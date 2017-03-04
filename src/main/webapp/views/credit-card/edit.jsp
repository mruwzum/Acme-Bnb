<%--
  Created by IntelliJ IDEA.
  User: mruwzum
  Date: 22/11/16
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>


<form:form action="creditcard/save.do" modelAttribute="creditCard">

    <form:hidden path="id"/>
    <form:hidden path="version"/>

    <acme:textbox path="holderName" code="credit-card.holderName"/>
    <br />
    <acme:textbox path="brandName" code="credit-card.brandName"/>
    <br />
    <acme:textbox path="number" code="credit-card.number"/>
    <br />
    <acme:textbox path="expirationYear" code="credit-card.expirationYear"/>
    <br />
    <acme:textbox path="expirationMonth" code="credit-card.expirationMonth"/>
    <br />
    <acme:textbox path="CVV" code="credit-card.CVV"/>
    <br />



    <input type="submit" name="save"
           value="<spring:message code="credit-card.save" />"/>&nbsp;

</form:form>