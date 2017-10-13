package com.osfglobal.hybris.emarsys.facades.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.site.BaseSiteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictModel;
import com.osfglobal.hybris.emarsys.data.CommandData;
import com.osfglobal.hybris.emarsys.enums.EmarsysWidgetTypeEnum;
import com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider;
import com.osfglobal.hybris.emarsys.recommendations.commands.impl.CartCommandProvider;
import com.osfglobal.hybris.emarsys.recommendations.commands.impl.CategoryCommandProvider;
import com.osfglobal.hybris.emarsys.recommendations.commands.impl.HomeCommandProvider;
import com.osfglobal.hybris.emarsys.recommendations.commands.impl.PurchaseCommandProvider;
import com.osfglobal.hybris.emarsys.recommendations.commands.impl.ViewCommandProvider;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysCategoryResolver;
import com.osfglobal.hybris.emarsys.services.EmarsysPredictService;
/**
 * This class provides UT for JS Recommendation main components: the command
 * providers
 * 
 * @author Imad Eddine BOUIHI
 *
 */
@UnitTest
public class EmarsysPredictFacadeImplTest
{

	private EmarsysPredictFacadeImpl emarsysPredictFacadeImpl;
	@Mock
	private CartFacade cartFacade;
	@Mock
	OrderFacade orderFacade;
	@Mock
	private BaseSiteService baseSiteService;
	@Mock
	private UserService userService;
	@Mock
	private CategoryService categoryService;
	@Mock
	private EmarsysCategoryResolver emarsysCategoryResolver;
	@Mock
	private EmarsysPredictService emarsysPredictService;
	@Mock
	private I18NService i18NService;
	@Mock
	CommonI18NService commonI18NService;

	private CartCommandProvider cartCommandProvider;
	private CategoryCommandProvider categoryCommandProvider;
	private HomeCommandProvider homeCommandProvider;
	private ViewCommandProvider viewCommandProvider;
	private PurchaseCommandProvider purchaseCommandProvider;

	CategoryModel category;
	CartData cart1;
	CartData cart2;

	EmarsysPredictModel emarsysPredict;
	BaseSiteModel currentSite;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		final Locale locale = new Locale("en");

		BaseSiteModel currentSite = new BaseSiteModel();
		emarsysPredict = new EmarsysPredictModel();
		emarsysPredict.setEnableTrackingCode(Boolean.TRUE);
		currentSite.setEmarsysPredict(emarsysPredict);
		emarsysPredict.setCartPageRecomType(EmarsysWidgetTypeEnum.ALSO_BOUGHT);
		emarsysPredict.setCategoryPageRecomType(EmarsysWidgetTypeEnum.CATEGORY);
		emarsysPredict.setHomePageRecomType(EmarsysWidgetTypeEnum.DISABLED);
		emarsysPredict.setProductPageRecomType(EmarsysWidgetTypeEnum.RELATED);
		emarsysPredict.setOrderPageRecomType(EmarsysWidgetTypeEnum.TOPICAL);

		emarsysPredictFacadeImpl = new EmarsysPredictFacadeImpl();
		emarsysPredictFacadeImpl.setBaseSiteService(baseSiteService);
		emarsysPredictFacadeImpl.setUserService(userService);
		// init commands
		// Cart
		ArrayList<String> patterns = new ArrayList<String>();
		patterns.add("/**/cart");
		// Commands
		ArrayList<AbstractCommandProvider> commands = new ArrayList<AbstractCommandProvider>();
		cartCommandProvider = new CartCommandProvider();
		cartCommandProvider.setCommandName("cart");
		cartCommandProvider.setPatterns(patterns);
		cartCommandProvider.setBaseSiteService(baseSiteService);
		commands.add(cartCommandProvider);
		// Category
		ArrayList<String> patterns2 = new ArrayList<String>();
		patterns2.add("/**/c/{categoryCode}?sort**");
		patterns2.add("/**/c/{categoryCode}?q**");
		patterns2.add("/**/c/{categoryCode:.*}");
		categoryCommandProvider = new CategoryCommandProvider();
		categoryCommandProvider.setCommandName("category");
		categoryCommandProvider.setPatterns(patterns2);
		categoryCommandProvider.setBaseSiteService(baseSiteService);
		categoryCommandProvider.setCategoryService(categoryService);
		categoryCommandProvider.setEmarsysCategoryResolver(emarsysCategoryResolver);
		categoryCommandProvider.setHeroParameter("categoryCode");
		commands.add(categoryCommandProvider);
		// Home
		ArrayList<String> patterns3 = new ArrayList<String>();
		patterns3.add("/");
		patterns3.add("/{catalogId}/{lang}/");
		patterns3.add("/{contextPath}/");
		patterns3.add("/{contextPath}/{catalogId}/{lang}/");

