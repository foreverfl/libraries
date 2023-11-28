## 개요

- 사용해 본 Library와 Framework에 대해 정리하는 Repository입니다. 자료는 GPT4 및 웹서핑을 사용해서 만들었습니다.

## 목차

- Java

  > - Default Library
  > - GraphQL
  > - Kafka
  > - Redis

- Python

  > - Matplotlib
  > - Numpy
  > - Pandas
  > - Sklearn
  > - Tensorflow

- php
- Node.js
- JavaScript

## Java - Default Library

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

빠른 읽기/쓰기 속도: Redis는 메모리 기반 데이터 저장소로, 데이터베이스에 비해 읽기 및 쓰기 속도가 훨씬 빠릅니다. 따라서 빈번한 데이터 조회가 필요한 경우 Redis의 사용이 성능을 크게 향상시킬 수 있습니다.

부하 감소: 자주 사용되는 데이터를 Redis에 캐싱함으로써 데이터베이스 서버의 부하를 줄일 수 있습니다. 이는 데이터베이스의 성능 저하를 방지하는 데 도움이 됩니다.

### Redis를 사용할 때 일반적으로 관리하는 데이터 유형은 다음과 같습니다:

세션 데이터: 웹 애플리케이션의 사용자 세션 정보를 저장하는 데 Redis가 자주 사용됩니다. 빠른 읽기 및 쓰기 속도 덕분에 사용자 경험을 개선할 수 있습니다.

캐시 데이터: 데이터베이스 쿼리 결과나 계산에 시간이 많이 걸리는 작업의 결과를 캐싱하는 데 Redis를 사용합니다. 이를 통해 애플리케이션의 응답 시간을 단축할 수 있습니다.

실시간 분석 데이터: 실시간으로 변하는 데이터(예: 페이지 조회 수, 사용자 활동)를 저장하고 분석하는 데 Redis가 유용합니다.

메시징 큐: Redis의 퍼블리시/서브스크라이브 기능과 리스트 데이터 구조를 활용하여 간단한 메시징 큐를 구현할 수 있습니다.

레이트 제한: API 요청과 같은 작업에 대한 레이트 제한을 구현하는 데 Redis의 빠른 읽기/쓰기 속도가 유용합니다.

임시 데이터: 일시적으로만 필요한 데이터(예: OTP, 인증 토큰)를 저장하는 데 Redis를 사용할 수 있습니다.

리더보드 및 카운팅: 게임 리더보드, 실시간 통계 등 빠르게 변경되는 순위나 카운팅 정보를 관리하는 데 Redis가 적합합니다.