package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import jakarta.faces.webapp.FacesServlet;

@SpringBootApplication
public class ProductFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductFrontendApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
        ServletRegistrationBean<FacesServlet> registrationBean = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}
