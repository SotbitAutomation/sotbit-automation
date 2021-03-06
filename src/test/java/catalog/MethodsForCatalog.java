package catalog;

import base_actions.BaseActions;
import documents.MethodsForDocuments;
import organizations_with_extended_version.MethodsForAddingOrganizationsWithExtendedVersion;
import registration_and_authorization.RegistrationB2B;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class MethodsForCatalog extends BaseActions {
    MethodsForAddingOrganizationsWithExtendedVersion org = new MethodsForAddingOrganizationsWithExtendedVersion();

    RegistrationB2B registr = new RegistrationB2B();
    public int numberOfProductsPerPage = 0;
    public int randomProductNumberOnThePage = 0;
    public int randomNumberPage = 0;
    public double quantityOfProductsInStock = 0;
    public double quantityOfSecondProductsInStock = 0;
    public double randomNumberUpToMAxQuantityThisProducts = 0;
    public double basePriceRandomProduct = 0;
    public double sumOfPricesOfTheAddedProducts = 0;
    public double sumOfPricesOfTheAddedProductsWithTheCostOfDelivery = 0;
    public double priceForNewlyAddedProducts = 0;
    public double pricesForAllProductsInTheFooter = 0;
    public double pricesForAllProductsInTheCartPAge = 0;
    //public int numberOfProductsInTheFooter = 0;
    public int numberOfProductsInTheFooter = 0;
    double unitsOfMeasurement = 0;
    double coefficientForQuantityOfProducts = 0;
    public String tempString;
    String tempString2 = "0.1 шт";
    public int tempInt = 0;
    public int tempInt2 = 0;
    public int tempInt3 = 0;
    public double tempDouble = 0;
    public double tempDouble2 = 0;
    public double numberOfAvailableGefestGasStove;
    public double numberOfAvailableKaiserGasStove;
    public double tempDouble3 = 0;
    public double tempDouble4 = 0;
    public double tempDouble5 = 0;
    String maxPriceForFiltering = "10000";
    String minPriceForFiltering = "3000";
    public By quantityFieldOfGefestLocator = By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']");
    public By iconPlusOfGefestLocator = By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-plus']");
    public By iconMinusOfGefestLocator = By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-minus']");

    public By quantityFieldOfKaiserLocator = By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']");
    public By iconPlusOfKaiserLocator = By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-plus']");
    public By iconMinusOfKaiserLocator = By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-minus']");

    public By quantityFieldOfRandomTPLocator = By.xpath("//*[@data-entity ='basket-item-quantity-field']");
    public By iconPlusOfRandomTPLocator = By.xpath("//*[@data-entity ='basket-item-quantity-plus']");
    public By iconMinusOfRandomTPLocator = By.xpath("//*[@data-entity ='basket-item-quantity-minus']");

    public By quantityFieldOfTPWithAFractionalCoefficientLocator = By.xpath("(//*[@data-entity ='basket-item-quantity-field'])[1]");
    public By iconPlusOfTPWithAFractionalCoefficientLocator = By.xpath("(//*[@data-entity ='basket-item-quantity-plus'])[1]");
    public By iconMinusOfTPWithWithAFractionalCoefficientLocator = By.xpath("(//*[@data-entity ='basket-item-quantity-minus'])[1]");

    public By quantityFieldOfTPWithQuantitativeAccountingDisabledLocator = By.xpath("(//*[@data-entity ='basket-item-quantity-field'])[2]");
    public By iconPlusOfTPWithQuantitativeAccountingDisabledLocator = By.xpath("(//*[@data-entity ='basket-item-quantity-plus'])[2]");
    public By iconMinusOfTPWithQuantitativeAccountingDisabledLocator = By.xpath("(//*[@data-entity ='basket-item-quantity-minus'])[2]");

    public By priceForFirstProductInCart = By.xpath("((//*[@class='basket__column-price-wrap'])[1] /span)[1]");
    public By priceForSecondProductInCart = By.xpath("(//*[@class='basket__column-price-wrap'] /span)[last()-1]");

    //public String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    public By checkboxThatHighlightsAllProductsInTheCartLocator = By.xpath("//*[@data-entity='basket-gruope-item-checkbox']");
    public By buttonForDeletingProductsInCartLocator = By.xpath("//*[@data-entity='basket-groupe-item-delete']");
    public By iconCatalogLocator = By.xpath("//*[contains(@class, 'nav-item nav-item-submenu')] /*[contains(@href, 'blank_zakaza')]");





    public void changeTheQuantityOfRandomProduct() {
        determiningNumberOfProductsOnThePage();
        determiningRandomProduct();
        calculationOfTheCoefficientForNonPieceProducts();
        determiningRandomNumberUpToMAxQuantityThisProducts();
        numberOfProductsInTheFooter = Integer.parseInt(driver.findElement(By.id("catalog__basket-quantity-value")).getText());
        System.out.println("Ввожу такое кол-во товара - " + randomNumberUpToMAxQuantityThisProducts);
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]")).clear();
        waitingMilliSecond();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .sendKeys(String.valueOf(randomNumberUpToMAxQuantityThisProducts));
        numberOfProductsInTheFooter++;
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
    }

    public void changeTheQuantityOfRandomProductUsingIconPlus() {
        determiningNumberOfProductsOnThePage();
        determiningRandomProduct();
        calculationOfTheCoefficientForNonPieceProducts();
        determiningRandomNumberUpToMAxQuantityThisProducts();
        numberOfProductsInTheFooter = Integer.parseInt(driver.findElement(By.id("catalog__basket-quantity-value")).getText());
        for (int i = 1; i <= randomNumberUpToMAxQuantityThisProducts; i++) {
            if (quantityOfProductsInStock * coefficientForQuantityOfProducts < 40) {
                clickElement("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]");
                double tempQuantityItems;
                int tempCountForBreak = 0;
                double expectedTempQuantityItems;
                flag = false;
                while (!flag) {
                    tempCountForBreak++;
                    expectedTempQuantityItems = i / coefficientForQuantityOfProducts;
                    tempQuantityItems = Double.valueOf(driver.findElement(By.xpath("(//*[contains(@id, 'quantity-value')])[" + randomProductNumberOnThePage + "]")).getAttribute("value"));
                    if (tempQuantityItems == expectedTempQuantityItems) {
                        flag = true;
                    }
                    if (tempCountForBreak > 10) {
                        try {
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]")));
                            clickElement("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]");
                            implicitWaiting();
                            implicitWaiting();
                            tempQuantityItems = Double.valueOf(driver.findElement(By.xpath("(//*[contains(@id, 'quantity-value')])[" + randomProductNumberOnThePage + "]")).getAttribute("value"));
                            Assert.assertTrue(tempQuantityItems == expectedTempQuantityItems);
                        }catch (Exception e){
                            System.out.println("!!!!!!!!!!!!!!!!!!!!! клик не защитался ");
                            clickElement("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]");
                            implicitWaiting();
                            implicitWaiting();
                            tempQuantityItems = Double.valueOf(driver.findElement(By.xpath("(//*[contains(@id, 'quantity-value')])[" + randomProductNumberOnThePage + "]")).getAttribute("value"));
                            Assert.assertTrue(tempQuantityItems == expectedTempQuantityItems);
                        } // иногда клик не защитывается
                    }
                }
                waitingMilliSecond();
            } else {
                driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                        .sendKeys(String.valueOf(randomNumberUpToMAxQuantityThisProducts));
                i = (int) (randomNumberUpToMAxQuantityThisProducts * coefficientForQuantityOfProducts) + 1;
                break;
            }
        }
        numberOfProductsInTheFooter++;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
    }

    public void addingTheMaxNumberOfProductsToTheCart() {
        determiningNumberOfProductsOnThePage();
        determiningRandomProduct();
        calculationOfTheCoefficientForNonPieceProducts();
        determiningRandomNumberUpToMAxQuantityThisProducts();
        numberOfProductsInTheFooter = Integer.parseInt(driver.findElement(By.id("catalog__basket-quantity-value")).getText());
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]")).clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .sendKeys(String.valueOf(quantityOfProductsInStock));
        priceForNewlyAddedProducts = basePriceRandomProduct * quantityOfProductsInStock;
        randomNumberUpToMAxQuantityThisProducts = quantityOfProductsInStock;
        numberOfProductsInTheFooter++;
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        implicitWaiting();
    }

    public void addingTheMaxNumberOfProductsToTheCartUsingIconPlus() {
        determiningNumberOfProductsOnThePage();
        determiningRandomProduct();
        calculationOfTheCoefficientForNonPieceProducts();
        determiningRandomNumberUpToMAxQuantityThisProducts();

        numberOfProductsInTheFooter = Integer.parseInt(driver.findElement(By.id("catalog__basket-quantity-value")).getText());
        for (int i = 0; i < quantityOfProductsInStock * coefficientForQuantityOfProducts; i++) {
            if (quantityOfProductsInStock * coefficientForQuantityOfProducts < 500) {
                clickElement("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]");
                waitingMilliSecond();
            } else {
                clickElement("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]");
                driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                        .sendKeys(String.valueOf(quantityOfProductsInStock));
                i = (int) (quantityOfProductsInStock * coefficientForQuantityOfProducts) + 1;
                break;
            }
        }
        waitingMilliSecond();
        waitingMilliSecond();
        priceForNewlyAddedProducts = basePriceRandomProduct * quantityOfProductsInStock;
        randomNumberUpToMAxQuantityThisProducts = quantityOfProductsInStock;
        numberOfProductsInTheFooter++;
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
    }

    public void determiningRandomProduct() {
        count = 0;
        flag = false;
        while (!flag) {
            tempInt = 1 + (int) (Math.random() * numberOfProductsPerPage);
            count++;
            if (count > 50) {
                break;
            }
            tempValue2 = driver.findElement(By.xpath("(//*[@class='item-quantity__general'])[" + tempInt + "]")).getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            Double quantitySelectedProduct = Double.valueOf(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + tempInt + "]")).getAttribute("value"));
            if (tempValue2 != null && !tempValue2.trim().isEmpty() && quantitySelectedProduct == 0) {
                if (Double.valueOf(tempValue2) > 0) {
                    flag = true;
                    tempDouble = Double.valueOf(tempValue2);
//                    try {
//                        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[" + tempInt + "]")).click();
//                        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter + 1)));
//                        flag = true;
//                        tempDouble = Double.valueOf(tempValue2);
//                        driver.findElement(By.xpath("(//*[@class='quantity-selector__decrement'])[" + tempInt + "]")).click();
//                        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
//                    } catch (Exception e) {
//                    }
                }
            }
        }

        if (randomProductNumberOnThePage == tempInt) {
            System.out.println("Выбрант товар тот же товар как и в прошлый раз. выбираю след за ним");
//            driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[" + tempInt + "]")).click();
//            implicitWaiting();
            randomProductNumberOnThePage = tempInt + 1;
        } else {
            randomProductNumberOnThePage = tempInt;
        }
        if (randomProductNumberOnThePage == numberOfProductsPerPage + 1) {
            randomProductNumberOnThePage = randomProductNumberOnThePage - 2;
            System.out.println("Кол-во доступных товаров взято у предыдущего товара, ошибка из-за этого бывает редко, по этому не обрабатываю этот случай");
        }            //Рандомной номер от 1 до (кол-во продуктов на странице), но не равный предыдущему рандомному продукту

        System.out.println("Выбран товар №_" + randomProductNumberOnThePage);
    }

    public void determiningRandomNumberUpToMAxQuantityThisProducts() {
        System.out.println("В наличии = " + tempDouble);
        quantityOfProductsInStock = tempDouble;
        randomNumberUpToMAxQuantityThisProducts = 1 + (int) (Math.random() * quantityOfProductsInStock * coefficientForQuantityOfProducts);
        randomNumberUpToMAxQuantityThisProducts = (double) (randomNumberUpToMAxQuantityThisProducts / coefficientForQuantityOfProducts);
        System.out.println("Ввожу такое кол-во товара - " + randomNumberUpToMAxQuantityThisProducts);
    }

    public void calculationOfTheCoefficientForNonPieceProducts() {
        String unitOfMeasurementOfARandomProduct = driver.findElement(By.xpath("(//*[contains(@class, 'roperty--measure')])[" + randomProductNumberOnThePage + "]")).getText();
        numberOfProductsInTheFooter = Integer.parseInt(driver.findElement(By.id("catalog__basket-quantity-value")).getText());
        if (!areThereAnyOffers && unitOfMeasurementOfARandomProduct.equals("шт")) {
            coefficientForQuantityOfProducts = 1;
        } else {
            clickElement("(//*[@class='quantity-selector__increment'])[" + randomProductNumberOnThePage + "]");
            try {
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter + 1)));
            } catch (Exception e) {
                System.out.println("C первого раза не кликнулось");
                driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[" + randomProductNumberOnThePage + "]")).click();
                System.out.println("Ожидаю кол-во позицый в футере каталога - " + (numberOfProductsInTheFooter + 1));
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter + 1)));
            }
            implicitWaiting();

            if (Double.valueOf(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]")).getAttribute("value"))
                    == 0.1) {
                unitsOfMeasurement = 0.1;
            } else {
                unitsOfMeasurement = 1;
            }
            driver.findElement(By.xpath("(//*[@class='quantity-selector__decrement'])[" + randomProductNumberOnThePage + "]")).click();
            coefficientForQuantityOfProducts = 1 / unitsOfMeasurement;
            driver.findElement(By.xpath("(//*[@class='quantity-selector__decrement'])[" + randomProductNumberOnThePage + "]")).click();
            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]")).clear();
            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]")).sendKeys("0");
            //clickElementByItsCssSelector("#title-search-input"); закрывает каталог во весь экран
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
            implicitWaiting();
        }
    }

    public void determiningNumberOfProductsOnThePage() {
        if (areThereAnyOffers) {
            numberOfProductsPerPage = driver.findElements(By.cssSelector(".product__link")).size() - driver.findElements(By.cssSelector(".offers-info__label")).size();
        } else {
            numberOfProductsPerPage = driver.findElements(By.cssSelector(".product__link")).size();
        }
        System.out.println("Количесвто товаров на странице = " + numberOfProductsPerPage);
    }

    public void determiningPriceOfThisRandomProduct() {
        for (int i = 1; i < driver.findElements(By.xpath("//*[@class='blank-zakaza__header-row']/*[contains(@class, 'blank-zakaza__header')]")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[@class='blank-zakaza__header-row']/*[contains(@class, 'blank-zakaza__header')])[" + i + "]")).getText().contains("Минимальная цена")) {
                countColumnForMinPrice = i;
                break;
            }
        }
        if (countColumnForMinPrice > 0) {
            tempString = driver.findElement(
                            By.xpath("(((//*[@class='quantity-selector'])[" + randomProductNumberOnThePage + "] /preceding::*[@class='product__property product__property--image'])[last()] /following::*[contains(@class, 'product__property product__property')])[" + (countColumnForMinPrice - 1) + "]"))
                    .getText();
            basePriceRandomProduct = Double.valueOf(replacingSomeSymbols(tempString));
        } else {
            System.out.println("Я не нашел колонку с минимальной ценой!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            tempString = driver.findElement(By.xpath("(//*[contains(@id, 'price_BASE')])[" + randomProductNumberOnThePage + "]")).getText();
            basePriceRandomProduct = Double.valueOf(replacingSomeSymbols(tempString));
            if (isThereASmallOptPrice) {
                try {
                    if (basePriceRandomProduct > Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'SMALL_OPT')])[" + randomProductNumberOnThePage + "]"))
                            .getText()))) {
                        basePriceRandomProduct = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'SMALL_OPT')])[" + randomProductNumberOnThePage + "]"))
                                .getText()));
                    }
                } catch (Exception e) {
                }   //Если у товара есть меньшая цена (для твоей группы пользователя), то выберется меньшая цена
            }
            if (isThereAOptPrice) {
                try {
                    if (basePriceRandomProduct > Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_OPT')])[" + randomProductNumberOnThePage + "]"))
                            .getText()))) {
                        basePriceRandomProduct = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_OPT')])[" + randomProductNumberOnThePage + "]"))
                                .getText()));
                    }
                } catch (Exception e) {
                }   //Если у товара есть меньшая цена (для твоей группы пользователя), то выберется меньшая цена
            }
            if (isThereATestPrice) {
                try {
                    if (basePriceRandomProduct > Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_TEST')])[" + randomProductNumberOnThePage + "]"))
                            .getText()))) {
                        basePriceRandomProduct = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_TEST')])[" + randomProductNumberOnThePage + "]"))
                                .getText()));
                    }
                } catch (Exception e) {
                }   //Если у товара есть меньшая цена (для твоей группы пользователя), то выберется меньшая цена
            }

            if (
                    isThereAnIndividualPrice) {
                try {
                    if (basePriceRandomProduct > Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'PRIVATE_PRICE')])[" + randomProductNumberOnThePage + "]"))
                            .getText()))) {
                        basePriceRandomProduct = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'PRIVATE_PRICE')])[" + randomProductNumberOnThePage + "]"))
                                .getText()));
                    }
                } catch (Exception e) {
                }   //Если у товара есть меньшая цена (для твоей группы пользователя), то выберется меньшая цена
            }
        }


        System.out.println("Доступная цена товара за шт. = " + basePriceRandomProduct);
        //System.out.println("Рандомное число товаров = " + randomNumberUpToMAxQuantityThisProducts);
        priceForNewlyAddedProducts = basePriceRandomProduct * randomNumberUpToMAxQuantityThisProducts; //* coefficientForQuantityOfProducts
    }

    public void calculatingOfThePriceForAllProducts() {
        sumOfPricesOfTheAddedProducts = Math.round((sumOfPricesOfTheAddedProducts + priceForNewlyAddedProducts) * 100.0) / 100.0;
        System.out.println("Сумма добавленных товаров подсчитанная мной = " + sumOfPricesOfTheAddedProducts);
    }

    public void checkingThatThePriceOfTheAddedProductHasBeenCalculated() {
        determiningPriceOfThisRandomProduct();
        calculatingOfThePriceForAllProducts();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
        tempString = replacingSomeSymbols(driver.findElement(By.id("catalog__basket-price-value")).getText());
        System.out.println("Сумма добавленных товаров отображаемая в футере каталога = " + Double.valueOf(tempString));
        pricesForAllProductsInTheFooter = Double.valueOf(tempString);
        implicitWaiting();
        System.out.println("1 сумма за товары подсчитанная мной - " + sumOfPricesOfTheAddedProducts);
        System.out.println("2 сумма за товары отображаемая в футуре - " + pricesForAllProductsInTheFooter);
        Assert.assertTrue(sumOfPricesOfTheAddedProducts == pricesForAllProductsInTheFooter);
        navigationToCart();
        implicitWaiting();
        implicitWaiting(); // иногда долго грузит "Итого" в корзине
        tempString = driver.findElement(By.id("page-basket-total-block")).getText();
        pricesForAllProductsInTheCartPAge = Double.valueOf(replacingSomeSymbols(tempString));
        System.out.println("Сумма добавленных товаров отображаемая в футере корзины = " + pricesForAllProductsInTheCartPAge);
        Assert.assertTrue(pricesForAllProductsInTheCartPAge == sumOfPricesOfTheAddedProducts);
        navigationToCatalogTab();
    }

    public void deletingProductsFromTheCart() {
        sumOfPricesOfTheAddedProducts = 0;
        pricesForAllProductsInTheFooter = 0;
        count = 0;
        countColumnForMinPrice = 0;
        numberOfProductsInTheFooter = 0;
        randomProductNumberOnThePage = 0;

        navigationToCart();
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
        driver.findElement(buttonForDeletingProductsInCartLocator).click();
        implicitWaiting();
        driver.navigate().refresh();
        if (driver.findElements(By.xpath("//*[contains(@class, 'disabled')]")).size() == 0) {
            driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket__checkbox_content.state-checked")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonForDeletingProductsInCartLocator));
            wait.until(ExpectedConditions.elementToBeClickable(buttonForDeletingProductsInCartLocator));
            driver.findElement(buttonForDeletingProductsInCartLocator).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-entity='basket-item-restore-button']")));
            driver.navigate().refresh();
            implicitWaiting();

            if (!driver.findElement(By.cssSelector(".index_cart-empty")).isDisplayed()) {
                flag = false;
                while (flag == false && count < 5) {
                    count++;
                    driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
                    driver.findElement(buttonForDeletingProductsInCartLocator).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-entity='basket-item-restore-button']")));
                    driver.navigate().refresh();
                    if (driver.findElements(By.xpath("//*[@class='basket__product-name ']")).size() == 0) {
                        flag = true;
                    }
                }
            }
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='card-title']//*[contains(@href, 'blank')]")).isDisplayed());
        numberOfProductsInTheFooter = 0;
    }

    public void deletingLastAddedProductFromTheCatalog() {
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .sendKeys(String.valueOf("0"));
        numberOfProductsInTheFooter--;
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
        sumOfPricesOfTheAddedProducts = sumOfPricesOfTheAddedProducts - priceForNewlyAddedProducts;
        sumOfPricesOfTheAddedProducts = Math.round(sumOfPricesOfTheAddedProducts * 1000.0) / 1000.0; //Ингода добавляет цифру в конце, поэтому округля до 3-х знаков
        tempString = driver.findElement(By.id("catalog__basket-price-value")).getText();
        pricesForAllProductsInTheFooter = Double.valueOf(replacingSomeSymbols(tempString));
        System.out.println("1 подсчитано= " + sumOfPricesOfTheAddedProducts);
        System.out.println("2 в футере= " + pricesForAllProductsInTheFooter);
        Assert.assertTrue(pricesForAllProductsInTheFooter == sumOfPricesOfTheAddedProducts);
        navigationToCart();
        implicitWaiting();
        tempString = driver.findElement(By.id("page-basket-total-block")).getText();
        pricesForAllProductsInTheCartPAge = Double.valueOf(replacingSomeSymbols(tempString));
        Assert.assertTrue(pricesForAllProductsInTheCartPAge == sumOfPricesOfTheAddedProducts);
        navigationToCatalogTab();
    }

    public void deletingLastAddedProductFromTheCatalogUsingIconMinus() {
        for (double i = 0; i < quantityOfProductsInStock * coefficientForQuantityOfProducts; i++) {
            if (quantityOfProductsInStock * coefficientForQuantityOfProducts < 50) {
                clickElement("(//*[contains(@id, 'quantity-decrement')])[" + randomProductNumberOnThePage + "]");
            } else {
                driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                        .clear();
                driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                        .sendKeys(String.valueOf("0"));
                i = quantityOfProductsInStock * coefficientForQuantityOfProducts + 1;
                break;
            }
        }
        numberOfProductsInTheFooter--;
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
        sumOfPricesOfTheAddedProducts = sumOfPricesOfTheAddedProducts - priceForNewlyAddedProducts;  // /coeff
        tempString = driver.findElement(By.id("catalog__basket-price-value")).getText();
        pricesForAllProductsInTheFooter = Double.valueOf(replacingSomeSymbols(tempString));
        Assert.assertTrue(pricesForAllProductsInTheFooter == sumOfPricesOfTheAddedProducts);
        navigationToCart();
        implicitWaiting();
        tempString = driver.findElement(By.id("page-basket-total-block")).getText();
        pricesForAllProductsInTheCartPAge = Double.valueOf(replacingSomeSymbols(tempString));
        Assert.assertTrue(pricesForAllProductsInTheCartPAge == sumOfPricesOfTheAddedProducts);
        navigationToCatalogTab();
    }


    public void addingPlusOneToThisProduct() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .sendKeys(String.valueOf(quantityOfProductsInStock + 1));
    }

    public void addingPlusOneToThisProductUsingIconPlus() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
//        if(quantityOfProductsInStock * coefficientForQuantityOfProducts < 120){
//            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomNumberOfProductsPerPage + "]"))
//                    .clear();
//            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomNumberOfProductsPerPage + "]"))
//                    .sendKeys( "0");
//            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(productCounterInTheCart-1)));
//            for (int i = 0; i < quantityOfProductsInStock * coefficientForQuantityOfProducts + 1; i++) {
//                driver.findElement(By.xpath("(//*[contains(@id, 'quantity-increment')])[" + randomNumberOfProductsPerPage + "]")).click();
//            }
//        }else {
//            driver.findElement(By.xpath("(//*[contains(@id, 'quantity-increment')])[" + randomNumberOfProductsPerPage + "]")).click();
//        }
        driver.findElement(By.xpath("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]")).click();
        implicitWaiting();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
        randomNumberUpToMAxQuantityThisProducts = quantityOfProductsInStock;
    }

    public void changingPageInCatalog() {
        int numberOfPages = driver.findElements(By.xpath("//*[contains(@class, 'blank-zakaza__pagination')][1] //*[@class='page-item']")).size();
        if (numberOfPages>0){
            randomNumberPage = 1 + (int) (Math.random() * numberOfPages);
            clickElement("(//*[@class='page-item'])[" + randomNumberPage + "]");
            openingAllOffers();
        }else {
            System.out.println("В каталоге всего одна старница");
        }
    }

    public void navigationToThePageWithTheLastAddedProduct() {
        driver.findElement(By.xpath("(//*[@class='page-item'])[" + randomNumberPage + "]")).click();  //Если Каталог нормальных (все товары есть в наличии, то раскоментить)
        //driver.findElement(By.xpath("(//*[@class='page-item'])[1]")).click(); //Если каталог галимый (доступные товары тольок на первых двух страницах, то раскоментить)
    }

    public void decreaseQuantitiesLastAddedProduct() {
        if (randomNumberUpToMAxQuantityThisProducts > 1) {
            System.out.println(numberOfProductsInTheFooter);
            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                    .clear();
            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                    .sendKeys("0");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter - 1)));
            driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                    .sendKeys(String.valueOf(randomNumberUpToMAxQuantityThisProducts - 1));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
            waitingMilliSecond();
            waitingMilliSecond();
            sumOfPricesOfTheAddedProducts = sumOfPricesOfTheAddedProducts - priceForNewlyAddedProducts;
            sumOfPricesOfTheAddedProducts = sumOfPricesOfTheAddedProducts + basePriceRandomProduct * (randomNumberUpToMAxQuantityThisProducts - 1);
            if (Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector(".catalog__basket-price-value")).getText()))
                    != sumOfPricesOfTheAddedProducts) {
                implicitWaiting();
            }
            implicitWaiting();
            tempString = driver.findElement(By.id("catalog__basket-price-value")).getText();
            pricesForAllProductsInTheFooter = Double.valueOf(replacingSomeSymbols(tempString));
            Assert.assertTrue(pricesForAllProductsInTheFooter == sumOfPricesOfTheAddedProducts);
            navigationToCart();
            implicitWaiting();
            tempString = driver.findElement(By.id("page-basket-total-block")).getText();
            pricesForAllProductsInTheCartPAge = Double.valueOf(replacingSomeSymbols(tempString));
            Assert.assertTrue(pricesForAllProductsInTheCartPAge == sumOfPricesOfTheAddedProducts);
        } else {
            System.out.println("кол-во товара = 1");
        }
        navigationToCatalogTab();
    }

    public void decreaseQuantitiesLastAddedProductUsingIconMinus() {
        System.out.println(randomNumberUpToMAxQuantityThisProducts);
        if (randomNumberUpToMAxQuantityThisProducts > 1) {
            clickElement("(//*[contains(@id, 'quantity-decrement')])[" + randomProductNumberOnThePage + "]");
            sumOfPricesOfTheAddedProducts = sumOfPricesOfTheAddedProducts - priceForNewlyAddedProducts;
            sumOfPricesOfTheAddedProducts = sumOfPricesOfTheAddedProducts + basePriceRandomProduct * (randomNumberUpToMAxQuantityThisProducts - 1);
            implicitWaiting();
            implicitWaiting();
            tempString = driver.findElement(By.id("catalog__basket-price-value")).getText();
            pricesForAllProductsInTheFooter = Double.valueOf(replacingSomeSymbols(tempString));
            implicitWaiting();
            implicitWaiting();
            Assert.assertTrue(sumOfPricesOfTheAddedProducts == pricesForAllProductsInTheFooter);
            navigationToCart();
            implicitWaiting();
            tempString = driver.findElement(By.id("page-basket-total-block")).getText();
            pricesForAllProductsInTheCartPAge = Double.valueOf(replacingSomeSymbols(tempString));
            implicitWaiting();
            implicitWaiting();
            Assert.assertTrue(pricesForAllProductsInTheCartPAge == sumOfPricesOfTheAddedProducts);
        } else {
            System.out.println("кол-во товара = 1");
        }
        navigationToCatalogTab();
    }

    public void addingProductsThatAreOutOfStock() {
        driver.findElement(By.cssSelector(".page-item.last")).click();
        driver.findElement(By.cssSelector(".quantity-selector__value")).sendKeys("1");
        implicitWaiting();
        Assert.assertEquals(driver.findElement(By.cssSelector(".catalog__basket-quantity-value")).getText(), "0");
    }

    public void addingProductsThatAreOutOfStockUsingIconPlus() {
        driver.findElement(By.cssSelector(".page-item.last")).click();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[1]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".catalog__basket-quantity-value")).getText(), "0");
    }

    public void downloadingCatalogToYourComputer() {
        driver.findElement(actionsButtonLocator).click();
        driver.findElement(By.cssSelector(".icon-upload")).click();
        if (driver.findElements(By.xpath("//*[contains(@id, 'All_link')]")).size() != 0) {
            driver.findElement(By.xpath("//*[contains(@id, 'All_link')]")).click();
            driver.findElement(By.xpath("//*[@name='send_cond_tree']")).click();
        }
        checkingThatCatalogIsDownloaded(".xlsx");
    }

    public By actionsButtonLocator = By.cssSelector(".catalog__actions-toggler");

    public void downloadingCatalogFromExcel(String nameCatalog) {
        try {
            clickElement(actionsButtonLocator);
        } catch (Exception e) {
            clickElementByItsCssSelector(".btn-actions");
        }
        uploadingExcelCatalog(nameCatalog);
    }

    public void uploadingExcelCatalog(String nameCatalog) {
        driver.findElement(By.xpath("//*[contains(@class, 'icon-download')]")).click();
        choiceExcelFromResources(nameCatalog);
        clickAcceptTheUploadedFile();
        try {
            driver.findElement(By.xpath("//button[contains(text(), 'Закрыть')][contains(@class, 'btn')]")).click();
        } catch (Exception e) {
            System.out.println("Всплывашка какие товары были загружены не появилась");
        }
    }

    public void choiceExcelFromResources(String nameCatalog) {
        By fileInput = By.xpath("//input[@class='file-fileUploader']");
        String filePath = System.getProperty("user.dir") + "\\resources\\" + nameCatalog;
        driver.findElement(fileInput).sendKeys(filePath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'file-extended')] //*[contains(@class, 'files-size')]")));
    }

    public void clickAcceptTheUploadedFile() {
        driver.findElement(By.xpath("//*[contains(@name,'send_file')]")).click();
    }

    public void checkThatProductsAreDisplayedInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket__product-discrioption")));
        implicitWaiting();
        Assert.assertTrue(driver.findElement(By.cssSelector(".basket__product-discrioption")).isDisplayed());
    }

    public void checkingThatThereAreTwoGefestGasStoveInTheCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket__product-discrioption")));
        implicitWaiting();
        Assert.assertTrue(driver.findElement(By.cssSelector(".basket__product-discrioption")).isDisplayed());
        for (int i = 1; i <= driver.findElements(By.cssSelector(".basket__item")).size(); i++) {
            if (driver.findElements(By.xpath("(//*[contains(@class, 'basket__product-name')])[" + i + "][contains(text(), 'Плита GEFEST')]")).size() > 0) {
                count = i;
                break;
            }
        }
        Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@id, 'basket-item-quantity')])[" + count + "]")).getAttribute("value").equals("2"));
    }

    public void checkThatMessageAboutEmptyExcelIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed());
        driver.findElement(By.xpath("//*[@id='modal_import_excel'] //button[@class='close']")).click();
    }

    public void addingProductToCartFromTabAddAnAdditionalProduct(int randomNumberOfTheAdditionalProduct) {
        int tempQualityProductsInTheCart = driver.findElements(By.cssSelector(".basket__item")).size();
        clickElement("(//*[@class='input-group-append'])[" + randomNumberOfTheAdditionalProduct + "]");
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".basket__item"), tempQualityProductsInTheCart));
        } catch (Exception e) {
            System.out.println("Добавляемый товар уже был в корзине");
            implicitWaiting();
            implicitWaiting();
            implicitWaiting();
        }
    }

    public void checkThatProductAddedFromTabAddAnAdditional() {
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'catalog-list__font-white-space-nowrap')])[" + randomNumberUpToFife + "]")).getText()
                , driver.findElement(By.xpath("//*[contains(@class, 'busket__column__font-bold')]")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'catalog-list__font-white-space-nowrap')])[" + randomNumberUpToFife + "] /*")).getText()
                , driver.findElement(By.xpath("//*[contains(@class, 'basket-page__total-price-value')]")).getText());
    }

    public void sortsProductsByIncreaseAvailability() {
        driver.findElement(By.xpath("//*[@data-property-code = 'AVALIABLE']")).click();
        openingAllOffers();
    }

    public void sortsProductsByDecreaseAvailability() {
        driver.findElement(By.xpath("//*[@data-property-code = 'AVALIABLE']")).click();
        driver.findElement(By.xpath("//*[@data-property-code = 'AVALIABLE']")).click();
        openingAllOffers();
    }

    public void sortsProductsByIncreasePrice() {
        try {
            sortsItemsIfNeededColumnIsNotDisplayed(true, "//*[contains(@class, 'blank-zakaza__header-property')][contains(text(), 'Розничная цена')]");
        } catch (Exception e) {
            System.out.println("Нет столбца с 'розничная цена'");
            sortsItemsIfNeededColumnIsNotDisplayed(true, "//*[@data-property-code = 'BASE']");
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'active sort-ASC')]")).isDisplayed()
                , "У 'Розничная цена' не появился флажок сортировки во убыванию");
        openingAllOffers();

//        for (int i = 1; i < driver.findElements(By.xpath("//*[@class='blank-zakaza__header-row']/*[contains(@class, 'blank-zakaza__header')]")).size(); i++) {
//            if (driver.findElement(By.xpath("(//*[@class='blank-zakaza__header-row']/*[contains(@class, 'blank-zakaza__header')])[" + i + "]")).getText().contains("Розничная цена")) {
//                driver.findElement(By.xpath("(//*[@class='blank-zakaza__header-row']/*[contains(@class, 'blank-zakaza__header')])[" + i + "]")).click();
//                break;
//            }
//        }
//        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'active sort-ASC')]")).isDisplayed()
//                , "У 'Розничная цена' не появился флажок сортировки во убыванию");
//        openingAllOffers();
    }

    public void sortsItemsIfNeededColumnIsNotDisplayed(boolean sortByIncreasing, String xpathForColumnWithPrice) {
        String expectedXpathForColumnWithPrice;
        if (sortByIncreasing) {
             expectedXpathForColumnWithPrice = xpathForColumnWithPrice + "[contains(@class, 'sort-ASC')]";
        } else {
             expectedXpathForColumnWithPrice = xpathForColumnWithPrice + "[contains(@class, 'sort-DESC')]";
        }
        int countForBreak = 0;
        flag = false;
        while (!flag && countForBreak < 3){
            driver.findElement(By.xpath(xpathForColumnWithPrice)).click();
            if (driver.findElements(By.xpath(expectedXpathForColumnWithPrice)).size()>0){
                flag = true;
            }else countForBreak++;
        }





        //        int numberOfClicksOnColumnWithPrice;
//        if (sortByIncreasing) {
//            numberOfClicksOnColumnWithPrice = 1;
//        } else {
//            numberOfClicksOnColumnWithPrice = 2;
//        }
//        Actions action = new Actions(driver);
//        int countForBreak = 0;
//        for (int i = 1; i <= numberOfClicksOnColumnWithPrice; i++) {
//            flag = false;
//            while (!flag) {
//                countForBreak++;
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-ear-right")));
//                action.moveToElement(driver.findElement(By.cssSelector(".ui-ear-right")));
//                action.perform();
//                try {
//                    driver.findElement(By.xpath(xpathForColumnWithPrice)).click();
//                    flag = true;
//                } catch (Exception e) {
//                    if (countForBreak > 5) {
//                        System.out.println("НЕ смог кликнуть по столбцу с ценой");
//                        System.out.println(5 / 0); //не смог отсортировать
//                    }
//                }
//            }
//        }
    }

    public void sortsProductsByDecreasePrice() {
        try {
            sortsItemsIfNeededColumnIsNotDisplayed(false, "//*[contains(@class, 'blank-zakaza__header-property')][contains(text(), 'Розничная цена')]");
        } catch (Exception e) {
            System.out.println("Нет столбца с 'розничная цена'");
            sortsItemsIfNeededColumnIsNotDisplayed(false, "//*[@data-property-code = 'BASE']");
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'active sort-DESC')]")).isDisplayed()
                , "У 'Розничная цена' не появился флажок сортировки во убыванию");
        openingAllOffers();
    }

    public void determineRandomProductOnPge() {
        determiningNumberOfProductsOnThePage();
        determiningRandomProduct();
        if (randomProductNumberOnThePage == 1) {
            randomProductNumberOnThePage++;
        }
        if (randomProductNumberOnThePage == numberOfProductsPerPage) {
            randomProductNumberOnThePage--;
        }
    }

//    public void determineRandomProductOnPge(){
//        determiningNumberOfProductsOnThePage();
//        determiningRandomNumberOfProducts();
//        numberOfOffersPerPage = driver.findElements(By.cssSelector(".product.product--offer")).size();
//        if(randomNumberOfProductsPerPage < numberOfOffersPerPage + 2){
//            randomNumberOfProductsPerPage =  numberOfOffersPerPage + 2;
//            System.out.println(randomNumberOfProductsPerPage);
//        }
//        if (randomNumberOfProductsPerPage==1){
//            randomNumberOfProductsPerPage++;
//        }
//        if (randomNumberOfProductsPerPage==numberOfProductsPerPage){
//            randomNumberOfProductsPerPage--;
//        }
//    }


    public void checkThatProductsAreSortedByIncreaseAvailability() {
        for (int i = 1; i < driver.findElements(By.cssSelector(".blank-zakaza__item")).size(); i++) {
            tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'])[" + i + "] //*[@class='product__property product__property--avaliable'])[1]"))
                    .getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            tempValue3 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'])[" + (i + 1) + "] //*[@class='product__property product__property--avaliable'])[1]"))
                    .getText();
            tempValue3 = replacingSomeSymbols(tempValue3);
            tempValue3 = tempValue3.replaceAll("[^0-9.]", "");
            if (areThereAnyOffers) {
                if (tempValue2 != null && !tempValue2.trim().isEmpty() && tempValue3 != null && !tempValue3.trim().isEmpty()) {
                    Assert.assertTrue(Double.valueOf(tempValue2) <= Double.valueOf(tempValue3));
                }
            } else {
                if (!tempValue2.equals("0") && !tempValue3.equals("0")) {
                    Assert.assertTrue(Double.valueOf(tempValue2) <= Double.valueOf(tempValue3));
                }
            }
        }
    }

    public void checkThatProductsAreSortedByDecreaseAvailability() {
        for (int i = 1; i < driver.findElements(By.cssSelector(".blank-zakaza__item")).size(); i++) {
            tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'])[" + i + "] //*[@class='product__property product__property--avaliable'])[1]"))
                    .getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            tempValue3 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'])[" + (i + 1) + "] //*[@class='product__property product__property--avaliable'])[1]"))
                    .getText();
            tempValue3 = replacingSomeSymbols(tempValue3);
            tempValue3 = tempValue3.replaceAll("[^0-9.]", "");
            if (areThereAnyOffers == true) {
                if (tempValue2 != null && !tempValue2.trim().isEmpty() && tempValue3 != null && !tempValue3.trim().isEmpty()) {
                    Assert.assertTrue(Double.valueOf(tempValue2) >= Double.valueOf(tempValue3));
                }
            } else Assert.assertTrue(Double.valueOf(tempValue2) >= Double.valueOf(tempValue3));
        }
    }

    public void checkThatProductsAreSortedByIncreasePrice() {
        for (int i = 1; i < driver.findElements(By.xpath("//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1]"))
                .size(); i++) {
            tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1]"))
                    .getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            tempValue3 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + (i + 1) + "] //*[@class='product__property product__property--price'])[1]"))
                    .getText();
            tempValue3 = replacingSomeSymbols(tempValue3);
            tempValue3 = tempValue3.replaceAll("[^0-9.]", "");
            if (tempValue2 != null && !tempValue2.trim().isEmpty() && tempValue3 != null && !tempValue3.trim().isEmpty()) {
                if (!(Double.valueOf(tempValue2) <= Double.valueOf(tempValue3))) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                            "ОШИБКА, товары не отсортированы, Но Проверки настроены так, что бы не учитывали скидки, а проверяло только по базовой цене " +
                            "(потому что битрикс не сортирует с учетом скидки)");
                    if (driver.findElements(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                            .size() > 0) {
                        tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                                .getText();
                        tempValue2 = replacingSomeSymbols(tempValue2);
                        tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
                    }
                    if (driver.findElements(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + (i + 1) + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                            .size() > 0) {
                        tempValue3 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + (i + 1) + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                                .getText();
                        tempValue3 = replacingSomeSymbols(tempValue3);
                        tempValue3 = tempValue3.replaceAll("[^0-9.]", "");
                    }
                }
                Assert.assertTrue(Double.valueOf(tempValue2) <= Double.valueOf(tempValue3));
            }
        }
    }

    public void checkThatProductsAreSortedByDecreasePrice() {
        for (int i = 1; i < driver.findElements(By.xpath("//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1]")).size(); i++) {
            tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1]"))
                    .getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            tempValue3 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + (i + 1) + "] //*[@class='product__property product__property--price'])[1]"))
                    .getText();
            tempValue3 = replacingSomeSymbols(tempValue3);
            tempValue3 = tempValue3.replaceAll("[^0-9.]", "");
            if (tempValue2 != null && !tempValue2.trim().isEmpty() && tempValue3 != null && !tempValue3.trim().isEmpty()) {
                if (!(Double.valueOf(tempValue2) >= Double.valueOf(tempValue3))) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                            "ОШИБКА, товары не отсортированы, Но Проверки настроены так, что если ловится ошибка по сортировке, то он проверяет есть ли у товаров цена со скидкой, " +
                            "и если есть то проверяет базовые цены этих товаров (потому что битрикс не сортирует с учетом скидки)");
                    if (driver.findElements(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                            .size() > 0) {
                        tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                                .getText();
                        tempValue2 = replacingSomeSymbols(tempValue2);
                        tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
                    }
                    if (driver.findElements(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + (i + 1) + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                            .size() > 0) {
                        tempValue3 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + (i + 1) + "] //*[@class='product__property product__property--price'])[1] //*[contains(@class, 'discount-price')]"))
                                .getText();
                        tempValue3 = replacingSomeSymbols(tempValue3);
                        tempValue3 = tempValue3.replaceAll("[^0-9.]", "");
                    }
                }
                Assert.assertTrue(Double.valueOf(tempValue2) >= Double.valueOf(tempValue3));
            }
        }
    }


    public void choicePartOfWordForSearch() {
        wordForSearch = driver.findElement(By.xpath("(//*[@class='product__link'])[" + randomProductNumberOnThePage + "]")).getText();
    }

    public void enterPartOfNameInTheSearchFieldOnTheCatalogTab(By searchField, String wordForSearch) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(wordForSearch.substring(0, 1));
        waitingMilliSecond();
        driver.findElement(searchField).sendKeys(wordForSearch.substring(1, 2));
        waitingMilliSecond();
        driver.findElement(searchField).sendKeys(wordForSearch.substring(2, 3));
        waitingMilliSecond();
        driver.findElement(searchField).sendKeys(wordForSearch.substring(3, 4));
        waitingMilliSecond();
        driver.findElement(searchField).sendKeys(wordForSearch.substring(4, 5));
        waitingMilliSecond();
        try {
            driver.findElement(searchField).sendKeys(wordForSearch.substring(5, 6));
        } catch (Exception e) {
            System.out.println("Слово меньше чем из 6 символов");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-result-products")));
    }

    public void enterNameInTheSearchFieldOnTheCatalogTabByWord(By searchField, String wordForSearch) {
        for (int i = 1; i <= wordForSearch.length(); i++) {
            driver.findElement(searchField).sendKeys(wordForSearch.substring((i - 1), i));
        }
        //driver.findElement(searchField).sendKeys(wordForSearch);
    }

    public void enterNameInTheSearchFieldOnTheCatalogTab(String nameForSearch) {
        clickElement(fieldForSearchInCatalogLocator);
        enterNameInTheSearchFieldOnTheCatalogTabByWord(fieldForSearchInCatalogLocator, nameForSearch);
        //driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch);
//        driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch.substring(0, 1));
//        driver.findElement(fieldForSearchInCatalogLocator).sendKeys("\b"); баг, пробую сразу
        try {
            implicitWaiting();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".media-title")));
        } catch (Exception e) {
            System.out.println("Не высветился поп-ап товар в подсказке, ввожу посимвольно!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + nameForSearch);
            driver.findElement(fieldForSearchInCatalogLocator).clear();
            driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch.substring(0, 1));
            driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch.substring(1, 2));
            driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch.substring(2, 3));
            driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch.substring(3, 4));
            driver.findElement(fieldForSearchInCatalogLocator).sendKeys(nameForSearch.substring(4, 5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".media-title")));
        }
        implicitWaiting();
    }

    public void choiceWordForSearch() {
        wordForSearch = driver.findElement(By.xpath("(//*[@class='product__link'])[" + randomProductNumberOnThePage + "]")).getText();
        waitingMilliSecond();
    }

    public By fieldForSearchInCatalogLocator = By.xpath("//*[@type='search']");

    public void searchByWord() {
        driver.findElement(fieldForSearchInCatalogLocator).sendKeys(Keys.ENTER);
        implicitWaiting();
        Assert.assertTrue(driver.findElement(By.cssSelector(".blank-zakaza__item")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@title='" + wordForSearch + "']")).isDisplayed());
        System.out.println(wordForSearch.substring(0, 6));
        System.out.println(wordForSearch.substring(0, 6).trim());
        Assert.assertTrue(driver.findElement(fieldForSearchInCatalogLocator).getAttribute("value").trim().contains(wordForSearch.substring(0, 6).trim()));
    }

    public void goToTheLastPage() {
        try {
            driver.findElement(By.xpath("//*[@class='page-item last']")).click();
            hideTheMenuWhileTheBag();
            tempValue2 = driver.findElement(By.xpath("//*[@class='page-item active']")).getText();
        } catch (Exception e) {
            Assert.assertTrue(driver.findElements(By.xpath("//*[@class='page-item last']")).size() == 0);
            System.out.println("Всего одна страница!");
            tempValue2 = "1";
        }
    }

    public void rememberTheNumberOfPages() {
        tempValueForNumbers = driver.findElement(By.xpath("//*[@class='page-item active']")).getText();
    }

    public void rememberTheNumberOfProductsOnFirstPage() {
        tempInt = driver.findElements(By.cssSelector(".blank-zakaza__item")).size();
    }

    public void choiceTheCategory() {
        tempIntValue = 1 + (int) (Math.random() * driver.findElements(By.cssSelector(".catalog_section")).size());
        System.out.println("Я выбрал категорию   - " + driver.findElement(By.xpath("(//*[contains(@class, 'catalog_section')])[" + tempIntValue + "]")).getText());
        driver.findElement(By.xpath("(//*[contains(@class, 'catalog_section')])[" + tempIntValue + "] //*[@class='form-check']")).click();
    }

    public void choiceTheSecondLevelCategoryInABlackHatOrTheFirstLevelInAWhiteHat() {
        determineThemeColor();
        if (themeColorBlack) {
            choiceRandomCategoryInMenuCatalog(false);
            //checkingThatAllProductsHaveASimilarIdToTheSectionId();
            //expandCatalogCategories(false); Удалить - раскоментить после испр бага
            choiceRandomUnderCategoryOfTheSelectedCategory();
            tempString = tempValue3; //Название категории
            checkingThatBreadCrumbHaveSelectedCategories();
            //checkingThatAllProductsHaveASimilarIdToTheSectionId();
        } else {
            choiceRandomCategoryInMenuCatalog(false);
            tempString = tempValue2;
        }
    }

    public void expandCatalogCategories(boolean expandFromPopUpWindow) {
        if (!expandFromPopUpWindow) {
            determineThemeColor();
            implicitWaiting();
            if (themeColorBlack) {
                tempValue1 = driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']")).getText();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']")));
                driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'nav-item-open')]//*[@class='nav-item nav-item-submenu'])")));
                waitingMilliSecond();
                String backgroundColor = driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']"))
                        .getCssValue("background-color");
                Assert.assertTrue(backgroundColor.contains("rgba(62, 73, 95,"));
//            try {
//                Assert.assertEquals(backgroundColor, "rgba(62, 73, 95, 1)", "Цвет фона для 'Каталог' не соответсвует ожидаемому'");
//            }catch (Exception e){
//                System.out.println("тупая ошибка, цвет фона троху отличается");
//                Assert.assertEquals(backgroundColor, "rgba(62, 73, 95, 0.996)", "Цвет фона для 'Каталог' не соответсвует ожидаемому'");
//            }
                wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li)[3]")));
                waitingMilliSecond();
            } else {
                tempValue1 = driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][contains(@class, 'navbar-nav-link')]")).getText();
                driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][contains(@class, 'navbar-nav-link')]")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@href, 'blank_zakaza')] /following::*[contains(@class, 'dropdown-menu')])[1]")));
                waitingMilliSecond();
            }
        }
    }

    int numberOfPropertiesInTheFilterAfterChoiceSection;
    int numberOfPropertiesInTheFilterAfterChoiceUnderSection;

    public void hideAdminPanel() {
        try {
            implicitWaiting();
            waitElementVisible("//*[@id='bx-panel']");
            waitElementVisible("//*[@id='bx-panel-hider']");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bx-panel-hider']")));
            driver.findElement(By.xpath("//*[@id='bx-panel-hider']")).click();
        } catch (Exception e) {
            System.out.println("Админ панель уже свернута");
        }
    }

    public void choiceRandomCategoryInMenuCatalog(boolean expandFromPopUpWindow) {
        expandCatalogCategories(expandFromPopUpWindow);
        determineThemeColor();
        if (themeColorBlack) {
            tempRandomNumber = (1 + (int) (Math.random() * (driver.findElements(By.xpath("//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li")).size()- 2)));
            System.out.print("Номер раздела - " + tempRandomNumber);
            tempValue2 = driver.findElement(By.xpath("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li)[" + tempRandomNumber + "]")).getText();
            System.out.println("   Название рандомного раздела - " + tempValue2);
            String backgroundColor = driver.findElement(By.xpath("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li)[" + tempRandomNumber + "]"))
                    .getCssValue("background-color");
            Assert.assertTrue(backgroundColor.contains("rgba(0, 0, 0, 0"), "Цвет фона для 'Каталог не соответсвует ожидаемому'");
            clickElement("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li /a /span)[" + tempRandomNumber + "]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + tempValue2 + "'][@class='breadcrumb-item active']")));
            waitingMilliSecond();
//            tempValue4 = driver.findElement(By.xpath("(//*[contains(@class, 'nav-item-open')])[last()] /*[@href]")).getAttribute("href");
//            tempValue4 = tempValue4.substring(tempValue4.indexOf('=') + 1); ЧПУ
        } else {
            By menuCategoriseLocator = By.xpath("//*[contains(@class ,'show')]/*[contains(@class ,'dropdown-menu')]/*[contains(@class ,'dropdown-submenu')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(menuCategoriseLocator));
            tempRandomNumber = (1 + (int) (Math.random() * driver.findElements(menuCategoriseLocator).size()));
            System.out.println("Рандомно выбранный номер каталога - " + tempRandomNumber);
            tempValue2 = driver.findElement(By.xpath("(//*[contains(@class ,'show')]/*[contains(@class ,'dropdown-menu')]/*[contains(@class ,'dropdown-submenu')] /*[1] /span)["
                    + tempRandomNumber + "]")).getText();
            System.out.println("Рандомный раздел - " + tempValue2);
//            tempValue4 = driver.findElement(By.xpath("(//*[contains(@class ,'show')]/*[contains(@class ,'dropdown-menu')]/*[contains(@class ,'dropdown-submenu')] /*[1])["
//                    + tempRandomNumber + "]")).getAttribute("href");
//            tempValue4 = tempValue4.substring(tempValue4.indexOf('=') + 1); ЧПУ убрали
            driver.findElement(
                    By.xpath("(//*[contains(@class ,'show')]/*[contains(@class ,'dropdown-menu')]/*[contains(@class ,'dropdown-submenu')] /*[1] /span)["
                            + tempRandomNumber + "]")).click();
        }
        numberOfPropertiesInTheFilterAfterChoiceSection = driver.findElements(By.xpath("//*[contains(@class, 'active')]//*[@data-checkbox='div']")).size();
    }

    public void choiceRandomCategoryInPopUpMenuCatalog() {
        By pathToSectionsInMenuLocator = By.xpath("//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item nav-item-submenu')] /*[contains(@class, 'nav nav-group-sub')] /*[contains(@class, 'nav-item nav-item-submenu')]/*[@class='nav-link']");
        tempRandomNumber = (1 + (int) (Math.random() * driver.findElements(pathToSectionsInMenuLocator).size()));
        By pathToRandomSectionsInMenuLocator = By.xpath("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item nav-item-submenu')] /*[contains(@class, 'nav nav-group-sub')] /*[contains(@class, 'nav-item nav-item-submenu')]/*[@class='nav-link'])[" + tempRandomNumber + "]/span");
        tempValue2 = driver.findElement(pathToRandomSectionsInMenuLocator).getText();
        tempValue3 = tempValue2;
        System.out.println("Рандомный раздел - " + tempValue2);
        driver.findElement(pathToRandomSectionsInMenuLocator).click();
        hoveringTheCursorOverTheElement(iconCatalogLocator);
        String backgroundColor = driver.findElement(pathToRandomSectionsInMenuLocator).getCssValue("background-color");
        Assert.assertTrue(backgroundColor.contains("rgba(0, 0, 0, 0"), "Цвет фона для 'Каталог не соответсвует ожидаемому'");
//        tempValue4 = driver.findElement(pathToRandomSectionsInMenuLocator).getAttribute("href");
//        tempValue4 = tempValue4.substring(tempValue4.indexOf('=') + 1); уже ЧПУ
    }

    public void waitingElementWithText(String cssLocator) {
        flag = false;
        int countForBreak = 0;
        while (!flag) {
            countForBreak++;
            if (countForBreak > 10) {
                System.out.println(5 / 0);
            }
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector(cssLocator)));
                String nameUnderSection;
                nameUnderSection = driver.findElement(By
                        .cssSelector(cssLocator)).getText();
                if (nameUnderSection != null && !nameUnderSection.trim().isEmpty()) {
                    flag = true;
                } else {
                    implicitWaiting();
                }
            } catch (Exception e) {
                flag = false;
            }
        }
    }

    public void choiceRandomUnderCategoryOfTheSelectedCategory() {
        determineThemeColor();
        if (themeColorBlack) {
            System.out.println(tempRandomNumber);
            tempValue2 = driver.findElement(By.xpath("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li)[" + tempRandomNumber + "]/*")).getText();
            String backgroundColor = driver.findElement(By.xpath("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li)[" + tempRandomNumber + "]"))
                    .getCssValue("background-color");
            Assert.assertTrue(backgroundColor.contains("rgba(0, 0, 0, 0"), "Цвет фона для 'Каталог не соответсвует ожидаемому'");
            //disclosureOfASubcategories("(//*[contains(@class, 'nav-sidebar')]/*[contains(@class, 'nav-item')]/ul[contains(@class, 'nav-group-sub')] /li)[" + tempRandomNumber + "]");
            implicitWaiting();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-item-open > .nav-group-sub > .nav-item")));
            //tempRandomNumber = (1 + (int) (Math.random() * driver.findElements(By.xpath("((//*[contains(@class, 'nav-item-open')])[last()]/*[contains(@class, 'nav-group-sub')] /li /a /span)")).size()));
            int numberOfSubcategories = driver.findElements(By.xpath("(//*[@class='nav-item nav-item-submenu nav-item-open'])[last()] /ul/li")).size();
            tempRandomNumber = (1 + (int) (Math.random() * numberOfSubcategories));
            tempValue3 = driver.findElement(By.xpath("((//*[@class='nav-item nav-item-submenu nav-item-open'])[last()] /ul/li)[" + tempRandomNumber + "]")).getText();
            System.out.println("Рандомный подраздел рандомного раздела - " + tempValue3);
            clickElement("((//*[@class='nav-item nav-item-submenu nav-item-open'])[last()] /ul/li)[" + tempRandomNumber + "]");
        } else {
            //expandCatalogCategories(false);
            if (!driver.findElement(By.cssSelector(".dropdown-submenu")).isDisplayed()){
                expandCatalogCategories(false);
            }
            disclosureOfASubcategories("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), '" + tempValue2 + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='dropdown-submenu show'] //*[@class='dropdown-menu show']")));
            tempRandomNumber = (1 + (int) (Math.random() * driver.findElements(
                    By.xpath("//*[@class='dropdown-submenu show'] /*[@class='dropdown-menu show'] /*[@class='dropdown-submenu']")).size()));
            tempValue3 = driver.findElement(By.xpath("(//*[@class='dropdown-submenu show'] /*[@class='dropdown-menu show'] /*[@class='dropdown-submenu'])[" + tempRandomNumber + "]"))
                    .getText();
            System.out.println("Рандомный подраздел рандомного раздела - " + tempValue3);
//            tempValue4 = driver.findElement(By.xpath("(//*[@class='dropdown-submenu show'] //*[@class='dropdown-menu show'] /*[@class='dropdown-submenu']/*[contains(@href, 'SECTION_ID')])[" + tempRandomNumber + "]"))
//                    .getAttribute("href");
//            tempValue4 = tempValue4.substring(tempValue4.indexOf('=') + 1); ЧПУ
            driver.findElement(By.xpath("(//*[@class='dropdown-submenu show'] /*[@class='dropdown-menu show'] /*[@class='dropdown-submenu'])[" + tempRandomNumber + "] //span"))
                    .click();
        }
        numberOfPropertiesInTheFilterAfterChoiceUnderSection = driver.findElements(By.xpath("//*[contains(@class, 'active')]//*[@data-checkbox='div']")).size();
    }

    public void checkThatTheQuantityOfPagesIsChanged() {
        String breadCrumbs = driver.findElement(By.cssSelector(".breadcrumb-item.active")).getText();
        if (!breadCrumbs.contains("Компьютеры")) {
            Assert.assertNotEquals(tempValueForNumbers, tempValue2);
        }
    }

    public void enteringTheMaxPriceIntoTheFilter() {
        expendFilterInCatalog();
        driver.findElement(By.cssSelector(".max-price")).sendKeys(maxPriceForFiltering);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#modef")));
        clickElementByItsCssSelector("#set_filter");
    }

    public void enteringTheMinPriceIntoTheFilter() {
        expendFilterInCatalog();
        driver.findElement(By.cssSelector(".min-price")).sendKeys(minPriceForFiltering);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#modef")));
        clickElementByItsCssSelector("#set_filter");
    }

    public void checkThatMaxPriceHasBeenApplied() {
        for (int i = 1; i < driver.findElements(By.xpath("//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1]")).size(); i++) {
            tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1]"))
                    .getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            if (Double.valueOf(tempValue2) > Double.valueOf(maxPriceForFiltering)) {
                tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[2] //*[@class='product__property product__property--price'])[1] //*[contains(@id, 'BASE')]"))
                        .getText();
                tempValue2 = replacingSomeSymbols(tempValue2);
                tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            }
            Assert.assertTrue(Double.valueOf(tempValue2) <= Double.valueOf(maxPriceForFiltering));
        }
    }

    public void checkThatMinPriceHasBeenApplied() {
        for (int i = 1; i < driver.findElements(By.xpath("//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1]")).size(); i++) {
            tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[" + i + "] //*[@class='product__property product__property--price'])[1]"))
                    .getText();
            tempValue2 = replacingSomeSymbols(tempValue2);
            tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            if (Double.valueOf(tempValue2) < Double.valueOf(maxPriceForFiltering)) {
                tempValue2 = driver.findElement(By.xpath("((//*[@class='blank-zakaza__item'] /*[@class='product'] /following::*[1][not(ancestor-or-self::*[contains(@class, 'product product--offer')])] /preceding::tr[1])[2] //*[@class='product__property product__property--price'])[1] //*[contains(@id, 'BASE')]"))
                        .getText();
                tempValue2 = replacingSomeSymbols(tempValue2);
                tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
            }
            Assert.assertTrue(Double.valueOf(tempValue2) >= Double.valueOf(minPriceForFiltering));
        }
    }

    public void changePageOnTheSecond() {
        try {
            driver.findElement(By.xpath("(//*[@class='page-item'])[1]")).click();
        } catch (Exception e) {
            System.out.println("Я не нашел второй страницы");
        }
    }

    public void checkThatTheMaximumPriceIsAppliedOnAllPages() {
        System.out.println("ID раздела - " + tempValue4);
        count = 1;
        while (!flag) {
            checkThatMaxPriceHasBeenApplied();
            try {
                driver.findElement(By.xpath("//*[@class='page-item next']")).click();
                count++;
                System.out.println();
                System.out.println("Выбрал старницу №" + count + " с товарами категории, для проверки всех цен на ней");
                System.out.println();
            } catch (Exception e) {
                System.out.println();
                System.out.println("Больше страниц с товарами категории нет, всего страниц - " + count);
                System.out.println();
                flag = true;
            }
        }
    }

    public void checkThatTheMinimumPriceIsAppliedOnAllPages() {
        System.out.println("ID раздела - " + tempValue4);
        count = 1;
        while (!flag) {
            checkThatMinPriceHasBeenApplied();
            try {
                driver.findElement(By.xpath("//*[@class='page-item next']")).click();
                count++;
                System.out.println();
                System.out.println("Выбрал старницу №" + count + " с товарами категории, для проверки всех цен на ней");
                System.out.println();
            } catch (Exception e) {
                System.out.println();
                System.out.println("Больше страниц с товарами категории нет, всего страниц - " + count);
                System.out.println();
                flag = true;
            }
        }
    }

    public void changePageOnTheFourth() {
        driver.findElement(By.xpath("//*[@class='page-link'][text()='4']")).click();
    }

    public void checkThatDetailPageOfProductIsOpened() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".blank-zakaza-detail__image")).isDisplayed(), "!!!! Блок с детальной картинкой не отображается");
        Assert.assertTrue(driver.findElement(By.cssSelector(".quantity-selector")).isDisplayed(), "!!!! Блок добавления (удаления) в корзину не отображается");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='card-title'][contains(text(), 'Описание')]")).isDisplayed(), "!!!! Описание не отображается");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='card-title'][contains(text(), 'Характеристики')]")).isDisplayed(), "!!!! Характеристики не отображаются");
    }

    public void openDetailPageOfRandomProduct(int randomNumberOfProductsPerPage) {
        implicitWaiting();
        clickElement("(//*[@class='product__link'])[" + randomNumberOfProductsPerPage + "]");
        By locIframe = By.cssSelector(".side-panel-iframe");
        driver.switchTo().frame(driver.findElement(locIframe));
    }

    public void addingProductFromPopUpDetailPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".quantity-selector__increment")));
        driver.findElement(By.cssSelector(".quantity-selector__increment")).click();
        tempString = driver.findElement(By.cssSelector(".blank-zakaza-detail__title")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
    }

    public void checkingThatThereIsProductInTheCartThatWasAddedFromTheDetailedProductPage() {

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), '" + tempString + "')]")).isDisplayed()
                , "В коризне нет товара который добавлялся из поп-ап деталки товара");
    }

    public void navigationToComponentOfUnloadingTheCatalog() {
        try {
            driver.findElement(By.xpath("//*[contains(@id, 'components')] //*[@class='bx-panel-small-single-button-arrow']")).click();
        } catch (Exception e) {
            unHideAdminPanel();
            driver.findElement(By.xpath("//*[contains(@id, 'components')] //*[@class='bx-panel-small-single-button-arrow']")).click();
        }
        driver.findElement(By.xpath("//*[text()='Выгрузка каталога в файл excel']")).click();
        driver.findElement(By.xpath("//*[@title='Развернуть']")).click();
    }

    public void navigationToComponentOfUserOrders() {
        unHideAdminPanel();
        turnOnEditMode();
        clickElement("//*[contains(@id, 'components')] //*[@class='bx-panel-small-single-button-arrow']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, '.order')]")));
        driver.findElement(By.xpath("//*[contains(@title, '.order')]")).click();
        driver.findElement(By.xpath("//*[@title='Развернуть']")).click();
    }

    public void navigationToComponentOfUserParameters() {
        driver.findElement(By.xpath("//*[contains(@id, 'components')] //*[@class='bx-panel-small-single-button-arrow']")).click();
        driver.findElement(By.xpath("//*[contains(@title, 'main.profile')]")).click();
        driver.findElement(By.xpath("//*[@title='Развернуть']")).click();
    }

    public void unHideAdminPanel() {
        try {
            waitElementVisible("//*[@id='bx-panel']");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(), 'Компоненты')]")));
            driver.findElement(By.cssSelector("#bx-panel-expander-arrow")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Компоненты')]")));
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'components')] //*[@class='bx-panel-small-single-button-arrow']")));
            }catch (Exception e2){
                driver.findElement(By.cssSelector("#bx-panel-expander-arrow")).click();
                // тупая ошибка, обрабатываю трай кэтчем ее
            }
        }
    }

    public void navigationToComponentOfCatalogSetting() {
        turnOnEditMode();
        unHideAdminPanel();
        clickElement("//*[contains(@id, 'components')] //*[@class='bx-panel-small-single-button-arrow']");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'popup-menu-item-text')][text()='Каталог']")));
        waitingMilliSecond();
        driver.findElement(By.xpath("//*[contains(@class, 'popup-menu-item-text')][text()='Каталог']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Развернуть']")));
        clickElement("//*[@title='Развернуть']");
    }

    public void selectTheWorkModelAsUserConfigurable() {
        driver.findElement(By.xpath("//*[contains(@for, 'MODEL_OF_WORK')] / following::*[1]")).click();
        driver.findElement(By.xpath("//*[@value= 'user_config']")).click();
        scrollToTheElement(By.xpath("//*[contains(@id, 'save-button')]"));
        driver.findElement(By.xpath("//*[contains(@id, 'save-button')]")).click();
    }

    public void selectTheNumberOfDisplayedOrdersOnThePage() {
        randomNumberPage = randomNumberUpToNine;
        System.out.println("Выбранное кол-во заказов на странице - " + randomNumberPage);
        driver.findElement(By.xpath("//*[@name='ORDERS_PER_PAGE']")).clear();
        driver.findElement(By.xpath("//*[@name='ORDERS_PER_PAGE']")).sendKeys(String.valueOf(randomNumberPage));
        driver.findElement(buttonSaveLocator).click();
        implicitWaiting();
    }

    public void selectTheNumberOfDisplayedOrdersOnThePageIsEquallyThirty() {
        driver.findElement(By.xpath("//*[@name='ORDERS_PER_PAGE']")).clear();
        driver.findElement(By.xpath("//*[@name='ORDERS_PER_PAGE']")).sendKeys("30");
        driver.findElement(buttonSaveLocator).click();
    }

    public void selectRandomSectionToDownloadToTheCatalog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(actionsButtonLocator));
        implicitWaiting();
        driver.findElement(actionsButtonLocator).click();
        driver.findElement(By.cssSelector(".icon-upload")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'add_link')]")));
        driver.findElement(By.xpath("//*[contains(@id,'add_link')]")).click();
        driver.findElement(By.xpath("//*[@value='CondIBSection']")).click();
        driver.findElement(By.xpath("//*[contains(@id,'value_link')]")).click();
        selectingRandomCatalogFromPupOpWindow();
    }

    public void selectingRandomCatalogFromPupOpWindow() {
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next();
        String newWindow = itr.next();
        driver.switchTo().window(newWindow);
        driver.findElement(By.xpath("//*[@id='find_type']")).click();
        driver.findElement(By.xpath("//*[@value='sotbit_b2bcabinet_type_catalog']")).click();
        driver.findElement(By.xpath("//*[@id='find_iblock_id']")).click();
        driver.findElement(By.xpath("//*[@id='find_iblock_id'] //*[contains(text(), 'Каталог товаров')]")).click();
        tempInt = 1 + (int) (Math.random() * driver.findElements(By.xpath("//*[@class='adm-list-table-popup']")).size());
        driver.findElement(By.xpath("(//*[@class='adm-list-table-popup'])[" + tempInt + "]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Выбрать')]")).click();
        driver.switchTo().window(parentWindow); //вернуть фокус на старое окно
    }

    public void clickTheUploadButton() {
        driver.findElement(By.xpath("//*[@name='send_cond_tree']")).click();
    }

    public void checkingThatCatalogIsDownloaded(String downloadedFileContainsName) {
        flag = false;
        count = 0;
        while (!flag) {
            implicitWaiting();
            count++;
            if (count > 10) {
                System.out.println(5 / 0);
            }
            String downloadPath = System.getProperty("user.home") + "/Downloads/";
            flag = isFileDownloaded_Ext(downloadPath, downloadedFileContainsName);
        }
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        Assert.assertTrue(isFileDownloaded_Ext(downloadPath, downloadedFileContainsName), "Failed to download document which has extension .xlsx");
    }

    public void sortingOfProductsInAlphabeticalIncreasingOrder() {
        driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')]")).click();
        if (driver.findElements(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')][contains(@class, 'active sort-ASC')]")).size() == 0) {
            driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')]")).click();
        }
        if (driver.findElements(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')][contains(@class, 'active sort-ASC')]")).size() == 0) {
            driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')]")).click();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')][contains(@class, 'active sort-ASC')]")).isDisplayed()
                , "Значок что товары отсортированы по Алфавиту (возрастанию) не отображается");
    }

    public void sortingOfProductsInAlphabeticalDescendingOrder() {
        driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')]")).click();
        if (driver.findElements(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')][contains(@class, 'active sort-DESC')]")).size() == 0) {
            driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')]")).click();
        }
        if (driver.findElements(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')][contains(@class, 'active sort-DESC')]")).size() == 0) {
            driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')]")).click();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'blank-zakaza__header-property--name')][contains(@class, 'active sort-DESC')]")).isDisplayed()
                , "Значок что товары отсортированы по Алфавиту (возрастанию) не отображается");
    }

    public void checkingThatCatalogIsSortedByProductNamesIncrease() {
        for (int i = 1; i < driver.findElements(By.cssSelector(".blank-zakaza__item")).size(); i++) {
            tempInt = driver.findElement(By.xpath("(//*[@class='blank-zakaza__item'] //*[@class='product'] //*[@class='product__link'])[" + i + "]")).getText().substring(0, 3)
                    .compareTo(
                            driver.findElement(By.xpath("(//*[@class='blank-zakaza__item'] //*[@class='product'] //*[@class='product__link'])[" + (i + 1) + "]")).getText().substring(0, 3)
                    );
            Assert.assertTrue(tempInt <= 0, "Товары не отсортированы по алфавиту (возрастанию)");
        }
    }

    public void checkingThatURLContainsSORTAndASC() {
        Assert.assertTrue(driver.getCurrentUrl().contains("SORT"));
        Assert.assertTrue(driver.getCurrentUrl().contains("asc"));
    }

    public void checkingThatURLContainsSORTAndDESC() {
        Assert.assertTrue(driver.getCurrentUrl().contains("SORT"));
        Assert.assertTrue(driver.getCurrentUrl().contains("desc"));
    }

    public void checkingThatCatalogIsSortedByProductNamesDecrease() {
        for (int i = 1; i < driver.findElements(By.cssSelector(".blank-zakaza__item")).size(); i++) {
            tempInt = driver.findElement(By.xpath("(//*[@class='blank-zakaza__item'] //*[@class='product'] //*[@class='product__link'])[" + i + "]")).getText().substring(0, 3)
                    .compareTo(
                            driver.findElement(By.xpath("(//*[@class='blank-zakaza__item'] //*[@class='product'] //*[@class='product__link'])[" + (i + 1) + "]"))
                                    .getText().substring(0, 3));
            if (!driver.findElement(By.xpath("(//*[@class='item-quantity__general'])[" + i + "]")).getText().equals("0")
                    && !driver.findElement(By.xpath("(//*[@class='item-quantity__general'])[" + (i + 1) + "]")).getText().equals("0")) {
                Assert.assertTrue(tempInt >= 0, "Товары не отсортированы по алфавиту (возрастанию)");
            }
        }
    }

    public void checkingThatSelectedSecondPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-item.active")).getText().equals("2"), "Я выбирал страницу №2, а выбралась другая(");
        Assert.assertTrue(driver.getCurrentUrl().contains("=2"));
        tempString = driver.findElement(By.xpath("(//*[@class='blank-zakaza__item'] //*[@class='product__link'])[1]")).getAttribute("id");
    }

    public void checkingThatSelectedFourthPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-item.active")).getText().equals("4"), "Я выбирал страницу №4, а выбралась другая(");
        Assert.assertTrue(driver.getCurrentUrl().contains("=4"));
        Assert.assertFalse(tempString.equals(driver.findElement(By.xpath("(//*[@class='blank-zakaza__item'] //*[@class='product__link'])[1]")).getAttribute("id")));
    }

    public void choosingRandomCategory() {
        tempInt = driver.findElements(By.cssSelector(".item_name")).size();
        choiceRandomCategoryInMenuCatalog(false);
    }

    public void checkingThatQuantityOfPropertiesIsHadDecreased() {
        System.out.println(numberOfPropertiesInTheFilterAfterChoiceSection);
        System.out.println(numberOfPropertiesInTheFilterAfterChoiceUnderSection);
        if (!tempValue2.contains("Спорт и отдых")) {
            Assert.assertTrue(numberOfPropertiesInTheFilterAfterChoiceSection > numberOfPropertiesInTheFilterAfterChoiceUnderSection);
        } else {
            Assert.assertTrue(numberOfPropertiesInTheFilterAfterChoiceSection >= numberOfPropertiesInTheFilterAfterChoiceUnderSection);

        }

//        System.out.println(driver.findElements(By.cssSelector(".item_name")).size());
//        Assert.assertTrue(tempInt > driver.findElements(By.cssSelector(".item_name")).size()
//                , "Количество свойств в рандомной разделе больше или равно чем во всех разделах");
    }

    public void navigationToSystemSettings() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/settings.php?lang=ru&mid=iblock&mid_menu=1");
    }

    public void enableOutputOfPropertiesInTheDirectory() {
        if (driver.findElements(By.xpath("//*[@id='property_features_enabled'][@checked]")).size() == 0) {
            driver.findElement(By.xpath("//*[@for='property_features_enabled'][@class]")).click();
        }
        driver.findElement(By.xpath("//*[@type='submit'][contains(@class,'save')]")).click();
    }

    public void disableOutputOfPropertiesInTheDirectory() {
        if (driver.findElements(By.xpath("//*[@id='property_features_enabled'][@checked]")).size() > 0) {
            driver.findElement(By.xpath("//*[@for='property_features_enabled'][@class]")).click();
        }
        driver.findElement(By.xpath("//*[@type='submit'][contains(@class,'save')]")).click();
    }

    public void navigationToGasStoveSetting() {
        driver.findElement(By.xpath("//*[@class='adm-main-menu-item-text'][text()='Контент']")).click();
        try {
            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Каталог (sotbit.b2bcabinet)']")).click();
            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Каталог товаров']")).click();
            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Бытовая техника']")).click();
            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Кухонные плиты']")).click();
        } catch (Exception e) {

            try {
                driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Кухонные плиты']")).click();
            } catch (Exception e4) {
                try {
                    driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Бытовая техника']")).click();
                    driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Кухонные плиты']")).click();
                } catch (Exception e1) {
                    try {
                        driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Каталог товаров']")).click();
                        driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Бытовая техника']")).click();
                        driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Кухонные плиты']")).click();
                    } catch (Exception e2) {
                        try {
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Каталог товаров']")).click();
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Бытовая техника']")).click();
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Кухонные плиты']")).click();
                        } catch (Exception e3) {
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Каталог (sotbit.b2bcabinet)']")).click();
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Каталог товаров']")).click();
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Бытовая техника']")).click();
                            driver.findElement(By.xpath("//*[@class='adm-submenu-item-name-link-text'][text()='Кухонные плиты']")).click();
                        }
                    }
                }
            }
        }
    }

    public void addRegionPropertyToThisProduct() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        driver.findElement(By.xpath("//*[text()='Регионы:']/following::*[1] //input")).clear();
        tempString = randomString(10);
        driver.findElement(By.xpath("//*[text()='Регионы:']/following::*[1] //input")).sendKeys(tempString);
        driver.findElement(By.cssSelector("#save")).click();
    }

    public void configureOutputOfThisPropertyToTheCatalog() {
        driver.findElement(By.xpath("//*[contains(text(), 'Настройках информационного блока')]")).click();
        driver.findElement(By.xpath("//*[@class='adm-detail-tab'][contains(text(), 'Свойства')]")).click();
        driver.findElement(By.xpath("//*[@value='Регионы']/following::td[7]")).click();
        driver.findElement(By.xpath("//*[@title='Развернуть']")).click();
        if (driver.findElements(By.xpath("//*[contains(text(), 'Показывать на странице списка элементов')]/following-sibling::* //*[@checked]")).size() == 0) {
            driver.findElement(By.xpath("//*[contains(text(), 'Показывать на странице списка элементов')]/following::label[1]")).click();
        }
        driver.findElement(By.cssSelector("#savebtn")).click();
        driver.findElement(By.xpath("//*[@value='Регионы']/following::td[7]")).click();
        driver.findElement(By.xpath("//*[@title='Развернуть']")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), 'Показывать на странице списка элементов')]/following-sibling::* //*[@checked]")).size() > 0);
        driver.findElement(By.cssSelector("#savebtn")).click();
        scrollToTheElement("//*[@class='adm-btn-save']");
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void selectTheSectionWithGasStoves() {
        determineThemeColor();
        if (themeColorBlack) {
            try {
                driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']")).click();
                implicitWaiting();
                disclosureOfASubcategories("(//*[contains(@class, 'nav-item-open')] //span)[2]");
                //driver.findElement(By.xpath("(//*[contains(@class, 'nav-item-open')] //span)[2]")).click();
                implicitWaiting();
                driver.findElement(By.xpath("((//*[contains(@class, 'nav-item-open')])[last()] //span)[2]")).click();
            } catch (Exception e) {
                navigationToCatalogTab();
                driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']")).click();
                implicitWaiting();
                disclosureOfASubcategories("(//*[contains(@class, 'nav-item-open')] //span)[2]");
                implicitWaiting();
                driver.findElement(By.xpath("((//*[contains(@class, 'nav-item-open')])[last()] //span)[2]")).click();
            }
        } else {
            expandTheNeededNavigationMenu("аталог");
            disclosureOfASubcategories("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), 'Бытовая техника')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), 'плиты')]")));
            driver.findElement(By.xpath("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), 'плиты')]")).click();
        }
    }

    public void selectSectionWithChainsaws() {
        if (themeColorBlack) {
            driver.findElement(By.xpath("//*[contains(@href, '/orders/blank_zakaza/')][@title='Каталог']")).click();
            implicitWaiting();
            disclosureOfASubcategories("(//*[contains(@class, 'nav-item-open')]/*[contains(@class, 'nav-group-sub')] /li /a /span)[2]");
            //driver.findElement(By.xpath("(//*[contains(@class, 'nav-item-open')]/*[contains(@class, 'nav-group-sub')] /li /a /span)[2]")).click();
            implicitWaiting();
            clickElement("((//*[contains(@class, 'nav-item-open')])[last()] //span)[2]");
        } else {
            expandTheNeededNavigationMenu("аталог");
            disclosureOfASubcategories("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), 'Дом, дача, ремонт')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), 'ензопилы')]")));
            driver.findElement(By.xpath("//*[@class='nav-item dropdown nav-item-dropdown-xl show'] //*[contains(text(), 'ензопилы')]")).click();
        }
    }

    public void checkingThatTheColumnWithThisPropertyHasAppearedInTheCatalog() {
        Assert.assertTrue(driver.findElement(By.xpath("//th[contains(text(), 'егион')]")).isDisplayed());
    }

    public void checkingThatTheProductHasAPropertyWithThePreviouslyEnteredValue() {
        tempInt = 1;
        flag = false;
        while (flag == false) {
            if (driver.findElement(By.xpath("(//*[contains(@class, 'blank-zakaza__header-property')])[" + tempInt + "]")).getText().replaceAll(" ", "")
                    .equals("Регионы")) {
                flag = true;
            } else {
                tempInt++;
                if (tempInt > 20) break;
            }
        }
        System.out.println(tempInt);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@title, 'Плита GEFEST')] /following::td[" + (tempInt - 1) + "]")).getText().replaceAll(" ", "").equals(tempString));
    }

    public void removeAllColumnsWithPropertiesFromTheCatalog() {
        for (int i = 2; i <= driver.findElements(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)[" + i + "]")).isSelected()) {
                driver.findElement(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)[" + i + "]")).click();
                implicitWaiting();
                implicitWaiting();
            }
        }
        clickElement(buttonToSaveTheComponentSettingsForTheCatalog);
        //driver.findElement(buttonToSaveTheComponentSettingsForTheCatalog).click();
    }

    public void selectFewPropertiesToOutputToTheCatalog() {
        for (int i = 2; i <= driver.findElements(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)[" + i + "]")).getText().contains("Производитель")
                    || driver.findElement(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)[" + i + "]")).getText().contains("Артикул")
                    || driver.findElement(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)[" + i + "]")).getText().contains("Реквизиты")) {
                driver.findElement(By.xpath("(//*[@data-bx-property-id='LIST_PROPERTY_CODE'] //option)[" + i + "]")).click();
                implicitWaiting();
            }
        }
        clickElement(buttonToSaveTheComponentSettingsForTheCatalog);
    }

    public void checkingThatSelectedPropertiesAreDisplayedInTheCatalog() {
        Assert.assertTrue(driver.findElement(By.xpath("//th[contains(text(), 'роизводитель')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//th[contains(text(), 'ртикул')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//th[contains(text(), 'еквизиты')]")).isDisplayed());
    }

    public void chooseToDisplaySmallOptPricesForAllUsers() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "/bitrix/admin/cat_group_admin.php?lang=ru");
        driver.findElement(By.xpath("//*[text()='SMALL_OPT']/preceding::label[1] /following::*[1]")).click();
        driver.findElement(By.xpath("//*[text()='Изменить тип цен']")).click();
        for (int i = 1; i <= driver.findElements(By.xpath("//*[contains(text(),'Все пользователи')]")).size(); i++) {
            if (!driver.findElement(By.xpath("(//*[contains(text(),'Все пользователи')])[" + i + "]")).isSelected()) {
                driver.findElement(By.xpath("(//*[contains(text(),'Все пользователи')])[" + i + "]")).click();
            }
        }
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void setPriceForSmallOptForGasStoveGefest() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//td[contains(text(), 'SMALL_OPT')] /following::input[1][not(ancestor-or-self::*[@style = 'display: none;'])]")).clear();
        tempDouble = Double.parseDouble(driver.findElement(By.xpath("//input[contains(@id, 'BASE_PRICE')][not(ancestor-or-self::*[@style = 'display: none;'])]")).getAttribute("value")) - 1;
        driver.findElement(By.xpath("//td[contains(text(), 'SMALL_OPT')] /following::input[1][not(ancestor-or-self::*[@style = 'display: none;'])]")).sendKeys(String.valueOf(tempDouble));
        clickElement("//*[@title='Управление скидками']");
        if (driver.findElements(By.xpath("//td[text()='ID']")).size() > 0) {
            tempDouble2 = tempDouble * Double.valueOf(driver.findElement(By.xpath("(//td[contains(@style, 'text-align:')])[5]")).getText().replaceAll("%", "")) / 100;
            tempDouble = tempDouble - tempDouble2;
            tempDouble = Math.round(tempDouble * 100.0) / 100.0;
            System.out.println("Цена со скидкой для SMALLOPT =  " + tempDouble);
        }
        clickElementByItsCssSelector(".adm-btn-save");
    }

    public void settingTheMultiplicityForTheGefestGasStove() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//*[@title='Дополнительные параметры']")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).clear();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).sendKeys("0.1");
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void settingTheMultiplicityForTheKaiserGasStove() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита Kaiser')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//*[@title='Дополнительные параметры']")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).clear();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).sendKeys("0.1");
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void removingImagesFromTheGefestGasStove() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        try {
            clickElement("//*[contains(@class, 'adm-btn-del')]");
            implicitWaiting();
        } catch (Exception e) {
            System.out.println("Все картинки уже удалены");
        }
        try {
            clickElement("//*[contains(@class, 'adm-btn-del')]");
            implicitWaiting();
        } catch (Exception e) {
            System.out.println("Все картинки уже удалены");
        }
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void returningImagesToTheGefestGasStoveBack() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        String filePath = System.getProperty("user.dir") + "\\resources\\Gefest.jpg";
        driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys(filePath);
        driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys(filePath);
        implicitWaiting();
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void settingBackTheMultiplicityForTheGefestGasStove() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//*[@title='Дополнительные параметры']")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).clear();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).sendKeys("1");
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }

    public void findNumberOfGasStoveInCatalogInCatalog(String neededGasStove) {
        for (int i = 1; i <= driver.findElements(By.cssSelector(".product")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[@class='product__link'])[" + i + "]")).getText().contains(neededGasStove)) {
                count = i;
                break;
            }
        }
    }


    public void checkingThatTheGefestGasStoveHasTheSmallOptPrice() {
        findNumberOfGasStoveInCatalogInCatalog("Плита GEFEST");
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'SMALL_OPT')])[" + count + "]")).getText())) == tempDouble
                , "Отображаемая ОПТ цена для пользваотеля не равна вводимой у товара в админке");
    }

    public void addingGefestGasStoveToTheCart() {
        findNumberOfGasStoveInCatalogInCatalog("Плита GEFEST");
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("1");
    }

    public void checkingThatThePriceInTheCatalogFooterIsDisplayedAsForSmallOptGroup() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "1"));
        tempString = replacingSomeSymbols(driver.findElement(By.id("catalog__basket-price-value")).getText());
        System.out.println("Сумма добавленных товаров отображаемая в футере каталога = " + Double.valueOf(tempString));
        System.out.println("Цена товара которую я выбирал для SmallOpt  = " + tempDouble);
        pricesForAllProductsInTheFooter = Double.valueOf(tempString);
        Assert.assertTrue(tempDouble == pricesForAllProductsInTheFooter);
    }

    public void navigationToSettingOfQuantitativeAccountingForTheProduct() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/settings.php?lang=ru&mid=catalog");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#default_quantity_trace")));
    }

    public void enableQuantitativeAccountingForTheProductsInCatalog() {
        if (driver.findElement(By.cssSelector("#default_quantity_trace")).getText().equals("Нет")) {
            clickElementByItsCssSelector("#product_settings");
            //driver.findElement(By.cssSelector("#product_settings")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='quantity_trace']")));
            driver.findElement(By.xpath("//*[@for='quantity_trace']")).click();
            driver.findElement(By.cssSelector("#product_settings_start_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Сохранить']")));
            clickElement("//*[@value='Сохранить']");
        }
        if (driver.findElement(By.cssSelector("#default_can_buy_zero")).getText().equals("Да")) {
            clickElementByItsCssSelector("#product_settings");
            //driver.findElement(By.cssSelector("#product_settings")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='quantity_trace']")));
            driver.findElement(By.xpath("//*[@for='can_buy_zero']")).click();
            driver.findElement(By.cssSelector("#product_settings_start_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Сохранить']")));
            clickElement("//*[@value='Сохранить']");
        }
    }

    public void turnOffQuantitativeAccountingForTheProductsInCatalog() {
        if (driver.findElement(By.cssSelector("#default_quantity_trace")).getText().equals("Да")) {
            clickElementByItsCssSelector("#product_settings");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='quantity_trace']")));
            driver.findElement(By.xpath("//*[@for='quantity_trace']")).click();
            driver.findElement(By.cssSelector("#product_settings_start_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Сохранить']")));
            clickElement("//*[@value='Сохранить']");
        }
    }
    public void allowAddingProductsThatAreNotInStock(){
        if (driver.findElement(By.cssSelector("#default_can_buy_zero")).getText().equals("Нет")) {
            clickElementByItsCssSelector("#product_settings");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='quantity_trace']")));
            driver.findElement(By.xpath("//*[@for='can_buy_zero']")).click();
            driver.findElement(By.cssSelector("#product_settings_start_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Сохранить']")));
            clickElement("//*[@value='Сохранить']");
        }
    }

    public void addingThisProductOneMoreTime() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        implicitWaiting();
        driver.findElement(By.xpath("(//*[contains(@id, 'quantity-increment')])[" + randomProductNumberOnThePage + "]")).click();
        implicitWaiting();
    }

    public void checkingThatPriceAndQuantityHaveIncreased() {
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText())) > priceForNewlyAddedProducts);
        implicitWaiting();
        System.out.println(randomProductNumberOnThePage);
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage +
                "]")).getAttribute("value"))) > quantityOfProductsInStock);
    }

    public void checkingThatPriceAndQuantityHaveIncreasedForGefestGasStove() {
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText())) > priceForNewlyAddedProducts);
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count +
                "]")).getAttribute("value"))) > quantityOfProductsInStock);
    }

    public void enableQuantitativeAccountingAtTheGefestGasStove() {
        driver.findElement(By.xpath("//a[contains(text(), 'Плита GEFEST')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//*[@title='Дополнительные параметры']")).click();
        clickElement("//*[contains(@id, 'BASE_QUANTITY_TRACE')]");
        driver.findElement(By.xpath("//*[@id='CAT_BASE_QUANTITY_TRACE'] /option[@value='Y']")).click();
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
    }


    public void enterTheMaximumAvailableQuantityOfThisProduct() {
        findNumberOfGasStoveInCatalogInCatalog("Плита GEFEST");
        tempValue2 = driver.findElement(By.xpath("(//*[@class='item-quantity__general'])[" + count + "]"))
                .getText();
        tempValue2 = replacingSomeSymbols(tempValue2);
        tempValue2 = tempValue2.replaceAll("[^0-9.]", "");
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).clear();
//        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("0");
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "0"));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys(tempValue2);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "1"));
        waitingMilliSecond();
    }

    public void addThisProductOneMoreTimeUsingPlusIcon() {
        quantityOfProductsInStock = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count +
                "]")).getAttribute("value")));
        priceForNewlyAddedProducts = Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText()));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[" + count + "]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
        implicitWaiting();
        implicitWaiting();
    }

    public void addThisProductOneMoreTimeManually() {
        quantityOfProductsInStock = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count +
                "]")).getAttribute("value")));
        priceForNewlyAddedProducts = Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText()));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys(String.valueOf(quantityOfProductsInStock + 1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
        implicitWaiting();
        implicitWaiting();
    }

    public void checkingThatPriceAndQuantityAreTheSame() {
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText())) == priceForNewlyAddedProducts);
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count +
                "]")).getAttribute("value"))) == quantityOfProductsInStock);
    }

    public void checkingTheMultiplicityOfAddingProductsAndCalculatingThePrice() {
        enterTheMaximumAvailableQuantityOfThisProduct();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("0");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "0"));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("1");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "1"));
        tempString = replacingSomeSymbols(driver.findElement(By.xpath("//*[@class='catalog__basket-price-value']")).getText());
        tempDouble = Double.parseDouble(tempString);
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("0");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "0"));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[" + count + "]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "1"));
        tempDouble2 = Math.round((tempDouble / 10) * 100.0) / 100.0;
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector("#catalog__basket-price-value")).getText())) == tempDouble2);
    }

    public void checkingThatThisProductHasStubInsteadOfPicture() {
        findNumberOfGasStoveInCatalogInCatalog("Плита GEFEST");
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("1");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "1"));
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@src][@class='product__image'])[" + count + "]")).getAttribute("src").contains("no_photo.svg"));
    }

    public void checkingThatThisProductHasStubInsteadOfPictureInTheCart() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id, 'basket-item')]//img[@src]")).getAttribute("src").contains("no_photo.svg"));
    }

    public void removeTheSelectionFromTheCatalogCategory() {
        navigationToCatalogTab();
    }

    public void checkingThatAllProductsAreDisplayedAgain() {
        goToTheLastPage();
        Assert.assertTrue(tempValueForNumbers.equals(driver.findElement(By.xpath("//*[@class='page-item active']")).getText()));
    }

    public void removeOutputOfAllSubcategories() {
        navigationToCatalogTab();
    }

    public void checkingThatThereIsSomeProductsInTheBasket() {
        Assert.assertTrue(driver.findElements(By.cssSelector(".basket__item")).size() > 0);
    }

    public void addingThisProductToTheBasket() {
        driver.findElement(By.cssSelector(".quantity-selector__increment")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
    }

    public void settingUpRandomDiscountForGefestGasStove() {
        driver.findElement(By.xpath("//*[@id='bx-search-box'] /input")).sendKeys("Предустановленный список маркетинговых акций");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".adm-search-result")));
        driver.findElement(By.cssSelector(".adm-search-result")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Скидка на товары, группы товаров')] /following::div[2] //*[contains(text(), 'Создать')]")).click();
        driver.findElement(By.xpath("//*[@name = 'discount_name']")).sendKeys("Название скидки " + randomString(10));
        driver.findElement(By.xpath("//*[contains(text(), 'Следующий шаг')]")).click();
        tempString = randomNumber(2);
        driver.findElement(By.xpath("//*[@name = 'discount_value']")).sendKeys(tempString);
        driver.findElement(By.cssSelector("#sale_discount_preset_product_add")).click();
        driver.findElement(By.cssSelector(".bx-core-adm-icon-expand")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'adm-s-search-input-cel')] /input")).clear();
        driver.findElement(By.xpath("//*[contains(@class, 'adm-s-search-input-cel')] /input")).sendKeys("gefest");
        implicitWaiting();
        implicitWaiting();
        driver.findElement(By.cssSelector(".adm-list-table-popup")).click();
        driver.findElement(By.cssSelector(".bx-core-popup-menu-item-text")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'adm-icon-close')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Следующий шаг')]")).click();
        try {
            driver.findElement(By.xpath("//*[contains(@id, 'discount_groups')] /*[contains(text(), 'Все пользователи')]")).click();
        } catch (Exception e) {
            scrollToTheElement("//*[contains(text(), 'Следующий шаг')]");
            driver.findElement(By.xpath("//*[contains(text(), 'Следующий шаг')]")).click();
            driver.findElement(By.xpath("//*[contains(@id, 'discount_groups')] /*[contains(text(), 'Все пользователи')]")).click();
        }
        driver.findElement(By.xpath("//*[contains(text(), 'Следующий шаг')]")).click();
        implicitWaiting();
    }

    public void memorizingDiscountedAndNonDiscountedPricesForGefest() {
        resetCache();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).clear();
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + count + "]")).sendKeys("0");
        System.out.println(Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_BASE')])[" + count + "]")).getText())));
        System.out.println(Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_BASE')])[" + count + "] /following::*[1]")).getText())));
        tempDouble2 = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_BASE')])[" + count + "] /following::*[1]")).getText()));
        tempDouble = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_BASE')])[" + count + "]")).getText()))
                / Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@id, 'price_BASE')])[" + count + "] /following::*[1]")).getText()));
        tempDouble = (1 - (Math.round(tempDouble * 100.0) / 100.0)) * 100;
        tempDouble = Math.round(tempDouble * 100.0) / 100.0;
        System.out.println("Высчитанный процент скидки= " + tempDouble);
        System.out.println("Введенный процент скидки= " + tempString);
    }

    public void deletingALLDiscounts() {
        driver.findElement(By.xpath("//*[@id='bx-search-box'] /input")).sendKeys("Предустановленный список маркетинговых акций");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".adm-search-result")));
        driver.findElement(By.cssSelector(".adm-search-result")).click();
        if (driver.findElements(By.xpath("//*[contains(text(), 'Скидка на товары, группы товаров')] /following::div[2] //*[contains(text(), 'Список')]")).size() > 0) {
            driver.findElement(By.xpath("//*[contains(text(), 'Скидка на товары, группы товаров')] /following::div[2] //*[contains(text(), 'Список')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'main-grid-row main-grid-row-body']//*[@class='main-grid-cell main-grid-cell-action']")));
        }

        if (driver.findElements(By.xpath("//*[@class='main-grid-row main-grid-row-body']")).size() > 0) {
            driver.findElement(By.cssSelector("#tbl_sale_discount_check_all")).click();
            driver.findElement(By.cssSelector("#grid_remove_button_control")).click();
            driver.findElement(By.cssSelector("#tbl_sale_discount-confirm-dialog-apply-button")).click();
            //standardConfirmationOfTheActionOnThePage();
        }
    }

    public void checkingThatTheDiscountEnteredAndDisplayedInTheCatalogAreTheSame() {
        Assert.assertTrue(Double.valueOf(tempString) == tempDouble);
    }

    public void addingAnItemToTheCartWithPriceChecking() {
        randomProductNumberOnThePage = count;
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), "0"));
        calculationOfTheCoefficientForNonPieceProducts();
        numberOfProductsInTheFooter = Integer.parseInt(driver.findElement(By.id("catalog__basket-quantity-value")).getText());
        driver.findElement(By.xpath("(//*[@class='quantity-selector__value'])[" + randomProductNumberOnThePage + "]"))
                .sendKeys("1");
        numberOfProductsInTheFooter++;
        determiningPriceOfThisRandomProduct();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("catalog__basket-quantity-value"), String.valueOf(numberOfProductsInTheFooter)));
        waitingMilliSecond();
        waitingMilliSecond();
        tempString = replacingSomeSymbols(driver.findElement(By.id("catalog__basket-price-value")).getText());
        System.out.println("Сумма добавленных товаров отображаемая в футере каталога = " + Double.valueOf(tempString));
        pricesForAllProductsInTheFooter = Double.valueOf(tempString);
        implicitWaiting();
        Assert.assertTrue(pricesForAllProductsInTheFooter == basePriceRandomProduct);
        navigationToCart();
        implicitWaiting();
        tempString = driver.findElement(By.id("page-basket-total-block")).getText();
        pricesForAllProductsInTheCartPAge = Double.valueOf(replacingSomeSymbols(tempString));
        waitingMilliSecond();
        System.out.println("Сумма добавленных товаров отображаемая в футере корзины = " + pricesForAllProductsInTheCartPAge);
        Assert.assertTrue(pricesForAllProductsInTheFooter == basePriceRandomProduct);
    }

    public void choiceCatalogWithOnlyOffers() {
//        // выбор каталога из публички, из настроек компонента (старый способ)
//        turnOnEditMode();
//        unHideAdminPanel();
//        driver.findElement(By.cssSelector("#bx_topmenu_btn_components")).click();
//        driver.findElement(By.xpath("//*[@class='bx-core-popup-menu-item-text'][text()='Каталог']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bx-core-adm-icon-expand")));
//        driver.findElement(By.cssSelector(".bx-core-adm-icon-expand")).click();
//        driver.findElement(By.xpath("//*[@name='IBLOCK_TYPE']")).click();
//        driver.findElement(By.xpath("//*[@name='IBLOCK_TYPE'] /*[contains(text(), 'Каталоги')]")).click();
//        driver.findElement(By.xpath("//select[@data-bx-property-id = 'IBLOCK_ID']")).click();
//        try {
//            driver.findElement(By.xpath("//select[@data-bx-property-id = 'IBLOCK_ID'] //*[contains(text(), 'дежда')]")).click();
//        } catch (Exception e) { //каталог с ТП имеет не стандартное название
//            driver.findElement(By.xpath("//select[@data-bx-property-id = 'IBLOCK_ID'] //*[contains(text(), 'товаров')]")).click();
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonToSaveTheComponentSettingsForTheCatalog));
//        implicitWaiting();
//        clickElement(buttonToSaveTheComponentSettingsForTheCatalog);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".catalog")));
//        implicitWaiting();
//        navigationToMeanPageByUrl();
//        turnOffEditMode();
//        hideAdminPanel();





        // Пока забаговано не проверяю ТП каталог

//        navigationToBasicB2BSettings();
//        driver.findElement(By.xpath("//*[contains(@title, 'Каталог ')]")).click();
//        driver.findElement(By.cssSelector("#CATALOG_IBLOCK_ID")).click();
//        driver.findElement(By.xpath("//*[@id='CATALOG_IBLOCK_ID']/*[contains(text(), 'торговые предложения')]")).click();
//        clickElement(buttonSaveLocator);
//        implicitWaiting();
    }

    public void choiceStandardCatalog() {
        // выбор каталога из публички, из настроек компонента (старый способ)

//        turnOnEditMode();
//        unHideAdminPanel();
//        driver.findElement(By.cssSelector("#bx_topmenu_btn_components")).click();
//        driver.findElement(By.xpath("//*[@class='bx-core-popup-menu-item-text'][text()='Каталог']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bx-core-adm-icon-expand")));
//        driver.findElement(By.cssSelector(".bx-core-adm-icon-expand")).click();
//        driver.findElement(By.xpath("//*[@name='IBLOCK_TYPE']")).click();
//        driver.findElement(By.xpath("//*[@value='sotbit_b2bcabinet_type_catalog']")).click();
//        driver.findElement(By.xpath("//select[@data-bx-property-id = 'IBLOCK_ID']")).click();
//        driver.findElement(By.xpath("//select[@data-bx-property-id = 'IBLOCK_ID'] //*[contains(text(), 'Каталог товаров')]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonToSaveTheComponentSettingsForTheCatalog));
//        implicitWaiting();
//        clickElement(buttonToSaveTheComponentSettingsForTheCatalog);
//        implicitWaiting();
//        navigationToBasicB2BSettings();
//        driver.findElement(By.xpath("//*[contains(@title, 'Каталог ')]")).click();
//        driver.findElement(By.cssSelector("#CATALOG_IBLOCK_ID")).click();
//        driver.findElement(By.xpath("//*[@id='CATALOG_IBLOCK_ID']/*[contains(text(), 'Каталог товаров')]")).click();
//        clickElement(buttonSaveLocator);
//        navigationToMeanPageByUrl();
//        turnOffEditMode();
//        hideAdminPanel();


//        driver.navigate().to("http://b2b-gospod.devsotbit.ru/bitrix/admin/fileman_file_edit.php?path=%2Forders%2Fblank_zakaza%2Findex.php&full_src=Y&site=s1&lang=ru&&filter=Y&set_filter=Y");
//        By iBlockType = By.xpath("//*[@class='bxce-string']");
//        for (int i = 95; i <= driver.findElements(iBlockType).size(); i++) {
//            System.out.println(driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).getText());
//            if (driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).getText().contains("sotbit_b2bcabinet_type_catalog")){
//                driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).click();
//                driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).sendKeys(Keys.DELETE);
//                driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).sendKeys(Keys.DELETE);
//                driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).sendKeys(Keys.DELETE);
//
//
//                driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).clear();
//                driver.findElement(By.xpath("(//*[@class='bxce-string'])[" + i + "]")).sendKeys("Config::get('CATALOG_IBLOCK_TYPE')");
//            }
//        }
    }

    public void checkingTheNamesOfTheOutputGasStoves() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Плита ENDEVER IP-26')]")));
        tempString = "Плита ENDEVER IP-26 Плита GEFEST 6560-03 0001 Плита Gorenje EC 62 CLB Плита Kaiser HC 62010 S Moire Плита Oursson IP1220T/GA";
        for (int i = 1; i <= 5; i++) {
            Assert.assertTrue(tempString.contains(driver.findElement(By.xpath("(//*[@class='product__link'])[" + i + "]")).getText())
                    , "Этой плиты  " + driver.findElement(By.xpath("(//*[@class='product__link'])[" + i + "]")).getText() + "нету в моем списке плит, которые должны выводится  ");
        }
    }

    public void checkingTheNamesOfTheOutputGasChainsaw() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'пила CHAMPION')]")));
        tempString = "Цепная бензиновая пила CHAMPION 125T-10 Цепная бензиновая пила FORWARD FGS-4504 Цепная бензиновая пила Husqvarna 365H Цепная бензиновая пила Husqvarna 450e " +
                "Цепная бензиновая пила Huter BS-62 Цепная бензиновая пила PARTNER P340S Цепная бензиновая пила PIRAN CS4990";
        for (int i = 1; i <= 7; i++) {
            Assert.assertTrue(tempString.contains(driver.findElement(By.xpath("(//*[@class='product__link'])[" + i + "]")).getText())
                    , "Этой бензопилы  " + driver.findElement(By.xpath("(//*[@class='product__link'])[" + i + "]")).getText() + "нету в моем списке бензопил, которые должны выводится  ");
        }
    }

    public void checkingTheQuantityOfOutputGoodsWhenSelectingSubcategoriesChainsawsAndGasStoves() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Плита')]")));
        tempInt = driver.findElements(By.cssSelector(".product__link")).size();
        if (driver.findElements(By.xpath("//*[@class='page-item']")).size() > 0) {
            changePageOnTheSecond();
            tempInt = tempInt + driver.findElements(By.cssSelector(".product__link")).size();
        }
    }


    public void choiceMinPriceForOutputInCatalog() {
        navigationToMeanPageByUrl();
        navigationToCatalogTab();
        if (driver.findElements(By.xpath("//*[@data-property-code='MINIMUM_PRICE']")).size() == 0) {
            navigationToComponentOfCatalogSetting();
            try {
                clickElement("//*[@data-bx-property-id='LIST_PROPERTY_CODE'] /*[@value='MINIMUM_PRICE']");
            } catch (Exception e) {
                System.out.println("Удалить    не смог выбрать вывод мин цены!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonToSaveTheComponentSettingsForTheCatalog));
            implicitWaiting();
            clickElement(buttonToSaveTheComponentSettingsForTheCatalog);
            //driver.findElement(buttonToSaveTheComponentSettingsForTheCatalog).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".catalog")));
            implicitWaiting();
        }
    }


    public void addingGefestGasStoveToCartUsingPlusIcon() {
        driver.findElement(By.xpath("(//*[contains(@title, 'Плита GEFEST')] /following::* //*[@class='quantity-selector__increment'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
        numberOfAvailableGefestGasStove = Double.valueOf(driver.findElement(By.xpath("(//*[contains(@title, 'Плита GEFEST')] /following::* //*[@class='item-quantity__general'])[1]")).getText());
    }

    public void addingKaiserGasStoveToCartUsingPlusIcon() {
        driver.findElement(By.xpath("(//*[contains(@title, 'Плита Kaiser')] /following::* //*[@class='quantity-selector__increment'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b2b-notification__content")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#catalog__basket-quantity-value"), "2"));
        numberOfAvailableKaiserGasStove = Double.valueOf(driver.findElement(By.xpath("(//*[contains(@title, 'Плита Kaiser')] /following::* //*[@class='item-quantity__general'])[1]")).getText());
    }
//    public void addingGefestGasStoveToCartUsingPlusIconOneMoreThanAvailable(){
//        driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']")).clear();
//        driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']")).sendKeys(String.valueOf(tempDouble + 1));
//        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
//        Assert.assertTrue(Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']"))
//                .getAttribute("value")) > tempDouble);
//        driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']")).clear();
//        explicitWaiting();explicitWaiting();
//        driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']")).clear();
//        explicitWaiting();explicitWaiting();
//        tempDouble3 = Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']")).getAttribute("value"));
//        while (!(tempDouble == tempDouble3)){
//            driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-plus']")).click();
//            tempDouble3 = Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']")).getAttribute("value"));
//            waitingMilliSecond();
//        }
//        driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-plus']")).click();
//        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
//        Assert.assertTrue(Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'GEFEST')] /following::* //*[@data-entity ='basket-item-quantity-field']"))
//                .getAttribute("value")) > tempDouble);
//    }
//    public void addingKaiserGasStoveToCartUsingPlusIconOneMoreThanAvailable (){
//        tempDouble3 = Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']")).getAttribute("value"));
//        while (!(tempDouble2 == tempDouble3)){
//            driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-plus']")).click();
//            waitingMilliSecond();
//            tempDouble3 = Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']")).getAttribute("value"));
//        }
//        driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-plus']")).click();
//        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
//        Assert.assertTrue(Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']"))
//                .getAttribute("value")) == tempDouble2);
//        driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']")).clear();
//        driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']")).sendKeys(String.valueOf(tempDouble2 + 1));
//        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
//        explicitWaiting();explicitWaiting();
//        Assert.assertTrue(Double.valueOf(driver.findElement(By.xpath("//*[contains(text(), 'Kaiser')] /following::* //*[@data-entity ='basket-item-quantity-field']"))
//                .getAttribute("value")) == tempDouble2);
//    }

    public void enteringNumberInTheInputField(String theNumberToEnter, By quantityFieldSelector) {
        driver.findElement(quantityFieldSelector).clear();
        driver.findElement(quantityFieldSelector).sendKeys("\b\b\b\b\b\b");
        if (theNumberToEnter.substring(theNumberToEnter.length() - 2).equals(".0")) {
            theNumberToEnter = theNumberToEnter.substring(0, theNumberToEnter.length() - 2);
        }
        System.out.println("Число которое ввожу = " + theNumberToEnter);
        driver.findElement(quantityFieldSelector).sendKeys(theNumberToEnter);
        implicitWaiting();
    }

    public void enteringNumberInTheInputField(String theNumberToEnter, String quantityFieldSelector) {
        driver.findElement(By.xpath(quantityFieldSelector)).clear();
        if (theNumberToEnter.length() > 2) {
            if (theNumberToEnter.substring(theNumberToEnter.length() - 2).equals(".0")) {
                theNumberToEnter = theNumberToEnter.substring(0, theNumberToEnter.length() - 2);
            }
        }
        System.out.println("Число которое ввожу - " + theNumberToEnter);
        driver.findElement(By.xpath(quantityFieldSelector)).sendKeys(theNumberToEnter);
        implicitWaiting();
    }

    public void addingMaxQuantityOfProductInTheCartUsingPlusIconOneMoreThanAvailable(By quantityFieldSelector, By quantityPlusSelector, double numberOfAvailableProduct) {
        int countForBreak = 0;
        tempDouble = 1;
        System.out.println("Доступное кол-во товара - " + numberOfAvailableProduct);
        if (numberOfAvailableProduct > 95) {
            enteringNumberInTheInputField(String.valueOf(numberOfAvailableProduct - 10), quantityFieldSelector);
            driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
            implicitWaiting();
        }
        while (numberOfAvailableProduct != tempDouble) {
            countForBreak++;
            if (countForBreak > 1000) {
                break;
            }
            try {
                waitingMilliSecond();
                driver.findElement(quantityPlusSelector).click();
            } catch (Exception e) {
                System.out.println("тупая ошибка. слишком быстро кликает!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                implicitWaiting();
                driver.findElement(quantityPlusSelector).click();
            }
            waitingMilliSecond();
            try {
                tempDouble = Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value"));
            } catch (Exception e) {
                tempDouble = Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value"));
            }
        }
        try {
            driver.findElement(quantityPlusSelector).click();
        } catch (Exception e) {
            driver.findElement(quantityPlusSelector).click();
        }
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
        implicitWaiting();
        implicitWaiting();
    }

    public void attemptToSelectNegativeQuantityOfProductsInTheCartUsingMinusIcon(By quantityFieldSelector, By quantityMinusSelector) {
        tempDouble = Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value"));
        if (tempDouble > 95) {
            enteringNumberInTheInputField("10", quantityFieldSelector);
            driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
            implicitWaiting();
        }
        while (1 != tempDouble) {
            try {
                driver.findElement(quantityMinusSelector).click();
            } catch (Exception e) {
                // тупая ошибка слишком быстро кликает
            }
            waitingMilliSecond();
            try {
                tempDouble = Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value"));
            } catch (Exception e) {
                tempDouble = Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value"));
            }
        }
        for (int i = 0; i < 11; i++) {
            try {
                driver.findElement(quantityMinusSelector).click();
            } catch (Exception e) {
                driver.findElement(quantityMinusSelector).click();
            }
            waitingMilliSecond();
        }
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
    }

    public void attemptToEnterNegativeQuantityOfProductsInTheCart(By quantityFieldSelector) {
        enteringNumberInTheInputField("-1", quantityFieldSelector);
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
    }

    public void addingMaxQuantityOfProductInTheCartUsingInputField(By quantityFieldSelector, double numberOfAvailableProduct) {
        implicitWaiting();
        enteringNumberInTheInputField(String.valueOf(numberOfAvailableProduct + 1), quantityFieldSelector);
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
        implicitWaiting();
        implicitWaiting();
    }

    public void checkingThatTotalPriceAreCalculatedRight() {
        System.out.println(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector(".basket-page__total-price-value")).getText())));
        double calculatedSum = Double.valueOf((((numberOfAvailableGefestGasStove + 1) * Double.valueOf(replacingSomeSymbols(
                driver.findElement(By.xpath("(//*[contains(text(), 'GEFEST')] /following::* //*[@class ='basket__column-price-wrap']/span) [1]")).getText())))
                + (numberOfAvailableKaiserGasStove * Double.valueOf(replacingSomeSymbols(
                driver.findElement(By.xpath("(//*[contains(text(), 'Kaiser')] /following::* //*[@class ='basket__column-price-wrap']/span) [1]")).getText())) * 10)));
        double scale = Math.pow(10, 2);
        calculatedSum = Math.ceil(calculatedSum * scale) / scale;
        System.out.println(calculatedSum);
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector(".basket-page__total-price-value")).getText()))
                == calculatedSum);
    }

    public void checkingThatTotalPriceOfTheseProductsAreCalculatedRight(By priceForFirstProduct, By priceForSecondProduct) {
        Assert.assertTrue(Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector(".basket-page__total-price-value")).getText()))
                == (((quantityOfSecondProductsInStock + 1) * Double.valueOf(replacingSomeSymbols(driver.findElement(priceForSecondProduct).getText())))
                + (quantityOfProductsInStock * 10 * Double.valueOf(replacingSomeSymbols(driver.findElement(priceForFirstProduct).getText())))
        ));
    }

    public void checkingThatQuantityOfGefestGasStoveIsOneMoreThanAvailable() {
        Assert.assertTrue(Double.valueOf(driver.findElement(quantityFieldOfGefestLocator).getAttribute("value")) == numberOfAvailableGefestGasStove + 1);
    }

    public void checkingThatQuantityOfThisProductIsOneMoreThanAvailable(By quantityFieldSelector, double numberOfAvailableProduct) {
        Assert.assertTrue(Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value")) == numberOfAvailableProduct + 1);
    }

    public void checkingThatQuantityThisProductIsEqualsAvailable(By quantityFieldSelector, double numberOfAvailableProduct) {
        Assert.assertTrue(Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value")) == numberOfAvailableProduct);
    }

    public void checkingThatQuantityThisProductIsEqualsOne(By quantityFieldSelector) {
        if (driver.findElement(quantityFieldSelector).getAttribute("value").equals("1")) {
            Assert.assertTrue(driver.findElement(quantityFieldSelector).getAttribute("value").equals("1"));
        } else Assert.assertTrue(driver.findElement(quantityFieldSelector).getAttribute("value").equals("0.1"));
    }

    public void checkingThatQuantityThisProductIsNotNegative(By quantityFieldSelector) {
        Assert.assertTrue(Double.valueOf(driver.findElement(quantityFieldSelector).getAttribute("value")) > 0);
    }

    public void checkingThatQuantityOfKaiserGasStoveEqualsOneTenth() {
        Assert.assertTrue(driver.findElement(quantityFieldOfKaiserLocator).getAttribute("value").equals("0.1"));
    }

    public void checkingThatQuantityThisProductEqualsOneTenth(By quantityFieldSelector) {
        Assert.assertTrue(driver.findElement(quantityFieldSelector).getAttribute("value").equals("0.1"));
    }

    public void checkingThatThereAreNoProdutsInTheBasket() {
        Assert.assertTrue(driver.findElements(By.cssSelector(".basket__item")).size() == 0);
    }

    public void configureTheFirstTwoTP(String quantitativeAccountingLocator) {
        turnOnEditMode();
        refreshingThisPage();
        openingAllOffers();
        implicitWaiting();
        Actions action = new Actions(driver);
        try {
            action.moveToElement(driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[1]")));
            action.perform();
        } catch (Exception e) {
            System.out.println("тупая ошибка, не появилась шестеренка редактирования ТП");
            refreshingThisPage();
            openingAllOffers();
            implicitWaiting();
            implicitWaiting();
            implicitWaiting();
            implicitWaiting();
            action.moveToElement(driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[1]")));
            action.perform();
        }
        implicitWaiting();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class = 'bx-context-toolbar-button-text'][contains(text(), 'Изменить')])[1]")));
        driver.findElement(By.xpath("(//*[@class = 'bx-context-toolbar-button-text'][contains(text(), 'Изменить')])[1]")).click();
        driver.findElement(By.xpath("//*[contains(@title, 'еречень торговых предложений')]")).click();
        driver.findElement(By.xpath("(//*[@class='adm-list-table-popup'])[1]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'menu-item-text')][text()='Изменить']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//*[@title='Дополнительные параметры']")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).clear();
        driver.findElement(By.xpath("//*[contains(@id, 'MEASURE_RATIO')]")).sendKeys("0.1");
        try {
            driver.findElement(By.xpath("//*[@class='adm-btn-save']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("(//*[@class='adm-btn-save'])[2]")).click();
        }
        driver.findElement(By.xpath("(//*[@class='adm-list-table-popup'])[2]")).click();
        try {
            driver.findElement(By.xpath("(//*[contains(@class, 'menu-item-text')][text()='Изменить'])[2]")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("(//*[contains(@class, 'menu-item-text')][text()='Изменить'])[1]")).click();
        }
        driver.findElement(By.xpath("//*[contains(text(), 'Торговый каталог')][contains(@class, 'adm-detail-tab')]")).click();
        driver.findElement(By.xpath("//*[@title='Дополнительные параметры']")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'BASE_QUANTITY_TRACE')]")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'BASE_QUANTITY_TRACE')] /option[@value='" + quantitativeAccountingLocator + "']")).click();
        try {
            driver.findElement(By.xpath("//*[@class='adm-btn-save']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("(//*[@class='adm-btn-save'])[2]")).click();
        }
        driver.findElement(By.cssSelector(".adm-btn-save")).click();
        implicitWaiting();
        turnOffEditMode();
    }

    public void addingFirstTwoTPToTheCart() {
        driver.findElement(By.cssSelector(".offers-info")).click();
        quantityOfProductsInStock = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='item-quantity__general'])[1]")).getText()));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[1]")).click();
        quantityOfSecondProductsInStock = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[@class='item-quantity__general'])[2]")).getText()));
        driver.findElement(By.xpath("(//*[@class='quantity-selector__increment'])[2]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='catalog__basket-quantity-value']"), "2"));
        navigationToCart();
    }

    public void checkingThatThereAreTwoProductsInTheCart() {
        Assert.assertEquals(driver.findElements(By.xpath("//*[contains(@class, 'basket__item')][not(contains(@class,'expend'))]")).size(), 2);
        driver.navigate().refresh();
        implicitWaiting();
        Assert.assertEquals(driver.findElements(By.xpath("//*[contains(@class, 'basket__item')][not(contains(@class,'expend'))]")).size(), 2);
    }

    public void checkingThatThereAreOneActiveProductInTheCart() {
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(@class, 'basket__item')][not(contains(@class,'expend'))]")).size() == 1);
        checkingThatCartIconHavePictureOfThePresenceOfOneProductInTheBasket(1);
    }

    public void checkingThatInCartOnlyOneProduct(){
        clickElement(buttonMakeOrderInTheCartLocator);
        showProductsInTheCartOnTheMakingOrderPage();
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(@id, 'DataTables')] /tbody /tr")).size() == 1);
    }

    public void deleteTheFirstProductFromTheCart() {
        tempString = driver.findElement(By.xpath("//*[@class='basket__product-name ']")).getText();
        System.out.println(tempString);
        driver.findElement(By.xpath("//*[@data-entity='basket-item-checkbox']")).click();
        driver.findElement(buttonForDeletingProductsInCartLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-entity='basket-item-restore-button']")));
        implicitWaiting();
    }

    public void restoreTheFirstProductInTheCart() {
        driver.findElement(By.xpath("//*[@data-entity='basket-item-restore-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()= '" + tempString + "']")));
        implicitWaiting();
    }

    public void checkingThatAllCheckboxesAreSelected() {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@data-entity='basket-item-checkbox']")).size(); i++) {
            Assert.assertTrue(driver.findElement(By.xpath("(//*[@data-entity='basket-item-checkbox'])[" + i + "] //*[contains(@class, 'state-checked')]")).isDisplayed()
                    , "Не все чекбоксы выбрались");
        }
    }

    int pieceQuantityOfItemsInTheCart = 0;

    public void sumPieceQuantityItemsInTheCart() {
        pieceQuantityOfItemsInTheCart = 0;
        for (int i = 1; i <= driver.findElements(By.xpath("//*[contains(@id, 'basket-item-quantity')]")).size(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@id, 'basket-item-quantity')])[" + i + "]")));
            try {
                pieceQuantityOfItemsInTheCart = (pieceQuantityOfItemsInTheCart + Integer.valueOf(driver.findElement(By.xpath("(//*[contains(@id, 'basket-item-quantity')])[" + i + "]")).getAttribute("value")));
            } catch (Exception e) {
                System.out.println("Тупая ошибка, скрипты меняют данные после отрисовки");
                implicitWaiting();
                pieceQuantityOfItemsInTheCart = (pieceQuantityOfItemsInTheCart + Integer.valueOf(driver.findElement(By.xpath("(//*[contains(@id, 'basket-item-quantity')])[" + i + "]")).getAttribute("value")));
            }
        }
    }

    public void addingAndCheckThatAdditionalProductIsAddedTenTimes() {
        int tempCountForBreakCircle;
        int pieceQuantityOfItemsInTheCartAfterAddingItem = 0;
        sumPieceQuantityItemsInTheCart();
        pieceQuantityOfItemsInTheCartAfterAddingItem = pieceQuantityOfItemsInTheCart;

        for (int i = 1; i <= 10; i++) {
            tempRandomNumber = 1 + (int) (Math.random() * driver.findElements(By.xpath("//*[@class='catalog-list__body'] //*[@class='input-group-append']")).size());
            clickElement("(//*[@class='catalog-list__body'] //*[@class='input-group-append'])[" + tempRandomNumber + "]");
            sumPieceQuantityItemsInTheCart();
            tempCountForBreakCircle = 0;
            while (pieceQuantityOfItemsInTheCartAfterAddingItem == pieceQuantityOfItemsInTheCart) {
                implicitWaiting();
                sumPieceQuantityItemsInTheCart();
                tempCountForBreakCircle++;
                if (tempCountForBreakCircle > 5) {
                    driver.findElement(By.xpath("(//*[@class='catalog-list__body'] //*[@class='input-group-append'])[" + tempRandomNumber + "]")).click();
                    implicitWaiting();
                    implicitWaiting();
                    implicitWaiting();
                    implicitWaiting();
                    sumPieceQuantityItemsInTheCart();
                    Assert.assertTrue(pieceQuantityOfItemsInTheCart > pieceQuantityOfItemsInTheCartAfterAddingItem);
                }
            }
            pieceQuantityOfItemsInTheCartAfterAddingItem = pieceQuantityOfItemsInTheCart;

//            tempDouble2 = 0;
//            for (int y = 1; y <= driver.findElements(By.xpath("//*[contains(@id, 'basket-item-quantity')]")).size(); y++) {
//                tempDouble2 = tempDouble2 + Double.valueOf(driver.findElement(By.xpath("(//*[contains(@id, 'basket-item-quantity')])[" + y + "]")).getAttribute("value"));
//            }
//            Assert.assertTrue(tempDouble2 > tempDouble, "Я не смог добавить этот товар -  " + tempRandomNumber + " -- это его порядковый номер в таблице доп. товаров");
//            tempDouble = tempDouble2;
        }
    }

    public void addingToSearchFieldWordForSearchInTheCart() {
        driver.findElement(By.cssSelector(".search-group__input")).sendKeys("бензин");
        driver.findElement(By.cssSelector(".search-group__input")).sendKeys(Keys.ENTER);
        implicitWaiting();
    }

    public void checkingThatAllProductsInTheCarContainsWordForSearch() {
        for (int i = 1; i <= driver.findElements(By.cssSelector(".basket__product-name ")).size(); i++) {
            Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='basket__product-name '])[" + i + "]")).getText().contains("бензин"));
        }
    }

    public void addingToSearchFieldWordForSearchInAdditionalProducts() {
        driver.findElement(By.xpath("//*[@placeholder='Название']")).sendKeys("бензин");
        driver.findElement(By.xpath("//*[contains(@class, 'filter')]/*[contains(@class, 'btn_b2b')]")).click();
        implicitWaiting();
        implicitWaiting();
    }

    public void addingToSearchFieldWordForSearchAdditionalProductsGefestGasStove() {
        hideAdminPanel();
        driver.findElement(By.xpath("//*[@placeholder='Название']")).sendKeys("Плита GEFEST");
        waitingMilliSecond();
        clickElement("//*[contains(@class, 'filter')]/*[contains(@class, 'btn_b2b')]");
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".catalog-list__name"), 1));
        }catch (Exception e){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! зашел");
            clickElement("//*[contains(@class, 'filter')]/*[contains(@class, 'btn_b2b')]");
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".catalog-list__name"), 1));
        }
    }

    public void checkingThatAllAdditionalProductsContainsWordForSearch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'бензин')]")));
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@class='catalog-list__name']")).size(); i++) {
            clickElement("(//*[@class='form-control'][not(ancestor-or-self::*[@placeholder])])[" + i + "]");
            scrollToTheElement("(//*[@class='catalog-list__name'])[" + i + "]");
            Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='catalog-list__name'])[" + i + "]")).getText().contains("бензин"));
        }
    }

    public void checkingThatAllAdditionalProductsBelongThisSection() {
        checkingThatAllAdditionalProductsContainsWordForSearch();
    }

    String[] wordsForCheck = new String[9];
    String[] wordsForSearch = new String[9];
    public String wordForSearch;

    public void selectRandomSection() {
        wordsForCheck[0] = "лит";
        wordsForCheck[1] = "тиральн";
        wordsForCheck[2] = "олодильник";
        wordsForCheck[3] = "бензин";
        wordsForCheck[4] = "азонокос";
        wordsForCheck[5] = "ышь";
        wordsForCheck[6] = "кабин";
        wordsForCheck[7] = "анн";
        wordsForCheck[8] = "лавиатур";

        wordsForSearch[0] = "Кухонные плиты";
        wordsForSearch[1] = "Стиральные машины";
        wordsForSearch[2] = "Холодильники";
        wordsForSearch[3] = "Бензопилы";
        wordsForSearch[4] = "Газонокосилки";
        wordsForSearch[5] = "Мыши";
        wordsForSearch[6] = "Душевые кабины и уголки";
        wordsForSearch[7] = "Ванны";
        wordsForSearch[8] = "Клавиатуры";

        tempRandomNumber = 0 + (int) (Math.random() * 8);
        System.out.println("Категория которую буду выбирать - " + wordsForSearch[tempRandomNumber]);
        driver.findElement(By.xpath("//*[@placeholder='Раздел']")).click();
        implicitWaiting();
        clickElement("//*[@class='filter__SectionsSelect'] //*[contains(text(), '" + wordsForSearch[tempRandomNumber] + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".filter__selected-item")));
        driver.findElement(By.xpath("//*[contains(@class, 'filter')]/*[contains(@class, 'btn_b2b')]")).click();
        implicitWaiting();
        implicitWaiting();
    }

    public void checkThatAllProductsHaveThisWord() {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@class='catalog-list__name']")).size(); i++) {
            tempString = wordsForCheck[tempRandomNumber];
            Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='catalog-list__name'])[" + i + "]")).getText().contains(tempString));
        }
    }

    public void checkingThatOnlyGefestGasStoveIsDisplayedInAdditionalProducts() {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='catalog-list__name']")).size() == 1);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='catalog-list__name']")).getText().contains("Плита GEFEST"));
    }

    public void navigationToCatalogUsingTheHyperlinkClickHere() {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='card-title']//*[contains(@href, 'blank')]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".catalog")).isDisplayed());
    }

    public void selectingSectionByPartOfItsName() {
        driver.findElement(By.xpath("//*[@placeholder='Раздел']")).sendKeys("бенз");
        implicitWaiting();
        scrollToTheElementByCss(".filter__SectionsSelect");
        clickElementByItsCssSelector(".filter__SectionsSelect");
    }

    public void checkingThatSectionFieldIsEmpty() {
        scrollToTheElement("//*[@placeholder='Раздел']");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@placeholder='Раздел']")).getAttribute("value").equals(""));
    }

    public void applyTheOutputOfThisSection() {
        clickElement("//*[contains(@class, 'filter')]/*[contains(@class, 'btn_b2b')]");
    }

    public void checkingThatThePricesInTheCartForAdditionalProductsIsDisplayedAsForSmallOptGroup() {
        for (int i = 1; i < 10; i++) {
            if (driver.findElement(By.xpath("(//*[@class='catalog-list__header']//*[contains(@class, 'catalog-list__column')])[" + i + "]")).getText().contains("цен")) {
                count = i;
                break;
            }
        }
        tempDouble2 = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("((//*[@class='catalog-list__body']//*[contains(@class, 'catalog-list__column')])[" + count + "])/*[1]")).getText()));
        Assert.assertTrue(tempDouble == tempDouble2);
        driver.findElement(By.xpath("(//*[@class='catalog-list__body'] //*[@class='input-group-append'])")).click();
        enteringNumberInTheInputField("1", "(//*[@class='catalog-list__body'] //*[@class='form-control'])");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket__product-name")));
        implicitWaiting();
        Assert.assertTrue(tempDouble == Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("((//*[@class = 'basket__column-price-wrap'])[2])/*[1]")).getText())));
        Assert.assertTrue(tempDouble == Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("//*[@class='basket-page__total-price-value']")).getText())));
    }

    public void checkingTheDiscountAmountAndTheAvailablePriceWithoutDiscount() {
        tempDouble = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("//*[@class='basket__full-price-formated']")).getText()));
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@class='basket__header'] //*[contains(@class, 'basket__column ')]")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[@class='basket__header'] //*[contains(@class, 'basket__column ')])[" + i + "]")).getText().contains("Скидк")) {
                count = i;
                break;
            }
        }
        tempDouble2 = Double.valueOf(replacingSomeSymbols(driver.findElement(By.xpath("(//*[contains(@class, 'basket__item')] //*[contains(@class, 'basket__column ')])[" + count + "]")).getText()));
        basePriceRandomProduct = basePriceRandomProduct / coefficientForQuantityOfProducts;
        System.out.println("Доступная пользователю цена - " + basePriceRandomProduct);
        System.out.println("Размер скидки - " + tempDouble2);
        System.out.println("Доступная пользователю цена БЕЗ учета скидки - " + tempDouble);
        Assert.assertTrue(basePriceRandomProduct + tempDouble2 == tempDouble);
    }


    public void sendRequestToTopUpYourPersonalAccountForOneHundredRubles() {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@class='card-body blank_invoices-payment_method']//*[@class='nav-item']")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[@class='card-body blank_invoices-payment_method']//*[@class='nav-item'])[" + i + "]")).getText().contains("Наличные курьеру")) {
                driver.findElement(By.xpath("(//*[@class='card-body blank_invoices-payment_method']//*[@class='nav-item'])[" + i + "]")).click();
                break;
            }
        }
        driver.findElement(By.cssSelector(".btn-pay")).click();
        try {
            driver.findElement(By.cssSelector(".blank_invoices-pay_button")).click();
        } catch (Exception e) {
            scrollDown();
            driver.findElement(By.cssSelector(".blank_invoices-pay_button")).click();
        }
    }

    public void checkingConfirmInformationThatTheRequestIsSent() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='bx-sap blank_personal'] //*[contains(text(), '№')]")).isDisplayed());
        tempValue = driver.findElement(By.xpath("//*[@class='bx-sap blank_personal'] //*[contains(text(), '№')]")).getText().replaceAll("№", "");
    }

    public void checkingThatTheRequestForReplenishmentOfThePersonalAccountIsDisplayedByTheAdmin(String numberOrder) {
        System.out.println(numberOrder);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='№" + numberOrder + "']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='№" + numberOrder + "']")).isDisplayed());
    }

    public void addMoneyToTheUserSPersonalAccount(String emailUserForDoc) {
        MethodsForDocuments methodsForDocument = new MethodsForDocuments();
        driver.findElement(By.xpath("//*[contains(@href, 'sale_account_edit')]")).click();
        driver.findElement(By.cssSelector(".tablebodybutton")).click();
        methodsForDocument.choiceUserFromJustOpenedPage(emailUserForDoc);
        driver.findElement(By.xpath("//*[@name='CURRENT_BUDGET']")).sendKeys("111");
        driver.findElement(buttonSaveLocator).click();
    }

    public void checkingThatTheUserHasBeenAddedMoneyToHisPersonalAccount() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".form-control.blank_invoices-amount")).getAttribute("placeholder").contains("111"));
    }

    public void addUserParameterInTheSettingsOnTheMainPage() {
        if (driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='HIDE']")).isSelected()) {
            driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='HIDE']")).click();
        }
        if (!driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='WORK_COMPANY']")).isSelected()) {
            driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='WORK_COMPANY']")).click();
        }
        driver.findElement(By.cssSelector("#bx-comp-params-save-button")).click();
    }

    public void checkingThatNewUserParameterInTheSettingsOnTheMainPageISDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Информация о работе']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Информация о работе']")).isDisplayed());
    }

    public void deletingAddedUserParameterInTheSettingsOnTheMainPage() {
        if (!driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='HIDE']")).isSelected()) {
            driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='HIDE']")).click();
        }
        if (driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='WORK_COMPANY']")).isSelected()) {
            driver.findElement(By.xpath("//*[contains(@for, 'USER_PROPERTY_WORK_INFORMATION')] /following::*[1] //*[@value='WORK_COMPANY']")).click();
        }
        driver.findElement(By.cssSelector("#bx-comp-params-save-button")).click();
    }

    public void enteredDataInAddedUserParameter() {
        scrollToTheElement(By.xpath("//*[@name='WORK_COMPANY']"));
        driver.findElement(By.xpath("//*[@name='WORK_COMPANY']")).clear();
        System.out.println(randomData);
        driver.findElement(By.xpath("//*[@name='WORK_COMPANY']")).sendKeys(randomData);
    }

    public void checkingThatEnteredDataIsDisplayed() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='WORK_COMPANY']")).getAttribute("value"), randomData);
    }

    public void checkingThatBreadCrumbHaveSelectedCategories() {
        tempValue5 = driver.findElement(By.cssSelector(".breadcrumb")).getText();
        Assert.assertTrue(tempValue5.contains(tempValue1));
        Assert.assertTrue(tempValue5.contains(tempValue2));
        Assert.assertTrue(tempValue5.contains(tempValue3));
    }

    public void checkingThatAllProductsHaveASimilarIdToTheSectionId() { //ВЫРЕЗАЛИ ID
//        System.out.println("ID раздела - " + tempValue4);
//        count = 1;
//        flag = false;
//        while (!flag) {
//            for (int i = 1; i <= driver.findElements(By.xpath("//*[@class='product__link']")).size(); i++) {
//                tempValue5 = driver.findElement(By.xpath("(//*[@class='product__link'])[" + i + "]")).getAttribute("href");
//                tempValue5 = tempValue5.substring(tempValue5.indexOf('=') + 1);
//                tempValue5 = tempValue5.substring(0, tempValue5.indexOf('&'));
//                System.out.println("Id товара № " + i + " настранице № " + count + " - " + tempValue5);
//                Assert.assertTrue(Integer.parseInt(tempValue5) >= Integer.parseInt(tempValue4));
//                Assert.assertTrue((Integer.parseInt(tempValue4) + 10) >= Integer.parseInt(tempValue5));
//            }
//            try {
//                driver.findElement(By.xpath("//*[@class='page-item next']")).click();
//                System.out.println();
//                System.out.println("Выбрал следующую старницу с товарами категории");
//                System.out.println();
//                count++;
//            } catch (Exception e) {
//                System.out.println();
//                System.out.println("Больше страниц с товарами категории нет, всего страниц - " + count);
//                System.out.println();
//                flag = true;
//            }
//        }
    }

    public void configureTheMenuOutputToTheRightSideOfTheScreen() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sotbit.b2bcabinet_settings.php?mid=sotbit.b2bcabinet&lang=ru&site=s1");
        scrollToTheElement("//*[@id='MENU_POSITION']");
        driver.findElement(By.cssSelector("#MENU_POSITION")).click();
        driver.findElement(By.xpath("//*[@value='RIGHT']")).click();
        driver.findElement(buttonSaveLocator).click();
        navigationToMeanPageByUrl();
    }

    public void configureTheMenuOutputToTheLeftSideOfTheScreen() {
        driver.navigate().to(b2bUrl.replaceAll("b2bcabinet/", "") + "bitrix/admin/sotbit.b2bcabinet_settings.php?mid=sotbit.b2bcabinet&lang=ru&site=s1");
        scrollToTheElement("//*[@id='MENU_POSITION']");
        driver.findElement(By.cssSelector("#MENU_POSITION")).click();
        driver.findElement(By.xpath("//*[@value='LEFT']")).click();
        driver.findElement(buttonSaveLocator).click();
        navigationToMeanPageByUrl();
    }

    public void checkingThatTheMenuIsOnTheRightSideOfTheScreen() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'b2bcabinet-sidebar-right')]")).isDisplayed());
    }

    public void checkingThatTheMenuIsOnTheLeftSideOfTheScreen() {
        Assert.assertEquals(0, driver.findElements(By.xpath("//*[contains(@class, 'b2bcabinet-sidebar-right')]")).size());
    }

    public void determineMaxPriceForFilteringAThousandLessThanThePriceOfTheMostExpensiveProductInThisSection() {
        try {
            maxPriceForFiltering = String.valueOf(Double.valueOf(driver.findElement(By.cssSelector(".max-price")).getAttribute("placeholder")) - 1000);
        } catch (Exception e) {
            System.out.println("В фильтре нет поля (или плэйсхолдера) для ввода максимальной цены, меняю категорию");
        }
        try {
            navigationToMeanPageByUrl();
            choiceRandomCategoryInMenuCatalog(false);
            maxPriceForFiltering = String.valueOf(Double.valueOf(driver.findElement(By.cssSelector(".max-price")).getAttribute("placeholder")) - 1000);
        } catch (Exception e) {
            System.out.println("В фильтре нет поля (или плэйсхолдера) для ввода максимальной цены (снова), меняю категорию");
            navigationToMeanPageByUrl();
            choiceRandomCategoryInMenuCatalog(false);
            maxPriceForFiltering = String.valueOf(Double.valueOf(driver.findElement(By.cssSelector(".max-price")).getAttribute("placeholder")) - 1000);
        }
    }

    public void determineMinPriceForFilteringAThousandMoreThanThePriceOfTheMostCheapProductInThisSection() {
        try {
            minPriceForFiltering = String.valueOf(Double.valueOf(driver.findElement(By.cssSelector(".min-price")).getAttribute("placeholder")) + 1000);
        } catch (Exception e) {
            System.out.println("В фильтре нет поля (или плэйсхолдера) для ввода минимальной цены, меняю категорию");
        }
        try {
            navigationToMeanPageByUrl();
            choiceRandomCategoryInMenuCatalog(false);
            minPriceForFiltering = String.valueOf(Double.valueOf(driver.findElement(By.cssSelector(".min-price")).getAttribute("placeholder")) + 1000);
        } catch (Exception e) {
            System.out.println("В фильтре нет поля (или плэйсхолдера) для ввода минимальной цены (снова), меняю категорию");
            navigationToMeanPageByUrl();
            choiceRandomCategoryInMenuCatalog(false);
            minPriceForFiltering = String.valueOf(Double.valueOf(driver.findElement(By.cssSelector(".min-price")).getAttribute("placeholder")) + 1000);
        }
    }

    public void rememberQuantityProductsOnThisPage() {
        tempInt = driver.findElements(By.xpath("//*[@class='product__link']")).size();
    }

    public void applyTheFirstProperty() {
        expendFilterInCatalog();
        driver.findElement(By.xpath("//*[@type='checkbox']/following::*[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#set_filter")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#modef")));
        waitingMilliSecond();
        waitingMilliSecond();
        clickElementByItsCssSelector("#set_filter");
    }

    public void checkingThatQuantityProductsOnThisPageAreDecreased() {
        System.out.println(driver.findElements(By.xpath("//*[@class='product__link']")).size());
        Assert.assertTrue(tempInt > driver.findElements(By.xpath("//*[@class='product__link']")).size());
    }

    public void showProductsInTheCartOnTheMakingOrderPage() {
        if (driver.findElements(By.cssSelector(".list-icons-item.rotate-180")).size() > 0) {
            driver.findElement(By.xpath("//*[@data-action='collapse'][contains(@class, 'rotate')]")).click();
            waitingMilliSecond();
        }
    }

    public void highlightsAllProductsInTheCart() {
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
    }

    public void configuringDirectoryOutputInTheNavigationMenu() {
        if (driver.findElements(By.xpath("//*[contains(@class, 'nav-item-submenu')] /*[contains(@href, 'blank_zakaza')]")).size() == 0) {
            navigationToBasicB2BSettings();
            driver.findElement(By.xpath("//*[contains(@title, 'Каталог ')]")).click();
            driver.findElement(By.cssSelector("#CATALOG_SHOW_SECTIONS")).click();
            driver.findElement(By.xpath("//*[@value='MENU']")).click();
            driver.findElement(buttonSaveLocator).click();
            implicitWaiting();
            navigationToMeanPageByUrl();
        }
    }

    public void selectTapForIP() {
        driver.findElement(By.xpath("//*[contains(@title, 'ндивидуальный')]")).click();
    }

    public void selectTapForLegalPerson() {
        driver.findElement(By.xpath("//*[contains(@title, 'ридическое')]")).click();
    }

    public void selectGroupsOfOrderPropertiesWhenChangingWhichTheOrganizationGetsToModeration(String keyWordThisGroup) {
        if (!driver.findElement(By.xpath("//*[contains(@style, 'visible')]//*[contains(@id, 'COMPANY_PROPS')]/*[contains(text(), '" + keyWordThisGroup + "')]")).isSelected()) {
            driver.findElement(By.xpath("//*[contains(@style, 'visible')]//*[contains(@id, 'COMPANY_PROPS')]/*[contains(text(), '" + keyWordThisGroup + "')]")).click();
        }
    }

    public void unselectGroupsOfOrderPropertiesWhenChangingWhichTheOrganizationGetsToModeration(String keyWordThisGroup) {
        if (driver.findElement(By.xpath("//*[contains(@style, 'visible')]//*[contains(@id, 'COMPANY_PROPS')]/*[contains(text(), '" + keyWordThisGroup + "')]")).isSelected()) {
            driver.findElement(By.xpath("//*[contains(@style, 'visible')]//*[contains(@id, 'COMPANY_PROPS')]/*[contains(text(), '" + keyWordThisGroup + "')]")).click();
        }
    }

    public void changeINNOnTheOrganizationPage() {
        iNNManual = randomNumber(14);
        driver.findElement(By.xpath("//*[contains(text(),'ИНН:')]/following::*[1]")).clear();
        driver.findElement(By.xpath("//*[contains(text(),'ИНН:')]/following::*[1]")).sendKeys(iNNManual);
        nameCompany = driver.findElement(By.xpath("//*[contains(text(), 'азвание компании')] /following::input[1]")).getAttribute("value");
    }

    public void changeEmailOnTheOrganizationPage() {
        driver.findElement(By.xpath("//*[contains(text(),'ail')]/following::*[1]")).clear();
        driver.findElement(By.xpath("//*[contains(text(),'ail')]/following::*[1]")).sendKeys(email);
        nameCompany = driver.findElement(By.xpath("//*[contains(text(), 'азвание компании')] /following::input[1]")).getAttribute("value");
    }

    public void checkingThatDataWasChangedWithoutModeration() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".form-edit__success")).isDisplayed());
    }

    public void creatingLegalPersonOrganization() {
        org.navigationToAddOrganizationTab();
        org.selectionFromDropDownListLegalPerson();
        org.fillingFieldsForCreatingOrganization();
        org.creatingOrganization();
        nameCompany = org.nameCompany;
        confirmRegistrationOfOrganizationFromAdmin();
        checkingThatOrganizationIsConfirmed();
    }

    public void creatingIPOrganization() {
        MethodsForAddingOrganizationsWithExtendedVersion org = new MethodsForAddingOrganizationsWithExtendedVersion();
        org.navigationToAddOrganizationTab();
        org.selectionFromDropDownListIndividualBusinessman();
        org.fillingFieldsForCreatingOrganization();
        org.creatingOrganization();
        nameCompany = org.nameCompany;
        confirmRegistrationOfOrganizationFromAdmin();
        checkingThatOrganizationIsConfirmed();
    }

    public void changingDataLegalPersonOrganizationWhichNeededConfirmAndNot() {
        org.openFirstOrganizationOnTheOrganizationTabForChange();
        changeEmailOnTheOrganizationPage();
        clickStandardButtonForSaveSettings();
        standardConfirmationOfTheActionOnThePage();
        confirmRegistrationOfOrganizationFromAdmin();
        navigationToOrganizationTab();
        org.openFirstOrganizationOnTheOrganizationTabForChange();
        changeINNOnTheOrganizationPage();
        clickStandardButtonForSaveSettings();
        checkingThatDataWasChangedWithoutModeration();
    }

    public void changingDataIPOrganizationWhichNeededConfirmAndNot() {
        org.openFirstOrganizationOnTheOrganizationTabForChange();
        changeINNOnTheOrganizationPage();
        clickStandardButtonForSaveSettings();
        standardConfirmationOfTheActionOnThePage();
        confirmRegistrationOfOrganizationFromAdmin();
        navigationToOrganizationTab();
        org.openFirstOrganizationOnTheOrganizationTabForChange();
        changeEmailOnTheOrganizationPage();
        clickStandardButtonForSaveSettings();
        checkingThatDataWasChangedWithoutModeration();
    }

    By UserDataWhenRegisteringAnOrganizationAsIPLocator = By.xpath("//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_FIELDS')] /*[@value]");

    public void deselectAllUserDataForRegisteringAnOrganization() {
        for (int i = 1; i <= driver.findElements(UserDataWhenRegisteringAnOrganizationAsIPLocator).size(); i++) {
            By UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator = By.xpath("(//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_FIELDS')] /*[@value])[" + i + "]");
            if (driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).isSelected()) {
                driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).click();
            }
        }
        driver.findElement(buttonSaveLocator).click();
        refreshingThisPage();
    }

    public void selectAllUserDataForRegisteringAnOrganizationOneAtATimeCheckingThatTheyAppearedInTheRequiredFieldsField() {
        tempValue = "";
        tempValue2 = "";
        for (int i = 1; i <= driver.findElements(UserDataWhenRegisteringAnOrganizationAsIPLocator).size(); i++) {
            By UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator = By.xpath("(//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_FIELDS')] /*[@value])[" + i + "]");
            tempString = driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).getAttribute("value");
            tempValue = driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).getText();
            tempValue2 = tempValue2 + tempValue;
            driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).click();
            driver.findElement(buttonSaveLocator).click();
            refreshingThisPage();
            By UserRequiredDataWhenRegisteringAnOrganizationAsIPForCycleLocator = By.xpath("(//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_REQUIRED_FIELDS')] /*[@value])[" + i + "]");
            Assert.assertTrue(driver.findElement(UserRequiredDataWhenRegisteringAnOrganizationAsIPForCycleLocator).getAttribute("value")
                    .contains(tempString));
        }
    }

    public void selectTheFirstTwoProperties() {
        tempValue = "";
        tempValue2 = "";
        for (int i = 1; i <= 2; i++) {
            By UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator = By.xpath("(//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_FIELDS')] /*[@value])[" + i + "]");
            tempString = driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).getAttribute("value");
            tempValue = driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).getText();
            tempValue2 = tempValue2 + tempValue;
            driver.findElement(UserDataWhenRegisteringAnOrganizationAsIPForCycleLocator).click();
            driver.findElement(buttonSaveLocator).click();
            refreshingThisPage();
            By UserRequiredDataWhenRegisteringAnOrganizationAsIPForCycleLocator = By.xpath("(//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_REQUIRED_FIELDS')] /*[@value])[" + i + "]");
            Assert.assertTrue(driver.findElement(UserRequiredDataWhenRegisteringAnOrganizationAsIPForCycleLocator).getAttribute("value")
                    .contains(tempString));
        }
    }

    public void selectARequiredProperty() {
        driver.findElement(By.xpath(
                        "(//*[contains(text(), 'Индивидуальный предприниматель')][@class = 'adm-detail-title']/following::*[1] //*[contains(@id, 'GROUP_REQUIRED_FIELDS')] /*[@value='TITLE'])"))
                .click();
        driver.findElement(buttonSaveLocator).click();
        refreshingThisPage();
    }

    public void checkingThatAllUserDataForIPSelectedInTheAdminPanelIsDisplayedWhenRegisteringTheOrganization() {
        registr.choiceIP();
        for (int i = 3; i <= driver.findElements(By.xpath("(//*[@class='card'] //*[@class='card-body'])[1] /*[@class='row']")).size(); i++) {

            tempValue = driver.findElement(By.xpath("((//*[@class='card'] //*[@class='card-body'])[1] /*[@class='row'])[" + i + "]"))
                    .getText().replaceAll(":", "");
            tempValue = tempValue.replaceAll("[(]", "");
            tempValue = tempValue.replaceAll("работа", "");
            tempValue = tempValue.replaceAll("[*]", "");
            tempValue = tempValue.replaceAll("[)]", "").trim();
            System.out.println(tempValue);
            System.out.println(tempValue2);
            Assert.assertTrue(tempValue2.contains(tempValue));
        }
    }

    public void checkingThatTheFieldSelectedInTheAdminPanelAsRequiredIsReallyRequired() {
//        determineWhetherVersionsOfWorkingWithOrganization();
//        if (versionsOfWorkingWithOrganizationsExtended){
//            MethodsForRegistrationAndAuthorization reg = new MethodsForRegistrationAndAuthorization();
//            //arrange
//            navigationToRegistrationTab();
//            //act
//            reg.determineRadioButton();
//            reg.choiceIPForCreatingLocators();
//            try{
//                reg.enterINNManually();
//            }catch (Exception e){}
//            reg.creatingArrayWithExistingLocatorsForIP();
//            reg.writingArrayWithLocatorsForIPOnComputer();
//            navigationToRegistrationTab();
//            reg.choiceIP();
//            reg.enterINNManually();
//            reg.fillingFieldsOnTheRegistrationTab(reg.arrayWithExistingLocatorsForIP);
//            driver.findElement(By.xpath("//*[contains(text(), 'Обращение')][not(ancestor-or-self::*[@style = 'display: none;'])] /following::*[2]")).clear();
//            driver.findElement(registr.registerButtonOnRegistrationTabLocator).click();
//            Assert.assertTrue(driver.findElement(By.cssSelector(".errortext")).isDisplayed());
//        }else {
//            Assert.assertTrue(driver.findElement(By.xpath(
//                            "//*[contains(text(), 'Обращение')][not(ancestor-or-self::*[@style = 'display: none;'])] /following::*[2][@required]"))
//                    .isDisplayed());
//        } // была разная логика пометки полей как "обязательные", пока просто добавляет тег "required"
        Assert.assertTrue(driver.findElement(By.xpath(
                        "//*[contains(text(), 'Обращение')][not(ancestor-or-self::*[@style = 'display: none;'])] /following::*[2][@required]"))
                .isDisplayed()); //баг 1.11.2, Алеся оофрмила уже
    }

    public void addingThisProductFromPopUpWindowToTheCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_search__product-add >*")));
        implicitWaiting();
        driver.findElement(By.cssSelector(".btn_search__product-add >*")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-cross']")));
        driver.findElement(By.xpath("//i[@class='icon-cross']")).click();
        driver.findElement(fieldForSearchInCatalogLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-checkmark3")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".icon-checkmark3")).isDisplayed()); //галка которая вресто корзинки в поп-ап окне отображается
        checkingThatThereAreNoCartIconInPupOpWindow(); //корзинка которая в поп-ап окне отображается до добавления товара пропала
    }

    public void checkingThatThisProductWasAddedToTheCart() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".basket__product-discrioption")).getText().contains(wordForSearch));
    }

    public void checkingThatThereAreNoCartIconInPupOpWindow() {
        Assert.assertTrue(driver.findElements(By.cssSelector(".btn_search__product-add")).size() == 0); //корзинка в поп-ап окне отсутсвует
    }

    public void openCatalogInFullScreen() {
        while (driver.findElements(By.xpath("//*[@data-action='fullscreen'][@data-fullscreen='active']")).size() == 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-action='fullscreen']")));
            driver.findElement(By.xpath("//*[@data-action='fullscreen']")).click();
            implicitWaiting();
        }
    }

    public void closeCatalogInFullScreen() {
        while (driver.findElements(By.xpath("//*[@data-action='fullscreen'][@data-fullscreen='active']")).size() != 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-action='fullscreen']")));
            driver.findElement(By.xpath("//*[@data-action='fullscreen']")).click();
            implicitWaiting();
        }
    }

    public void checkingThatCatalogIsOpenToFullScreen() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-fullscreen='active']")).isDisplayed());
    }

    int quantityItemsInTheCart;
    int randomNumberItemInTheCart;

    public void choiceRandomProductInTheCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket__item")));
        quantityItemsInTheCart = driver.findElements(By.cssSelector(".basket__product-discrioption")).size();
        randomNumberItemInTheCart = 1 + (int) (Math.random() * quantityItemsInTheCart);
        driver.findElement(By.xpath("(//*[@class='basket__checkbox'])[" + (randomNumberItemInTheCart + 1) + "]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket__checkbox_content.state-checked")));
        implicitWaiting();
    }

    public void checkingThatSuchNumberOfSelectedProductsAppearedInTheBasket(int ExpectedQuantitySelectedItems) {
        Assert.assertEquals(driver.findElements(By.xpath("//*[contains(@class, 'basket__item')] /*[contains(@class, 'basket__column')] /*[contains(@class, 'basket__checkbox')] /*[contains(@class, 'checked')]")).size()
                , ExpectedQuantitySelectedItems);
    }

    public void restoreJustDeletedItemInTheCart() {
        quantityItemsInTheCart = driver.findElements(By.cssSelector(".basket__product-discrioption")).size();
        driver.findElement(By.cssSelector(".basket-item-restore-button")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".basket-item-restore-button")));
        refreshingThisPage();
        Assert.assertEquals(driver.findElements(By.cssSelector(".basket__product-discrioption")).size(), quantityItemsInTheCart);
    }

    public void deletingSelectedProducts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-trash")));
        driver.findElement(By.cssSelector(".icon-trash")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket-item-restore-button")));
    }

    public void checkingThatProductWasDeleted(int quantityItemsInTheCart) {
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(".basket__product-discrioption"), quantityItemsInTheCart));
    }

    Double calculatedSumOfAllPricesInTheCart = 0.0;

    public void checkingThatTheAmountOfPricesHasBeenRecalculatedTakingIntoAccountTheDeletedItem() {
        quantityItemsInTheCart = driver.findElements(By.cssSelector(".basket__product-discrioption")).size();
        calculationOfAllPricesOfGoodsInTheBasket();
        Double priceJustDeletedProduct = Double.valueOf(replacingSomeSymbols(
                driver.findElement(By.xpath("(//*[contains(@class, 'busket__column__font-bold')])[" + randomNumberItemInTheCart + "]"))
                        .getText()));
        calculatedSumOfAllPricesInTheCart = calculatedSumOfAllPricesInTheCart - priceJustDeletedProduct;
        checkingThatCurrentSumOfAllPricesInTheCartIsEqualsCalculatedSum(calculatedSumOfAllPricesInTheCart);
    }

    public void checkingThatCurrentSumOfAllPricesInTheCartIsEqualsCalculatedSum(Double calculatedSumOfAllPricesInTheCart) {
        Double currentSumOfAllPricesInTheCart = Double.valueOf(replacingSomeSymbols(driver.findElement(By.cssSelector(".basket-page__total-price-value")).getText()));
        Assert.assertEquals(calculatedSumOfAllPricesInTheCart, currentSumOfAllPricesInTheCart);
    }

    public void calculationOfAllPricesOfGoodsInTheBasket() {
        quantityItemsInTheCart = driver.findElements(By.cssSelector(".basket__product-discrioption")).size();
        calculatedSumOfAllPricesInTheCart = 0.0;
        for (int i = 1; i <= quantityItemsInTheCart; i++) {
            calculatedSumOfAllPricesInTheCart = calculatedSumOfAllPricesInTheCart + Double.valueOf(replacingSomeSymbols(
                    driver.findElement(By.xpath("(//*[contains(@class, 'busket__column__font-bold')])[" + i + "]"))
                            .getText()));
        }
        System.out.println("Сумма всех товаров в корзине - " + calculatedSumOfAllPricesInTheCart);
    }

    public void chooseAllProductInTheCart() {
        quantityItemsInTheCart = driver.findElements(By.cssSelector(".basket__product-discrioption")).size();
        for (int i = 1; i <= quantityItemsInTheCart; i++) {
            driver.findElement(By.xpath("(//*[contains(@class, 'basket__item')] /*[contains(@class, 'basket__column')] /*[contains(@class, 'basket__checkbox')])[" + i + "]"))
                    .click();
        }
    }

    public void checkingThatCheckboxThatAllProductsSelectedIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-entity='basket-gruope-item-checkbox']/*[contains(@class, 'checked')]")).isDisplayed());
    }

    public void checkingThatCheckboxThatAllProductsSelectedIsNotDisplayed() {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@data-entity='basket-gruope-item-checkbox']/*[contains(@class, 'checked')]")).size() == 0);
    }



    public void expendFilterInCatalog(){
        if (browserWindowWidth <= 1100){
            driver.findElement(By.cssSelector(".catalog__filter-toggler")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bx_filter")));
        }
    }
    public void choiceRandomProperty() {
        expendFilterInCatalog();
        tempRandomNumber = (1 + (int) (Math.random() * driver.findElements(By.xpath("//*[@data-checkbox]")).size()));
        clickElement("(//*[@data-checkbox])[" + tempRandomNumber + "]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#modef")));
        clickElementByItsCssSelector("#set_filter");
    }

    public void checkingThatQuantityItemsIsDecreased() {
        int quantityItemsAfterChoiceRandomProperty;
        String quantityPagesAfterChoiceRandomProperty = "0";
        if (tempValue2.equals("1")) {
            quantityItemsAfterChoiceRandomProperty = driver.findElements(By.cssSelector(".blank-zakaza__item")).size();
            Assert.assertFalse(tempInt == quantityItemsAfterChoiceRandomProperty);
        } else {
            if (driver.findElements(By.xpath("//*[@class='page-item active']")).size() > 0) {
                quantityPagesAfterChoiceRandomProperty = driver.findElement(By.xpath("//*[@class='page-item active']")).getText();
                Assert.assertFalse(tempValue2 == quantityPagesAfterChoiceRandomProperty);
            }
        }
    }

    public void navigationToClothesSection() {
        driver.navigate().to(b2bUrl + "orders/blank_zakaza/odezhda/");
    }
    public void selectAllItemsInTheCart(){
        driver.findElement(checkboxThatHighlightsAllProductsInTheCartLocator).click();
    }
}
