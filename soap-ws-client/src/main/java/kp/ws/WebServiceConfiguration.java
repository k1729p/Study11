package kp.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import kp.Constants;

/**
 * The web service configuration for the client.
 *
 */
@Configuration
public class WebServiceConfiguration {

	/**
	 * The constructor.
	 */
	public WebServiceConfiguration() {
		super();
	}

	/**
	 * Produces the {@link Jaxb2Marshaller}.
	 * 
	 * @return the {@link Jaxb2Marshaller}
	 */
	@Bean
	public Jaxb2Marshaller marshaller() {

		final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(Constants.GENERATED_PACKAGE);
		return marshaller;
	}

	/**
	 * Produces the {@link CompanyServiceClient}.
	 * 
	 * @param marshaller the {@link Jaxb2Marshaller}
	 * @return the {@link CompanyServiceClient}
	 */
	@Bean
	public CompanyServiceClient companyServiceClient(Jaxb2Marshaller marshaller) {

		final CompanyServiceClient companyServiceClient = new CompanyServiceClient();
		companyServiceClient.setDefaultUri(Constants.DEFAULT_URI);
		companyServiceClient.setMarshaller(marshaller);
		companyServiceClient.setUnmarshaller(marshaller);
		return companyServiceClient;
	}
}