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


<form:form action="bookRequest/edit.do" modelAttribute="bookRequest">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="checkindate">
			<spring:message code="bookRequest.checkindate" />:
			</form:label>
			<form:input path="checkindate" />
			<form:errors cssClass="error" path="checkindate" />
			<br />
			<form:label path="checkoutdate">
			<spring:message code="bookRequest.checkoutdate" />:
			</form:label>
			<form:input path="checkoutdate" />
			<form:errors cssClass="error" path="checkoutdate" />
			<br />
			<form:label path="smoker">
			<spring:message code="bookRequest.smoker" />:
			</form:label>
			<form:input path="smoker" />
			<form:errors cssClass="error" path="smoker" />
			<br />
			<form:label path="creditcard">
			<spring:message code="bookRequest.creditcard" />:
			</form:label>
			<form:input path="creditcard" />
			<form:errors cssClass="error" path="creditcard" />
			<br />
			<form:label path="status">
			<spring:message code="bookRequest.status" />:
			</form:label>
			<form:input path="status" />
			<form:errors cssClass="error" path="status" />
			<br />
			<form:label path="tenant">
			<spring:message code="bookRequest.tenant" />:
			</form:label>
			<form:input path="tenant" />
			<form:errors cssClass="error" path="tenant" />
			<br />
			<form:label path="property">
			<spring:message code="bookRequest.property" />:
			</form:label>
			<form:input path="property" />
			<form:errors cssClass="error" path="property" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="bookRequest.save" />" />

	<jstl:if test="\$\{bookRequest.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="bookRequest.delete" />"
			onclick="return confirm('<spring:message code="bookRequest.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="bookRequest.cancel" />"
		onclick="javascript: window.location.replace('bookRequest/list.do')" />

</form:form>