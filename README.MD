## 개요

- 사용해 본 Library에 대해 정리하는 Repository입니다. 자료는 공식문서/GPT4/구글링 을 사용해서 만들었습니다.

## 목차

- Git

- Java

  > - Default Library
  > - GraphQL
  > - Kafka
  > - Redis
  > - Graddle

- Python

  > - Matplotlib
  > - Numpy
  > - Pandas
  > - Sklearn
  > - Tensorflow

- php
- Node.js
- JavaScript
- HTML/CSS

## Git

### 협업 시 주의사항

- **초기 환경 설정 공유**: .gitignore 파일을 설정하여 불필요한 파일들이 추적되지 않도록 하는 것이 매우 중요함. 이는 불필요한 충돌을 예방하고, 리포지토리를 깔끔하게 유지하는 데 도움이 됨. 또한, API 키와 같은 중요한 정보를 환경 변수로 관리하는 것도 안전한 개발 관행임.
- **Branch 관리 전략**: main 브랜치는 보통 '안정적인' 코드 상태를 유지해야 하므로, 팀장이 이를 관리하고 팀원들은 각자의 브랜치에서 작업한 뒤 pull request를 통해 코드 리뷰와 병합을 요청하는 것은 좋은 전략임. 이런 접근 방식은 코드의 품질을 유지하고 충돌을 줄이는 데 도움이 됨.
- **정기적인 코드 리뷰**: 코드 리뷰는 코드의 품질을 높이고, 팀원들 사이의 지식 공유를 촉진함. 리뷰 과정을 통해 버그를 미리 잡아내고, 코드의 일관성을 유지할 수 있음.
- **명확한 작업 분할**: 팀 프로젝트에서는 각 팀원의 역할과 책임을 명확히 해야 함. 이렇게 하면 작업 중복을 방지하고, 코드의 충돌 가능성을 줄일 수 있음.
- **정기적인 브랜치 동기화**: 팀원들은 자신의 브랜치를 정기적으로 main 브랜치와 동기화해야 함. 이는 충돌을 미리 발견하고 해결하는 데 도움이 됨.
- **커밋 메시지와 문서화**: 명확하고 일관된 커밋 메시지는 변경 사항을 이해하는 데 도움이 됨. 또한, 프로젝트의 README 파일, 코드 내 주석 등을 통해 문서화를 잘 해두면 팀원들이 프로젝트를 더 쉽게 이해하고 유지보수할 수 있음.

### 주요 명령어

- **구성요소**

  > - **HEAD**: 현재 체크아웃된 커밋을 가리키는 포인터. Git에서는 HEAD를 사용하여 현재 작업 중인 브랜치의 최신 커밋을 참조함. 일반적으로 작업 중인 브랜치의 마지막 커밋.
  > - **HEAD~1**: HEAD의 부모 커밋, 즉 바로 이전 커밋을 의미함. HEAD~2는 HEAD의 부모의 부모 커밋으로, 이전의 이전 커밋을 가리킴. 이러한 방식으로 HEAD에서 특정 커밋으로 돌아갈 수 있음.
  > - **Origin**: 기본적으로 원격 저장소의 기본 이름. git clone으로 저장소를 복제할 때, Git은 복제된 원격 저장소에 origin이라는 이름을 자동으로 할당함. origin을 통해 원격 저장소를 참조하고 명령을 실행할 수 있음.
  > - **main(or master)**: 대부분의 저장소에서 기본 브랜치로 사용되는 이름. 이 브랜치에서 프로젝트의 주요 개발 작업이 이루어짐.
  > - **branch**: 프로젝트의 다른 버전을 동시에 개발할 수 있게 해주는 독립적인 작업 경로.

