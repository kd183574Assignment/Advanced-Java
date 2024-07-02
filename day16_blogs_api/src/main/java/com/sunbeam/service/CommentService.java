package com.sunbeam.service;

import javax.transaction.Transactional;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentDto;


public interface CommentService  {
	
	ApiResponse postComment(CommentDto commentdto);
	

}
