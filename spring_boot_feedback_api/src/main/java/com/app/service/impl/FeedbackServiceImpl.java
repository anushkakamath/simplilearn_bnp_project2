package com.app.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FeedbackDAO;
import com.app.exception.BusinessException;
import com.app.model.Feedback;
import com.app.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackDAO dao;
	
	@Override
	public Feedback createFeedback(Feedback feedback) throws BusinessException {
		if(!isValidName(feedback.getName())) {
			throw new BusinessException("Entered name " + feedback.getName() + " is invalid");
		}
		if (!isValidFeedback(feedback.getLikelyToRecommend())) {
			throw new BusinessException("Entered feedback for likely to recommend " + feedback.getLikelyToRecommend() + " is invalid");
		}
		if (!isValidFeedback(feedback.getOverallExperience())) {
			throw new BusinessException("Entered feedback for overall experience " + feedback.getOverallExperience() + " is invalid");
		}
		if (!isValidFeedback(feedback.getQualityOfProduct())) {
			throw new BusinessException("Entered feedback for quality of product " + feedback.getQualityOfProduct() + " is invalid");
		}
		if (!isValidFeedback(feedback.getResponseSpeed())) {
			throw new BusinessException("Entered feedback for speed of response " + feedback.getResponseSpeed() + " is invalid");
		}
		if (!isValidFeedback(feedback.getSatisfactionOfProduct())) {
			throw new BusinessException("Entered feedback for satisfaction of the product " + feedback.getSatisfactionOfProduct() + " is invalid");
		}
		return dao.save(feedback);
	}

//	@Override
//	public Feedback updateFeedback(Feedback feedback) throws BusinessException {
//		if(!isValidName(feedback.getName())) {
//			throw new BusinessException("Entered name " + feedback.getName() + " is invalid");
//		}
//		if (!isValidFeedback(feedback.getLikelyToRecommend())) {
//			throw new BusinessException("Entered feedback for likely to recommend " + feedback.getLikelyToRecommend() + " is invalid");
//		}
//		if (!isValidFeedback(feedback.getOverallExperience())) {
//			throw new BusinessException("Entered feedback for overall experience " + feedback.getOverallExperience() + " is invalid");
//		}
//		if (!isValidFeedback(feedback.getQualityOfProduct())) {
//			throw new BusinessException("Entered feedback for quality of product " + feedback.getQualityOfProduct() + " is invalid");
//		}
//		if (!isValidFeedback(feedback.getResponseSpeed())) {
//			throw new BusinessException("Entered feedback for speed of response " + feedback.getResponseSpeed() + " is invalid");
//		}
//		if (!isValidFeedback(feedback.getSatisfactionOfProduct())) {
//			throw new BusinessException("Entered feedback for satisfaction of the product " + feedback.getSatisfactionOfProduct() + " is invalid");
//		}
//		if(feedback.getId()<=0) {
//			throw new BusinessException("Id "+feedback.getId() +" is invalid");
//		}
//		
//		return dao.save(feedback); 
//	}
	
	@Override
	public Feedback updateFeedback(Feedback feedback) throws BusinessException {
		if(!isValidName(feedback.getName())) {
			throw new BusinessException("Entered name " + feedback.getName() + " is invalid");
		}
		if (!isValidFeedback(feedback.getLikelyToRecommend())) {
			throw new BusinessException("Entered feedback for likely to recommend " + feedback.getLikelyToRecommend() + " is invalid");
		}
		if (!isValidFeedback(feedback.getOverallExperience())) {
			throw new BusinessException("Entered feedback for overall experience " + feedback.getOverallExperience() + " is invalid");
		}
		if (!isValidFeedback(feedback.getQualityOfProduct())) {
			throw new BusinessException("Entered feedback for quality of product " + feedback.getQualityOfProduct() + " is invalid");
		}
		if (!isValidFeedback(feedback.getResponseSpeed())) {
			throw new BusinessException("Entered feedback for speed of response " + feedback.getResponseSpeed() + " is invalid");
		}
		if (!isValidFeedback(feedback.getSatisfactionOfProduct())) {
			throw new BusinessException("Entered feedback for satisfaction of the product " + feedback.getSatisfactionOfProduct() + " is invalid");
		}
		if(feedback.getId()<=0) {
			throw new BusinessException("Id "+feedback.getId() +" is invalid");
		}
		Feedback checker=null;
		try {
		checker=dao.findById(feedback.getId()).get();
		return dao.save(feedback);
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+feedback.getId());
		}
		 
	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException{
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback=null;
		try {
		feedback=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+id);
		}
		return feedback;
	}


	@Override
	public void deleteFeedbackById(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		
		return dao.findAll();
	}

	@Override
	public List<Feedback> getFeedbacksByName(String name){
		return dao.findByName(name);
	}

	@Override
	public List<Feedback> getFeedbacksBySatisfactionOfProduct(int satisfactionOfProduct){
		return dao.findBySatisfactionOfProduct(satisfactionOfProduct);

	}

//	@Override
//	public List<Feedback> getFeedbacksBySatisfactionOfProduct(int satisfactionOfProduct) throws BusinessException {
//		if(satisfactionOfProduct<0 | satisfactionOfProduct>5) {
//			throw new BusinessException("Feedback entry for satisfaction of the Product "+satisfactionOfProduct +" is invalid");
//		}
//		List <Feedback> list=null;
//		try {
//		list = dao.findBySatisfactionOfProduct(satisfactionOfProduct);
//		}catch(NoSuchElementException e) {
//			throw new BusinessException("No feedback found for Feedback entry value for satisfaction of the Product "+satisfactionOfProduct);
//		}
//		return list;
//	}

	@Override
	public List<Feedback> getFeedbacksByOverallExperience(int overallExperience) {
		
		return dao.findByOverallExperience(overallExperience);
	}
	
	
	@Override
	public List<Feedback> getFeedbacksByLikelyToRecommend(int likelyToRecommend) {
		
		return dao.findByLikelyToRecommend(likelyToRecommend);
	}
	
	private boolean isValidFeedback(int field) {
		boolean b = true;
		if (field < 0 || field > 5) {
			b = false;
		}
		return b;
	}

	private boolean isValidName(String name) {
		boolean b = false;
		if (name.matches("[a-zA-Z]{3,30}")) {
			b = true;
		}
		return b;
	}
	

}
