## Unit4 테스트 조직
#### 1. AAA 로 테스트 일관성 유지
테스트 코드를 가시적으로 준비, 실행, 단언 부분으로 조직하여  
가독성과 일관성을 유지하기

- 준비(Arrange): 테스트 코드를 실행하기 전에 시스템이 적절한 상태에 있는지 확인  
  객체들을 생성하거나 이것과 의사소통하거나 다른 API 를 호출하는 것 등.  
  드물지만 시스템이 우리가 필요한 상태로 있다면 준비 상태를 생략하기도 함.
- 실행(Act): 테스트 코드를 실행.
- 단언(Assert): 실행한 코드가 기대한 대로 동작하는지 확인한다.  
  실행한 코드의 반환값 혹은 그 외 필요한 객체들의 새로운 상태를 검사한다.
  
- 사후(After): 테스트를 실행할 때 어떤 자원을 할당했다면 잘 정리 되었는지 확인한다.  
  테스트의 각 부분을 구별하는 빈 줄은 전체 테스트 코드를 훨씬 빠르게 이해하는데  
  가시적인 도구이다. 빈 줄을 잘 활용한다.
  
#### 2. 동작 테스트 vs 메서드 테스트
테스트를 작성할 때는 클래스 동작에 집중해야 하며 개별 메서드를 테스트한다고 생각하면 안된다.  
단위 테스틀르 작성할 때는 먼저 전체적인 시각에서 시작해야 한다.  
개별 메서드를 테스트하는 것이 아니라 클래스의 종합적인 동작을 테스트 해야한다.  
  
---------------------
#### 3. 테스트와 프로덕션 코드의 관계
JUnit 테스트는 검증 대상인 프로덕션 코드와 같은 프로젝트에 위치할 수 있다.  
하지만 테스트는 주어진 프로젝트 안에서 프로덕션 코드와 분리해야 한다.  
  
단위 테스트는 프로그래머만 하는 활동이다. 고객이나 최종 사용자, 비 프로그래머는  
테스트 결과를 보거나 실행만 한다.  
  
단위 테스트는 일방향성이다. 테스트 코드는 프로덕션 시스템 코드를 의존하지만,  
그 반대는 해당하지 않는다.  프로덕션 코드는 테스트 코드의 존재를 모른다.  
테스틀르 작성하는 행위가 프로덕션 시스템의 설계에 영향을 주지 않는것은 아니지만,  
더 많은 단위 테스트를 작성할수록 설계를 변경했을 때 테스트 작성이 훨씬 용이해질 것이다.  
프로그래머의 삶은 테스트 친화적인 설계를 채택할수록 편해지고 설계 자체도 더 좋아질 것이다.  

--------------------------
#### 4. 내부 데이터 노출 vs 내부 동작 노출

내부의 세부 사항을 테스트하는 것은 저품질로 이어질 수도 있다.  
코드의 작은 변화가 수많은 테스트를 깨면 (테스트 코드가 과도하게 내부적인 구현 사항을  
알고 있기 때문에) 프로그래머는 깨진 테스트를 고치면서 당황하게 된다.  
테스트가 더 많이 깨질수록 프로그래머는 리팩토링을 꺼리게 된다.  
그리고 리팩토링이 줄어들수록 코드 베이스는 빠르게 퇴화한다.  
이러한 강한 결합성 때문에 단위 테스트에 상당한 시간을 투자하는 것을 거부하는 팀들을 볼 수 있다.  
  
테스트를 위해 내부 데이터를 노출하는 것(테스트 하기 위해 게터 메서드를 만든다)은 테스트와  
프로덕션 코드 사이에 과도한 결합을 초래한다. 내부 동작을 노출하는 것은 다른 문제다.  
  
내부 행위를 테스트하려는 충동이 든다면 설계에 문제가 있는 것이다.  
묻혀 있는 수많은 흥미로운 행동은 거의 단일 책임 원칙(SRP, Single Responsibility Principle)을  
어기게 된다. SRP 는 어떤 클래스가 작고 단일 목적을 가져야 함을 의미하며, 가장 좋은 해결책은  
흥미로운 private 메서드를 추출하여 다른 클래스로 이동하는 것이다.  

