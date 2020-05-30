package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Role;
import restful.form.RoleForm;
import restful.utils.EasyUIData;

public interface RoleService {
	
	void addRole(RoleForm roleForm) throws Exception;
	void delRole(int id) throws Exception;
	void updateRole(RoleForm roleForm) throws Exception;
	
	EasyUIData<Role> findPageRolesByProjectId(Pageable pageable,int projectId);
}
