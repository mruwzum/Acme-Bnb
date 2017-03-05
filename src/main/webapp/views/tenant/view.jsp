<%--
  Created by IntelliJ IDEA.
  User: mruwzum
  Date: 1/3/17
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
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



<spring:message code="actor.name" var="name1"/>
<h3><jstl:out value="${name1}"/></h3>
<jstl:out value="${name}"/>


<spring:message code="actor.surname" var="surname1"/>
<h3><jstl:out value="${surname1}"/></h3>
<jstl:out value="${surname}"/>


<spring:message code="actor.email" var="email1"/>
<h3><jstl:out value="${email1}"/></h3>
<jstl:out value="${email}"/>


<spring:message code="actor.phone" var="phone1"/>
<h3><jstl:out value="${phone1}"/></h3>
<jstl:out value="${phone}"/>


<spring:message code="actor.picture" var="picture1"/>
<h3><jstl:out value="${picture1}"/></h3>
<jstl:out value="${picture}"/>

<!-- Listing grid -->
<display:table pagesize="5" class="displaytag" keepStatus="true"
               name="socialIdentitys" requestURI="${requestURI}" id="row">


    <!-- Attributes -->


    <spring:message code="socialIdentity.nick" var="nick" />
    <display:column property="nick" title="${nick}" sortable="true" />
    <spring:message code="socialIdentity.socialnetwork" var="socialNetwork" />
    <display:column property="socialNetwork" title="${socialNetwork}" sortable="true" />
    <spring:message code="socialIdentity.url" var="URL" />
    <display:column property="URL" title="${URL}" sortable="true" />

</display:table>

