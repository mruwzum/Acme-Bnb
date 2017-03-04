<%--
 * header.jsp
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<img src="images/logo.png" alt="AcmeBnb Co., Inc." />
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMINISTRATOR')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/changeFee.do"><spring:message code="master.page.administrator.change.fee" /></a></li>
				</ul>
			</li>
			<li><a class="fNiv"><spring:message code="master.page.lessor.registration"/></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="auditor/create.do"><spring:message
							code="master.page.auditor.register"/></a></li>
				</ul>
			</li>


		</security:authorize>


		<security:authorize access="hasRole('LESSOR')">
			<li><a class="fNiv"><spring:message code="master.page.lessor.properties"/></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="lessor/property/list.do"><spring:message
							code="master.page.lessor.properties.list"/></a></li>
					<li><a href="lessor/request/list.do"><spring:message
							code="master.page.lessor.request.list"/></a></li>
				</ul>
			</li>
			<li><a href="lessor/fee.do"><spring:message
					code="master.page.lessor.fee"/></a></li>
            <li><a href="lessor/edit1.do"><spring:message
                    code="master.page.modify"/></a></li>

		</security:authorize>
		<security:authorize access="hasRole('TENANT')">
			<li><a class="fNiv"><spring:message code="master.page.tenant.properties"/></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="finder/create.do"><spring:message
							code="master.page.tenant.request.finder"/></a></li>
				</ul>
			</li>
            <li><a href="bookRequest/listMy.do"><spring:message
                    code="master.page.tenant.bookRequests.list"/></a></li>
            <li><a href="tenant/edit1.do"><spring:message
                    code="master.page.modify"/></a></li>
		</security:authorize>

		<security:authorize access="hasRole('AUDITOR')">

            <li><a href="auditor/edit1.do"><spring:message
                    code="master.page.modify"/></a></li>
			<li><a href="auditor/listMy.do"><spring:message
					code="master.page.auditor.audits"/></a></li>

		</security:authorize>
		<security:authorize access="isAnonymous()">

			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>

			<li><a class="fNiv"><spring:message code="master.page.lessor.registration"/></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="tenant/create.do"><spring:message
							code="master.page.tenant.register"/></a></li>
					<li><a href="lessor/create.do"><spring:message
							code="master.page.lessor.register"/></a></li>
				</ul>
			</li>



			<li><a href="property/list.do"><spring:message
					code="master.page.property.list"/></a></li>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
            <li><a href="property/list.do"><spring:message
                    code="master.page.tenant.property.list"/></a></li>
			<li><a href="socialIdentity/list.do"><spring:message
					code="master.page.actor.socialIdentity.list"/></a></li>

		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

