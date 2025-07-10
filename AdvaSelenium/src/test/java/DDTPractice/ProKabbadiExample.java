package DDTPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadiExample {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		//div[@class='table-body']//div[@class='table-data matches-won']/p
		//=lost
			//	points
		WebElement teams = driver.findElement(By.xpath("//div[@class='table-body']//div[@class='team-name']/p"));
		System.out.println("Teams:"+teams.getText());
		WebElement won = driver.findElement(By.xpath("//div[@class='table-body']//div[@class='table-data matches-won']/p"));
		System.out.println("won:"+won.getText());
		WebElement lost = driver.findElement(By.xpath("//div[@class='table-body']//div[@class='table-data matches-lost']/p"));
		System.out.println("lost:"+lost.getText());
		WebElement points = driver.findElement(By.xpath("//div[@class='table-body']//div[@class='table-data points']/p"));
		System.out.println("points:"+points.getText());
		//System.out.println("Teams:"+teams.getText()+"won:"+won.getText()+"Lost:"+lost.getText()+"points"+points.getText());
	}

}
