package umc.study.domain.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import umc.study.config.Code;
import umc.study.config.GeneralException;
import umc.study.domain.member.MemberRepository;
import umc.study.domain.member.entity.Member;
import umc.study.domain.mission.entity.MemberMission;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.model.MissionRequest;
import umc.study.domain.mission.model.MyMission;
import umc.study.domain.store.StoreRepository;
import umc.study.domain.store.entity.Store;
import umc.study.domain.validation.annotation.ChallengingMissions;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public boolean addMission(Long storeId, MissionRequest missionRequest) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(Code.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(store, missionRequest);

        Mission result = missionRepository.save(mission);

        if(result == null)
            return false;

        return true;
    }

    @Validated
    public boolean challengeMission(Long missionId) {
        Member member = memberRepository.findById(1L).orElseThrow(() -> new GeneralException(Code.MEMBER_NOT_FOUND));
        Mission misson = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(Code.MISSION_NOT_FOUND));
        MyMission myMission = MyMission.builder().member(member).mission(misson).build();

        MemberMission result = memberMissionRepository.save(MissionConverter.toMemberMission(myMission));

        if(result == null)
            return false;

        return true;
    }

    public boolean isChallenging(Long missionId) {
        Member member = memberRepository.findById(1L).orElseThrow(() -> new GeneralException(Code.MEMBER_NOT_FOUND));
        Mission misson = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(Code.MISSION_NOT_FOUND));
        List<MemberMission> list = memberMissionRepository.findByMemberAndMission(member, misson);

        if(list.isEmpty()) {
            return false;
        }

        return true;
    }
}
