<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

     <form:form id="emailSignUpForm" method="post" action="${request.contextPath}/emailsignup/quicksubscribe">
        <label class="control-label text" for="emailSignUp">Subscribe to our Newsletter</>
        <input type="email" id="emailSignUp" name="email" placeholder="your@email.com">
        
        <div class="form-actions clearfix">
            <button type="submit" class="positive" onClick="return submitOrOpenSubscribePage()">Subscribe</button>
        </div>
    </form:form>