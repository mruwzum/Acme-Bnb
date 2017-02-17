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
			<a href="socialIdentity/create.do"> <spring:message
					code="socialIdentity.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="socialIdentitys" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="socialIdentity/edit.do?socialIdentityId=${row.id}> <spring:message
					code="socialIdentity.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="socialIdentity.nick" var="nick" />
			<display:column property="nick" title="\$\{nick\}" sortable="true" />
			<spring:message code="socialIdentity.socialnetwork" var="socialnetwork" />
			<display:column property="socialnetwork" title="\$\{socialnetwork\}" sortable="true" />
			<spring:message code="socialIdentity.url" var="url" />
			<display:column property="url" title="\$\{url\}" sortable="true" />

</display:table>