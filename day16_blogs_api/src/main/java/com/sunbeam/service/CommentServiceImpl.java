package com.sunbeam.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentDto;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

import lombok.Setter;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentdao;

	@Autowired
	private UserDao userdao;

	@Autowired
	private BlogPostDao blogpostdao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse postComment(CommentDto commentdto) {

		User user = userdao.findById(commentdto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not exist"));
		
		if(user.getRole().toUpperCase().equals("BLOGGER")) throw new ApiException("USer is not Commenter");
		
		BlogPost post = blogpostdao.findById(commentdto.getPostId())
						.orElseThrow(() -> new ResourceNotFoundException("Blog Post does not exist"));
		
		if(post.getBlogger().getId() == user.getId())throw new ApiException("you can't comment..!!");
		
		 
		Comment comment = mapper.map(commentdto, Comment.class);
		
		comment.setCommenter(user);
		comment.setPost(post);
		
		return new ApiResponse("Comment added !! your comment is - " +commentdao.save(comment)) ;
	}

}
