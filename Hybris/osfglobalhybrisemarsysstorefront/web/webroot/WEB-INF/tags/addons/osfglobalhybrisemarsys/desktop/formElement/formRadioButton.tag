<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="idKey" required="true"  type="java.lang.String" %>
<%@ attribute name="labelKey" required="true"  type="java.lang.String" %>
<%@ attribute name="path" required="true"  type="java.lang.String" %>
<%@ attribute name="value" required="true"  type="java.lang.String" %>
<%@ attribute name="mandatory" required="false"  type="java.lang.Boolean" %>
<%@ attribute name="labelCSS" required="false"  type="java.lang.String" %>
<%@ attribute name="inputCSS" required="false" type="java.lang.String" %>
<%@ attribute name="errorPath" required="false" type="java.lang.String" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>

<label class="control-label ${labelCSS}" for="${idKey}">
	<spring:theme code="${labelKey}"/>
</label>
<form:radiobutton id="${idKey}" path="${path}" value="${value}" cssClass="${inputCSS}"/>