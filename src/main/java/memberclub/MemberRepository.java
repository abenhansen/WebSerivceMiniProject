package memberclub;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberRepository {

    private static final Map<String, Member> members = new HashMap<>();

    @PostConstruct
    public void initData() {
        Member member = new Member();
        member.setName("Svend");
        member.setEmail("svend@mail.dk");
        member.setAge(18);
        members.put(member.getEmail(), member);
    }

    public Member findMember(String email) {
        return members.get(email);
    }

}
