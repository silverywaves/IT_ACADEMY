# 인터넷과 리눅스 활용
네트워크와 인터넷 서비스
---
### ✔️ 네트워크 개요 - LAN, MAN, WAN, SAN
- 네트워크(Network) 개념 : 전송 매체(링크)로 연결되어 데이터를 상호 교환하는 시스템(노드)들의 그룹
  - LAN(Local Area Network) : 사무실, 학교 등 지리적으로 한정된 범위의 근거리 통신망(약 10km 이내 범위)
    - Ethernet(CSMA/CD), Token Ring(Token Passing), FDDI(이중 링, Token Passing)
  - MAN(Metropolitan Area Network) : 도시 지역을 잇는 통신, LAN을 연결한 백본라인(Backbone line)
    - 광섬유, 동축케이블, DBQB(Distributed Queue Dual Bus, Dual Bus, 회선교환/패킷 교환)
    - DBDQB는 MAN에서 사용하는 QPSX(Queued Packet Synchronous Exchange) 접속제어에 사용
  - WAN(Wide Area Network) : 국가, 대륙 등 넓은 지역의 네트워크
    - 거리제한 없음, 다양한 경로(상대적으로 느린 속도, 높은 에러율), 전용선, 회선교환망, 패킷 교환망
  - SAN(Storage Area Network) : 스토리지 구성을 위한 고속 전용 네트워크, Fiber Channel
    - 퍄일 I/O 요청을 블록 I/O로 전환 후 SAN 스토리지로 전달

<br>

### ✔️ 네트워크 개요 - 회선 교환 네트워크
- 회선 교환 네트워크(Circuit Switching Network)
  - 송수신 단말장치 사이에서 연결 경로를 미리 설정 후 데이터 전송
- 메시지 교환 네트워크(Message Switching Network)
  - 메시지 헤더에 목적지 주소 표시하여 전송, 사전 경로 설정 없음
  - 교환기가 전송자의 메시지를 받은 후 수신자 확인 및 전달
- 패킷 교환 네트워크(Packet Switching Network)
  - 메시지를 일정 크기의 패킷으로 분할하여 전송
  - 교환기는 패킷의 목적지 주소를 참고하여 전송 경로 선택
  - 가상 회선과 데이터 그램 방식

<br>

### ✔️ LAN 토폴로지(Topology) 
- 호스트 및 장비들의 물리적인 배치 형태, 성형, 망형, 버스형, 링형, 트리형 등

|토폴로지|특징|연결형태|
|:-:|-|-|
|성형(star)|- 중앙 컴퓨터에 여러 대의 컴퓨터가 허브 또는 스위치와 같은 장비로 연결<br>- 중앙 집중식 형태로 네트워크 확장이 용이<br>- 고속의 대규모 네트워크에 적합<br>- 관리하는 중앙 컴퓨터 고장시 전체 네트워크 사용 불가능|![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/10c168d4-16a0-49be-9856-a6b1700c1b20)|
|망형<br>(full mesh)|- 모든 노듣가 서로 일대일로 연결된 형태<br>- 대량의 데이터를 송수신할 경우 적합<br>- 장애 발생시 다른 시스템에 영향이 적고 우회할 수 있는 경로가 존재하여 가장 신뢰성이 높은 방식<br>- 회선 구축 비용이 많이 듦|![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2ea18fd3-c686-473f-a969-52bafe7b599a)|
|버스형(bus)|- 하나의 통신회서넹 여러 컴퓨터를 연결해서 전송<br>- 연결된 컴퓨터 수에 따라 네트워크 성능이 변동<br>- 단말기 추가 및 제거가 용이하며 설치 비용이 저렴<br>- 노드 수 증가시 트래픽 증가로 병목현상 발생, 네트워크 성능 저하 초래<br>- 문제가 발생한 노드의 위치를 파악하기 어려움|![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e5267dff-3f7f-423f-95cb-464ec3adf21d)|
|링형(ring)|- 각 노드가 좌우의 인접한 노드와 연결되어 원형을 이룬 형태<br>- 앞의 컴퓨터로부터 수신한 내용을 다음 컴퓨터로 재전송하는 방법<br>- 토큰패싱(Token passing)이라는 방법을 통해 데이터 전송<br>- 고속 네트워크로 자주 네트워크 환경이 바뀌지 않는 경우 구성<br>- 분산 제어와 검사 및 회복 가능<br>- 네트워스의 전송상 충돌이 없고 노드 숫자가 증가하더라도 망 성능의 저하가 적음<br>- 논리적인 순환형 토폴로지로 하나의 노드장애가 전체 토폴로지에 영향<br>- 노드의 추가 및 삭제가 용이하지 않음|![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7ea27ec7-21f1-4313-bcba-22da2afdc02c)|
|트리형(tree)|- 버스형과 성형 토폴로지의 확장 형태<br>- 백본(backbone)과 같은 공통 배선에 적절한 분기 장치(허브, 스위치)를 사용하여 링크를 덧붙여 나갈 수 있는 구조<br>- 트래픽 양 증가시 병목 현상의 가능성 증대|![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c749a642-77d8-4885-9ef9-7581aa0d2984)|

