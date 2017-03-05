<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>


<form:form action="invoice/edit.do" modelAttribute="invoice">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="tenant"/>
	<form:hidden path="creditCard"/>

	<acme:textbox path="issuedMoment" code="invoice.issuedmoment"/>
	<br />

	<acme:textbox path="VATNumber" code="invoice.vatnumber"/>
	<br />
	<acme:textbox path="tenantInfo" code="invoice.tenantinfo"/>
	<br />
	<acme:textbox path="details" code="invoice.details"/>
	<br />
	<acme:textbox path="totalAmount" code="invoice.totalamount"/>
	<br />
	<acme:textbox path="issuedMoment" code="invoice.issuedmoment"/>
	<br />
	<acme:textbox path="issuedMoment" code="invoice.issuedmoment"/>
	<br />







	<!---------------------------- BOTONES -------------------------->
<acme:submit name="save" code="invoice.save"/>

	<jstl:if test="\$\{invoice.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="invoice.delete" />"
			onclick="return confirm('<spring:message code="invoice.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="invoice.cancel" />"
		onclick="javascript: window.location.replace('invoice/list.do')" />

</form:form>