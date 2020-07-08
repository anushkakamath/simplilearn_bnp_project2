package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.BusinessException;
import com.app.model.Feedback;
import com.app.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService service;
	
	private MultiValueMap<String, String> map;
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) throws BusinessException {
		try {
			return new ResponseEntity<Feedback>(service.createFeedback(feedback),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
		//return service.createFeedback(feedback);
	}

	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
		try {
			return new ResponseEntity<Feedback>(service.updateFeedback(feedback),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
		//return service.updateFeedback(feedback);
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) throws BusinessException {
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/feedback/{id}")
	public void deleteFeedbackById(@PathVariable("id") int id) {
		service.deleteFeedbackById(id);
	}

	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedbacks() {
		
		return service.getAllFeedbacks();
	}


	@GetMapping("/feedbacks/name/{name}")
	public List<Feedback> getFeedbacksByName(@PathVariable("name") String name) {
		return service.getFeedbacksByName(name);
	}

	@GetMapping("/feedbacks/{satisfactionOfProduct}")
	public List<Feedback> getFeedbacksBySatisfactionOfProduct(@PathVariable("satisfactionOfProduct") int satisfactionOfProduct) {
		return service.getFeedbacksBySatisfactionOfProduct(satisfactionOfProduct);
	}

	@GetMapping("/feedbacks/experience/{overallExperience}")
	public List<Feedback> getFeedbacksByOverallExperience(@PathVariable("overallExperience") int overallExperience) {
		
		return service.getFeedbacksByOverallExperience(overallExperience);
	}

	@GetMapping("/feedbacks/recommend/{likelyToRecommend}")
	public List<Feedback> getFeedbacksByLikelyToRecommend(@PathVariable("likelyToRecommend") int likelyToRecommend) {
		
		return service.getFeedbacksByLikelyToRecommend(likelyToRecommend);
	}

}
