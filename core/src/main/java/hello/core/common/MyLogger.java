package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) //실제 http요청이 오지않았기 때문에 에러 / 이 단계는 DI 생성과 초기화 단계에서 정해지므로 뒤로 미뤄야함
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {  //생성 시점을 알 수 없으므로 setter로..
        this.requestURL = requestURL;
    }

    public void log(String msg) {
        System.out.println("[" + uuid +"] " +" ["+ requestURL + "] "+ msg);
    }

    @PostConstruct //빈 초기화 단계
    public void init() {
        uuid = UUID.randomUUID().toString(); //유일한 랜덤 값
        System.out.println("[" + uuid +"] request scope bean create: " + this);
    }

    @PreDestroy //빈 종료 바로 전
    public void close(){
        System.out.println("[" + uuid +"] request scope bean close: " + this);
    }
}
