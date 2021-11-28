package pageUI.LiveGuru99;

public class AdminManagerCustomerPageUI {
	public static String COLUMN_NAME_POSITION = "//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static String TEXTBOX_BY_COLUMN_POSITION = "//tr[@class='%s']/th[%s]//input";
	public static String CLICK_SEARCH_BUTTON = "//button[@title='Search']";
	public static String LOADING_ICON = "//p[@id='loading_mask_loader']";
	public static String FULLNAME_AND_EMAIL_IN_TABLE = "//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
	public static String CLOSE_POPUP_WINDOW= "//div[@id='message-popup-window']//a[@title='close']";
}
