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

import me.spring.entity.Role;
import me.spring.service.RoleService;
import restful.form.RoleForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

@Component
@Path("/manage/role")

public class RoleAPI {
	@Autowired
	private RoleService roleService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<Role> list(@Form EasyUIDataPageRequest pageRequest, @FormParam("projectId") int projectId,
			@Context HttpServletRequest request) {
		request.getSession().setAttribute("currentRoleProjectId", projectId);
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		return roleService.findPageRolesByProjectId(pageable, projectId);
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form RoleForm roleForm, @Context HttpServletRequest request) {
		// 从session中取得当前的projectId
		roleForm.setProjectId((int) request.getSession().getAttribute("currentRoleProjectId"));
		Message message = new Message();
		try {
			roleService.addRole(roleForm);
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
	public Message update(@Form RoleForm roleForm) {
		Message message = new Message();
		try {
			roleService.updateRole(roleForm);
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
			roleService.delRole(id);
			message.setMsg("删除成功！");
		} catch (Exception e) {
			message.setMsg("删除失败！");
		}
		return message;
	}
}
