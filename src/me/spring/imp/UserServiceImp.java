package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.UserDAO;
import me.spring.entity.User;
import me.spring.service.UserService;
import restful.form.UserForm;
import restful.utils.EasyUIData;
import restful.utils.PrivilegeUtils;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(UserForm form) throws Exception {
		User user = new User();
		user.setId(0);
		user.setUsername(form.getUsername());
		user.setPassword(PrivilegeUtils.sha256(form.getPassword()));
		user.setRealname(form.getRealname());
		user.setIsAdmin(form.isAdmin());
		userDAO.save(user);
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userDAO.delete(id);
	}

	@Override
	public void updateUser(UserForm form) throws Exception {
		User userSaved = userDAO.findOne(form.getId());
		// 只会涉及1张表: T_User
		User userToSave = new User();
		userToSave.setId(form.getId());
		userToSave.setUsername(form.getUsername());
		userToSave.setRealname(form.getRealname());
		userToSave.setIsAdmin(form.isAdmin());
		String newPassword = form.getPassword();
		if (newPassword==null || newPassword.equals(""))
			userToSave.setPassword(userSaved.getPassword()); // 不修改密码
		else
			userToSave.setPassword(PrivilegeUtils.sha256(form.getPassword()));
		userDAO.save(userToSave);
	}

	@Override
	public EasyUIData<User> findPageUsers(Pageable pageable) {
		EasyUIData<User> data = new EasyUIData<>();
		Page<User> page = userDAO.findAll(pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}
	
}
