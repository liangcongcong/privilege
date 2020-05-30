package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.EndType;
import restful.form.ELOForm;
import restful.utils.EasyUIData;

public interface EndTypeService {
	void addEndType(ELOForm form) throws Exception;
	void deleteEndType(int id) throws Exception;
	void updateEndType(ELOForm form) throws Exception;
	
	EasyUIData<EndType> findPageEndTypes(Pageable pageable);
}
