package com.jasperpoc.demo.service;

import com.jasperpoc.demo.Repository.DiseaseRepository;
import com.jasperpoc.demo.entities.Disease;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class ReportService
{
	@Autowired
	private DiseaseRepository repository;

	public String exportFile(String reportFormat) throws FileNotFoundException, JRException
	{
		String path = "C:\\sabiah\\Report";
		List<Disease> diseases = repository.findAll();

		File file = ResourceUtils.getFile("classpath:disease.jrxml");
		JasperDesign jasperDesign;
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(diseases);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Kleber Aluizio");

		JRDataSource dataSource1;
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
		if(reportFormat.equalsIgnoreCase("html")){
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path +"\\diasease.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")){
			JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\diasease.pdf");
		}

		return "Report generated in path: " + path;


	}
}
