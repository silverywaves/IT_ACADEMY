# 파일 시스템과 프로세스
권한 및 그룹 설정
---
### ✔️ 리눅스의 파일 권한 관리
- 모든 파일 디렉토리에 접근권한(permission)과 소유권을 설정하여 관리
- 권한 : 사용자, 그룹이 해당 파일을 어떻게 사용할 수 있는지 설정
```
    [LinuxMaster]#ls -al
    합계 24
    drwxr-xr-x 3 root root 4096 1월 10 20:53 .
    dr-xr-x---. 11 root root 4096 1월 10 20:46 ..
    -rw-r--r-- 1 chris chris 12 1월 10 20:53 chrisMsg.txt
    -rwxr-xr-x 1 root root 60 1월 10 20:51 list.sh
    -rw-r--r-- 1 root root 12 1월 10 20:49 msg.txt
    drwxr-xr-x 2 root root 4096 1월 10 20:49 mydirectory
```
> 파일유형+접근권한, 물리적 파일 연결개수 (하드링크), 소유자, 소유 그룹, 크기, 마지막 변경 날짜+시간, 파일명

<br>

### ✔️ chown - 파일(디렉터리)의 사용자(그룹) 소유권 변경
- chown <옵션> [소유자] [;그룹명] [파일명]
  - 옵션 : -R(하위 디렉터리 포함)
```
    [LinuxMaster]#ls -al
    ...
    -rw-r--r-- 1 root root 6 1월 10 21:18 sample.txt
    [LinuxMaster]#chown chris;chris sample.txt
    [LinuxMaster]#ls -al
    ...
    -rw-r--r-- 1 chris chris 6 1월 10 21:18 sample.txt
```

<br>

### ✔️ chgrp - 파일(디렉터리)의 그룹 소유권 변경
- chgrp <옵션> [그룹명] [파일명]
  - 옵션 : -R(하위 디렉터리 포함)

<br>

### ✔️ chmod - 파일(디렉터리)의 접근 권한 변경
- chmod <옵션> [권한] [파일명]
  - 옵션 : -R(하위 디렉터리 포함)
- chmod 명령의 다양한 사용 방식
  - ex) chmod+x file, chmod -x file, chmod u+x file, chmod g=rx file, chmod o-x file, chmod a+r file, chmod 766 file

<br>

### ✔️ umask - 파일/디렉터리 생성시 기본으로 적용할 접근 권한 지정
- 주의 : 파일은 '666 - umask' 값, 디렉터리는 '777 - umask' 값으로 설정
- umask <옵션> [설정값]
  - 옵션 : -S(문자로 표시)
```
    [LinuxMaster]#umask
    0022
    [LinuxMaster]#umask 002
    [LinuxMaster]#touch new.txt
    [LinuxMaster]#ls -al
    ...
    -rw-r--r-- 1 root root 12 1월 10 20:49 msg.txt
    -rw-rw-r-- 1 root root 0 1월 10 22:38 new.txt
```

<br>

### ✔️ 리눅스 파일의 특수 권한
- 대상 파일을 사용하는 프로세스가 실행되는 동안 설정된 접근권한으로 전환하여 사용하는 특징 → 유효사용자/유효그룹이 변경
  - SetUID : 소유자 권한으로 실행(4000)
  - SetGID : 소유 그룹 권한으로 실행(2000)
  - s(실행파일), S(일반파일)
```
    [LinuxMaster]#chmod u+s test.sh
    [LinuxMaster]#ls -al text.sh
    -rwsr-xr-x 1 root root 60 1월 10 23:11 test.sh
    [LinuxMaster]#chmod 2644 test.sh
    [LinuxMaster]#ls -al test.sh
    -rw-r-Sr-- 1 root root 60 1월 10 23:11 test.sh
```
- (공유) 폴더에 대하여 소유자 혹은 root만 파일을 수정하거나 삭제할 수 있는 특징
  - Sticky bit(1000)
  - t로 표시
```
    [LinuxMaster]#mkdir tmp
    [LinuxMaster]#chmod +t tmp
    [LinuxMaster]#ls -al
    ...
    drwxrwxr-t 2 root root 4096 1월 10 23:16 tmp
```

<br>

### ✔️ 디스크 쿼터(Disk Quota)
- 사용자(그룹)이 파일 시스템에서 생성(사용)할 수 있는 파일의 용량(개수)
  - inode 개수 제한, 할당된 디스크 블록 수 제한 → 사용자(그룹)별, 파일 시스템별 동작
