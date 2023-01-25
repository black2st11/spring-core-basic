package helllo.core.discount;

import helllo.core.member.Grade;
import helllo.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
