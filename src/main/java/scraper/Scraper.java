package scraper;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {
	//public static String AMAZON_LINK = "http://www.wikipedia.org";
	public static String AMAZON_LINK = "https://www.amazon.com/gp/product/B01CGGOZOM/ref=s9_acss_bw_cg_cegwcacl_2b1?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=unified-hybrid-3&pf_rd_r=BYXMG5WB5VQ1HCAT7H84&pf_rd_t=101&pf_rd_p=8cf85aa2-a96a-4847-b5be-d3bebf45ebf9&pf_rd_i=565108";
	public static void main(String[] args) {
		System.out.println("test");
		
		try {
			Document doc = Jsoup.connect(AMAZON_LINK)
					.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
					  .referrer("http://www.google.com")
					  .get();
			List<Element> allElements = doc.getAllElements();
			for(Element e: allElements){
				System.out.println(e.data());
			}
			
			List<Element> entries = doc.getElementsByClass("prodDetSectionEntry");
			for(Element e: entries){
				System.out.println(e.data());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
