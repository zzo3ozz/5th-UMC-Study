package umc.study.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.config.Code;
import umc.study.config.ResponseDto;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.model.MemberRequestDTO;
import umc.study.domain.member.model.MemberResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ResponseDto<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinRequestDTO request) {
        System.out.println("test");

        Member member = memberCommandService.joinMember(request);

        return ResponseDto.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
