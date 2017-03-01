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


<spring:message code="property.name" var="name"/>
<h3><jstl:out value="${name}"/></h3>
<jstl:out value="${name}"/>

<spring:message code="property.address" var="address"/>
<h3><jstl:out value="${address}"/></h3>
<jstl:out value="${address}"/>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="audits" requestURI="${requestURI}" id="row">

    <!-- Attributes -->


    <spring:message code="audit.writtenMoment" var="writtenMoment"/>
    <display:column property="writtenMoment" title="writtenMoment" sortable="true"/>
    <spring:message code="audit.text" var="text"/>
    <display:column property="text" title="text" sortable="true"/>
    <spring:message code="audit.auditor" var="auditor"/>
    <display:column property="auditor" title="auditor" sortable="true"/>

</display:table>
