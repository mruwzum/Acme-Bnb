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
			<a href="audit/create.do"> <spring:message
					code="audit.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="audits" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="audit/edit.do?auditId=${row.id}"> <spring:message
					code="audit.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="audit.writtenmoment" var="writtenMoment" />
			<display:column property="writtenMoment" title="${writtenMoment}" sortable="true" />
			<spring:message code="audit.text" var="text" />
			<display:column property="text" title="${text}" sortable="true" />
			<spring:message code="audit.attachments" var="attachments" />
			<display:column property="attachments" title="${attachments}" sortable="true" />
			<spring:message code="audit.property" var="property" />
			<display:column property="property" title="${property}" sortable="true" />
			<spring:message code="audit.auditor" var="auditor" />
			<display:column property="auditor" title="${auditor}" sortable="true" />
			<spring:message code="audit.comment" var="comments" />
			<display:column property="comments" title="${comments}" sortable="true" />

</display:table>