package com.osfglobal.hybris.emarsys.converters;


import com.osfglobal.emarsys.client.beans.EmarsysDynamicDTO;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysPredictSmartInsightResolver;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.site.BaseSiteService;
import org.springframework.beans.factory.annotation.Required;

/**
 * /**
 * Abstract converter {@link ItemModel} to {@link EmarsysDynamicDTO}.
 */
public abstract class AbstractEmarsysDynamicDtoPopulatingConverter<SOURCE, TARGET extends EmarsysDynamicDTO> extends AbstractPopulatingConverter<SOURCE, TARGET> {
    protected BaseSiteService baseSiteService;
    protected EmarsysPredictSmartInsightResolver emarsysPredictSmartInsightResolver;

    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    @Required
    public void setEmarsysPredictSmartInsightResolver(EmarsysPredictSmartInsightResolver emarsysPredictSmartInsightResolver) {
        this.emarsysPredictSmartInsightResolver = emarsysPredictSmartInsightResolver;
    }
}
