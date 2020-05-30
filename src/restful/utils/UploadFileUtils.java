package restful.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import restful.utils.Message;

public class UploadFileUtils {
	public static Message upload(String inputName,HttpServletRequest request,MultipartFormDataInput dataInput) {
		Message message=new Message();
		String parent=request.getServletContext().getRealPath("WEB-INF/lib");
		Map<String, List<InputPart>> form=dataInput.getFormDataMap();
		List<InputPart> uploadFileParts=form.get(inputName);
		MultivaluedMap<String, String> headers=uploadFileParts.get(0).getHeaders();
		String fileName=getFileName(headers);
		if(fileName==null) {
			message.setMsg("未知错误");
			return message;
		}else if(!fileName.endsWith(".jar")){
			message.setMsg("请上传.jar文件");
			return message;
		}
		File file=new File(parent, fileName);
		if(file.exists()) {
			message.setMsg("上传失败，文件已存在。");
			return message;
		}
		try {
			InputStream inputStream=uploadFileParts.get(0).getBody(InputStream.class, null);
			transferTo(inputStream, new FileOutputStream(file));
		} catch (IOException e) {
			message.setMsg("IO异常");
			e.printStackTrace();
			return message;
		}
		message.setMsg("上传成功，请重启服务器。");
		return message;
	}
	private static String getFileName(MultivaluedMap<String, String> headers) {
		String[] parts=headers.getFirst("Content-Disposition").split(";");
		for(String part:parts) {
			if(part.trim().startsWith("filename")) {
				String[] key_value=part.split("=");
				return key_value[1].replace("\"", "");
			}
		}
		return null;
	}
	private static void transferTo(InputStream inputStream,OutputStream outputStream) throws IOException {
		byte[] buffer=new byte[1024];
		int length=0;
		while((length=inputStream.read(buffer))!=-1) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}
}
