# 리눅스 기본 명령어
기본 명령어
---
### ✔️ which : 명령어 경로 확인
- PATH 환경변수의 경로에 따라 사용자가 실행할 명령어의 위치 혹은 alias 표시
- which [명령어]
```
    [LinuxMaster]#which bash
    /usr/bin/bash
  
    [LinuxMaster]#which pwd
    /usr/bin/pwd
```

<br>

### ✔️ whereis : 대상 명령어의 절대 경로, 소스 파일, 설정 파일, 메뉴얼 등 정보 표시
- whereis <~옵션> [명령어]
  - 옵션 : -b (바이너리만 검색), -m(지정한 메뉴얼 섹션만 검색), -M(메뉴얼 페이지 위치 제한), -u(특정 파일 제외)
```
    [LinuxMaster]#whereis find
    find: /usr/bin/find/usr/share/man/man1p/find.1p.gz/usr/share/man/man1/find.1.gz
```

<br>

### ✔️ alias : 명령어의 별칭 만들기
- 명령어에 별칭을 부여하여 자주 사용하는 명령을 편리하게 사용
- alias [별칭 = '명령']
```
    [LinuxMaster]#alias fshowall='ls-al'
    [LinuxMaster]#showall
    합계 1969
    dr-xr-x---. 10 root root  4096 1월 5 13:28 .
    dr-xr-xr-x. 19 root root  4096 9월 7 02:18 ..
    drwx------. 3 root root  4096 3월 9 2021 .ansible
    -rw-------. 1 root root  15821 1월 5 15:44 .bash_history
    -rw-r--r--. 1 root root  18 12월 29 2013 .bash_logout
    ...
```

<br>

### ✔️ unalias : 명령어의 별칙 삭제
- 만들어놓은 별칭 삭제
- unalias [별칭]
```
    [LinuxMaster]#unalias showall
    [LinuxMaster]#showall
    -bash: showall: command not found
```

<br>

### ✔️ PATH 환경 변수 : 명령어(프로그램)가 위치된 경로를 찾는 순서 지정
- PATH 환경 변수에 지정된 디렉터리를 순서대로 탐색하여 명령어(프로그램)을 찾고 실행
- 확인 : echo/$PATH
- 설정 : export PATH = [설정값:설정값:...]
  - ~/.bash_profile 에 기본값 설정
  - ex) export PATH = $PATH:/var/myfile
- 기타 환경 변수의 확인 및 설정 방법도 동일
```
    [LinuxMaster]#echo $PATH
    /usr/local/sbin:/usr/local/bin:/usr/bin:/root/bin
    [LinuxMaster]#export MYVAR=LinuxMaster
    [LinuxMaster]#echo $MYVAR
    LinuxMaster
```

<br>

### ✔️ man : 리눅스 명령어의 메뉴얼(manual) 확인
- 리눅스에서 사용할 수 있는 명령어들의 메뉴얼 확인
- main <섹션><-옵션> [명령어]
  - 섹션 : 1(일반), 2(시스템 호출), 3(C 표준함수), 4(장치/특수파일), 5(특정한 파일), 6(게임/화면보호기), 7(리눅스 파일 표준, 프로토콜, 시그널 목록), 8(시스템 관리 명령어, 데몬 정보), 9(커널 관리 정보)
  - -h(사용법 표시), -a(모든 페이지 표시), -w(검색 문자의 메뉴얼 페이지의 위치 표시), -f(키워드 검색하여 페이지 표시)
```
    [LinuxMaster]#man find
    FIND(1)              General Commands Manual              FIND(1)    
    NAME
        find-search for files in a directory hierarchy
    ...
```

<br>

