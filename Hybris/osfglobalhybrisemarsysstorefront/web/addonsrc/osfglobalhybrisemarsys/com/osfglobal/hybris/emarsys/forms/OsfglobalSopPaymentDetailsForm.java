package com.osfglobal.hybris.emarsys.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.SopPaymentDetailsForm;

public class OsfglobalSopPaymentDetailsForm extends SopPaymentDetailsForm {
    private String email;
    private Boolean subscribeForNewsletter;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSubscribeForNewsletter() {
        return subscribeForNewsletter;
    }

    public void setSubscribeForNewsletter(Boolean subscribeForNewsletter) {
        this.subscribeForNewsletter = subscribeForNewsletter;
    }
}
