package umc.study.domain.mission;

import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.model.MissionRequest;
import umc.study.domain.store.entity.Store;

public class MissionConverter {
    public static Mission toMission(Store store, MissionRequest missionRequest) {
        return Mission.builder()
                .store(store)
                .reward(missionRequest.getReward())
                .mission_spec(missionRequest.getMission_spec())
                .deadline(missionRequest.getDeadLine())
                .build();
    }
}