### ✔️ apropos : 명령어 메뉴얼에서 지정한 키워드가 포함된 것을 검색
- whatis 데이터베이스를 참조하여 지정한 문자열을 포함한 것을 검색하여 표시
- apropos [문자열]
```
    [LinuxMaster]#apropos find
    ffs (3)        - find first bit set in a word
    ffsl (3)       - find first bit set in a word
    ffsll (3)      - find first bit set in a word
    tfind (3)      - manage a binary tree
    ttyslot (3)    - find the slot of the current user's terminal in some file
    ...
```

<br>

### ✔️ manpath : man 명령이 참조하는 메뉴얼의 경로 표시
- man 명령이 페이지를 찾기 위해 탐색하는 경로 정보를 표시
- manpath
```
    [LinuxMaster]#manpath
    /usr/local/share/man:/usr/share/man/overrides:/usr/share/man
```

<br>

### ✔️ info : 리눅스 명령어의 사용법, 옵션 등 표시
- man 명령보다 제한적인 기능 제공
- info [명령어]
```
    [LinuxMaster]#info find
    File:find.info, Node:Invoking find, Next:Invoking locate, Up:Reference
  
    8.1 Invoking 'find'
    =======================
        find [-H] [-L] [-P] [-D DEBUGOPTIONS] [-OLEVERL] [FILE...] [EXPRESSION]
    ...
```

<br>

### ✔️ whatis : 명령어의 기능을 간략히 표시
- whatis 데이터베이스에서 키워드를 검색하여 일치할 경우 명령어의 기능 표시
- whatis [명령어]
```
    [LinuxMaster]#whatis find
    find(1p)    - find files
    find(1)     - search for files in a directory hierarchy
```

<br>

---
#
---

<br>

사용자 생성 및 계정 관리
--
### ✔️ useradd, adduser : 사용자 계정 생성
- 사용자 계정과 관련 정보를 생성
- user add <-옵션> [계정명]
  - 옵션 : -s(로그인 셸 지정), -d(홈 디렉터리 지정), -f(패스워드 만료 후 계정 영구 정지까지의 기간), -e(계정의 유효기간, 임시 계정 생성), -c(/etc/passwd에 사용자 설명 추가), -G(/etc/group에 정보 추가)
- 기본 홈 디렉터리 : /home/계정명
- 계정 정보 파일 : etc/passwd, /etc/shadow, /etc/group 에 정보 추가
```
    [LinuxMaster]#useradd -d /CHRIS chris
```

<br>

### ✔️ passwd : 사용자 패스워드 변경
- /etc/shadow 파일에 패스워드 변경 및 저장
- passwd <-옵션> [계정명]
  - 옵션 : -S(상태표시), -d(삭제), -l(잠금), -u(잠금해제)
- 상태표시 정보 : PS(정상), NP(패스워드 없음), LK(잠금 혹은 패스워드 없는 상태)
```
    [LinuxMaster]#passwd -S chris
    chris LK 2023-01-08 0 99999 7 -l (비밀 번호 잠금.)
    [LinuxMaster]#passwd chris
    ...
    passwd: 모든 인증 토큰이 성공적으로 업데이트 되었습니다.
    [LinuxMaster]#passwd -S chris
    chris PS 2023-01-08 0 99999 7 -l (비밀번호 설정, SHA512 암호화. )
```

<br>

### ✔️ su : 사용자 전환(switch user)
- 로그아웃 없이 다른 사용자의 계정으로 로그인, 다른 사용자의 권한을 획득
- su <-옵션> [계정명] <셸변수>
  - 옵션 : - or -ㅣ or -login(사용자 환경변수 적용), -s(셸 지정), -c(계정 변환없이 지정한 명령어 실행)
```
    [LinuxMaster]#su chris
    [LinuxMaster]#pwd
    /root
    [LinuxMaster]#exit
    exit
    [LinuxMaster]#su - chris
    [chris@118-27-119-212~]$pwd
    /CHRIS
```

<br>

