package Testes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class AbreKanleitos {
	
	private WebDriver driver;
	
	@Test
	public void deveLogar()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		this.driver = new ChromeDriver();
		
		driver.get("http://kanleitos.azurewebsites.net/");
		
		new WebDriverWait(driver, 30).withMessage("Tempo insuficiente para encontrar o campo Login").
			until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@ng-model='login.login']")));
		
		WebElement campoLogin = driver.findElement(By.xpath("//input[@ng-model='login.login']"));
		campoLogin.sendKeys("teste@kanleitos.com");
		
		new WebDriverWait(driver, 30).withMessage("Tempo insuficiente para encontrar o campo Senha").
			until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@ng-model='login.senha']")));
		
		WebElement campoSenha = driver.findElement(By.xpath("//input[@ng-model='login.senha']"));
		campoSenha.sendKeys("teste@123");
		
		new WebDriverWait(driver, 30).withMessage("Tempo insuficiente para encontrar o botão entrar").
		until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@ng-click='realizarLogin()']")));
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@ng-click='realizarLogin()']"));
		btnLogin.click();
		
		boolean logou = driver.getPageSource().contains("Relatórios gerais");
		assertTrue(logou);
		
		driver.close();
	}
	
}
