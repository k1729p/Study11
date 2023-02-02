package kp;

/**
 * The constants
 *
 */
@SuppressWarnings("doclint:missing")
public final class Constants {

	public static final String TARGET_NAMESPACE = "http://kp.com/ws";
	public static final String URL_MAPPINGS = "/ws/*";
	public static final String WSDL_DEFINITION_BEAN_NAME = "company";
	public static final String PORT_TYPE = "CompanyPort";
	public static final String LOCATION_URI = "/ws";
	public static final String SCHEMA_XSD_PATH = "company.xsd";

	private Constants() {
		throw new IllegalStateException("Utility class");
	}
}