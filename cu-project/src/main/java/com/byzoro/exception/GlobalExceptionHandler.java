package com.byzoro.exception;


import com.byzoro.utils.ViewResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一处理抛出的异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获Exception异常，封装ViewResult
     * @param exception Exception
     * @return ViewResult
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ViewResult globalException(Exception exception){
        ViewResult exceptionResult = new ViewResult();
        exceptionResult.setStatus(ViewResult.ERROR);
        exceptionResult.setError(exception.toString());
        exceptionResult.setInfo("系统异常");
        exception.printStackTrace();
        return exceptionResult;
    }
}
