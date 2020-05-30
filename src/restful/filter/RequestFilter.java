package restful.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;

public class RequestFilter implements ContainerRequestFilter {
	@Context
	private HttpServletRequest request;
	
	@Override
	public void filter(ContainerRequestContext paramContainerRequestContext) throws IOException {
	}

}