<br>

### ✔️ 네트워크 장비
- LAN 카드
  - 컴퓨터 내에 설치, 전기 신호를 이용한 데이터 송/수신, MAC 주소
- 케이블(Cable)
  - 두 개 이상의 전선 혹은 광섬유, TP(Twisted Pair) 케이블, 동축케이블, 광섬유케이블 등
  - 1000 BASE FX : 속도 채널 케이블타입
- 브릿지(Bridge)
  - 수신 프레임을 버퍼에 저장, 목적지 포트로 전달, 필터링, Segment 구성
- 허브(Hub)
  - 노드에 신호 전달, 네트워크 확장, 상호 연결, 신호 증폭
- 스위치(Switch)
  - 맥 주소 테이블을 기반으로 프레임 전송, 스위칭 허브(전용매체교환 기술, 병목 제거, 포트별 속도 보장)
- 리피터(Repeater)
  - 신호 재생, 증폭, 물리거리 확장
- 게이트웨이(Gateway)
  - 서로 다른 네트워크 연결, 서로 ㄹ다른 데이터 포맷 중계
- 라우터(Router)
  - OSI 모델의 물리/데이터/네트워크 계층, 네트워크간 통신, 목적지까지 경로설정 및 전달

<br>

### ✔️ OSI 7 모델과 TCP/IP 모델
> 응용, 표현, 세션, 전송, 네트워크, 데이터링크, 물리 vs 응용, 전송, 인터넷, 네트워크

|NO|OSI 7 모델|기능|TCP/IP 모델|
|:-:|:-:|-|:-:|
|7|응용 계층|사용자에게 다양한 네트워크 서비스를 제공하기 위해 User Interface 제공, UI로 데이터 생성|응용 계층|
|6|표현 계층|부호화(encoding), 압축(Compression), 암호화(Encryption)|응용 계층|
|5|세션 계층|종단 간 애플리케이션들의 연결 설정, 유지, 해제|응용 계층|
|4|전송 계층|종단 간 연결(End-to-End Connection), 응용계층 사이에 논리적인 통로 제공(Virtual Circuit)|전송 계층|
|3|네트워크 계층|논리적인 주소 사용, 경로 관리 및 최적 경로 결정|인터넷 층|
|2|데이터링크 계층|데이터 전송을 위한 형식 결정, 데이터 전송을 위해 Media에 접근하는 방법 제공, 오류 검출 기능 제공|네트워크 인터페이스 층|
|1|물리 계층|물리적인 연결, 전기적, 기계적, 기능적 절차적인 수단 제공|네트워크 인터페이스 층|

<br>

### ✔️ 계층별 프로토콜 
- 프로토콜(Protocol)
  - 컴퓨터 네트워크에서 데이터 교환 방식을 정의한 규약
  - 주고받는 데이터의 형식 및 수행 절차
- 구성요소
  - 형식(Syntax : 문법, 구문)
    - 데이터 포맷(형식), 부호화 및 신호 레벨 등
  - 의미(Semantic)
    - 특정 패턴을 어떻게 해석하고, 어떤 동작을 할 것인가 결정
    - 전송의 조정 및 오류 처리를 위한 제어 정보 등
  - 순서(Timing)
    - 속도 일치 및 순서 제어 등
- 응용 계층 프로토콜
  - SMTP, POP, Telnet, SSH, FTP, HTTP, SNMP, TFTP, DHCP
- 전송 계층 프로토콜
  - TCP(Transmission Control Protocol), UDP(User Datagram Protocol)
- 인터넷/네트워크 계층 프로토콜
  - IP, ICMP, IGMP, ARP, RARP

<br>

### ✔️ IP 주소와 도메인
- IP(IPv4) 주소 체계
  - 4개의 옥탯(octet, 8비트 모임), 32비트 체계, E클래스(240~255, IP 부족 위해 예약)
  - 네트워크 ID + 호스트 ID, 서브네팅으로 관리
- 서브네팅(subnetting)
  - 네트워크를 여러 개의 네트워크, 브로드캐스트 도메인으로 분할, IP 주소 부족 현상 해소 방안
  - 서브넷 마스크
- 특수 네트워크 주소
  - Network 주소 : 호스트 비트가 모두 0
  - Direct Broadcast 주소 : 호스트 비트가 모두 1
  - Limited Broadcast 주소 : 255.255.255.255, DHCP 클라이언트가 DHCP 서버를 찾을 때 사용
  - Lookback 주소 : 127.0.0.0 ~ 127.255.255.255, 내부 시험 테스트용
  - 0.0.0.0 : 자신의 IP를 모를 경우(부팅시)
- IPv6 주소의 특징 : 128비트 :로 구분된 16진수 8자리

