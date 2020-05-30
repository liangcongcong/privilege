package restful.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jboss.resteasy.annotations.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import me.spring.entity.Project;
import me.spring.service.ProjectService;
import restful.form.ProjectForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

//提供增删改
@Component
@Path("/manage/project")
public class ProjectAPI {
	@Autowired
	private ProjectService projectService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<Project> list(@Form EasyUIDataPageRequest pageRequest) {
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		return projectService.findPageProjects(pageable);
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form ProjectForm projectForm) {
		Message message = new Message();
		try {
			projectService.addProject(projectForm);
			message.setMsg("保存成功");
		} catch (Exception e) {
			message.setMsg("保存失败");
		}
		return message;
	}

	@POST
	@Path("/update")
	@Produces("application/json;charset=utf-8")
	public Message update(@Form ProjectForm projectForm) {
		Message message = new Message();
		try {
			projectService.updateProject(projectForm);
			message.setMsg("保存成功");
		} catch (Exception e) {
			message.setMsg("保存失败");
		}
		return message;
	}

	@POST
	@Path("/del")
	@Produces("application/json;charset=utf-8")
	public Message del(@FormParam("id") int id) {
		Message message = new Message();
		try {
			projectService.deleteProject(id);
			message.setMsg("删除成功");
		} catch (Exception e) {
			message.setMsg("删除失败");
		}
		return message;
	}
	
	@POST
	@Path("/comboBoxList")
	@Produces("application/json;charset=utf-8")
	public List<Project> comboBoxList() {
		return projectService.findAllProjects();
	}
}
