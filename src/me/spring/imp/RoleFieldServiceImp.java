package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.RoleFieldDAO;
import me.spring.entity.RoleField;
import me.spring.service.RoleFieldService;
import restful.form.RoleFieldForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class RoleFieldServiceImp implements RoleFieldService {
	@Autowired
	private RoleFieldDAO roleFieldDAO;

	@Override
	public void addRoleField(RoleFieldForm roleFieldForm) throws Exception {
		roleFieldForm.setId(0);
		updateRoleField(roleFieldForm);
	}

	@Override
	public void delRoleField(int id) throws Exception {
		roleFieldDAO.delete(id);
	}
	
	@Override
	public void updateRoleField(RoleFieldForm form) throws Exception {
		RoleField roleField = new RoleField();
		roleField.setId(form.getId());
		roleField.setProjectId(form.getProjectId());
		roleField.setFieldName(form.getFieldName());
		roleField.setFieldType(form.getFieldType());
		roleField.setDescription(form.getDescription());
		roleFieldDAO.save(roleField);
	}

	@Override
	public EasyUIData<RoleField> findPageRoleFieldsByProjectId(Pageable pageable, int projectId) {
		EasyUIData<RoleField> data=new EasyUIData<RoleField>();
		Page<RoleField> page=roleFieldDAO.findByProjectId(projectId, pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}
	
}
