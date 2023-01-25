package helllo.core.member;

import java.util.Map;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
