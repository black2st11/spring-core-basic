package helllo.core.order;

import helllo.core.AppConfig;
import helllo.core.member.Grade;
import helllo.core.member.Member;
import helllo.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private OrderService orderService;
    private MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
    }
    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}