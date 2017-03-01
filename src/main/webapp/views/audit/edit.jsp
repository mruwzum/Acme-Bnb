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

<form:form action="audit/edit.do" modelAttribute="audit">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="comments" />
	<form:hidden path="auditor" />

	<acme:textbox path="writtenMoment" code="audit.writtenMoment"/>
	<br />
	<acme:textbox path="text" code="audit.text"/>
	<br />
	<acme:textbox path="attachments" code="audit.attachments"/>
	<br />
	<acme:textbox path="property" code="audit.property"/>
	<br />



	<!---------------------------- BOTONES -------------------------->


	<acme:submit name="save" code="audit.save"/>

	<jstl:if test="\$\{audit.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="audit.delete" />"
			onclick="return confirm('<spring:message code="audit.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="audit.cancel" />"
		onclick="javascript: window.location.replace('audit/draft.do')" />

</form:form>