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
			<a href="auditor/create.do"> <spring:message
					code="auditor.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="auditors" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="auditor/edit.do?auditorId=${row.id}> <spring:message
					code="auditor.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="auditor.nameofcompany" var="nameofcompany" />
			<display:column property="nameofcompany" title="\$\{nameofcompany\}" sortable="true" />
			<spring:message code="auditor.audit" var="audit" />
			<display:column property="audit" title="\$\{audit\}" sortable="true" />

</display:table>