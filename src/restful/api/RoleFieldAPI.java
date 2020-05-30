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

import me.spring.entity.RoleField;
import me.spring.service.RoleFieldService;
import restful.form.RoleFieldForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

@Component
@Path("/manage/roleField")

public class RoleFieldAPI {
	@Autowired
	private RoleFieldService roleFieldService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<RoleField> list(@Form EasyUIDataPageRequest pageRequest, @FormParam("projectId") int projectId,
			@Context HttpServletRequest request) {
		request.getSession().setAttribute("currentRoleFieldProjectId", projectId);
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		return roleFieldService.findPageRoleFieldsByProjectId(pageable, projectId);
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form RoleFieldForm roleFieldForm, @Context HttpServletRequest request) {
		// 从session中取得当前的projectId
		roleFieldForm.setProjectId((int) request.getSession().getAttribute("currentRoleFieldProjectId"));
		Message message = new Message();
		try {
			roleFieldService.addRoleField(roleFieldForm);
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
	public Message update(@Form RoleFieldForm roleFieldForm) {
		Message message = new Message();
		try {
			roleFieldService.updateRoleField(roleFieldForm);
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
			roleFieldService.delRoleField(id);
			message.setMsg("删除成功！");
		} catch (Exception e) {
			message.setMsg("删除失败！");
		}
		return message;
	}
}
