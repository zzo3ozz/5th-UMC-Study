package umc.study.domain.temp;

import umc.study.config.Code;
import umc.study.config.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(Code errorCode){
        super(errorCode);
    }
}