|구분|IPv4|IPv6|
|:-:|-|-|
|IP 주소 비트 수|32비트|128비트|
|IP 주소 방식|지정 주소 방식<br>(일반주소, 브로드캐스트주소)|자동 설정 주소 방식<br>(유니캐스트주소, 멀티캐스트주소, 애니캐스트주소)|
|IP 헤더 길이|20바이트(기본헤더)~<br>60바이트(옵션필드 사용시)|40바이트(기본헤더)와 확장필드 이용|
|기능|IP 헤더를 이용한 기본 기능|확장 필드를 이용한 다양한 기능<br>- 암호 및 인증 기능<br>- QoS 관련 기능<br>- 보안 기능|

<br>

### ✔️ 인터넷 서비스 종류
- WWW(World Wide Web : HTTP를 기반으로 한 서비스, 분산 클라이언트 - 서버모델)
  - HTTP : Requst(GET, POST), Response(응답코드), Header+Body(Data)
  - 표준 웹 프로토콜 : HTTP, XML, SOAP, USDL, UDDI → 상호 운영성
  - 다양한 웹 브라우저와 웹 서버
- FTP 서비스 : TCP/IP 기반, 파일 복사/전송
  - 통신 모드 : 액티브 모드, 패시브 모드
  - 계정 정책 : 사용자 계정, 익명 계정
- DNS 서비스 : 호스트(도메인)이름 ↔ IP 주소, 분산된 트리 구조, DNS 레코드
  - DNS 레코드 : A, AAA, MX, TXT, SOA, PTR, CNAME
- Telnet과 SSH 서비스 : 원경 로그인, 실행 제어
  - Telnet : Byte 스트림 형식으로 전송
  - SSH : RSA 등 암호화 기법, 압축 기술
- NFS(Network File System) : 파일 공유를 위한 클라이언트/서버, pormap 데몬을 이용한 RPC 연결 필요
  - NFS 관련 데몬 : nfsd, rpc, mouted, rpc, rockd, rpc, rquotad 등
- RPC(Remote Procedure Call) : 서비스와 포트 연결
  - 정적 포트 : /etc/services
  - 동적 포트 : rpcbind 사용 (SUN은 sunrpc)

<br>

### ✔️ 네트워크 인터페이스 설정 : 자동, 수동(컴파일 된 모듈 적재, 설정 파일 등
- 네트워크 설정 파일
  - /etc/sysconfig/network : 기본 설정 정보
  - /etc/sysconfig/network-scripts/ifcfg-ethX : 지정된 네트워크 인터페이스의 환경 설정 정보
  - /etc/resolv.conf : 도메인 명, 네임서버
  - /etc/hosts : IP 주소와 도메인 정보 설정
- IP 주소 설정 방법
  - 설정 파일 : /etc/sysconfig/network, /etc/sysconfig/network-scripts/ifcfg=ethX
  - 명령어 : ifconfig
  - 유틸리티 : netconfig, shystem-config-network, redhat-config-network 등

<br>

### ✔️ 네트워크 관련 명령어
- TCP/IP 주소 설정 정보 확인
  - ifconfig
  - nslookup
- 네트워크 경로 상태 확인
  - ping
  - traceroute
- 네트워크 연결 상태 확인
  - netstat
- 라우팅 테이블 확인
  - route
- NIC 상태 확인
  - ethtool, mii-tool, arp

<br>

리눅스 기술동향과 활용
---
### ✔️ 리눅스 동향
- POSIX 표준, 인터넷 표준 프로토콜, 초기에는 주소 서버 → 서버, 데스크탑, 개발, 임베디드 → 클라우드

<br>

### ✔️ 리눅스 관련 기술 및 서버 분야
- 클러스터링 : 여러 개의 시스템 연결, 하나의 큰 컴퓨팅 환경 → 고계산용, 부하 분산, 고 가용성(HA, High Available)
- 임베디드 시스템 : H/W와 S/W가 통합된 특정 목적을 수행하는 컴퓨팅 시스템, 실시간 처리, 높은 신뢰성, 소형/경량/저전력
- 서버 가상화 : 하나의 물리적 호스트에서 여러 운영체제(게스트 OS) 실행, 가상화 기술을 기반으로 한 IT 인프라, 가용성
- 클라우딩 컴퓨팅 : 가상화 기술을 기반으로 IT 자원 및 서비스 제공, 인터넷(네트워크) 기반, On-Demand
  - laaS(Infrastructure as a Service), PaaS(Platform as a Service), SaaS(Software as a Service)
  - Public Cloud, Private Cloud, Hybrid Cloud
  - 오픈스택(Open Stack), 클라우드 스택, 유칼립투스
- 빅데이터 : 크기(Volume), 속도(Velocity), 다양성(Variety)

<br>

### ✔️ 임베디드 시스템(Embedded System)
- 안드로이드, iOS, Maemo, Moblin, MeeGo, Limo, Tizen 등

<br>

### ✔️ 스마트 TV
- 인터넷과 서비스가 통합된 TV
- Tizen, WebOS

<br>

### ✔️ IVI(In Vegicle Infortainment)
- 정보(information) + 오락(Entertainment)
- GENIVI 표준 플랫폼 기반
- 운전자 편의성/안전성 → AUTOSAR(상호운영)

<br>




