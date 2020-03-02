package org.learning.springbootcache.excption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResultBody bizExceptionHandler(HttpServletRequest request, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("未知异常！原因是:", e);
        return ResultBody.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
