// package com.wecp.progressive.jwt;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
 
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// import javax.crypto.SecretKey;
 
// @Component
// public class JwtUtil {
 
//     private final String secret = "qwertyuiopasdfghjklzxcvbnm12345678900000000000zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"; // Secret key for signing JWT
//     //private final SecretKey secret = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//     private final int expiration = 1000*60*60*10; // Token expiration (24 hours in ms)
 
//  //   Generate token with username
//     public String generateToken(String username) {
//         Map<String,Object> claims = new HashMap<>();
//         return createToken(claims, username);
//     }
 
//     private String createToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject) // username
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }
 
//     // Extract all claims
//     public Claims extractAllClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
 
//     // Extract username from token
//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }
 
//     // Generic method to extract a claim
//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }
 
//     // Check if token has expired
//     public boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }
 
//     private Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }
 
//     // Validate token with UserDetails
//     public boolean validateToken(String token, UserDetails userDetails) {
//         final String username = extractUsername(token);
//         return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//     }
// }
 
 

package com.wecp.progressive.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

   private static final SecretKey key=Keys.secretKeyFor(SignatureAlgorithm.HS512); // Use a SecretKey object
    private final int expiration = 1000 * 60 * 60 * 10; // Token expiration (10 hours in ms)

    // Constructor to generate a secure key once
    public JwtUtil() {
       // this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    // Generate token with username
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key) // ,SignatureAlgorithm.HS512
                .compact();
    }

    // Extract all claims
    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key) // Use the SecretKey object
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            System.err.println("JWT signature does not match locally computed signature.");
            throw e;
        }
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Generic method to extract a claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Check if token has expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Validate token with UserDetails
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
