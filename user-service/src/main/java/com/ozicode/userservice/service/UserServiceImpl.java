package com.ozicode.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ozicode.userservice.entity.User;
import com.ozicode.userservice.repository.UserRepository;
import com.ozicode.userservice.service.abstracts.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(int id) {
		return userRepository.findById(id).orElseThrow();
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

}
