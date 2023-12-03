## 개요

- 사용해 본 Library에 대해 정리하는 Repository입니다. 자료는 GPT4 및 구글링을 사용해서 만들었습니다.

## 목차

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
