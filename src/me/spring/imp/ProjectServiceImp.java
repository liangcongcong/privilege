package me.spring.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.ProjectDAO;
import me.spring.entity.Project;
import me.spring.service.ProjectService;
import restful.form.ProjectForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class ProjectServiceImp implements ProjectService {
	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public void addProject(ProjectForm form) throws Exception {
		form.setId(0);
		updateProject(form);
	}

	@Override
	public void deleteProject(int id) throws Exception {
		projectDAO.delete(id);
	}

	@Override
	public void updateProject(ProjectForm form) throws Exception {
		// 只会涉及1张表: T_Project
		Project project = new Project();
		project.setId(form.getId());
		project.setCode(form.getCode());
		project.setProjectName(form.getProjectName());
		project.setLoginUserClass(form.getLoginUserClass());
		project.setDescription(form.getDescription());
		projectDAO.save(project);
	}

	@Override
	public EasyUIData<Project> findPageProjects(Pageable pageable) {
		EasyUIData<Project> data = new EasyUIData<>();
		Page<Project> page = projectDAO.findAll(pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}

	@Override
	public List<Project> findAllProjects() {
		return projectDAO.findAll();
	}

}
