## 모델 생성
HOME -> File -> New Model -> mydb 더블클릭 -> 이름 변경 가능
-> Model Overview 에서 Add Diagram 더블클릭 -> 퀵메뉴 New Table 선택
-> 격자창에서 생성된 Table 더블클릭하면 속성 기재 가능

---------------------------------------------------

관계선 연결시 자식먼저 선택해야함
FK 있는 쪽이 하위테이블(자식)

---------------------------------------------------

## 데이터베이스 연결
Database->Forward Engineer->Stored Connection 설정

---------------------------------------------------

## 저장
File -> Save Model

---------------------------------------------------

## Table 먼저 생성시
table 작성 -> database -> reverse engineer

* table 작성시 하단탭의 foreign key 작성
    * foreign key 는 전역 설정이라 중복 불가
    * 외래키 제약 조건 : 기본 키열 값만 넣을 수 있음
    * foreign key name 기재 방법 : fk_외래키가 포함된 테이블_기본키가 포함된 테이블
    * foreign key options
        - cascade : 부모테이블이 변경되면 자식테이블도 함께 변경
        - restrict : 자식테이블이 참조하고 있을 경우 수정 불가
        - set null : 부모데이터 변경시 자식테이블의 참조 컬럼을 null로 업데이트
        - no action : = restrict 옵션 지정안한 경우 기본값
