# SQLMAPPER_MYBATIS

SQLMAPPER
---
> 개발자가 작성한 SQL 실행 결과를 객체에 매핑 <br>

> 객체와 테이블간의 관계를 매핑하는 것이 아니라, SQL문을 직접 작성하고 쿼리 수행결과를 어떠한 객체에 매핑하여 줄 지 바인딩하는 방법. 즉 SQL 의존적인 방법 (ex) JdbcTemplate, Mybatis )<br>

> 장점
```
1 Java 코드와 SQL 매핑
 MyBatis를 사용하면, MyBatis 내부에서 그러한 Boilerplate 코드가 구현되어 있고, MyBatis에서 Java 메소드와 SQL 간에 매핑을 시켜서
 개발자는 Java 메소드 선언과 SQL 문만 만들면 MyBatis가 자동으로 그 둘 간을 연결시켜 주게 됩니다.
 SQL 문장이 Java 코드 내에 들어가 있어서 수정하기도 힘들고, 보기도 힘들었는데, SQL 문을 별도로
 Java 코드에서 분리해두어서 관리가 편하게 하였으며, 분리된 SQL 문을 MyBatis가 찾아서 실행해 주는 기능을 합니다.

2 동적 SQL 생성 기능
 MyBatis는 Boilerplate 코드 제거 및 SQL 문 분리 외에도 동적인 SQL(Dynamic SQL) 생성 기능을 제공하여
 프로그램 실행 중에 입력되는 파라미터에 따라 서로 다른 SQL 문을 동적으로 생성해 내는 기능을 제공해 줍니다.
 MyBatis 내에 if 문, choose, when, otherwise, foreach 등의 문법을 지원해서 동적인 SQL 문 생성이 가능합니다
```

> 단점
```
SQL을 개발자가 직접 작성하는 문제.
DBMS에 종속적인 문제.
비슷한 쿼리를 반복적으로 작성해야하는 문제
객체와 관계형 테이블 구조간 패러다임 불일치 발생.
```


ORM (Object Relation Mapping)
---
