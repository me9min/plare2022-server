package org.amel.plare.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.amel.plare.member.domain.MemberLoginVO;
import org.amel.plare.member.domain.MemberVO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenizer jwtTokenizer;


    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        ObjectMapper objectMapper = new ObjectMapper();
        MemberLoginVO loginVO = objectMapper.readValue(request.getInputStream(), MemberLoginVO.class);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVO.getAuthId(), loginVO.getPassword());

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) {
        MemberVO memberVO = (MemberVO) authentication.getPrincipal();

        String accessToken = delegateAccessToken(memberVO);
        String refreshToken = delegateRefreshToken(memberVO);

        response.setHeader("Authorization", "Bearer " + accessToken);
        response.setHeader("Refresh", refreshToken);
    }

    private String delegateAccessToken(MemberVO memberVO) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", memberVO.getAuthId());
        claims.put("name", memberVO.getName());

        String subject = memberVO.getEmail();
        Date expiration = jwtTokenizer.getTokenExpire(jwtTokenizer.getAccessTokenExpireMinutes());
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());
        return jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);
    }

    private String delegateRefreshToken(MemberVO memberVO) {
        String subject = memberVO.getEmail();
        Date expiration = jwtTokenizer.getTokenExpire(jwtTokenizer.getRefreshTokenExpireMinutes());
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());
        return jwtTokenizer.generateRefreshToken(subject, expiration, base64EncodedSecretKey);
    }
}
