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


<form:form action="actor/edit.do" modelAttribute="actor">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
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
			<form:label path="socialidentity">
			<spring:message code="actor.socialidentity" />:
			</form:label>
			<form:input path="socialidentity" />
			<form:errors cssClass="error" path="socialidentity" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="actor.save" />" />

	<jstl:if test="\$\{actor.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="actor.delete" />"
			onclick="return confirm('<spring:message code="actor.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="actor.cancel" />"
		onclick="javascript: window.location.replace('actor/list.do')" />

</form:form>