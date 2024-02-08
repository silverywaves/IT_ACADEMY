-- ----------------------------
-- Stored Procedure
-- ----------------------------
-- 데이터베이스에서 실행가능한 저장프로그램
	-- 주로 DML을 사용해 주기적으로 진행해야되는 작업 저장
-- SQL문들의 논리적인 묶음
-- Function(함수)와 유사하나 특정부분에서의 차이점 존재
-- Function(함수) : 수를 받아서 처리하는 논리적 공간		// 수 : Data / 선저장 후처리

-- ----------------------------
-- function 과의 공통점
-- ----------------------------
-- 01. 재사용성
-- 02. 모듈화
-- 03. 매개변수의 존재
-- 04. 흐름제어 처리(if, case, while 사용 가능)
-- 05. 트랜잭션 처리
-- 06. 커서사용
-- 07. 반환값 존재
-- 08/ 동적 SQL문 실행 가능(prepare = execute)

-- ----------------------------
-- function 과의 차이점
-- ----------------------------
-- 반환값
	-- 프로시저에서는 반환값이 필수 X
	-- 함수에서는 항상 값을 반환

-- 허용되는 문맥
	-- 프로시저는 SELECT, INSERT, UPDATE, DELETE 문과 같은 SQL문 내에서 직접 호출 가능
    -- 함수는 주로 SELECT 문이나 WHERE 절에서 호출되어 사용, SQL문에서 직접 호출되는 경우가 적음

-- 트랜잭션
	-- 프로시저 : 트랜잭션 내에서 여러 SQL문 실행 가능
    -- 함수 : 주로 읽기 전용 작업에 사용, 트랜잭션에서 변경 사항을 가지지 않도록 설계

-- 예외처리
	-- 프로시저 : 프로시저 내에서 예외처리 가능
    -- 함수 : 예외처리가 가능하지만 주로  SELECT 문을 사용하기 때문에(조회) 예외처리를 적용하는 경우가 적음
    
-- ----------------------------
-- 예제 01
-- ----------------------------
delimiter $$
create procedure pro1()
begin 				-- 작업영역 생성
	-- 변수 선언
    declare var1 int;
    -- 초기값 삽입
    set var1 = 100;
    -- if문(조건절)
	if var1 = 100 
		then
			select 'var1 은 100 입니다';
        else
			select 'var1 은 100 이 아닙니다';
	end if;
end $$
delimiter ;

show procedure status where db='shopdb';

call pro1();		-- call 프로시저명(파라미터); : 실행	<->	drop procedure 프로시저명 : 삭제 

-- ---------------------------
-- 예제 02. 파라미터
-- ----------------------------
delimiter $$
create procedure pro2(in param int)
begin 
    -- if문(조건절)
	if param = 100 
		then
			select param, ' 은 100 입니다';
        else
			select param, ' 은 100 이 아닙니다';
	end if;
end $$
delimiter ;

call pro2(105);
call pro2(100);
call pro2(99);


-- ---------------------------
-- 예제 03. 테이블 적용
-- ----------------------------
delimiter $$
create procedure pro3(in amt int)
begin 
	select * from buytbl where amount>=amt;
end $$
delimiter ;

call pro3(4);
call pro3(6);

delimiter $$
create procedure pro4(in amt int, in isGt int)
begin 
	if isGt != 0
		then
			select * from buytbl where amount>=amt;
		else
			select * from buytbl where amount<amt;
	end if;
end $$
delimiter ;

call pro4(4,0);
call pro4(4,1);
call pro4(4,-1);	-- 0 제외 모두 참
call pro4(4,4);


drop procedure pro5;
delimiter $$
create procedure pro5()
begin 
	declare avg_total_price double;
    set avg_total_price = (select avg(amount*price) from buytbl);
--    select avg_total_price;
    select *, price * amount, if(price*amount>=@avr, '평균이상', '평균이하') as '평균이상/이하' from buytbl;
end $$
delimiter ;

call pro5();
select avg(amount*price) from buytbl;

set @avr=(select avg(amount * price) from buytbl);
select @avr;
select *, price * amount, if(price*amount>=@avr, '평균이상', '평균이하') as '평균이상/이하' from buytbl;
(select avg(amount * price) from buytbl);	-- 평균


-- 문제
-- usertbl에서 출생년도를 입력받아 해당 출샌년도보다 나이가 많은 행만 출력
-- birthyear 열을 이용
-- 프로시저명 : older (IN param int)
select * from usertbl;

delimiter $$
create procedure older(in param  int)
begin
	select * from usertbl where birthyear<param;
