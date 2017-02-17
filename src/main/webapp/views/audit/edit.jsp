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


<form:form action="audit/edit.do" modelAttribute="audit">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="writtenmoment">
			<spring:message code="audit.writtenmoment" />:
			</form:label>
			<form:input path="writtenmoment" />
			<form:errors cssClass="error" path="writtenmoment" />
			<br />
			<form:label path="text">
			<spring:message code="audit.text" />:
			</form:label>
			<form:input path="text" />
			<form:errors cssClass="error" path="text" />
			<br />
			<form:label path="attachments">
			<spring:message code="audit.attachments" />:
			</form:label>
			<form:input path="attachments" />
			<form:errors cssClass="error" path="attachments" />
			<br />
			<form:label path="property">
			<spring:message code="audit.property" />:
			</form:label>
			<form:input path="property" />
			<form:errors cssClass="error" path="property" />
			<br />
			<form:label path="auditor">
			<spring:message code="audit.auditor" />:
			</form:label>
			<form:input path="auditor" />
			<form:errors cssClass="error" path="auditor" />
			<br />
			<form:label path="comment">
			<spring:message code="audit.comment" />:
			</form:label>
			<form:input path="comment" />
			<form:errors cssClass="error" path="comment" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="audit.save" />" />

	<jstl:if test="\$\{audit.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="audit.delete" />"
			onclick="return confirm('<spring:message code="audit.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="audit.cancel" />"
		onclick="javascript: window.location.replace('audit/list.do')" />

</form:form>