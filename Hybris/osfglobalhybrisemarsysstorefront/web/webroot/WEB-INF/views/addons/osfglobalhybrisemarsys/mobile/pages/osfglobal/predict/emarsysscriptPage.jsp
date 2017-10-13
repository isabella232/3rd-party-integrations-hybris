<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>


var ScarabQueue = ScarabQueue || [];

(function(id) {
  if (document.getElementById(id)) return;
  var js = document.createElement('script'); js.id = id;
  js.src = '//cdn.scarabresearch.com/js/'+ '${predictWidgetData.merchantId}' + '/scarab-v2.js';
  var fs = document.getElementsByTagName('script')[0];
  fs.parentNode.insertBefore(js, fs);
})('scarab-js-api');

<!-- Cart and email collection (Mandatory for all pages) -->
<c:if test="${not ('anonymous' eq predictWidgetData.email)}">
  ScarabQueue.push(['setEmail', '${predictWidgetData.email}']);
</c:if>

<!-- Language && currency -->
ScarabQueue.push(['language', '${currentLanguage.isocode}']);
<!-- Currency is Managed in Template -->

<!-- Cart -->
ScarabQueue.push(['cart', [
<c:forEach items="${predictWidgetData.cart.entries}" var="cartEntry" varStatus="status">
    {item: '${cartEntry.product.code}', price: ${cartEntry.roundedBasePrice}, quantity: ${cartEntry.quantity}}
    <c:if test="${!status.last}">,</c:if> 
 </c:forEach>
]]); 

<c:if test="${not empty predictWidgetData.command}">

   <!-- if we are not in cart already  -->
   <c:if test="${not ('cart' eq predictWidgetData.command.name)}">
	  ScarabQueue.push(['${predictWidgetData.command.name}', ${predictWidgetData.command.paramString}]);
	</c:if>
	<c:if test="${not empty predictWidgetData.command.availabilityZone}">
	  ScarabQueue.push(['availabilityZone', '${predictWidgetData.command.availabilityZone}']);
	</c:if>
	
	console.log('${predictWidgetData.command.logic}');
	<!-- REcommendations -->
	<c:if test="${not ('DISABLED' eq predictWidgetData.command.logic)}">
	
	if( $('#${predictWidgetData.command.containerId}').length )        
    {
		ScarabQueue.push(['recommend', {
		    logic: '${predictWidgetData.command.logic}',
		    containerId: '${predictWidgetData.command.containerId}'
		    <c:if test="${not empty predictWidgetData.command.template}">
		    ,
		    templateId : '${not empty predictWidgetData.command.template}',
		    </c:if>
		  
		}]);
	}
	</c:if>
</c:if>

ScarabQueue.push(['go']);