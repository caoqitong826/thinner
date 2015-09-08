package com.thinner.apps.utils;

import com.thinner.apps.mail.MailSenderInfo;
import com.thinner.apps.mail.SimpleMailSender;

/**
 * Created by caoqitong on 8/22/15.
 */
public class MailUtil {
  public static boolean senderMail(String toAddress,String mailTitle,String mailContent) {
    //这个类主要是设置邮件
    MailSenderInfo mailInfo = new MailSenderInfo();
    mailInfo.setMailServerHost("smtp.163.com");
    mailInfo.setMailServerPort("25");
    mailInfo.setValidate(true);
    mailInfo.setUserName("han2000lei@163.com");
    mailInfo.setPassword("**********");//您的邮箱密码
    mailInfo.setFromAddress("han2000lei@163.com");
    mailInfo.setToAddress(toAddress);
    mailInfo.setSubject(mailTitle);
    mailInfo.setContent(mailContent);
    //这个类主要来发送邮件
    SimpleMailSender sms = new SimpleMailSender();
    //sms.sendTextMail(mailInfo);//发送文体格式
    sms.sendHtmlMail(mailInfo);//发送html格式
    return true;
  }
}
