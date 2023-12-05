package umc.study.domain.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class JoinRequestDTO {
        String name;
        String gender;
        String birth;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
