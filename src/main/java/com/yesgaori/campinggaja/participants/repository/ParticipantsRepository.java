package com.yesgaori.campinggaja.participants.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.campinggaja.participants.domain.RecruitmentParticipants;
import com.yesgaori.campinggaja.post.domain.RecruitmentPost;
import com.yesgaori.campinggaja.post.repository.PostRepository;

@Repository
public interface ParticipantsRepository {
	

	
	public int selectCountParticipants(
			@Param("recruitmentPostId") int postId);
	
	public int selectCountParticipantsByUserId(
			@Param("recruitmentPostId") int postId
			, @Param("userId") int userId);
	
	public int approveCountParticipants(
			@Param("recruitmentPostId") int id);
	
	
	public int insertParticipants(
			@Param("recruitmentPostId") int postId
			, @Param("userId") int userId
			, @Param("content") String content
			, @Param("age") int age
			, @Param("kakao") String kakao
			, @Param("qualifications") String qualifications
			, @Param("result") String result);
	
	public List<RecruitmentParticipants> selectParticipantsList(@Param("postId") int postId
											);
	
	
	public int deleteParticipantsByPost(@Param("participantsId") int participantsId);
	

	
	
}
