-- INSERT
use shopdb;
select * from tbl_buy_copy3;

-- 여러값 삽입
insert into tbl_buy_copy3 values
(8, 'aab', '운동화', '의류', 1000, 2),
(9, 'aac', '운동화', '의류', 1000, 2),
(10, 'aad', '운동화', '의류', 1000, 2),
(11, 'aae', '운동화', '의류', 1000, 2);

-- AUTO_INCREMENT(AI) : 자동증가
desc tbl_a;
insert into tbl_a(name) values('홍길동');
insert into tbl_a(name) values('남길동');
insert into tbl_a(name) values('서길동');
select * from tbl_a;	-- no 자동 카운딩되어있음
insert into tbl_a values(null, '김민수');

delete from tbl_a;		-- 데이터 모두 삭제했으나, 새로 insert 하면 5번 나옴
insert into tbl_a(name) values('홍길동');
select * from tbl_a;	

-- AI 초기화
delete from tbl_a;
alter table tbl_a auto_increment=0;
insert into tbl_a(name) values('홍길동');
select * from tbl_a;	


-- UPDATE

-- DELETE