package org.amel.plare.config;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

@Component
public class JwtTokenizer {

	@Getter
	@Value("${jwt.secret-key}")
	private String secretKey;

	@Getter
	@Value("${jwt.access-minutes}")
	private int accessTokenExpireMinutes;

	@Getter
	@Value("${jwt.refresh-minutes}")
	private int refreshTokenExpireMinutes;

	public String encodeBase64SecretKey(String secretKey) {
		return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
	}

	public String generateAccessToken(Map<String, Object> claims, String subject, Date expiration,
			String base64EncodedSecretKey) {
		Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Calendar.getInstance().getTime())
				.setExpiration(expiration).signWith(key).compact();
	}

	public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey) {
		Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

		return Jwts.builder().setSubject(subject).setIssuedAt(Calendar.getInstance().getTime())
				.setExpiration(expiration).signWith(key).compact();
	}

	public Jws<Claims> getClaims(String jws, String base64EncodedSecretKey) {
		Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws);
	}

	public void verifySignature(String jws, String base64EncodedSecretKey) {
		Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

		Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws);
	}

	public Date getTokenExpire(int expirationMinutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, expirationMinutes);

		return calendar.getTime();
	}

	private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey) {
		byte[] KeyBytes = Decoders.BASE64.decode(base64EncodedSecretKey);
		return Keys.hmacShaKeyFor(KeyBytes);
	}
}