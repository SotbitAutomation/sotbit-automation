package DangerousTests.MultiRegions;

import DangerousTests.MethodsForDangerousTests;
import MakingOrders.MethodsForMakingOrders;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MethodsForMultiRegions extends MethodsForDangerousTests {
    MethodsForMakingOrders make = new MethodsForMakingOrders();

    String nameRandomCity;
    int randomCityNumber;
    public void tryExitFromB2B(){
        try {
            exitFromB2B();
        }catch (Exception e){
            System.out.println("Я и не смог выйти, значит не авторизован, походу");
        }
    }
    public void clickButtonNo(){
        driver.findElement(By.xpath("(//*[contains(@class, 'select-city__dropdown__choose')])[last()]")).click();
    }
    public void choiceRandomCityFromList(){
        choiceNameRandomCityFromList();
        driver.findElement(By.xpath("(//*[@class='select-city__modal__list__item'])[" + randomCityNumber + "]")).click();
    }
    public void choiceNameRandomCityFromList(){
        randomCityNumber = driver.findElements(By.xpath("//*[@class='select-city__modal__list__item']")).size();
        randomCityNumber = 1 + (int) (Math.random() * randomCityNumber);
        nameRandomCity = driver.findElement(By.xpath("(//*[@class='select-city__modal__list__item'])[" + randomCityNumber + "]")).getText();
    }
    public void checkingThatChosenCityIsDisplayed(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@data-entity='select-city__block__text-city']"), nameRandomCity));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@data-entity='select-city__block__text-city']")).getText(), nameRandomCity);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-entity='select-city__block__text-city']")).isDisplayed());
    }
    public void clickOnTheMultiRegion(){
        driver.findElement(By.xpath("//*[@data-entity='select-city']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-title'][text()='Выбор города']")));
    }
    public void choiceRandomCityFromSearchHint(String nameRandomCity){
        driver.findElement(By.xpath("//*[@placeholder='Введите ваш город']")).sendKeys(nameRandomCity.substring(0, 3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".regions_vars")));
        driver.findElement(By.cssSelector(".regions_vars")).click();
        driver.findElement(By.xpath("//*[@name='submit']")).click();
    }
    public void openRandomRegionInAdminPart(){
        refreshingThisPage();
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/" , "") + "bitrix/admin/sotbit_regions.php?lang=ru&site=s1");
        int randomHamburgerMenuNumber = driver.findElements(By.xpath("//*[@class='adm-list-table-popup']")).size();
        randomHamburgerMenuNumber = 2 + (int) (Math.random() * randomHamburgerMenuNumber);
        clickElement("(//*[@class='adm-list-table-popup'])[" + randomHamburgerMenuNumber + "]");
        driver.findElement(By.xpath("//*[contains(@style, 'display: block')]//*[text()='Изменить']")).click();
        nameRandomCity = driver.findElement(By.xpath("//*[@name='NAME']")).getAttribute("value");
    }
    public void navigationToRegionSetting(){
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/" , "") + "bitrix/admin/sotbit_regions_settings.php?lang=ru&site=s1");
    }
    public void turnOffWorkingWithLocations(){
        if (driver.findElements(By.xpath("//*[@id='MODE_LOCATION'][@checked] /following::*[1]")).size() > 0){
            driver.findElement(By.xpath("//*[@id='MODE_LOCATION'] /following::*[1]")).click();
            driver.findElement(buttonSaveLocator).click();
        }
    }
    public void turnOnWorkingWithLocations(){
        if (driver.findElements(By.xpath("//*[@id='MODE_LOCATION'][@checked] /following::*[1]")).size() == 0){
            driver.findElement(By.xpath("//*[@id='MODE_LOCATION'] /following::*[1]")).click();
            driver.findElement(buttonSaveLocator).click();
        }
    }
    public void unselectAllStorages(){
        int quantityOfStorages = driver.findElements(By.xpath("//*[contains(@id, 'STORE')] //option")).size();
        for (int i = 1; i <= quantityOfStorages ; i++) {
            if (driver.findElement(By.xpath("(//*[contains(@id, 'STORE')] //option)[" + i + "]")).isSelected()){
                driver.findElement(By.xpath("(//*[contains(@id, 'STORE')] //option)[" + i + "]")).click();
            }
        }
    }
    public void selectShowingOnlyOneTESTStorage(){
        driver.findElement(By.xpath("//*[contains(@id, 'STORE')] //option[text()='TEST']")).click();
        driver.findElement(buttonSaveLocator).click();
    }
    public void unselectAllTypesOfPrices(){
        int quantityTypesOfPrices = driver.findElements(By.xpath("//*[contains(@id, 'PRICE_CODE')] /option")).size();
        for (int i = 1; i <= quantityTypesOfPrices; i++) {
            if (driver.findElement(By.xpath("(//*[contains(@id, 'PRICE_CODE')] //option)[" + i + "]")).isSelected()){
                driver.findElement(By.xpath("(//*[contains(@id, 'PRICE_CODE')] //option)[" + i + "]")).click();
            }
        }
    }
    public void choiceSmallOptTypePrice(){
        driver.findElement(By.xpath("//*[contains(@id, 'PRICE_CODE')] //option[@value='SMALL_OPT']")).click();
    }
    double basePriceOurssonGasStove;
    double displayedOptPriceForOursson;
    double displayedSmallOptPriceForOursson;


    public void setOptPricesForOurssonGasStove (){
        driver.findElement(By.xpath("//a[contains(text(), 'Плита Oursson')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        basePriceOurssonGasStove = Double.valueOf(driver.findElement(By.cssSelector("#CAT_BASE_PRICE")).getAttribute("value"));
        clearAllOptPrices();
        driver.findElement(By.xpath("//*[contains(@onchange, 'ChangePrice')]")).sendKeys(String.valueOf(basePriceOurssonGasStove-6));
        driver.findElement(By.xpath("(//*[contains(@onchange, 'ChangePrice')])[2]")).sendKeys(String.valueOf(basePriceOurssonGasStove-1));
        driver.findElement(buttonSaveLocator).click();
    }
    public void checkingThatAllOptPricesAreDisplayed (){
        displayedOptPriceForOursson = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_OPT')])[" + count + "]")).getText()));
        Assert.assertTrue(displayedOptPriceForOursson == (basePriceOurssonGasStove-6));
        displayedSmallOptPriceForOursson = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'SMALL_OPT')])[" + count + "]")).getText()));
        Assert.assertTrue(displayedSmallOptPriceForOursson == (basePriceOurssonGasStove-1));
    }
    public void addingOurssonGasStoveToTheCart(){
        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[" + count + "]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), "1"));
    }
    public void checkingThatAffordablePriceIsEqualsOptPrice (){
        pricesForAllProductsInTheFooter = Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText()));
        Assert.assertTrue(pricesForAllProductsInTheFooter == (basePriceOurssonGasStove-6));
    }
    public void checkingThatOptPriceIsNotDisplayed(){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("(//*[contains(@id, 'price_OPT')])[" + count + "]"), 0));
        displayedOptPriceForOursson = driver.findElements(By.xpath("(//*[contains(@id, 'price_OPT')])[" + count + "]")).size();
        System.out.println(count);
        System.out.println(displayedOptPriceForOursson);
        Assert.assertTrue(displayedOptPriceForOursson == 0);
    }
    public void checkingThatSmallOptPriceIsDisplayed(){
        displayedSmallOptPriceForOursson = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'SMALL_OPT')])[" + count + "]")).getText()));
        Assert.assertTrue(displayedSmallOptPriceForOursson == (basePriceOurssonGasStove-1));
    }
    public void checkingThatAffordablePriceIsEqualsSmallOpt (){
        pricesForAllProductsInTheFooter = Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText()));
        Assert.assertTrue(pricesForAllProductsInTheFooter == (basePriceOurssonGasStove-1));
    }
}