package helllo.core;

import helllo.core.member.Grade;
import helllo.core.member.Member;
import helllo.core.member.MemberService;
import helllo.core.order.Order;
import helllo.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
    }
}
