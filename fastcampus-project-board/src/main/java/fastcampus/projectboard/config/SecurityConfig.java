package fastcampus.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //WebSecurityConfigurerAdapter 이거 이제 안씀 Coponent스타일로 바뀜

        return http
                .authorizeRequests(auth -> auth.anyRequest().permitAll())
                .formLogin().and()
                .build();

    }
}
