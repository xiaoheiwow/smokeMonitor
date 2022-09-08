package me.xhw.plugin.oauth2;

import me.xhw.exception.ReLoginException;
import me.xhw.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Map;

/**
 * @author admin
 */
@Configuration
public class TokenConfig {

    /**
     * JWT使用的秘钥
     */
    private final static String SIGNING_KEY = "micro-caa-abc";


    @Bean
    public TokenStore tokenStore(UserService userService){
        return new JwtTokenStore(accessTokenConverter(userService));
    }


    @Bean
    public JwtAccessTokenConverter accessTokenConverter(UserService userService){
        JwtAccessTokenConverter converter = new MyJwtAccessTokenConverter(userService);
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }

    public static class MyJwtAccessTokenConverter extends JwtAccessTokenConverter {
        private JsonParser objectMapper = JsonParserFactory.create();
        private SignatureVerifier verifier;
        private UserService userService;

        public MyJwtAccessTokenConverter(UserService userService) {
            this.userService=userService;
            SignatureVerifier verifier = new MacSigner(SIGNING_KEY);
            try {
                verifier = new RsaVerifier(SIGNING_KEY);
            } catch (Exception e) {
            }
            this.verifier = verifier;
        }

        @Override
        protected Map<String, Object> decode(String token) {
            try {
                Jwt jwt = JwtHelper.decodeAndVerify(token, verifier);
                String claimsStr = jwt.getClaims();
                Map<String, Object> claims = objectMapper.parseMap(claimsStr);
                //查看用户有没有修改过，修改后需要重新登陆
                String userName = claims.get("user_name").toString();
                Integer reLogin = userService.isReLogin(Long.valueOf(userName.substring(userName.lastIndexOf("||") + 2)));
                if(reLogin == 1 ){
                    throw new ReLoginException("User is changed, must reLogin ");
                }
                //
                if (claims.containsKey(EXP) && claims.get(EXP) instanceof Integer) {
                    Integer intValue = (Integer) claims.get(EXP);
                    claims.put(EXP, new Long(intValue));
                }
                this.getJwtClaimsSetVerifier().verify(claims);
                return claims;
            } catch (Exception e) {
                if(e instanceof ReLoginException){
                    throw  e;
                }
                throw new InvalidTokenException("Cannot convert access token to JSON", e);
            }
        }
    }
}
