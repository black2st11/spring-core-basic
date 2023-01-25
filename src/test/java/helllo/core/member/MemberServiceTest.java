package helllo.core.member;

import helllo.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
    }

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member result = memberService.findMember(1L);

        assertThat(member).isEqualTo(result);

    }

}