- **branch**: 코드의 다른 버전을 독립적으로 관리할 수 있는 기능. 이를 통해 한 프로젝트에서 여러 기능을 동시에 개발하거나 실험적인 작업을 별도로 진행할 수 있음.

  > - git branch [branch_name]: 새로운 브랜치를 생성.
  > - git branch: 로컬 저장소에 있는 모든 브랜치 목록이 출력됨.
  > - git branch --list: 로컬 저장소에 있는 모든 브랜치 목록이 출력됨.
  > - git branch -r: 원격 저장소의 브랜치 목록이 출력됨.
  > - git branch -a: 로컬 브랜치와 원격 브랜치가 모두 출력됨.
  > - git branch -d [branch_name]: 브랜치를 삭제.

- **add [stage area]**: 변경된 파일을 스테이징 영역에 추가해서, 커밋 대기 상태로 만드는 단계. git add 명령어를 사용하면, 해당 파일들은 스테이지 영역에 올라가 커밋을 기다림.

  > - git add [file_name]: 특정 파일을 스테이징 영역에 추가.
  > - git add .: 변경된 모든 파일을 스테이징 영역에 추가.

- **commit**: 변경 사항을 영구적으로 저장하는 버전을 만드는 과정. git commit을 실행하면 스테이지 영역의 파일들이 새로운 커밋으로 기록됨.

  > - git commit -m "[commit_message]": 변경 사항에 대한 설명과 함께 커밋.
  > - git commit --amend: 마지막 커밋을 수정.

- **push**: 로컬 저장소의 커밋을 원격 저장소에 업로드하는 과정. git push를 사용하면 로컬의 변경 사항을 원격 저장소와 동기화.

  > - git push origin [branch_name]: 지정된 브랜치를 원격 저장소에 푸시함.
  > - git push -u origin [branch_name]: 브랜치를 원격 저장소에 처음 푸시하고 추적함(--set-upstream).

- **pull**: 원격 저장소의 변경 사항을 로컬 저장소로 가져오는 과정. git pull 명령어를 사용하면 원격의 변경 사항을 로컬과 병합.

  > - git pull origin [branch_name]: 원격 저장소의 변경 사항을 현재 브랜치와 병합.

- **merge**: 두 브랜치의 변경 사항을 합치는 과정. git merge를 사용하면 한 브랜치의 변경 사항을 다른 브랜치와 병합할 수 있음.

  > - git merge [branch_name]: 지정된 브랜치의 변경 사항을 현재 브랜치와 병합.

- **clone**: 원격 저장소의 내용을 로컬 컴퓨터에 복사하는 과정. git clone 명령어로 저장소의 전체 이력을 복사할 수 있음.

  > - git clone [repository_url]

- **fetch**: 원격 저장소의 변경 사항을 로컬로 가져오되, 병합하지 않는 과정. git fetch 명령어로 원격 변경 사항을 로컬에 반영할 수 있음.

  > - git fetch origin: 원격 저장소의 변경 사항을 로컬로 가져옴.

- **checkout**: 다른 브랜치로 전환하거나, 특정 파일을 이전 상태로 되돌리는 작업.

  > - git checkout [commit-hash] -- [file-path]: 특정 파일이나 디렉토리를 이전 상태로 복원함.
  > - git checkout [branch_name]: 다른 브랜치로 전환.
  > - git checkout -b [branch_name]: 새 브랜치 생성 및 체크아웃.

