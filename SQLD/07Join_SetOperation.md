## JOIN
### E.F.CODD의 연산자
- SQL의 많은 기능이 RDB이론을 수립한 E.F.Codd 박사의 논문에서 소개됨
  - 4개의 일반집합연산자 + 4개의 순수관계연산자
  - 일반집합연산자의 SQL 구현
    - UNION -> UNION / UNION ALL (공통집합의 중복 허용)
    - INTERSECTION -> INTERSECT
    - DIFFERENCE -> MINUS(Oracle) / EXCEPT(MS-SQL)
    - PRODUCT -> CROSS JOIN

![E F Codd](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/eef54357-e0c5-4a6a-ab01-1fc380f052e9)


  - 순수관계연산자의 SQL 구현
    - SELECT(행을 선택) -> WHERE 절
    - PROJECT(열을 선택) -> SELECT 절
    - JOIN -> 매우 다양한 JOIN으로 구현
    - DIVIDE -> 현재 사용 X

![순수연산자의sql구현](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/369f334e-0b7d-411e-845c-2a64e2192d6e)




