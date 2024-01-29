package pages;

import driver.manager.DriverManager;
import pages.screen.ScreenActions;

public final class GoogleSearchResultPage extends ScreenActions {

  public String getSearchResultsPageTitle() {
    return DriverManager.getDriver().getTitle();
  }

}
