package restful.utils;

import javax.servlet.ServletContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class PrivilegeUtils {

	public static String sha256(String string) {
		return DigestUtils.sha256Hex(string);
	}

	public static Object getBean(ServletContext servletContext, String beanName) {
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return ctx.getBean(beanName);
	}
}
