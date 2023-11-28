package umc.study.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.config.Code;
import umc.study.domain.common.FoodCategoryRepository;
import umc.study.domain.common.entity.FoodCategory;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.entity.MemberPrefer;
import umc.study.domain.member.model.MemberRequestDTO;
import umc.study.domain.temp.TempHandler;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinRequestDTO request) {
        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository
                            .findById(category)
                            .orElseThrow(() -> new TempHandler(Code.FOOD_CATEGORY_ERROR));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> { memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
