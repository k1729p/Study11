<!DOCTYPE html>
<HTML>
<HEAD>
	<META charset="UTF-8">
</HEAD>
<BODY>
<a href="../../../tree/main/docs"><IMG src="images/ColorScheme.png" height="25" width="800"/></a>
<H2 id="contents">Study11 README Contents</H2>
<H3>Research the SOAP Web Services</H3>

<P><img src="images/MermaidFlowchart.png" height="395" width="420"/><br>
<img src="images/blackArrowUp.png">
<I>The flowchart with the SpringBoot <b>server</b> application and the SpringBoot <b>client</b> application.</I></P>

<P>The <a href="images/MermaidSequenceDiagram.png">screenshot</a> of the sequence diagram.
</P>

<P>Creating the <b>SOAP Web Services</b>:
<UL>
 <LI>in the server application<br>
  <UL>
   <LI>generate (with XJC Schema Compiler) Java classes from XML schema file
    <a href="https://github.com/k1729p/Study11/tree/master/soap-ws-server/src/main/resources/company.xsd">company.xsd</a></LI>
   <LI>export (with <a href="https://spring.io/projects/spring-ws"><b>Spring Web Services</b></a>) this XSD file
    <a href="https://github.com/k1729p/Study11/tree/master/soap-ws-server/src/main/resources/company.xsd">company.xsd</a> as a WSDL 1.1</LI>
  </UL>
 </LI>
 <LI>in the client application<br>
  <UL>
   <LI>generate (with JAXB) Java classes using WSDL (<a href="images/ScreenshotCompanyWsdl.png">screenshot</a>) 
   from '<A HREF="http://localhost:8080/ws/company.wsdl">http://localhost:8080/ws/company.wsdl</A>'</LI>
  </UL>
 </LI>
</UL>
</P>

<P>
The limitations of the <a href="https://spring.io/projects/spring-ws"><b>Spring Web Services</b></a>: 
XSD-based generation is only supported for WSDL version 1.1 and
Spring-WS only supports the <i>contract-first</i> development style.
</P>

<p>
The sections of this project:
<OL>
<li><a href="#ONE"><b>SpringBoot Server Application</b></a></li>
<li><a href="#TWO"><b>SpringBoot Client Application</b></a></li>
<li><a href="#THREE"><b>Curl Client</b></a></li>
</OL>
</p>

<p>Java source code. Packages in modules 'soap-ws-server', 'soap-ws-client':<br>
<img src="images/aquaHR-500.png"><br>
<img src="images/aquaSquare.png"> module 'soap-ws-server' application sources:
	<a href="https://github.com/k1729p/Study11/tree/master/soap-ws-server/src/main/java/kp/">kp</a><br>
<img src="images/aquaSquare.png"> module 'soap-ws-server' test sources:
	<a href="https://github.com/k1729p/Study11/tree/main/soap-ws-server/src/test/java/kp/ws">kp.ws</a><br>
<img src="images/aquaSquare.png"> module 'soap-ws-client' application sources:
	<a href="https://github.com/k1729p/Study11/tree/master/soap-ws-client/src/main/java/kp/">kp</a><br>
<img src="images/aquaSquare.png"> module 'soap-ws-client' test sources:
	<a href="https://github.com/k1729p/Study11/tree/main/soap-ws-client/src/test/java/kp/ws">kp.ws</a><br>
<img src="images/aquaHR-500.png"></P>

<P><IMG src="images/MermaidClassDiagram.png" height="740" width="270"/><BR>
<img src="images/blackArrowUp.png">
<I>The Java classes are generated from the XML schema file
<a href="https://github.com/k1729p/Study11/tree/master/soap-ws-server/src/main/resources/company.xsd">company.xsd</a>.</I></P>

<p>
The Java classes for request and response are generated from the XML schema file
<a href="https://github.com/k1729p/Study11/tree/master/soap-ws-server/src/main/resources/company.xsd">company.xsd</a>:
<ul>
<li>'GetCompanyRequest', 'GetCompanyResponse'</li>
<li>'GetDepartmentsRequest', 'GetDepartmentsResponse'</li>
<li>'GetEmployeesRequest', 'GetEmployeesResponse'</li>
</ul>
</p>

