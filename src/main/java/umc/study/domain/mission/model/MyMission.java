package umc.study.domain.mission.model;

import lombok.*;
import umc.study.domain.member.entity.Member;
import umc.study.domain.mission.entity.Mission;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class MyMission {
    private Member member;
    private Mission mission;
}
