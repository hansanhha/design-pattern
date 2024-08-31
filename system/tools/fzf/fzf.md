# fzf

[fzf docs](https://github.com/junegunn/fzf)

범용 파인더(파일, command history, 프로세스, hostnames, bookmarks, git commits 등)

## Installation

brew

```
brew install fzf

$(brew --prefix)/opt/fzf/install - key bindings, fuzzy completion
```

git 

```
git clone --depth 1 https://github.com/junegunn/fzf.git ~/.fzf
~/.fzf/install
```

vim plugin

```
Plug 'junegunn/fzf', { 'do': { -> fzf#install() } }
```

## Upgrading

`brew upgrade fzf`

`:PlugUpdate fzf`

## Usage

fzf 명령 실행 -> finder launch

finder는 UNIX의 filter임 (STDIN으로부터 읽고 선택된 아이템을 STDOUT 출력)

vim $(fzf) : fzf 명령 실행 -> 파일 선택 -> vim open

### Fuzzy Completion(bash, zsh)

`Command [Directory/][FUZZY_PATTERN]**<TAB>` 

vim **<TAB> : 현재 디렉토리에서 파일 선택

vim ../**<TAB> : 부모 디렉토리에서 파일 선택

cd **<TAB> : 현재 디렉토리의 하위 디렉토리로 이동

### Shortcuts

CTRL + r : command history finder

CTRL + t : 현재 디렉토리 finder

Option(Alt) + c : 디렉토리 switching

### Layout

height : fzf --height 40%

direction : fzf --layout=reverse

multi : fzf --multi (tab/shift +tab으로 여러 개의 파일 선택/해제)


기본 레이아웃 설정 : export FZF_DEFAULT_OPTS='설정 값'

```
export FZF_DEFAULT_OPTS='--multi --height 60% --layout=reverse │
--border'
```



