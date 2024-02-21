package com.jasperpoc.demo.controller;

import com.jasperpoc.demo.entities.Disease;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disease")
public class DiseaseController
{

	@PostMapping
	@Transactional
	public ResponseEntity registerDisease(Disease disease){
		return ResponseEntity.ok().build();
	}
}
