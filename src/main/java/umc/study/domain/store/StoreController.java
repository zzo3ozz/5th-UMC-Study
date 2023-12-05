package umc.study.domain.store;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.config.ResponseDto;
import umc.study.domain.store.model.ReviewRequest;
import umc.study.domain.validation.annotation.ExistStores;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Validated
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/{storeId}/reviews")
    public ResponseDto<Boolean> addReview(@PathVariable @ExistStores long storeId, @RequestBody ReviewRequest reviewRequest) {
        Boolean result = storeService.addNewReview(storeId, reviewRequest);
        return ResponseDto.onSuccess(result);
    }
}
