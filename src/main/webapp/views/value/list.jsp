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
            <a href="value/create.do"> <spring:message
                    code="value.create"/>
            </a>
        </H5>
    </div>
</security:authorize>


<security:authorize access="isAuthenticated()">

    <a href="value/create.do"> <spring:message
            code="value.create"/></a>

</security:authorize>
<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="values" requestURI="${requestURI}" id="row">


    <!-- Attributes -->

    <spring:message code="value.valueName" var="valueName"/>
    <display:column property="valueName" title="${valueName}" sortable="true"/>

    <security:authorize access="isAuthenticated()">
        <display:column>
            <a href="value/delete.do?valueId=${row.id}"> <spring:message
                    code="value.delete"/>
            </a>
        </display:column>
    </security:authorize>
</display:table>