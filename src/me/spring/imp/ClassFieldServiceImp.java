package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.ClassDAO;
import me.spring.dao.ClassFieldDAO;
import me.spring.entity.Class;
import me.spring.entity.ClassField;
import me.spring.service.ClassFieldService;
import me.spring.service.ClassService;
import restful.form.ClassFieldForm;
import restful.form.ClassForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class ClassFieldServiceImp implements ClassFieldService {
	@Autowired
	private ClassFieldDAO classFieldDAO;

	@Override
	public void addClassField( ClassFieldForm classFieldForm) throws Exception {
		classFieldForm.setId(0);
		updateClassField(classFieldForm);
	}

	@Override
	public void delClassField(int id) throws Exception {
		classFieldDAO.delete(id);
	}

	@Override
	public void updateClassField(ClassFieldForm form) throws Exception {
		ClassField classField = new ClassField();
		classField.setId(form.getId());
		classField.setClassId(form.getClassId());
		classField.setFieldName(form.getFieldName());
		classField.setFieldType(form.getFieldType());
		classField.setDescription(form.getDescription());
		classFieldDAO.save(classField);
	}

	@Override
	public EasyUIData<ClassField> findPageClassFieldsByclassId(Pageable pageable, int classId) {
		EasyUIData<ClassField> data = new EasyUIData<ClassField>();
		Page<ClassField> page = classFieldDAO.findByClassId(classId, pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}


}
