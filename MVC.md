

# MVC 1편

## 웹 서버, 웹 어플리케이션 서버 이해 

Web server - 정적이미지 위주

Was server - 어플리케이션 로직 위주 > 버그가 많이 생겨 서버가 아예 다운되는 일이 많다



큰 비즈니스 같은 경우 위 두개의 서버를 구축하여 사용

회사간 데이터 전송은 Was server만 써도 문제 없음



## 서블릿

기존에 서버 TCP/IP 대기 , 소켓연결부터 해서 HTTP 메시지 파싱 등등 여러가지 작업을 개발자가 직접 일일이 개발했어야함

비즈니스 로직을 제외하고 나머지는 서블릿이 다 지원해준다!!



![image-20211130160853869](https://user-images.githubusercontent.com/82758364/144242897-a04fb4b4-f1c1-4dfe-b7a3-e7b638bc107f.png)

* urlPatterns(/hello)의 URL이 호출되면 서블릿 코드가 실행

* HttpServletRequest : HTTP 요청 정보
* HttpServletResponse: HTTP 응답 정보



### HTTP 요청, 응답흐름

* HTTP요청 시
  * WAS는  Request, Response 객체를 새로 만들어서 서블릿 객체 호출
  * Request 객체에서 HTTP 요청 정보를 꺼내서 사용
  * Response 객체에 HTTP 응답정보를 입력
  * WAS는  Response 객체에 담겨있는 내용으로 HTTP 응답정보를 생성



## 동시요청 - 멀티 쓰레딩

 그 전에 서블릿 객체는 누가 호출하나?

> `쓰레드`가 호출해준다.

### 쓰레드

* 애플리케이션 코드를 하나하나 순차적으로 실행하는 것
* 자바 메인 메서드를 처음 실행하면 main이라는 이름의 쓰레드가 실행
* 쓰레드가 없으면 자바 애플리케이션 실행 불가능!
* 쓰레드는 한번에 하나의 코드 라인만 수행
* 동시 처리가 필요하면 쓰레드를 추가로 생성



**요청마다 쓰레드 생성 시 장단점 **

* 장점
  * 동시 요청 처리
  * 리소스 허용할 때 까지 처리 가능
  * 하나의 쓰레드가 지연되도 나머지는 정상 작동
* 단점
  * 쓰레드 생성 비용 매우 비쌈
    * 고객 요청 올 때 마다 생성하면 응답 속도 늦어짐 
  * 쓰레드는 컨텍스트 스위칭 비용이 발생한다. ( 컨텍스트 스위칭 비용 == 코어가 쓰레드를 전환할 때 드는 비용 )
  * 쓰레드 생성에 제한이 없다
    * 고객 요청이 너무 많으면 , 리소스의 임계점을 넘어 서버가 다운될 수 있다.

==>  WAS는 보통 쓰레드풀로 사용함.



### 쓰레드 풀 

> 요청 마다 쓰레드 생성의 단점 보완

* 특징
  * 필요한 쓰레드를 쓰레드 풀에 보관하고 관리한다.
  * 쓰레드 풀에 생성 가능한 쓰레드의 최대치를 관리한다. 
  * 톰캣은 최대 기본 200개 ( 변경 가능 )
* 사용
  * 이미 생성되어있는 쓰레드를 쓰레드 풀에서 꺼내서 사용한다.
  * 사용 종료시 쓰레드풀에 반납
  * 최대 쓰레드가 모두 사용 중이라면 
    * 특정 숫자만큼 대기 시키거나, 거절
* 장점
  * 쓰레드가 미리 생성되어 있으므로, 쓰레드를 생성,종료 비용이 절약되고 응답 시간이 빠름
  * 너무 많은 요청이 들어와도 기존 요청은 안전하게 처리할 수 있다.



WAS의 주요 튜닝 포인트는 `최대 쓰레드 수` 이다.

>  적정 숫자는 어떻게 찾지?

- 로직 복잡도, CPU, Memory, IO Resource 상황에 따라 다 다름.
- 성능 테스트
  - 실제 서비스와 유사하게 성능 테스트 시도
  - 툴 : 아파치 AB, 제이미터, nGrinder



### WAS의 멀티 쓰레드 지원

* 멀티 쓰레드에 대한 부분은 WAS가 처리
* 개발자는 멀티 쓰레드 관련 코드를 신경쓰지 않아도 됨
* 멀티 쓰레드 환경이므로 싱글톤 객체(서블릿, 스프링 빈) 주의해서 사용하자



<hr>

URL 요청 시

- 정적 리소스 

- HTML 페이지

- HTTP API -주로 JSON 형태로 데이터 통신
  - 웹/앱 클라이언트 to 서버
  - 서버 to 서버



### SSR - 서버 사이드 렌더링

- 서버에서 최종 HTML을 생성해서 클라이언트에 전달

- 주로 정적인 화면

- JSP, 타임리프



### CSR - 클라이언트 사이드 렌더링

- JS를 사용하여 웹 브라우저에서 동적으로 생성해서 사용

- 주로 동적인 화면에 사용

<hr>


War jar 차이







