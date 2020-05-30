package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.ClassDAO;
import me.spring.entity.Class;
import me.spring.service.ClassService;
import restful.form.ClassForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class ClassServiceImp implements ClassService {
	@Autowired
	private ClassDAO classDAO;

	@Override
	public void addClass( ClassForm classForm) throws Exception {
		classForm.setId(0);
		updateClass(classForm);
	}

	@Override
	public void delClass(int id) throws Exception {
		classDAO.delete(id);
	}

	@Override
	public void updateClass(ClassForm form) throws Exception {
		Class classes = new Class();
		classes.setId(form.getId());
		classes.setProjectId(form.getProjectId());
		classes.setClassName(form.getClassName());
		classes.setDescription(form.getDescription());
		classDAO.save(classes);
	}

	@Override
	public EasyUIData<Class> findPageClassesByProjectId(Pageable pageable, int projectId) {
		EasyUIData<Class> data = new EasyUIData<Class>();
		Page<Class> page = classDAO.findByProjectId(projectId, pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}


}
