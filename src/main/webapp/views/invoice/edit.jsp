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


<form:form action="invoice/edit.do" modelAttribute="invoice">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="issuedmoment">
			<spring:message code="invoice.issuedmoment" />:
			</form:label>
			<form:input path="issuedmoment" />
			<form:errors cssClass="error" path="issuedmoment" />
			<br />
			<form:label path="vatnumber">
			<spring:message code="invoice.vatnumber" />:
			</form:label>
			<form:input path="vatnumber" />
			<form:errors cssClass="error" path="vatnumber" />
			<br />
			<form:label path="tenantinfo">
			<spring:message code="invoice.tenantinfo" />:
			</form:label>
			<form:input path="tenantinfo" />
			<form:errors cssClass="error" path="tenantinfo" />
			<br />
			<form:label path="details">
			<spring:message code="invoice.details" />:
			</form:label>
			<form:input path="details" />
			<form:errors cssClass="error" path="details" />
			<br />
			<form:label path="totalamount">
			<spring:message code="invoice.totalamount" />:
			</form:label>
			<form:input path="totalamount" />
			<form:errors cssClass="error" path="totalamount" />
			<br />
			<form:label path="creditcard">
			<spring:message code="invoice.creditcard" />:
			</form:label>
			<form:input path="creditcard" />
			<form:errors cssClass="error" path="creditcard" />
			<br />
			<form:label path="tenant">
			<spring:message code="invoice.tenant" />:
			</form:label>
			<form:input path="tenant" />
			<form:errors cssClass="error" path="tenant" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="invoice.save" />" />

	<jstl:if test="\$\{invoice.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="invoice.delete" />"
			onclick="return confirm('<spring:message code="invoice.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="invoice.cancel" />"
		onclick="javascript: window.location.replace('invoice/list.do')" />

</form:form>