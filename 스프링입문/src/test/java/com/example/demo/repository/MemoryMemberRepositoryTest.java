package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LogRecordListener;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void test () {

    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("jiwoo");

        repository.save(member);

        Member result =  repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

        //assertThat(actual).isEqualTo(expected);
        assertThat(member).isEqualTo(result);
        // == Assertions.assertEquals(member, result);
    }

    //소소한 꿀팁 shift + F6 -> variable rename
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("jiwoo1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jiwoo2");
        repository.save(member2);

        Member result = repository.findByName("jiwoo1").get();
//        System.out.println(repository.findByName("jiwoo1").get());
//        System.out.println(repository.findByName("jiwoo2").get());
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("jiwoo1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jiwoo2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
