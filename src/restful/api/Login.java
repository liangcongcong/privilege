package restful.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.springframework.stereotype.Component;
import net.sf.json.JSONObject;
@Component
@Path("/request")
public class Login {
	@Context
	private HttpServletRequest request;
	
	@Path("/login")
	@GET// 这里用get做测试
	@Produces("application/json;charset=utf-8")
	public Object test() {
		//request.getSession().setAttribute("loginUser", new User());
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		JSONObject js = new JSONObject();
		if(request.getParameter("username").equals("user1"))
		{
			js.put("url", "jsp/menu.jsp");	
			return js;
		}
		else
		{
			js.put("errorInfo", "请确认用户名是否正确!");
			return js;
		}
	}
}
