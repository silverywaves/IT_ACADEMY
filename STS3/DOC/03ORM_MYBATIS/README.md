# JDBC
- 자바에서 데이터의 영속성(Persistence)을 위해 지원
- 과정 : JDBC에서 DB에 접근 → SQL 수행 → 결과값을 다시 dataType으로 매핑
  - 해당 작업을 개발자가 일일히 수행해야 하는 번거로움 존재
  - 개발자가 직접 JDBC Programming을 하지 않도록 기능들을 제공해주는 Persistence Framework
    - SQL Mapper
    - ORM
```
영속성(Persistence)
 - 데이터들이 프로그램이 종료되어도 사라지지 않고 어떤 곳에 저장되는 것
 - Layered Architecture에서 도메인 모델과 데이터베이스 사이에 존재
 - 프로그램의 객체정보를 DB에 저장하고, DB의 정보를 객체로 담아와 사용
```

# SQLMAPPER_MYBATIS

SQLMAPPER
---
- 개발자가 작성한 SQL 실행 결과를 객체에 매핑 <br>
- 객체와 테이블간의 관계를 매핑하는 것이 아니라, SQL문을 직접 작성하고 쿼리 수행결과를 어떠한 객체에 매핑하여 줄 지 바인딩
- SQL 의존적 방법 (ex) JdbcTemplate, Mybatis <br>

> 장점
```
1 SQL 직접 제어
 개발자가 SQL을 직접 작성 및 최적화
 복잡한 쿼리 또는 특정 데이터베이스에 최적화된 쿼리 작성이 필요한 경우에 적합

2 동적 SQL 생성 기능
 MyBatis는 Boilerplate 코드 제거 및 SQL 문 분리 외에도 동적인 SQL(Dynamic SQL) 생성 기능을 제공
 프로그램 실행 중에 입력되는 파라미터에 따라 서로 다른 SQL 문을 동적으로 생성해 내는 기능을 제공
 MyBatis 내에 if 문, choose, when, otherwise, foreach 등의 문법을 지원해서 동적인 SQL 문 생성 가능
```

> 단점
```
1 SQL을 개발자가 직접 작성
2 DBMS에 종속적
3 비슷한 쿼리를 반복적으로 작성
4 객체와 관계형 테이블 구조간 패러다임 불일치 발생
```

MYBATIS
---
- SQL을 xml파일로 분리하여 관리, SQL결과와 객체 인스턴스의 매핑을 도와주는 역할
- 동적쿼리 지원 → 다이나믹하게 변경되는 쿼리 작성 가능
<br>

동적쿼리
---
> 상황에 따라 분기 처리를 통해 SQL문을 동적으로 만드는 것
#
- 조건문(if, choose, when, otherwise)

> 단일 조건 : if
```
<if test="조건">
    조건이 참일 때 추가될 문장
</if>
```

> 다중 조건 : choose, when, otherwise
```
<choose>
    <when test="조건1">
        조건1이 참일 때 추가될 문장
    </when>
    <when test="조건2">
        조건1이 거짓이고, 조건2가 참일 때 추가될 문장
    </when>
    <otherwise>
        조건1, 조건2 모두 거짓일 때 실행할 문장
    </otherwise>
</choose>
```

#
- 반복문(foreach)

> foreach

|속성|설명|
|:-:|-|
|List|배열 객체가 파라미터로 넘어올 경우 반복하여 처리할 수 있음|
|collection|컬렉션 파라미터(Map, List, Set, 배열, .. 등 반복가능한 객체)|
|item|현재 반복되는 값을 저장할 변수|
|index|현재 반복되는 인덱스 값을 저장할 변수|
|open|쿼리가 실행될 때 앞에 추가될 접두사(시작문자열)|
|close|쿼리가 실행될 때 끝에 추가될 접미사(종료문자열)|
|separator|컬렉션이 반복될 때 추가될 문자(구분자 문자열)|

