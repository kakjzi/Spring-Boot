package hello.core.singleton;
// ## 싱글톤 문제점
//1. 싱글톤 패턴을 구현하는 코드 자체가 많이 들어감
//2. 클라이언트가 구체 클래스에 의존함. ->DIP,OCP 위반
//3. 테스트가 어렵다.
//4. private 생성자로 자식 클래스를 만들기 어렵다.
//5. 결론적으로 유연성이 떨어짐.

// -> 스프링컨테이너는 위의 문제를 해결하면서 싱글톤으로 객체를 만들어줌.  ㄷㄷ
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    //객체 인스턴스가 필요하다면 이 static 메서드를 통해서만 조회하도록 허용.
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        //외부에서 new 키워드를 사용하여 객체 생성을 못하게 막는다.
    }
    public void logic(){
        System.out.println("싱클톤 객체 로직 호출");
    }
}
