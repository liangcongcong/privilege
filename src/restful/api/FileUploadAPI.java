package restful.api;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Component;

import restful.utils.Message;
import restful.utils.UploadFileUtils;
@Component
@Path("/request/api/fileUpload")
public class FileUploadAPI {
	
	@POST
	@Consumes("multipart/form-data")
	@Path("/upload")
	@Produces("application/json;charset=utf-8")
	public Message upload(MultipartFormDataInput input,@Context HttpServletRequest httpServletRequest) {
		return UploadFileUtils.upload("file",httpServletRequest, input);
	}
}