### ✔️ 사용자 설정 관련 환경 구성 파일
- /etc/default/useradd : 사용자를 추가할 때 기본 설정 정보로 활용
  - SKEL : 사용자 홈 디렉터리로 복사될 초기 환경 설정 파일이 저장된 디렉터리 지정
- 텍스트 편집기(vi, nano 등) 혹은 'useradd -D옵션'으로 변경
```
    [LinuxMaster]#cat /etc/default/useradd
    #useradd defaults file
    GROUP=100
    HOME=/home
    INACTIVE=-1
    SHELL=/bin/bash
    SKE=/etc/skel
    ...
```
- /etc/passwd : 사용자 계정 정보 저장
  - 파일 형식) username : password : uid : gid : comment : home-direcroty : shell
  - password : 패스워드 → pwconv 실행(x로 표시, /etc/shadow에 패스워드 기록), pwunconv로 비활성화
- /etc/shadow : 사용자 패스워드 암호화파일
  - 파일 형식) username : password : lastchange : mindays : maxdays : warndays : inactive : expire : flag
  - lastchange : 1970년 1월 1일 기준 최근 비밀번호 변경일
  - mindays : 비밀번호 변경 후 재설정 가능한 최소 기간
  - inactive : 비밀번호 만료 후 계정 사용 불가능까지의 유예 기간
  - expire : 계정 사용 정지 날짜(1970년 1월 1일 기준으로 이후의 날짜 수)
  - flag : 기본 0으로 설정
- /etc/login.defs : 사용자 계정 설정시 기본값
  - ex) MAIL_DIR(메일 디렉터리), PASS_MAX_DAYS(패스워드 변경 없이 사용할 수 있는 최대 일 수), PASS_MIN_LEN(패스워드 최소 길이), CREATE_HOME(홈 디렉터리 생성 여부) 등
```
    [LinuxMaster]#cat /etc/login.defs
    ...
    #  PASS_MAX_DAYS Maximum number of days a password may be used.
    #  PASS_MIN_DAYS Minimum number of days allowed between password changes.
    ...
    PASS_MAX_DAYS 99999
    PASS_MIN_DAYS 0
    ...
```

<br>

### ✔️ usermod : 사용자 계정 정보 수정
- 사용자 홈 디렉터리, 그룹, 유효기간, 셸 등 정보 변경
- usermod <-옵션> [계정명]
  - 옵션 : -u(새로운 UID), -g(새로운 GID), -G(새로운 보조 그룹), -d(새로운 홈 디렉터리), -s(새로운 셸), -c(새로운 주석), -l(새로운 계정명)
```
    [LinuxMaster]#usermod -h
    Usage: usermod [options] LOGIN

    Options:
    -c, --comment COMMENT    new value of the GECOS field
    ...
```

<br>

### ✔️ userdel : 사용자 계정 정보 삭제
- /etc/passwd, /etc/shadow, /etc/group 에서 사용자 정보 삭제
- usermod <-옵션> [계정명]
  - 옵션 : -r(사용자의 메일 파일과 홈 디렉토리 모두 삭제)
```
    [LinuxMaster]#userdel -h
    Usage: userdel [options] LOGIN

    Options:
    -f, --force    force some actions that would fail otherwise
                  e.g. removal of user still logged in
                  or files, even if not owned by the user
```

<br>

### ✔️ chage : 패스워드 만료 정보 변경
- chage <-옵샨> [계정명]
  - 옵션 : -l(계정 정보 표시), -m(최소 사용 일자), -M(사용 가능 일자), -E(만기일), -W(만기 전 지정 날짜부터 경고)
```
    [LinuxMaster]#chage -l chris
    마지막으로 암호를 바꾼 날        : 1월 08, 2023
    암호 만료        :안함
    암호가 비활성화 기간          :안함
    계정 만료                  :안함
    암호를 바꿀 수 있는 최소 날 수  :0
    암호를 바꿔야 하는 최대 날 수    :99999
    암호 만료 예고를 하는 날 수      :7
    ...
```

