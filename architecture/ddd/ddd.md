# DDD(Domain Driven Design)

비즈니스 도메인이 가지고 있는 복잡한 문제들에 집중하여 모델링하는 소프트웨어 설계 방법    
-> 도메인이 해결해야 할 문제를 소프트웨어 제품에 명확하게 반영 

## Domain

도메인은 아래와 같이 설명할 수 있음
* 프로젝트가 제공할 서비스 또는 다루는 대상(target)
* 소프트웨어에서 해결할 문제 영역(Problem Space)

문제 영역에서 도메인은 그 성격에 따라 몇 가지 종류(Sub Domain)로 분류함
* Core Domain : 비즈니스의 핵심 도메인 - 직접 구현, 차별화
* Supporting Domain : Core Domain을 지원하는 도메인 - 사내 구현 또는 아웃 소싱
* Generic Domain : 공통 도메인(보안, 인증, 로깅 등) - 구현된 솔루션 사용 권장

## 설계 종류

전략적 설계(Strategic Design) : 프로젝트 자체의 개념적 설계

기술적 설계(Tactical Design)  : 전략적 설계 기반 프로그래밍 기술적 설계

## 설계 순서

상황에 따라 설계 순서는 변동될 수 있음

- 비즈니스 요구사항 파악, 비즈니스 모델과 유비쿼터스 언어 정의
    - Business Model Canvas : 비즈니스 관점 이해
    - User Story Maaping : 사용자 관점 이해
- 도메인 시각화
    - Event Storming
- 도메인을 서브 도메인, 바운디드 컨텍스트, 컨텍스트 맵으로 분리
    - Event Storming
- 코어 도메인 식별 및 구축, 구매, 아웃소싱 결정
    - Core Domain Charts
- 서브 도메인을 loosely-coupled 아키텍처로 연결
    - Domain Message Flow Modeling
    - Process Modeling Event Storming
    - Sequence Diagram
- 바운디드 컨텍스트 별 role, resposibility 정의
    - Bounded Context Canvas
- 도메인 코델 코딩
    - Aggregate Design Canvas
    - Event Modeling
    - Design-Level Event Storming

## 전략적 설계

유비쿼터스 언어, 도메인 모델, Bounded Context, Context Map을 설계하는 단계

### Ubiquitous Language

[Ubiquitous Language](https://martinfowler.com/bliki/UbiquitousLanguage.html) : 도메인 전문가, 아키텍트, 개발자 등 프로젝트를 수행하는 조직 내부에서 공유되는 언어로 소통 혼란을 줄임

유비쿼터스 언어는 다음과 같은 곳에서 사용됨
- 구성원 간 의사소통
- 설계 모델링, UML
- 애플리케이션 코드(클래스, 메서드 명)

### Domain Model

도메인 모델은 비즈니스 도메인의 개념과 규칙, 그리고 도메인 간의 관계를 표현하는 추상화된 모델 

도메인 모델을 통해 도메인을 이해하고 문제 자체에 집중

모델 표현 방법
- 객체 기반
- 상태 다이어그램 등

### Bounded Context

[Bounded Context](https://martinfowler.com/bliki/BoundedContext.html): 비즈니스 도메인을 컨텍스트(상황)에 맞게 설계하는 방법, 비즈니스 목적 별로 서비스들을 그룹화

구성원은 각 Bounded Context에서 사용하는 유비쿼터스 언어를 통해 소통 혼란 최소화

1개의 Bounded Context는 최소 1개 이상의 마이크로 서비스로 구성

### Context Map

Context Map : Bounded Context간의 관계를 나타내는 다이어그램

#### Event Storming

소프트웨어에서 발생하는 이벤트를 빠르게 찾는 워크숍 기반 방법론

Actor, Command, Aggregate, Event, External System, Policy/Rule 정의 및 Bounded Context 도출

예시 참고

[1](https://tech.junhabaek.net/ddd-%EC%A0%84%EB%9E%B5%EC%A0%81-%EC%84%A4%EA%B3%84-event-storming-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%BB%A4%EB%A7%A8%EB%93%9C-%EC%99%B8%EB%B6%80%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%95%A1%ED%84%B0-23ea8af1f457)

[2](https://happycloud-lee.tistory.com/94)

구성 요소
* Actor
    * Command를 내리는 주체
    * 판매자, 구매자, 관리자 등
* Command
    * Actor의 행위
    * Aggregate 또는 External Service에 의해 수행됨
* Aggregate
    * Command를 수행하는 시스템 요소 집합
    * 루트 엔티티와 기타 엔티티, Value Object로 구성됨
* External System
    * 현재 시스템의 Command, Event와 관련된 Command를 외부에서 수행하는 시스템
    * 외부 시스템의 Event는 자체적으로 발생할 수도 있음
    * OAuth 로그인, 이메일 발송, 푸시 알림 등
* Event
    * Command 수행의 결과 또는 발생한 일 
    * 1개의 Command에 1개 이상의 Event 발생
    * 또는 Command를 수행한 뒤 Event가 발생하지 않을 수도 있음
* Policy/Rule
    * Event와 관련된 정책이나 규정
    * Policy와 Rule도 Command를 발생시킬 수 있음

## 기술적 설계

전략적 설계 단계에서 만든 도메인 모델을 기반으로 프로그래밍 설계를 하는 단계

### Entity

### Value Object

### Service

### Repository

### Aggregate

### Domain Event


**참고**  
[DDD 핵심만 빠르게 이해하기](ttps://happycloud-lee.tistory.com/94)
[MSA 에서 유비쿼터스 언어(보편 언어)의 중요성](https://medium.com/dtevangelist/msa-%EC%97%90%EC%84%9C-%EC%9C%A0%EB%B9%84%EC%BF%BC%ED%84%B0%EC%8A%A4-%EC%96%B8%EC%96%B4-%EB%B3%B4%ED%8E%B8-%EC%96%B8%EC%96%B4-%EC%9D%98-%EC%A4%91%EC%9A%94%EC%84%B1-ca22b96aaeea)
[모두를 위한 DDD](https://blog.doctor-cha.com/introduction-to-domain-driven-design-for-everyone)
[DDD Eventstorming](https://tech.junhabaek.net/ddd-%EC%A0%84%EB%9E%B5%EC%A0%81-%EC%84%A4%EA%B3%84-event-storming-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%BB%A4%EB%A7%A8%EB%93%9C-%EC%99%B8%EB%B6%80%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%95%A1%ED%84%B0-23ea8af1f457)
[Domain Driven Design Guige](https://romanglushach.medium.com/domain-driven-design-ddd-a-guide-to-building-scalable-high-performance-systems-5314a7fe053c)
[DDD starter modeling process](https://ddd-crew.github.io/ddd-starter-modelling-process/)
뤼튼 GPT4
