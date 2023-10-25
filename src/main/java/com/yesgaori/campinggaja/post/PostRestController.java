package com.yesgaori.campinggaja.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yesgaori.campinggaja.post.service.PostService;

@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	public Map<String, String> creatDiaryPost(
								@RequestParam("title") String title
								, @RequestParam("content") String content
								, @RequestParam("imagePath") MultipartFile file
								, @RequestParam("mapPath") String mapPath
								, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.creatDiaryPost(userId, title, content, file, mapPath);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
}
