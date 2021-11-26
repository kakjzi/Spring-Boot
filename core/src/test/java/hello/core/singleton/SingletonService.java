package hello.core.singleton;

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