- **reset**: 특정 커밋으로 현재 브랜치를 되돌리는 작업. --soft, --mixed, --hard 옵션을 사용하여 되돌리는 범위와 방식을 선택할 수 있음.

  > - git reset: HEAD가 가리키는 커밋으로 모든 변경사항을 되돌림. 커밋을 되돌리거나 수정된 파일을 이전 상태로 되돌림.
  > - git reset [file_name]: 특정 파일을 언스테이징
  > - git reset --soft [file_name]: 지정된 커밋으로 이동하되 변경 사항을 스테이징 영역에 유지. 이 옵션을 사용하면, 지정된 커밋으로 돌아가되, 이후의 변경 사항들은 스테이징 영역에 그대로 남김. 즉, 이 변경사항들은 다시 커밋할 준비가 된 상태임.
  > - git reset --mixed [file_name]: 지정된 커밋으로 이동하되 변경 사항을 작업 영역에 유지. 기본값. 지정된 커밋으로 돌아가지만, 변경 사항들은 스테이징 영역에서 제거되고 작업 디렉토리에 남음. 여기서 변경 사항들은 커밋되지 않은 상태로, 필요에 따라 다시 git add를 사용하여 스테이지할 수 있음.
  > - git reset --hard [file_name]: 지정된 커밋으로 완전히 되돌리고 모든 변경 사항을 삭제.
  > - git reset --soft HEAD~1: 마지막 커밋을 취소하고 스테이징 영역을 유지.
  > - git reset --hard HEAD~1: 마지막 커밋을 취소하고 모든 변경 사항을 삭제. 이 명령어를 사용할 때는 주의가 필요. 변경 사항을 복구할 수 없음.
  > - --soft, --mixed, --hard의 차이
  >   > - --soft: 과거로 돌아가지만, 시간 여행을 통해 배운 모든 것(변경 사항)을 기억함. 즉, 지정된 커밋으로 되돌아가되, 현재 변경사항을 스테이징 영역에 그대로 유지함.
  >   > - --mixed: 과거로 돌아가고, 시간 여행에서 배운 것들은 기억하지만, 행동으로 옮기지는 않음. 변경 사항은 작업 영역에 남겨두되, 스테이징은 취소됨.
  >   > - --hard: 과거로 완전히 돌아가서, 시간 여행에서 배운 것을 모두 잊음. 즉, 모든 변경사항을 버리고 지정된 커밋 상태로 완전히 되돌아감.

