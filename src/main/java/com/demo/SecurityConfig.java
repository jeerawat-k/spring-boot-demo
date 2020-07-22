package com.demo;
 
 import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {//config path ไหนบ้างที่เราจะให้ผ่านได้
		http
			.authorizeRequests()
				.antMatchers("/**.js", "/**.css","/login/**").permitAll()
				.antMatchers("/*").hasRole("USER") // คือ ถ้าเข้า path role ต้องเป็น USER
				.and()
			.formLogin()
				.loginPage("/login").defaultSuccessUrl("/home", true).failureUrl("/login");	
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { // method นี้ คือกำหนด user กับ role
		auth
			.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER");//{noop} ที่ต้องใส่เพราะว่า เป็นการ Ignore เพื่อให้ใส่คำว่าว่า password
	}

	@Bean
  	public WebMvcConfigurer myWebMvcConfigurer() {
      return new WebMvcConfigurerAdapter() {

		  @Override
		  public void addViewControllers(ViewControllerRegistry registry) {
			  registry.addViewController("/home").setViewName("site.homepage");
			  registry.addViewController("/login").setViewName("login");
		  }
      };
  }
}
