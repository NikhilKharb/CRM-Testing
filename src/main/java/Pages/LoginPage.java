package Pages;

import AbstractComponents.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="a[class*='btn btn-primary']")
    WebElement startBtn;

    public void goToLoginPage(){
        driver.get("https://freecrm.com/index.html");
        System.out.println("Opend URL");
        startBtn.click();
        System.out.println("Navigated toLoginPage");
    }
    @FindBy(name="email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(css=".ui.fluid.large.blue.submit.button")
    WebElement loginBtn;

    public void loginApplication(String email,String pass){

        emailField.sendKeys(email);
        System.out.println("UserName entered : "+email );
        password.sendKeys(pass);
        System.out.println("Password entered : "+pass);
        loginBtn.click();
        System.out.println("Navigated to HomePage ");

    }







}
