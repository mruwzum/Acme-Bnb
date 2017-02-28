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

<form:form action="bookRequest/edit.do" modelAttribute="bookRequest">

	<form:hidden path="id" />
	<form:hidden path="version" />

		<acme:textbox path="checkInDate" code="bookRequest.checkindate"/>
			<br />
		<acme:textbox path="checkOutDate" code="bookRequest.checkoutdate"/>
			<br />
		<acme:textbox path="smoker" code="bookRequest.smoker"/>
			<br />
		<acme:textbox path="creditCard" code="bookRequest.creditcard"/>
			<br />
		<acme:textbox path="status" code="bookRequest.status"/>
			<br />
		<acme:select path="tenant" code="bookRequest.tenant" items="tenant" itemLabel="tenant"/>
			<br />
	<acme:select path="property" code="bookRequest.property" items="property" itemLabel="property"/>
			<br />

	<!---------------------------- BOTONES -------------------------->

	<acme:submit name="save" code="bookRequest.save"/>

	<jstl:if test="\$\{bookRequest.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="bookRequest.delete" />"
			onclick="return confirm('<spring:message code="bookRequest.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<acme:cancel code="bookRequest.cancel" url="bookRequest/list.do"/>

</form:form>