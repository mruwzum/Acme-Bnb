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

<form:form action="auditor/edit.do" modelAttribute="auditor">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="userAccount"/>




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
	<acme:textbox path="nameOfCompany" code="auditor.nameofcompany"/>
	<br />

	    <h1>User Account</h1>
	   <br>
	    <form:label path="UserAccount.username">
			<spring:message code="actor.username"/>:
	    </form:label>

	    <form:input path="UserAccount.username"/>
	   <form:errors cssClass="error" path="UserAccount.username"/>
	    <br/>
		<br>
	   <form:label path="UserAccount.password">
		   <spring:message code="actor.password"/>:
	    </form:label>
	    <form:password path="UserAccount.password"/>
	    <form:errors cssClass="error" path="UserAccount.password"/>
	    <br/>

	<!---------------------------- BOTONES -------------------------->

	<acme:submit name="save" code="auditor.save"/>

	<jstl:if test="\$\{auditor.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="auditor.delete" />"
			onclick="return confirm('<spring:message code="auditor.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="auditor.cancel" />"
		onclick="javascript: window.location.replace('auditor/list.do')" />

</form:form>