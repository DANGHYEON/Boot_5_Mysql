package com.iu.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		//정적자원 요청 url은 Security 거치지않고 통과
		web.ignoring()
					 .antMatchers("/css/**")
					 .antMatchers("/js/**")
					 .antMatchers("/images/**")
					 .antMatchers("/vendor/**")
					 .antMatchers("/favicon/**")
					 .antMatchers("/resources/**");
					 
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.csrf().disable()
			.authorizeRequests()
								.antMatchers("/").permitAll()
								.antMatchers("/notice/selectList","/notice/selectOne").permitAll()
								.antMatchers("/notice/**").hasRole("ADMIN")
								//.antMatchers("/notice/insert","/notice/update","/noitce/delete").hasRole("ADMIN")
								//ROLE_를 제외한 나머지 roleName
								//.antMatchers("/member/memberLogin").permitAll()
								.antMatchers("/member/meberJoin").permitAll()
								.anyRequest().authenticated()
								//위의 antMathchers 그외 나머지는 인증(로그인)이 되어야 가능
								.and()
			
			//Security에서는 기본 로그인 폼을 제공
			//개발자가 만든 로그인폼으로 사용
			.formLogin()
						.loginPage("/member/memberLogin")
						.defaultSuccessUrl("/")
						//파라미터이름은 security에서는 username 사용
						//파라미터 이름이 다를 경우 작성
						.usernameParameter("id")
						.passwordParameter("pw")
						.permitAll()
			
								
								;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//Spring 5 이후 부터, 비밀번호를 평문 저장 금지(암호화)
		return new BCryptPasswordEncoder();
	}
	
	
	
	

}
