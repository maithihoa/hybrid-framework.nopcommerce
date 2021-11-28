package dynamicLocator;

public class RestParameter {
	//Way 2
	String DYNAMIC_PAGE1 = "//td[@data-key='females' and text()='%s']";
	String DYNAMIC_PAGE2 = "//td[@data-key='females' and text()='%s']//following-sibling::td[@data-key='country' and text()='%s']";
	String DYNAMIC_PAGE3 = "//td[@data-key='females' and text()='%s']//following-sibling::td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='males' and text()='%s']";
	String DYNAMIC_PAGE4 = "//td[@data-key='females' and text()='%s']//following-sibling::td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='males' and text()='%s']//following-sibling::td[@data-key='total' and text()='%s']";
	
	public void ClickToElement(String locator, String... value)
	{
		System.out.println(String.format(locator, (Object[]) value));
	}
}