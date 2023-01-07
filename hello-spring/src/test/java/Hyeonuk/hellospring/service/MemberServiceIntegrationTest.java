package Hyeonuk.hellospring.service;

import Hyeonuk.hellospring.domain.Member;
import Hyeonuk.hellospring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void validateMemberException() {
        //given
        Member member1 = new Member();
        member1.setName("test");

        Member member2 = new Member();
        member2.setName("test");
        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

    }

    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("JHU");
        Member member2 = new Member();
        member2.setName("JYW");
        memberService.join(member1);
        memberService.join(member2);

        List<Member> memberList = memberService.findMembers();
        System.out.println(memberList);
    }

    @Test
    void findOne() {
        Member member = new Member();
        member.setName("JHU");
        Long memberId = memberService.join(member);

        Optional<Member> memberOne = memberService.findOne(memberId);
        System.out.println(memberOne);
    }
}
