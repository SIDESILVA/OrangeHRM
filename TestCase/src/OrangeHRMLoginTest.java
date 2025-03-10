import org.TestCase.Selenium.By;
import org.TestCase.Selenium.WebDriver;
import org.TestCase.Selenium.WebElement;
import org.TestCase.Selenium.chrome.ChromeDriver;


public class OrangeHRMLoginTest {
	public static void main(String[]args) {
        // Set the path to the ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suchini\\Desktop\\QA Assignment\\chromedriver-win64\\chromedriver.exe");
		
        // Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		try {
            // Step 1: Open the OrangeHRM login page
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
            // Step 2: Enter a valid username and password
			WebElement username = driver.findElement(By.name("username"));
			username.sendkeys("Admin"); // Enter valid username
			
			WebElement password = driver.findElement(By.name("password"));
			password.sendkeys("admin123");
			
            // Step 3: Click the login button
			WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
			loginButton.click();
			
            // Wait for a few seconds to ensure navigation to the home page
			Thread.sleep(5000); // Adjust the wait time as needed
			
            // Verify if the home page is displayed
			String expectedUrl = "https://opensource-demo.oranehrmlive.com/web/index.php/dashboard/index";
			
			if(driver.getCurrentUrl().equals(expectedUrl)) {
				System.out.println("Login successful. User navigated to the OrangeHRM home page.");
			}else {
				System.out.println("Login failed. User did not navigate to the home page.");
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
		//close the browser
		driver.quit();
		}
		
	}
}
