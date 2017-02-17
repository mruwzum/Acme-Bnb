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


<form:form action="lessor/edit.do" modelAttribute="lessor">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="creditcard">
			<spring:message code="lessor.creditcard" />:
			</form:label>
			<form:input path="creditcard" />
			<form:errors cssClass="error" path="creditcard" />
			<br />
			<form:label path="property">
			<spring:message code="lessor.property" />:
			</form:label>
			<form:input path="property" />
			<form:errors cssClass="error" path="property" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="lessor.save" />" />

	<jstl:if test="\$\{lessor.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="lessor.delete" />"
			onclick="return confirm('<spring:message code="lessor.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="lessor.cancel" />"
		onclick="javascript: window.location.replace('lessor/list.do')" />

</form:form>