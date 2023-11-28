package umc.study.domain.member;

import umc.study.domain.member.entity.Member;
import umc.study.domain.member.model.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinRequestDTO request);
}
