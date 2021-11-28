package pageUI.jquery;

public class HomePageUIJquery {
	public static final String PAGE_NAME_LINK = "//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME = "//div[text()='%s']";
	public static final String SEND_HEADER_TEXTBOX_BY_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_BY_ALL_VALUES = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ROW_DELETE_BY_COUNTRY_AND_NAME = "//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	//lấy ra số người anh của cột cần lấy
	public static final String COLUMN_NUMBER_INDEX = "//th[text()='%s']/preceding-sibling::th";
	//lấy ra ô cần chèn, vì cột không thể đếm cụ thể như dòng được nên phải thêm step ngay bên trên để lấy ra số cột
	public static final String COLUMN_NAME_AND_ROW_NUMBER = "//table//tr[%s]/td[%s]/input";
	
	public static final String SELECT_DROP_DOWN_BY_COLUMN_NAME_AND_ROW_NUMBER = "//tbody/tr[%s]/td[%s]//option[@value='%s']";
	public static final String SELECT_BUTTON_BY_COLUMN_NAME_AND_ROW_NUMBER = "//tbody/tr[%s]/td[8]//button[contains(@id,'%s')]";
	
}
