package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Feedback;

public interface FeedbackService {

	public Feedback createFeedback(Feedback feedback) throws BusinessException;
	public Feedback updateFeedback(Feedback feedback) throws BusinessException;
	public Feedback getFeedbackById(int id) throws BusinessException;
	public void deleteFeedbackById(int id);
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> getFeedbacksByName(String name);
	public List<Feedback> getFeedbacksBySatisfactionOfProduct(int satisfactionOfProduct);
	public List<Feedback> getFeedbacksByOverallExperience(int overallExperience);
	public List<Feedback> getFeedbacksByLikelyToRecommend(int likelyToRecommend);
}
