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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page pageTitle="${pageTitle}">
    <div id="globalMessages">
        <common:globalMessages/>
    </div>

    <h1>Subscribe error</h1>
    <p>Newsletter subscribe error, subscription token is not found in the database</p>

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