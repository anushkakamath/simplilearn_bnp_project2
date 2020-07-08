package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.model.Feedback;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer>{
	
	public List<Feedback> findByName(String name);
	public List<Feedback> findBySatisfactionOfProduct(int satisfactionOfProduct);
	public List<Feedback> findByOverallExperience(int overallExperience);
	public List<Feedback> findByLikelyToRecommend(int likelyToRecommend);

}
