package com.management.config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                       Exception ex) {
    Exception err = null;

    if(ex instanceof MyException) {
      err = ex;
    }else {
      err=new MyException("系统发生了异常");
    }
    ModelAndView result = new ModelAndView("error");
    result.addObject("message",err.getMessage());
    return result;
  }
}
