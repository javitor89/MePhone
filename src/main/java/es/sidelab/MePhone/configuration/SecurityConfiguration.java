/*package es.sidelab.MePhone.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/busqueda").permitAll();
		http.authorizeRequests().antMatchers("/registro").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		// Private pages (all other pages)
		http.authorizeRequests().anyRequest().authenticated();
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("usuario");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/busqueda");
		http.formLogin().failureUrl("/loginerror");
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/busqueda");

		// Disable CSRF at the moment
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// User
		auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("adminpass").roles("USER", "ADMIN");

	}

}
*/