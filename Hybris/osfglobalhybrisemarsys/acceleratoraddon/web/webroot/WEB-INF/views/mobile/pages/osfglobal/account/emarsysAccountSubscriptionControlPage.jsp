<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${isSubscribedUser}">
        <a class="button" href="<c:url value="/emailsignup/unsubscribe-profile"/>"><spring:theme code="text.account.profile.unsubscribeFromNL" text="Unsubscribe from newsletters"/></a>
    </c:when>
    <c:otherwise>
        <a class="button" href="<c:url value="/emailsignup/subscribe-profile"/>"><spring:theme code="text.account.profile.subscribeForNL" text="Subscribe for newsletters"/></a>
    </c:otherwise>
</c:choose>