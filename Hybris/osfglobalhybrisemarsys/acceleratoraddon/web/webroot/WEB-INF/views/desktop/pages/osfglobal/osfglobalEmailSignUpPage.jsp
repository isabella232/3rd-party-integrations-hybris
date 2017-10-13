<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/desktop/cart" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/desktop/formElement" %>
<%@ taglib prefix="addonFormElement" tagdir="/WEB-INF/tags/addons/osfglobalhybrisemarsys/desktop/formElement" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page pageTitle="${pageTitle}">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>
	
	
	<form:form action="${request.contextPath}/${action}" method="post" commandName="emailSignUpForm">
		<div class="span-12"> <!-- wrapper -->
		<div class="form_field-elements">
			<div class="gender-radio-label">Gender
				<span class="mandatory">
						<img width="5" height="6" src="${commonResourcePath}/images/mandatory.gif">
				</span>
			</div>
			<fieldset>
				<div class="gender-radio">
					<addonFormElement:formRadioButton idKey="gender" labelKey="Male" value="true" path="gender"/>
					<addonFormElement:formRadioButton idKey="gender" labelKey="Female" value="false" path="gender"/>
				</div>
			</fieldset>
			<formElement:formInputBox idKey="firstName" labelKey="First Name" path="firstName" inputCSS="text" mandatory="true"/>
			<formElement:formInputBox idKey="lastName" labelKey="Last Name" path="lastName" inputCSS="text" mandatory="true"/>
			<formElement:formInputBox idKey="email" labelKey="E-Mail Address" path="email" inputCSS="text" mandatory="true"/>
		</div>
		
		<div class="form-actions clearfix">
			<button type="submit" class="positive">Sign Me Up for Email</button>
		</div>

		</div><!-- end of wrapper -->
	</form:form>
	
	
	<cms:pageSlot position="MiddleContent" var="comp" element="div" class="span-20">
		<cms:component component="${comp}"/>
	</cms:pageSlot>
	<cms:pageSlot position="BottomContent" var="comp" element="div" class="span-20 cms_disp-img_slot last">
		<cms:component component="${comp}"/>
	</cms:pageSlot>
	<cms:pageSlot position="SideContent" var="feature" element="div" class="span-4 narrow-content-slot cms_disp-img_slot">
		<cms:component component="${feature}"/>
	</cms:pageSlot>
</template:page>