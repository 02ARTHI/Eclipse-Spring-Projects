package com.in28minutes.springboot.firstrestapi.survey;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyResource {
	// surveys => all surveys

private SurveyService surveyService;
	
	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	// /surveys => surveys
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys(){
		return surveyService.retrieveAllSurveys();
	}

}
