package umc.study.domain.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.config.Code;
import umc.study.domain.store.StoreService;
import umc.study.domain.validation.annotation.ExistStores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStores, Long> {
    private final StoreService storeService;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        System.out.println("initailize");
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid =  storeService.isStoreExist(value);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Code.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
