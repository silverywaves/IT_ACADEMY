# TRANSACTION
> DB의 상태를 변경시키는 작업의 단위

- 트랜잭션의 4가지 특징 : ACID

|ACID|설명|
|:-:|-|
|Atomicity<br>(원자성)|트랜잭션이 DB에 모두 반영되거나, 혹은 전혀 반영되지 않아야 함 (All or Nothing)
|Consistenty<br>(일관성)|트랜잭션의 작업 처리 결과는 항상 일관성 있어야 함<br>= 시스템이 가지고 있는 고정 요소는 트랜잭션 수행 전과 수행 후의 상태가 같아야 함<br>= DB의 제약조건을 위배하는 작업을 트랜잭션 과정에서 수행할 수 없음<br>ex) 송금 시 금액의 데이터 타입을 정수형(integer)에서 문자열(string)로 변경할 수 없음|
|Isolation<br>(독립성)|둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 때, 어떤 트랜잭션도 다른 트랜잭션 연산에 끼어들 수 없음|
|Durability<br>(지속성)|트랜잭션이 성공적으로 완료되었으면, 결과는 영구적으로 반영되어야 함|

<br>

- TRANSACTION 연산
```
(1) COMMIT 연산
  - 트랜잭션이 성공적으로 수행되었음을 선언하는 연산
  - COMMIT 연산의 실행을 통해 트랜잭션의 수행이 성공적으로 완료되었음을 선언하고, 그 결과를 최종 DB에 반영

(2) ROLLBACK 연산
  - 트랜잭션 수행이 실패했음을 선언하고 작업을 취소하는 연산
  - 트랜잭션이 수행되는 도중 일부 연산이 처리되지 못한 상황이라면 ROLLBACK 연산을 실행하여 트랜잭션 수행이 실패했음을 선언하고,
    DB를 트랜잭션 수행 전과 일관된 상태로 되돌려야 함
```
<br>

- TRANSACTION 상태<br>

|name|status|info|
|:-:|-|-|
|Active|트랜잭션 활동 상태|트랜잭션이 실행 중이며 동작 중인 상태|
|Partially<br>Committed|트랜잭션의 COMMIT 명령이<br>도착한 상태|트랜잭션의 COMMIT 이전 SQL문이 수행되고, COMMIT 만 남은 상태<br>(트랜잭션의 마지막 연산까지 실행하고 COMMIT 연산을 실행하기 직전의 상태)|
|Failed|트랜잭션 실패 상태|더이상 트랜잭션이 정상적으로 진행될 수 없는 상태|
|Committed|트랜잭션 완료 상태|트랜잭션이 정상적으로 완료된 상태|
|Aborted|트랜잭션 취소 상태|트랜잭션이 취소되고, 트랜잭션 실행 이전 데이터로 돌아간 상태<br>(트랜잭션 수행을 실패하고 ROLLBACK 연산을 실행한 상태)|

#

@Transactionl Option 정리
---
|옵션|설명|
|:-:|-|
|propagation|트랜잭션 전파 방식을 설정<br>(다른 트랜잭션 내에서 메서드가 호출될 때 어떻게 트랜잭션을 전파할지를 결정)<br>ex) REQUIRED, REQUIRES_NEW, SUPPORTS 등|
|isolation|트랜잭션 격리 수준을 설정<br>(여러 트랜잭션이 동시에 실행될 때 데이터의 일관성을 보장하기 위해 어떤 수준의 격리를 유지할지를 결정)<br>ex) DEFAULT, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE 등|
|timeout|트랜잭션 타임아웃을 설정<br>특정 시간 내에 트랜잭션이 완료되지 않으면 롤백<br>단위 : 초(seconds)|
|readOnly|읽기 전용 트랜잭션 여부를 설정<br>(읽기 전용 트랜잭션은 해당 트랜잭션 동안 데이터를 수정하지 않음을 나타냄<br>기본값은 false (true로 설정하면 성능 향상)|
|rollbackFor<br>noRollbackFor|롤백을 수행할 예외 클래스를 지정하거나 롤백을 수행하지 않을 예외 클래스를 지정|
