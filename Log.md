# Log

운영 시스템에서는 `System.out.println()` 같은 시스템 콘솔을 사용해서 필요한 정보를 출력하지 않고 로깅 라이브러리를 사용하여 로그를 출력함.



## 로깅 라이브러리

Spring-boot-starter-logging 



* SLF4J - 인터페이스
* Logback  - 구현체



```java
@RestController
@Slf4j
public class LogTestController {
   
  // @Slf4j 로 대체 (롬복이 처리해줌)
  //private final Logger log = LoggerFactory.getLogger(getClass());
 
    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.info("info log={}", name);

        return "ok";
    }
}
```





**@Controller**

> 주로 View를 반환하기 위해 사용
>
> 반환 값이 `String` 이면 뷰 이름으로 인식.



**@RestController**

> 주로 Data를 반환할 때 사용 (Http 메시지 바디에 바로 입력)
>
> 단순 문자열인 경우에는 `StringHttpMessageConverter`가 사용
>
> 객체인 경우에는 `MappingJackson2HttpMessageConverter`가 사용
>
> 데이터 종류에 따라 서로 다른 `MessageConverter`가 작동





#### Application.properties 내에서

```
logging.level.hello.springmvc= '로그 레벨'


# 아래로 갈수록 심각도 레벨 증가
# trace : log 모두 다 조회 (로컬 서버 단계)
# debug : debug, info , warn, error 모두 조회 (개발 서버 단계)
# info : 운영 서버는 보통 info 레벨
# warn 
# error
```



 스프링 부트의 전체 로그 레벨 

`Logging.level.root = info` 로 기본 설정되어있음.



* 올바른 로그 사용법

```
logging.level.hello.springmvc=debug
```

위와 같이 프로젝트 로그 레벨이 '디버그' 인 상황이고 

코드에서 로그를 찍어볼 때

* `log.trace("trace my log =" + name);`  
  * 로그에는 남지 않지만  ' + ' 연산자 때문에 연산이 일어나 **메모리를 차지**하게 된다. (리소스 낭비) 

* `log.trace("trace my log ={}", name);` 
  * 로그에 남지 않고 아무 연산도 일어나지 않는다.



* 로그 장점
  * 시스템 콘솔 뿐 아니라 파일, 네트워크등 별도의 위치에 남길 수 있다.
  * 파일로 남길 때 일별, 특정 용량에 따라 로그를 분할 하는 것도 가능
  * 성능도 System.out 보다 좋음 