<p>
<img src="images/yellowHR-500.png"><br>
<img src="images/yellowSquare.png">
    <a href="http://htmlpreview.github.io/?https://github.com/k1729p/Study11/blob/main/docs/apidocs/index.html">
	Java API Documentation</a>&nbsp;●&nbsp;
    <a href="http://htmlpreview.github.io/?https://github.com/k1729p/Study11/blob/main/docs/testapidocs/overview-tree.html">
	Java Test API Documentation</a><br>
<img src="images/yellowHR-500.png">
</p>

<hr/>
<h3 id="ONE">❶ SpringBoot Server Application</H3>

<p>Action:<br>
<img src="images/orangeHR-500.png"><br>
<img src="images/orangeSquare.png"> 1. With batch file 
"<a href="https://github.com/k1729p/Study11/blob/main/0_batch/01%20MVN%20clean%20install%20run%20(server).bat">
01 MVN clean install run (server).bat</a>" build and run the server application.<br>
<img src="images/orangeHR-500.png"></p>

<p><img src="images/greenCircle.png"> 
1.1. The server application tests:
<OL>
<LI>tests with the  <B>WebServiceTemplate</B> in 
<a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/test/java/kp/ws/ApplicationIntegrationTests.java">
ApplicationIntegrationTests</a>.</LI>
<LI>tests with the <B>MockWebServiceClient</B> in 
<a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/test/java/kp/ws/CompanyEndpointIntegrationTests.java">
CompanyEndpointIntegrationTests</a>.</LI>
</OL>
</p>
<p><img src="images/greenCircle.png"> 
1.2. The WSDL file (<a href="images/ScreenshotCompanyWsdl.png">screenshot</a>) link 
'<A HREF="http://localhost:8080/ws/company.wsdl">http://localhost:8080/ws/company.wsdl</A>'.
</p>

<a href="#top">Back to the top of the page</a>
<hr/>
<h3 id="TWO">❷ SpringBoot Client Application</H3>

<P>Action:<BR/>
<img src="images/orangeHR-500.png"><br>
<img src="images/orangeSquare.png"> 1. With batch file 
"<a href="https://github.com/k1729p/Study11/blob/main/0_batch/02%20MVN%20clean%20install%20run%20(client).bat">
02 MVN clean install run (client).bat</a>" build and run the client application.<br>
<img src="images/orangeHR-500.png"></p>

<p><img src="images/greenCircle.png"> 
2.1. The client application tests are with <B>MockWebServiceServer</B> in 
<a href="https://github.com/k1729p/Study11/blob/main/soap-ws-client/src/test/java/kp/ws/CompanyServiceClientIntegrationTests.java">
CompanyServiceClientIntegrationTests</a>.
</p>

<p><img src="images/greenCircle.png"> 
2.2. The service client: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-client/src/main/java/kp/ws/CompanyServiceClient.java">
kp.ws.CompanyServiceClient</a>.
</p>
<p>
The server endpoint: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/ws/CompanyEndpoint.java">
kp.ws.CompanyEndpoint</a>.
</p>
<p>
The server repository: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/repository/CompanyRepository.java">
kp.repository.CompanyRepository</a>. 
The sample dataset is stored in the 'CompanyRepository'. It is the single 'Company' object filled with departments and employees.
</p>

<p><img src="images/greenCircle.png"> 
2.3. Web service 'get company'.<br>
The service client method: 
<a href="https://github.com/k1729p/Study11/blob/main/soap-ws-client/src/main/java/kp/ws/CompanyServiceClient.java#L32">
kp.ws.CompanyServiceClient::getCompany</a>.<br>

<IMG src="images/ClientConsoleLogGetCompany.png" height="45" width="495"/><BR>
<img src="images/blackArrowUp.png">
<i>Client console log for 'get company'.</i>
</p>
<p>
The handler method of the server endpoint: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/ws/CompanyEndpoint.java#L47">
kp.ws.CompanyEndpoint::getCompany</a>.<br>
The server repository method: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/repository/CompanyRepository.java#L78">
kp.repository.CompanyRepository::findCompany</a>.<br>

<IMG src="images/ServerConsoleLogGetCompany.png" height="25" width="400"/><BR>
<img src="images/blackArrowUp.png">
<i>Server console log for 'get company'.</i>
</p>