- 디스크 쿼터 설정 파일 및 관련 명령어
  - 설정 파일(/etc/fstab), 사용자 쿼터 파일(aquota.user), 그룹 쿼터 파일(aquota.group)
  - 마운팅, 재마운팅 : mount -o remount /QUOTA
  - quotaoff(비활성화), quotaon(활성화), quotacheck(파일시스템의 디스크 사용 상태 점검)
  - setquota(명령어를 이용한 사용자/그룹 쿼터 설정), edquota(편집기를 이용한 사용자/그룸 쿼터 설정)

<br>

파일 시스템의 관리
---
### ✔️ 파일 시스템 개요
-  스토리지 장치(디스크) 상에 파일을 관리할 수 있도록 만들어놓은 구조 혹은 관리하는 방식 → 서버 파일 접근, 가상 파일까지 확대
-  리눅스 파일 시스템 구조
  - Super Block (파일 시스템 관련 정보, 블록크기 및 개수, inode 개수), Group Descriptor Table(Block 그룹 관리)
  - Block Bitmap(블록의 사용 상태), inode(파일 이름을 제외한 정보, 고유번호, 파일 형태, 크기, 위치, 소유자 등)

<br>

### ✔️ 리눅스 파일 시스템 종류와 특징(네트워크 파일 시스템)
|파일 시스템|설명|
|:-:|-|
|ext(ext1)|- 리눅스 초기에 사용되던 파일 시스템이며 호환성이 없음<br>- ext2의 원형<br>- 2GByte의 데이터와 파일명을 255자까지 지정 가능<br>- 파일 접근에 대한 타임 스탬프, 아이노드 수정 지원 불가|
|ext2|- ext 파일 시스템의 다음 버전<br>- 고용량 디스크 사용을 염두하고 설계된 파일 시스템<br>- 쉽게 호환되며 업그레이드도 쉽게 설계되어있음|
|ext3|- ext2의 확장판<br>- 리눅스의 대표적인 저널링(jornaling)을 지원하도록 확장된 파일 시스템<br>- ACL(Access Control List)를 통한 접근 제어 지원|
|ext4|- ext2 및 ext3와 호환성이 있는 확장 버전<br>- 파일에 디스크 할당 시 물리적으로 연속적인 블록을 할당<br>- 64비트 기억 공간 제한을 없앰<br>- 16 TeraByte의 파일을 지원|
|JFS|- Journaling File System 약자<br>- IBM사의 독자적인 저널링 파일 시스템<br>- GPL로 공개하여 현재 리눅스용으로 개발|
|xfs|- eXetended File System<br>- 고성능 저널링 시스템<br>- 64비트 주소를 지원하며 확장성 있는 자료 구조와 알고리즘 사용<br>- 파일 수에 관계없이 예상치 못한 상황으로부터 신속한 복구와 재시작 가능<br>- 데이터 읽기/쓰기 트랜잭션으로 성능 저하를 최소화<br>- 64비트 파일 시스템으로 큰 용량의 파일도 다룰 수 있음<br>- 높은 확장성과 처리량을 가짐|
|ReiserFS|- 독일의 한스 라이저(Hans Reiser)가 개발한 파일 시스템<br>- 리눅스용 저널링 파일 시스템 중에서 가장 안정적이라는 평가를 받음<br>- 모든 파일 객체들을 B트리에 저장, 간결한 색인화 된 디렉터리 지원|
|SMB|- 삼바(samba) 파일 시스템을 마운트 지정<br>- Server Message Block(서버 메시지 블록)<br>- 윈도우 계열 OS 환경엥서 사용되는 파일/프린터 공유 프로토콜<br>- 리눅스, 유닉스 계정 OS와 윈도우 OS와의 자료 및 하드웨어 공유<br>- 윈도우에서 표준 클라이언트 환경으로 처음부터 구성되었고 NFS 유닉스 표준 응용부터 운용상 쉽다는 장점이 있음|
|CIFS|- Common Internet File System<br>- SMB를 확장한 파일 시스템<br>- SMB를 기초로 응용하여 라우터를 뛰어넘어 연결할 수 있는 프로토콜|
|NFS|- Network File System(네트워크 파일 시스템)<br>- 썬마이크로시스템(SUN)이 개발한 네트워크 공유 프로토콜<br>- 파일 공유 및 파일 서버로 사용됨<br>- 공유된 영역을 마운트할 때 지정<br>- 하드웨어, 운영체제 또는 네트워크 구조가 달라도 공유 가능<br>- NFS 서버의 특정 디렉터리를 마운트하여 사용할 수 있음|

