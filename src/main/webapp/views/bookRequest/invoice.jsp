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
<jstl:out value="${issued}"/>

<spring:message code="invoice.tenant1" var="tenant1"/>
<h3><jstl:out value="${tenant1}"/></h3>
<jstl:out value="${tenant}"/>

<spring:message code="invoice.details1" var="details1"/>
<h3><jstl:out value="${details1}"/></h3>
<jstl:out value="${details}"/>


<spring:message code="invoice.tenant.card" var="card1"/>
<h3><jstl:out value="${card1}"/></h3>
<jstl:out value="${card}"/>

<spring:message code="invoice.VAT1" var="VAT1"/>
<h3><jstl:out value="${VAT1}"/></h3>
<jstl:out value="${VAT}"/>

<spring:message code="invoice.ammount" var="ammount"/>
<h3><jstl:out value="${ammount}"/></h3>
<jstl:out value="${total}"/>