Basic
* [Configuration](#configuration)
* [Help](help)
* [Modes](#modes)
    * [Visual Mode](#visual-mode)
* [Seaching](#searching)

Movement
* [Movement](#movement)
* [Jump](#jump)

Edit
* [Writing](#writing)
* [Copy, Paste, Cut](#copy,-paste,-cut)
* [Undo, Redo](#undo,-redo)
* [Repeat](#repeat)

File
* [Save](#edits)
* [Windows](#Windows)
* [Buffers](#buffers)
* [Tabs](#tabs)

* [Marks](#marks)
* [Filtering](#filtering)
* [Multiple Files](#multiple-files)

* [Macro](#macro)
* [Digraphs](#digraphs)
* [Command for Programming](#command-for-programming)
* [Mapping](#mapping)
* [Key Mapping](#key-mapping)
* [Fording](#folding)
* [Formatting, Linting](#formatting,-linting)
* [Language Server Protocol](#language-server-protocol)
* [Vim Scripts](#vim-scripts)

## Configuration

vim 설정 파일(수동 생성) : ~/.vimrc

:set : vim 파일에 적용된 설정 값 표시

:set {option}? : 특정 설정 값이 적용됐는지 확인

### Highlighting

hl - highlighting

:set hlsearch : 하이라이팅 켜기

:set nohlsearch : 하이라이팅 끄)기

:nohlsearch : 현재 검색된 문자열만 하이라이팅 끄기

### Incremental Searches

원래는 검색할 문자열을 모두 입력하고 엔터를 눌러야 검색이 됨

Incremental Search의 경우 문자열 검색 시 바로 검색됨(highlighting을 켜야 표시됨)

inc : incremental

:set incsearch : incremental search 켜기

:set noincsearch : incremental seach 끄기


## Modes

vim은 mode-based workflow를 가지는 텍스트 에디터임(modal text editor)

일반적인 text editor처럼 키 입력이 텍스트로 간주되어 텍스트 파일에 입력되지 않고

각 키 입력(keystroke)이 vim 명령(command)과 짝을 이룸 

vim은 각 모드에 따라 사용자 입력과 처리를 진행함

### Normal mode

파일을 열거나 다른 모드에서  ESC, Ctrl + [ 키를 누르면 Normal mode가 됨

매핑된 키를 누르면 명령 실행 또는 다른 모드로 전환

### Insert mode

입력 모드

Normal mode에서 i 입력

### Visual mode

키보드로 텍스트를 선택할 수 있는 모드

v : visual 모드

V : visual line 모드

CTRL + v : visual block 모드

### Select mode

Visual mode와 비슷하게 텍스트를 선택하지만

select mode는 선택된 텍스트들을 삭제하고 insert mode로 변경함

#### Command line mode

단순 키 매핑이 아닌 텍스트 기반 명령을 수행할 수 있는 모드

4가지 옵션
* :    - ex 명령 
* ?, / - 검색
* !    - filtering

## Help

:help <query>, :h <help> : 도움말 보기

텍스트 선택 + K : 해당 단어에 man 명령 적용

## Searching

### Simple Searches 

* : 커서가 있는 라인에 포함된 단어 검색

/pattern: 문자열 검색, 엔터 입력 시 문자열 입력 종료

/pattern\`*[]^%?~$` : 특수문자([]^%?~$`)를 포함해서 검색할 경우 특수문자 앞에 \ 명시

n : 검색된 다음 문자열로 이동

shift + n : 검색된 이전 문자열로 이동

? : 역방향 문자열 검색

/<Up>, /<Down> : 검색 history 보기

### Incremental Searches

Incremental Searches : 입력과 동시에 검색(원래는 엔터를 입력해야 됨)

:set incsearch : incremental search 켜기

:set noincsearch : incremental seach 끄기

### Regular Expressions

^ : 라인 시작, /^the - 라인 맨 앞에서 the로 시작하는 문자열 검색

$ : 라인 끝, /the% - 라인 맨 뒤에서 the로 끝나는 문자열 검색

. : 아무 단일 문자열 매칭, /t.e - the, tae 등의 문자열 검색

### Highlighting

:set hlsearch : 검색어 하이라이팅 켜기

:set nohlsearch : 검색어 하이라이팅 끄)기

:nohlsearch : 현재 검색된 문자열만 하이라이팅 끄기

## Movement

### Line Movement

hjkl 왼쪽 아래 위 오른쪽

---

0 : 라인 맨 앞 

$ : 라인 맨 뒤

^ : 공백 제외 라인 맨 앞

---

% : 매칭되는 괄호로 이동

---

gg : 파일의 맨 위

G : 파일의 맨 아래

number + G : 특정 번호의 라인으로 이동

---

Ctrl + b : 한 페이지 위로 스크롤

Ctrl + f : 한 페이지 아래로 스크롤

Ctrl + u(up) : 절반 위로 스크롤

Ctrl + d(down) : 절반 아래로 스크롤

Ctrl + e : 한 칸 아래 스크롤 

Ctrl + y : 한 칸 위로 스크롤

### Word Movement

mac os의 option + 방향키처럼 단어를 기준으로 이동할 수 있음

* 커서가 다음 단어의 맨 앞 쪽에 위치함
    * w : 다음 단어
    * b : 이전 단어

* 커서가 다음 단어의 맨 뒤 쪽에 위치함
    * e : 다음 단어
    * ge : 이전 단어

## Jump

vim jump : 문서 내 특정 위치로 이동
    - 내부 jump
        - 현재 문서에서의 이동(gg, G 등)
    - 외부 jump
        - 다른 파일로 이동
        - gf : 커서에 위치한 파일 이름으로 이동

:jumps   : jump 목록

Ctrl + o : 이전 jump 위치로 이동 

Ctrl + i, <Tab> : 다음 jump 위치로 이동

## Writing

i(insert) : insert 모드 

a(append) : 커서를 한 칸 뒤로 옮기고 insert 모드 

I : 커서를 라인의 맨 앞으로 옮기고 insert 모드

A : 커서를 라인의 맨 뒤로 옮기고 insert 모드

o : 커서 기준 한 줄 내리고 insert 모드

O : 커서 기준 한 줄 올리고 insert 모드

c : motion만큼 삭제 후 insert 모드

C : 커서 뒤의 내용 삭제 후 insert 모드

r : 문자 변경 

R : 수정 모드

s : 문자 삭제 후 insert 모드 

S : 해당 줄 내용 삭제 후 insert 모드

J : 문자열 합치기

~ : 대소문자 변경

## Copy, Paste, Cut

y(yanks) : 복사

d(delete) : 잘라내기

dd : 라인 잘라내기

x : 문자 잘라내기

p(put, paste) :  붙여넣기
    - 라인을 잘라낸 경우 : 커서의 다음 줄에 붙여넣기
    - 부분만 잘라낸 경우 : 커서의 다음에 붙여넣기

## Undo, Redo

u : undo

Ctrl + r : redo

## Repeat

. : 마지막 command 수행

## Save

:w(write) : 저장

:q(quit) : 나가기

ZZ, :wq, :wqa : 파일 저장 후 나가기

ZQ, :q! : 저장하지 않고 나가기

:set autowrite : 자동저장 켜기

:set noautowrite : 자동저장 끄기

:vi file, :e file :  현재 vim 화면에서 다른 파일 열기

:vi! file : 경고 무시하고 강제로 다른 파일 열기

:view file : read-only 모드로 파일 열기

## Marks

m + a-z 또는 0-9 : mark 지정
    - mark로 설정한 라인을 옮기거나 삭제하면 mark가 삭제됨

'(홑따옴표) + 문자 : mark 라인 이동

`(백틱) + 문자     : mark 라인, 컬럼 이동

:marks : mark 목록 표시

미리 지정된 mark
* '', `` : 점프하기 전 마지막 위치
* '", `" : 현재 버퍼 마지막 커서 위치
* '^, `^ : insert 모드 마지막 커서 위치
* '., `. : 마지막 변경 위치
* (, )   : 문장 위치
* {, }   : 단락 위치

## Filtering

unix filter : 데이터 표준 입력 -> 데이터 처리 -> 데이터 표준 출력

vim filter : 텍스트 선택 -> 외부 프로그램 -> 버퍼에 결과 반영

!motion + command : vim filter 

!!motion command : 외부 프로그램 실행 결과 반영(표준 입력은 하지 않음 - filter가 아님)

**예시**

!5jsort : 다섯 라인 정렬

!!date : date 명령 결과 반영

!!ls : ls 명령 결과 반영 

## Multiple Files

vi file1 file2 file3 : 여러 개 파일 열기

:next, :n, `<Enter>` : 다음 파일 열기(현재 파일을 저장하지 않거나, 다음 파일이 없으면 동작 X)

:previous, N : 이전 파일 열기(현재 파일을 저장하지 않거나, 다음 파일이 없으면 동작 X)

:wn, N : 저장하고 이전, 다음 파일 열기

:n!, N! : 강제로 이전, 다음 파일 열기

:first, :last : 첫 파일 또는 마지막 파일 열기

:args : 현재 파일 작업 중인 파일 표시

## Windows

윈도우 관련 단축키는 모두 CTRL + w로 시작함(window key : CTRL + W)

대소문자 구분 필요(동작이 다름)

### Window Open, Close

:split, window key + s(split) : 현재 파일 새 윈도우 열기

:sview : 현재 파일 read-only 모드로 새 윈도우 열기

:new, window key + n(new) : 새로운 파일 새 윈도우 열기 

:sp(split) file : 다른 파일 열기

:sp +/command file : 다른 파일 열기(명령 적용)

:number split file : 다른 파일 열기(새 윈도우 사이즈 조절)

window key + c, q : 윈도우 닫기

window key + v : 새로운 vertical split window 생성 

### Window Movement

window key + H,J,K,L : 방향키 방향으로 윈도우 옮김

### Cursor Movement

window key + h,j,k,l : 방향키 방향의 윈도우로 커서 이동

window key + w : 다음 윈도우로 커서 이동 

### Chainging Window Size

window key + + : 윈도우 크기 늘리기

window key + - : 윈도우 크기 줄이기

window key + = : 모든 윈도우 크기 통일

window key + _ : 현재 윈도우 최대 크기(vertical 적용 안됨)

## Buffers

Buffer는 편집하고 있는 파일의 복사본임

vim editor로 파일을 열면 메모리에 내용이 로드됨(파일마다 고유 버퍼 id를 가짐, 1:1 관계)

버퍼 변경을 마치면 버퍼의 내용(content)이 파일에 작성됨(marks, setting, 등 파일에 관련된 내용도 포함)

### Screen, Window, Buffer

screen : vim이 실행되는 터미널 전체 화면

window : screen 내에서 분할된 편집 화면(window당 하나의 버퍼를 보여줄 수 있음)

buffer : 메모리에 로드된 파일 내용

### Buffer State

buffer의 3가지 상태
* Active   : 현재 윈도우에 표시된 파일 (스크린에 윈도우가 있으면 버퍼가 있는 상태임)
* Hidden, InActive   : 버퍼가 메모리에 로드되어 있지만 윈도우에 표시되지 않는 상태
    * hidden 상태인 경우 파일을 변경하면 메모리에 임시 저장해두고, 다른 buffer로 스위칭할 수 있음
    * set hidden 설정 필요

buffer 상태 표시
* a : active buffer
* - : inactive buffer
* h : hidden buffer
* % : current window
* # : alternative buffer(현재 윈도우에서 마지막으로 수정한 파일)
* + : modified buffer
* = : read-only buffer
* x : read error buffer

### Selecting Buffer

:buffer number : 버퍼 번호로 선택

:b(buffer) file : 파일 이름으로 선택

:sb file, number : 새로운 윈도우로 열기

:bn, bN : 다음, 이전 버퍼 선택 

### Control Buffer

:buffers, :ls, :files : 버퍼 리스트 보기

:bdelete file : 특정 버퍼 삭제

:badd file : 특정 버퍼 추가

## Tabs

Vim은 버퍼를 통해 파일의 내용을 저장함

다른 텍스트 에디터들은 Tab을 닫으면 모두 사라지는 것과 달리 Vim은 Tab을 닫아도 버퍼가 내용을 보관하고 있음

Tab은 하나 이상의 Window를 가질 수 있음

### Tab Open, Close

vim -p file1 file2 file3 : 여러 탭으로 파일 열기
:tabnew file : 새로운 Tab에 새로운 파일 열기
:tabclose : 현재 탭 닫기

### Tab Movement

gt : 다음 탭 이동
gT : 이전 탭 이동
:tabnext     : 다음 탭 이동
:tabprevious : 이전 탭 이동
:tabfirst    : 첫 탭으로 이동
:tablast     : 마지막 탭으로 이동   

## Visual Mode

Visual, Line, Block 동일

텍스트 선택 + >, < : 들여쓰기(shift width)

shitfwidth 설정 값 만큼 공백 이동(set shitfwidth=4)

텍스트 선택 + = : 들여쓰기 통일

텍스트 선택 + K : 선택한 텍스트에 대해 man command 적용

## Macro

.은 마지막에 수행한 하나의 명령을 반복하는 명령

매크로는 수행할 명령들을 기록해서 반복 수행하는 기능

### 동작과정

1. 매크로 키 지정 및 기록시작 : qkey
2. 수행할 명령 실행
3. 매크로 종료 : q

### 매크로 실행

@macroKey : 키에 매핑된 매크로 실행

### 예시

헤더 파일 명만 있는 텍스트들을 #include "filename"로 변경

**before**
```
stdio.h
fcntl.h
unistd.h
stdlib.h
```

**after**
```
#include “stdio.h”
#include “fcntl.h”
#include “unistd.h”
#include “stdlib.h”
```

1. 매크로 키 지정 및 기록 시작
    1. qa 입력, 하단에 recording @a라고 표시됨
2. 기록
    1. ^ : 라인의 맨 앞으로 커서 이동(공백 제외)
    2. i#include "<Esc> : 텍스트 입력
    3. A“<Esc> : 텍스트 입력
    4. j : 다음 줄로 이동
3. 기록 종료
    1. q 입력
4. 사용
    1. 매크로를 적용할 곳에 @a 입력

## Digraphs

이중 문자를 사용해야 될 경우

1. insert 모드 상태에서 CTRL + K 입력
2. 원하는 이중문자와 매핑된 문자 입력
3. 이중문자로 변환

매핑 문자는 :digraphs로 확인

## Command for Programming

### Syntax Coloring

:syntax on : 문법 coloring

### File Type

vim은 파일 확장자에 따라 파일 타입을 결정함

.java : java 파일

.c, .h : c 파일

:set filetype=c : 다른 확장자를 가진 파일을 c 파일 타입으로 설정

### Auto Indentation

set cident : C 스타일 프로그램(c, c++, java 등)을 작성할 때 표준 C 스타일로 자동 들여쓰기 적용

set smartindent : { } 를 기준으로 들여쓰기 적용, 주석 문자를 만나면 들여쓰기 유지

set autoindent : 현재 줄의 들여쓰기를 다음 줄에도 적용

텍스트 선택 + = + motion : 상황에 맞게 들여쓰기 적용

### Shifting

>>, << : 라인 들여쓰기(normal mode에서 동작)

>, < + i(inner) + { : {} 내부 텍스트 블록 들여쓰기

### Locating

gd, gD : 변수 정의 탐색

### Abbreviations

:ab or iab or abbreviate + 약어 + 자동완성 문구 : 자동완성 약어 지정

:ab : 약어 목록 표시

:unab + 약어 : 약어 해제

### Exmaple Abbreviate

:ab sout System.out.println();

## Mapping

특정 키, 커맨드를 작업(task), 명령 수행을 하도록 매핑하는 기능

{mode}{attribute}map {key} {command} : 키 매핑 구조

### Mapping Modes

nore 뜻 : No-Recursive 약자로 재귀적으로 매핑하지 않겠다는 의미임(vim에서 키 매핑을 지정하면 중복되는 키 매핑도 수행함)

nnoremap : normal 모드

inoremap : insert 모드

vnoremap : visual 모드

### Example Key Binding

nnoremap <Tab> :bn<CR> : 탭 키를 누르면 bn 명령 실행

inoremap <C-s> <ESC>:w<CR> : insert 모드에서 CTRL + S 입력 시 저장

## Fording

## Formatting, Linting

## Code Completion

## Language Server Protocol  

## Vim Scripts



**참고**

vim 9.x 버전대 기준

[vim docs](https://vimhelp.org/)

[vim-book](https://www.truth.sk/vim/vimbook-OPL.pdf)

[learn vimscript the hard way](https://learnvimscriptthehardway.stevelosh.com/)