<br>

### ✔️ 리눅스 파일 시스템 종류와 특징(지원 가능한 기타 파일 시스템)
|파일 시스템|설명|
|:-:|-|
|FAT|- Windows NT가 지원하는 파일 시스템 중 가장 간단한 시스템<br>- FAT로 포맷된 디스크는 클러스터 단위로 할당<br>- 클러스터 크기는 볼륨 크기에 따라 결정<br>- 읽기 전용, 숨김, 시스템 및 보관 파일 특성만 지원<br>- 삼바(samba) 파일 시스템을 마운트 지정|
|VFAT(Virtual FAT)|- FAT 파일 시스템이 확장된 것으로 FAT와 호환<br>- FAT보다 제한이 적음<br>- 파일 이름도 최고 255자까지 만들 수 있음<br>- 공백이나 여러 개의 구두점도 포함<br>- 대소문자는 지정한대로 보존되기는 하나 구별하지는 않음|
|FAT32|- SMB를 확장한 파일 시스템<br>- Windows 95, 98 및 ME과 같은 버전과 다중 부팅 구성<br>- 32GB보다 큰 파티션을 만들 수 없고 파티션에 4GB를 초과하는 파일을 저장할 수 없음|
|NTFS|- 윈도우에서 사용하는 파일 시스템<br>- 안정성이 뛰어나고 대용량 파일도 저장<br>- 안정성, 자세한 사용자 제한, 보안성 등이 FAT32보다 뛰어남<br>- 파일 크기 및 볼륨은 이론상으로 최대 16EB(ExaByte=10의18승byte)이나 실질적으로는 2TB로 한계가 있음|
|ISO 9660|- CD-ROM의 표준 파일 시스템<br>- 1988년에 제정된 표준|
|UDF|- Universal Disk Format의 약자로 최신 파일 시스템 형식<br>- OSTA(Optical Storage Technology Association)에 의해 개발<br>- 광학 매체용 파일 시스템 표준<br>- ISO 9660 파일 시스템을 대체하기 위한 것으로 대부분 DVD에서 사용<br>- DVD 멀티미디어 디스크들은 MPEG 오디오 및 비디오 스트림을 담기 위해 사용|
|HPFS|- OS/2 운영체제를 위해 만들어진 파일 시스템<br>- 1988년 발표, 마이크로소프트와 IBM이 공동 개발|

<br>

### ✔️ mount - (스토리지) 장치를 연결하여 디렉토리처럼 사용
- 설정 파일 : /etc/fstab (부팅시 참조하여 마운트), /etc/mtab (마운트된 블록 시스템 정보)
- mount <옵션> [장치명] [디렉터리명]
  - 옵션 : -a(/etc/fstab의 내용 모두 마운트), -n(/etc/mtab 설정정보 기록 안함), -f(마운트 테스트), -t(파일 시스템), -o(remount, ro, rw, sync, noatime 등 추가 설정)

<br>

### ✔️ unmount - 마운트를 해제하는 명령어
- unmount <옵션> [장치명] [디렉터리명]
  - 옵션 : -a(/etc/fstab의 내용 모두 마운트 gowp), -n(/etc/mtab 설정정보 기록 안함), -t(파일 시스템)

<br>

### ✔️ eject - (미디어) 장치를 해제하고 장치 제거
- eject <옵션> [장치명]
  - 옵션 : -r(CD-ROM 장치), -f(Floppy 장치)

<br>

### ✔️ mkfs - 파일 시스템 생성
- mkfs <옵션> [장치명]
  - 옵션 : -V(자세한 정보 표시), -t(파일 시스템), -c(Bad Block 검사), -l(지정한 파일명에서 Bad Block 목록 읽기), -v(진행 상태 표시)

<br>

### ✔️ mk2fs - ext2, ext3, ext4 리눅스 파일 시스템 생성
- mk2fs <옵션> [장치명]
  - 옵션 : -t(파일타입), -b(블록 크기, 바이트), -i(inode 당 바이트 수), -j(저널링 파일 시스템 ext3), -R(RAID4)

<br>

### ✔️ fsck - 파일시스템 점검 및 복구
- /lost+found 디렉터리에 손상된 파일 관리 → 정상 복구 된 후 삭제
- fsck <옵션> [장치명]
  - 옵션 : -A(/etc/fstab의 모든 시스템 점검), -a(자동 복구), -r(확인 후 복구), -t(파일 시스템)

