package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1
{
	
	private WebDriver driver;
	private By userTextField = By.name("user_name");
	private By passwordTextField = By.name("user_password");
	private By loginButton = By.id("submitButton");
	
	
	//create constructor for class default
	public LoginPage1(WebDriver driver)
	{
		this.driver = driver;
	}
	//methods to interact with webelements
	public void EnterUserName(String username)
	{
		WebElement userInput = driver.findElement(userTextField);
		userInput.sendKeys(username);
	}
	public void EnterPassword(String password)
	{
		WebElement passwordInput = driver.findElement(passwordTextField);
		passwordInput.sendKeys(password);
	}
	public void ClickOnLoginButton()
	{
		WebElement loginbuttonfield = driver.findElement(loginButton);
		loginbuttonfield.click();
	}
	public void EnterLoginData(String Username,String Password)
	{
		WebElement userInput = driver.findElement(userTextField);
		userInput.sendKeys(Username);
		WebElement passwordInput = driver.findElement(passwordTextField);
		passwordInput.sendKeys(Password);
		WebElement loginbuttonfield = driver.findElement(loginButton);
		loginbuttonfield.click();
	
		
	}

}
