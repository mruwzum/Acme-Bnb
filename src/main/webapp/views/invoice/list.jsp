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
			<a href="invoice/create.do"> <spring:message
					code="invoice.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="invoices" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="invoice/edit.do?invoiceId=${row.id}> <spring:message
					code="invoice.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="invoice.issuedmoment" var="issuedmoment" />
			<display:column property="issuedmoment" title="\$\{issuedmoment\}" sortable="true" />
			<spring:message code="invoice.vatnumber" var="vatnumber" />
			<display:column property="vatnumber" title="\$\{vatnumber\}" sortable="true" />
			<spring:message code="invoice.tenantinfo" var="tenantinfo" />
			<display:column property="tenantinfo" title="\$\{tenantinfo\}" sortable="true" />
			<spring:message code="invoice.details" var="details" />
			<display:column property="details" title="\$\{details\}" sortable="true" />
			<spring:message code="invoice.totalamount" var="totalamount" />
			<display:column property="totalamount" title="\$\{totalamount\}" sortable="true" />
			<spring:message code="invoice.creditcard" var="creditcard" />
			<display:column property="creditcard" title="\$\{creditcard\}" sortable="true" />
			<spring:message code="invoice.tenant" var="tenant" />
			<display:column property="tenant" title="\$\{tenant\}" sortable="true" />

</display:table>