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


<spring:message code="property.name" var="name1"/>
<h3><jstl:out value="${name1}"/></h3>
<jstl:out value="${name}"/>

<spring:message code="property.address" var="address1"/>
<h3><jstl:out value="${address1}"/></h3>
<jstl:out value="${address}"/>



<spring:message code="property.audit" var="audit"/>
<h3><jstl:out value="${audit}"/></h3>
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



<spring:message code="value.attributes" var="attribute"/>
<h3><jstl:out value="${attribute}"/></h3>
<security:authorize access="hasRole('LESSOR')">
    <a href="value/create.do?propertyId=${idp}"> <spring:message
            code="value.create"/>
    </a>
</security:authorize>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="values" requestURI="${requestURI}" id="row">


    <!-- Attributes -->
    <spring:message code="value.attributte" var="attribute"/>
    <display:column property="attribute" title="${attribute}" sortable="true"/>
    <spring:message code="value.valueName" var="valueName"/>
    <display:column property="valueName" title="${valueName}" sortable="true"/>

    <security:authorize access="hasRole('LESSOR')">
        <display:column>
            <a href="value/delete.do?valueId=${row.id}"> <spring:message
                    code="value.delete"/>
            </a>
        </display:column>
    </security:authorize>


</display:table>
