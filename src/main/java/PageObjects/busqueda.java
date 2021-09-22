package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class busqueda {
	public WebDriver driver;
	private By categoria=new By.ByCssSelector(".odd");
	private By marcaCabecera=new By.ByCssSelector(".marcas"); //Cabecera de la pagina cuando le pinchas a una marca
	private By mensajeBusqueda=new By.ByCssSelector(".note-msg"); //Mensaje indicando que hay que meter más de tres caracteres
	private By precioMaximo=new By.ByCssSelector("#maxPrice"); //El filtro del precio máximo 
	private By botonIr=new By.ByCssSelector("input[class='go btn-sm btn-primary']"); //Botón de Ir 
	private By precioResultados=new By.ByCssSelector(".span-md-centro"); //El filtro del precio máximo 
	
	public WebElement getMensajeBusqueda(){
		return driver.findElement(mensajeBusqueda);
	}
	public WebElement getBotonIr(){
		return driver.findElement(botonIr);
	}
	public WebElement getPrecioMaximo(){
		return driver.findElement(precioMaximo);
	}
	public WebElement getMarcaCabecera(){
		return driver.findElement(marcaCabecera);
	}
	public busqueda(WebDriver driver)	{
		this.driver=driver;
	}
	public List<WebElement> getCategoria(){
		return driver.findElements(categoria);
	}
	public List<WebElement> getPrecioResultado(){
		return driver.findElements(precioResultados);
	}


}
