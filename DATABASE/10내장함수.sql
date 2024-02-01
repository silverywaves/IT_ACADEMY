-- 내장함수 https://velog.io/@wngud4950/MySQL-%EB%82%B4%EC%9E%A5%ED%95%A8%EC%88%98-%EC%A0%95%EB%A6%AC
-- ------------------------------------------------------------------
-- Concat(), concat_ws() : 두 개 이상의 문자열 결합
select concat('hello', '-', 'world',5,6);
select concat_ws("-",'hello', ' ', 'world',5,6);	-- 구분자 추가 가능

-- SubString() : 문자열 일부 추출
select "HELLO WORLD";
select substring("HELLO WORLD",6);	-- 6 index ~ 마지막 문자	// 공백도 문자!
select substring("HELLO WORLD",1,6);	-- 1 index ~ 6개 문자 (index 1부터 시작함)

-- SubString_index() : 찾는 문자열이 n회 등장하면 그 이후 문자열을 버림
select substring_index("HELLO MY NAME IS JUNG"," ", 3);	
select userId,subString_index(mDate,'-',2) as '가입연월' from usertbl;

-- length() : 문자열 길이
select length("Hello World");
select * from classicmodels.employees;
select length(lastname) from classicmodels.employees;

-- LOWER() : 대문자->소문자	  //  UPPER() : 소문자->대문자
select lower('Hello World');
select upper('Hello World');

-- TRIM() : 문자열 앞/뒤/양쪽 문자열 제거
select "   HELLO WORLD   ";
select trim("   HELLO WORLD   "); 				-- 앞뒤 공백 제거
select trim(both "a" from "aaaabcbbbaaa"); 		-- 앞/뒤
select trim(trailing "a" from "aaaabcbbbaaa"); 	-- 뒤
select trim(leading "a" from "aaaabcbbbaaa");  	-- 앞

-- Replace(str, old_str, new_str) : 문자열에서 old_str -> new_str 대체
select replace(curdate(),'-','#') as '날짜';

-- instr(str, substr) : 문자열에서 substr 위치 반환
select instr('HELLO WORLD', 'WORLD') as 'WORLD';

-- lpad, rpad(str, len, pad_str) : 문자열을 왼쪽, 오른쪽으로 패딩
select lpad("hello world",15,"0");
select rpad("hello world",15,"0");

-- left, right(str, len) : 문자열에서 왼쪽, 오른쪽에서 길이만큼 추출
select left("hello world",3);
select right("hello world",3);

-- mid(str, pos, len) : 문자열에서 특정 시작점에서의 길이만큼 추출
select mid("hello world",2,2);

-- bin, oct, hex : 각각 2진수, 8진수, 16진수 반환
select bin(1);
select bin(2);
select bin(3);
select bin(4);
select bin(5);
select bin(6);
select bin(7);
select bin(8);
select bin(9);
select bin(10);
select bin(11);
select bin(12);
select bin(13);
select bin(14);
select bin(15);

-- reverse : 문자열 거꾸로 반환
select reverse("hello world");

-- space(len) : 길이만큼 공백
select concat("hello", space(5), "world");

-- repeat(str, len) : 문자열 주어진 횟수만큼 반복
select repeat("hello world", 3);

-- locate(sbustr, str, [pos]) : 첫번째로 발견한 문자열 위치 반환
select locate("wor", "hello world hello world", 5);
select locate("wor", "hello world hello world", 8);

-- format

-- 날짜관련 함수 생략
 select year(mdate) from usertbl;
 select month(mdate) from usertbl;
 select day(mdate) from usertbl;

select now();
select date(now());
select curdate();
select time(now());
select curtime();

-- Q1. 현재 날짜 시간에서 연, 월, 일, 시, 분, 초를 각각 추출해내고 다음과 같은 포맷팅으로 출력
-- YYYY#MM#DD-HH|mm|ss
select now();
select replace(curdate(),'-','#');
select replace(curtime(),':','|');
select concat(replace(curdate(),'-','#') , " " , replace(curtime(),':','|'));

