-- -------------------------
-- TRANSACTION
-- -------------------------
-- 데이터베이스의 상태를 변환시키는 작업 단위
-- 예외 처리와 함께 사용됨
-- 동시에 수행되어야할 일련의 연산모음 (전부 적용 or 전부 취소)

-- ------------------------
-- 트랜잭션 성질
-- -------------------------
-- 원자성 : 연산이 모두 적용 or 모두 실행X 상태
-- 일관성 : 실행전 DB 에 이상이 없다면, 실행 후에도 이상X
-- 독립성, 격리성 : 실행 중, 다른 트랜잭션 영향X
-- 영속성, 지속성 : 성공적으로 수행되면 영구적으로 반영, 저장

insert into tbl_a values(5, 10, 11); 	-- auto commit false
insert into tbl_a values(1, 2, 3); 	-- auto commit false
update tbl_a set name = 123 where a=4; 	-- auto commit false


-- 
create table tbl_tx(
	no int primary key,
    name varchar(20),
    age int,
    gender char(1)
);
select * from tbl_tx;

insert into tbl_tx values(1,'aa', 55, 'w');	-- auto commit
insert into tbl_tx values(2,'bb', 44, 'M');	-- auto commit
-- DBMS 마다 방식 다름
-- oracle : DDL 문장 수행 후 자동으로 commit 수행 => 롤백해도 저장되어버림
-- SQL Server : DDL 문장 수행 후 자동으로 commit 수행x

start transaction;	-- auto commit  사라짐
	insert into tbl_tx values(3,'cc', 55, 'W');
	insert into tbl_tx values(4,'dd', 55, 'W');
	insert into tbl_tx values(5,'ee', 55, 'W');
	-- 바로 select 해보면 값이 추가된 것 처럼 보이지만 임시공간에 저장된 것으로, commit 전 rollback 하면 원상태로 돌아감
    rollback;	-- 전체 롤백:변경사항 취소, 이전 데이터 재저장 (중간에 commit 있으면 commit 직전까지)

start transaction;
	savepoint s1;
	insert into tbl_tx values(3,'cc', 55, 'W');
	insert into tbl_tx values(4,'dd', 55, 'W');
	savepoint s2;
	insert into tbl_tx values(5,'cc', 55, 'W');
	insert into tbl_tx values(6,'dd', 55, 'W');
	savepoint s3;
	insert into tbl_tx values(7,'cc', 55, 'W');
	insert into tbl_tx values(8,'dd', 55, 'W');
	rollback to s2;	-- s2 이전 시점으로 돌아감
-- delete from tbl_tx;	-- error : s2 does not exist  -> s2 정상 처리 된걸로 나오는데 에러뜸 -> 삭제 후 재시작하니 작동됨.

select * from tbl_tx;
delete from tbl_tx;
drop procedure Tx_test;
delimiter $$
create procedure Tx_test()
begin

	declare continue handler for SQLEXCEPTION		-- 고정언어 // SQLEXCEPTION : 예외정보 저장 -> handler : 예외정보 다룸
    begin
		show errors;
		rollback;
    end;
    
	start transaction;
		insert into tbl_tx values(1, 'dd', 55, 'M');	-- SQL
		insert into tbl_tx values(2, 'dd', 55, 'M');	-- SQL
		insert into tbl_tx values(2, 'dd', 55, 'M');	-- SQL
	commit;		-- 변경사항 적용
    
end $$
delimiter ;

call Tx_test();
select * from tbl_tx;