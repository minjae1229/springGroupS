package com.spring.springGroupS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springGroupS.vo.UserVO;

@Service
public interface UserService {

	List<UserVO> getUserList();

	UserVO getUserSearch(String mid);

}
