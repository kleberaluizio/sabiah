package com.jasperpoc.demo.controller;

import com.jasperpoc.demo.entities.Disease;
import com.jasperpoc.demo.service.ReportService;
import jakarta.transaction.Transactional;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disease")
public class DiseaseController
{
	@Autowired
	private ReportService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> registerDisease(Disease disease){
		return ResponseEntity.ok().build();
	}

	@GetMapping("/report/{format}")
	@Transactional
	public String getDiseases(@PathVariable String format) throws JRException, FileNotFoundException
	{
		return service.exportFile(format);
	}
}
