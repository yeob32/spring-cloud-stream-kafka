# spring-cloud-stream-kafka

## Spring Cloud

- 마이크로 서비스를 구축하기 위한 프레임워크

## Spring Cloud Stream

- 이벤트 중심 마이크로 서비스를 구축하기 위한 프레임워크
    - 외부 미들웨어와의 통신을 하기 위해서 통합 컴포넌트 제공
- 애플리케이션은 Bindings 를 구성하여 외부에 노출되어 있는 브로커와 통신
- 필수적인 구성정보는 특정 미들웨어 (Kafka, RabbitMQ)를 구현하는 Binder 가 Broker 에 연결 가능한 Bindings를 구성하는데 사용된다.
- kafka <-> bindings <-> Spring Cloud Stream App (Destination Binder) <-> bindings <-> kafka

### Binder

- Spring Cloud Stream이 제공해 주는 미들웨어(kafka)와의 통신 컴포넌트
- 메시징 시스템과의 연결, 위임 및 생산자와 소비자 간의 메시지 라우팅, 데이터 유형 변환, 사용자 코드 호출 등을 담당

### Binding

- 외부 메시징 시스템과 애플리케이션 제공 메시지의 메시지 Producer 및 Consumers 간의 Bridge
- properties
    - `spring.cloud.stream.bindings`
        - `spring.cloud.stream.bindings.<input>.destination`
            - 네이밍 규칙
                - input : <functionName> + -in- + <index>
                - output : <functionName> + -out- + <index>
    - kafka topic - `spring.cloud.stream.kafka.bindings`

### DLQ
- 배치모드로 설정하여 데이터 스트림을 소비할 경우에는 retry 가 적용되지 않고 가져온 값이 버려지므로 조심해야 한다.

## Kafka Streams

- kafka에 저장된 데이터를 처리하고 분석하기 위한 라이브러리
- 연속적으로 유입되는 메세지(스트림)를 빠르게 처리

### 특징
- 데이터 유실과 중복 처리가 되지 않고 exactly once 보장 
- 자체 로컬 상태 저장소(rocksDB 를 이용한 상태 기반 처리)
  - 로컬 DB에 저장된 상태에 대한 변환 정보는 카프카 변경로그에 저장
- 스케줄링 도구가 필요 없음

### Kafka Streams DSL
- KStream, KTable, GlobalKTable

## Global Transaction
### JTA

### 2PC

### SAGA

## References

- https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/spring-cloud-stream.html
- https://cloud.spring.io/spring-cloud-stream-binder-kafka/spring-cloud-stream-binder-kafka.html