//Recommendations and predict
(function() {
	var currentPage = window.location.href;
	//No need for Emarsys listener for checkout page except order confirmation
	if (currentPage.indexOf("checkout")!=-1 && currentPage.indexOf("orderConfirmation")==-1) {
		return;
	}
	var po = document.createElement('script');
	po.type = 'text/javascript';
	po.async = true;
	po.src = ACCMOB.config.encodedContextPath
			+ '/emarsyspredict/getemarsysscript.js';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(po, s);
})();

//Subscriptions and   forms 
ACCMOB.emarsys = {

		getNewsLetterForm : function() {
			$.ajax({
				url : ACCMOB.config.encodedContextPath
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
				url : ACCMOB.config.encodedContextPath
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
		getCheckoutNewsLetterForm: function () {
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
                url : ACCMOB.config.encodedContextPath
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
			url : ACCMOB.config.encodedContextPath + "/emarsysforms/getcheckoutnewsletterform",
			type : 'GET',
			cache : false,
			success : function (html) {
				callback(html);	
			} 
		});
	}

	function submitOrOpenSubscribePage() {
		if (document.getElementById("emailSignUp").value == "") {
			window.location.href = ACCMOB.config.encodedContextPath + "/emailsignup";
			return false;
		} else {
			return true;
		}
	}
	$(document).ready(
			function() {
				// Footer form
				ACCMOB.emarsys.getNewsLetterForm();

				// Register Optin
				if ($('#registerForm').html() != null
						|| $('#updateEmailForm').html() != null) {
					ACCMOB.emarsys.getNewsLetterOptin();
				}
				//my account subscription control
				if(window.location.href.indexOf("/my-account/profile") > -1){
					ACCMOB.emarsys.getAccountSubscriptionControlPage();
				}

				// Checkout newsletter subscription
				if ($('#silentOrderPostForm').html() != null){
					ACCMOB.emarsys.getCheckoutNewsLetterForm();
				}
				// Default Checkout newsletter subscription
				if ($('#newBillingAddressFields').html() != null){
					ACCMOB.emarsys.getCheckoutDefaultNewsLetterForm();
				}

			});


