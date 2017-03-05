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
			<a href="comment/create.do"> <spring:message
					code="comment.create" />
			</a>
		</H5>
	</div>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="comments" requestURI="${requestURI}" id="row">


	<!-- Attributes -->

	<security:authorize access="permitAll">
		<display:column>
			<a href="comment/edit.do?commentId=${row.id}"> <spring:message
					code="comment.edit" />
			</a>
		</display:column>
	</security:authorize>
	
			<spring:message code="comment.title" var="title" />
			<display:column property="title" title="${title}" sortable="true" />
	<spring:message code="comment.postedMoment" var="postedNoment"/>
	<display:column property="postedMoment" title="${postedNoment}" sortable="true"/>
			<spring:message code="comment.text" var="text" />
			<display:column property="text" title="${text}" sortable="true" />
			<spring:message code="comment.numberofstars" var="numberOfStars" />
			<display:column property="numberOfStars" title="${numberOfStars}" sortable="true" />

</display:table>