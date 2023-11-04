package com.yesgaori.campinggaja.post;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesgaori.campinggaja.like.service.LikeService;
import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;
import com.yesgaori.campinggaja.post.service.PostService;
import com.yesgaori.campinggaja.user.domain.User;
import com.yesgaori.campinggaja.user.service.UserService;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	private UserService userService;
	private LikeService likeService;
	
	@GetMapping("/main-view")
	public String timeLine() {
		
		return "/post/main";
	}
	
	
	@GetMapping("/camping-diary/create-view")
	public String diaryCreateView() {
		
		return"/post/diaryInput";
	}
	
	@GetMapping("/main/diary-view")
	public String diaryMainView(Model model) {
			
	List<CampingDiaryPost> diaryList = postService.selectDiary();
	
	model.addAttribute("diaryList", diaryList);
		
		return"/post/diaryMain";
	}
	
	@GetMapping("/camping-diary/detail-view")
	public String postDetail(@RequestParam("id")int id
							, Model model) {
		
		
		
		CampingDiaryPost post = postService.selectDetail(id);
		User user = userService.getUserById(post.getUserId());
		int like = likeService.countLike(id);
		
		
		model.addAttribute("post", post);
		model.addAttribute("user", user);
		model.addAttribute("like", like);
		
		return "post/detail";
	}
	
}
