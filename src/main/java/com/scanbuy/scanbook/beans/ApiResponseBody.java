package com.scanbuy.scanbook.beans;

import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;

import java.util.Date;
import java.util.List;

public class ApiResponseBody {
    //List<ApiError> apiErrorList;
    String timestamp = new Date().toString();

}
