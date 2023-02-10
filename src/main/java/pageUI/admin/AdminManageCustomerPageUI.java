package pageUI.admin;
public class AdminManageCustomerPageUI{
	public static final String INCOMING_MESSAGE ="xpath=//h2[normalize-space()='Incoming Message']";
	public static final String CLOSE_OF_INCOMING_MESSAGE ="xpath=//span[normalize-space()='close']";
	public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME ="xpath=//span[contains(text(),'%s')]//parent::a//parent::span//parent::th//parent::tr//following-sibling::tr//th//input[@id='%s']";
	public static final String NO_RECORDS_FOUND_MESSAGE ="xpath=//td[@class='empty-text a-center']";
	public static final String DYNAMIC_VALID_EMAIL_INFORMATION ="xpath=//td[normalize-space()='%s']";
	public static final String CUSTOMERS_INFOR_DISPLAYED ="xpath=//td[@class='a-center ']/parent::tr";


}
