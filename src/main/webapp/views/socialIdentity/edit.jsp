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


<form:form action="socialIdentity/edit.do" modelAttribute="socialIdentity">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="nick">
			<spring:message code="socialIdentity.nick" />:
			</form:label>
			<form:input path="nick" />
			<form:errors cssClass="error" path="nick" />
			<br />
			<form:label path="socialnetwork">
			<spring:message code="socialIdentity.socialnetwork" />:
			</form:label>
			<form:input path="socialnetwork" />
			<form:errors cssClass="error" path="socialnetwork" />
			<br />
			<form:label path="url">
			<spring:message code="socialIdentity.url" />:
			</form:label>
			<form:input path="url" />
			<form:errors cssClass="error" path="url" />
			<br />


	<security:authorize access="isAuthenticated()">
		<display:column>

		</display:column>
	</security:authorize>

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