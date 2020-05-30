package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Application;
import restful.form.ApplicationForm;
import restful.utils.EasyUIData;

public interface ApplicationService {
	void addApplication(ApplicationForm applicationForm) throws Exception;
	void deleteApplication(int id) throws Exception;
	void updateApplication(ApplicationForm applicationForm) throws Exception;
	
	EasyUIData<Application> findPageApplications(Pageable pageable);
}
