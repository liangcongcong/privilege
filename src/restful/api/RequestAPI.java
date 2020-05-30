package restful.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import restful.annotation.RequestJSONFilterBinding;

@Path("/request")
public class RequestAPI {
	
	@GET
	@Path("/json")
	@Produces("application/json;charset=utf-8")
	@RequestJSONFilterBinding
	public String JSON() {
		return null;
	}
}
