//Recommendations and predict
(function() {
	var currentPage = window.location.href;
	//No need for Emarsys listener for checkout page except order confirmation
	
	var po = document.createElement('script');
	po.type = 'text/javascript';
	po.async = true;
	var s = document.getElementsByTagName('script')[0];
	var scriptUrl = ACC.config.encodedContextPath+ '/emarsyspredict/getemarsysscript.js';
	$.get(scriptUrl, function( data ) {
		po.innerHTML = data;
		});
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(po, s);
})();

//Subscriptions and  forms 
ACC.emarsys = {

		getNewsLetterForm : function() {
			$.ajax({
				url : ACC.config.encodedContextPath
						+ "/emarsysforms/getnewlettersform",
				type : 'GET',
				cache : false,
				success : function(html) {
					if ($(html) != []) {
						$(html).appendTo('#newsletterfrorm');

					}
				}
			});
		},

		getNewsLetterOptin: function() {
			$.ajax({
				url : ACC.config.encodedContextPath
						+ "/emarsysforms/getnewlettersoptin",
				type : 'GET',
				cache : false,
				success : function(html) {
					if ($(html) != []) {
						$(html).appendTo('#registerForm');
					}
				}
			});
		},
		
		bindSumbitSopForm: function ()
		{
			$('#silentOrderPostForm').submit(function (event)
			{
				var email = $('#email').val();
				if(email==null ||  !validateEmail(email))
					{
					   $('.blockMsg ').css('display','none');
					   $('#silentOrderPostForm').css('position','');
					   $('#email').closest('.control-group').addClass('error');
					    event.preventDefault(); 
					    return false;
					}
			})
		},
		bindClickSopForm: function ()
		{
			$('.submit_silentOrderPostForm').on('click',function (event)
			{
				var email = $('#email').val();
				if(email==null ||  !validateEmail(email))
					{
					   $('.blockOverlay').css('display','none');
					   $('.blockMsg ').css('display','none');
					   $('#silentOrderPostForm').css('position','');
					   $('#email').closest('.control-group').addClass('error');
					    event.preventDefault(); 
					    return false;
					}
			})
		}, 
		bindClickDefaultPaymentForm: function ()
		{
			$('#lastInTheForm').click(function (event)
			{
				var email = $('#email').val();
				if(email==null ||  !validateEmail(email))
					{
					   $('#email').closest('.control-group').addClass('error');
					    event.preventDefault(); 
					    return false;
					}
			})
		},
	getCheckoutSilentNewsLetterForm: function () {
		processCheckoutNewsLetterForm(function (html) {
			if ($(html) != []) {
				$(html).appendTo('#silentOrderPostForm .form-additionals:last');
			}
			if ($('#savedPaymentListHolder .paymentList .paymentEntry form').html() != null) {
				$('<input>').attr({
					type: 'hidden',
					class: 'customerEmail',
					name: 'customerEmail',
					value: $("#email").val()
				}).appendTo('#savedPaymentListHolder .paymentList .paymentEntry form').not('#command');
				$('<input>').attr({
					type: 'hidden',
					class: 'forceOptIn',
					name: 'forceOptIn',
					value: $('#subscribeForNewsletter').is(':checked')
				}).appendTo('#savedPaymentListHolder .paymentList .paymentEntry form').not('#command');
				$('#email').on('change', function () {
					$('.customerEmail').val($(this).val());
				});
				$('#subscribeForNewsletter').on('change', function () {
					$('.forceOptIn').val($(this).is(':checked'));
				});
			}
		});
	},
	getCheckoutDefaultNewsLetterForm: function() {
		processCheckoutNewsLetterForm(function (html) {
			if ($(html) != []) {
				$(html).wrap("<div class='form-additionals'></div>").parent().insertBefore('#checkoutContentPanel .form-actions');
			}
		});
	},
		getAccountSubscriptionControlPage: function () {
			$.ajax({
				url : ACC.config.encodedContextPath
				+ "/emarsysforms/getaccountsubscriptioncontrolpage",
				type : 'GET',
				cache : false,
				success : function(html) {
					if ($(html) != []) {
						$('a.button').last().after($(html));
					}
				}
			});
		}
}
	
	function processCheckoutNewsLetterForm(callback) {
		$.ajax({
			url : ACC.config.encodedContextPath + "/emarsysforms/getcheckoutnewsletterform",
			type : 'GET',
			cache : false,
			success : function (html) {
				callback(html);
			}
		});
	}
	function submitOrOpenSubscribePage() {
		if (document.getElementById("emailSignUp").value == "") {
			window.location.href = ACC.config.encodedContextPath + "/emailsignup";
			return false;
		} else {
			return true;
		}
	}
	
	
	function validateEmail(email) {
		var pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"; 
	    return email.match(pattern);
	}
	$(document).ready(
			function() {
				// Footer form
				ACC.emarsys.getNewsLetterForm();
	            ACC.emarsys.bindClickSopForm();
				ACC.emarsys.bindSumbitSopForm();
				ACC.emarsys.bindClickDefaultPaymentForm();
				// Register Optin
				if ($('#registerForm').html() != null
						|| $('#updateEmailForm').html() != null) {
					ACC.emarsys.getNewsLetterOptin();
				}
				
				// my account subscription control
				if(window.location.href.indexOf("/my-account/profile") > -1){
					ACC.emarsys.getAccountSubscriptionControlPage();
				}

				// Silent Checkout  newsletter subscription
				if ($('#silentOrderPostForm').html() != null){
					ACC.emarsys.getCheckoutSilentNewsLetterForm();
				}
				// Default Checkout newsletter subscription
				if ($('#newBillingAddressFields').html() != null){
					ACC.emarsys.getCheckoutDefaultNewsLetterForm();
				}

			});


