package restful.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.annotations.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;


import me.spring.entity.ClassField;
import me.spring.service.ClassFieldService;
import restful.form.ClassFieldForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

@Component
@Path("/manage/classField")

public class ClassFieldAPI {
	@Autowired
	private ClassFieldService classFieldService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<ClassField> list(@Form EasyUIDataPageRequest pageRequest,  @FormParam("classId") int classId,
			@Context HttpServletRequest request) {
		request.getSession().setAttribute("currentclassId", classId);
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		return classFieldService.findPageClassFieldsByclassId(pageable, classId);
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form ClassFieldForm classFieldForm, @Context HttpServletRequest request) {
		// 从session中取得当前的classId
		classFieldForm.setClassId((int) request.getSession().getAttribute("currentclassId"));
		Message message = new Message();
		try {
			classFieldService.addClassField(classFieldForm);
			message.setMsg("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			message.setMsg("保存失败！");
		}
		return message;
	}

	@POST
	@Path("/update")
	@Produces("application/json;charset=utf-8")
	public Message update(@Form ClassFieldForm classFieldForm) {
		Message message = new Message();
		try {
			classFieldService.updateClassField(classFieldForm);
			message.setMsg("保存成功！");
		} catch (Exception e) {
			message.setMsg("保存失败！");
		}
		return message;
	}

	@POST
	@Path("/del")
	@Produces("application/json;charset=utf-8")
	public Message del(@FormParam("id") int id) {
		Message message = new Message();
		try {
			classFieldService.delClassField(id);
			message.setMsg("删除成功！");
		} catch (Exception e) {
			message.setMsg("删除失败！");
		}
		return message;
	}
}
