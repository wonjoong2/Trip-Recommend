package com.example.board.service;

//import com.study.email_verification.common.util.RedisUtil;
import com.example.board.mapper.EmailMapper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.Map;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private final JavaMailSender javaMailSender;

    private static final String senderEmail = "wjkim0331@naver.com";

    private String createCode() {
        int leftLimit = 48; // number '0'
        int rightLimit = 122; // alphabet 'z'
        int targetStringLength = 6;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 | i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    // 이메일 내용 초기화
    private String generateEmailContent(String code) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                "<div style='margin:120px'>" +
                "  <div style='margin-bottom: 10px'>" +
                "    <h1>인증 코드 메일입니다.</h1>" +
                "    <br/>" +
                "    <h3 style='text-align: center;'> 아래 코드를 사이트에 입력해주십시오</h3>" +
                "  </div>" +
                "  <div style='text-align: center;'>" +
                "    <h2 style='color: crimson;'>" + code + "</h2>" +
                "  </div>" +
                "  <br/>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

    // 이메일 폼 생성
    private MimeMessage createEmailForm(String email,String authCode) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, email);
        message.setSubject("안녕하세요. 인증번호입니다.");
        message.setFrom(senderEmail);

        // HTML 본문 설정
        String emailContent = generateEmailContent(authCode);
        message.setContent(emailContent, "text/html; charset=utf-8");

        return message;
    }


    // 인증코드 이메일 발송
    public String sendEmail(String toEmail) throws MessagingException {

        String authCode = createCode();
        // 이메일 폼 생성
        MimeMessage emailForm = createEmailForm(toEmail ,authCode);
        // 이메일 발송
        javaMailSender.send(emailForm);

        return authCode;
    }
    public String mailIdFind(Map<String, Object> params) {
        EmailMapper mapper = sqlSessionTemplate.getMapper(EmailMapper.class);
        String mailIdFind = mapper.mailIdFind(params);
        return mailIdFind;
    }

    public int mailPwFind(Map<String, Object> params) {
        EmailMapper mapper = sqlSessionTemplate.getMapper(EmailMapper.class);
        int mailPwFind = mapper.mailPwFind(params);
        return mailPwFind;
    }
}