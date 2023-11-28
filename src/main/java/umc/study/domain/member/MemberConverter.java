package umc.study.domain.member;

import umc.study.domain.common.entity.FoodCategory;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.entity.MemberPrefer;
import umc.study.domain.member.model.MemberRequestDTO;
import umc.study.domain.member.model.MemberResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinRequestDTO request) {
        return Member.builder()
                .name(request.getName())
                .gender(Member.Gender.valueOf(request.getGender()))
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .category(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
