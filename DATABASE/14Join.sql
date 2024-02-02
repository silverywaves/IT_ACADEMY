use testdb;
-- ----------------------------------------------------------
-- JOIN
-- ----------------------------------------------------------
-- 두 개 이상의 테이블을 서로 묶어서 하나의 조회결과를 만드는데 사용

-- ----------------------------------------------------------
-- JOIN 종류
-- ----------------------------------------------------------
-- INNER JOIN : on 이하의 조건절을 만족하는 행만 JOIN
-- OUTER JOIN : on 이하의 조건절을 만족하지 않는 행도 JOIN
	-- LEFT OUTER JOIN	: 조건을 만족하지 않는 왼쪽테이블의 행도 JOIN
    -- RIGHT OUTER JOIN : 조건을 만족하지 않는 오른쪽테이블의 행도 JOIN
	-- FULL OUTER JOIN	: 조건을 만족하지 않는 왼/오른쪽 테이블의 행도 JOIN
-- CROSS JOIN : 한쪽테이블 모든행과 반대쪽테이블의 모든 행을 JOIN, 조건절 X
-- SELF JOIN  : 한테이블 내에서 JOIN


-- INNER JOIN 기본
use shopdb;
select * from usertbl;
select * from buytbl;

select * 
from usertbl 
inner join buytbl
on usertbl.userid=buytbl.userid;

-- INNER JOIN 원하는 열만 출력(열이름 중복시 특정테이블의 열이름으로 선택해서 지정)
select usertbl.userid,name, addr, mobile1,mobile2,prodname,price,amount
from usertbl 
inner join buytbl
on usertbl.userid=buytbl.userid;

-- INNER JOIN (별칭 지정)
select U.userid,name, addr, mobile1,mobile2,prodname,price,amount
from usertbl U
inner join buytbl B
on U.userid=B.userid;

-- WHERE 조건절 적용
select U.userid,name, addr, mobile1,mobile2,prodname,price,amount
from usertbl U
inner join buytbl B
on U.userid=B.userid
where amount<=5;


-- QUIZ
-- Q. 바비킴의 userID, birthYear, prodName, GroupName 출력
select U.userId, birthYear, prodName, groupName 
from usertbl U inner join buytbl B 
on U.userid=B.userid 
where U.name='바비킴';

-- Q. amount*price 값이 100 이상인 행의 name, addr, prodname, mobile1- mobile2를 (concat()함수 사용) 출력
select name, addr, prodname, concat(mobile1,'-',mobile2) as 'phone'
from usertbl U inner join buytbl B 
on U.userid=B.userid 
where amount*price>=100;

-- Q. groupname 이 전자인 행의 userid, name, bitrhyear, prodname 출력
select U.userid, name, birthyear, prodname 
from usertbl U inner join buytbl B 
on U.userid=B.userid 
where groupname='전자';


-- OUTER JOIN

-- LEFT OUTER JOIN(on 조건을 만족하지 않는 left 테이블의 행도 출력)
select *
from usertbl U					-- left 테이블
inner join buytbl B				-- right 테이블
on U.userid=B.userid;

select *
from usertbl U			
left outer join buytbl B				
on U.userid=B.userid;

-- RIGHT OUTER JOIN(on 조건을 만족하지 않는 right 테이블의 행도 출력)
select *
from buytbl B			
right outer join usertbl U				
on U.userid=B.userid;

-- FULL OUTER JOIN(on 조건을 ㅁ나족하지 않는 left, right 테이블의 행도 출력)
-- mysql 에서는 full outer join 을 지원하지 않음
-- 대신 union 을 사용해서 left, right outer join 을 연결
select * from usertbl U	left outer join buytbl B on U.userid=B.userid
union
select * from usertbl U	right outer join buytbl B on U.userid=B.userid;

-- 여러 테이블들 JOIN
use classicmodels;

-- INNER JOIN
select p.productCode, productname, quantityOrdered, priceEach, orderDate, O.status
from orderdetails OD
inner join products P
on P.productCode=OD.productCode
inner join orders O
on O.orderNumber=OD.orderNumber;

-- RIGHT OUTER JOIN
select p.productCode, productname, quantityOrdered, priceEach, orderDate, O.status
from orderdetails OD
right outer join products P
on P.productCode=OD.productCode
right outer join orders O
on O.orderNumber=OD.orderNumber;
