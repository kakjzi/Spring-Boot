package com.example.demo;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 자바 코드로 직접 스프링 빈 등록하는 이유
// 현재 MemberRepository 는 변경 할 예정이므로 손쉽게 교체하기 위함.
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public  MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
