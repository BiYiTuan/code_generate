package my.learn.code.generate.utils;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;



public class VelocityUtils {
	private static Log log = LogFactory.getLog(VelocityUtils.class);

	static {

		Properties properties=new Properties();
		properties.setProperty("resource.loader", "class");
		properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(properties);

	}
	
	public static String mergeTemplate(Map<String, Object> contextMap,
			String templatePath) {

		StringWriter sw = new StringWriter(1000);
		try {

			Template template = Velocity.getTemplate("vm/" + templatePath,"UTF-8");
			Context context = new VelocityContext(contextMap);
			template.merge(context, sw);
			//sw.flush();
		} catch (Exception ex) {
			log.error(ex);
		}
		return sw.toString();
	}
	


}