<p><img src="images/greenCircle.png"> 
2.4. Web service 'get departments'.<br>
The service client method: 
<a href="https://github.com/k1729p/Study11/blob/main/soap-ws-client/src/main/java/kp/ws/CompanyServiceClient.java#L48">
kp.ws.CompanyServiceClient::getDepartments</a>.<br>

<IMG src="images/ClientConsoleLogGetDepartments.png" height="60" width="470"/><BR>
<img src="images/blackArrowUp.png">
<i>Client console log for 'get departments'.</i>
</p>
<p>
The handler method of the server endpoint: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/ws/CompanyEndpoint.java#L63">
kp.ws.CompanyEndpoint::getDepartments</a>.<br>
The server repository method: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/repository/CompanyRepository.java#L87">
kp.repository.CompanyRepository::findDepartments</a>.<br>

<IMG src="images/ServerConsoleLogGetDepartments.png" height="25" width="620"/><BR>
<img src="images/blackArrowUp.png">
<i>Server console log for 'get departments'.</i>
</p>

<p><img src="images/greenCircle.png"> 
2.5. Web service 'get employees'.<br>
The service client method: 
<a href="https://github.com/k1729p/Study11/blob/main/soap-ws-client/src/main/java/kp/ws/CompanyServiceClient.java#L67">
kp.ws.CompanyServiceClient::getEmployees</a>.<br>

<IMG src="images/ClientConsoleLogGetEmployees.png" height="60" width="715"/><BR>
<img src="images/blackArrowUp.png">
<i>Client console log for 'get employees'.</i>
</p>
<p>
The handler method of the server endpoint: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/ws/CompanyEndpoint.java#L80">
kp.ws.CompanyEndpoint::getEmployees</a>.<br>
The server repository method: <a href="https://github.com/k1729p/Study11/blob/main/soap-ws-server/src/main/java/kp/repository/CompanyRepository.java#L100">
kp.repository.CompanyRepository::findEmployees</a>.<br>

<IMG src="images/ServerConsoleLogGetEmployees.png" height="25" width="845"/><BR>
<img src="images/blackArrowUp.png">
<i>Server console log for 'get employees'.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr/>
<h3 id="THREE">❸ Curl Client</H3>

<P>Action:<BR/>
<img src="images/orangeHR-500.png"><br>
<img src="images/orangeSquare.png"> 3. With batch file 
"<a href="https://github.com/k1729p/Study11/blob/main/0_batch/03%20CURL%20call%20server.bat">
03 CURL call server.bat</a>"  execute the requests to the server.<br>
<img src="images/orangeHR-500.png"></P>

<p><img src="images/greenCircle.png"> 
3.1. Web service 'get company' with 
<a href="https://github.com/k1729p/Study11/blob/main/0_batch/requests/company.xml">company.xml</a> request.
</p>
<p>
<img src="images/ScreenshotCurlCompany.png" height="1000" width="550"/><br>
<img src="images/blackArrowUp.png">
<I>The response to the <a href="https://github.com/k1729p/Study11/blob/main/0_batch/requests/company.xml">company.xml</a> request.</I>
</P>

<p><img src="images/greenCircle.png"> 
3.2. Web service 'get departments' with 
<a href="https://github.com/k1729p/Study11/blob/main/0_batch/requests/departments.xml">departments.xml</a> request.
</p>
<p>
<img src="images/ScreenshotCurlDepartments.png" height="570" width="520"/><br>
<img src="images/blackArrowUp.png">
<I>The response to the <a href="https://github.com/k1729p/Study11/blob/main/0_batch/requests/departments.xml">departments.xml</a> request.</I>
</P>

<p><img src="images/greenCircle.png"> 
3.3. Web service 'get employees' with 
<a href="https://github.com/k1729p/Study11/blob/main/0_batch/requests/employees.xml">employees.xml</a> request.
</p>
<p>
<img src="images/ScreenshotCurlEmployees.png" height="290" width="520"/><br>
<img src="images/blackArrowUp.png">
<I>The response to the <a href="https://github.com/k1729p/Study11/blob/main/0_batch/requests/employees.xml">employees.xml</a> request.</I>
</P>

<a href="#top">Back to the top of the page</a>
<HR/>
</BODY>
</HTML>