<br>

### ✔️ e2fsck - ext2, ext3, ext4 리눅스 파일 시스템 점검 및 복구
- e2fsck <옵션> [장치명]
  - 옵션 : -p(자동 복구), -n(모든 확인에 no로 응답), -y(모든 확인에 yes로 응답), -c(Bad Block 점검), -f(문제가 없는 시스템까지 강제 점검)

<br>

### ✔️ du - 디렉터리 별 디스크 사용량 확인
- du <옵션> [파일/디렉터리]
  - 옵션 : -n(용량 단위로 표시, -a(모든 파일 대상), -m(MB 단위로 표시), -k(KB 단위로 표시), -s(총 합계만 표시), -c(사용정보 표시 후 합계 표시)
```
    [LinuxMaster]#du master/
    4  master/tmp
    8  master/mydirectory
    32 master/
```

<br>

### ✔️ df - 마운트 된 저장장치의 용량 표시 → 파티션 단위로 사용량 확인, 기본 1024byte 블록단위 출력
- df <옵션> [파일명]
  - 옵션 : -n(용량 단위로 표시), -T(파일시스템 유형 정보, 파티션 정보), -t(표시 파일 시스템 유형), -a(모든 파일 시스템), -k(--block-site=1K), -i(inode 사용률)
```
    [LinuxMaster]#df
    Filesystem  1K-blocks  Used Available Use% Mounted on
    devtmpfs    496808    0    496808  0% /dev
    tmpfs      507252    0    507252  0% /dev/shm
    tmpfs      507252    51312    455940  11% /run
    tmpfs      507252    0    507252  0% /sys/fs/cgroup
    /dev/vda2    103077796  5635476  93022332  6%  /
    tmpfs      101452    0    101452  0%  /run/user/0
```

<br>

### ✔️ /etc/fstab - 파일 시스템 정보 저장 및 관리하는 설정 파일, 부팅 시 마운트 정보 포함
```
    [LinuxMaster]#cat /etc/fstab
    
    #
    # /etc/fstab
    # Create by anaconda on Web Nov 25 03:32:03 2020
    #
    # Accessible filesystems, by reference, are maintained under '/dev/disk'
    # See man pages fstab(5), findfs(8), mount(8) and.or blkid(8) for more info
    #
    UUID=e29905e8-a03a-448f-836c-bafc868a02a3/      ext4  defaults  1 1
    /var/spool/swap/swapfile  none  swap  defaults  0 0
```

<br>

셸(Shell)과 환경 설정
---
### ✔️ 리눅스의 셸(Shell)의 개요
- 명령어 해석기 : 사용자의 명령어 ↔ 커널
  - 로그인 시 사용자별 셸 지정
  - 리다이렉션, 파이프, 셸 스크립트, 포그라운드/백그라운드 프로세스 실행
- 셸의 분류
  - 본셸(Bourne Shell) : $프롬프트 → korn shell, bash shell(리눅스 표준셸, POSIX 호환), z shell(확장 기능 제공)
  - C셸 : %프롬프트 → tc shell (BSD 계열에서 많이 사용, 명령어 편집 기능)
- 사용할 수 있는 셸의 목록과 설정
  - /etc/shells
  - /etc/passwd 의 마지막 필드
```
    [LinuxMaster]#cat /etc/shells
    /bin/sh
    /bin/bash
    /usr/bin/sh
    /usr/bin/bash
    ...
    [LinuxMaster]#echo $SHELL
    /bin/bash
```

<br>

### ✔️ 환경변수와 셸 변수의 특징
|환경 변수(전역 변수)|셸 변수(지역 변수)|
|:-:|:-:|
|전체 셸에서 사용 가능한 전역 변수|현재 로그인 셸에서만 사용 가능한 지역 변수|
|서브 셸에 기능 상속 가능|서브 셸에 기능 상속 불가능|
|환경 변수 확인 명령 : env|셸 변수 확인 명령 : set|

- 주요 환경 변수
  - PATH, HOME, HOSTNAME, USER, DISPLAY, PS1, PWN, SHELL, TERM, TMOUT, LANG, PRINT, MAIL
- 환경 변수의 설정과 해제
  - 설정 : export 변수명=값 → $변수명으로 참조
  - 해제 : unset 변수명

<br>

### ✔️ 환경 설정 파일 - 셸 시작 시 참조하여 자동 실행
- 주요 환경 설정 파일(bash shell)
  - 공통 설정 : /etc/profile, /etc/bashrc
  - 사용자 설정 : ~/.bash_profile(로그인시), ~/.bash_history(명령어 재사용), ~/.bashrc(alias와 자동실행), ~/.bash_logout(로그아웃 직전)
- /etc/profile.d : 특정 응용 프로그램 시작 시 자동 실행할 스크립트 경로 저장

<br>

### ✔️ History 기능 - .bash_history에 저장된 명령어 재사용
- 사용방법
  - history : 명령어 목록 출력
  - 상/하 화살표 → 이전/이후 명령어
  - !!(마지막 명령어), !n(n번째 명령어), !-n(현재 이전 n번째 명령어), !string(string으로 시작하는 최근 명령어), !$ 혹은 !!$(마지막 명령의 인자), !*(마지막 명령의 모든 인자), !?string?(string을 포함하는 가장 최근 명령어)
- History 관련 환경 변수
  - HISTSIZE, HISTFILESIZE, HISTTIMEFORMAT, HISTCONTROL

<br>

프로세스 개념과 관련 명령어
---
### ✔️ 프로세스 개요
- 프로그램이 실행된 상태 → CPU 메모리 등 자원을 할당받아 실행된 상태
  - PID(Process ID)로 관리, init(최초 실행 프로세스, PID는 1) → CentOS7부터 systemd가 최초 실행되면 PID가 1이 됨
- 프로세스의 유형
  - 포그라운드 프로세스(Foreground)
    - 사용자와 상호작용하는 프로세스
    - 터미널에 직접 연결되어 입출력을 주고받는 프로세스
    - 명령 입력 후 수행 종료까지 기다려야하는 프로세스
    - 화면에서 실행되는 것이 보이는 프로세스
    - ex) 응용프로그램, 명령어 등
  - 백그라운드 프로세스(Background)
    - 사용자와 직접적인 대화를 하지 않고 뒤에서 실행되는 프로세스
    - 사용자의 입력에 관계없이 실행되는 프로세스
    - 실행은 되지만 화면에 나타나지 않고 실행되는 프로세스
    - ex) 시스템 프로그램, 데몬 등

