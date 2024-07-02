package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.CommentDto;
import com.sunbeam.service.CommentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/comment")

public class CommentController {
	
	@Autowired
	private CommentService commentservice;
	
	@PostMapping
	public ResponseEntity<?> postComment(@RequestBody CommentDto commentBody){
		try {
			return ResponseEntity.ok(commentservice.postComment(commentBody));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		
	}
	
	

}
