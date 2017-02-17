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


<form:form action="auditor/edit.do" modelAttribute="auditor">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="nameofcompany">
			<spring:message code="auditor.nameofcompany" />:
			</form:label>
			<form:input path="nameofcompany" />
			<form:errors cssClass="error" path="nameofcompany" />
			<br />
			<form:label path="audit">
			<spring:message code="auditor.audit" />:
			</form:label>
			<form:input path="audit" />
			<form:errors cssClass="error" path="audit" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="auditor.save" />" />

	<jstl:if test="\$\{auditor.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="auditor.delete" />"
			onclick="return confirm('<spring:message code="auditor.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="auditor.cancel" />"
		onclick="javascript: window.location.replace('auditor/list.do')" />

</form:form>