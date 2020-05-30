package me.spring.service;

import org.springframework.data.domain.Pageable;

import me.spring.entity.Link;
import restful.form.ELOForm;
import restful.utils.EasyUIData;

public interface LinkService {
	void addLink(ELOForm form) throws Exception;
	void deleteLink(int id) throws Exception;
	void updateLink(ELOForm form) throws Exception;
	
	EasyUIData<Link> findPageLinks(Pageable pageable);
}
