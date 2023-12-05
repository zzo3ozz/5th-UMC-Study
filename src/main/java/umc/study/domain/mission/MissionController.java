package umc.study.domain.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.config.ResponseDto;
import umc.study.domain.mission.model.MissionRequest;
import umc.study.domain.validation.annotation.ChallengingMissions;
import umc.study.domain.validation.annotation.ExistStores;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Validated
public class MissionController {
    private final MissionService missionService;

    @PostMapping("/{storeID}")
    public ResponseDto<Boolean> addMission(@PathVariable @ExistStores long storeID, @RequestBody @Valid MissionRequest missionRequest) {
        Boolean result = missionService.addMission(storeID, missionRequest);

        return ResponseDto.onSuccess(result);
    }

    @PostMapping("/mymission/{missionId}")
    public ResponseDto<Boolean> challengeMission(@PathVariable @ChallengingMissions long missionId) {
        Boolean result = missionService.challengeMission(missionId);

        return ResponseDto.onSuccess(result);
    }
}