<br>

### ✔️ groupadd : 그룹을 추가하는 명령어
- groupadd <-옵션> [그룹명]
  - 옵션 : -g(GID 지정), -r(시스템 그룹시 500번 이하의 값 중 가능한 높은 범위 할당)

<br>

### ✔️ groupdel : 그룹을 삭제하는 명령어(단, 소속 계정이 있을 경우 삭제 불가)
- groupdel [그룹명]

<br>

### ✔️ groupmod : 그룹 설정 변경
- groupmod <-옵션> [그룹명]
  - 옵션 : -g(GID 변경), -n(새로운 그룹명 설정)

<br>

### ✔️ 그룹 설정 관련 환경 구성 파일
- /etc/group : 사용자가 소속된 그룹을 설정
  - 파일 형식) groupname : password : gid : users
  - users : 콤마(,)로 구분된 사용자 계정
- /etc/gshadow : 그룹의 패스워드를 MD5로 암호화하여 저장
  - 파일 형식) groupname : password : owner : users
  - password : ! 이면 암호가 없는 상태
  - users : 콤마(,)로 구분된 사용자 계정

<br>

### ✔️ users : 로그인한 사용자 정보 표시
- users <-옵션>
  - 옵션 : --version(명령어 버전 정보)
```
    [LinuxMaster]#users
    root
```

<br>

### ✔️ who : 접속한 사용자 정보 표시
- 계정명, 터미널 정보, 접속 시간, 접속 서버 등 표시
- who <옵션>
  - 옵션 : -b(마지막 부팅 시간), -q(로그인 사용자, 사용자 수 표시), -r(현재 실행 레벨 표시)
```
    [LinuxMaster]#who -q
    root
    # users=1
    [LinuxMaster]#who -r
        run-level 3 2022-09-07 02:20
```

<br>

### ✔️ w : 접속한 사용자 정보 표시
- 서버 시간, 부팅 후 작동 시간, 접속자 수, 접속자별 평균 부하율, 접속자별 계정명, TTY 이름, 로그인 시간 등
- w
  - JCPU : TTY 장치명에서 사용되는 모든 프로세스의 CPU 사용 시간
  - PCPU : WHAT에 표시된 프로세스의 CPU 사용 시간
```
    [LinuxMaster]#w
    17:43:20 up 123 days, 15:26. 1 user, load average: 0.06, 0.03, 0.05
    USER  TTY    FROM      LOGIN@      IDLE   JCPU   PCPU  WHAT
    root pts/0 10.0.0.7 13:25         0.00s  0.50s  0.01s   w
```

<br>

### ✔️ id : 접속한 사용자 정보 표시
- uid, gid, group 정보 표시
- id <-옵션> [계정명]
  - 옵션 : -u(UID만 표시), -g(GID만 표시), -G(사용자가 표시된 모든 그룹 표시)
```
    [LinuxMaster]#ㅑㅇ
    uid=0(root) gitd=0(root) groups=0(root)
```

<br>

### ✔️ who am i, shoami : 접속해있는 자신의 정보를 표시
- who am i 혹은 whoami
```
    [LinuxMaster]#whoami
    root
```

<br>

### ✔️ groups : 사용자가 속한 그룹 목록 표시
- group <계정명>
```
    [LinuxMaster]#groups
    root
    [LinuxMaster]#groups chris
    chris : chris
```

<br>

---
#
---

<br>

디렉터리 및 파일 관련 명령어
---
### ✔️ pwd : 현재 작업 디렉터리명 표시
- pwd
```
    [LinuxMaster]#pwd
    /root
    [LinuxMaster]#cd /var/www/
    [LinuxMaster]#pwd
    /var/www
    [LinuxMaster]#cd ~
    [LinuxMaster]#pwd
    /root
```

<br>

