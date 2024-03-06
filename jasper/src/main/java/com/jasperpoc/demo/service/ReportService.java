package com.jasperpoc.demo.service;

import com.jasperpoc.demo.Repository.DiseaseRepository;
import com.jasperpoc.demo.entities.Disease;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class ReportService
{
	private static DiseaseRepository repository;

	public ReportService(DiseaseRepository repository){
		this.repository = repository;
	}

	public static String exportFile(String reportFormat) throws FileNotFoundException, JRException
	{
		String path = "C:\\sabiah\\Report";
		List<Disease> diseases = repository.findAll();
		Disease disease = diseases.get(0);

		File file = ResourceUtils.getFile("classpath:disease.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

		Map<String, Object> parameters = new HashMap<>();

		parameters.put("name", disease.getName());
		parameters.put("description", disease.getDescription());
		parameters.put("recommendations", disease.getRecommendations());
		parameters.put("videosLinks", disease.getVideosLinks());
		parameters.put("createdBy", "Kleber Aluizio");

		JRDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(parameters));

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap<>(),dataSource);
		if(reportFormat.equalsIgnoreCase("html")){
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path +"\\diasease.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")){
			JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\diasease.pdf");
		}

		return "Report generated in path: " + path;


	}
}
