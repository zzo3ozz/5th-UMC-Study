package umc.study.domain.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.config.Code;
import umc.study.domain.member.MemberRepository;
import umc.study.domain.member.entity.Member;
import umc.study.domain.store.entity.Review;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.model.ReviewRequest;
import umc.study.domain.temp.TempHandler;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Boolean addNewReview(Long storeId, ReviewRequest reviewRequest) {
        Member member = memberRepository.findById(1L).orElseThrow(() -> new TempHandler(Code.MEMBER_NOT_FOUND));

        // 어쩔 수 없이 store 검증이 한번 더 들어가는데 어노테이션으로 미리 검증하는 게 불필요하지 않나??
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new TempHandler(Code.STORE_NOT_FOUND));

        Review review = StoreConverter.toReview(member, store, reviewRequest);

        Review result = reviewRepository.save(review);

        if(result == null) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean isStoreExist(Long storeId) {
        Optional<Store> store = storeRepository.findById(storeId);
        if(store.isEmpty()) {
            return false;
        }

        return true;
    }
}
