package kp.ws;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import kp.Constants;

/**
 * The web service configuration for the server.
 *
 */
@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

	/**
	 * The constructor.
	 */
	public WebServiceConfiguration() {
		super();
	}

	/**
	 * Produces the {@link ServletRegistrationBean} with the
	 * {@link MessageDispatcherServlet} and URL mappings.
	 * 
	 * @param applicationContext the {@link ApplicationContext}
	 * @return the {@link ServletRegistrationBean}
	 */
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {

		final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, Constants.URL_MAPPINGS);
	}

	/**
	 * Produces the {@link DefaultWsdl11Definition}
	 * 
	 * @param xsdSchema the {@link XsdSchema}
	 * @return the {@link DefaultWsdl11Definition}
	 */
	@Bean(name = Constants.WSDL_DEFINITION_BEAN_NAME)
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {

		final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName(Constants.PORT_TYPE);
		wsdl11Definition.setLocationUri(Constants.LOCATION_URI);
		wsdl11Definition.setSchema(xsdSchema);
		return wsdl11Definition;
	}

	/**
	 * Produces the {@link XsdSchema} from the <b>company.xsd</b> file.
	 * 
	 * @return the {@link XsdSchema}
	 */
	@Bean
	public XsdSchema companySchema() {
		return new SimpleXsdSchema(new ClassPathResource(Constants.SCHEMA_XSD_PATH));
	}
}