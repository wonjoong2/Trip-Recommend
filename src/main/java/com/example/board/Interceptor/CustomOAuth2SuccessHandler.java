package com.example.board.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final HttpSession session;

    public CustomOAuth2SuccessHandler(HttpSession session) {
        this.session = session;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

        // 사용자 정보를 세션에 저장
        String userId = (String) oauth2User.getAttributes().get("sub");
        String email = (String) oauth2User.getAttributes().get("email");

        session.setAttribute("userId", userId);
        session.setAttribute("email", email);
        response.sendRedirect("/board/BoardList");
    }
}