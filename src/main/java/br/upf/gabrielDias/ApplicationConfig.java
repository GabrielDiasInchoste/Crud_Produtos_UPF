package br.upf.gabrielDias;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = { "br.upf.gabrielDias.entity" })
@EnableJpaRepositories(basePackages = { "br.upf.gabrielDias.repositories" })
@ComponentScan(basePackages = {"br.upf.gabrielDias.controller", "br.upf.gabrielDias.services"})
public class ApplicationConfig {
    public static void main( String[] args )
    {
        SpringApplication.run(ApplicationConfig.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
