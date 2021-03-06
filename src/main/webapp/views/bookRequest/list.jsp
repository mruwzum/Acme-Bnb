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

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="bookRequests" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="bookRequest/edit.do?bookRequestId=${row.id}"> <spring:message
					code="bookRequest.edit" />
			</a>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('LESSOR')">
		<display:column>
			<jstl:if test="${mis}">
				<a href="tenant/view.do?bookRequestId=${row.id}"> <spring:message
						code="bookRequest.view.tenant"/>
				</a>
			</jstl:if>
		</display:column>
	</security:authorize>
	
			<spring:message code="bookRequest.checkindate" var="checkInDate" />
			<display:column property="checkInDate" title="${checkInDate}" sortable="true" />
			<spring:message code="bookRequest.checkoutdate" var="checkOutDate" />
			<display:column property="checkOutDate" title="${checkOutDate}" sortable="true" />
			<spring:message code="bookRequest.smoker" var="smoker" />
			<display:column property="smoker" title="${smoker}" sortable="true" />
			<%--<spring:message code="bookRequest.creditcard" var="creditCard" />--%>
			<%--<display:column property="creditCard" title="${creditCard}" sortable="true" />--%>
			<spring:message code="bookRequest.status" var="status" />
			<display:column property="status" title="${status}" sortable="true" />
			<spring:message code="bookRequest.tenant" var="tenant" />
			<display:column property="tenant" title="${tenant}" sortable="true" />
			<spring:message code="bookRequest.property" var="property" />
			<display:column property="property" title="${property}" sortable="true" />


	<security:authorize access="permitAll">
		<display:column>
			<a href="tenant/invoice.do?bookRequestId=${row.id}"> <spring:message
					code="bookRequest.invoice"/>
			</a>
		</display:column>
	</security:authorize>

	<%--TODO estas dos de abajo solo las puede hacer el propietario--%>


</display:table>


<spring:message code="bookRequest.pending" var="pend"/>
<h1><jstl:out value="${pend}"/></h1>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
			   name="bookRequestsP" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="hasRole('TENANT')">
		<display:column>
			<a href="bookRequest/edit.do?bookRequestId=${row.id}"> <spring:message
					code="bookRequest.edit"/>
			</a>
		</display:column>
	</security:authorize>


	<spring:message code="bookRequest.checkindate" var="checkInDate"/>
	<display:column property="checkInDate" title="${checkInDate}" sortable="true"/>
	<spring:message code="bookRequest.checkoutdate" var="checkOutDate"/>
	<display:column property="checkOutDate" title="${checkOutDate}" sortable="true"/>
	<spring:message code="bookRequest.smoker" var="smoker"/>
	<display:column property="smoker" title="${smoker}" sortable="true"/>
	<%--<spring:message code="bookRequest.creditcard" var="creditCard" />--%>
	<%--<display:column property="creditCard" title="${creditCard}" sortable="true" />--%>
	<spring:message code="bookRequest.status" var="status"/>
	<display:column property="status" title="${status}" sortable="true"/>
	<spring:message code="bookRequest.tenant" var="tenant"/>
	<display:column property="tenant" title="${tenant}" sortable="true"/>
	<spring:message code="bookRequest.property" var="property"/>
	<display:column property="property" title="${property}" sortable="true"/>


	<security:authorize access="hasRole('LESSOR')">
		<display:column>
			<a href="lessor/accept.do?bookRequestId=${row.id}"> <spring:message
					code="bookRequest.accept"/>
			</a>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('LESSOR')">
		<display:column>
			<a href="lessor/deny.do?bookRequestId=${row.id}"> <spring:message
					code="bookRequest.deny"/>
			</a>
		</display:column>
	</security:authorize>
</display:table>
