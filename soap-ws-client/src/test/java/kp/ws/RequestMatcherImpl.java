package kp.ws;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.util.AssertionErrors;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.test.client.RequestMatcher;

/**
 * Simple implementation of the {@link RequestMatcher}
 *
 */
class RequestMatcherImpl implements RequestMatcher {

	private static final boolean VERBOSE = false;
	private final String expectedRequestFile;

	/**
	 * The constructor.
	 * 
	 * @param expectedRequestFile the expected request file
	 */
	RequestMatcherImpl(String expectedRequestFile) {
		super();
		this.expectedRequestFile = expectedRequestFile;
	}

	/**
	 * ({@inheritDoc}
	 * 
	 */
	@Override
	public void match(URI uri, WebServiceMessage actualRequest) throws AssertionError {

		String expectedPayload = "";
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try (InputStream inputStream = new FileInputStream(new ClassPathResource(expectedRequestFile).getFile())) {
			expectedPayload = new String(inputStream.readAllBytes()).replace("\r", "").replace("\n", "");
			actualRequest.writeTo(outputStream);
		} catch (IOException e) {
			AssertionErrors.fail("checkRequestPayload(): IOException[" + e.getMessage() + "]");
		}
		final String actualPayload = outputStream.toString();
		if (VERBOSE) {
			System.err.println(actualPayload.replace("><", ">\n<"));
		}
		Assertions.assertEquals(expectedPayload, actualPayload);
	}

}
