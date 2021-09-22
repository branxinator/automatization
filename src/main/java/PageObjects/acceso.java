package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class acceso {

	public WebDriver driver;
	By email =new By.ByCssSelector(".form-control.validate-email");
	By password =new By.ByCssSelector(".form-control.validate-password");
	By button =new By.ByCssSelector("button[title='Acceder']");
	
	public acceso(WebDriver driver)	{
		this.driver=driver;
	}
	public WebElement getEmail(){
		return driver.findElement(email);
	}
	public WebElement getPassword(){
		return driver.findElement(password);
	}
	public WebElement getButton(){
		return driver.findElement(button);
	}

}
