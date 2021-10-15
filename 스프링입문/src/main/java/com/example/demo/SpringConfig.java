package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;


// 자바 코드로 직접 스프링 빈 등록하는 이유
// 현재 MemberRepository 는 변경 할 예정이므로 손쉽게 교체하기 위함.
@Configuration
public class SpringConfig {

    //@Autowired DataSource dataSource; // 방법 1

    // 방법2
    //private DataSource dataSource;

    // 방법3
    //@Autowired
    //public SpringConfig(DataSource dataSource){
    //    this.dataSource=dataSource;
    //}

    // JPA
/*    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    // spring JPA

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/*    @Bean
    public  MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }*/
}