		homeCommandProvider = new HomeCommandProvider();
		homeCommandProvider.setCommandName("home");
		homeCommandProvider.setPatterns(patterns3);
		homeCommandProvider.setBaseSiteService(baseSiteService);
		commands.add(homeCommandProvider);

		// View
		ArrayList<String> patterns4 = new ArrayList<String>();
		patterns4.add("/**/p/{productCode:.*}");
		viewCommandProvider = new ViewCommandProvider();
		viewCommandProvider.setCommandName("view");
		viewCommandProvider.setPatterns(patterns4);
		viewCommandProvider.setBaseSiteService(baseSiteService);
		viewCommandProvider.setEmarsysPredictService(emarsysPredictService);
		viewCommandProvider.setCommonI18NService(commonI18NService);
		viewCommandProvider.setHeroParameter("productCode");

		commands.add(viewCommandProvider);

		// Purchase
		ArrayList<String> patterns5 = new ArrayList<String>();
		patterns5.add("/**/checkout/orderConfirmation/{orderCode:.*}");
		purchaseCommandProvider = new PurchaseCommandProvider();
		purchaseCommandProvider.setCommandName("purchase");
		purchaseCommandProvider.setPatterns(patterns5);
		purchaseCommandProvider.setBaseSiteService(baseSiteService);
		purchaseCommandProvider.setHeroParameter("orderCode");
		purchaseCommandProvider.setOrderFacade(orderFacade);

		commands.add(purchaseCommandProvider);

		emarsysPredictFacadeImpl.setCommandProviders(commands);

		// Mock other required objects
		given(baseSiteService.getCurrentBaseSite()).willReturn(currentSite);
		given(i18NService.getCurrentLocale()).willReturn(locale);

	}

	@Test
	public void testgetCommandCart()
	{
		given(cartFacade.getSessionCart()).willReturn(cart1);

		final CommandData command = emarsysPredictFacadeImpl.getCommand("/electronics/en/USD/cart");
		Assert.assertEquals("cart", command.getName());
	}

	@Test
	public void testCategoryCommand()
	{
		final CategoryModel category = mock(CategoryModel.class);
		final String code = "571";
		BDDMockito.given(categoryService.getCategoryForCode(code)).willReturn(category);
		BDDMockito.given(emarsysCategoryResolver.resolve(category)).willReturn("Films cameras");

		final CommandData command = emarsysPredictFacadeImpl
				.getCommand("/electronics/en/Open-Catalogue/Cameras/Film-cameras/c/574");
		Assert.assertEquals("category", command.getName());
		Assert.assertEquals("CATEGORY", command.getLogic());
	}

	@Test
	public void testHomeCommand()
	{
		final CommandData command = emarsysPredictFacadeImpl.getCommand("/");
		Assert.assertEquals("home", command.getName());
		Assert.assertEquals(null, command.getLogic());
	}

	@Test
	public void testViewCommand()
	{

		final CommandData command = emarsysPredictFacadeImpl
				.getCommand("/electronics/en/Open-Catalogue/Cameras/Digital-Cameras/Digital-Compacts/DSC-S930/p/1992695");
		Assert.assertEquals("view", command.getName());
		Assert.assertEquals("RELATED", command.getLogic());
		Assert.assertEquals("'1992695'", command.getParamString());
	}

	@Test
	public void testPurchaseCommand()
	{
		// Data
		OrderData order = new OrderData();
		order.setCode("00000001");
		List<OrderEntryData> entries = new ArrayList<>();
		OrderEntryData entry1 = new OrderEntryData();
		entry1.setQuantity(Long.valueOf(1));
		ProductData product1 = new ProductData();
		product1.setCode("1992695");
		entry1.setProduct(product1);
		entry1.setRoundedBasePrice("7.99");
		entries.add(entry1);
		order.setEntries(entries);
		given(orderFacade.getOrderDetailsForCode("00000001")).willReturn(order);

		// Test
		final CommandData command = emarsysPredictFacadeImpl
				.getCommand("/checkout/orderConfirmation/00000001");
		Assert.assertEquals("purchase", command.getName());
		Assert.assertEquals("TOPICAL", command.getLogic());
		Assert.assertEquals("{orderId: '00000001',items: [{item: '1992695', price:7.99, quantity:1}]}", command.getParamString());
	}
	

}
