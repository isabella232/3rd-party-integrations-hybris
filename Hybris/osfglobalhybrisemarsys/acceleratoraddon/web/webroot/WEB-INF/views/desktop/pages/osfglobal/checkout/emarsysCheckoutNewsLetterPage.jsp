<%@ page trimDirectiveWhitespaces="true" %>
<div class="control-group">
	<div class="headline">Newsletter Subscription</div>
	<div class="control-group">
		<label class="control-label " for="email">
			Email<span class="mandatory">
				<img width="5" height="6" alt="Required" title="Required" src="${commonResourcePath}/images/mandatory.gif">
			</span>
			<span class="skip"></span>
		</label>

		<div class="controls">
			<input id="email" name="email" class="text" type="text" value="${userEmail}" style="width:250px"></div>

	</div>
	<div class="control-group">
		<div class="controls">
			<label class="control-label " for="subscribeForNewsletter">
				<input id="subscribeForNewsletter" name="subscribeForNewsletter" type="checkbox" value="true">
				<input type="hidden" name="_subscribeForNewsletter" value="on">Please add me to the newsletter list. We don't share or sell personal info.
				<span class="skip"></span>
			</label>
		</div>
	</div>
</div>