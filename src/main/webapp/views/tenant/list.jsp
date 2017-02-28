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
			<a href="tenant/create.do"> <spring:message
					code="tenant.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="tenants" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="tenant/edit.do?tenantId=${row.id}"> <spring:message
					code="tenant.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="tenant.bookrequest" var="bookrequest" />
			<display:column property="bookrequest" title="\$\{bookrequest\}" sortable="true" />
			<spring:message code="tenant.invoice" var="invoice" />
			<display:column property="invoice" title="\$\{invoice\}" sortable="true" />
			<spring:message code="tenant.finder" var="finder" />
			<display:column property="finder" title="\$\{finder\}" sortable="true" />

</display:table>