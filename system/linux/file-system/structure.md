## File system

운영체제에서 데이터를 저장 장치에 파일로 저장하고 관리하는 방법을 정의한 시스템

특정 구조를 따르는 계층적 데이터 저장소

## Linux - Windows file system

윈도우 : 물리 저장 장치마다 이름(C, D)을 할당하고 각 장치마다 별도의 디렉토리 구조를 가짐  

리눅스 : 모든 물리적 장치를 하나의 가상 디렉토리로 관리

리눅스의 파일 시스템은 [다음](https://linux-kernel-labs.github.io/refs/pull/187/merge/labs/filesystems_part1.html#virtual-filesystem-vfs)과 같이 기능적인 관점에서 3가지로 분류할 수 있음
* disk file systems (ext3, ext4, xfs, fat, ntfs, etc.)
* network file systems (nfs, smbfs/cifs, ncp, etc.)
* virtual filesystems (procfs, sysfs, sockfs, pipefs, etc.)

## File

하나의 디렉토리로 모든 저장 장치(storage device)를 관리할 수 있는 이유

리눅스(Unix-like OS)는 유닉스 파일 시스템 철학인 '모든 것은 파일이다'를 기반으로 하여

하드웨어 장치, 네트워크 소켓, 파이프 등 시스템의 모든 요소를 파일로 추상화함  
-> 파일 입출력을 통해 다양한 시스템 리소스를 통일된 방식으로 다룸

따라서 리눅스의 모든 저장 장치마다 하나의 파일로 취급하고, 이를 하나의 디렉토리(/dev)에서 관리함

## Device

I/O 작업을 수행하는 물리적인 장치이며 /dev 디렉토리에 위치함(I/O 작업 시 /dev에 접근)

keyboard - input device

hard disk - input/output device 

**유형**  

* Character device
    * 문자 단위로 I/O 작업을 처리하는 디바이스
    * 키보드, 마우스 등
    * 마우스 클릭마다 /dev/mouse 장치에 문자(click) 전송
* Block device
    * 문자 단위보다 훨씬 큰 단위로 데이터를 읽는 디바이스
    * IDE 하드 드라이브(/dev/hd), SCSI 하드 드라이브(/dev/sd), CD-ROMS(/dev/cdrom) 등
* Special device
    * /dev/null : 휴지통 용도, output으로 출력되지 않음
    * /dev/zero :  무한히 0으로 채워진 파일처럼 동작함, 디스크를 0으로 채우거나 메모리 상의 값들을 초기화하는 데 사용됨
    * /dev/full : 이 파일에 쓰는 작업을 하면 디스크가 가득 찼다는 에러를 발생시킴
    * /dev/random : 난수 생성

**이름**  
보통 디바이스의 타입으로 이름을 따서 지음

같은 유형의 디바이스가 여러 개가 있다면 번호를 붙임

/dev/fb : frame buffer (그래픽용 프레임 버퍼)  
/dev/hda, /dev/hda1, /dev/hdb, /dev/hdb2 : IDE 하드 드라이브

하드 디스크 이름의 경우 디스크의 위치(a,b..)와 파티션(1,2..)으로 구성됨

심볼릭 링크를 사용하는 경우도 있음  
/dev/mouse : 마우스를 나타내며 Serial, PS2 또는 USB 장치에 연결됨

## VFS

모든 저장 장치를 하나의 디렉토리로 관리하지만, 저장 장치마다 포맷된 파일 시스템이 상이할 수 있음

파일 작업(open, read, write, stat, chmod)을 추상화하여 사용자(User)가 일관된 방식으로 접근할 수 있도록 하는 것이 VFS임

VFS는 사용자와 특정 파일 시스템 사이에서 동작하며 파일 시스템에 관련된 모든 system call을 다룸

[Virtual File System(VFS)](https://www.kernel.org/doc/html/latest/filesystems/vfs.html) 구조

[Linux file system high level architecture](https://developer.ibm.com/tutorials/l-linux-filesystem/)

```

==========User Space==========

User application, GNU C Library

==============================

             |
             v

=========Kernal Space==========

    System call interface (funneling)

            |
            v

 VFS - (Inode cache, Dentry cache)

            |
            v

   Individual file system

            |
            v

       Buffer Cache

            |
            v

     Device Drivers

==============================

```

## 범용 파일 시스템 메타데이터 요소

[superblock, inode, file, dentry](https://linux-kernel-labs.github.io/refs/pull/187/merge/labs/filesystems_part1.html#the-general-file-system-model)

**superblock**
마운트된 파일 시스템에 관한 정보(inode, block 위치)

실제 물리 디스크의 첫 번째 블록이 superblock에 대응됨

보관하는 정보
* 파일 시스템 block 사이즈
* 파일 최대 이름 길이, 최대 파일 사이즈 
* root inode 위치

**inode(index node)**  
파일에 대한 일반적인 정보

일반 파일, 디렉토리, 특수 파일(pipe, fifo), block device, character device, 링크 등 파일로 추상화할 수 있는 것들은 모두 inode를 가진다

superblock처럼 실제 물리 디스크에 inode에 대한 특수 블록이 존재함(실제 데이터가 저장되는 블록과 분리)

보관하는 정보
* 파일 유형(type)
* 파일 사이즈
* 접근 권한(access rights)
* 접근, 수정 시각
* 파일의 데이터가 있는 디스크 위치(pointer)

inode는 파일 이름을 가지고 있지 않음

파일 이름은 dentry에 보관되어 있음, 따라서 inode에 대한 여러 개의 이름을 가질 수 있음(hardlink)

**file**  
파일 구조체로서 열려진 파일의 상태나 정보를 추상화하여 관리함

메모리 상에서 VFS 엔티티로만 존재하고 disk에 저장되지 않음

inode에서 실제 파일 데이터의 위치를 가리키고, file은 열린 파일과 관련된 정보를 가지고 있음

이를 통해 사용자가 파일을 쉽게 다룰 수 있도록 함

보관하는 정보
* 파일 커서 위치
* 열기 권한
* 연관된 inode를 가리키는 포인터

file 구조체 -> inode -> disk에 위치한 데이터

**dentry(directory entry)**  
inode와 파일 이름을 연결하는 요소

dentry는 두 개의 필드를 가지고 있음
* inode 식별자(integer)
* 이름(string)

경로(path)의 특정 부분을 나타냄

/bin/vi라는 경로에 대해선 /, bin, vi를 위한 3개의 dentry 객체가 생성됨

inode와 파일 이름을 연결하는 정보는 디스크에 존재하지만 dentry 구조체 자체는 메모리 상에서만 존재  
(파일 시스템 종류에 따라 실제 파일 시스템 구조와 dentry 사이의 대응관계가 다르기 때문)
