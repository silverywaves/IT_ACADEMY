-- 00 확인	(--띄어쓰기 : 주석)
use shopdb;
show tables;
select * from usertbl;
select * from buytbl;
desc usertbl;
desc buytbl;

-- 01 Select
select * from usertbl;
select userid, birthyear from usertbl;							-- 열이름 대소문자 구분x
select userid as '아이디', birthyear as '생년월일' from usertbl;	-- as '': 별칭 등록
select 
userid as '아이디', birthyear as '생년월일', concat(mobile1, '-', mobile2) as '연락처'
from usertbl;

-- 02 Select where (조건절 - 비교연산자)
select * from usertbl where name = '김경호';		-- 동등 비교 연산자(=)
select * from usertbl where userid = 'LSG';
select * from usertbl where birthyear >=1970;	-- 대소 비교 연산자
select * from usertbl where height <=170;

-- 03 select where (조건절 - 논리연산자)
select * from usertbl where birthyear >= 1970 and height >= 180;	-- and 연산자 (참 and 참)을 만족하는 경우
select * from usertbl where birthyear >= 1970 or height >= 180;		-- or 연산자 ([참 or 거짓], [거짓 or 참], [참 or 참])을 만족하는 경우

select * from usertbl where height >= 170 and height <= 180;
select * from usertbl where height between 170 and 180;

-- 04 in(포함문자열 - 완성된 문자열), like(포함문자열 - 미완선된 문자열 필터링)
select * from usertbl where addr in ('서울', '경남');
select * from usertbl where addr='경남' or addr='서울';

select * from usertbl where name='김범수';
select * from usertbl where name like '김%';			-- % 길이제한 없는 모든 문자
select * from usertbl where name like '%수';
select * from usertbl where name like '%경%';
select * from usertbl where name like '김__';		-- _ 개수만큼의 길이제한이 있는 모든 문자

-- Quiz buytbl
select * from buytbl;
-- Q1. 구매양이 5개 이상
select * from buytbl where amount >= 5;
-- Q2. 가격이 50 이상 500 이하 userid, prodname만 출력
select userid, prodname from buytbl where price between 50 and 500;
-- Q3. 구매양 10 이상 or 가격 100 이상
select * from buytbl where amount >= 10 or price >= 100;
-- Q4. userid가 k로 시작
select * from buytbl where userID like 'K%';
-- Q5. 서적이거나 전자
select * from buytbl where groupName='서적' or groupName='전자';
select * from buytbl where groupName in('서적', '전자');
-- Q6. 상품이 책이거나 userid 가 w로 끝남
select * from buytbl where prodname='책' or userID like '%w';
-- Q7. groupname 이 비어있지 않은 행만 출력 (!=, <>)
select * from buytbl where groupname!='null';
select * from buytbl where groupname<>'null';

-- 04. Select 조건절 - 서브쿼리

-- 김경호보다 큰 키를 가지는 모든 열의 값
select height from usertbl where name='김경호';	-- 김경호의 키
-- select * from usertbl where height>(김경호의 키);	
select * from usertbl where height >(select height from usertbl where name='김경호'); 

-- 성시경보다 나이가 많은(birthyear)가 많은 모든 열의 값
select birthyear from usertbl where name='성시경';
select * from usertbl where birthyear<(select birthyear from usertbl where name='성시경');

-- 지역이 '경남'인 height 보다 큰 행 출력
select height from usertbl where addr='경남';
-- select * from usertbl where height>(select height from usertbl where addr in('경남'));	// Error : Subquery returns mor than 1 row
-- all(모든 조건을 만족하는)
select * from usertbl where height>all(select height from usertbl where addr in('경남'));
-- any(어느 조건이든 하나 이상 만족)
select * from usertbl where height>any(select height from usertbl where addr in('경남'));

-- 예약어 : 미리 시스템 내에서 지정되어있는 문법, 단어

-- Quiz buytbl
select * from buytbl;
-- Q1. amount가 10인 행의 price 보다 큰 행 (서브쿼리)
select price from buytbl where amount=10;
select * from buytbl where price>(select price from buytbl where amount=10);
-- Q2. userID 가 K로 시작하는 행의 amount 보다 큰 행 (서브쿼리+any)
select amount from buytbl where userID like 'K%';
select * from buytbl where amount>any(select amount from buytbl where userid like 'K%');
-- Q3. amount 가 5인 행의 price 보다 큰 행 (서브쿼리+all)
select price from buytbl where amount=5;
select * from buytbl where price>all(select price from buytbl where amount=5);


-- 05 Select Order by	: 정렬
use shopdb;
select * from usertbl;		-- 보통 primary key 오름차순 기준으로 정렬되어있음
select * from usertbl order by mDate asc;		-- asc 오름차순 정렬 (기본값)
select * from usertbl order by mDate desc;		-- desc 내림차순 정렬
select * from usertbl where birthyear>=1970 order by mdate;		-- order by 는 where 보다 나중에 사용
select * from usertbl order by height,name;		-- , : 같은 값 대상으로 2차 정렬 가능

-- 06 distinct		: 중복되는 값들을 하나로 묶음
select distinct addr from usertbl;			-- 단일열 앞에 distinct 사용
select distinct addr,userid from usertbl;	-- userid 가 각 달라서 distinct가 의미없음

-- 07 limit
select * from usertbl;
select * from usertbl limit 3;		-- 0번 인덱스부터 3개 출력
select * from usertbl limit 2,3;	-- 2번 인덱스부터 3개 출력

-- 08 테이블 복사
-- 08-01 구조 + 값 복사(PK,FK 복사 X)
create table tbl_buy_copy(select * from buytbl);
select * from tbl_buy_copy;		
desc tbl_buy_copy;				-- 키열 공란 확인
desc buytbl;

create table tbl_buy_copy2(select userid,prodname,amount from buytbl);
select * from tbl_buy_copy2;

-- 08-02 구조만 복사(값x, pk 복사 O, FK 복사 x, index 설정 O)
create table tbl_buy_copy3 like buytbl;
select * from tbl_buy_copy3;

-- 08-03 데이터만 복사
insert into tbl_buy_copy3 select * from buytbl where amount>=3;
select * from tbl_buy_copy3;


-- Quiz
-- Q1. userId 순으로 오름차순 정렬
select * from buytbl order by userid asc;
-- Q2. price 순으로 내림차순 정렬
select * from buytbl order by price desc;
-- Q3. amount 순으로 오름차순 prodName 순으로 내림차순 정렬
select * from buytbl order by amount, prodname desc;
-- Q4. prodName 을 오름차순으로 정렬시 중복 제거
select distinct prodname from buytbl order by prodname asc;
-- Q5. userId 열의 검색시 중복된 아이디 제거하고 select
select distinct userid from buytbl;
-- Q6. 구매양(amount)가 3 이상인 행을 prodName 내림차순으로 정렬
select * from buytbl where amount>=3 order by prodname desc;
-- Q7. usertbl 의 addr 가 서울, 경기인 값들을 CUsertbl 에 복사
-- create table CUsertbl like usertbl;
-- insert into CUsertbl select * from usertbl where addr in('서울','경기');
create table cusertbl(select * from usertbl where addr in('서울','경기'));
select * from cusertbl;



