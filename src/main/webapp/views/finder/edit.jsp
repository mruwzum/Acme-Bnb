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


<form:form action="finder/edit.do" modelAttribute="finder">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="destinationcity">
			<spring:message code="finder.destinationcity" />:
			</form:label>
			<form:input path="destinationcity" />
			<form:errors cssClass="error" path="destinationcity" />
			<br />
			<form:label path="minimumpay">
			<spring:message code="finder.minimumpay" />:
			</form:label>
			<form:input path="minimumpay" />
			<form:errors cssClass="error" path="minimumpay" />
			<br />
			<form:label path="maximumpay">
			<spring:message code="finder.maximumpay" />:
			</form:label>
			<form:input path="maximumpay" />
			<form:errors cssClass="error" path="maximumpay" />
			<br />
			<form:label path="keyword">
			<spring:message code="finder.keyword" />:
			</form:label>
			<form:input path="keyword" />
			<form:errors cssClass="error" path="keyword" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="finder.save" />" />

	<jstl:if test="\$\{finder.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="finder.delete" />"
			onclick="return confirm('<spring:message code="finder.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="finder.cancel" />"
		onclick="javascript: window.location.replace('finder/list.do')" />

</form:form>