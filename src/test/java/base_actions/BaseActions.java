package base_actions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.security.SecureRandom;
import java.util.Collection;

public class BaseActions extends Config {

    public File dir = new File(System.getProperty("user.home") + "/Downloads/");
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_______________";
    static SecureRandom rnd = new SecureRandom();
    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    static final String NUMBERS = "0123456789";

    public String randomNumber(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(NUMBERS.charAt(rnd.nextInt(NUMBERS.length())));
        return sb.toString();
    }

    static final String NUMBERSWithoutZero = "123456789";

    public String randomNumberWithoutZero(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(NUMBERSWithoutZero.charAt(rnd.nextInt(NUMBERSWithoutZero.length())));
        return sb.toString();
    }

    public int randomNumberUpToFife = 1 + (int) (Math.random() * 5);
    public int randomNumberUpToTwo = 1 + (int) (Math.random() * 2);
    public int randomNumberUpToNine = 1 + (int) (Math.random() * 9);
    public int tempRandomNumber;


    public void standardConfirmationOfTheActionOnThePage() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        implicitWaiting();
    }

    By registerButtonLocator = By.xpath("//*[text()='??????????????????????']");
    public By registrationTabLocator = By.xpath("//*[text()='?????????????? ?????????????? ????????????']");
    public By loginInputLocator = By.xpath("//*[@placeholder='??????????']");
    public By passwordInputInAuthorizationTanLocator = By.xpath("//*[@placeholder='????????????']");
    public By logInButtonOnTheAuthorizationTabLocator = By.xpath("//*[text()='?????????? '][contains(@class, 'btn')]");
    By organizationsTabLocator = By.xpath("//*[contains(@class, 'nav')] //*[contains(text(), '??????????????????????')]");
    By employeesTabLocator = By.cssSelector(".icon-person");
    public By catalogTabLocator = By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='??????????????'] /span");
    By cartIconLocator = By.xpath("//*[contains(@href, 'orders/make/')][@class='nav-link']");
    public By firstHamburgerMenuOnTheOrganizationTabLocator = By.xpath("(//*[@class='main-grid-cell main-grid-cell-action'][not(ancestor-or-self::*[@hidden = 'true'])])[1]");
    public By ordersTabInTheOrganization = By.xpath("//a[contains(text(), '????????????')]");
    public By firstNameOfOrganizationOnTheOrganizationTabOrEmployeeTab = By.xpath("((//*[@class='main-grid-row main-grid-row-body'])[1] //*[@class='main-grid-cell-content'])[3]");
    public By sotbitTabLocator = By.cssSelector("#global_menu_sotbit");
    By addOrganizationButtonLocator = By.xpath("//*[contains(@class,'add_organization-button')]");


    public String name = "Name ??????" + randomString(8);
    public String lastName = "LastName ??????????????" + randomString(10);
    public String phone = "+7" + randomNumber(+10);
    public String mobilePhone = "+7495" + randomNumber(+7);
    public String password = randomString(20);
    public String passwordUser;
    public String passwordEmployee;
    public String nameCompany = "NameCompany ??????????????????????" + randomString(10);
    public String CompanyNameToJoinEmployees;
    public String iNNManual = randomNumber(14);
    public String theSameInnManual;
    public String theSameEmail;
    public String iNN = randomNumber(4);
    public String appeal = "Sir ??????????????????" + randomString(4);
    public String address = "??. ?????????????? ????. " + randomString(20);
    public String email = "test_EMail" + randomString(12) + "@mail.ru";
    public String emailUser;
    public String emailEmployee;
    public String randomData = "?????????????????? ??????????????" + randomString(20) + randomNumberUpToFife;
    public String index = randomNumber(+6);
    public String tempValue;
    public String tempValue1;
    public String tempValue2;
    public String tempValue3 = "";
    public String tempValue4;
    public String tempValue5;

    public String tempValueForEmail;
    public String tempValueForPassword;
    public int tempIntValue;
    public int tempIntValue2;
    public String tempValueForNumbers = "0";
    public boolean flag = false;
    public static boolean flagForLocation = false;
    public boolean doNeedToConfirmRegistrationUser;
    public boolean doNeedToConfirmRegistrationOrganization;
    public boolean versionsOfWorkingWithOrganizationsExtended;
    public String fileNameForConfirmRegistrationUser = "doNeedToConfirmRegistrationUser";  //?????? ???????????????????????? ?????????? ?? ?????????? ?? ????????????????
    public String fileNameForConfirmRegistrationOrganization = "doNeedToConfirmRegistrationOrganization";  //?????? ???????????????????????? ?????????? ?? ?????????? ?? ????????????????
    public String fileNameForUsersEmailsAndPasswords = "fileNameForUsersEmailsAndPasswords";  //?????? ???????????????????????? ?????????? ?? ?????????? ?? ????????????????
    public String fileNameForVersionOfWorkingWithOrganization = "fileNameForVersionOfWorkingWithOrganization";  //?????? ???????????????????????? ?????????? ?? ?????????? ?? ????????????????

    public ObjectOutputStream outputStream = null;
    public int count;
    public int countForThemeColor = 0;
    public int countColumnForMinPrice;
    public int countIP;
    public int counterOfExistingLocators = 0;
    public By buttonToGoToAdminPartLocator = By.cssSelector("#bx-panel-admin-tab");
    public By checkboxShowEmployeesOfAllOrganizations = By.xpath("//*[@class='form-check'] //*[@type = 'checkbox']");
    public By buttonAddNewEmployee = By.cssSelector("#staff-list__add-staff");
    public By buttonMakeOrderInTheCartLocator = By.xpath("//button[contains(text(), '???????????????? ??????????')]");
    public By buttonToSaveTheComponentSettingsForTheCatalog = By.cssSelector("#bx-comp-params-save-button");
    public By buttonSaveLocator = By.xpath("//*[@name='save']");
    public By buttonForMakeOrderLocatorOnTheCheckoutPage = By.cssSelector("#ORDER_CONFIRM_BUTTON");
    By settingIconLocator = By.cssSelector(".icon-cog.mr-2");
    By buttonOfHomeLocator = By.xpath("//*[@title='??????????????']");
    By calendarIconLocator = By.cssSelector(".icon-calendar2.mr-2");
    By desktopIconLocator = By.xpath("//*[@href='#desktop']");
    public By dropdownUserIcon = By.cssSelector(".dropdown-user");
    public ObjectInputStream inputStream = null;
    public String fileNameForB2BThemeColor = "fileNameForColor";  //?????? ???????????????????????? ?????????? ?? ?????????? ?? ????????????????
    public boolean themeColorBlack = true;

    public boolean flagForCloseWarningWindowThisIsTheFirstVisit = true;
    public boolean flagForRegionThisIsTheFirstVisit = true;


    public void firsNavigationToB2B() {
        driver.navigate().to(b2bUrl);
        if (flagForCloseWarningWindowThisIsTheFirstVisit) {
            flagForCloseWarningWindowThisIsTheFirstVisit = false;
            closeTheWarningWindowThatYouNeedToLogIn();
        } else {
            try {
                exitFromB2B();
                clickEnter();
                Assert.assertTrue(driver.findElement(By.cssSelector(".login-form")).isDisplayed());
            } catch (Exception e) {
                System.out.println("1 ???????? -  ?? ?? ?????? ???? ??????????????????????");
            }
        }
    }

    public By iconForClosingWarningThatYouNeedToLogInLocator = By.cssSelector(".brighttheme-icon-closer");

    public void closeTheWarningWindowThatYouNeedToLogIn() {
        try {
            driver.findElement(iconForClosingWarningThatYouNeedToLogInLocator).click();
        } catch (Exception e) {
            System.out.println("0 ???????? - ?????? ???????????? ?????????????? ???????????????????????????? ?????? ?????????? ???????????????????????????? ???? ????????!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public void choiceStandardCityInMultiRegionsWindow() {
        if (isThereModuleMultiRegions) {
            if (flagForRegionThisIsTheFirstVisit) {
                flagForRegionThisIsTheFirstVisit = false;
                try {
                    driver.findElement(By.cssSelector(".select-city__dropdown__choose")).click();
                } catch (Exception e) {
                    System.out.println("???????? - ?????? ???????????? ?????????????? ?????????????????????? ?????????????? ???????????? ???????????? (?????????? ?????????? ?????? ????????????)");
                }
            }
        }
    }

    public void navigationToAuthorizationTab() {
        firsNavigationToB2B();
        try {
            driver.navigate().to(b2bUrl);
            clickEnter();
            Assert.assertTrue(driver.findElement(By.cssSelector(".login-form")).isDisplayed());
        } catch (Exception e2) {
            try {
                System.out.println("2 ???????? - ???????????? ?????????? ?????????????????????? ???????????????????????????? ????-???? ???????????? ???????? ?? ?? ???? ?????? ??????????????????????");
                closeTheWarningWindowThatYouNeedToLogIn();
                clickEnter();
                Assert.assertTrue(driver.findElement(By.cssSelector(".login-form")).isDisplayed());
            } catch (Exception e3) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!???????????? ????????????, ?????? ???? ?????????? ???? ???????????????? ?????????? ?????????????????????? ?????? ?????????????? ????????????");
                exitFromB2B();
                clickEnter();
                Assert.assertTrue(driver.findElement(By.cssSelector(".login-form")).isDisplayed());
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector(".login-form")).isDisplayed());
    }

    public void clickEnter() {
        driver.findElement(By.xpath("//span[contains(text(),'??????????')]")).click();
    }

    public void navigationToTheSetting() {
        determineThemeColor();
        if (themeColorBlack) {
            driver.findElement(buttonOfHomeLocator).click();
        } else {
            driver.findElement(By.xpath("//*[contains(@class, 'icon-home')]")).click();
        }
        driver.findElement(settingIconLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#settings")));
    }

    public void navigationToTheCalendar() {
        determineThemeColor();
        if (themeColorBlack) {
            driver.findElement(buttonOfHomeLocator).click();
        } else {
            driver.findElement(By.xpath("//*[contains(@class, 'icon-home')]")).click();
        }
        driver.findElement(calendarIconLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'b2bcabinet-mainpage__calendar')]")));
    }

    public void navigationToTheDesktop() {
        determineThemeColor();
        if (themeColorBlack) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonOfHomeLocator));
            driver.findElement(buttonOfHomeLocator).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(desktopIconLocator));
            driver.findElement(desktopIconLocator).click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'icon-home')]")));
            driver.findElement(By.xpath("//*[contains(@class, 'icon-home')]")).click();
            driver.findElement(By.xpath("//*[@class='nav-item']/*[contains(@href, 'desktop')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#s0")));
    }

    public void doubleClick(String xpath) {
        Actions action = new Actions(driver);
        Action doubleClick = action.doubleClick(driver.findElement(By.xpath(xpath))).build();
        doubleClick.perform();
        waitingMilliSecond();
    }

    public void navigationToRegistrationTab() {
        navigationToAuthorizationTab();
        driver.findElement(registerButtonLocator).click();
        Assert.assertEquals("?????????????? ?????????????? ????????????", driver.findElement(registrationTabLocator).getText(), "?????????????? ?????????????? ?????????????? ???????????? ???? ??????????????????");
    }

    public void navigationToAdminPartFromMeanPage() {
        navigationToMeanPageByUrl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonToGoToAdminPartLocator));
        try {
            driver.findElement(buttonToGoToAdminPartLocator).click();
        } catch (Exception e) {
            scrollToTheElement("//*[@id='bx-panel-admin-tab']");
            scrollUp();
            driver.findElement(buttonToGoToAdminPartLocator).click();
        }
        try {
            driver.findElement(By.cssSelector("#global_menu_content")).click();
        } catch (Exception e) {
            System.out.println("?????????? ?????????????????????? ???????? '??????????????24'!!  ?? ???? ?? ???? ???????? ???????????? ???????????? ????-???? ????????!");
            driver.findElement(By.cssSelector("//*[contains(@class, 'network-dontshow-checkbox')]")).click();
            driver.findElement(By.cssSelector("#save")).click();
        }
    }

    public void fillingFieldsOnTheLogInTabLikeAdmin() {
        driver.findElement(loginInputLocator).sendKeys(adminLogin);
        Assert.assertEquals(adminLogin, driver.findElement(loginInputLocator).getAttribute("value"), "?????????? ???? ????????????????????????");
        driver.findElement(passwordInputInAuthorizationTanLocator).sendKeys(adminPassword);
        Assert.assertEquals(adminPassword, driver.findElement(passwordInputInAuthorizationTanLocator).getAttribute("value"), "???????????? ???? ????????????????????????");
    }

    public void fillingFieldsOnTheLogInTabLikeUser() {
        readingUserData();
        driver.findElement(loginInputLocator).sendKeys(emailUser);
        Assert.assertEquals(emailUser, driver.findElement(loginInputLocator).getAttribute("value"), "?????????? ???? ????????????????????????");
        driver.findElement(passwordInputInAuthorizationTanLocator).sendKeys(passwordUser);
        Assert.assertEquals(passwordUser, driver.findElement(passwordInputInAuthorizationTanLocator).getAttribute("value"), "???????????? ???? ????????????????????????");
        System.out.println("?????????? ???????????????????? - " + emailUser);
        System.out.println(passwordUser);
    }

    public void fillingFieldsOnTheLogInTab(String email, String password) {
        driver.findElement(loginInputLocator).sendKeys(email);
        Assert.assertEquals(email, driver.findElement(loginInputLocator).getAttribute("value"), "?????????? ???? ????????????????????????");
        driver.findElement(passwordInputInAuthorizationTanLocator).sendKeys(password);
        Assert.assertEquals(password, driver.findElement(passwordInputInAuthorizationTanLocator).getAttribute("value"), "???????????? ???? ????????????????????????");
    }


    public void fillingFieldsOnTheLogInTabLikeEmployee() {
        readingUserData();
        driver.findElement(loginInputLocator).sendKeys(emailEmployee);
        Assert.assertEquals(emailEmployee, driver.findElement(loginInputLocator).getAttribute("value"), "?????????? ???? ????????????????????????");
        driver.findElement(passwordInputInAuthorizationTanLocator).sendKeys(passwordEmployee);
        Assert.assertEquals(passwordEmployee, driver.findElement(passwordInputInAuthorizationTanLocator).getAttribute("value"), "???????????? ???? ????????????????????????");
        System.out.println("?????????? ???????????????? ???????????????????? - " + emailEmployee);
        System.out.println(passwordEmployee);
    }

    public void fillingFieldsOnTheLogInTabLikeEmployeeJustNowRegistered() {
        driver.findElement(loginInputLocator).sendKeys(email);
        Assert.assertEquals(email, driver.findElement(loginInputLocator).getAttribute("value"), "?????????? ???? ????????????????????????");
        driver.findElement(passwordInputInAuthorizationTanLocator).sendKeys(password);
        Assert.assertEquals(password, driver.findElement(passwordInputInAuthorizationTanLocator).getAttribute("value"), "???????????? ???? ????????????????????????");
    }

    public void hideTheMenu() {
        determineThemeColor();
        if (themeColorBlack) {
            if (driver.findElement(By.cssSelector(".bx-user-info-name")).isDisplayed())
                driver.findElement(By.cssSelector(".icon-transmission")).click();
        }
    }

    public void unHideTheMenu() {
        determineThemeColor();
        if (themeColorBlack) {
            if (!driver.findElement(By.cssSelector(".bx-user-info-name")).isDisplayed()) {
                driver.findElement(By.cssSelector(".icon-transmission")).click();
            }
        }
    }

    public void logInToB2B() {
        driver.findElement(logInButtonOnTheAuthorizationTabLocator).click();
        choiceStandardCityInMultiRegionsWindow();
        determineThemeColor();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swiper-wrapper")));
        if (themeColorBlack) {
            try {
                unHideTheMenu();
            } catch (Exception e) {
                navigationToMeanPageByUrl();
                Assert.assertTrue(driver.findElement(By.cssSelector(".swiper-wrapper")).isDisplayed());
                unHideTheMenu();
            }
        }
    }

    public void exitFromB2B() {
        navigationToMeanPageByUrl();
        determineThemeColor();
        if (!themeColorBlack) {
            try {
                driver.findElement(dropdownUserIcon).click();
            } catch (Exception e) {
                System.out.println("1 ???????? -  ?? ?? ???? ???????? ??????????, ???????????? ???? ??????????????????????, ????????????");
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitButtonInb2bCabinetLocator));
        driver.findElement(exitButtonInb2bCabinetLocator).click();
    }

    public void expandMenuWithUnderMenuInWhiteHat(String nameMenu) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[contains(@class, 'navbar-nav-link dropdown-toggle')]"), 3));
        for (int i = 1; i <= driver.findElements(By.xpath("//*[contains(@class, 'navbar-nav-link dropdown-toggle')]")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).getText().contains(nameMenu)) {
                driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).click();
                if (driver.findElements(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "][@aria-expanded='true']")).size() == 0) {
                    refreshingThisPage(); // ???????????????????? ???? ????????????????????, ???????????? ?????? ??????
                    driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).click();
                }
                break;
            }
        }
    }

    public void navigationToOrganizationTab() {
        determineThemeColor();
        if (!themeColorBlack) {
            expandMenuWithUnderMenuInWhiteHat("????????????????????");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(organizationsTabLocator));
        driver.findElement(organizationsTabLocator).click();
        try {
            Assert.assertTrue(driver.findElement(By.cssSelector("#PERSONAL_PROFILE_LIST")).isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()='???????????? ?????????????????????? ????????']")).isDisplayed());
        }
    }

    public void navigationToAddOrganizationTab() {
        determineWhetherVersionsOfWorkingWithOrganization();
        if (versionsOfWorkingWithOrganizationsExtended) {
            driver.findElement(By.cssSelector(".card__footer__actions-toggler")).click();
        }
        driver.findElement(addOrganizationButtonLocator).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".row.add-company__wrapper")).isDisplayed());
    }

    public void navigationToDeliveryWayByUrl() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sale_delivery_service_list.php");
    }

    public void navigationToOrdersPageInAdminPart() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sale_order.php?lang=ru");
    }

    public void navigationToPageForAddingPersonalAccountInAdminPart() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sale_account_admin.php?lang=ru");
    }

    public void navigationToEmployeesTab() {
        determineThemeColor();
        if (!themeColorBlack) {
            expandMenuWithUnderMenuInWhiteHat("????????????????????");
        }
        driver.findElement(employeesTabLocator).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#STAFF_LIST")).isDisplayed());
    }

    public void navigationToMeanPageByUrl() {
        driver.navigate().to(b2bUrl);
    }

    public void checkingThatCartIconHavePictureOfThePresenceOfOneProductInTheBasket(int numberOfProductsInTheBasket) {
        tempValueForNumbers = String.valueOf(numberOfProductsInTheBasket);
        flag = false;
        while (!flag) {
            if (driver.findElements(By.cssSelector(".b2b-notification__content")).size() > 0) {
                clickElement("//i[@class='icon-cross']");
            } else flag = true;
        }
        Assert.assertTrue(driver.findElement(By.cssSelector(".badge")).getText().equals(tempValueForNumbers), "???????????? ?????????????? ?????????????? ?? ?????????????? ???? ???????????????????? '????????????????????'");
    }

    public void resetCache() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bx-panel-clear-cache-icon")));
            clickElementByItsCssSelector("#bx-panel-clear-cache-icon");
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bx-panel-clear-cache-icon")));
            clickElementByItsCssSelector(".bx-panel-clear-cache-icon");
        }
        implicitWaiting();
        implicitWaiting();
        implicitWaiting();
        implicitWaiting();
    }

    public void navigationToCatalogTab() {
        navigationToTheRootPageOfTheCatalog();
        if (driver.findElements(By.xpath("//*[@title='????????????????????']")).size() > 0) {
            try {
                clickElement("//*[@title='????????????????????']");
            } catch (Exception e) {
                System.out.println("?????????? ????????????, ???? ???????? ???????????????? ?? ?????????????? ????????");
                clickElement("//*[@title='????????????????????']");
            }
        } else {
            clickElement("//*[@title='??????????????']");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".catalog")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".catalog")).isDisplayed());
        openingAllOffers();
        // ??????????????, ????-???? ???????? ?????????????? ?????? ????????
        hideTheMenuWhileTheBag();
    }
    public void hideTheMenuWhileTheBag(){
        if (driver.findElements(By.xpath("//*[@class='nav-item nav-item-submenu nav-item-open']")).size()>0){
            if (driver.findElement(By.xpath("//*[@class='nav-item nav-item-submenu nav-item-open']")).isDisplayed()){
                clickOnTheRightSideOfTheElement(By.xpath("(//*[@class='nav-item nav-item-submenu nav-item-open'])[last()]/*"));
                driver.findElement(By.xpath("//*[@class='nav-item nav-item-submenu nav-item-open']/*")).click();
            }
        }
    }

    public void navigationToTheRootPageOfTheCatalog() {
        navigationToMeanPageByUrl();
        determineThemeColor();
        if (!themeColorBlack) {
            expandMenuWithUnderMenuInWhiteHat("??????????????");
            driver.findElement(By.cssSelector(".show >* > .dropdown-item > span")).click();
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='breadcrumb-item'][contains(@href, 'blank_zakaza')]")));
            } catch (Exception e) {
                flagForRegionThisIsTheFirstVisit = true; //???????????? ???????????????????????????? ???????????????? ????????????
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='breadcrumb-item'][contains(@href, 'blank_zakaza')]")));
            }
            driver.findElement(By.xpath("//*[@class='breadcrumb-item'][contains(@href, 'blank_zakaza')]")).click();
        } else {
            driver.findElement(catalogTabLocator).click();
        }
        checkingBreadcrumbs("??????????????");
        checkingPageTitle("??????????????");
    }


    public void navigationToPersonalAccountTab() {
        determineThemeColor();
        if (!themeColorBlack) {
            expandMenuWithUnderMenuInWhiteHat("????????????????????");
        }
        driver.findElement(By.xpath("//*[contains(@href, 'personal/account')]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".blank_personal")).isDisplayed());
    }

    public void openingAllOffers() {
        if (areThereAnyOffers) {
            if (driver.findElements(By.cssSelector(".offers-info__label")).size() > 0) {
                for (int i = 1; i <= driver.findElements(By.xpath("//*[contains(text(), '??????????????????????:')]")).size(); i++) {
                    try {
                        driver.findElement(By.xpath("(//*[contains(text(), '??????????????????????:')])[" + i + "]")).click();
                    } catch (Exception e) {
                        System.out.println("???? ???????? ?????????????????????? ???????????????????????????? ?????? ?????????? ???? ?????????????????????? ????????????");
                        scrollToTheElement("(//*[contains(text(), '??????????????????????:')])[" + i + "]");
                        driver.findElement(By.xpath("(//*[contains(text(), '??????????????????????:')])[" + i + "]")).click();
                    }
                }
            }
        }
    }

    public void navigationToCart() {
        try {
            driver.findElement(cartIconLocator).click();
        }catch (Exception e){
            int quantityPopApWindowsThatItemWasAddedToCart = driver.findElements(By.xpath("//i[@class='icon-cross']")).size();
            for (int i = 1; i <= quantityPopApWindowsThatItemWasAddedToCart; i++) {
                try {
                    driver.findElement(By.xpath("//i[@class='icon-cross']")).click();
                } catch (Exception e2) {
                    System.out.println("???????????????????? ?????? ?????????? ???????????????? ?? ?????????????? ?????????????? ????????");
                }
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'icon-cart')]")));
        driver.navigate().to(b2bUrl + "/orders/make");
        Assert.assertTrue(driver.findElement(By.cssSelector(".basket-page")).isDisplayed());
        checkingBreadcrumbs("??????????????");


//        determineThemeColor();
//        if (!themeColorBlack) {
        //implicitWaiting();
//            flag = false;
//            while (!flag) {
//                if (driver.findElements(By.cssSelector(".b2b-notification__content")).size() > 0) {
//                    try {
//                        driver.findElement(By.xpath("//i[@class='icon-cross']")).click();
//                    } catch (Exception e) {
//                        System.out.println("???????????????????? ?????? ?????????? ???????????????? ?? ?????????????? ?????????????? ????????");
//                    }
//                } else flag = true;
//            }

//            try {
//                driver.findElement(By.xpath("//*[contains(@class, 'icon-cart')]")).click();
//            } catch (Exception e) {
//                flag = false;
//                while (!flag) {
//                    if (driver.findElements(By.cssSelector(".b2b-notification__content")).size() > 0) {
//                        driver.findElement(By.xpath("//i[@class='icon-cross']")).click();
//                    } else flag = true;
//                }
//                try {
//                    driver.findElement(By.xpath("//*[contains(@class, 'icon-cart')]")).click();
//                } catch (Exception e2) {
//                    implicitWaiting();
//                    driver.findElement(By.xpath("//*[contains(@class, 'icon-cart')]")).click();
//                }
//            }
//        } else {
//            try {
//                driver.findElement(cartIconLocator).click();
//            } catch (Exception e3) {
//                scrollToTheElement("//*[contains(@href, 'orders/make/')][@class='nav-link']");
//                driver.findElement(cartIconLocator).click();
//            }
//            Assert.assertTrue(driver.findElement(By.cssSelector(".basket-page")).isDisplayed());
//            checkingBreadcrumbs("??????????????");
//        }


    }

    public void navigationToMyOrdersPage() {
        determineThemeColor();
        if (!themeColorBlack) {
            for (int i = 1; i <= driver.findElements(By.xpath("//*[contains(@class, 'navbar-nav-link dropdown-toggle')]")).size(); i++) {
                if (driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).getText().contains("??????????")) {
                    driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '???? ????????????')][@class='dropdown-item']")));
            driver.findElement(By.xpath("//*[contains(text(), '???? ????????????')][@class='dropdown-item']")).click();
        } else {
            driver.findElement(By.xpath("//*[@title='?????? ????????????']")).click();
        }
        Assert.assertTrue(driver.findElement(By.cssSelector(".order_wrapper")).isDisplayed());
        checkingBreadcrumbs("?????? ????????????");
    }

    public void checkingBreadcrumbs(String nameBreadcrumb) {
        Assert.assertTrue(driver.findElement(By.cssSelector(".breadcrumb")).getText().contains("??????????????"));
        Assert.assertTrue(driver.findElement(By.cssSelector(".breadcrumb")).getText().contains(nameBreadcrumb));
    }

    public void checkingPageTitle(String nameTitle) {
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-title")).getText().contains(nameTitle));
    }

    public void navigationToTechnicalSupportTab() {
        determineThemeColor();
        if (!themeColorBlack) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUserIcon));
            driver.findElement(dropdownUserIcon).click();
            driver.findElement(By.xpath("//*[contains(@href,'support')][contains(@class, 'action')]")).click();
        } else {
            scrollToTheElement("//*[@class='icon-clippy']");
            driver.findElement(By.xpath("//*[@class='icon-clippy']")).click();
        }
        if (driver.findElements(By.xpath("//*[contains(@class,'page-title')]/*[text()='???????????? ??????????????????']")).size() > 0) {
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'page-title')]/*[text()='???????????? ??????????????????']")).isDisplayed());
        } else {
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@href, 'support')][contains(@class, 'btn_b2b')]")).isDisplayed());
        }
    }

    public void implicitWaiting() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitingMilliSecond() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)"); //jse.executeScript("scroll(0, -250);");
    }

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250);"); //jse.executeScript("window.scrollBy(0,250)");
    }

    public void scrollDownMax() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);"); //jse.executeScript("window.scrollBy(0,250)");
    }

//    public void scrollUpToTheElement(String xpath) {
//        boolean elemIsDisplayed = false;
//        while (!elemIsDisplayed) {
//            scrollUp();
//            if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
//                elemIsDisplayed = true;
//            }
//        }
//    }
//    public void scrollUpToTheElement(By locator) {
//        boolean elemIsDisplayed = false;
//        while (!elemIsDisplayed) {
//            scrollUp();
//            if (driver.findElement(locator).isDisplayed()) {
//                elemIsDisplayed = true;
//            }
//        }
//    }
//    public void scrollUpToTheElementByCss(String cssSelector) {
//        boolean elemIsDisplayed = false;
//        while (!elemIsDisplayed) {
//            scrollUp();
//            if (driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
//                elemIsDisplayed = true;
//            }
//        }
//    }

        public void scrollToTheElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            implicitWaiting();
        } catch (Exception e) {
            scrollDownMax();
            implicitWaiting();
        }
    }


    public void scrollToTheElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        implicitWaiting();
    }

    public void scrollToTheElementByCss(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        implicitWaiting();
    }


    public void fileDownload() {
        By fileInput = By.cssSelector("input[type=file]");
        String filePath = System.getProperty("user.dir") + "\\resources\\palms.jpg";
        driver.findElement(fileInput).sendKeys(filePath);
    }

    public void downloadingALargeFile() {
        By fileInput = By.cssSelector("input[type=file]");
        String filePath = System.getProperty("user.dir") + "\\resources\\largeFile.jpg";
        driver.findElement(fileInput).sendKeys(filePath);
    }

    public void confirmRegistrationOfOrganizationFromAdmin() {
        System.out.println(nameCompany);
        determineWhetherRegistrationOrganizationNeedsToBeConfirmed();
        if (doNeedToConfirmRegistrationOrganization) {
            navigationToAdminPartFromMeanPage();
            driver.findElement(By.cssSelector("#global_menu_sotbit")).click();
            approveTheRegistrationOfTheLastOrganization(nameCompany);
            navigationToMeanPageByUrl();
        }
    }

    public void navigationToRegistrationOrganizationsTableFromAdminPart() {
        try {
            driver.findElement(By.xpath("//*[text()='?????????????????????????? ?????????????????????? (?????????????????????? ??????????)']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//*[text()='?????????????? ????????????????????']")).click();
            driver.findElement(By.xpath("//*[contains(text(),'?????????????????????????? ??????????????????????')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#digitalwand_admin_helper_sotbit_auth_company_confirm")));
    }

    public void approveTheRegistrationOfTheLastOrganization(String nameCompany) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='?????????????????????????? ?????????????????????? (?????????????????????? ??????????)']")));
            driver.findElement(By.xpath("//*[text()='?????????????????????????? ?????????????????????? (?????????????????????? ??????????)']")).click();
        } catch (Exception e) {
            System.out.println("???????? ???????????? '?????????????????????????? ?????????????????????? (?????????????????????? ??????????)' ???????? ????????????");
            try {
                driver.findElement(By.xpath("//*[text()='?????????????? ????????????????????']")).click();
                driver.findElement(By.xpath("//*[contains(text(),'?????????????????????????? ??????????????????????')]")).click();
            } catch (Exception e2) {
                driver.findElement(By.xpath("//*[text()='?????????????????????? ??????????????????????']")).click();
                driver.findElement(By.xpath("//*[text()='?????????????? ????????????????????']")).click();
                driver.findElement(By.xpath("//*[contains(text(),'?????????????????????????? ??????????????????????')]")).click();
            }
        }
        int columnWithDataAboutOrganization = driver.findElements(By.xpath("//*[@class='adm-list-table-row'] /*[@class='adm-list-table-cell'][3]")).size();
        for (int i = 1; i <= columnWithDataAboutOrganization; i++) {
            if (driver.findElement(By.xpath("(//*[@class='adm-list-table-row'] /*[@class='adm-list-table-cell'][3])[" + i + "]")).getText().contains(nameCompany)) {
                count = i;
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#digitalwand_admin_helper_sotbit_auth_company_confirm")));
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='adm-list-table-row'] /*[@class='adm-list-table-cell'][3])[" + count + "]")).getText().contains(nameCompany));
        driver.findElement(By.xpath("(//*[@class='adm-designed-checkbox-label adm-checkbox'])[" + count + "]")).click();
        driver.findElement(By.cssSelector("#digitalwand_admin_helper_sotbit_auth_company_confirm_action")).click();
        driver.findElement(By.xpath("//*[text()='????????????????']")).click();
        driver.findElement(By.xpath("//*[@value='??????????????????']")).click();
    }

    public void confirmRegistrationOfOrganizationInB2bFromTheUser() {
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        confirmRegistrationOfOrganizationFromAdmin();
    }

    public void tryConfirmRegistrationOfOrganizationInB2bFromTheUser() {
        determineWhetherRegistrationOrganizationNeedsToBeConfirmed();
        if (doNeedToConfirmRegistrationOrganization) {
            confirmRegistrationOfOrganizationInB2bFromTheUser();
        }
    }

    public void sortingOrganizationByDecrease() {
        clickElement("//*[text()='??????'][@class='main-grid-head-title']");
        implicitWaiting();//???????????? ??????????????????????????, ???? ???????????????????????? ???????????? ??????-????
        int numberOfOrganizations = driver.findElements(By.xpath("//tbody //*[@class='main-grid-row main-grid-row-body']")).size();
        if (numberOfOrganizations > 1) {
            int comparedNumber;
            int nextNumberAfterComparedNumber;
            count = 0;
            flag = false;
            while (!flag) {
                flag = true;
                for (int i = 1; i < numberOfOrganizations; i++) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By
                            .xpath("((//tbody /*[@class='main-grid-row main-grid-row-body'])[" + i + "] //*[@class='main-grid-cell-content'])[2]")));
                    try {
                        comparedNumber = Integer.parseInt(driver.findElement(By
                                .xpath("((//tbody /*[@class='main-grid-row main-grid-row-body'])[" + i + "] //*[@class='main-grid-cell-content'])[2]")).getText());
                    } catch (Exception e) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ?????????? ???????????? ?????? ????????????????????, ???? ?????????? ???????????????? -  " + i);
                        waitingMilliSecond();
                        comparedNumber = Integer.parseInt(driver.findElement(By
                                .xpath("((//tbody /*[@class='main-grid-row main-grid-row-body'])[" + i + "] //*[@class='main-grid-cell-content'])[2]")).getText());
                    }
                    try {
                        nextNumberAfterComparedNumber = Integer.parseInt(driver.findElement(By
                                .xpath("((//tbody /*[@class='main-grid-row main-grid-row-body'])[" + (i + 1) + "] //*[@class='main-grid-cell-content'])[2]")).getText());
                    } catch (Exception e2) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ?????????? ???????????? 2 ?????? ????????????????????, ???? ?????????? ???????????????? -  " + i);
                        waitingMilliSecond();
                        nextNumberAfterComparedNumber = Integer.parseInt(driver.findElement(By
                                .xpath("((//tbody /*[@class='main-grid-row main-grid-row-body'])[" + (i + 1) + "] //*[@class='main-grid-cell-content'])[2]")).getText());
                    }
                    if (comparedNumber < nextNumberAfterComparedNumber) {
                        count++;
                        if (count > 100) {
                            System.out.println(5 / 0);
                        }
                        flag = false;
                        clickElement("//*[text()='??????'][@class='main-grid-head-title']");
                        implicitWaiting();
                    }
                }
            }
        }


//        driver.findElement(By.xpath("//*[text()='??????'][@class='main-grid-head-title']")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='??????'][@class='main-grid-head-title']")));
//        waitingMilliSecond();
//        clickElement("//*[text()='??????'][@class='main-grid-head-title']");
//        implicitWaiting(); //????-???? ???????? (???????????????????? ?????? ????????????) ?????????????? ?????? ??????????
//        if (driver.findElements(By.xpath("//*[contains(@class, 'sort-desc')]")).size() == 0) {
//            try {
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'sort-asc')]")));
//                driver.findElement(By.xpath("//*[contains(@class, 'sort-asc')]")).click();
//            } catch (Exception e) {
//                System.out.println("?????? ??????????????????????????");
//            }
//            implicitWaiting();
//        }
    }

    public void checkingThatOrganizationsIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#PERSONAL_PROFILE_LIST")).isDisplayed());
    }

    public void checkingThatOrganizationIsConfirmed() {
        navigationToOrganizationTab();
        determineWhetherRegistrationOrganizationNeedsToBeConfirmed();
        if (doNeedToConfirmRegistrationOrganization) {
            sortingOrganizationByDecrease();
            waitingMilliSecond();
            try {
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//*[@class='main-grid-row main-grid-row-body'])[1] /*[7]"), "????????????????"));
            } catch (Exception e) {
                if (driver.findElements(By.xpath("//*[@class='main-ui-pagination-arrow']")).size() > 0) {
                    clickElement("//*[@class='main-ui-pagination-arrow']");
                }
                driver.findElement(By.xpath("//*[@class='main-grid-head-title'][text()='??????']")).click();
                sortingOrganizationByDecrease();
                waitingMilliSecond();
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//*[@class='main-grid-row main-grid-row-body'])[1] /*[7]"), "????????????????"));
            }
            Assert.assertEquals(driver.findElement(By.xpath("(//*[@class='main-grid-row main-grid-row-body'])[1] /*[7]")).getText(), "????????????????");
        } else {
            System.out.println("???????????????? ??????. ???? ??????????");
        }
    }

    public void deletingExcelAndJpgFilesFromDownloads() {
        String[] str = {"xlsx"};
        Collection<File> files = FileUtils.listFiles(dir, str, true);
        for (File f : files) {
            f.delete();
        }
        String[] image = {"jpg"};
        Collection<File> filesImage = FileUtils.listFiles(dir, image, true);
        for (File f : filesImage) {
            f.delete();
        }
    }

    public boolean isFileDownloaded_Ext(String dirPath, String ext) {
        boolean flag = false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }
        for (int i = 0; i <= files.length - 1; i++) {
            if (files[i].getName().contains(ext)) {
                flag = true;
            }
        }
        return flag;
    }


    public void determineWhetherRegistrationUserNeedsToBeConfirmed() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream("currentSettingsB2B\\" + fileNameForConfirmRegistrationUser)); //?????? ?????????? ?? ????????????????
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            doNeedToConfirmRegistrationUser = (boolean) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("?????????? ???????????????????????? ??????????????????????? - " + doNeedToConfirmRegistrationUser);
    }

    public void determineWhetherVersionsOfWorkingWithOrganization() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream("currentSettingsB2B\\" + fileNameForVersionOfWorkingWithOrganization)); //?????? ?????????? ?? ????????????????
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            versionsOfWorkingWithOrganizationsExtended = (boolean) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("???????????? ???????????? ?? ???????????????????? ?????????????????????? - " + versionsOfWorkingWithOrganizationsExtended);
    }

    public void determineWhetherRegistrationOrganizationNeedsToBeConfirmed() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream("currentSettingsB2B\\" + fileNameForConfirmRegistrationOrganization)); //?????? ?????????? ?? ????????????????
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            doNeedToConfirmRegistrationOrganization = (boolean) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("?????????? ???????????????????????? ?????????????????????? ??????????????????????? - " + doNeedToConfirmRegistrationOrganization);
    }

    public void readingUserData() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream("currentSettingsB2B\\" + fileNameForUsersEmailsAndPasswords)); //?????? ?????????? ?? ????????????????
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            emailUser = (String) inputStream.readObject();
            passwordUser = (String) inputStream.readObject();
            emailEmployee = (String) inputStream.readObject();
            passwordEmployee = (String) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String replacingSomeSymbols(String stringForReplace) {
        stringForReplace = stringForReplace.replaceAll("??????.", "");
        return stringForReplace = stringForReplace.replaceAll("[\\$, ,???,' ',???]", "");
    }

    public String replacingBracketsAndNumbers(String stringForReplace) {
        stringForReplace = stringForReplace.replaceAll("[1-9]", "");
        return stringForReplace = stringForReplace.replaceAll("\\p{P}", "");
    }

    public void navigationToTablesFromAdmin() {
        driver.findElement(By.xpath("//*[contains(@class,'adm-main-menu')][text()='??????????????????']")).click();
        try {
            driver.findElement(By.xpath("//*[contains(@class,'adm-submenu')][text()='??????????????']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//*[contains(@class,'adm-submenu')][text()='????????????????????????????????????']")).click();
            driver.findElement(By.xpath("//*[contains(@class,'adm-submenu')][text()='??????????????']")).click();
        }
    }

    public void navigationToTheEventTableFromAdminMeanPage() {
        driver.findElement(buttonToGoToAdminPartLocator).click();
        navigationToTheEventTableFromAdmin();
    }

    public void navigationToTheEventTableFromAdmin() {
        navigationToTablesFromAdmin();
        driver.findElement(By.xpath("//*[text()='b_event']")).click();
        if (driver.findElements(By.xpath("(//*[@class='adm-nav-page'])[1]")).size() > 0) {
            if (driver.findElement(By.xpath("(//*[@class='adm-nav-page'])[1]")).getText().equals("1")) {
                driver.findElement(By.xpath("(//*[@class='adm-nav-page'])[1]")).click();
                implicitWaiting();
            }
        }
        sortingEventsByDecrease();
    }

    public void sortingEventsByDecrease() {
        try {
            driver.findElement(By.cssSelector(".adm-list-table-cell-sort-up")).click(); //???????????????????? ???? ???????????????? ??????????????
            implicitWaiting();
        } catch (Exception e) {
            System.out.println("?????????????? ?????? ??????????????????????????");
        }
    }

    public void determineWhetherLocationWhileRegistration() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream("currentSettingsB2B\\" + "doNeedToSpecifyLocation")); //?????? ?????????? ?? ????????????????
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            flagForLocation = (boolean) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("???????? ???? ?????????? ???????????????????????????? - " + flagForLocation);
    }



//    public void enableEditMode() {
//        driver.findElement(By.cssSelector("#bx-panel-toggle-indicator")).click();
//        implicitWaiting();
//        expandTheControlPanel();
//    }

    public void turnOffEditMode() {
        try {
            waitElementVisible("//*[@id='bx-panel']");
            waitElementVisible("//*[contains(@href, 'bitrix_include_areas=N')][@id='bx-panel-toggle'] //*[@id='bx-panel-toggle-icon']");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href, 'bitrix_include_areas=N')][@id='bx-panel-toggle'] //*[@id='bx-panel-toggle-icon']")));
            driver.findElement(By.xpath("//*[contains(@href, 'bitrix_include_areas=N')][@id='bx-panel-toggle'] //*[@id='bx-panel-toggle-icon']")).click();
            implicitWaiting();
        } catch (Exception e) {
            System.out.println("?????????? ???????????? ?????? ????????????????");
        }
    }

    public void turnOnEditMode() {
        try {
            waitElementVisible("//*[@id='bx-panel']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@href, 'bitrix_include_areas=Y')][@id='bx-panel-toggle']")));
            driver.findElement(By.xpath("//*[contains(@href, 'bitrix_include_areas=Y')][@id='bx-panel-toggle']")).click();
            implicitWaiting();
        } catch (Exception e) {
            System.out.println("?????????? ???????????? ?????? ??????????????");
        }
    }


    public void saveBasicData(int numberOfSetting) {
        System.out.println(numberOfSetting);
        scrollToTheElement("(//*[contains(@name, 'save')])[" + numberOfSetting + "]");
        driver.findElement(By.xpath("(//*[contains(@name, 'save')])[" + numberOfSetting + "]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
    }

    public void refreshingThisPage() {
        driver.navigate().refresh();
    }

    public void hoveringTheCursorOverTheElement(By xpathLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(xpathLocator));
        action.perform();
        implicitWaiting();
        implicitWaiting();
    }

    public void determineThemeColor() {
        if (countForThemeColor == 0) {
            try {
                inputStream = new ObjectInputStream(new FileInputStream("currentSettingsB2B\\" + fileNameForB2BThemeColor)); //?????? ?????????? ?? ????????????????
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                themeColorBlack = (boolean) inputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("???????????? ???? ???????????? ?????????? - " + themeColorBlack);
            countForThemeColor++;
        }
    }
    public void clickOnTheRightSideOfTheElement(By locator) {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            action.moveToElement(driver.findElement(locator), 5, 15).click().build().perform();
        } catch (Exception e) {
            System.out.println(locator);
            scrollToTheElement(locator);
            action.moveToElement(driver.findElement(locator), 5, 15).click().build().perform();
        }
    }

    public void disclosureOfASubcategories(String xpathThisCategory) {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathThisCategory)));
        try {
            action.moveToElement(driver.findElement(By.xpath(xpathThisCategory)), 5, 15).click().build().perform();
        } catch (Exception e) {
            System.out.println(xpathThisCategory);
            scrollToTheElement(xpathThisCategory);
            action.moveToElement(driver.findElement(By.xpath(xpathThisCategory)), 5, 15).click().build().perform();
        }
    }

    public void expandTheNeededNavigationMenu(String nameOfTheMenuForOpen) {
        determineThemeColor();
        if (!themeColorBlack) {
            for (int i = 1; i <= driver.findElements(By.xpath("//*[contains(@class, 'navbar-nav-link dropdown-toggle')]")).size(); i++) {
                if (driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).getText().contains(nameOfTheMenuForOpen)) {
                    driver.findElement(By.xpath("(//*[contains(@class, 'navbar-nav-link dropdown-toggle')])[" + i + "]")).click();
                    break;
                }
            }
        }
    }

    public void navigationToBasicB2BSettings() {
        implicitWaiting();
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "/bitrix/admin/sotbit.b2bcabinet_settings.php?lang=ru&site=s1");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tabControl_layout")));
        }catch (Exception e){
            driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "/bitrix/admin/sotbit.b2bcabinet_settings.php?lang=ru&site=s1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tabControl_layout")));
        }
    }

    public void navigationToGeneralB2BSettings() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sotbit.auth_settings.php?lang=ru");
    }

    public String waitElementVisible(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return xpath;
    }

    public String waitElementInVisible(String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        return xpath;
    }

    public String waitClearingCash(String xpath) {
        new WebDriverWait(driver,100).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        return xpath;
    }

    public void navigationToTheSiteSettings() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sotbit.auth_settings.php?lang=ru&site=s1");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bx-admin-prefix")));
        } catch (Exception e) {
            driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sotbit.auth_settings.php?lang=ru&site=s1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bx-admin-prefix")));
        }
    }

    public void clickStandardButtonForSaveSettings() {
        try {
            driver.findElement(buttonSaveLocator).click();
        } catch (Exception e) {
            System.out.println("???? ???????????????????? ?????? ???? ???????????? ??????????????????");
            scrollToTheElement(buttonSaveLocator);
            driver.findElement(buttonSaveLocator).click();
        }
    }

    public void clickElement(String elementXpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            driver.findElement(By.xpath(elementXpath)).click();
        } catch (Exception e) {
            System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????? ???? ????????");
            scrollToTheElement(elementXpath);
            waitingMilliSecond();
            try {
                driver.findElement(By.xpath(elementXpath)).click();
            } catch (Exception e2) {
                System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????? ??????????");
                scrollUp();
                waitingMilliSecond();
                try {
                    driver.findElement(By.xpath(elementXpath)).click();
                } catch (Exception e3) {
                    System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????????? ????????????????");
                    refreshingThisPage();
                    try {
                        driver.findElement(By.xpath(elementXpath)).click();
                    } catch (Exception e4) {
                        System.out.println("?????????? ???????????????????????????????????????? ????????????, ???????????? ?????????????? ????");
                        driver.findElement(By.cssSelector(".select-city__dropdown__choose")).click();
                        driver.findElement(By.xpath(elementXpath)).click();
                    }
                }
            }
        }
    }

    public void clickElement(By elementLocator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            waitingMilliSecond();
            driver.findElement(elementLocator).click();
        } catch (Exception e) {
            System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????? ???? ????????");
            scrollToTheElement(elementLocator);
            waitingMilliSecond();
            try {
                driver.findElement(elementLocator).click();
            } catch (Exception e2) {
                System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????? ??????????");
                scrollUp();
                waitingMilliSecond();
                try {
                    driver.findElement(elementLocator).click();
                } catch (Exception e3) {
                    System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????????? ????????????????");
                    refreshingThisPage();
                    driver.findElement(elementLocator).click();
                }
            }
        }
    }

    public void clickElementByItsCssSelector(String cssSelector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            driver.findElement(By.cssSelector(cssSelector)).click();
        } catch (Exception e) {
            System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????? ???? ????????");
            scrollToTheElementByCss(cssSelector);
            waitingMilliSecond();
            try {
                driver.findElement(By.cssSelector(cssSelector)).click();
            } catch (Exception e2) {
                System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????? ??????????");
                scrollUp();
                waitingMilliSecond();
                try {
                    driver.findElement(By.cssSelector(cssSelector)).click();
                } catch (Exception e3) {
                    System.out.println("???? ???????? ???????????????? ???? ????????????????, ???????????? ?????????????????????????? ????????????????");
                    refreshingThisPage();
                    driver.findElement(By.cssSelector(cssSelector)).click();
                }
            }
        }
    }


}
