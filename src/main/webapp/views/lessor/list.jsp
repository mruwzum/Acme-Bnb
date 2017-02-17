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
			<a href="lessor/create.do"> <spring:message
					code="lessor.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="lessors" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="lessor/edit.do?lessorId=${row.id}> <spring:message
					code="lessor.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="lessor.creditcard" var="creditcard" />
			<display:column property="creditcard" title="\$\{creditcard\}" sortable="true" />
			<spring:message code="lessor.property" var="property" />
			<display:column property="property" title="\$\{property\}" sortable="true" />

</display:table>