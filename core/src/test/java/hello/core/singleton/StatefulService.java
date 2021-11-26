package hello.core.singleton;

// ## 싱글톤 문제점
//1. 싱글톤 패턴을 구현하는 코드 자체가 많이 들어감
//2. 클라이언트가 구체 클래스에 의존함. ->DIP,OCP 위반
//3. 테스트가 어렵다.
//4. private 생성자로 자식 클래스를 만들기 어렵다.
//5. 결론적으로 유연성이 떨어짐.
public class StatefulService {

    //private int price; //상태를 유지하는 필드  ( 공유되는 필드이며, 특정 클라이언트가 값을 변경할 수 있음)

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);

        //this.price = price; //여기가 문제!!!!!!!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
