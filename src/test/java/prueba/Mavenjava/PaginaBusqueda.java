package prueba.Mavenjava;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageObjects.paginaPrincipal;
import PageObjects.busqueda;
import resources.base;

public class PaginaBusqueda extends base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void inicializar() throws IOException
	{
		driver=crearDriver();
		driver.get(prop.getProperty("urlBusqueda"));
		Log.info("Se accede a la página de búsqueda.");
		paginaPrincipal l=new paginaPrincipal(driver);
		l.aceptarCookies().click();
		Log.info("Se aceptan las cookies.");
	}
	
	@Test
	public void busqueda13() //Se seleccionan distintos filtros de búsqueda.

	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		busqueda b=new busqueda(driver);
		Actions a=new Actions(driver);
		b.getPrecioMaximo().click();
		a.moveToElement(b.getPrecioMaximo()).sendKeys(Keys.chord(Keys.CONTROL, "a", "5")).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		b.getPrecioMaximo().sendKeys("5");
		Log.info("Se introduce un precio en el filtro de precio máximo.");
		b.getBotonIr().click();
		Log.info("Se le da al botón de Ir.");
		List<WebElement> options =b.getPrecioResultado();
		int i=0;
		Log.info("Se comprueba si el precio de los resultados está por debajo del precio máximo.");
		for(WebElement option:options)
		{
			if(i<6)
				{
				Assert.assertTrue(Integer.parseInt(option.getText())<5);
				i++;
				}
			else
				Assert.assertTrue(true);
		}
	}
	@AfterTest
	public void terminar()
	{
		driver.close();
		Log.info("Se cierra la ventana");
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="gestiones@fmasonline.com";
		data[0][1]="gestionesfmas";
		return data;
}

}
