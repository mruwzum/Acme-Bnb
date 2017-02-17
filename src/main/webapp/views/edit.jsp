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
	
			<form:label path="bookrequest">
			<spring:message code="tenant.bookrequest" />:
			</form:label>
			<form:input path="bookrequest" />
			<form:errors cssClass="error" path="bookrequest" />
			<br />
			<form:label path="invoice">
			<spring:message code="tenant.invoice" />:
			</form:label>
			<form:input path="invoice" />
			<form:errors cssClass="error" path="invoice" />
			<br />
			<form:label path="finder">
			<spring:message code="tenant.finder" />:
			</form:label>
			<form:input path="finder" />
			<form:errors cssClass="error" path="finder" />
			<br />

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