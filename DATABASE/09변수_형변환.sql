-- 01 변수
-- 변하는 수
-- 수(Data, 자료)는 기본 선저장, 후처리를 원칙으로 함
-- 저장된 수가 특정상황에 있어 바뀔 가능성이 있는 경우 이 수를 변수라고 함

use shopdb;
set @var1 = 5;
set @var2 = 4.56;
set @var3 = '가수이름=>';

select @var1;			-- 아웃풋 용도로도 사용가능
select @var2;
select @var3;
select @var1+@var2;		-- 자료형(종류&공간제한) 상이 -> 형변환(데이터 손실 최소화 위함) 후 연산 / 정수 + 실수 -> 실수 + 실수 -> 실수 

select @var3 as 'TITLE',name,addr from usertbl;

-- LIMIT 에서 변수 사용
set @rowcnt = 5;
-- select * from usertbl order by height limit @rowcnt;		에러

prepare sqlQuery01
from 'select * from usertbl order by height limit ?';	-- 변수가 들어갈 예정 공간 먼저 지정

execute sqlQuery01 using @rowcnt;


-- ------------------------------------------------------------------
-- 형변환
-- ------------------------------------------------------------------
-- 연산 작업시(ex. 대입연산, 비교연산...) 자료형(Data Type) 불일치시 일치시키는 작업
-- 자동형변환(암시적형변환) : 시스템에 의한 형변환(데이터 손실을 최소화 방향)
-- 강제형번환(명시적형변환) : 프로그래머에 의한 형변환(프로그램 제작 목적에 따름 => 데이터 손실 우려 비교적 큼)

select mdate from usertbl;
select cast('2024$01$01' as date);	-- 문자형[char('')] -> 날짜형-구분자 상관x
select cast('2024@01@01' as date);

select num,price*amount from buytbl;
select 
num, 
concat(cast(price as char(10)),'x', cast(amount as char(10))) as '가격x수량' ,
price*amount as '결과값'
from buytbl;	

-- 암시적 형변환
select 100 + 200;
select '100' + 200;			-- 문자열 + 숫자 : 문자열 안에 순수한 숫자만 있으면 자동으로 파싱
select '100' + '200';
select 'a100' + '200';		-- 문자열 안에 문자와 숫자가 함께 들어가는 경우 : 문자가 앞에 나와서 숫자로 해석을 못함 => 값이 비워져 0
select 'a100' * 1;
select '10a0' + 200 + 300;	-- 문자가 나온 이후로 해석x->버림

-- 숫자 비교 연산
select 1 > 2;					-- 결과값 : 참(1) / 거짓(0)
select 2 > '1';					-- 연산 전 자료형 일치시켜야함 => 형변환 적용
select 0 = 'mega';				-- 0 = 0(문자)


-- Qiuz
-- Q1. userTbl 의 평균키 (cast 이용, 평균키 정수형으로 형변환)
select cast(avg(height) as signed integer) from usertbl;	-- 175.8 인데 176으로 출력 => 반올림이 디폴트

-- Q2. '2020년 5월 7일' 문자열을 DATE 자료형으로 변환(ex.2020-05-07)
select cast('2020년5월7일' as date);

