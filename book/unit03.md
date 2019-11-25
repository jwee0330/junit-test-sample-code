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
