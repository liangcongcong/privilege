package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.LinkDAO;
import me.spring.entity.Link;
import me.spring.service.LinkService;
import restful.form.ELOForm;
import restful.utils.EasyUIData;

@Service
@Transactional
public class LinkServiceImp implements LinkService {
	@Autowired
	private LinkDAO linkDAO;

	@Override
	public void addLink(ELOForm form) throws Exception {
		form.setId(0);
		updateLink(form);
	}

	@Override
	public void deleteLink(int id) throws Exception {
		linkDAO.delete(id);
	}

	@Override
	public void updateLink(ELOForm form) throws Exception {
		// 只会涉及1张表: T_Link
		Link link = new Link();
		link.setId(form.getId());
		link.setCaption(form.getCaption());
		link.setDescription(form.getDescription());
		linkDAO.save(link);
	}

	@Override
	public EasyUIData<Link> findPageLinks(Pageable pageable) {
		EasyUIData<Link> data = new EasyUIData<>();
		Page<Link> page = linkDAO.findAll(pageable);
		data.setRows(page.getContent());
		data.setTotal(page.getTotalElements());
		return data;
	}

}
