package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.ApplicationDAO;
import me.spring.entity.Application;
import me.spring.service.ApplicationService;
import restful.form.ApplicationForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class ApplicationServiceImp implements ApplicationService {
	@Autowired
	private ApplicationDAO applicationDAO;

	@Override
	public void addApplication(ApplicationForm form) throws Exception {
		form.setId(0);
		updateApplication(form);
	}

	@Override
	public void deleteApplication(int id) throws Exception {
		applicationDAO.delete(id);
	}

	@Override
	public void updateApplication(ApplicationForm form) throws Exception {
		// 只会涉及1张表: T_Application
		Application application = new Application();
		application.setId(form.getId());
		application.setProjectId(form.getProjectId());
		application.setAppId(form.getAppId());
		application.setSecretKey(form.getSecretKey());
		application.setDescription(form.getDescription());
		applicationDAO.save(application);
	}

	@Override
	public EasyUIData<Application> findPageApplications(Pageable pageable) {
		EasyUIData<Application> data = new EasyUIData<>();
		Page<Application> page = applicationDAO.findAll(pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}

}
