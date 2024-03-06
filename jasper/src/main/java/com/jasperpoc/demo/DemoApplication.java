package com.jasperpoc.demo;

import com.jasperpoc.demo.service.ReportService;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws JRException, FileNotFoundException
	{
		SpringApplication.run(DemoApplication.class, args);

		ReportService.exportFile("pdf");
	}

}
