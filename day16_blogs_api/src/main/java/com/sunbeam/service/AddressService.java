package com.sunbeam.service;

import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;

public interface AddressService {
	
	ApiResponse assignAddressToUser(AddressDTO addressDto);
	
}
