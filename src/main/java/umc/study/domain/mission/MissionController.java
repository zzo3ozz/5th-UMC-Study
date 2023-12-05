package umc.study.domain.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.config.ResponseDto;
import umc.study.domain.mission.model.MissionRequest;
import umc.study.domain.validation.annotation.ExistStores;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Validated
public class MissionController {
    private final MissionService missionService;

    @PostMapping("/{storeID}")
    public ResponseDto<Boolean> addMission(@PathVariable @ExistStores long storeID, @RequestBody MissionRequest missionRequest) {
        return null;
    }
}