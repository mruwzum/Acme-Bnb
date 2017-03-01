<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>


<spring:message code="invoice.momment" var="momment"/>
<h3><jstl:out value="${momment}"/></h3>
<jstl:out value="${moment1}"/>

<spring:message code="invoice.property" var="property"/>
<h3><jstl:out value="${property}"/></h3>
<jstl:out value="${property1}"/>

<spring:message code="invoice.in" var="in"/>
<h3><jstl:out value="${in}"/></h3>
<jstl:out value="${in1}"/>

<spring:message code="invoice.out" var="out"/>
<h3><jstl:out value="${out}"/></h3>
<jstl:out value="${out1}"/>

<spring:message code="invoice.days" var="days"/>
<h3><jstl:out value="${days}"/></h3>
<jstl:out value="${days1}"/>

<spring:message code="invoice.tenant.name" var="name"/>
<h3><jstl:out value="${name}"/></h3>
<jstl:out value="${name1}}"/>

<spring:message code="invoice.tenant.surname" var="surname"/>
<h3><jstl:out value="${name}"/></h3>
<jstl:out value="${surname1}}"/>

<spring:message code="invoice.tenant.email" var="email"/>
<h3><jstl:out value="${name}"/></h3>
<jstl:out value="${email1}}"/>

<spring:message code="invoice.tenant.card" var="card"/>
<h3><jstl:out value="${card}"/></h3>
<jstl:out value="${card1}}"/>

<spring:message code="invoice.ammount" var="ammount"/>
<h3><jstl:out value="${ammount}"/></h3>
<jstl:out value="${ammount1}"/>