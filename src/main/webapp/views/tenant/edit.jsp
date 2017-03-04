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

<form:form action="tenant/change.do" modelAttribute="tenant">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="invoices"/>
	<form:hidden path="finders"/>
	<form:hidden path="bookRequests"/>
    <form:hidden path="userAccount"/>

	<acme:textbox path="name" code="actor.name"/>
	<br />
	<acme:textbox path="surname" code="actor.surname"/>
	<br />
	<acme:textbox path="email" code="actor.email"/>
	<br />
	<acme:textbox path="phone" code="actor.phone"/>
	<br />
	<acme:textbox path="picture" code="actor.picture"/>
	<br />

	<h3><spring:message code="edit.creditcard" var="cc"/>
		<jstl:out value="${cc}"/>
	</h3>
	<acme:textbox path="creditCard.holderName" code="credit-card.holderName"/>
	<br />
	<acme:textbox path="creditCard.brandName" code="credit-card.brandName"/>
	<br />
	<acme:textbox path="creditCard.number" code="credit-card.number"/>
	<br />
	<acme:textbox path="creditCard.expirationYear" code="credit-card.expirationYear"/>
	<br />
	<acme:textbox path="creditCard.expirationMonth" code="credit-card.expirationMonth"/>
	<br />
	<acme:textbox path="creditCard.CVV" code="credit-card.CVV"/>
	<br />


	<!---------------------------- BOTONES -------------------------->
	<acme:submit name="save" code="tenant.save"/>


	<jstl:if test="\$\{tenant.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="tenant.delete" />"
			onclick="return confirm('<spring:message code="tenant.confirm.delete" />')" />&nbsp;
	</jstl:if>

	<input type="button" name="cancel"
		value="<spring:message code="tenant.cancel" />"
		onclick="javascript: window.location.replace('tenant/list.do')" />

</form:form>