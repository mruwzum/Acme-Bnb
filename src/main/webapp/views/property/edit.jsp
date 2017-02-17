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


<form:form action="property/edit.do" modelAttribute="property">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
			<form:label path="name">
			<spring:message code="property.name" />:
			</form:label>
			<form:input path="name" />
			<form:errors cssClass="error" path="name" />
			<br />
			<form:label path="rate">
			<spring:message code="property.rate" />:
			</form:label>
			<form:input path="rate" />
			<form:errors cssClass="error" path="rate" />
			<br />
			<form:label path="description">
			<spring:message code="property.description" />:
			</form:label>
			<form:input path="description" />
			<form:errors cssClass="error" path="description" />
			<br />
			<form:label path="address">
			<spring:message code="property.address" />:
			</form:label>
			<form:input path="address" />
			<form:errors cssClass="error" path="address" />
			<br />
			<form:label path="province">
			<spring:message code="property.province" />:
			</form:label>
			<form:input path="province" />
			<form:errors cssClass="error" path="province" />
			<br />
			<form:label path="country">
			<spring:message code="property.country" />:
			</form:label>
			<form:input path="country" />
			<form:errors cssClass="error" path="country" />
			<br />
			<form:label path="state">
			<spring:message code="property.state" />:
			</form:label>
			<form:input path="state" />
			<form:errors cssClass="error" path="state" />
			<br />
			<form:label path="capacity">
			<spring:message code="property.capacity" />:
			</form:label>
			<form:input path="capacity" />
			<form:errors cssClass="error" path="capacity" />
			<br />
			<form:label path="city">
			<spring:message code="property.city" />:
			</form:label>
			<form:input path="city" />
			<form:errors cssClass="error" path="city" />
			<br />
			<form:label path="lessor">
			<spring:message code="property.lessor" />:
			</form:label>
			<form:input path="lessor" />
			<form:errors cssClass="error" path="lessor" />
			<br />
			<form:label path="audit">
			<spring:message code="property.audit" />:
			</form:label>
			<form:input path="audit" />
			<form:errors cssClass="error" path="audit" />
			<br />
			<form:label path="bookrequest">
			<spring:message code="property.bookrequest" />:
			</form:label>
			<form:input path="bookrequest" />
			<form:errors cssClass="error" path="bookrequest" />
			<br />

	<!---------------------------- BOTONES -------------------------->

	<input type="submit" name="save"
		value="<spring:message code="property.save" />" />

	<jstl:if test="\$\{property.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="property.delete" />"
			onclick="return confirm('<spring:message code="property.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="property.cancel" />"
		onclick="javascript: window.location.replace('property/list.do')" />

</form:form>