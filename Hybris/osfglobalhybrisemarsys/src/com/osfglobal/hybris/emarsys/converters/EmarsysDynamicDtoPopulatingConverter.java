package com.osfglobal.hybris.emarsys.converters;


import com.osfglobal.emarsys.client.beans.EmarsysDynamicDTO;
import com.osfglobal.hybris.emarsys.converters.mappings.EmarsysMappingsConverter;
import de.hybris.platform.core.model.ItemModel;
import org.springframework.beans.factory.annotation.Required;

/**
 * /**
 * Converts {@link ItemModel} to {@link EmarsysDynamicDTO}.
 */
public class EmarsysDynamicDtoPopulatingConverter<SOURCE, TARGET extends EmarsysDynamicDTO> extends AbstractEmarsysDynamicDtoPopulatingConverter<SOURCE, TARGET> {
    private EmarsysMappingsConverter emarsysMappingsConverter;

    @Override
    public void populate(SOURCE source, TARGET target) {
        emarsysMappingsConverter
                .convert(baseSiteService.getCurrentBaseSite())
                .entries()
                .forEach((entry) ->
                        target.put(entry.getValue(), emarsysPredictSmartInsightResolver.resolve(entry.getKey(),entry.getValue(), source)));
        super.populate(source, target);
    }


    @Required
    public void setEmarsysMappingsConverter(EmarsysMappingsConverter emarsysMappingsConverter) {
        this.emarsysMappingsConverter = emarsysMappingsConverter;
    }

}
