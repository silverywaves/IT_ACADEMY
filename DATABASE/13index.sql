-- ----------------------------------------------------------
-- INDEX
-- ----------------------------------------------------------
-- 데이터 베이스 테이블의 검색 성능(속도)을 향상시키기 위해 사용되는 데이터 구조
-- where 이하 조건절열에 index로 지정된 열을 사용
-- index 로 지정된 열은 기본적으로 정렬 처리가 도미 (모든 DBMS는 아님)

-- ----------------------------------------------------------
-- MYSQL INDEX 검색 알고리즘 종류
-- ----------------------------------------------------------
-- B-Tree : 기본값, 대부분의 데이터 index에 잘 적용되어 사용
-- Hash : 해시 함수를 이용한 index, 정확한 일치 검색에 사용(포함검색에는 다소 성능이 저하될 수 있음)
-- Full-text : 전체 텍스트 검색에 사용되는 index, 텍스트 검색기능 향상시 유리
-- Spatial : 공간데이터(위도/경도 등을 담는 지도데이터)을 처리하기 위한 index, 지리 정보 검색에 유리

-- ----------------------------------------------------------
-- MYSQL INDEX TYPE
-- ----------------------------------------------------------
-- 클러스터형 인덱스		   : PK열에 기본적으로 적용되는 index, 사전편찬 순서에 맞게 정렬됨. [기본 : B-Tree]
-- 					   : 한 테이블에 한개만 생성departments
-- 					   : 실제 데이터의 정렬이 인덱스의 순서로 정렬
-- 					   : 보조인덱스보다 빠른 속도

-- 보조(Secondary) 인덱스 : PK이외 다른 제약조건이나 수동으로 설정시 적용 [기본 : B-Tree]
-- 					   : 한 테이블에 여러 index 생성


-- 01 제약조건 PK 설정시 unique index 확인 - 클러스터형 인덱스
use testdb;
create table tbl_a(
	col1 int primary key,
    col2 int
);
desc tbl_a;
show index from tbl_a;

-- 02 제약조건 unique 설정시 unique index 확인 - 보조인덱스
create table tbl_b(
	col1 int primary key,
    col2 int unique,
    col3 int
);

desc tbl_b;
show index from tbl_b;

-- 03 index 삭제
show index from tbl_b;
desc tbl_b;

alter table tbl_b drop primary key;			
alter table tbl_b drop constraint col2;    
-- alter table tbl_b drop index [인덱스명];


-- 04 보조 인덱스 추가
-- 테이블 생성 시 추가
create table tbl_c(
	col1 int primary key,
    col2 int,
    col3 int,
    unique index col2_index(col2)
);
show index from tbl_c;

create table tbl_d(
	col1 int primary key,
    col2 int,
    col3 int,
    unique index col2_3_index(col2,col3)
);
show index from tbl_d;

-- 테이블 생성 후 추가
create table tbl_e(
	col1 int primary key,
    col2 int,
    col3 int
);
show index from tbl_e;
create index col2_idx on tbl_e(col2);
show index from tbl_e;

-- 외래키 만들었을 때도 인덱스 설정 가능
create table tbl_f(
	col1 int primary key,
    tbl_e_col1 int,
    col3 int,
    constraint Fk_tbl_f_tbl_e foreign key(tbl_e_col1) references tbl_e(col1)
    on update cascade
    on delete cascade
);
show index from tbl_f;


-- ----------------------------------------------------------
-- INDEX 성능 관리
-- ----------------------------------------------------------
use employees;
select count(*) from employees.salaries;
SELECT * FROM employees.salaries;
SELECT * FROM employees.salaries where to_date = '1986-01-01';
create index to_date_idx on employees.salaries(to_date);
show index from employees.salaries;
alter table employees.salaries drop index to_date_idx;
SELECT * FROM employees.salaries where to_date = '1986-12-01';
