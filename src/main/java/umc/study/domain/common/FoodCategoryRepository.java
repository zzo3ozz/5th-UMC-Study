package umc.study.domain.common;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.common.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
