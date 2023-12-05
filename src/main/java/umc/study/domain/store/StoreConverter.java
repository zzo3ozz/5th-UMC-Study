package umc.study.domain.store;

import umc.study.domain.member.entity.Member;
import umc.study.domain.store.entity.Review;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.model.ReviewRequest;

public class StoreConverter {
    public static Review toReview(Member member, Store store, ReviewRequest reviewRequest) {
        return Review.builder()
                .member(member)
                .store(store)
                .body(reviewRequest.getContent())
                .score(reviewRequest.getScore())
                .build();
    }
}