### ✔️ cd : 디렉터리 이동(change directory)
- cd [경로명]
  - 경로명 : ~(홈 디렉터리), .(현재 디렉터리), ..(상위 디렉터리), /(루트 디렉터리)
```
    [LinuxMaster]#pwd
    /root
    [LinuxMaster]#cd /var/www/
    [LinuxMaster]#pwd
    /var/www
    [LinuxMaster]#cd ~
    [LinuxMaster]#pwd
    /root
```

<br>

### ✔️ mkdir : 디렉터리 만들기
- mkdir <옵션> [디렉터리명]
  - 옵션 : -m(권한 설정, 기본 755), -p(상위 디렉터리 생성), -v(생성 디렉터리 메시지 표시)
```
    [LinuxMaster]#pwd
    /root/Test
    [LinuxMaster]#mkdir One
    [LinuxMaster]#mkdir -m 700 Two
    [LinuxMaster]#ls-al
    ...
    drwxr-xr-x  2 root root 4096  1월 8 18:00 One
    drwx------  2 root root 4096  1월 8 18:04 Two
```

<br>

### ✔️ rmkdir : 디렉터리 삭제하기(비어있는 디렉터리만 가능)
- rmdir [디렉터리명]
  - rm 명령으로 비어있지 ㅇ낳은 디렉터리도 삭제 가능
```
    [LinuxMaster]#ls
    One Two
    [LinuxMaster]#rmdir Two
    [LinuxMaster]#ls
    One
```

<br>

### ✔️ ls : 디렉터리의 파일 목록(정보) 표시
- ls <옵션> [디렉터리명]
  - 옵션 : -a(숨김 파일 포함), -l(자세히 목록 보기), -d(디렉터리 지정), -r(역순으로 표시), -R(하위 디렉터리 포함)
```
    [LinuxMaster]#ls-al
    합계 16
    drwxr-xr-x  3 root root 4096 1월 8 18:11 .
    dr-xr-x---.  11 root root 4096 1월 8 18:00 ..
    drwxr-xr-x  2 root root 4096 1월 8 18:11 One
    -rw-r--r--  1 root root  0 1월 8 18:11 hell.txt
    -rw-r--r--  1 root root  7 1월 8 18:11 hi.txt
```

<br>

### ✔️ cp : 파일, 디렉터리 복사
- cp <옵션> [소스] [타깃]
  - 옵션 : -b(타깃 파일 존재시 백업), -f(타깃 파일 존재시 강제로 삭제 및 복사), -i(타깃 파일 존재시 덮어쓰기 확인), -r(하위 폴더 및 파일 포함)
```
    [LinuxMaster]#ls
    One hell.txt hi.txt
    [LinuxMaster]#cp hell.txt hello.txt
    [LinuxMaster]#ls
    One hell.txt hello.txt hi.txt
```

<br>

### ✔️ rm : 파일, 디렉터리 삭제
- rm <옵션> [파일명] [디렉터리명]
  - 옵션 : -f(확인없이 삭제), -i(사용자에게 확인), -r(하위 디렉터리 포함, 모든 파일 제거)
```
    ne hell.txt hello.txt hi.txt
    [LinuxMaster]#rm hi.txt
    rm:remove 일반 파일 'hi.txt'? y
    [LinuxMaster]#ls
    One hell.txt hello.txt
```

<br>

### ✔️ mv : 파일, 디렉터리 이동, 파일명 변경에서 사용
- mv <옵션> [소스] [타깃]
  - 옵션 : -b(타깃 파일 존재시 백업), -f(타깃 파일이 있어도 강제 적용), -v(진행 과정의 정보 표시)
```
    [LinuxMaster]#ls
    One hell.txt hello.txt
    [LinuxMaster]#mv hell.txt hi.txt
    [LinuxMaster]#ls
    One hello.txt hi.txt
```

<br>

