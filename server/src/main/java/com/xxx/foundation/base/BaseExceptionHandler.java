package com.xxx.foundation.base;

import com.pica.cloud.foundation.utils.PicaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2020/4/16 17:21
 * author:crs
 * Description:异常处理器
 */
@ControllerAdvice(annotations = {RestController.class})
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);
    private static final String JSON_FORMAT_TEMP = "{\"code\": \"%s\",\"message\": \"%s\",\"from\": \"%s\",\"path\": \"%s\"}";
    private static final HttpHeaders headers = new HttpHeaders();


    public BaseExceptionHandler() {
        //json字符串类型
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, 0);
        }

        logger.error(ex.getMessage(), ex);
        return new ResponseEntity(body, headers, status);
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<PicaResponse> handleException(Exception ex, HttpServletRequest request) {
        int code = 500005;
        String msg = "接口调用时内部存在异常";
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof BaseException) {
            code = ((BaseException) ex).getCode();
            msg = ((BaseException) ex).getMsg();
            httpStatus=HttpStatus.OK; //这次请求成功
        }

        String url = request.getRequestURI();
        if (!StringUtils.isEmpty(request.getQueryString())){
            url = url + "?" + request.getQueryString();
        }

        String json = String.format("{\"code\": \"%s\",\"message\": \"%s\",\"from\": \"%s\",\"path\": \"%s\"}", code, msg, request.getRemoteAddr(), url);
        //打印错误日志
        logger.error(json, ex);
        return new ResponseEntity((new BaseResponse.Builder()).setCode(code).setMsg(msg).builder(),headers,httpStatus);
    }
}
