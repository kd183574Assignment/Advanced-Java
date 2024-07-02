package com.sunbeam.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.AddressDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.User;

@Service
@Transactional
public class AddressServiceimpl implements AddressService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private AddressDao addressdao;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse assignAddressToUser(AddressDTO addressDto) {
		
		User user= userdao.findById(addressDto.getUserId())
				.orElseThrow(()-> new ApiException("User not existed"));
		
		Address address = mapper.map(addressDto, Address.class);
		Address address2 = addressdao.save(address);
		
		user.setUserAddress(address2);
		
		return new ApiResponse("Address was Assigned"+userdao.save(user));
	}
 
}
