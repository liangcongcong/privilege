package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.OperatorDAO;
import me.spring.entity.Operator;
import me.spring.service.OperatorService;
import restful.form.ELOForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class OperatorServiceImp implements OperatorService {
	@Autowired
	private OperatorDAO operatorDAO;

	@Override
	public void addOperator(ELOForm form) throws Exception {
		form.setId(0);
		updateOperator(form);
	}

	@Override
	public void deleteOperator(int id) throws Exception {
		operatorDAO.delete(id);
	}

	@Override
	public void updateOperator(ELOForm form) throws Exception {
		// 只会涉及1张表: T_Operator
		Operator operator = new Operator();
		operator.setId(form.getId());
		operator.setCaption(form.getCaption());
		operator.setDescription(form.getDescription());
		operatorDAO.save(operator);
	}

	@Override
	public EasyUIData<Operator> findPageOperators(Pageable pageable) {
		EasyUIData<Operator> data = new EasyUIData<>();
		Page<Operator> page = operatorDAO.findAll(pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}

}
