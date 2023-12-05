package umc.study.domain.store.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ReviewRequest {
    Float score;
    String content;
}
