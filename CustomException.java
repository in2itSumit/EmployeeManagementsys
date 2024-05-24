package com.example.demo.exceptionHandler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomException {
	 
		
		private LocalDateTime time;
		
		private long statusCode;
		
		private String errName;
		
		private String errMessage;
	 
		private String errPath;
		

}
