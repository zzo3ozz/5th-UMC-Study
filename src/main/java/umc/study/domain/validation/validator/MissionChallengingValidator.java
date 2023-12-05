package umc.study.domain.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.config.Code;
import umc.study.domain.mission.MissionService;
import umc.study.domain.mission.model.MyMission;
import umc.study.domain.validation.annotation.ChallengingMissions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Component
public class MissionChallengingValidator implements ConstraintValidator<ChallengingMissions, Long> {
    private final MissionService missionService;

    @Override
    public void initialize(ChallengingMissions constraintAnnotation) {
        System.out.println("initialize");
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = !missionService.isChallenging(value);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Code.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
