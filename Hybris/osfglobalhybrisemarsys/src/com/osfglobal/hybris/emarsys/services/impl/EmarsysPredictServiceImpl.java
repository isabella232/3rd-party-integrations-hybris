package com.osfglobal.hybris.emarsys.services.impl;


import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.enums.EmarsysPredictExportTypeEnum;
import com.osfglobal.hybris.emarsys.services.EmarsysBaseService;
import com.osfglobal.hybris.emarsys.services.EmarsysPredictService;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.session.Session;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Emarsys Predict service class
 */
public class EmarsysPredictServiceImpl extends EmarsysBaseService implements EmarsysPredictService {
	private static final String QUERY = "SELECT {" + EmarsysPredictAvailabilityZoneModel.PK + "} FROM {"
			+ EmarsysPredictAvailabilityZoneModel._TYPECODE + "} where {currency}=?currency and {language}=?language";
	private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysPredictServiceImpl.class);
    private UserService userService;
    private CatalogVersionService catalogVersionService;
    private SessionService sessionService;
	private CartService cartService;

    /**
     * Return only online products
     * @param exportType
     * @return
     */
    @Override
    public List<ProductModel> getAllProductsOnline(EmarsysPredictExportTypeEnum exportType) {

        createLocalSessionContext();
        catalogVersionService.setSessionCatalogVersions(getActiveCatalogsVersions());
        userService.setCurrentUser(userService.getAnonymousUser());

        LOGGER.debug("export type: {}", exportType);
        String from = ProductModel._TYPECODE;
        if(exportType == EmarsysPredictExportTypeEnum.MAIN){
            from += "!";//select products without variations
        }
        FlexibleSearchQuery searchQuery
                = new FlexibleSearchQuery("SELECT {" + ProductModel.PK + "} FROM {" + from + " AS p}");

        List<ProductModel> result = flexibleSearchService.<ProductModel>search(searchQuery).getResult();
        removeLocalSessionContext();
        LOGGER.debug("getAllProductsOnline() query: {}", searchQuery.getQuery());
        return result;
    }

    protected List<CatalogVersionModel> getActiveCatalogsVersions() {
        return baseSiteService
                .getProductCatalogs(baseSiteService.getCurrentBaseSite())
                .stream()
                .map(CatalogModel::getActiveCatalogVersion)
                .collect(Collectors.toList());
    }
	@Override
	public String getEmailForPredictWidget()
	{
		CartModel cartModel = cartService.getSessionCart();
		String userUid = cartModel.getUser().getUid();
		if (isGuestUserCart(cartModel))
		{
			return StringUtils.substringAfter(userUid, "|");
		}
		return userUid;
	}
	protected boolean isGuestUserCart(final CartModel cartModel)
	{
		final ItemModel customer = cartModel.getUser();
		return customer instanceof CustomerModel && CustomerType.GUEST.equals(((CustomerModel) customer).getType());
	}
    protected void createLocalSessionContext(){
        final Session session = sessionService.getCurrentSession();
        final JaloSession jaloSession = (JaloSession) this.sessionService.getRawSession(session);
        jaloSession.createLocalSessionContext();
    }

    protected void removeLocalSessionContext(){
        final Session session = sessionService.getCurrentSession();
        final JaloSession jaloSession = (JaloSession) this.sessionService.getRawSession(session);
        jaloSession.removeLocalSessionContext();
    }

    @Required
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @Required
    public void setCatalogVersionService(CatalogVersionService catalogVersionService) {
        this.catalogVersionService = catalogVersionService;
    }
    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

	@Override
	public EmarsysPredictAvailabilityZoneModel getAvailabilityZone(LanguageModel currentLanguage,
			CurrencyModel currentCurrency) {
		final Map<String, Object> queryParams = new HashMap<String, Object>();

		queryParams.put("language", currentLanguage);
		queryParams.put("currency", currentCurrency);

		FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(QUERY);
		searchQuery.addQueryParameters(queryParams);

		SearchResult<EmarsysPredictAvailabilityZoneModel> result = flexibleSearchService.search(QUERY, queryParams);

		if (CollectionUtils.isNotEmpty(result.getResult())) {
			return result.getResult().get(0);
		}
		return null;
	}

	@Required
	public void setCartService(CartService cartService)
	{
		this.cartService = cartService;
	}

}
