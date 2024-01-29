package pages;

import entity.LoginData;
import enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import pages.screen.ScreenActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.screen.ScreenActions;

public final class LoginPage extends ScreenActions {

  @AndroidFindBy(accessibility = "test-Username")
  @iOSXCUITFindBy(accessibility = "test-Username")
  private static WebElement txtFieldUsername;

  @AndroidFindBy(accessibility = "test-Password")
  @iOSXCUITFindBy(accessibility = "test-Password")
  private static WebElement txtFieldPassword;

  @AndroidFindBy(accessibility = "test-LOGIN")
  @iOSXCUITFindBy(accessibility = "test-LOGIN")
  private static WebElement btnLogin;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
  private static WebElement errorMessage;

  public boolean isLoginPageDisplayed() {
    return isElementDisplayed(txtFieldUsername);
  }

  public LoginPage setUsername(String username) {
    enter(txtFieldUsername, username, "Username");
    return this;
  }

  public LoginPage setPassword(String password) {
    enter(txtFieldPassword, password, "Password");
    return this;
  }

  public ProductPage tapOnLogin() {
    click(btnLogin, "Login");
    return new ProductPage();
  }

  public ProductPage login(LoginData loginData) {
    setUsername(loginData.getLoginUsername())
      .setPassword(loginData.getLoginPassword())
      .tapOnLogin();

    return new ProductPage();
  }

  public String getErrorText() {
    return getText(errorMessage, WaitStrategy.VISIBLE);
  }
}
