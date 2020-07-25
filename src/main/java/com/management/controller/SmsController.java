package com.management.controller;

import com.management.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SmsController {
    @Autowired
    private SmsService smsService;
    @RequestMapping("/sms")
    public  void sms(){
            smsService.sms("15228413449");
        }
}
