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

import me.spring.entity.Application;
import me.spring.service.ApplicationService;
import restful.form.ApplicationForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

//提供增删改
@Component
@Path("/manage/application")
public class ApplicationAPI {
	@Autowired
	private ApplicationService applicationService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<Application> list(@Form EasyUIDataPageRequest pageRequest) {
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		return applicationService.findPageApplications(pageable);
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form ApplicationForm applicationForm) {
		Message message = new Message();
		try {
			applicationService.addApplication(applicationForm);
			message.setMsg("保存成功");
		} catch (Exception e) {
			message.setMsg("保存失败");
		}
		return message;
	}

	@POST
	@Path("/update")
	@Produces("application/json;charset=utf-8")
	public Message update(@Form ApplicationForm applicationForm) {
		Message message = new Message();
		try {
			applicationService.updateApplication(applicationForm);
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
			applicationService.deleteApplication(id);
			message.setMsg("删除成功");
		} catch (Exception e) {
			message.setMsg("删除失败");
		}
		return message;
	}
}
