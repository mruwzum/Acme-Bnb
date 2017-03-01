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


<form:form action="tenant/edit.do" modelAttribute="tenant">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="invoices"/>
	<form:hidden path="finders"/>
	<form:hidden path="bookRequests"/>

	<form:label path="name">
		<spring:message code="actor.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />
	<form:label path="surname">
		<spring:message code="actor.surname" />:
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br />
	<form:label path="email">
		<spring:message code="actor.email" />:
	</form:label>
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br />
	<form:label path="phone">
		<spring:message code="actor.phone" />:
	</form:label>
	<form:input path="phone" />
	<form:errors cssClass="error" path="phone" />
	<br />
	<form:label path="picture">
		<spring:message code="actor.picture" />:
	</form:label>
	<form:input path="picture" />
	<form:errors cssClass="error" path="picture" />
	<br />
    <br>

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

	<input type="submit" name="save"
		value="<spring:message code="tenant.save" />" />

	<jstl:if test="\$\{tenant.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="tenant.delete" />"
			onclick="return confirm('<spring:message code="tenant.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="tenant.cancel" />"
		onclick="javascript: window.location.replace('tenant/list.do')" />

</form:form>