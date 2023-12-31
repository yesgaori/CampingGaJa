package com.yesgaori.campinggaja.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yesgaori.campinggaja.post.service.PostService;

@RequestMapping("/post")
@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/image-upload")
	public Map<String, String> fileUpload(
								@RequestParam("imagePath") MultipartFile file
								, HttpSession session){
		int userId = (Integer)session.getAttribute("userId");
		
		String imagePath = postService.insertImage(userId, file);
		
		Map<String, String> result = new HashMap<>();
		
		if(imagePath != null) {
			result.put("url", imagePath);
		} else {
			result.put("url", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/camping-diary/create")
	public Map<String, String> creatDiaryPost(
								@RequestParam("title") String title
								, @RequestParam("content") String content
								, @RequestParam("mapPath") String mapPath
								, @RequestParam("thumbnailPath") String thumbnailPath
								, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.creatDiaryPost(userId, title, content, mapPath, thumbnailPath);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/eating-diary/create")
	public Map<String, String> creatEatingPost(
								@RequestParam("title") String title
								, @RequestParam("content") String content
								, @RequestParam("thumbnailPath") String thumbnailPath
								, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.creatEatingPost(userId, title, content, thumbnailPath);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/item/create")
	public Map<String, String> creatItemPost(
								@RequestParam("title") String title
								, @RequestParam("content") String content
								, @RequestParam("starPoint") double starPoint
								, @RequestParam("thumbnailPath") String thumbnailPath
								, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.creatItemPost(userId, title, content, starPoint, thumbnailPath);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/recruitment/create")
	public Map<String, String> creatRecruitmentPost(
								@RequestParam("title") String title
								, @RequestParam("content") String content
								, @RequestParam("mapPath") String mapPath
								, @RequestParam("personnel") int personnel
								, @RequestParam("appointmentStartDate") String appointmentStartDate
								, @RequestParam("appointmentEndDate") String appointmentEndDate
								, @RequestParam("info") int info
								, @RequestParam("thumbnailPath") String thumbnailPath
								, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.creatRecruitmentPost(
											userId
											, title
											, content
											, mapPath
											, personnel
											, appointmentStartDate
											, appointmentEndDate
											, info
											, thumbnailPath);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/inquiry/create")
	public Map<String, String> inquiryCreate(
											@RequestParam("inquiry") String inquiry
											, HttpSession session){
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.inquiryCreate(userId, inquiry);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
}
