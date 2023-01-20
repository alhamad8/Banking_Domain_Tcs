import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Mytests extends Parameters {

	@Test(priority = 1, groups = "customer")
	public void login_as_customer() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("btn-lg")).click();

	}

	@Test(priority = 1, groups = "manager")
	public void login_as_maneger() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/button")).click();

	}

	@Test(priority = 2, groups = "manager")
	public void add_customer() throws InterruptedException {
		int userID = (int) (Math.random() * 100);
		StringBuilder userName = new StringBuilder();
		userName.append(userID);
		String UserIDAsString = userName.toString();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("Mr");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"))
				.sendKeys("user" + UserIDAsString);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"))
				.sendKeys(UserIDAsString);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Thread.sleep(3000);
		String alertText = driver.switchTo().alert().getText();
		boolean checkAlertText = alertText.contains("successfully");
		softassert.assertEquals(checkAlertText, true,"customer added successfully");
		softassert.assertAll();
		driver.switchTo().alert().accept();
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")).sendKeys("user" + UserIDAsString);
		List<WebElement> myUsers = driver.findElements(By.xpath("//tbody/tr"));
		int myActualUsers = myUsers.size();
		softassert.assertEquals(myActualUsers, 1);
		softassert.assertAll();

	}
	
	@Test()
	public void test_again() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();

		WebElement myMenu = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select MySelect = new Select(myMenu);

		MySelect.selectByVisibleText("Harry Potter");

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();

		Thread.sleep(1000);
		String MyBiggestAmount = "900";
		String MySmallestAmount = "200" ; 
		
		int small = Integer.parseInt(MySmallestAmount);
	int big = 	Integer.parseInt(MyBiggestAmount);


		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(MyBiggestAmount);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(MySmallestAmount);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		Thread.sleep(2000);

		String myBalance = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
		System.out.println(myBalance);
		
		int myNewBalance = Integer.parseInt(myBalance);
		
		
		softassert.assertEquals(myNewBalance, 500,"check the withdraw process ");
		softassert.assertAll();

		
//		Set<String> mytabs = driver.getWindowHandles();
//
//		Iterator<String> tabView = mytabs.iterator();
//
//		while (tabView.hasNext()) {
//			driver.switchTo().window(tabView.next());
//			System.out.println(driver.getTitle());
//		}
//		
	

	}

}
