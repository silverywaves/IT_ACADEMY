use shopdb;
-- -------------------
-- Trigger
-- -------------------
-- 테이블에 특정 명령어 수행시(입력, 수정, 삭제 등 DML 문) 자동으로 실행되는 코드
	-- 자동 실행 => 리턴값x, 매개변수x, 커밋x
-- "on" update cascade / on delete cascade <- 오라클에서는 delete 지원x 트리거로 대체
-- 무결성 유지 or 로그(작업내용) 저장


-- 01 After Trigger : 작업이 일어났을때 작동

drop table c_usertbl;
create table c_usertbl select * from usertbl;
select * from c_usertbl;
create table c_usertbl_bak like c_usertbl;		-- 백업임시테이블(구조복사)
select * from c_usertbl_bak;
alter table c_usertbl_bak add column type char(5);	-- 수정인지 삭제인지
alter table c_usertbl_bak add column U_D_date char(5);	
alter table c_usertbl_bak change column U_D_date U_D_date datetime; -- 삭입, 삭제 언제했는지
desc c_usertbl_bak;
select * from c_usertbl_bak;


delimiter $$
create trigger trg_c_usertbl_update
after update
on c_usertbl
for each row
begin
	insert into c_usertbl_bak values(
    old.userid,old.name,old.birthyear,old.addr,old.mobile1,old.mobile2,old.height,
    old.mDate,'수정',now()	-- 기존데이터 사용 = old.~	// 신규데이터 사용 = new.~
    );
end $$
delimiter ;

show triggers;
show create trigger trg_c_usertbl_update;

select * from c_usertbl;
select * from c_usertbl_bak;
update c_usertbl set name='바비' where userid='BBK';
update c_usertbl set addr='경남' where userid='EJW';


-- 02 삭제 트리거 	: 이벤트 발생 이전에 작동
delimiter $$
create trigger trg_c_usertbl_delete
after delete
on c_usertbl
for each row
begin
	insert into c_usertbl_bak values(
    old.userid,old.name,old.birthyear,old.addr,old.mobile1,old.mobile2,old.height,
    old.mDate,'삭제',now()
    );
end $$
delimiter ;

select * from c_usertbl;
delete from c_usertbl where userid='KKH';
select * from c_usertbl_bak;

-- buytbl의 c_buytbl의 구조+값복사
-- c_buytbl의 구조만 복사한 c_buytbl_bak 만들기
-- c_buytbl_bak 에 type char(5)와 mDate datetime 을 열로 추가
-- c_buytbl의 update시 c_buytbl_bak에 내용저장되는 trg_c_buytbl_update 트리거 만들기
-- c_buytbl의 delete시 c_buytbl_bak에 내용저장되는 trg_c_buytbl_delete 트리거 만들기