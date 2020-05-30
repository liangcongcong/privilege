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

import me.spring.entity.User;
import me.spring.service.UserService;
import restful.form.UserForm;
import restful.utils.EasyUIData;
import restful.utils.EasyUIDataPageRequest;
import restful.utils.Message;

//提供增删改
@Component
@Path("/manage/user")
public class UserAPI {
	@Autowired
	private UserService userService;

	@POST
	@Path("/list")
	@Produces("application/json;charset=utf-8")
	public EasyUIData<User> list(@Form EasyUIDataPageRequest pageRequest) {
		List<Sort.Order> orders = new ArrayList<Sort.Order>();
		if ("asc".equals(pageRequest.getOrder())) {
			orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
		} else {
			orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
		}
		Pageable pageable = new PageRequest(pageRequest.getPage() - 1, pageRequest.getRows(), new Sort(orders));
		EasyUIData<User> result = userService.findPageUsers(pageable);
		List<User> list = result.getRows();
		for (User user : list) {
			user.setPassword("");
		}
		return result;
	}

	@POST
	@Path("/add")
	@Produces("application/json;charset=utf-8")
	public Message add(@Form UserForm userForm) {
		Message message = new Message();
		String prompt = "";
		try {
			String password = userForm.getPassword();
			if (password==null || password.equals("")) {
				prompt = ": 请输入密码!";
				throw new Exception();
			}
			
			userService.addUser(userForm);
			message.setMsg("保存成功");
		} catch (Exception e) {
			message.setMsg("保存失败"+prompt);
		}
		return message;
	}

	@POST
	@Path("/update")
	@Produces("application/json;charset=utf-8")
	public Message update(@Form UserForm userForm) {
		Message message = new Message();
		try {
			userService.updateUser(userForm);
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
			userService.deleteUser(id);
			message.setMsg("删除成功");
		} catch (Exception e) {
			message.setMsg("删除失败");
		}
		return message;
	}
}
