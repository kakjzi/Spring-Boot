package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {


    //스프링JPA가 자동으로 구현해줌
    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
