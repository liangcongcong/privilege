package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Class;
import me.spring.entity.ClassField;
import restful.form.ClassFieldForm;
import restful.form.ClassForm;
import restful.utils.EasyUIData;

public interface ClassFieldService {
	
	void addClassField(ClassFieldForm classFieldForm) throws Exception;
	void delClassField(int id) throws Exception;
	void updateClassField(ClassFieldForm classFieldForm) throws Exception;	
	EasyUIData<ClassField> findPageClassFieldsByclassId(Pageable pageable,int classId);
}
