package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.RoleDAO;
import me.spring.entity.Role;
import me.spring.service.RoleService;
import restful.form.RoleForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class RoleServiceImp implements RoleService {
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public void addRole(RoleForm roleForm) throws Exception {
		roleForm.setId(0);
		updateRole(roleForm);
	}

	@Override
	public void delRole(int id) throws Exception {
		roleDAO.delete(id);
	}

	@Override
	public void updateRole(RoleForm form) throws Exception {
		Role role = new Role();
		role.setId(form.getId());
		role.setProjectId(form.getProjectId());
		role.setRole(form.getRole());
		role.setDescription(form.getDescription());
		roleDAO.save(role);
	}

	@Override
	public EasyUIData<Role> findPageRolesByProjectId(Pageable pageable, int projectId) {
		EasyUIData<Role> data = new EasyUIData<Role>();
		Page<Role> page = roleDAO.findByProjectId(projectId, pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}

}
