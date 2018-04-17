package cn.porkchop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${ADMINUSERNAME}")
    private String ADMINUSERNAME;
    @Value("${ADMINPASSWORD}")
    private String ADMINPASSWORD;


    /**
     * 用户认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(ADMINUSERNAME)
                .password(ADMINPASSWORD)
                .roles("ADMIN");
    }

    /**
     * 请求授权
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().headers().disable()
                .authorizeRequests()
                // 配置不需要身份认证的请求地址
                .antMatchers("/", "/static/**", "/film/**", "/webSite/**", "/webSiteInfo/**", "/about").permitAll()
                // 其他所有访问路径需要身份认证
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 指定登录请求地址
                .loginPage("/login")
                // 登录成功后的默认跳转页面
                .defaultSuccessUrl("/admin")
                .permitAll()
                .and()
                // 默认访问/logout登出
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}

