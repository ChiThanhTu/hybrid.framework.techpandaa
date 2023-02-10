package pageUI.admin;

public class AdminSalesOrderPageUI {
	public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME ="xpath=//span[contains(text(),'%s')]//parent::a//parent::span//parent::th//parent::tr//following-sibling::tr//th//input[@id='%s']";
	public static final String DYNAMIC_HEADER_INDEX_BY_NAME ="xpath=//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
	public static final String DYNAMIC_CEEL_BY_HEADER_INDEX_AND_ROW_INDEX ="xpath=//thead//following-sibling::tbody//tr[%s]//td[%s]";
	public static final String NO_RECORDS_FOUND_MESSAGE ="xpath=//td[@class='empty-text a-center']";

}