```
<foreach collection="컬렉션 변수" item="항목" index="인덱스" open="시작문자열" close="종료문자열" separator="구분자">
    #{item}
</foreach>
```
#
### 조건 특화 엘리먼트
- where
> where 내부에는 조건을 표현할 수 있는 if or choose 사용 가능<br>
> where 내부 코드가 추가되는 경우 동적으로 WHERE 키워드를 붙이고, 가장 앞에 해당되는 "AND"나 "OR" 삭제
```
SELECT *
<WHERE>
    <if test="조건">
        AND 컬럼명 = #{변수}
    </if>
    <if test="조건">
        AND 컬럼명 = #{변수}
    </if>
</WHERE>
```

- set
> 동적으로 SET 키워드를 붙이고 필요없는 콤마 제거
```
UPDATE 테이블명
<set>
    <if test="조건">
        컬럼명 = #{변수},
    </if>
    <if test="조건">
        컬럼명 = #{변수},
    </if>
</set>
```

- trim
> 접두사, 접미사 추가 or 오버라이딩 → 커스텀하게 동적 쿼리 생성 가능

|속성|설명|
|:-:|-|
|prefix|실행될 쿼리의 가장 앞에 문자를 추가|
|prefixOverrides|실행될 쿼리의 가장 앞에 해당하는 문자가 있는 경우 삭제|
|suffix|실행될 쿼리의 가장 뒤에 문자를 추가|
|suffixOverrides|실행될 쿼리의 가장 뒤에 해당하는 문자가 있는 경우 삭제|

```
<trim prefix="문자열" prefixOverrides="문자열" suffix="문자열" suffixOverrides="문자열">
   실행될 쿼리
</trim>
```

#
### 다중 쿼리 
- selectKey
> MyBatis 쿼리문을 실행하기 전 selectKey 태그안의 쿼리를 먼저 수행 → 조회된 결과를 파라미터로 사용 가능<br>
> selectKey의 결과로 나오는 데이터의 row 수는 1개여야 함

|속성|설명|
|:-:|-|
|resultType|결과의 타입|
|keyProperty|selectKey 구문의 결과가 세팅될 대상 프로퍼티|
|keyColumn|리턴되는 결과셋의 컬럼명은 프로퍼티에 일치, 여러개의 컬럼을 사용하는 경우 콤마를 사용해서 구분|
|order|쿼리 수행 순서(BEFORE, AFTER)|

```
// 1. 단일 프로퍼티(BEFORE)
// #{프로퍼티명} 으로 바인드 변수 사용할 수 있음
<selectKey keyProperty="프로퍼티명" resultType="string" order="BEFORE">
    SELECT 컬럼명
    FROM 테이블명
    WHERE 조건
</selectKey>

// 1. 단일 프로퍼티(AFTER)
// JAVA단에서 AFTER로 보낸 값을 사용할 수 있음, 바인드변수 불가
<selectKey keyProperty="프로퍼티명" resultType="string" order="AFTER">
    SELECT 컬럼명
    FROM 테이블명
    WHERE 조건
</selectKey>

// 2. 다중 프로퍼티
<selectKey keyColumn="컬럼명, 컬럼명" keyProperty="변수명, 변수명" resultType="hashMap" order="BEFORE">
    SELECT 컬럼명, 컬럼명
    FROM 테이블명
    WHERE 조건
</selectKey>
```

---
# ORM_JPA 

ORM (Object Relation Mapping)
---
- 객체와 DB의 데이터를 자동으로 매핑 <br>
- ex) Hibernate, EclipseLink, DataNucleus

> 특징
```
1 CRUD 관련 메소드를 사용하면 자동으로 SQL 생성(개발자가 반복적인 SQL을 직접 작성 X)
2 DBMS에 비종속 → 도메인과 비즈니스 로직 설계에 더 집중 가능
3 복잡한 쿼리의 경우 JPQL을 사용하거나 SQL Mapper를 혼용하여 사용 가능 ← 복잡한 통계성 쿼리보다는 실시간 처리용 쿼리에 적합
4 요구사항 변화에 빠른 대처 가능
```


JPA (Java Persistence Api)
---
- Java ORM 기술에 대한 인터페이스 표준
- 자동 매핑으로 개발 및 유지보수성 향상
- 객체 지향적인 접근 지원