<br>

### ✔️ 프로세스 실행 방식 및 관련 용어
- fork()
  - 기본 프로세스를 복제하여 실행 → 부모 프로세스와 자식 프로세스의 관계
- exec()
  - 새로운 프로세스로 변경되어 실행 → 하나의 프로세스만 남게 됨
- 데몬(deamon)
  - (부팅시 자동으로 실행되는) 백그라운드 프로세스
  - 일반적으로 서비스에 대한 요청을 담당
  - 데몬 실행 방법
    - Stand Alone(메모리에 단독 상주, httpd 등)
    - inetd 타입 데몬(커널 2.4부터 xinetd 슈퍼 데몬에 의해 실행, FTP 등)
    - CentOs7 부터는 systemd 에 의해 관리
- 시그널(Signal)
  - 프로세스에게 전달할 수 있는 이벤트(신호) → kill 명령 사용, kill -l로 가능한 시그널 목록 확인
  - 대표적인 시그널 : SIGINT(2), SIGKILL(9), SIGTERM(15), SIGSTOP(19), SIGSTP(20, CTRL+Z, 대기 전환)

<br>

### ✔️ ps - 실행 중인 프로세스의 목록/상태 정보 표시 → CPU 사용도가 낮은 순
- ps <옵션>
  - 옵션 : a(실행 중인 모든 프로세스), e(모든 프로세스), u(사용자 이름, 시작 시간), x(터미널 정보, 모든 프로세스), l(상세 정보 표시)

<br>

### ✔️ pstree - 실행 중인 프로세스의 목록을 tree 형식으로 표시
- pstree <옵션>
  - 옵션 : -p(PID 표시), -n(PID 정렬), -a(명령 인자 포함), -h(현재 프로세스와 부모 프로세스 강조)

<br>

### ✔️ jobs - 작업(프로세스)의 동작 상태 표시
- jobs <옵션> <작업번호>
  - 옵션 : -l(프로세스 그룹 ID 표시), -n(프로세스 그룹 중 대표 PID 표시), -p(PID를 한 라인씩 표시)

<br>

### ✔️ fg - 백그라운드에서 포그라운드로 작업 전환
- fg <작업번호> → 작업 번호가 없을 경우 현재 백그라운드 작업을 대상으로 함

