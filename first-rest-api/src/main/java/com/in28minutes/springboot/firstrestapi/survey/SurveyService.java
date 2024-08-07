package com.in28minutes.springboot.firstrestapi.survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
   
	 private static List<Survey> surveys = new ArrayList<Survey>();
	 
	 static {
		 
		 Question question1 = new Question("Question1",
	                "Most Popular Cloud Platform Today", Arrays.asList(
	                        "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
	        Question question2 = new Question("Question2",
	                "Fastest Growing Cloud Platform", Arrays.asList(
	                        "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
	        Question question3 = new Question("Question3",
	                "Most Popular DevOps Tool", Arrays.asList(
	                        "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
	 
	        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
	                question2, question3));
	 
	        Survey survey = new Survey("Survey1", "My Favorite Survey",
	                "Description of the Survey", questions);
	 
	        surveys.add(survey);
	 }

	public List<Survey> retrieveAllSurveys() {
		// TODO Auto-generated method stub
		
		return surveys;
	}
	 
	 
}
