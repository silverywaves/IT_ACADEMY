-- --------------------------------------
-- VIEW
-- --------------------------------------
-- 사용자에게 접근이 허용된 자료만을 제한적으로 보여주기 위한 가상테이블
-- 보통 읽기전용으로 사용

use shopdb;
select * from usertbl;
select * from buytbl;

create or replace view view_usertbl
as
select userid, name, concat(mobile1, '-', mobile2) as phone
from usertbl;

select * from view_usertbl;


create or replace view view_usertbl_2
as
select userid, name, concat(mobile1, '-', mobile2) as phone
from usertbl
where addr in('서울', '경기', '경남');

select * from view_usertbl_2;
show tables;
select * from information_schema.views where table_schema='shopdb';

create or replace view view_user_buytbl
as
select U.userid, addr, concat(mobile1, '-', mobile2) as phone, prodname, amount
from usertbl U
inner join buytbl B
on U.userid=B.userid;

select * from view_user_buytbl;
select * from view_user_buytbl where amount>=5;
desc usertbl;

create view view_test
as
select userid, name, birthyear, addr, height from usertbl;

select * from view_test;
insert into view_test value('aaa', '에이', 1999, '경기', 188);
select * from usertbl;

create table tbl_a(
	col1 int primary key,
    col2 int
);

create table tbl_b(
	col3 int primary key,
    col4 int
);

create or replace view view_a_b
as
select *
from tbl_a
inner join tbl_b;

select * from view_a_b;

-- insert into view_a_b(col1, col2, col3, col4) value(1,1,1,1);


-- classicmodels 에서 products, orderdetails, orders 에 대한 관계도를 확인해서
-- 열 항목이 productname, productvendor, quantityordered, priceeach, orderdate 가 포함된
-- view_product_order 을 만들기	// inner join 작업
-- quantityOrdered 가 25 이상인 값만 포함

use classicmodels;
select * from products;
select * from orderdetails;
select * from orders;

create or replace view view_product_order
as
select productname, productvendor, quantityordered, priceeach, orderdate
from orderdetails D
inner join products P
on D.productcode=P.productcode
inner join orders O
on D.ordernumber=O.ordernumber
where quantityordered >= 25;

select * from view_product_order;