- **rebase**: 한 브랜치의 커밋을 다른 브랜치 위로 옮기는 과정. rebase는 기존 커밋들을 새로운 베이스 커밋 위에 "재배치"하는 과정을 수행함. 이는 마치 중간 저장점을 불러와서 변경하는 것과 유사하며, 히스토리를 보다 깔끔하고 선형적으로 만드는 데 도움이 됨. git rebase를 사용하면 커밋 히스토리를 깔끔하게 유지할 수 있음. 하지만, Rebase는 커밋의 기록을 변경하기 때문에, 공개된 저장소에 이미 push된 커밋을 rebase할 경우 문제를 일으킬 수 있음. 그래서 이미 공개된 커밋에 대해서는 rebase를 피해야 함.

  > - git rebase [base_branch]: 현재 브랜치의 커밋을 지정된 기준 브랜치 위로 재배치.
  > - git rebase -i [base_branch]: 인터랙티브 모드에서 리베이스 실행. 이 명령어는 커밋 히스토리를 보다 세밀하게 조정할 수 있는 인터페이스를 제공함. 사용자는 커밋의 순서를 변경하거나, 커밋을 수정, 합치거나, 삭제하는 등 다양한 작업을 수행할 수 있음.
  > - git rebase --onto [branch_A] [branch_B] [branch_C]: B와 C의 공통 조상부터 C까지의 커밋을 A 브랜치로 이동시킴.
  > - [참고 링크](https://wormwlrm.github.io/2020/09/03/Git-rebase-with-interactive-option.html)
  > - [참고 링크](https://readystory.tistory.com/151)

- **remove**: 추적 중인 파일을 로컬 디렉토리와 Git 저장소에서 삭제함. "추적 중인 파일"이라는 용어는 Git에서 관리하고 있는 파일을 의미함. 이는 파일이 스테이지에 올라간 상태, 커밋된 상태 또는 이전에 커밋된 적이 있어서 Git이 변경 사항을 추적하고 있는 모든 파일을 포함함. 즉, Git 저장소에 의해 관리되는 모든 파일이 "추적 중인 파일"에 해당함.

  > - git rm [file_name]: 파일을 작업 디렉토리와 인덱스에서 제거.
  > - git rm -r --cached [path]
  >   > - **-r**: 재귀적으로 삭제를 수행. 즉, 디렉토리와 그 내부의 파일들을 모두 삭제하는데 사용됨.
  >   > - **--cached**: 이 옵션은 파일을 로컬 작업 디렉토리에서는 유지하면서, Git의 추적 목록(스테이지 영역)에서만 제거하고자 할 때 사용됨. 이 명령어를 사용하면, 해당 파일이나 디렉토리는 더 이상 Git에 의해 추적되지 않게 됨.

- **stash**: 작업 중인 변경사항을 임시로 저장. git stash는 현재 추적 중인 파일의 변경사항을 임시로 저장하고, 작업 디렉토리를 깨끗한 상태로 되돌림. git stash를 사용해 현재 변경사항을 스택에 저장하고, git stash pop으로 복원할 수 있음.

  > - git stash: 작업 중인 변경사항을 임시로 저장.
  > - git stash pop: 저장된 스태시를 복원하고 스태시 목록에서 제거.

- **cherry-pick**: 다른 브랜치의 특정 커밋을 현재 브랜치로 가져옴. cherry-pick으로 현재 커밋인 B에서 A를 가져오면, 선택한 커밋(A)의 변경사항을 현재 브랜치에 적용하고, 새로운 커밋(C)이 생성됨. 이 새 커밋(C)는 원래 커밋(A)의 내용을 포함하지만, 커밋 해시는 다름. 즉, 기존 커밋(B)와 독립적인 새로운 커밋(C)이 형성됨.

  > - git cherry-pick [commit_hash]: 다른 브랜치의 특정 커밋을 현재 브랜치로 가져옴.

- **log**: 현재 상태를 확인함.

  > - git log --oneline: 커밋을 한 줄 요약으로 보여줌.
  > - git log --graph --all --oneline: 이 명령어는 모든 브랜치의 커밋 이력을 그래픽 형태로 보여줌.
  > - git log --graph --decorate --oneline: 이 명령어는 커밋 히스토리를 그래프 형태로 표시하고, --decorate 옵션을 통해 각 커밋에 브랜치 이름이나 태그 등 추가적인 정보를 포함시킴.

- **diff**: 변경 사항을 비교. git diff 명령어를 사용해 파일 간의 차이점을 확인할 수 있음.

  > - git diff: 작업 디렉토리와 스테이지 영역 사이의 차이를 보여줌.
  > - git diff --staged: 스테이지 영역과 마지막 커밋 사이의 차이를 보여줌.
  > - git diff [branch1] [branch2]: 두 브랜치 간의 차이를 보여줌.

- **ignore**: 특정 파일이나 디렉토리를 Git 추적에서 제외함. .gitignore 파일을 사용해 추적하지 않을 파일을 지정할 수 있음.

- **tag**: 특정 커밋에 태그를 지정해 버전 번호나 릴리스 이름을 부여함. Git의 태그는 주로 프로젝트의 중요한 지점들을 표시하는 데 사용됨. 예를 들어, 특정 버전의 릴리스(예: v1.0, v2.0 등)를 표시할 때 태그를 사용함. git tag 명령어로 태그를 생성하고 관리할 수 있음.

  > - git tag: 현재 저장소의 모든 태그를 나열.
  > - git tag [tag_name]: 현재 커밋에 새 태그를 생성.
  > - git tag -a [tag_name] -m "[message]": 주석과 함께 새 태그를 생성.
  > - git tag -d [tag_name]: 태그를 삭제함.

- **config**: git config 명령어는 Git의 설정을 관리하는 데 사용됨. 사용자 이름, 이메일, 코딩 스타일, 브랜치 동작 등 다양한 Git 관련 설정을 조정할 수 있음.

  > - git config --global user.name "[name]": 전역 사용자 이름 설정.
  > - git config --global user.email "[email]": 전역 이메일 주소 설정.
  > - git config --global core.autocrlf true: 윈도우에서 자동 줄바꿈 설정.
  > - git config --list: 현재 설정된 Git 구성 확인.

- **blame**: git blame 명령어는 파일의 각 줄이 마지막으로 수정된 커밋과 그 저자를 보여줌. 코드의 특정 부분을 누가 언제 변경했는지 추적하는 데 유용함.

  > - git blame [file]: 지정된 파일의 각 줄에 대한 마지막 수정 커밋과 저자 표시.

- **bisect**: git bisect 명령어는 이진 탐색 알고리즘을 사용하여 버그가 도입된 커밋을 빠르게 찾을 수 있도록 도와줌.
  > - git bisect start: 이진 탐색 시작.
  > - git bisect bad: 현재 커밋이 문제가 있는 것으로 표시.
  > - git bisect good [commit]: 지정된 커밋이 정상 작동하는 것으로 표시.

### 추가 자료

- [git-scm](https://git-scm.com/book/ko/v2)

## Java - Standard Library

### 표준 라이브러리의 내장 패키지

- **java.lang**: 자바 프로그래밍의 기본 클래스들을 포함함. 예를 들어, String, Math, System, Thread 등이 여기에 속함. 이 패키지는 자바 프로그램의 기본적인 구성 요소를 제공함.
- **java.util**: 유틸리티 클래스와 인터페이스를 포함함. 컬렉션 프레임워크(List, Set, Map 등), 날짜 및 시간 유틸리티(Date, Calendar), 기타 유틸리티 클래스(Random, Scanner, Comparator 등)가 이에 해당함.
- **java.io**: 입력과 출력(I/O) 관련 기능을 제공함. 파일 읽기/쓰기, 스트림 처리 등이 포함됨.
- **java.nio**: 뉴 I/O(New I/O) 관련 클래스와 인터페이스를 제공함. 버퍼, 채널, 셀렉터 등 고성능 I/O 작업을 위한 클래스가 포함됨.
- **java.net**: 네트워킹 관련 기능을 제공함. 소켓 프로그래밍, URL 처리 등이 여기에 속함.
- **java.time**: 자바 8부터 도입된 날짜와 시간 API. LocalDate, LocalTime, DateTimeFormatter 등을 포함함.
- **java.sql**: 데이터베이스 접근과 관련된 클래스와 인터페이스를 제공함. JDBC API가 여기에 포함됨.

## Java - GraphQL

### Documentation 목차

1. Getting Started: GraphQL Java의 기본적인 사용 방법과 설정 방법.
2. Schema: GraphQL 스키마의 기본 구조와 정의 방법.
3. SDL Directives: 스키마 정의 언어(SDL)에서 사용되는 지시어.
4. Data fetching: 데이터 페칭 방법과 데이터 소스에서 정보를 가져오는 방법.
5. Scalars: 스칼라 타입에 대한 이해.
6. Field selection: 필드 선택과 쿼리 최적화 방법.
7. Subscriptions: 실시간 데이터 업데이트를 처리하는 구독 메커니즘.
8. Relay: Relay 스펙에 대한 개념.
9. Data mapping: 객체와 스키마 필드 간의 매핑 방법.
10. Instrumentation: 쿼리 성능 측정 및 모니터링 방법.
11. Logging: 로깅 설정 및 관리 방법.
12. Field visibility: 필드의 가시성과 보안 관련 사항.
13. Exceptions: 예외 처리 메커니즘.
14. Execution: 쿼리 실행 과정과 성능 최적화 방법.
15. Batching: 데이터 배치 처리와 N+1 문제 해결 방법.
16. Concerns: 일반적인 문제점 및 해결 방법.
17. Contributions: 오픈 소스 프로젝트에 기여하는 방법.

## Java - Kafka

### Kafka의 주요 구성 요소

- Producer (생산자):
  > - Producer는 Kafka 시스템에 데이터를 보내는 역할을 합니다. Producer는 다양한 소스(예: 애플리케이션, 서버, IoT 장치 등)에서 생성된 데이터를 Kafka 클러스터의 특정 토픽(Topic)으로 보냄.
  > - 각 메시지는 키(Key)와 값(Value)을 가질 수 있으며, 키를 기반으로 메시지가 토픽 내의 특정 파티션(Partition)에 저장됨.
- Broker (브로커):
  > - Kafka 클러스터는 하나 이상의 서버(Server)로 구성되며, 이 서버들을 '브로커'라고 함. 브로커는 Kafka 시스템의 핵심으로, 데이터의 저장 및 처리를 담당.
  > - 브로커는 토픽 별로 메시지를 저장하며, 각 토픽은 하나 이상의 파티션으로 나뉨. 이러한 구조는 데이터의 병렬 처리와 확장성을 높여줌.
- Consumer (소비자):
  > - Consumer는 Kafka 시스템에서 데이터를 읽는 역할을 함. Consumer는 하나 이상의 토픽을 구독하고, 해당 토픽의 새로운 메시지를 지속적으로 가져와서 처리함.
  > - Consumer는 일반적으로 Consumer Group의 일부로 동작하며, 이를 통해 메시지 처리의 부하를 여러 Consumer 간에 분산시킬 수 있음.

### Kafka의 Server와 Client 구분

- Kafka Server (브로커):

  > - Kafka Server는 메시지를 저장하고 관리하는 데 중점을 둔 브로커 역할을 수행함. 서버는 클러스터로 구성되어 데이터의 복제, 분산 처리, 내결함성을 제공.
  > - Server는 클라이언트로부터 오는 요청을 처리하고, 메시지를 저장 및 전달하는 역할을 함.

- Kafka Client (Producer와 Consumer):
  > - Kafka Client는 Kafka 클러스터와 통신하여 데이터를 보내거나 받는 애플리케이션. Producer와 Consumer는 Kafka Client의 예시.
  > - Client는 Kafka의 브로커와 통신하여 데이터를 전송하거나 가져오는 역할을 함.

### Kafka의 Topic

- Kafka에서 '토픽(Topic)'은 메시지들을 분류하기 위한 카테고리나 피드의 이름. Kafka를 사용할 때 데이터는 토픽 별로 발행되고 구독됨. 토픽은 데이터를 구조화하고 관리하는 데 사용되는 중요한 개념.

### Kafka API의 다양한 구성 요소

- Consumer API: Consumer API를 사용하면 애플리케이션에서 Kafka의 토픽을 구독하고, 메시지를 읽을 수 있음. 이 API는 데이터 처리 및 분석 애플리케이션에서 주로 사용됨.
- Producer API: Producer API를 통해 애플리케이션에서 메시지를 Kafka의 토픽으로 보낼 수 있음. 이 API는 데이터를 Kafka로 전송해야 하는 생산자 애플리케이션에서 사용됨.
- Streams API: Streams API는 스트림 처리 애플리케이션을 만들 때 사용됨. 이 API를 통해 실시간으로 데이터 스트림을 처리하고 변환할 수 있으며, 입력 스트림을 출력 스트림으로 변환하는 고급 작업을 수행할 수 있음.
- Connector API: Connector API는 Kafka와 다른 애플리케이션 또는 데이터 시스템 사이의 연결을 쉽게 구축할 수 있도록 해줌. 이 API는 주로 데이터베이스, 로그 시스템, 다른 메시지 시스템 등과 Kafka 사이의 데이터 통합에 사용됨.
- Admin API: Admin API는 Kafka 클러스터를 관리하는데 사용됨. 토픽 생성, 삭제, 파티션 조정 등 Kafka 클러스터와 관련된 관리 작업을 수행할 수 있음.

### Zookeeper와 Kafka를 사용하는 이유

- **클러스터 관리**: Zookeeper는 Kafka 클러스터의 브로커(서버)들 사이의 상태를 조정. 예를 들어, 어떤 브로커가 활성 상태인지, 어떤 브로커가 새로 추가되거나 실패했는지 등의 정보를 관리함.
- **메타데이터 관리**: Kafka 클러스터의 메타데이터(예: 토픽, 파티션 등의 정보)를 저장하고 관리함.
- **리더 선출**: Kafka의 각 파티션은 리더와 팔로워로 구성됨. Zookeeper는 이러한 리더의 선출을 관리하는 데 사용됨.
- **분산 처리의 조정**: Kafka 클러스터의 여러 브로커 사이에서 일관된 상태를 유지하고, 클러스터 내의 분산 처리를 원활하게 조정하는 데 Zookeeper가 사용됨.

### Kafka 브로커 구성

- **broker.id**: 이 설정은 Kafka 클러스터 내에서 각 브로커를 고유하게 식별하는 ID. 각 브로커는 서로 다른 broker.id 값을 가져야 함.
- **log.dirs**: 이 설정은 Kafka 브로커가 메시지를 저장하는 로그 파일의 위치를 지정함. Kafka는 이 디렉토리에 데이터(메시지)를 저장하며, 여러 디스크에 데이터를 분산시키기 위해 여러 로그 디렉토리를 지정할 수도 있음.
- **zookeeper.connect**: 이 설정은 Kafka 브로커가 Zookeeper 서비스와 연결하기 위한 정보를 제공. Zookeeper의 호스트 이름과 포트 번호를 포함하는 문자열로 지정됨. 예를 들어, zookeeper.connect=localhost:2181은 로컬 호스트에서 실행 중인 Zookeeper 서비스에 연결하라는 의미.

### Kafka 실행하기

1. Zookeeper 실행

```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

2. Broker(Server) 실행

```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

3. Topic 생성

```bash
.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

### Kafka 명령어

- 토픽 목록 확인

```bash
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```

- 토픽 상세 정보 확인

```bash
.\bin\windows\kafka-topics.bat --describe --topic test-topic --bootstrap-server localhost:9092
```

## Java - Redis

### Redis 사용 시 성능 이점:

- **빠른 읽기/쓰기 속도**: Redis는 메모리 기반 데이터 저장소로, 데이터베이스에 비해 읽기 및 쓰기 속도가 훨씬 빠름. 따라서 빈번한 데이터 조회가 필요한 경우 Redis의 사용이 성능을 크게 향상시킬 수 있음.
- **부하 감소**: 자주 사용되는 데이터를 Redis에 캐싱함으로써 데이터베이스 서버의 부하를 줄일 수 있음. 이는 데이터베이스의 성능 저하를 방지하는 데 도움이 됨.

### Redis를 사용할 때 일반적으로 관리하는 데이터 유형

- **세션 데이터**: 웹 애플리케이션의 사용자 세션 정보를 저장하는 데 Redis가 자주 사용됨. 빠른 읽기 및 쓰기 속도 덕분에 사용자 경험을 개선할 수 있음.
- **캐시 데이터**: 데이터베이스 쿼리 결과나 계산에 시간이 많이 걸리는 작업의 결과를 캐싱하는 데 Redis를 사용함. 이를 통해 애플리케이션의 응답 시간을 단축할 수 있음.
- **실시간 분석 데이터**: 실시간으로 변하는 데이터(예: 페이지 조회 수, 사용자 활동)를 저장하고 분석하는 데 Redis가 유용함.
- **메시징 큐**: Redis의 퍼블리시/서브스크라이브 기능과 리스트 데이터 구조를 활용하여 간단한 메시징 큐를 구현할 수 있음.
- **레이트 제한**: API 요청과 같은 작업에 대한 레이트 제한을 구현하는 데 Redis의 빠른 읽기/쓰기 속도가 유용함.
- **임시 데이터**: 일시적으로만 필요한 데이터(예: OTP, 인증 토큰)를 저장하는 데 Redis를 사용할 수 있음.
- **리더보드 및 카운팅**: 게임 리더보드, 실시간 통계 등 빠르게 변경되는 순위나 카운팅 정보를 관리하는 데 Redis가 적합함.

## Redis의 확률적 데이터 구조

- **HyperLogLog**: 이 구조는 대규모 데이터 세트에서 고유 요소의 수 (카디널리티)를 추정함. 메모리 효율적이며, 빠른 속도로 대량의 데이터에서 고유 값의 수를 추정할 수 있음.
- **Bloom Filter**: 데이터 세트 내 특정 요소의 존재 여부를 빠르게 확인할 수 있음. 이 구조는 요소가 세트에 '포함되어 있지 않다'는 것을 확실히 할 수 있지만, '포함되어 있다'고 할 때는 일정 확률로 오류를 포함할 수 있음.
- **Cuckoo Filter**: Bloom 필터와 유사하게 요소의 존재 여부를 확인함. Cuckoo 필터는 Bloom 필터에 비해 더 효율적인 데이터 삭제 및 동적 크기 조정 기능을 제공함.
- **t-digest**: 데이터 스트림에서 특정 백분위수를 추정함. 이 구조는 데이터 분포의 중간 값 또는 다른 백분위수를 추정하는 데 유용함.
- **Top-K**: 데이터 스트림에서 가장 빈번하게 등장하는 요소들을 추적함. 예를 들어, 가장 많이 방문한 웹 페이지나 가장 인기 있는 검색어 등을 식별하는 데 사용할 수 있음.
- **Count-min Sketch**: 데이터 스트림 내 요소의 빈도수를 추정함. 이 구조는 빅 데이터 환경에서 각 요소의 빈도수나 인기도를 추정하는 데 사용됨.
  실시간 분석 데이터: 실시간으로 변하는 데이터(예: 페이지 조회 수, 사용자 활동)를 저장하고 분석하는 데 Redis가 유용합니다.

## Java - Gradle

### 명령어

- **gradle init**: Gradle 프로젝트를 초기화.
- **gradlew build**: Gradle Wrapper를 사용하여 프로젝트를 빌드.
- **gradlew tasks**: 프로젝트에서 사용할 수 있는 모든 작업을 나열.
- **gradlew jar**: 실행 가능한 JAR 파일을 생성.
- **gradlew :app:dependencies**: 'app' 서브프로젝트의 종속성 트리를 확인.

### 플러그인의 역할

- 프로젝트에 작업을 추가. (예: 컴파일, 테스트).
- 기본 Gradle 모델을 확장. (예: 구성 가능한 새로운 DSL 요소 추가).
- 관례에 따라 프로젝트를 구성. (예: 새 작업 추가 또는 합리적인 기본값 설정).
- 특정 구성을 적용. (예: 조직적 저장소 추가 또는 표준 강제 적용).
- 기존 타입에 새로운 속성과 메소드를 확장을 통해 추가.

### 핵심 플러그인

- https://docs.gradle.org/current/userguide/plugin_reference.html#plugin_reference

### Gradle 상세 로그 보기

1. gradle.properties 생성.
2. gradle.properties에 다음과 같이 입력.

```sh
org.gradle.console=verbose
```

### 태스크 상태 설명

- **UP-TO-DATE**: 이미 실행되었고 변경되지 않은 작업 (증분 빌드 기능).
- **SKIPPED**: 명시적으로 실행이 방지된 작업.
- **FROM-CACHE**: 빌드 캐시에서 이전 빌드의 결과를 복사한 작업 (캐싱 기능).
- **NO-SOURCE**: 필요한 입력이 없어 실행되지 않은 작업.

### Gradle 환경설정 우선순위

1. **커맨드라인 플래그**: 속성 및 환경 변수보다 우선.
2. **시스템 속성**: 루트 프로젝트 디렉토리에 있는 gradle.properties 파일에 저장됨.
3. **Gradle 속성**: 일반적으로 프로젝트 디렉토리 또는 GRADLE_USER_HOME에 있는 gradle.properties 파일에 저장됨.
4. **환경 변수**: Gradle을 실행하는 환경에서 제공.
