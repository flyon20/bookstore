package com.panch.bookstore.handler;


import com.panch.bookstore.common.APIResponse;
import com.panch.bookstore.service.ErrorLogService;
import com.panch.bookstore.common.ResponeCode;
import com.panch.bookstore.entity.ErrorLog;
import com.panch.bookstore.utils.HttpContextUtils;
import com.panch.bookstore.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Autowired
    private ErrorLogService service;

    @ExceptionHandler(Exception.class)
    public APIResponse handleException(Exception ex){
        logger.error("error log======>" + ex.getMessage(), ex);

        saveLog(ex);
        return new APIResponse(ResponeCode.FAIL, ex.getMessage());
    }

    /**
     * 保存异常日志
     */
    private void saveLog(Exception ex){
        ErrorLog log = new ErrorLog();
        //请求相关信息
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.setIp(IpUtils.getIpAddr(request));
        log.setUrl(request.getRequestURI());
        log.setMethod(request.getMethod());
        // 请求参数
        Map<String, String> params = HttpContextUtils.getParameterMap(request);
        if(!params.isEmpty()){
            //log.setRequestParams(JsonUtils.toJsonString(params));
        }

        //异常信息
        log.setContent(Arrays.toString(ex.getStackTrace()));
        log.setLogTime(String.valueOf(System.currentTimeMillis()));

        //保存
        service.createErrorLog(log);
    }
}
