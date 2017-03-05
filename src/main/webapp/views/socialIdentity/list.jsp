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

<%--<security:authorize access="permitAll">--%>
	<%--<div>--%>
		<%--<H5>--%>
			<%--<a href="socialIdentity/create.do"> <spring:message--%>
					<%--code="socialIdentity.create" />--%>
			<%--</a>--%>
		<%--</H5>--%>
	<%--</div>--%>
<%--</security:authorize>--%>
<security:authorize access="isAuthenticated()">

		<a href="socialIdentity/create.do"> <spring:message
				code="socialIdentity.create" /></a>

</security:authorize>
<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="socialIdentitys" requestURI="${requestURI}" id="row">


	<!-- Attributes -->
	
			<spring:message code="socialIdentity.nick" var="nick" />
			<display:column property="nick" title="${nick}" sortable="true" />
			<spring:message code="socialIdentity.socialnetwork" var="socialNetwork" />
			<display:column property="socialNetwork" title="${socialNetwork}" sortable="true" />
			<spring:message code="socialIdentity.url" var="URL" />
			<display:column property="URL" title="${URL}" sortable="true" />
	<security:authorize access="isAuthenticated()">
		<display:column>
			<a href="socialIdentity/delete.do?socialIdentityId=${row.id}"> <spring:message
					code="socialIdentity.delete"/>
			</a>
		</display:column>
	</security:authorize>
</display:table>