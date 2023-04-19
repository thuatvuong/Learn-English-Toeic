package com.webtoeic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// interface đại diện cho class xử lý khi xác thực thành công
	@Autowired
	private AuthenticationSuccessHandler successHandler;

	// Lớp này đùng dể xác thực người dùng
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//  AuthenticationManager là một đối tượng dùng để quản lý quá trình xác thực của người dùng
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	// phương thức này dùng để xác thực người dùng AuthenticationManagerBuilder là một lớp hỗ trợ cấu hình cho authenticationManager cung cấp API cho phép người dùng cấu hình và xác thực
	// AuthenticationManagerBuilder được sử dụng dễ dàng cấu hình AuthenticationManager mà không cần triển khai giao diện
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	// sử dụng để cấu hình bảo vệ các tài nguyên của ứng dụng, thông qua filter nó sẽ được gọi khi ứng dụng được khởi động
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()// tắt tính năng CSRF (Cross-Site Request Forgery) để chống lại các yêu cầu giả mạo từ phía người dùng đến server
		    .authorizeRequests()// cấu hình quyền truy cập các URL được phép truy cập vào URL và những vai trò được phép truy cập vào URL
		        .antMatchers("/register").permitAll()// cho phép tất cả vào trang đăng kí và trang chủ
		        .antMatchers("/").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")// yêu cầu phải có Role là Amin
				.antMatchers("/profile").hasAnyRole("MEMBER, ADMIN")
				.antMatchers("/listExam").hasAnyRole("MEMBER","ADMIN")
			    .and()
			.oauth2Login()
				.and()
			.formLogin()// sử dụng cấu hình đăng nhập thông qua form
			    .loginPage("/login")
			    .usernameParameter("email")
				.passwordParameter("password")
				.successHandler(successHandler)// nếu xử lý thành công
				.failureUrl("/signin?error") // xử lý không thành công
			    .and()
			 .logout()
			    .logoutUrl("/signout")
			    .logoutSuccessUrl("/") // khi logout sẽ chuyển hướng đến home
			    .and()
	         .rememberMe().key("uniqueAndSecret").rememberMeParameter("remember-me")
	            .and()
			.exceptionHandling().accessDeniedPage("/signin?accessDenied");
	}
	

}

