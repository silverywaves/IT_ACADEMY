-- 01 select group by
use shopdb;
select * from buytbl;

-- userid 별 amount 의 총합(sum)
select userid, sum(amount) as '구매총량' from buytbl group by userid;	
-- userid 별 amount*price 의 총합(sum)
select userid, sum(amount*price) as '구매총액' from buytbl group by userid;

-- 평균(avg)
select userid, avg(amount) as '구매평균값' from buytbl group by userid;	
select userid, truncate(avg(amount*price),2) as '구매평균액' from buytbl group by userid;
-- truncate(값,소수점자리)

-- 가장 큰 값(max), 가작 작은 값(min)
select max(height) from usertbl;
select min(height) from usertbl;

-- 가장 큰 키를 가지는 user 의 모든 열의 값 확인
-- select * from usertbl where height=(가장 큰 키);
select * from usertbl where height=(select max(height) from usertbl);
-- 가장 작은 키를 가지는 user 의 모든 열의 값 확인
select * from usertbl where height=(select min(height) from usertbl);
-- 가장 큰 키와 가장 작은 키의 값만 확인
select * from usertbl where 
height=(select max(height) from usertbl)
or 
height=(select min(height) from usertbl);

-- Quiz
-- Q1. buytbl 에서 userid 별로 구매량(amount)의 합을 출력
select userid, sum(amount) from buytbl group by userid;
-- Q2. usertbl 에서 키의 평균값
select avg(height) from usertbl;		-- select  truncate(avg(height),2) from usertbl;
-- Q3. buy 테이블에서 최대 구매량과 최소 구매량을 userid 와 함께 출력
select userid,amount from buytbl where amount=(select max(amount) from buytbl)
or amount=(select min(amount) from buytbl);
-- Q4. buytbl 의 groupname 의 개수 출력
select count(groupname) from buytbl;
-- select * from buytbl where groupname is null ;
-- select * from buytbl where groupname is not null ;

-- classicmodels db 로 이동 후 작업
use classicmodels;
-- Q1. customers 테이블의 city 를 그룹으로 creditlimit 의 평균 구하기
select city,avg(creditlimit) from customers group by city;
-- Q2. orderdetails 테이블의 orderNumber를 그룹으로 quantityordered 총합 출력
select ordernumber,sum(quantityordered) from orderdetails group by ordernumber;
-- Q3. products 테이블의 productVendor 를 그룹으로 quantityinstock 총합 출력
select productvendor,sum(quantityinstock) from products group by productvendor;


-- 02 select group by + having
use shopdb;
-- 집계 결과 열에선 where 사용 불가. having 으로 사용
select userid, sum(amount) as '구매총량' from buytbl group by userid having sum(amount)>5;	-- o	
select userid, sum(amount) as '구매총량' from buytbl group by userid having '구매총량'>5;		-- x

select userid, truncate(avg(amount*price),2) as '구매평균액' 
from buytbl 
group by userid
having truncate(avg(amount*price),2)>50;


-- 03 select + group by + rollup : 전체총합, 부분합 (PK 무조건 포함)

select num,groupname,sum(price*amount) from buytbl group by groupname,num with rollup;
select *,sum(price*amount) from buytbl group by groupname,num with rollup;

select num,groupname,sum(price*amount) from buytbl group by groupname,num with rollup;		-- 그룹 기준 부분합&총합
select groupname,sum(price*amount) from buytbl group by groupname with rollup;				-- 그룹 기준 총합

select addr,avg(height) from usertbl group by addr;								-- 지역별 키의 평균
select addr,avg(height) from usertbl group by addr with rollup;					-- 전체 평균키
select userid,addr,avg(height) from usertbl group by addr,userid with rollup;	-- 메인그룹을 잘 선정해야함


-- Quiz
select * from buytbl;
-- Q1. prodname 별로 그룹화 한 뒤 userid/prodname/price*amount 순으로 출력될 수 있도록 설정
select userid,prodname,sum(price*amount) from buytbl group by prodname,userid;
-- Q2. 1번 명령어에서 price*amount 값이 1000 이상인 행만 출력
select userid,prodname,sum(price*amount) from buytbl group by prodname,userid having sum(price*amount)>=1000;
-- Q3. price 가격이 가장 큰 행과 작은 행의 userid, prodname, price 출력
select distinct userid,prodname,price from buytbl where price=(select max(price) from buytbl) or price=(select min(price) from buytbl);
-- Q4. 다음 행 중에 그룹네임이 있는 행만 출력
select * from buytbl having groupname!='null';			-- select * from buytbl where groupname is not null;
-- Q5. prodname 별로 총합 구하기(rollup 사용)
select prodname,sum(price*amount) from buytbl group by prodname with rollup;
select num,prodname,sum(price*amount) from buytbl group by prodname,num with rollup;

