package umc.study.domain.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.config.Code;
import umc.study.config.ResponseDto;
import umc.study.domain.temp.model.TempResponse;
import umc.study.domain.temp.service.TempQueryService;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempController {
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testAPI(){
        return ResponseDto.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ResponseDto<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ResponseDto.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}