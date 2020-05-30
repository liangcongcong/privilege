package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.RoleField;
import restful.form.RoleFieldForm;
import restful.utils.EasyUIData;

public interface RoleFieldService {
	
	void addRoleField(RoleFieldForm form) throws Exception;
	void delRoleField(int id) throws Exception;
	void updateRoleField(RoleFieldForm form) throws Exception;
	
	EasyUIData<RoleField> findPageRoleFieldsByProjectId(Pageable pageable,int projectId);
	
}
