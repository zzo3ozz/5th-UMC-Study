package umc.study.domain.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.store.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
