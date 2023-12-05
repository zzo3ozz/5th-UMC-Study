package umc.study.domain.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;
    public boolean isValidCategory(List<Long> values) {
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));

        return isValid;
    }
}
