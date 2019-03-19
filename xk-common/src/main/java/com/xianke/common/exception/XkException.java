package com.xianke.common.exception;

import com.xianke.common.enums.ExceptionEnum;
import lombok.Getter;

/**
 *
 * 自定义异常类
 */
@Getter
public class XkException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

    public XkException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }


}
