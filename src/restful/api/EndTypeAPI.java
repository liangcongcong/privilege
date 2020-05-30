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

import me.spring.entity.EndType;
import me.spring.service.EndTypeService;
import restful.form.ELOForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

@Component
@Path("/manage/endType")
public class EndTypeAPI {
	@Autowired
	private EndTypeService endTypeService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<EndType> list(@Form EasyUIDataPageRequest pageRequest) {
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		return endTypeService.findPageEndTypes(pageable);
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form ELOForm form) {
		Message message = new Message();
		try {
			endTypeService.addEndType(form);
			message.setMsg("保存成功");
		} catch (Exception e) {
			message.setMsg("保存失败");
		}
		return message;
	}

	@POST
	@Path("/update")
	@Produces("application/json;charset=utf-8")
	public Message update(@Form ELOForm form) {
		Message message = new Message();
		try {
			endTypeService.updateEndType(form);
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
			endTypeService.deleteEndType(id);
			message.setMsg("删除成功");
		} catch (Exception e) {
			message.setMsg("删除失败");
		}
		return message;
	}
}
