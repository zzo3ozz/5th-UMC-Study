package umc.study.domain.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.store.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
