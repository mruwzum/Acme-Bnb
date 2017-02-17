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
			<a href="bookRequest/create.do"> <spring:message
					code="bookRequest.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="bookRequests" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="bookRequest/edit.do?bookRequestId=${row.id}> <spring:message
					code="bookRequest.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="bookRequest.checkindate" var="checkindate" />
			<display:column property="checkindate" title="\$\{checkindate\}" sortable="true" />
			<spring:message code="bookRequest.checkoutdate" var="checkoutdate" />
			<display:column property="checkoutdate" title="\$\{checkoutdate\}" sortable="true" />
			<spring:message code="bookRequest.smoker" var="smoker" />
			<display:column property="smoker" title="\$\{smoker\}" sortable="true" />
			<spring:message code="bookRequest.creditcard" var="creditcard" />
			<display:column property="creditcard" title="\$\{creditcard\}" sortable="true" />
			<spring:message code="bookRequest.status" var="status" />
			<display:column property="status" title="\$\{status\}" sortable="true" />
			<spring:message code="bookRequest.tenant" var="tenant" />
			<display:column property="tenant" title="\$\{tenant\}" sortable="true" />
			<spring:message code="bookRequest.property" var="property" />
			<display:column property="property" title="\$\{property\}" sortable="true" />

</display:table>