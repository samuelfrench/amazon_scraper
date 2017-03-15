package scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scraper {
	public static String GECKO_DRIVER = "C:\\Users\\Sam\\Documents\\dev\\geckodriver.exe";
	//public static String AMAZON_LINK = "http://www.wikipedia.org";
	public static String AMAZON_LINK = "https://www.amazon.com/gp/product/B01CGGOZOM/ref=s9_acss_bw_cg_cegwcacl_2b1?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=unified-hybrid-3&pf_rd_r=BYXMG5WB5VQ1HCAT7H84&pf_rd_t=101&pf_rd_p=8cf85aa2-a96a-4847-b5be-d3bebf45ebf9&pf_rd_i=565108";
	public static String AMAZON_LINK2 = "https://www.amazon.com/dp/B01K1IO3QW";
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam\\Documents\\dev\\chromeDriver.exe");
		
		WebDriver webDriver = new ChromeDriver();

		// Setting the browser size
		webDriver.manage().window().setSize(new Dimension(1024, 768));

		webDriver.navigate().to(AMAZON_LINK2);
		
		WebElement screenSize = webDriver.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_1\"]/tbody/tr[1]/td"));
		System.out.println("Screen size: " + screenSize.getText());
		
		WebElement mfr = webDriver.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_2\"]/tbody/tr[1]/td"));
		System.out.println("Mfr: " + mfr.getText());
		
		WebElement os = webDriver.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_2\"]/tbody/tr[4]/td"));
		System.out.println("os: " + os.getText());
		
		WebElement cpu = webDriver.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_1\"]/tbody/tr[3]/td"));
		System.out.println("cpu: " + cpu.getText());
		
		webDriver.close();
	}

}
