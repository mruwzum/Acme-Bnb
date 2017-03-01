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

<form:form action="lessor/edit.do" modelAttribute="lessor">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="propertys" />

	<acme:textbox path="name" code="actor.name"/>
	<br />
	<acme:textbox path="surname" code="actor.surname"/>
	<br />
	<acme:textbox path="email" code="actor.email"/>
	<br />
	<acme:textbox path="phone" code="actor.phone"/>
	<br />
	<acme:textbox path="picture" code="actor.picture"/>
	<br />
	<acme:textbox path="creditCard" code="lessor.creditcard"/>
	<br />


	<h1>User Account</h1>
	<br>
	<acme:textbox path="UserAccount.username" code="actor.username"/>
	<br />
	<acme:textbox path="UserAccount.password" code="actor.password"/>
	<br />

	<!---------------------------- BOTONES -------------------------->

	<acme:submit name="save" code="lessor.save"/>

	<jstl:if test="\$\{lessor.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="lessor.delete" />"
			onclick="return confirm('<spring:message code="lessor.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="lessor.cancel" />"
		onclick="javascript: window.location.replace('lessor/list.do')" />

</form:form>