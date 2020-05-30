package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Class;
import restful.form.ClassForm;
import restful.utils.EasyUIData;

public interface ClassService {
	
	void addClass(ClassForm classForm) throws Exception;
	void delClass(int id) throws Exception;
	void updateClass(ClassForm classForm) throws Exception;	
	EasyUIData<Class> findPageClassesByProjectId(Pageable pageable,int projectId);
}
