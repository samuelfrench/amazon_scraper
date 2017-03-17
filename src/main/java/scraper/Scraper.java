package scraper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static String AMAZON_LINK3 = "https://www.amazon.com/dp/B01AWGXNH8/ref=psdc_13896615011_t1_B019O7V4EU";
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam\\Documents\\dev\\chromeDriver.exe");
		
		WebDriver webDriver = new ChromeDriver();

		// Setting the browser size
		webDriver.manage().window().setSize(new Dimension(1024, 768));

		webDriver.navigate().to(AMAZON_LINK3);
		
		List<WebElement> matchingClass = webDriver.findElements(By.className("a-size-base"));
		
		Map<String, String> detailMap = new HashMap<>(); //maps the specification title to the value
		
		for(int i = 0; i < matchingClass.size()-1; i++){ //no need to iterate over the last entry, it cannot be a key as a key must be followed by a value (prevents index oob exception)
			
			if(matchingClass.get(i).getTagName().equals("th")){ //is this a tableheading (in the product detail table)??
				System.out.println("putting key: " + matchingClass.get(i).getText() + " value: " + matchingClass.get(i+1).getText());
				detailMap.put(matchingClass.get(i).getText(), matchingClass.get(i+1).getText()); //if so go ahead and add it to our map
			}
			
		}
		
		webDriver.close();
	}
}
