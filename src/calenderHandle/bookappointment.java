package calenderHandle;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bookappointment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lakha\\eclipse-workspace\\MoneyBhai\\Browsers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://pms.tractorlearningcenter.in/auth/login");

		/*
		 * @FindBy(xpath = "") private WebElement userid;
		 * 
		 * @FindBy(xpath = "") private WebElement password;
		 * 
		 * @FindBy(xpath = "//div[@class='login-wrap']//button") private WebElement
		 * sinbtn;
		 */

		driver.findElement(By.xpath("//div[@class='login-wrap']/input[1]")).sendKeys("receptionist@hms.com");
		driver.findElement(By.xpath("//div[@class='login-wrap']/input[2]")).sendKeys("12345");
		driver.findElement(By.xpath("//div[@class='login-wrap']//button")).click();

		driver.findElement(By.xpath("//ul[@id='nav-accordion']/li[4]/a")).click();
		driver.findElement(By.xpath("//ul[@id='nav-accordion']/li[4]//ul/li[2]")).click();

		driver.findElement(By.xpath("//input[@id='date']")).click();

		String exMo = "December 2022";
		String exDay = "25";

		while (true) {

			String month = driver.findElement(By.xpath("//div[@class='datepicker-days']//thead/tr[2]/th[2]")).getText();
			List<WebElement> dates = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day']"));

			if (month.equals(exMo)) {

				for (int i = 0; i <= dates.size() - 1; i++) {

					String day = dates.get(i).getText();

					if (day.equals(exDay)) {
						dates.get(i).click();
						break;
					}

				}

			} else {

				driver.findElement(By.xpath("//div[@class='datepicker-days']//thead/tr[2]/th[3]")).click();
			}

		}

	}

}
