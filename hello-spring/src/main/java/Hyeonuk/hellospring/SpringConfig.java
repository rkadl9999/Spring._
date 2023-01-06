package Hyeonuk.hellospring;

import Hyeonuk.hellospring.repository.MemberRepository;
import Hyeonuk.hellospring.repository.MemoryMemberRepository;
import Hyeonuk.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


}
