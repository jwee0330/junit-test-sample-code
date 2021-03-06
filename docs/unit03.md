### 테스트의 단언
* assertThat 은 명확한 값을 비교
    * equalsTo 메처에는 어떤 자바 인스턴스나 기본형 값이라도 넣을 수 있다.  
      자바 기본형은 객체형으로 오토박싱되기 때문에 어떤 타입도 비교할 수 있다.
    * assertTrue 의 stackTrace 보다 조금더 구체적인 이유를 확인 할 수 있다.  
* 중요한 Matcher 들 살펴보기  (*표시: assertJ 사용법)
    * is(equalTo("abc")); * isEqualTo()
    * not(equalTo("abc")); * isNotEqualTo() 
  
null 이 아닌 값을 자주 검사하는 것은 설계 문제이거나 지나치게 걱정하는 것 일수 있다.  
많은 경우 이러한 검사는 불필요하고 가치가 없다.  
null 을 참조하는 테스트는 테스트 오류가 발생하며 테스트 실패는 발생하지 않는다.  
JUnit은 발생한 예외를 테스트 코드에서 잡지 않는 경우 오류를 보고 한다.

JUnit 햄크레시트 매처를 이용하면 다음 일을 할 수 있다.
* 객체 타입을 검사
* 두 객체의 참조가 같은 인스턴스인지 검사한다.
* 다수의 매처를 결합하여 둘 다 혹은 둘 중에 어떤 것이든 성공하는지 검사한다.
* 어떤 컬렉션이 요소를 포함하거나 조건에 부합하는지 검사한다.
* 어떤 컬렉션이 아이템 몇 개를 모두 포함하는지 검사한다.
* 어떤 컬렉션에 있는 모든 요소가 매처를 준수하는지 검사한다.

참조 -   
[햄크레스트 API 문서](https://goo.gl/g5W4xi)  
[구글 튜토리얼](https://goo.gl/g5W4xi)

--------------

#### 예외를 기대하는 세 가지 방법

* 단순한 방식: 애너테이션 사용
    * @Test(expected=IllegalArgumentException.class)
* 옛 방식: try/catch 와 fail
    * try {  
        account.withdraw(100);  
        fail();  
      }   
      catch (InsufficientFundsException expected) {  
        assertThat(expected.getMessage()).isEqualTo("balance only 0");    
      }
      
* 새로운 방식: ExpectedException 규칙
    * @Rule  
      public ExpectedException thrown = ExpectedException.none();
      
* [Fishbowl 방식](https://github.com/stefanbirkner/fishbowl)

* [JUnit5 expected exception - assertThrows() example](https://howtodoinjava.com/junit5/expected-exception-example/)
-------------------------

일부러 검증된 예외를 처리하려고 테스트 코드에 try/catch 블록을 넣지 말기!
그 대신 발생하는 예외를 다시 던지기!  
해피패스로 코드를 작성해서 테스트하기!
