package br.com.mateus.csvhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CSV Handler", version = "1.0", description = "CSV HANDLER, DOWNLOAD, UPLOAD AND MAP"))
public class CsvHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvHandlerApplication.class, args);
	}

}
