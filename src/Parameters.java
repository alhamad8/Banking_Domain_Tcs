import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng .annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {
	public WebDriver driver;
	String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
	SoftAssert softassert = new SoftAssert();
	@BeforeTest()
	public void pre_my_Test () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}

}
