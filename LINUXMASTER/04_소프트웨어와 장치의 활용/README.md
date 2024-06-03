# 소프트웨어와 장치의 활용
에디터 활용
---
### ✔️ pico 에디터
- 워싱턴 대학의 Aboil Kasar
- 유닉스 기반
- 메뉴 선택 방식
- 자유 소프트웨어 라이선스가 아님
- 복제 버전인 nano
- 관련 명령 : pico <옵션> [파일명]
  - w(긴 라인이 깨지는 경우 사용)

|메뉴|기능|
|:-:|-|
|[Ctrl]+[O]|파일 저장|
|[Ctrl]+[X]|파일 종료, 종료 시 저장이 안되어 있으면 저장할 것인지 물어봄|
|[Ctrl]+[R]|현재 커서 위치에 다른 파일을 불러옴|
|[Ctrl]+[A]|현재 행의 맨 앞으로 이동|
|[Ctrl]+[E]|현재 행의 맨 끝으로 이동|
|[Ctrl]+[V]|이전 페이지로 이동|
|[Ctrl]+[Y]|다음 페이지로 이동|
|[Ctrl]+[C]|현재 커서의 위치를 표시|
|[Ctrl]+[T]|영문자의 철자를 확인|
|[Ctrl]+[W]|키를 누르고 문자열을 입력하면 원하는 문자열을 찾음|
|[Ctrl]+[K]|현재 라인을 삭제|
|[Ctrl]+[U]|마지막으로 삭제된 라인을 복구|
|[Ctrl]+[I]|화면 갱신|

<br>

### ✔️ emacs 에디터
- 리차드 스톨만
- 매크로 기능
- 제임스 고슬링이 LISP 언어로 기능 추가 개발
- 소스 코드 작성 모드(통합 환경)

