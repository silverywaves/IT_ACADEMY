-- 제약조건
-- -------------------------------------------------------------------

-- PK	: unique, not null		/ PRI

-- PK 설정 1 : 생성함과 동시에 설정
create table tbl_a(
	id int primary key, 
    name varchar(45)
);
desc tbl_a;
insert into tbl_a values(2,'홍길동');
insert into tbl_a values(1,'홍길동');
select * from tbl_a;

-- PK 설정 2 : 생성함과 동시에 설정
create table tbl_b(
	id int,
    name varchar(45) not null,
    primary key(id)
);
desc tbl_b;

create table tbl_c(
	id int,
    name varchar(45) not null,
    primary key(id,name)		-- 여러개 묶을수도 있음
);
desc tbl_c;

select * from information_schema.columns where table_schema='shopdb' and column_key='PRI';

-- 설정방법3 : 테이블 생성 후 설정
-- alter table tbl_d add constraint PK명 primary key();
create table tbl_d(
	id int,
    name varchar(45) not null
);
desc tbl_d;
alter table tbl_d add constraint PK_tbl_d primary key(id, name);

-- -------------------------------------------------------------------

-- PK 삭제
alter table tbl_d drop primary key;
desc tbl_d;

-- -------------------------------------------------------------------

-- Quiz
-- Q1. buytbl을 buytbl_copy 로 구조+데이터 복사(create table+select 이용)하고 num을 primary key로 설정
create table buytbl_copy(select * from buytbl);
alter table buytbl_copy add constraint PK_buytbl_copy primary key(num);
desc buytbl_copy;

-- -------------------------------------------------------------------

-- FK		/ MUL

-- FK 설정1 : 생성과 동시에 설정
create table tbl_a(
	id int primary key, 	-- 타입 int
    name varchar(45)
);
desc tbl_a;

create table tbl_b(
	num int primary key,
    tbl_a_id int, 			-- tbl_a 에서 타입 int 였음. 맞춰주기
    name varchar(45), 
    -- constraint 외래키명 foreign key(외래키열명) references tbl_a(기본키열명)
    constraint Fk_tbl_a_tbl_b foreign key(tbl_a_id) references tbl_a(id)
);
desc tbl_b;

-- FK Options
-- RESTRICT		: PK, FK 열의 값의 변경 차단 -> PK도 FK도 변경할 수 없음
-- CASCADE		: PK열의 값 on Update, on Delete 이 변경시 FK 열의 값도 함께 변경
-- SET NULL		: PK열의 값이 변경시 FK 열의 값을 NULL로 설정
-- SET DEFAULT	: PK열의 값이 변경시 FK 열의 값은 Default로 성정된 기본값을 적용
-- NO ACTION	: PK열의 값이 변경시 FK 열의 값은 변경되지 않음으로 설정


-- FK 설정 with Option : 생성과 동시 설정
create table tbl_c(
	num int primary key,
    tbl_a_id int, 
    name varchar(45), 
    -- constraint 외래키명 foreign key(외래키열명) references tbl_a(기본키열명)
    constraint Fk_tbl_a_tbl_c foreign key(tbl_a_id) references tbl_a(id)
	on update cascade
    on delete set null
);
desc tbl_c;

-- FK 설정2 : 생성 후 설정
-- FK 설정시 자동으로 해당열이 index열로 지정
create table tbl_c_2(
	num int primary key,
    tbl_a_id int, 
    name varchar(45)
);
desc tbl_c_2;
alter table tbl_c_2 add constraint FK_tbl_a_tbl_c_2 foreign key(tbl_a_id) references tbl_a(id)
on update cascade on delete cascade;
desc tbl_c_2;

-- -------------------------------------------------------------------

-- Quiz
-- Q1. buytbl 을 copy_buytbl로 구조 + 데이터 복사 이후
create table copy_buytbl(select * from buytbl);
desc copy_buytbl;
-- Q2. num 을 PK 설정
alter table copy_buytbl add constraint Pk_copy_buytbl primary key(num);
-- Q3. userid 를 FK 설정 (on delete restrict on update cascade)
alter table copy_buytbl add constraint Fk_copy_buytbl foreign key(userid) references usertbl(userid)
on delete restrict on update cascade;

-- -------------------------------------------------------------------

-- UNIQUE (중복허용x, NULL o) - Email 등록		/ UNI
-- UNIQUE 설정1 : 생성과 동시에 설정
create table tbl_a(
	id int primary key,
    name varchar(45),
    email varchar(100) unique
);
create table tbl_b(
	id int primary key,
    name varchar(45),
    email varchar(100),
    constraint uk_email unique(email)
);

-- UNIQUE 설정2 : 생성 후 설정
create table tbl_c(
	id int primary key,
    name varchar(45),
    email varchar(100)
);
desc tbl_c;
alter table tbl_c add constraint uk_tbl_c_email unique(email);
desc tbl_c;

-- -------------------------------------------------------------------

-- 삭제
alter table tbl_c drop constraint uk_tbl_c_email;
desc tbl_c;

-- -------------------------------------------------------------------

-- CHECK : 들어오는 값을 제어
create table tbl_d(
	id int primary key,
    name varchar(50),
    age int check(age>=20 and age<=50),
    addr varchar(5), 
    constraint CK_ADDR check(addr in('대구', '부산', '대전'))
);
desc tbl_d;

select * from information_schema.check_constraints;

-- -------------------------------------------------------------------

-- 삭제
alter table tbl_d drop check CK_ADDR;
select * from information_schema.check_constraints;
alter table tbl_d drop check tbl_d_chk_1;

-- -------------------------------------------------------------------

-- DEFAULT
create table tbl_e(
	id int primary key,
    name varchar(45) default '이름없음',
    addr varchar(100)
);
desc tbl_e;
insert into tbl_e values(1, '홍길동', null);
select * from tbl_e;
insert into tbl_e(id) values(2);
select * from tbl_e;

alter table tbl_e alter column addr set default '대구';
alter table tbl_e alter column addr drop default;

