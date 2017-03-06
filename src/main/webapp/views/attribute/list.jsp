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

<security:authorize access="permitAll">
    <div>
        <H5>
            <a href="attribute/create.do"> <spring:message
                    code="attribute.create"/>
            </a>
        </H5>
    </div>
</security:authorize>
<security:authorize access="isAuthenticated()">

    <a href="attribute/create.do"> <spring:message
            code="attribute.create"/></a>

</security:authorize>
<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="attributes" requestURI="${requestURI}" id="row">


    <!-- Attributes -->

    <spring:message code="attribute.attributeName" var="attributeName"/>
    <display:column property="attributeName" title="${attributeName}" sortable="true"/>
    <spring:message code="attribute.value" var="value"/>
    <display:column property="value" title="${value}" sortable="true"/>


    <security:authorize access="isAuthenticated()">
        <display:column>
            <a href="attribute/delete.do?attributeId=${row.id}"> <spring:message
                    code="attribute.delete"/>
            </a>
        </display:column>
    </security:authorize>
</display:table>