package me.spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Project;
import restful.form.ProjectForm;
import restful.utils.EasyUIData;

public interface ProjectService {
	void addProject(ProjectForm projectForm) throws Exception;
	void deleteProject(int id) throws Exception;
	void updateProject(ProjectForm projectForm) throws Exception;
	
	EasyUIData<Project> findPageProjects(Pageable pageable);
	
	List<Project> findAllProjects();
}
