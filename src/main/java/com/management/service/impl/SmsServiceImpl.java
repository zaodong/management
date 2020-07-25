package com.management.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.management.config.SmsUtils;
import com.management.service.SmsService;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public void sms(String phone)  {
        String code = SmsUtils.code();
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = SmsUtils.sendSms(phone, code);
            String code1 = sendSmsResponse.getCode();
            //可以加入第三方库方便后续验证码比较
        } catch (ClientException e) {
            e.printStackTrace();
        }


    }
}
