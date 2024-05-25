## Structure

리눅스 파일 시스템은 트리와 비슷한 계층적인 구조를 가짐

최상단에 root(/) 디렉토리가 있고, 모든 파일과 디렉토리는 root 하위에 위치함

```

/ (root)

/home  /usr  /etc  /opt  /root  /lib  /boot  /sbin  /bin  /var  /mnt  /media  /dev  /tmp
         |                                                  |
/bin /local /sbin /include                       /tmp /log /cache /spool

```

/bin (Essential User Binaries) : ls, cp, mv, cat 등 기본적인 바이너리 파일이 있는 디렉토리

/boot (Boot Loader Files) : boot loader가 os를 load하기 위한 파일들(kernal, initial ram dis, boot loader configuration file)이 있는 디렉토리

/dev (Device Files) : 하드웨어 장치, 드라이버에 대한 파일이 있는 디렉토리, 하드웨어 장치와 직접적인 상호작용을 할 수 있음

/etc (Configuration Files) : 시스템에 설치된 애플리케이션, 시스템(network, user account) 등에 대한 설정 파일이 있는 디렉토리

/home (User Home Directorise) : 시스템의 사용자마다 주어지는 디렉토리

/lib (Essential Shared Libraries) : 시스템 바이너리나 애플리케이션에서 필요로 하는 공유 라이브러리

/media (Removable Media) : USB 드라이브, CD-ROM, DVD 같은 이동식 미디어를 마운트하는 데 사용되는 디렉토리

/mnt (Mount Point for File Systems) : 여러 파일 시스템(network, disk)을 마운팅하는 데 사용되는 디렉토리

/opt (Optional Software) : Optional 소프트웨어가 있는 디렉토리 - 패키지 관리자에 포함되지 않은 소프트웨어를 설치하는 데 사용할 수 있다

/proc (Process Information) : 시스템 및 실행 중인 프로세스에 대한 파일(virtual file)이 있는 디렉토리

/root (Home Directory for root User) : root user에 대한 home 디렉토리(시스템 관리자)

/run (Runtime Data) : 시스템 및 애플리케이션에 대한 런타임 데이터(system log, process ID, 기타 임시 파일 등)가 있는 디렉토리

/sbin (System Binaries) : 시스템 관리 작업(fdisk, iptables 등)에 사용되는 바이너리 파일이 있는 디렉토리 

/src (Service Data) : 웹사이트, FPT 서버 등 로컬 서비스에 대한 데이터가 있는 디렉토리

/tmp (Temporary Files) : 애플리케이션이 임시적으로 생성하고 사용하는 파일이 있는 디렉토리

/usr (User Binaries and Libraries) : 사용자 수준의 바이너리 파일 및 라이브러리(GNU 유틸리티 등)

/var (Variable Data) : 시스템 로그, 메일함, spool file과 같이 자주 변경되는 파일이 있는 디렉토리






