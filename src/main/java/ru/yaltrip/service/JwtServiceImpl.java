package ru.yaltrip.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.User;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * This class implements {@link JwtService} methods.
 * This service contains methods for working with the jwt token.
 */
@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.key}")
    private String jwtSecretKey;

    @Override
    public String extractPhoneNumber(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof User customUserDetails) {
            claims.put("id", customUserDetails.getId());
            claims.put("phoneNumber", customUserDetails.getPhoneNumber());
            claims.put("role", customUserDetails.getRoles());
        }
        return generateToken(claims, userDetails);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String phoneNumber = extractPhoneNumber(token);
        return (phoneNumber.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * extract data from token.
     *
     * @param token           token
     * @param claimsResolvers function extract data
     * @param <T>             data type
     * @return data
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    /**
     * Generate token.
     *
     * @param extraClaims extra data
     * @param userDetails user data
     * @return token
     */
    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .claims().empty().add(extraClaims).subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 5000 * 60 * 24))
                .and()
                .signWith(getSecretKey(), Jwts.SIG.HS256).compact();
    }

    /**
     * Check token on expiration.
     *
     * @param token token
     * @return true, if token expired
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extract date of expiration from token.
     *
     * @param token token
     * @return expiration date
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extract all data from token.
     *
     * @param token token
     * @return data
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
    }

    /**
     * Get key for signature token.
     *
     * @return key
     */
    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(jwtSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