### ✔️ touch : 비어있는 파일 생성 혹은 파일의 시간(time stamp) 변경
- touch <옵션> [파일명]
  - -a(접근시간 변경), -m(수정시간 변경), -c(파일 ㅣ간을 현재 시간으로 변경), -t(특정 파일의 시간 변경), -r 파일A 파일B(파일A의 시간을 파일B와 동일하게 변경)
```
    [LinuxMaster]#ls-al
    ...
    -rw-r--r--  1 root root  0 1월 8 18:21 empty.txt
    [LinuxMaster]#touch -c empty.txt
    [LinuxMaster]#ls-al
    ...
    -rw-r--r--  1 root root  0 1월 8 18:23 empty.txt
```

<br>

### ✔️ file : 파일의 종류와 속성값 표시
- file <옵션> [파일명]
  - 옵션 : -b(파일 형식만 표시), -f(지정한 파일만 대상으로 실행), -z(압축 파일 내용 표시), -i(MIME으로 출력)
```
    [LinuxMaster]#file hi.txt
    hi.txt: ASCII text
    [LinuxMaster]#file -i hi.txt
    hi.txt: text/plain; charset=us-ascii
    [LinuxMaster]#file -b hi.txt
    ASCII text
```

<br>

### ✔️ find : 지정된 조건에 따라 파일을 검색하는 명령어(지정한 경로 및 하위 경로를 대상으로 검색)
- find <경로> <-옵션> <정규표현식> <파일명>
  - 옵션 : -name(이름으로 검색), -user(사용자의 파일/디렉터리 검색), -perm(권한으로 검색), -type(파일 유형으로 검색), -atime 숫자(숫자 일수 이전에 접근한 파일 검색), -size(파일 크기를 지정하여 검색), -exec(검색 파일을 대상으로 실행할 명령어)
```
    [LinuxMaster]#pwd
    /
    [LinuxMaster]#find -name One
    ./root/Test/One
```

<br>

### ✔️ locate : 파일의 위치 검색
- locate [파일명]

<br>

### ✔️ cat : 파일 내용을 출력
- cat <-옵샨> [파일명]
  - 옵션 : -n(행 번호 표시), -b(행 번호 표시, 비어있는 행 제외), -s(2개 이상 빈 행을 하나로 표시), -A(텍스트 파일의 개행 문자, 탭 문자 등 확인)
```
    [LinuxMaster]#cat -n -s /etc/httpd/conf/httpd.conf
        1 #
        2 # This is the main Apache HTTP server configuration file. It contains the
        3 # configuration directives that give the server its instructions.
        4 # See <URL:http://httpd.apache.org/docs/2.4/> for detailed information.
        5 # In particular, see
        6 # <URL:http://httpd.apache.org/docs/2.4/mod/directives.html>
        ...
```

<br>

### ✔️ head : 파일의 앞 부분만 출력
- head <-옵션> [파일명]
  - 옵션 : -c(지정 숫자 바이트만큼 출력), -n(지정 줄 수 만큼 출력, 기본 10줄)
```
    [LinuxMaster]#head -n 3 /etc/httpd/conf/httpd.conf
    #
    # This is the main Apache HTTP server configuration file. It contains the
    # configuration directives that give the server its instructions.
    [LinuxMaster]#head -3 /etc/httpd/conf/httpd.conf
    #
    # This is the main Apache HTTP server configuration file. It contains the
    # configuration directives that give the server its instructions.
```

<br>

### ✔️ tail : 파일의 마지막 부분만 출력
- tail <-옵션> [파일명]
  - 옵션 : -c(지정 숫자의 바이트만큼 출력), -n(지정 줄 수 만큼 출력, 기본 10줄), -f(새롭게 추가되는 내용을 실시간 출력), -v(파일명 표시), -q(파일명 표시 X)
```
    [LinuxMaster]#tail -3 /etc/httpd/conf/httpd.conf
    #
    # Load config files in th "/etc/httpd/conf.d" directory, if any.
    IncludeOptional conf.d/*.conf
```

