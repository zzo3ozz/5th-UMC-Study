package umc.study.domain.mission.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class MissionRequest {
    @NotNull
    private int reward;
    private LocalDate deadLine;
    private String mission_spec;
}
