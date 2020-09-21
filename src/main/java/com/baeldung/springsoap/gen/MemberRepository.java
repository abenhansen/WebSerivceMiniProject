package com.baeldung.springsoap.gen;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberRepository {

    private static final Map<String, Member> members = new HashMap<>();

    @PostConstruct
    public void initData() {
      Member member = new Member("Svend", "svend@mail.dk", 18, Role.MEMBER);
      members.put(member.getEmail(), member);
    }

    public Member findMember(String email){
        return members.get(email);
    }

}
