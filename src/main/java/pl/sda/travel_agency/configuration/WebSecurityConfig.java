package pl.sda.travel_agency.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin()// formularz logowania
                .loginPage("/login")// adres formularza logowania
                .usernameParameter("email")// nazwa pola w formularzu dot. loginu
                .passwordParameter("password")// nazwa pola w formularzu dot. hasła
                .loginProcessingUrl("/login-process")// adres gdzie przekazywane są parametry formularza
                .defaultSuccessUrl("/")// domyśly URL po poprawnym zalogowaniu
                .failureUrl("/errorLogin")// domyśly URL po błędnym logowaniu
                .and()
                .logout()
                .logoutUrl("/logout")// adres do wylogowania
                .logoutSuccessUrl("/");// miejsce po wylogowaniu
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email, u.password, u.active FROM user u WHERE u.email = ?")  // SQL dla logowania użytkownika po adresie email i haśle
                .authoritiesByUsernameQuery("SELECT u.email, u.role_enum FROM user u WHERE u.email = ?")  // SQL dla przypisania uprawnień dla zalogowanego użytkownika
                .dataSource(dataSource) // wynik logowania
                .passwordEncoder(bCryptPasswordEncoder);// szyfrowanie hasła
    }

}