|메뉴|기능|
|:-:|-|
|[Ctrl]+[X], [Ctrl]+[S]|파일 저장|
|[Ctrl]+[X], [Ctrl]+[C]|편집 종료|
|마크 설정 후 [Ctrl]+[W]|잘라내기<br>(마크 설정 방법: 설정을 시작하고 싶은 부분으로 커서를 이동시킨 후 [Ctrl]+[SpaceBar]로 마크 설정|
|[Ctrl]+[K]|커서 뒤에 있는 한 줄이 모두 지워짐(지워진 문자는 클립보드에 저장)|
|[Ctrl]+[A]|커서를 줄의 맨 앞으로 이동|
|[Ctrl]+[E]|커서를 줄의 맨 뒤로 이동|
|[Ctrl]+[N]|커서를 한 줄 아래로 이동|
|[Ctrl]+[S] 찾을 문자열|커서의 아랫부분에서 찾을 문자열을 검색|
|[Ctrl]+[R] 찾을 문자열|커서의 윗부분에서 찾을 문자열을 검색|
|[Ctrl]+[G]|진행되고 있는 명령을 끔|

<br>

### ✔️ vi 에디터
- 명령모드
- 입력모드
- 편집모드
- 리눅스 배포판에 기본 포함
```
    # vi <파일명> : 기본 명령어를 입력 받을 수 있는 명령어 상태
    i : 입력 명령, 입력 상태로 전환
    d : 커서가 있는 라인 한 줄을 삭제
    esc : 명령어 상태로 전환
    : 명령줄 상태로 전환(여러개의 명령어 입력)
    w : 명령줄 상태에서 변경사항 저장
    q : 명령줄 상태에서 vi 편집기 종료
    q! : 수정된 사항 반영없이 강제 종료(편집한 내용 취소)
```

<br>

### ✔️ vim 에디터
- vi 편집기와 호환
- 색상 사용한 가시성
- ex모드에서 히스토리 가능
- 확장 정규 표현식
- 다중 되돌리기
- 문법 검사

<br>

### ✔️ nano 에디터
- 단축키 기반의 메뉴

<br>

### ✔️ gedit 에디터
- GNOME(GUI) 데스크톱 환경
- GTK+와 GNOME 라이브러리를 이용하여 개발
- UTF-8과 호환
- CLI에서 사용 불가

<br>

프로그램 설치
---
### ✔️ 리눅스 소프트웨어의 설치 - 배포판의 패키지 설치, 소스코드 컴파일
- 패키지 관리 프로그램
  - 데미안 계열
    - 배포 업체 : Debian, Ubuntu, Xandros, Linspire
    - 패키지 툴 : dpkg, apt-get, aptitude
  - 레드햇 계열
    - 배포 업체 : Fedora, CentOS, RHEL, openSUSE, Mandirva
    - 패키지 툴 : rpm, yum

<br>

### ✔️ RPM - Redhat Package Manager, 패키지 확장명(.rpm)
- 프로그램 패키지 파일 형식의 예 : sendmail-8.12.3-5.fc11.i586.rpm
  - 패키지명-버전(주버전.부버전.패치번호)-릴리즈번호.페도라버전.아키텍처
- 커널 패키지 파일 형식의 예 : kernel-3.5.0-327.el7.x86_x64.rpm
  - 패키지명-버전(주버전.부버전.패치번호)-릴리즈번호.CentOS버전.아키텍처
- 패키지 관리 명령 : rpm <옵션> [패키지명]
  - -i(설치), -h(#마크표시), -U(업그레이드), -e(제거), -q(설치여부확인), -v(진행 메시지 표시), -vv(메시지 상세 표시), --nodeps(의존성 무시), --oldpackage(다운그레이드), --replacepkgsg(재설치), --replacefiles(덮어쓰더라도 강제 설치), --force(기존 패키지 설치여부와 관계없이 강제 설치)
  - 패키지 변조 검사 옵션 : -V(Verify, 검증), -a(검증 시 모든 패키지 검사)
  - 검사 결과 코드 : 5(MID5 체크섬 변경), S(크기 변경), L(링크 변경), T(수정일 변경), D(장치파일 변경), U(소유자 변경)

<br>

### ✔️ YUM - Yellowdog Updater Mofiied, 레포지토리에 접속하여 패키지 관리, RPM 의존성 무제 해결, 페도라22 dlgn DNF로 전환
- 패키지 관리 명령 : yum <옵션> [패키지명]
  - install(설치, -y 옵션으로 자동 설치), update(설치 갱신), localinstall(rpm 이용), remove(제거), groupremove(패키지 그룹 제거), info(패키지 요약 정보)
  - 기타 : yum list(전체 패키지 정보 출력), yum grouplist(패키지 그룹 정보 출력), yum check update(업데이트 가능 목록), yum search 문자열(문자열이 포함된 패키지), yum check-update(업데이트 필요한 패키지), yum history(작업 이력)

<br>

### ✔️ dpkg - 데비안의 low level 패키지 관리 도구, deb 패키지 관리, 의존성 문제가 발생할 수 있음
- deb 패키지 형식 : 패키지이름_버전-릴리즈버전-리버전_아키텍처.deb
- 패키지 관리 명령 : dpkg <옵션> [패키지명.deb]
  - 옵션 : -i(설치), -r(설치된 패키지 삭제), -P(패키지/설정 모두 삭제), -s(패키지 정보 표시), -L(설치 목록 확인)

<br>

### ✔️ apt-get(Advanced Package tool Get)
- 데비안 계열 리눅스의 패키지 관리 도구
- /etc/apt.source.list 참고(의존성 충돌 해결)
  - 패키지 유형(소스코드, 바이너리), 레포지토리 주소(URL), 우분투 버전 정보, 카테고리 분류
```
    #See http://help.ubuntu.com/community/UpgradeNotes for how to upgrade to
    deb http://archive.ubuntu.com/ubuntu/focal main restricted
    #deb-src http://archive.ubuntu.com/ubuntu/focal main restricted
```
- 패키지 관리 명령 : apt-get <옵션> [명령어] [패키지명]
  - 명령어 : install(설치), dist-upgrade(의존성 검사 및 설치), update(/etc/apt/source.list 정보 갱신), upgrade(업그레이드), remove(제거)
  - 옵션 : -y(자동 설치), -u(업그레이드 패키지 목록 표시), -V(자세한 버전)

<br>

### ✔️ 소스파일을 이용한 설치 - 환경설정(configure) → 컴파일(make) → 설치(make install)
- 파일 아카이브(archive) : 여러 개의 파일을 하나로 묶어 놓은 것 → 백업, 배포에 활용
- tar 명령을 이용한 압축 : tar <옵션> [파일명]
  - 옵션 : c(새로 만들기), x(압축 해제), d(차이 비교), u(업데이트), f(아카이브 파일명 지정), v(진행 정보 표시), z(gzip으로 처리), j(bzip2로 처리), J(xz로 처리), P(절대경로 유지), --exclude(지정한 디렉터리 제외)
- 파일 압축과 압축 해제
  - 관련 명령어 : gzip (.gz), gunzip, gzcat, bzip2 (.bz2), bunzip2, bzcat compress(.Z, 가장 낮은 압축률), uncompress, xz(.xz, 가장 높은 압축률), unxz
  - -d 옵션으로 파일 압축 해제, (일반적으로) -v 옵션으로 진행과정 표시
- 1단계 환경설정 : ./configure
  - 프로그램 설치 과정에서 필요로하는 환경파일 makefile 생성
    - 시스템 파일 위치 지정 또는 설치 파일의 위치 지정
    - configure 뒤에 옵션을 넣음
- 2단계 : make
  - makefile을 기반으로 소스 파일을 컴파일
  - make가 끝나면 소스파일은 실행파일(setup)로 전환
- 3단계 : make install
  - 컴파일 된 실행파일을 지정된 속성으로 지정된 디렉터리에 설치
> CMake(Cross Platform Make)<br>운영체제별 Makefile 생성, 의존관계 분석, 다양한 개발 환경 지원, 타임스탬프(변화 확인)

<br>

장치 설정과 활용
---
### ✔️ 프린터(Printer) 인쇄 시스템 - LPRng, CUPS
- LPRng (Line Printer next gegeration)
  - 리눅스 초기, 라인 프린터 데몬 프로토콜 → 스풀링, 네트워크 프린트
    - 설정 파일 : /etc/printcap
- CUPS(Common Unix Printing System)
  - 애플, HTTP 기반의 IPP(Internet Printing Protocol, 631 포트), 인증
    - 데몬 이름 : cupsd
    - 설정 파일의 디렉터리 : /etc/cups
    - /etc/cups/supsd.conf(데본 환경설정), /etc/cups/printer.conf(프린터 큐 환경설정, Ipamin명령), /etc/cups/classes.conf(데몬의 클래스 설정파일)

<br>

### ✔️ 프린트 설정 - X Windows의 프린트 설정 도구, 로컬 접속, 네트워크 프린터 설정
- 네트워크 프린터 설정 방법
  - AppSocket/HP jetDirect
    - 프린터가 컴퓨터에 연결되어 있지 않고 네트워크에 연결된 경우 사용
  - LPD/LPR 호스트 또는 프린터
    - IPP 프로토콜 기반의 프린터 설정 시 사용
  - Windows Printer vis SAMBA
    - 윈도우 시스템에 연결된 프린터 설정 시 사용
    - 삼바 기반의 SMB(Server Message Block) 프로토콜 사용
  - 인터넷 프린터 프로토콜(https)
    - https 프로토콜 기반의 프린터 설정 시 사용
  - 인터넷 프린터 프로토콜(IPP)
    - IPP 프로토콜 기반의 프린터 설정 시 사용

<br>

### ✔️ 사운드 카드 시스템 - OSS, ALSA
- OSS(Open Sound System)
  - 표준 장치 시스템 콜 기반(POSIX read, write, ioctl 등) → ALSA 로 대체
- ALSA(Advanced Linux Sound Architecture)
  - 사운드 장치 드라이버 제공을 위한 리눅스 커널 요소, GPL/LGPL
  - 환경 설정 파일 : /etc/asound.state
  - 사운드 카드 자동 구성, 다수의 장치 관리
  - OSS의 지원으로 미디어 합성, 다중 채널 하드웨어 믹싱, 전이중 통신 등의 기능 제공

<br>

### ✔️ 스캐너 시스템 - SANE, XSANE
- SANE(Scanner Access Now Easy)
  - 스캐너, 비디오 캠 등 이미지 관련 H/W를 제어하는 API, GPL, 멀티 OS 지원
    - SCSI 스캐너 : /dev/sg0, /dev/scanner
    - USB 스캐너 : /dev/usb/scanner, /dev/usbscanner
- XSANE(X based interface for the SANE)
  - X-Windows 기반 스캔/이미지 수정 프로그램, SANE 이용, GPL, 멀티 OS 지원

<br>

### ✔️ 프린터 명령어 - BSD(lpr, lpq, lprm, lpc), System V(lp, lpstat, cancel)
- BSD 계열 프린트 명령어
  - lpr <옵션> [파일명] : -#(인쇄 매수 지정), -m(작업 완료 후 메일), -P(프린터 지정), -r(출력 후 지정파일 삭제)
  - lpq <옵션> : -a(모든 프린터 작업 정보 표시), -l(자세히 표시), -P(프린터 지정)
  - lprm <옵션> : -(모든 작업 취소), -U(사용자 작업), -P(프린터 지정), -h(서버 지정)
  - lpc : 프린터 상태 확인, 큐 활성화/비활성화, 큐의 작업 순서 변경
- System V 계열 프린트 명령어
  - lp <옵션> [파일명] : -n(인쇄매수 지정), -d(프린터 지정)
  - lpstat <옵션> : -p(인쇄 가능 여부), -t(상태 정보), -a(Accept된 상태 정보)
  - cancel[ReqID]: -a(모든 작업 취소)

<br>

### ✔️ 사운드 카드 명령어 - alsactl, alsamixer, cdparanoia
- alsactl <옵션> [명령]
  - 옵션 : -d(디버그 모드), -f(환경설정파일 지정)
  - 명령 : store(환경 설정 파일에 사운드 카드 정보 저장), restore(사운드 카드 정보 로딩), init(초기화)
- alsamixer : ncurses 라이브러리 기반 오디오 프로그램
- cdparanoia <옵션> : 오디오 CD 음악 추출
  - -w(wave 파일), -a(Applie AIFF-C형식), -B(모든 트랙을 cdda2wav 형식으로 추출)
 
<br>

### ✔️ 스캐너 명령어 - sane-fine-scanner, scanimage, scanadf, xcam
- sane-fine-scanner <옵션> [장치명]
  - -q(스캐너 장치만 대상), -v(자세한 정보), -p(시리얼 포트의 스캐너만 대상)
- scanimage <옵션>
  - -d(SANE 장치 파일명), --format(이미지 형식, png/tiff), -L(사용 가능한 스캐너 목록)
- scanadf <옵션> : 자동 문서 공급장치에서 여러개 스캔
  - -d(SANE 장치 파일명), -L(사용 가능한 스캐너 목록(
- xcam : GUI, 평판 스캐너 혹은 카메라로부터 이미지 스캔

<br>

X 윈도우
---
### ✔️ X-Window 개요
- GUI, 플랫폼 독립적, X11, X, X Windows System이라고도 불림, X.org(오픈 그룹)
- X 프로토콜 기반 클라이언트/서버 시스템
  - 서버 : 클라이언트의 디스플레이 접근 제어, 클라이언트 간 자원 공유, 메시지 전달, 클라이언트와 입출력 장치의 중계
  - 클라이언트 : 어플리케이션을 이용하여 X 서버의 기능 이용
- 오픈 데스크톱 환경 : KDE, GNOME, XFCE
- 구성 요소
  - X 프로토콜(XLib, Xtoolkit 인터페이스 사용), Xlib(저수준 클라이언트 라이브러리), XCB(향상된 쓰레드, 확장성), Xtoolkit(고급 GUI 개발, Widget과 Intrinsic 지원), SFree86(X86 계열의 X 서버, 무료), XF86Config(XFree86 설정파일)

<br>

### ✔️ X-Window 설정 
- /etc/inittab : init 프로세스가 참조
  - 사용 환경 초기화 : 파일 시스템 점검, 서비스 프로세스 관리, 가상 콘솔 관리, 런 레벨 관리

<br>

### ✔️ X-Window 실행
- startx -- [값]
  - 시스템 환경 초기화 및 xinit을 실행하는 스크립트

<br>

### ✔️ DISPLAY 환경 변수
- X 윈도우의 Display 위치 지정
- export DISPLAY=IP주소:Display번호,스크린번호

<br>

### ✔️ 윈도우 매니저
- 창의 배치와 표시를 담당하는 프로그램
- XLib와 XCB 라이브러리 사용
- fvwm, twm, mw, windowmaker, AfterStep
- 대표적인 윈도우 매니저
  - Enlightment : GNOME의 기본 윈도우 매니저
  - kwm : KDEv1.x의 기본 윈도우 매니저

<br>

### ✔️ 데스크톱 환경
- 사용자에게 제공되는 인터페이스 스타일, 데스크톱 관리자, 패키지 형태의 프로그램, 위젯, drag&drop, IPC
- 대표적인 데스크톱 환경
  - KDE : Kool Desktop Environment, QT툴 기반, UNIX/Linux, Solaris, FreeBSD 등, Kwin 윈도우
  - GNOME : GNU Network Object Model Environment, 공개 자유 소프트웨어, GTK+, BSD 등에 포함, 윈도우 관리자 선택 사용, 세션 매니저(환경 유지)
  - LXDE(Raspbian, GTK2, 가벼운 모델), XFCE(GTK+2, Xfwm 윈도우 매니저, 가벼운 모델)

<br>

### ✔️ 디스플레이 매니저 - X Windows system에서 동작하는 프로그램, XDM, GDM, KDM, dtlogin 등, X server 접속 및 세션 시작 담당
- 대표적인 디스플레이 매니저
  - kdm : KDE의 디스플레이 매니저
  - gdm : GNOME의 디스플레이 매니저, GTK, GNU GPL

<br>

### ✔️ X 윈도우의 활용
- xhost : X 서버에 접속할 수 있는 클라이언트 지정 혹은 해제, 호스트 단위로 제어
  - 명령 형식 : xhost [+|-] [IP|도메인명]
  - ex) xhost + (모든 클라이언트 접속 허용), xhost + IP 주소(해당 IP로부터 접속 허용)
- xauth : MMC 방식의 인증을 사용하기 위한 유틸리티(MIT-MAGIC-COOKIE), X 윈도우 실행 시 생성되는 키 값으로 인증
  - .Xauthority 파일에 매직 쿠키 추가, 삭제, 항목 출력
  - ~/.Xauthority에 RW 권한 필요
  - 명령 형식 : sauth <옵션> → list (모든 쿠키값 리스트)
 
<br>

### ✔️ X 윈도우 프로그램
- 오피스
  - LibreOffice : 오피스 프로그램 패키지
  - gedit : 텍스트 편집 프로그램
  - kwrite : KDE 기반의 텍스트 편집기
- 그래픽
  - GIMP : 이미지 편집 프로그램
  - ImageMagick : 이미지 생성 및 편집을 지원하는 프로그램
  - eog : GNOME 이미지 뷰어 프로그램
  - kolourpaint : Ubuntu 이미지 편집 프로그램
  - gThumb : GNOME 데스크톱 이미지 뷰어 프로그램
  - gwenview : KDE 기본 이미지 뷰어
- 멀티미디어
  - Totem : GNOME 기반의 사운드 및 비디오 재생 프로그램
  - RHYTHMBOX : 통합형 음악 관리 프로그램
  - CHEESE : GNOME 기반의 카메라 동영상 프로그램
- 개발
  - ECLIPSE : 통합 개발 환경으로 자바를 비롯한 다양한 언어 지원
- 기타
  - Dolphin : KDE용 파일 관리자
  - KSnapshot : 스크린샷 프로그램


