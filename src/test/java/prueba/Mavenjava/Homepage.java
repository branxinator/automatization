package prueba.Mavenjava;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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

public class Homepage extends base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void inicializar() throws IOException
	{
		driver=crearDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página principal.");
		paginaPrincipal l=new paginaPrincipal(driver);
		l.aceptarCookies().click();
		Log.info("Se aceptan las cookies.");
	}
	
	@Test
	public void acceso() //Acceso a página principal
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		Log.info("Se comprueba que ha accedido a la página principal.");
		Assert.assertTrue(l.getTextoPrincipal().isDisplayed());
	}
	
	@Test
	public void busqueda01() //Realizar una búsqueda en la barra de búsqueda
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		l.getBuscador().sendKeys("pasti");
		Log.info("Se introduce un término de búsqueda.");
		List<WebElement> options =l.getResultados();
		int i=0;
		Log.info("Se comprueba si hay resultados que contengan el término.");
		for(WebElement option:options)
		{
			if(i<6)
				{
				Assert.assertTrue(option.getText().contains("pasti"));
				i++;
				}
			else
				Assert.assertTrue(true);
		}
	}
	@Test
	public void busqueda02() //Introducir menos de tres términos en la barra de búsqueda
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("pa");
		Log.info("Se introduce un término de dos letras");
		Log.info("Comprueba que no hay resultados");
		Assert.assertTrue(l.getResultados().isEmpty());
	}
	@Test
	public void busqueda03() //Introducir un término que no devuelva ningún resultado
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("asdsds");
		Log.info("Se introduce un término de búsqueda.");
		Log.info("Comprueba que no hay resultados");
		Assert.assertTrue(l.getResultados().isEmpty());
	}
	
	@Test
	public void busqueda04() //Introducir un término que no devuelva ningún resultado 
	//pero sugiere palabra alternativa
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("ddd");
		Log.info("Se introduce un término de búsqueda.");
		Log.info("Comprueba que sugiere la palabra");
		Assert.assertTrue(l.getCorreccion().isDisplayed());
	}
	
	@Test
	public void busqueda05() //Seleccionar la palabra sugerida en la ventana emergente
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		String palabraCorreccion = l.getCorreccion().getText();
		l.getCorreccion().click();
		Log.info("Se selecciona la palabra sugerida");
		Log.info("Se comprueba que se ha seleccionado");
		Assert.assertTrue(l.getBuscador().getAttribute("value").equals(palabraCorreccion));
	}
	
	@Test
	public void busqueda06() //Limpiar el término introducido en la barra de búsqueda
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		l.getLimpiar().click();
		Log.info("Se limpia el buscador");
		Log.info("Comprueba que el campo está vacío");
		Assert.assertTrue(l.getBuscador().getAttribute("value").isEmpty());
	}
	@Test
	public void busqueda07() //Seleccionar una categoría al realizar una búsqueda.
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("pastillas");
		Log.info("Se introduce un término en el buscador");
		l.getCategoriasBuscadorResultados().get(0).click();
		Log.info("Se clica en la primera categoría disponible");
		busqueda b=new busqueda(driver);
		Log.info("Se comprueba que accede a la página de búsqueda");
		Assert.assertTrue(b.getCategoria().get(0).isDisplayed());
	}
	@Test
	public void busqueda08() //Seleccionar una marca al realizar una búsqueda.
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		busqueda b=new busqueda(driver);
		l.getBuscador().sendKeys("pastillas");
		Log.info("Se introduce un término en el buscador");
		l.getMarcasBuscadorHeader().click();
		Log.info("Se clica en la pestaña Marcas");
		l.getMarcasBuscadorResultados().get(0).click();
		Log.info("Se selecciona la primera marca");
		Log.info("Se comprueba que accede a la página de búsqueda");
		Assert.assertTrue(b.getCategoria().get(0).isDisplayed());
	}
	@Test
	public void busqueda09() //Comprar un producto en la ventana emergente
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("pastillas");
		Log.info("Se introduce un término en el buscador");
		l.getAñadir().click();
		Log.info("Se añade el primer producto");
		String a=l.getResultados().get(0).getText();
		String[] a1=a.split("\n");
		Log.info("Se comprueba que ha añadido al carrito");
		l.getCarrito().click();
		String a2=l.getItemCarrito().getText();
		
		Assert.assertTrue(a2.equalsIgnoreCase(a1[0]));
	}
	
	@Test
	public void busqueda10() //Se selecciona un producto.
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().click();
		l.getBuscador().sendKeys("pastillas");
		Log.info("Se introduce un término en el buscador");
		l.getResultadosLink().get(0).click();
		Log.info("Se comprueba que accede a la página del producto");
		Assert.assertTrue(l.getNombreBusqueda().isDisplayed());
	}
	
	@Test
	public void categoria01() //Se coloca el cursor sobre una categoría. 
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba:  "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		Actions a=new Actions(driver);
		a.moveToElement(l.getCategoriaMenu().get(0)).perform();
		Log.info("Se pone el cursor sobre una categoría");
		Log.info("Se comprueba que se muestra la ventana de categorías");
		boolean b=l.getCategoriaMenuItem1().isEnabled();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(b);
	}
	
	@Test
	public void categoria02() //Seleccionar una categoría
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getCategoriaMenu().get(0).click();
		Log.info("Se pone clica sobre una categoría");
		Log.info("Se comprueba que se accede a la página de la categoría");
		busqueda b=new busqueda(driver);
		Assert.assertTrue(b.getCategoria().get(0).isDisplayed());
	}
	
	@Test
	public void categoria03() //Se selecciona uno de los productos que aparecen al desplegar la categoría. 
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		Actions a=new Actions(driver);
		a.moveToElement(l.getCategoriaMenu().get(0)).perform();
		Log.info("Se pone el cursor sobre una categoría");
		Log.info("Se clica sobre un producto");
		l.getCategoriaMenuProducto().get(0).click();
		Log.info("Se comprueba que accede a la página del producto");
		Assert.assertTrue(l.getNombreBusqueda().isDisplayed());
	}
	
	@Test
	public void categoria04() //Se selecciona uno de las marcas que aparecen al desplegar la categoría.
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		Actions a=new Actions(driver);
		a.moveToElement(l.getCategoriaMenu().get(0)).perform();
		Log.info("Se pone el cursor sobre una categoría");
		Log.info("Se clica sobre la imagen de una de las marcas");
		l.getMarcaMenu().get(0).click();
		Log.info("Se comprueba que accede a la página de la marca");
		busqueda b=new busqueda(driver);
		Assert.assertTrue(b.getMarcaCabecera().isDisplayed());
	}
	
	@Test
	public void busqueda11() //Se introduce un término en la barra de búsqueda y se le da al icono de buscar.
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("pastilla");
		Log.info("Se introduce un término de búsqueda.");
		l.getIconoBusqueda().click();
		busqueda b=new busqueda(driver);
		Log.info("Se comprueba que accede a la página de búsqueda");
		Assert.assertTrue(b.getCategoria().get(0).isDisplayed());
	}
	@Test
	public void busqueda12() //Se introduce un término de menos de tres caracteres y se le da al botón de búsqueda.
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Log.info("Prueba: "+name);
		paginaPrincipal l=new paginaPrincipal(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Se accede a la página");
		l.getBuscador().sendKeys("pa");
		Log.info("Se introduce un término de búsqueda.");
		l.getIconoBusqueda().click();
		busqueda b=new busqueda(driver);
		Log.info("Se comprueba que accede a la página de búsqueda");
		Assert.assertTrue(b.getMensajeBusqueda().isDisplayed());
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
