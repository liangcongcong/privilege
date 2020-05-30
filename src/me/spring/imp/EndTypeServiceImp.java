package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.EndTypeDAO;
import me.spring.entity.EndType;
import me.spring.service.EndTypeService;
import restful.form.ELOForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class EndTypeServiceImp implements EndTypeService {
	@Autowired
	private EndTypeDAO endTypeDAO;

	@Override
	public void addEndType(ELOForm form) throws Exception {
		form.setId(0);
		updateEndType(form);
	}

	@Override
	public void deleteEndType(int id) throws Exception {
		endTypeDAO.delete(id);
	}

	@Override
	public void updateEndType(ELOForm form) throws Exception {
		// 只会涉及1张表: T_EndType
		EndType endType = new EndType();
		endType.setId(form.getId());
		endType.setCaption(form.getCaption());
		endType.setDescription(form.getDescription());
		endTypeDAO.save(endType);
	}

	@Override
	public EasyUIData<EndType> findPageEndTypes(Pageable pageable) {
		EasyUIData<EndType> data = new EasyUIData<>();
		Page<EndType> page = endTypeDAO.findAll(pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}

}
