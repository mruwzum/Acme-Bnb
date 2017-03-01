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

<form:form action="property/edit.do" modelAttribute="property">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<acme:textbox path="name" code="property.name"/>
	<br />
	<acme:textbox path="rate" code="property.rate"/>
	<br />
	<acme:textbox path="description" code="property.description"/>
	<br />
	<acme:textbox path="address" code="property.address"/>
	<br />
	<acme:textbox path="province" code="property.province"/>
	<br />
	<acme:textbox path="country" code="property.country"/>
	<br />
	<acme:textbox path="state" code="property.state"/>
	<br />
	<acme:textbox path="capacity" code="property.capacity"/>
	<br />
	<acme:textbox path="city" code="property.city"/>
	<br />
	<acme:textbox path="lessor" code="property.lessor"/>
	<br />



	<!---------------------------- BOTONES -------------------------->
	<acme:submit name="save" code="property.save"/>

	<jstl:if test="\$\{property.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="property.delete" />"
			onclick="return confirm('<spring:message code="property.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="property.cancel" />"
		onclick="javascript: window.location.replace('property/list.do')" />

</form:form>


<!-- AUDITS -->


<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="audits" requestURI="${requestURI}" id="row">


    <!-- Attributes -->


	<spring:message code="audit.writtenMoment" var="writtenMoment"/>
	<display:column property="writtenMoment" title="writtenMoment" sortable="true"/>
    <spring:message code="audit.text" var="text"/>
    <display:column property="text" title="text" sortable="true"/>
    <spring:message code="audit.auditor" var="auditor"/>
    <display:column property="auditor" title="auditor" sortable="true"/>

</display:table>


<!-- BOOKREQUEST -->

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="bookRequests" requestURI="${requestURI}" id="row">


    <!-- Attributes -->


    <spring:message code="bookRequest.checkindate" var="checkindate"/>
    <display:column property="checkindate" title="checkindate" sortable="true"/>
    <spring:message code="bookRequest.checkoutdate" var="checkoutdate"/>
    <display:column property="checkoutdate" title="checkoutdate" sortable="true"/>
    <spring:message code="bookRequest.smoker" var="smoker"/>
    <display:column property="smoker" title="smoker" sortable="true"/>
    <spring:message code="bookRequest.status" var="status"/>
    <display:column property="status" title="status" sortable="true"/>
    <spring:message code="bookRequest.tenant" var="tenant"/>
    <display:column property="tenant" title="tenant" sortable="true"/>

</display:table>
