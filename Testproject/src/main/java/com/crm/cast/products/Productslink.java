package com.crm.cast.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productslink {
@FindBy(name = "products")
private WebElement productlink;

public WebElement getProductlink() {
	return productlink;
}
}
