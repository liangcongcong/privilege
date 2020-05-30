package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Operator;
import restful.form.ELOForm;
import restful.utils.EasyUIData;

public interface OperatorService {
	void addOperator(ELOForm form) throws Exception;
	void deleteOperator(int id) throws Exception;
	void updateOperator(ELOForm form) throws Exception;
	
	EasyUIData<Operator> findPageOperators(Pageable pageable);
}
