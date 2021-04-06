package designpattern;

public class AdaptorDesignPattern {

	public static void main(String[] args) {
		ChromeDriver chrome = new ChromeDriver();
		chrome.getElement();
		chrome.selectElement();
		
		IEDriver ie = new IEDriver();
		ie.findElement();
		ie.clickElement();
		
		WebDriver wid = new WebDriverAdabptor(ie);
		wid.getElement();
		wid.selectElement();
	}
}


interface WebDriver{
	public void getElement();
	public void selectElement();
}

class ChromeDriver implements WebDriver
{

	@Override
	public void getElement() {
		System.out.println("GetElement in ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("SelectElement in ChromeDriver");
	}
	
}

class IEDriver{
	public void findElement() {
		System.out.println("FindElement in IEDriver");
	}
	public void clickElement() {
		System.out.println("ClickElement in IEDriver");
	}
}

class WebDriverAdabptor implements WebDriver{

	IEDriver ieDriver;
	
	public WebDriverAdabptor(IEDriver ie) {
		this.ieDriver = ie;
	}
	
	@Override
	public void getElement() {
		ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		ieDriver.clickElement();
	}
	
}