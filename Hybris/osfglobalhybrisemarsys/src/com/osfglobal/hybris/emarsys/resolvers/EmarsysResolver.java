package com.osfglobal.hybris.emarsys.resolvers;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;

import java.util.Map;

/**
 * Emarsys model resolver
 */
public interface EmarsysResolver<T> {
    String resolve(T model, EmarsysPredictAvailabilityZoneModel availabilityZone);
    String resolve(T model);
    Map<String, EmarsysResolver<T>> getResolvers();
}