---------------------------
#### 5. 집중적인 단일 목적 테스트의 가치  
다수의 케이스를 별도의 JUnit 테스트 메서드로 분리하고, 각각에는 검증하는 동작을 표현하는 이름을 붙인다.  
  
테스트를 리하면 다음의 이점을 얻게 된다.
- 단언이 실패했을 때 실패한 테스트 이름이 표시되기 때문에 어느 동작에서 문제가 있는지 빠르게 파악할 수 있다.
- 실패한 테스트를 해독하는 데 필요한 시간을 줄일 수 있습니다. JUnit은 각 테스트를 별도의 인스턴스로 실행하기 때문.  
  따라서 현재 실패한 테스트에 대해 다른 테스트의 영향을 제거 할 수 있다.
- 모든 케이스가 실행되었음을 보장할 수 있다. 단언이 실패하면 현재 테스트 메서드는 중단한다. 단언 에러가 AssertionError를  
  던지기 때문(JUnit은 이것을 잡아 테스트를 실패로 표시한다.) 단언 실패 이후의 테스트 케이스는 실행되지 않는다.
    
------------------------------------
#### 6. 문서로서의 테스트
단위 테스트는 우리가 만드는 클래스에 대한 지속적이고 믿을 수 있는 문서 역할을 해야한다.  
테스트는 코드 자체로 쉽게 설명할 수 없는 가능성들을 알려준다.  
그래서 이름이 중요하다.
  
| 멋지지 않은 이름         | 멋지고 설명적인 이름                             |
| ------------------------ | ------------------------------------------------ |
| makeSingleWithdrawal     | withdrawalReducesBalanceByWithdrawnAmount        |
| attemptToWithdrawTooMuch | withdrawalOfMoreThanAvailableFundsGeneratesError |
| multipleDeposists        | multipleDepositsIncreaseBalanceBySumOfDeposits   |
   
 다음 양식을 따르자.  
 - doingSomeOperationGeneratesSomeResult  
   (어떤 동작을 하면 어떤 결과가 나온다.)
 - someResultOccursUnderSomeCondition  
   (어떤 결과는 어떤 조건에서 발생한다.)
   
  
혹은 행위 주도 개발(BDD, Behavior-Driven Development)에서 말하는 given-when-then 같은 양식을 사용할 수도 있다.  
이것은 다음과 같이 표현할 수 있다.  

 - givenSomeContextWhenDoingSomeBehaviorThenSomeResultOccurs  
   (주어진 조건에서 어떤 일을 하면 어떤 결과가 나온다.)  
  
given-when-then 이 테스트를 잘 설명할 수 있지만 테스트 독자가 너무 많은 일을 할 수 있으니 주의한다.  
그래서 보통 givenSomeContext 는 제거하고 whenDoingSomeBehaviorThenSomeResultOccurs 를 쓴다.  
그러나 이건 처음에 언급한 doingSomeOperationGeneratesSomeResult 와 일치한다.  
  
어느 형식이든 일관성을 유지하는 것이 중요하다.  
주요 목표는 테스트 코드를 다른 사람에게 의미 있게 만드는 것임을 잊지 말자!  

--------------
#### 7. 녹색이 좋다: 테스트를 의미 있게 유지
보통 모든 테스트가 통과한다고 기대해야 한다. 이말은 실무에서 버그가 나왔을 때 문제를 고립시키는 것이 쉬워진다.  
실패하는 테스트가 있다면 즉시 고쳐 모든 테스트가 항상 통과하도록 유지해야 한다. 

테스트를 빠르게하기  
전체 테스트를 하는게 가장 좋지만 단위별로 빠르게 테스트 하고 싶다면  
목 객체를 황용하여 느린 테스트(데이터베이스 등의 의존)를 빠르게 전환시키고  
한단계 내려와 패키지에 있는 모든 테스트를 실행한다.  
혹은 [Infinitest](https://infinitest.github.io) 처럼 백그라운드에서 테스트를 항상 실행하는 도구를 고려하자.  
  
중요한 것은 테스트의 속도를 조절하기 위해 선택하는 위의 방법들은 빠른 피드백을 얻기 위해 선택하는 것들 이라는 것이다.

