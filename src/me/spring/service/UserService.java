package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.User;
import restful.form.UserForm;
import restful.utils.EasyUIData;

public interface UserService {
	void addUser(UserForm userForm) throws Exception;
	void deleteUser(int id) throws Exception;
	void updateUser(UserForm userForm) throws Exception;
	
	EasyUIData<User> findPageUsers(Pageable pageable);
}
