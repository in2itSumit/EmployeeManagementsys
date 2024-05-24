package com.example.demo.doc;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration

public class EmpProjectDoc {
	
		@Bean
		public OpenAPI defineOpenapi() {
			Server server=new Server();
			server.setUrl("http://localhost:8080");
			server.setDescription("Software Development");
			
			Contact myContact=new Contact();
			myContact.setName("Sumit Mishra");
			myContact.setEmail("sumit.mishra@in2ittech.com");
			
			Info info=new Info()
					.title("API_For_Employee_Management_System")
		               .version("1.0")
		               .description("This api is made to manage the overall works to manage the Employees")
		               .contact(myContact);
			
			return new OpenAPI().info(info).servers(List.of(server));
			
		}
	
}
