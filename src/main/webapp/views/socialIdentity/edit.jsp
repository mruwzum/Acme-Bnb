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


<form:form action="socialIdentity/edit.do" modelAttribute="socialIdentity">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<acme:textbox path="nick" code="socialIdentity.nick"/>
	<br />

	<acme:textbox path="socialNetwork" code="socialIdentity.socialnetwork"/>
	<br />

	<acme:textbox path="URL" code="socialIdentity.url"/>
	<br />


	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="socialIdentity.save" />" />

	<jstl:if test="\$\{socialIdentity.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="socialIdentity.delete" />"
			onclick="return confirm('<spring:message code="socialIdentity.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="socialIdentity.cancel" />"
		onclick="javascript: window.location.replace('socialIdentity/list.do')" />

</form:form>