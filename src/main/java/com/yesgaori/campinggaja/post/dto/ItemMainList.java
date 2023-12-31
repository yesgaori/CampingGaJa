package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemMainList {
	
	private int postId;
	private String title;
	private String userName;
	private int starPointCount;
	private double averagePoint;
	private String thumbnailPath;
	private Date createdAt;
	
}
