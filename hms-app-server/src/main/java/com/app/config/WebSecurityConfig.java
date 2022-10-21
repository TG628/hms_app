package com.app.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.filters.JWTRequestFilter;

@EnableWebSecurity // mandatory
@Configuration // mandatory to enable adding @Bean annotated methods
@EnableGlobalMethodSecurity(prePostEnabled = true)//to enable adding method level author
public class WebSecurityConfig {

	@Autowired
	private JWTRequestFilter filter;

	// configure BCryptPassword encode bean
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * All end Points: Permit All- "/user/login","/patient/register","/careers/newApplication","/user/doctorsList","/user/timeslotsAvailability"
		 * 
		 * Permit to patient -
		 * "/patient/{patId}/update","/patient/{patId}/bookAppointment",
		 * "/patient/{patId}/subscribePlan",
		 * "/patient/{patId}/image","/patient/{patId}","/patient/{patId}/reports",
		 * "/patient/report/{aptId}"
		 * 
		 * Permit to Staff- "/staff/uploadReport/{aptId}","staff/{staffId}/image",
		 * "/staff/showAppointments","/staff/{staffId}/update"
		 * 
		 * Permit to Admin -
		 * "/admin/updateShifts","/admin/add/admin","/admin/add/staff",
		 * "/careers/{applnId}/updateStatus",
		 * "/careers/{applnId}/resume","/careers/applicantsList"
		 * 
		 * Permit to Admin and Staff- "/admin/staffSchedule"
		 * 
		 */

		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
		}).and()
				.authorizeRequests().antMatchers("/user/login","/patient/register","/careers/newApplication","/user/doctorsList","/user/timeslotsAvailability")
				.permitAll()
				
				.antMatchers("/admin/staffSchedule").hasAnyRole("ADMIN","STAFF")
				
				.antMatchers("/admin/updateShifts","/admin/{adminId}/changePassword", "/admin/add/admin", "/admin/add/staff","/{adminId}/image",
						"/careers/{applnId}/updateStatus","/staff/appointment/timeslots","/careers/applicantsList","/careers/{applnId}/resume")
				.hasRole("ADMIN")	
				
				.antMatchers("/patient/{patId}/update","/patient/{patId}/changePassword", "/patient/{patId}/bookAppointment", "/patient/{patId}/image",
						"/patient/{patId}", "/patient/{patId}/reports", "/patient/report/{aptId}","/patient/{patId}/subscribePlan")
				.hasRole("PATIENT")
				
				.antMatchers("/staff/uploadReport/{aptId}","/staff/{staffId}/changePassword", "staff/{staffId}/image", "/staff/{staffId}/uploadImage",
						"/staff/{staffId}/update","/staff/{staffId}","/staff/showAppointments","staff/appointment/timeslots",
						"/staff/appointments","staff/appointments/reportUpload","/staff/showCurrentAppointments","/staff/donorList")
				.hasRole("STAFF")
				
				.antMatchers( "/swagger*/**", "/v*/api-docs/**").permitAll()
				// enabling global
				// access to all
				// urls with
				// /auth
				// only required for JS clnts (react / angular)
				.antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	// configure auth mgr bean : to be used in Authentication REST controller
	@Bean
	public AuthenticationManager authenticatonMgr(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
