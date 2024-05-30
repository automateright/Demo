import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("http://example.com/login");

            // Find the username and password input fields
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Enter the username and password
            usernameField.sendKeys("testuser");
            passwordField.sendKeys("testpassword");

            // Find the subscribe checkbox and assert its initial state
            WebElement subscribeCheckbox = driver.findElement(By.id("subscribe"));
            assert subscribeCheckbox.isSelected() == true;

            // Find the login button and click on it
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Check if login was successful by looking for a logout button
            try {
                WebElement logoutButton = driver.findElement(By.id("logoutButton"));
                System.out.println("Login successful!");
            } catch (Exception e) {
                System.out.println("Login failed!");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}