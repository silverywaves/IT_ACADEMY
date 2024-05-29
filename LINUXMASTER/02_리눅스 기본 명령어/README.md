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



[LinuxMaster]
### ✔️
→

















