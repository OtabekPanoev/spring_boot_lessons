package uz.pdp.spring_boot_lessons.conf;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "31321Jwt21cret76575646Key131231wt21cret76575646Key1312311321Jwt21cret76575646Key131231wt21cret76575646Key131231";

    public String generate(String username) {

        String compact = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 day
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return compact;
    }

}
