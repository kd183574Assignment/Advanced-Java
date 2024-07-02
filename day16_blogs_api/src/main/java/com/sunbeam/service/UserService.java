package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

public interface UserService {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);

	List<User> getAllUser();
}
