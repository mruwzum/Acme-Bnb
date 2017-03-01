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

<security:authorize access="permitAll">
	<div>
		<H5>
			<a href="property/create.do"> <spring:message
					code="property.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="propertys" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="hasRole('LESSOR')">
		<display:column>
			<a href="property/edit.do?propertyId=${row.id}">
				<spring:message code="property.edit"/>
			</a>
		</display:column>

	</security:authorize>
	<security:authorize access="hasRole('TENANT')">
		<display:column>
			<a href="bookRequest/createRequest.do?propertyId=${row.id}">
				<spring:message code="property.request"/>
			</a>
		</display:column>

	</security:authorize>

	<security:authorize access="isAnonymous()">
		<display:column>
			<a href="lessor/view.do?propertyId=${row.id}">
				<spring:message code="property.viewlessor"/>
			</a>
		</display:column>

	</security:authorize>

			<spring:message code="property.name" var="name" />
	<display:column property="name" title="name" sortable="true"/>
			<spring:message code="property.rate" var="rate" />
	<display:column property="rate" title="rate" sortable="true"/>
			<spring:message code="property.description" var="description" />
	<display:column property="description" title="description" sortable="true"/>
			<spring:message code="property.address" var="address" />
	<display:column property="address" title="address" sortable="true"/>
			<spring:message code="property.province" var="province" />
	<display:column property="province" title="province" sortable="true"/>
			<spring:message code="property.country" var="country" />
	<display:column property="country" title="country" sortable="true"/>
			<spring:message code="property.state" var="state" />
	<display:column property="state" title="state" sortable="true"/>
			<spring:message code="property.capacity" var="capacity" />
	<display:column property="capacity" title="capacity" sortable="true"/>
			<spring:message code="property.city" var="city" />
	<display:column property="city" title="city" sortable="true"/>
			<spring:message code="property.lessor" var="lessor" />
	<display:column property="lessor" title="lessor" sortable="true"/>

	<security:authorize access="permitAll">
		<display:column>
			<a href="property/view.do?propertyId=${row.id}">
				<spring:message code="property.view"/>
			</a>
		</display:column>
	</security:authorize>
	<security:authorize access="hasRole('AUDITOR')">
		<display:column>
			<a href="audit/createFromProp.do?propertyId=${row.id}">
				<spring:message code="property.audit"/>
			</a>
		</display:column>
	</security:authorize>

</display:table>