<br>

### ✔️ 프로세스 관리 명령의 사용 예
```
    [LinuxMaster]#ping 8.8.8.8 > NULL &
    [1] 8480
    [LinuxMaster]#jobs
    [1]+ Running    ping 8.8.8.8. > NULL &
    [LinuxMaster]#fg
    ping 8.8.8.8. > NULL
    ^Z
    [1]+ Stopped    ping 8.8.8.8. > NULL
    [LinuxMaster]#fg
    ping 8.8.8.8. > NULL
    ^C[LinuxMaster]#
```

<br>

### ✔️ kill - 프로세스에 시그널(이벤트) 전달
- kill <옵션> <PID|작업번호>
  - 옵션 : -l(시그널 종류), -s(시그널 번호 혹은 시그널 이름 지정), -1(HUP, 재시작), -9(SIGKILL, 강제종료)

<br>

### ✔️ killall - 동일한 데몬의 여러 프로세스를 한번에 종료
- killall <옵션> [프로세스명]
  - -g(그룹 지정), -i(확인 후 종료), -l(시그널 목록), -v(상세 정보)

<br>

### ✔️ kill 명령의 사용 예
```
    [LinuxMaster]#ping 8.8.8.8 > NULL &
    [1] 8898
    [LinuxMaster]#ps -al
    F S  UID  PID  PPID  C  PRI  NI  ADDR  SZ  WACHAN  TTY  TIME  CMD
    4 S   0  8898  15610 0  80   0  -32139  poll_s  pts/0 00:00:00 ping
    0 R   0  8907  15610 0  80   0  -38332  -      pts/0  00:00:00 ps
    [LinuxMaster]#kill 8898
    [LinuxMaster]#ps -al
    F S  UID  PID  PPID  C  PRI  NI  ADDR  SZ  WACHAN  TTY  TIME  CMD
    0 R   0  8907  15610 0  80   0  -38332  -      pts/0  00:00:00 ps
    [1]+ 종료됨    ping 8.8.8.8 > NULL
```

<br>

### ✔️ nice - 우선순위 변경(설정)하여 프로세스 실행 → NI 값 이용
- nice <옵션> [프로세스명]
  - 옵션 : -n 조정값, -조정값, --adjustment 조정값 → 기본 조정값은 10
  - NI 값 범위 : -20 ~ 19
  - 일반 사용자는 NI값 증가만 가능

<br>

### ✔️ renice - 실행 중인 프로세스의 우선순위 변경
- renice <옵션> <NI값> [PID]
  - -p(PID 지정), -u(사용자 지정), -g(GID 지정)

<br>

### ✔️ top - 시스템 운영 상태 혹은 프로세스 상태 확인
- top <옵션> [PID]
  - 옵션 : -d(실시간 화면 출력 시간 지정, 기본 5초), -p(PID 지정)\
```
top - 02:35:07 up 126 days, 18 min, 1 user, load average : 0.00, 0.01, 0,05
Tasks: 99 total, 1 running, 98 sleeping, 0 stopped, 0 zombie
%Cpu(s): 0.0 us, 0.0 sy, 0.0 ni, 100.0 id, 0.0 wa, 0.0 hi, 0.0 si, 0.0 st
MiB Mem: 990.7 total, 160.8 free, 221.8 used, 608.2 buff/cache
MiB SwapL 2048.0 total, 2004.0 free, 44.0 used, 559.4 avail Mem

PID USER  PR  NI  VIRT  RES  SHR S  %CPU %MEM  TIME+ COMMAND
9  root  20  0  0    0  0  S  0.3 0.0 105:16. 18 rcu_sched
...
```

<br>

### ✔️ nohup - 프로세스 중단없이 백그라운드로 작업 실행 → 로그아웃되어도 계속 실행
- 표준 출력 내용을 nohup.out에 기록
```
    [LinuxMaster]#nohup ping 8.8.8.8 &
    [1] 11121
    [LinuxMaster]#nohup:ignoring input and appending output to 'nohup.out'
    ^C
```

<br>

### ✔️ cron - crond 데몬에 의해 반복적인 작업 실행
- 설정 파일 : /etc/crontab
- 관련 명령 > crontab <옵션> [파일명]
  - 옵션 : -l(설정 내용 출력), -e(crontab 작성, 수정), -r(crontab 내용 삭제), -u(지정한 사용자의 스케쥴 수정)







