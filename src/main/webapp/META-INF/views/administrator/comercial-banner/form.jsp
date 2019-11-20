<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="administrator.comercial-banner.form.picture" path="picture"/>
	<acme:form-textarea code="administrator.comercial-banner.form.slogan" path="slogan"/>
	<acme:form-url code="administrator.comercial-banner.form.targetUrl" path="targetUrl"/>
	<acme:form-textbox code="administrator.comercial-banner.form.creditCard" path="creditCard"/>
	<acme:form-textbox code="administrator.comercial-banner.form.monthExp" path="monthExp"/>
	<acme:form-textbox code="administrator.comercial-banner.form.yearExp" path="yearExp"/>
	<acme:form-textbox code="administrator.comercial-banner.form.cvv" path="cvv"/>
	
	<acme:form-submit test="${command == 'show' }"
		code="administrator.comercial-banner.form.button.update" 
		action="/administrator/comercial-banner/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="administrator.comercial-banner.form.button.delete" 
		action="/administrator/comercial-banner/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="administrator.comercial-banner.form.button.create" 
		action="/administrator/comercial-banner/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.comercial-banner.form.button.update" 
		action="/administrator/comercial-banner/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="administrator.comercial-banner.form.button.delete" 
		action="/administrator/comercial-banner/delete"/>
	
	<acme:form-return code="administrator.comercial-banner.form.button.return"/>
</acme:form>
