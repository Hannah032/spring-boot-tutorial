package com.springBoot.Chap10.config;

import com.springBoot.Chap10.config.oauth.SpringOauth2PrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // 설정 클래스임을 나타내는 어노테이션
@EnableWebSecurity  // Spring Security 설정 활성화 어노테이션
public class SecurityConfiguration {

    @Autowired
    SpringOauth2PrincipalDetailsService springOAuth2PrincipalDetailsService;

    @Bean  // SecurityFilterChain 빈을 정의하는 메서드
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
//                .requestMatchers("/**").permitAll() // 모든 요청 허용
//                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // /admin/** 경로는 ROLE_ADMIN 권한 필요
//                        .requestMatchers("/manager/**").hasRole("MANAGER")       // /manager/** 경로는 ROLE_MANAGER 권한 필요
//                        //.requestMatchers("/member/**").authenticated()           // /member/** 경로는 인증된 사용자만 접근 가능
//                        .requestMatchers("/member/**").hasAnyRole("ADMIN","USER") // /member/** 경로는 ROLE_ADMIN 또는 ROLE_USER 권한 필요
                                .requestMatchers("/admin").hasRole("ADMIN")  // /admin 경로는 ROLE_ADMIN 권한 필요
                                .anyRequest().permitAll() // 그 외의 모든 요청은 허용
                )
                // 로그인 설정
                //.formLogin(Customizer.withDefaults())   // Spring Security 기본 로그인 폼 사용
                .formLogin(formLogin -> formLogin
                        .loginPage("/exam05")          // 커스텀 로그인 페이지 경로 설정(GET 요청 처리)
                        .loginProcessingUrl("/exam05") // 로그인 폼 action 경로 설정(POST 요청 처리)
                        .defaultSuccessUrl("/admin")   // 로그인 성공 시 이동할 기본 URL 설정
                        .usernameParameter("username") // 로그인 폼에서 사용할 사용자 이름 파라미터명 설정
                        .passwordParameter("password") // 로그인 폼에서 사용할 비밀번호 파라미터명 설정
                        .failureUrl("/loginfailed") // 로그인 실패 시 이동할 URL 설정
                )
                // 로그아웃 설정
                .logout(logout -> logout
                        .logoutUrl("/logout")               // 로그아웃 처리 URL 설정
                        .logoutSuccessUrl("/exam05")        // 로그아웃 성공 시 이동할 URL 설정
                        .invalidateHttpSession(true)        // 로그아웃 시 세션 무효화 설정
                )
                // 외부 로그인 설정
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/exam05") // 커스텀 로그인 페이지 경로 설정
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(springOAuth2PrincipalDetailsService) // OAuth2 사용자 정보 서비스 설정
                        )
                )
        ;

        return http.build(); // SecurityFilterChain 객체 반환
    }

    // UserDetailsService이라는 이름의 빈으로 사용자 정보를 임시로 저장
    @Bean
    public UserDetailsService userDetailsService() {
        // admin계정
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("a1234")) // 비밀번호 암호화
                .roles("ADMIN") // ROLE_ADMIN 권한 부여(authority("ROLE_ADMIN")와 동일)
                .build();

        // 일반user계정
        UserDetails user = User.builder()
                .username("guest")
                .password(passwordEncoder().encode("g1234")) // 비밀번호 암호화
                .roles("USER") // ROLE_USER 권한 부여(authority("ROLE_USER")와 동일)
                .build();

        // manager계정
        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder().encode("m1234")) // 비밀번호 암호화
                .roles("MANAGER") // ROLE_MANAGER 권한 부여(authority("ROLE_MANAGER")와 동일)
                .build();

        // InMemoryUserDetailsManager를 사용하여 사용자 정보를 메모리에 저장
        return new InMemoryUserDetailsManager(admin, user, manager);
    }

    // PasswordEncoder 빈 정의 (비밀번호 암호화에 사용)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}