end $$
delimiter ;

call older(1970);

-- 문제
-- 근태일, 가입일로부터 지난일 구하기(usertbl)
-- 가입일로부터 지난 날짜 확인(테이블 조회시 열하나 추가)
-- select curdate();	-- 현재 날짜(YYYY-MM-DD)
-- select now();		-- 현재 날짜시간
-- select curtime();	-- 현재 시간
-- select *, ceil(datediff(curdate(), mDate)/365) from usertbl;
select * from usertbl;

delimiter $$
create procedure tmp()
begin
	select *, ceil(datediff(curdate(), mDate)/365) as '근속년수' from usertbl;
end $$
delimiter ;

call tmp();

delimiter $$
create procedure tmp2()
begin
	select *, ceil(datediff(curdate(), mDate)) as '근속일수' from usertbl;
end $$
delimiter ;

call tmp2();



--	----------------------
-- 인자 2개
--	----------------------
delimiter $$
create procedure pro6(in arg1 int, in arg2 int)
begin
	select * from usertbl where height between arg1 and arg2;
end $$;
delimiter ;

call pro6(170, 180);



select 
*, 
case 
	when amount>=10 then 'VIP'
    when amount>=5 then '우수'
    when amount>=1 then '일반'
    else '구매없음'
end as 'GRADE'
from buytbl;


delimiter $$
create procedure pro7(in arg1 int, in arg2 int, in arg3 int)
	-- Q.파라미터 몇개까지 추가 가능할까? A.메모리공간이 남아있는한 제한없음. 단 반환값은 하나.(object 사용시 여려개 가능)
begin
	select 
	*, 
	case 
		when amount>=arg1 then 'VIP'
		when amount>=arg2 then '우수'
		when amount>=arg3 then '일반'
		else '구매없음'
	end as 'GRADE'
	from buytbl;	
end $$;
delimiter ;

call pro7(5,3,1);


--	----------------------
-- 프로시저 + 반복문	// 흐름제어 - 선행 : 조건문 (분기-if or 반복-while)
--	----------------------

-- Hello world 를 10회 반복	-> 1.반복탈출용 변수선언 2.반복탈출을 위한 연산작업 3.반복 조건식
--  while 조건식 do 
-- 		종속문장
-- 	end while;

delimiter $$
create procedure proc_while_01()
begin
    declare i int;
    set i = 1;
	while i<=10 do
		select "Hello World";
        set i = i+1;
	end while;
end $$;
delimiter ;

call proc_while_01();


delimiter $$
create procedure proc_while_02(in n int)
begin
    declare i int;
    set i = 1;
	while i<=n do
		select "Hello World";
        set i = i+1;
	end while;
end $$;
delimiter ;

call proc_while_02(3);


-- 1-10 합
drop procedure proc_while_03;
delimiter $$
create procedure proc_while_03()
begin
	declare i int;
    declare sum int;
    set i = 1;
    set sum = 0;
    
    while i<=10 do
        set sum = sum + i;
		set i = i + 1;
	end while;
    select sum;
end $$;
delimiter ;

call proc_while_03();

-- 1-N 합
delimiter $$
create procedure proc_while_04(in n int)
begin
	declare i int;
    declare sum int;
    set i = 1;
    set sum = 0;
    
    while i <= n do
		set sum = sum + i;
        set i = i + 1;
	end while;
    select sum;
end $$;
delimiter ;

call proc_while_04(10);

-- N-M 합 (N < M)
delimiter $$
create procedure proc_while_05(in n int, in m int)
begin
    declare sum int;
    set sum = 0;
    
    if n < m
		then while n<=m do
				set sum = sum + n;
                set n = n + 1;
			end while;
	end if;
	select sum;
end $$;
delimiter ;


call proc_while_05(2,5);
drop procedure proc_while_05;

-- 구구단 2단 출력
delimiter $$
create procedure proc_while_06()
begin
	declare i int;
    declare n int;
    declare r int;
    set i = 1;
    set n = 2;
	set r = 0;
    
    while i<=9 do
		set r = n * i;
        		select r;
        set i = i + 1;
	end while;
end $$;
delimiter ;

drop procedure proc_while_06;
call proc_while_06;

-- 구구단 N단 출력 (N<=9)
delimiter $$
create procedure proc_while_07(in n int)
begin
	declare i int;
    declare r int;
    set i = 1;
	set r = 0;
    
    if n<=9
		then while i<=9 do
			set r = n * i;
					select r;
			set i = i + 1;
		end while;
	end if;
end $$;
delimiter ;

drop procedure proc_while_07;
call proc_while_07(3);



