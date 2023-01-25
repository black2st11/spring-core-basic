package helllo.core;

import helllo.core.member.Grade;
import helllo.core.member.Member;
import helllo.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member result = memberService.findMember(1L);

        System.out.println("Member = " + member.getName());
        System.out.println("Find Member = " + result.getName());
    }
}
