package pageUI.user;

public class SiteMapPageUI {
public static final String MOBLIE_LINK="xpath=//ul[@class='sitemap']//a[text()='Mobile']";
public static final String MESSAGE_IN_MOBLIE="xpath=//div[@class='category-description std']";
public static final String DYNAMIC_PICTURE="xpath=//img[@id='product-collection-image-%s']";
public static final String DYNAMIC_PRICE="xpath=//span[@id='product-price-%s']";
public static final String DYNAMIC_ADD_TO_CART_BUTTON="xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";
public static final String COUNTRY_SELECT="xpath=//select[@id='country']";
public static final String STATE_PROVINCE_INPUT="xpath=//input[@id='region']";
public static final String ZIP_INPUT="xpath=//input[@id='postcode']";
public static final String PROCEED_TO_CHECKOUT_BUTTON="XPATH=//ul[@class='checkout-types top']//li//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]";
public static final String CONTINUE_BILLING_INFORMATION_BUTTON="XPATH=//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]";
public static final String CONTINUE_SHIPPING_METHOD_BUTTON="XPATH=//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]";
public static final String CONTINUE_PAYMENT_INFORMATION_BUTTON="XPATH=//button[@onclick='payment.save()']//span//span[text()='Continue']";
public static final String PLACE_ORDER_BUTTON="XPATH=//span[contains(text(),'Place Order')]";
public static final String MONEY_ORDER_RADIO="XPATH=//input[@id='p_method_checkmo']";
public static final String TV_LINK="xpath=//ul[@class='sitemap']//a[text()='TV']";
public static final String CONTINUE_BUTTON="XPATH=//button[@title='Continue Shopping']";
public static final String SHIP_TO_THIS_ADDRESS="XPATH=//input[@id='billing:use_for_shipping_yes']";




}
