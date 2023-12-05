package umc.study.domain.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.config.Code;
import umc.study.config.GeneralException;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.model.MissionRequest;
import umc.study.domain.store.StoreRepository;
import umc.study.domain.store.entity.Store;

@Transactional
@RequiredArgsConstructor
@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public boolean addMission(Long storeId, MissionRequest missionRequest) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(Code.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(store, missionRequest);

        Mission result = missionRepository.save(mission);

        if(result == null)
            return false;

        return true;
    }
}
