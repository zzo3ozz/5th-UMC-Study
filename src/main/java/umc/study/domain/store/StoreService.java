package umc.study.domain.store;

import umc.study.domain.store.model.ReviewRequest;

public interface StoreService {
    public Boolean isStoreExist(Long storeId);

    public Boolean addNewReview(Long storeId, ReviewRequest reviewRequest);
}