<br>

### ✔️ more : 화면 단위로 파일의 내용을 출력
- more <-옵션> [파일명]
  - 옵션 : -숫자(페이지 당 표시할 줄 수)
```
    [LinuxMaster]#more -4 /etc/httpd/conf/httpd.conf
    # This is the main Apache HTTP server configuration file. It contains the
    # configuration directives that give the server its instructions.
    # See <URL:http://httpd.apache.org/docs/2.4/> for deetailed information.
    # In particular, see
    --More--(1%)
```
> 보기 작업 : 다음 페이지(Space), 다음 줄(Enter), 1/2페이지(Ctrl+D), 이전페이지(Ctrl+B), 종료(Q), 문자열 패턴 검색(/패턴)

<br>

### ✔️ less : 텍스트 파일을 한 화면씩 표시
- 특징 : more과 다르게 커서 이동 가능

<br>

### ✔️ wc : 파일의 라인 수, 단어 수, 알파벳 수 표시
- wc <-옵션> [파일명]
  - 옵션 : -l(라인 수 표시), -w(단어 수 표시), -c(알파벳 수 표시)
```
    [LinuxMaster]#cat hi.txt
    hihi
    [LinuxMaster]#wc -w hi.txt
    1 hi.txt
```

<br>

### ✔️ grep : 특정한 문자열 패턴, 정규식을 이용하여 단어 검색
- grep <-옵션> [문자열] [파일명]
  - 옵션 : -r(모든 디렉터리, 파일), -E(정규표현식), -i(대소문자 무시), -v(검색 대상이 포함되지 않은 라인만 표시), -n(라인수 표시), -l(문자열이 포함된 파일명 표시)
```
    [LinuxMaster]#grep chris /etc/passwd
    chris:x:1001:1001::/CHRIS:/bin/bash
    [LinuxMaster]#cat /etc/passwd l grep chris
    chris:x:1001:1001::/CHRIS:/bin/bash
```
> ex) grep '^[AB]' sample.txt (A 혹은 B로 시작하는 모든 라인), grep 'fine$' sample.txt (fine으로 끝나는 모든 라인)

<br>

### ✔️ sort : 정렬하여 표시하는 명령어
- sort <-옵션> [파일명]
  - 옵션 : -b(앞 공백 무시), -o(저장 파일명), -r(역순), -f(대소문자 구분X), -t(필드 구분자 지정), -u(중복행 제거), -m(정렬 파일 병합), -n(숫자만 비교)
```
    [LinuxMaster]#sort -b -u /etc/httpd/conf/httpd.conf | grep '^[a-z|A-Z]'
    AddDefaultCharset UTF-8
    DocumentRoot "/var/www/html"
    EnableSendfile on
    ErrorLog "logs/error_log"
    Group apache
    Include conf.modules.d/*.conf
    ...
```

<br>

### ✔️ cut : 구분자를 이용하여 특정 필드를 추출하는 명령어
- cat <-옵션> [파일명]
  - 옵션 : -b(바이트 수 기준), -c(문자열, 콤마와 하이픈으로 범위 지정), -f(필드 기준), -d(구분 문자, 기본 값은 탭), -z(라인의 구분자로 개행이 아닌 NUL 이용)
```
    [LinuxMaster]#cut -c 1-5 /etc/httpd/conf/httpd.conf|grep '^[a-z|A-Z]'
    Serve
    Liste
    Inclu
    User
    Group
    ...
```

<br>

### ✔️ split : 여러개의 파일로 분리하여 저장
- split <-옵션> [파일명]
  - 옵션 : -b(byte 단위로 분할), -l(라인 수 단위로 분할)
```
    [LinuxMaster]#split -l 30 /etc/httpd/conf/httpd.conf
    [LinuxMaster]#ls
    xaa xab xac xad xae xaf xag xah xai xaj xak xal xam
```

<br>

