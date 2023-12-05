package umc.study.domain.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.member.entity.Member;
import umc.study.domain.mission.entity.MemberMission;
import umc.study.domain.mission.entity.Mission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    public List<MemberMission> findByMemberAndMission(Member member, Mission mission);
}
