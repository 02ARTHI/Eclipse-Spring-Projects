package com.telusko.JobApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.service.JobService;

import ch.qos.logback.core.model.Model;

@Controller
public class JobController {
	
	@Autowired
	private JobService service;

	
	@GetMapping({"/","home"})
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/addjob")
	public String add()
	{
		return "addjob";
	}
	
//	@PostMapping("/handleForm")
//	public String handleForm(JobPost jobPost)
//	{
//		return "success";
//	}
//	
	// controller method for getting all job posts
		@GetMapping("/viewalljobs")
		public String viewJobs(ModelMap m) {

			List<JobPost> jobPosts = service.returnAllJobPosts();
			m.addAttribute("jobPosts", jobPosts);
			return "viewalljobs";
		}
		
		@PostMapping("/handleForm")
		public String handleAddJobForm(JobPost jobPost,ModelMap model) {
			model.addAttribute("jobPost", jobPost);
			service.addJobPost(jobPost);
			//System.out.println(jobPost);
			  return "success";
			
		}
		
}
