<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<form:form action="comment/edit.do" modelAttribute="comment">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<acme:textbox path="title" code="comment.title"/>
	<br />
	<acme:textbox path="postedMoment" code="comment.checkindate"/>
	<br />
	<acme:textbox path="text" code="comment.checkindate"/>
	<br />
	<acme:textbox path="numberOfStars" code="comment.numberofstars"/>
	<br />
	

	<!---------------------------- BOTONES -------------------------->
<acme:submit name="save" code="comment.save"/>




	<jstl:if test="\$\{comment.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="comment.delete" />"
			onclick="return confirm('<spring:message code="comment.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<acme:submit code="comment.cancel" name="cancel"/>


	<%--<input type="button" name="cancel"--%>
		<%--value="<spring:message code="comment.cancel" />"--%>
		<%--onclick="javascript: window.location.replace('comment/list.do')" />--%>

</form:form>