### ✔️ diff : 파일을 라인 단위로 비교하여 표시
- diff <-옵션> [파일A|디렉터리A] [파일B|디렉터리B]
    - 옵션 : -d(연속 공백 무시), -i(대소문자 구분X), -S(동일한 파일인지 확인), -r(디렉터리 차이점 출력

<br>

### ✔️ cmp : 파일을 바이트(문자) 단위로 비교하여 표시
- cmp <-옵션> [파일A] [파일B]
  - 옵션 : -b(다른 바이트 출력), -l(다른 문자 위치, 문자 출력), -S(비교 결과만 표시)

<br>

### ✔️ comm : 파일을 라인 단위로 비교하여 표시
- comm <-옵션> [파일A] [파일B]
  - 옵션 : -1(파일 A에만 있는 내용 제외), -2(파일 B에만 있는 내용 제외), -3(공통으로 존재하는 내용 제외)

<br>

리다이렉션과 정규 표현식
---
### ✔️ 리다이렉션(redirection) 개념과 활용
- 표준 입력(stdin, standard input, 키보드), 표준 출력(stdout, standard output, 모니터), 표준 에러(stderr, standard error, 모니터)의 방향을 재지정하는 방법
  - 방법 : >(출력 재지정), >>(추가모드로 출력 재지정), <(입력 재지정)
```
    [LinuxMaster]#ls-al>out.txt
    [LinuxMaster]@tail-3 out.txt
    -rw-r--r-- 1 root root 979 1월 8 19:25 xak
    -rw-r--r-- 1 root root 906 1월 8 19:25 xal
    -rw-r--r-- 1 root root 96 1월 8 19:25 xam   
```

<br>

### ✔️ 파이프(pipe) 개념과 활용
- 두개 이상의 명령을 상호 연결하여, 한 명령의 출력을 다른 명령의 입력으로 지정하여 실행하는 방법
  - 방법 : 명령A | 명령B |
```
    [LinuxMaster]#ls-al | grep txt
    -rw-r--r-- 1 root root 0 1월 8 18:23 empty.txt
    -rw-r--r-- 1 root root 0 1월 8 18:14 hello.txt
    -rw-r--r-- 1 root root 5 1월 8 18:27 hi.txt
    -rw-r--r-- 1root root 1006 1월 8 19:45 out.txt
```

<br>

### ✔️ 정규 표현식의 개념과 예
- 특정한 규칙을 갖는 문자열의 집합을 표현하는 데 사용하는 형식 언어
  - 정규 표현식의 예
    - ^(첫글자), $(마지막 글자), .(한글자), *(0회 이상 반복), [](2개 이상 대체 목록, -로 범위 지정), [^](대체하지 못한 글자 목록, -로 범위 지정), +(1회 이상 반복), ?(0 혹은 1개만 존재), ()(부분 정규식의 시작, 끝, |(구분된 단어 중 최소 1개 이상), {m,n}(m개 이상, n개 이하)
    - ex) a..b(a와 b사이에 2개 문자), ab*(b가 0번 이상), [ab]c(ac,bc), [^ab]c(ac, bc는 안됨), ab+(b가 1개 이상), ab?(b가 없거나 1개만 존재), a(bcd)+(bcd가 1번 이상 반복), (a|b)c(a혹은 brk 1개 이상, ac, bc, abc), a{1.2}b(a가 1~2개, ab, aab)

<br>

기타 명령어 - 네트워크 관련 명령어
---
### ✔️ ping - 상대 호스트와 IP 통신이 가능한지 확인하는 명령어
- ping <옵션> [IP주소|도메인명]
    - 옵션 : -c(요청수, 기본 무제한), -i(통신을 위한 신호를 전달하는 시간 간격, 기본 1초), -s(전송할 패킷 크기, 바이트)
```
    [LinuxMaster]

```


<br>
[LinuxMaster]
### ✔️ 
→

















