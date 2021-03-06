package making_orders;


import base_actions.Retry;
import org.testng.annotations.Test;

public class MakingOrders extends MethodsForMakingOrders {
    @Test(retryAnalyzer = Retry.class) //1. Оформление заказа
    public void madeOrder() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        makingOrder();
    }

    @Test(retryAnalyzer = Retry.class) //2. Оформление заказа c выбором рандомного способа доставки
    public void madeOrderWithRandomDeliveryWay() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
        makingOrder();
    }

    @Test(retryAnalyzer = Retry.class) //3. Оформление заказа c выбором рандомного способа доставки и способа оплаты
    public void madeOrderWithRandomDeliveryWayAndPaymentMethod() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomPaymentMethod();
        makingOrder();
        checkingThatTheSelectedPaymentMethodIsDisplayed();
    }

    @Test(retryAnalyzer = Retry.class)
    //4. Оформление заказа c выбором рандомного способа доставки и способа оплаты после добавления товаров с разных страниц каталога
    public void madeOrderWithRandomDeliveryWayAndPaymentMethodAfterAddingProductsToCartFromDifferentPagesCatalog() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changingPageInCatalog();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        changingPageInCatalog();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();   //Раскоментить с нормальным каталогом
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomPaymentMethod();
        makingOrder();
        checkingThatTheSelectedPaymentMethodIsDisplayed();
    }

    @Test(retryAnalyzer = Retry.class)
    //5. Оформление заказа c выбором рандомного способа доставки и способа оплаты после добавления товаров из Excel
    public void madeOrderWithRandomDeliveryWayAndPaymentMethodAfterAddingProductsToCartFromExcelCatalog() {
        //arrange
        deletingExcelAndJpgFilesFromDownloads();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        downloadingCatalogFromExcel("blank.xlsx");
        navigationToCart();
        checkThatProductsAreDisplayedInCart();
        //act
        rememberingPriceOfProductsInCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomPaymentMethod();
        makingOrder();
        checkingThatTheSelectedPaymentMethodIsDisplayed();
    }

    @Test(retryAnalyzer = Retry.class)
    //6 Оформление заказа c выбором рандомного способа доставки и способа оплаты после добавления товара и выбора организации от лица которой оформлять заказ
    public void madeOrderWithRandomDeliveryWayAndPaymentMethodAfterAddingProductToCartAndChoiceOrganization() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        changingCompanyInTheCartForExtendedVersion();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomPaymentMethod();
        makingOrder();
        checkingThatTheSelectedPaymentMethodIsDisplayed();
    }

    @Test(retryAnalyzer = Retry.class)
    //7 Оформление заказа c выбором рандомного способа доставки и способа оплаты после добавления товаров с разных страниц каталога и выбора организации от лица которой оформлять заказ
    public void madeOrderWithRandomDeliveryWayAndPaymentMethodAfterAddingProductsToCartAndChoiceOrganization() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changingPageInCatalog();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        changingPageInCatalog();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        changingCompanyInTheCartForExtendedVersion();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomPaymentMethod();
        makingOrder();
        checkingThatTheSelectedPaymentMethodIsDisplayed();
    }

    @Test(retryAnalyzer = Retry.class) //8 Проверка корректности смены реквизитов заказа при смене организаций
    public void checkingTheCorrectnessOfChangingOrderDetailsWhenChangingOrganizations() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        selectCompanyByItSNumber(1);
        rememberingFieldsThisOrganization();
        selectCompanyByItSNumber(2);
        checkingThatTheFieldsOfThisOrganizationAreNotEqualToThePreviousOrganization();
    }

    @Test(retryAnalyzer = Retry.class)
    //9 Проверка валидности формы оформления заказа (обязательные/необязательные поля)
    public void checkingTheValidityOfTheOrderFormRequiredOptionalFields() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ifThereAreLessThanThreeOrganizationsThenCreateThreeOrganizations();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        navigationToCart();
        navigationToMakingOrderFromCart();
        //act
        selectCompanyByItSNumber(1);
        tryToMakeAnOrderWithoutTheEmailField();
        tryToMakeAnOrderWithoutTheAddressField();
        makingOrder();
    }

    @Test(retryAnalyzer = Retry.class)
    //10 Проверка что количество способов доставки равно кол-ву активных в админ. части
    public void checkThatTheNumberOfDeliveryMethodsIsEqualToTheNumberOfActiveInTheAdminPart() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        //act
        navigationToDeliveryWayByUrl();
        rememberTheNumberOfActiveDeliveryMethods();
        navigationToMeanPageByUrl();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        navigationToCart();
        navigationToMakingOrderFromCart();
        checkingThatTheNumberOfDeliveryMethodsIsEqualToTheNumberOfActiveInTheAdminPart();
    }

    @Test(retryAnalyzer = Retry.class)
    //11. Отмена способа доставки "Самовывоз" в поп-ап окне выбора адреса для самовывоза
    public void cancelOfThePickupDeliveryMethodInThePopUpWindowForSelectingAnAddressForPickup() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choicePickupAsADeliveryWay();
        cancellationOfThePickupDeliveryMethodInThePopUpWindowForSelectingAnAddressForPickup();
        checkingPriceOfProductsOnTheMakingOrderPage();
        checkingThatPriceForPickupEqualsZero();
    }

    // ОШИБКА B2B !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test(retryAnalyzer = Retry.class) //12. Итог в блоке "Корзина" на странице оформления заказа равен цене отображаемой в коризне (футере каталога)
    public void theTotalAmountAtTheTopOfTheCheckoutPageIsEqualToThePriceIndicatedInTheShoppingCart() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        //act
        navigationToCart();
        navigationToMakingOrderFromCart();
        checkThePriceAtTheTopOfThePage();
        trySelectCompany();
        checkingPriceOfProductsOnTheMakingOrderPage();
        choiceRandomDeliveryWay();
        checkingPriceOfProductsOnTheMakingOrderPage();
    }
    @Test(retryAnalyzer = Retry.class) //13 Оформление заказа без выбора организации
    public void makingOrderWithoutChoosingOrganization() {
        //arrange
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        deletingProductsFromTheCart();
        navigationToCatalogTab();
        changeTheQuantityOfRandomProduct();
        checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        navigationToCart();
        navigationToMakingOrderFromCart();
        //act
        makingOrder();
        navigationToListOfOrdersUsingLinkFromInformationAboutMadeOrder();
        checkingThatThereIsNumberOfMadeOrderInTheFirstRow();
        checkingThatThereIsALinkToDetailPageOfOrganizationInTheFirstRow();
    }
}
