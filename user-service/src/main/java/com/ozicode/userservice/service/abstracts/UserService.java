package com.ozicode.userservice.service.abstracts;

import java.util.List;

import com.ozicode.userservice.entity.User;

public interface UserService {
	User save(User user);
	User getById(int id);
	List<User> getAll();

}
