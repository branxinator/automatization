package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class paginaPrincipal {
	
	public WebDriver driver;
	private By cookies=By.cssSelector(".aceptarCookie");
	private By textoPrincipal=By.cssSelector(".texto-cabecera");
	private By buscador=By.cssSelector("input[name='q']");
	private By acceder1=By.xpath("//div[@id=\"menu-usuario\"]/i");
	private By acceder2=By.cssSelector("div[aria-labelledby='menu-usuario'] a:nth-child(1)");
	private By resultados=new By.ByCssSelector(".divTableCell.titulo.col-12.text-center");
	private By resultadosLink=new By.ByCssSelector(".divTableCell.titulo.col-12.text-center a");
	private By correccion=new By.ByCssSelector(".badge.badge-primary");
	private By limpiar=new By.ByCssSelector(".btn.searchbtn");
	private By categoriasBuscadorResultados=new By.ByCssSelector(".divTableCell.titulo.categoria");
	private By marcasBuscadorHeader=new By.ByXPath("//a[contains(text(),'Marcas')]");
	private By marcasBuscadorResultados=new By.ByCssSelector(".canedapred");
	private By botonAñadir=new By.ByCssSelector("div[class='col-12 footer-producto btn btn-primary add-cart-btn ajx-cart btn-64654']");
	private By numeroCarrito=new By.ByCssSelector("span[class='badge  badge-pill badge-danger'][css='1']");
	private By itemCarrito=new By.ByCssSelector(".product-name");
	private By carrito=new By.ByCssSelector(".fa.fa-shopping-cart");
	private By nombreBusqueda=new By.ByCssSelector("h1[itemprop='name']");
	private By categoriaMenu=new By.ByCssSelector(".dropdown-toggle.nav-link.hrclose");
	private By categoriaMenuItem1=new By.ByCssSelector("div[class='col-3 sub-category category-6374']");
	private By categoriaMenuProducto=new By.ByCssSelector("article[class='col-12'] a");//Productos cuando pones el ratón sobre una categoría
	private By marcaMenu=new By.ByCssSelector(".marcas-holder.col-md-3 a img"); //Imagen de la marca cuando pones el ratón sobre una categoría en la página principal
	private By iconoBusqueda=new By.ByCssSelector(".fa.fa-search");//Icono de búsqueda
	public paginaPrincipal(WebDriver driver)	{
		this.driver=driver;
	}
	public WebElement aceptarCookies(){
		return driver.findElement(cookies);
	}
	public WebElement getIconoBusqueda(){
		return driver.findElement(iconoBusqueda);
	}
	public WebElement getTextoPrincipal(){
		return driver.findElement(textoPrincipal);
	}
	public WebElement getAcceder1(){
		return driver.findElement(acceder1);
	}
	public acceso getAcceder2(){
		driver.findElement(acceder2).click();
		acceso a=new acceso(driver);
		return a;
	}
	public WebElement getBuscador(){
		return driver.findElement(buscador);
	}
	public WebElement getCorreccion(){
		return driver.findElement(correccion);
	}
	public WebElement getLimpiar(){
		return driver.findElement(limpiar);
	}
	public WebElement getMarcasBuscadorHeader(){
		return driver.findElement(marcasBuscadorHeader);
	}
	public WebElement getAñadir(){
		return driver.findElement(botonAñadir);
	}
	public WebElement getNumeroCarrito(){
		return driver.findElement(numeroCarrito);
	}
	public WebElement getItemCarrito(){
		return driver.findElement(itemCarrito);
	}
	public WebElement getCarrito(){
		return driver.findElement(carrito);
	}
	public WebElement getNombreBusqueda(){
		return driver.findElement(nombreBusqueda);
	}
	public WebElement getCategoriaMenuItem1(){
		return driver.findElement(categoriaMenuItem1);
	}
	public List<WebElement> getCategoriaMenuProducto(){
		return driver.findElements(categoriaMenuProducto);
	}
	public List<WebElement> getMarcaMenu(){
		return driver.findElements(marcaMenu);
	}
	public List<WebElement> getMarcasBuscadorResultados(){
		return driver.findElements(marcasBuscadorResultados);
	}
	public List<WebElement> getCategoriasBuscadorResultados(){
		return driver.findElements(categoriasBuscadorResultados);
	}
	public List<WebElement> getResultados(){
		return driver.findElements(resultados);
	}
	public List<WebElement> getResultadosLink(){
		return driver.findElements(resultadosLink);
	}
	public List<WebElement> getCategoriaMenu(){
		return driver.findElements(categoriaMenu);
	}
}
