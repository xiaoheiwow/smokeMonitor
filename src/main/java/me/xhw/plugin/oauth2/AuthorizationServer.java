package me.xhw.plugin.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collections;


/**
 * @author admin
 * 授权服务
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Resource
    private TokenStore tokenStore;
    @Resource
    private JwtAccessTokenConverter accessTokenConverter;
    @Resource(name = "clientDetailsService")
    private ClientDetailsService clientDetailsService;
    @Value("${token.valid.hours}")
    private Integer tokenValidHours;

    /**
     * 密码模式需要的
     */
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private AuthorizationCodeServices authorizationCodeServices;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     *
     * @return token服务
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        //客户端信息服务
        services.setClientDetailsService(clientDetailsService);
        //支持刷新令牌
        services.setSupportRefreshToken(true);
        //token存储
        services.setTokenStore(tokenStore);
        //JWT---token增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(accessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);
        //JWT---token增强
        //2小时
        services.setAccessTokenValiditySeconds(tokenValidHours*60*60);
        //3天
        services.setRefreshTokenValiditySeconds(259200);
        return services;
    }

    @Bean("clientDetailsService")
    public ClientDetailsService clientDetailsService(DataSource dataSource){
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setPasswordEncoder(passwordEncoder());
        return clientDetailsService;
    }

    /**
     *
     * @return 授权码模式需要的
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource){
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    /**
     * @param    clients 管理客户端
     * @throws   Exception 23
     *
     * authorization_code：授权码模式：通过授权码获取token
     * implicit ：简化模式--》针对没有后端服务的前端，#传参
     *password：密码模式（要求客户端是自己开发的）
     *client_credentials:客户端模式--》内部系统使用
     *
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }
    /**
     *
     * @param endpoints 管理token
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices())
                .allowedTokenEndpointRequestMethods(HttpMethod.POST,HttpMethod.GET)
//                .pathMapping("/oauth/confirm_access","/qm/confirm_access")
        ;
    }

    /**
     *
     * @param security 安全约束
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.//jwt模式 ：oauth/token_key url 公开
                tokenKeyAccess("permitAll()")
                //oauth/check_token url 公开
                .checkTokenAccess("permitAll()")
                //运行表单认证
                .allowFormAuthenticationForClients();
    }

//    public static void main(String[] args) throws InterruptedException {
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//
//
//    }


}
