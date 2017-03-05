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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="bookRequest/edit.do" modelAttribute="bookRequest">

	<form:hidden path="id" />
	<form:hidden path="version" />
    <form:hidden path="tenant" />
    <form:hidden path="property"/>
    <form:hidden path="status"/>
	<form:hidden path="creditCard"/>


	<acme:textbox path="checkInDate" code="bookRequest.checkindate"/>
			<br />
		<acme:textbox path="checkOutDate" code="bookRequest.checkoutdate"/>
			<br />
        <spring:message code="bookRequest.smoker" var="smoker"/>
        <jstl:out value="${smoker}"/>
		<form:checkbox path="smoker" code="bookRequest.smoker"/>
			<br />



	<!---------------------------- BOTONES -------------------------->


   <%-- <input type="submit" name="save"
           value="<spring:message code="bookRequest.saave"/>" />--%>



    <input type="submit" name="save"
           value="<spring:message code="tenant.save" />" />

    <jstl:if test="\$\{bookRequest.id != 0}">
        <input type="submit" name="delete"
               value="<spring:message code="bookRequest.delete"/>"
               onclick="return confirm('<spring:message code="bookRequest.confirm.delete" />')" />&nbsp;
    </jstl:if>

    <input type="button" name="cancel"
           value="<spring:message code="tenant.cancel" />"
           onclick="javascript: window.location.replace('bookRequest/list.do')" />


    <%--	<acme:cancel code="bookRequest.cancel" url="bookRequest/list.do"/>--%>

</form:form>