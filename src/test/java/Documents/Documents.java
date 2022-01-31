package Documents;


import org.junit.Test;


public class Documents extends MethodsForDocuments {
    @Test //1. Добавление существующего документа пользователю
    public void AddExistingDocumentToUser() {
        //arrange
        deletingExcelFilesFromDownloads();
        registr.registrationIPWithManualEntryINN();
        registr.tryConfirmRegistration();
        //confirmRegistrationOfOrganizationJustCreatedUser();
        exitFromB2B();
        //act
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        addingExistingDocumentToJustCreatedUser();
        exitFromB2B();
        navigationToAuthorizationTab();
        registr.fillingFieldsOnTheLogInTab();
        logInToB2B();
        navigationToActsOfDocuments();
        checkingThatDocumentIsDisplayed();
        downloadDocument();
    }

    @Test //2. Добавление существующего  документа пользователю c привязкой организации
    public void AddExistingDocumentWithOrganizationToUser() {
        //arrange
        deletingExcelFilesFromDownloads();
        registr.registrationIPWithManualEntryINN();
        registr.tryConfirmRegistration();
        //confirmRegistrationOfOrganizationJustCreatedUser();
        //exitFromB2B();
        //act
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        addingExistingDocumentWithOrganizationToJustCreatedUser();
        exitFromB2B();
        navigationToAuthorizationTab();
        registr.fillingFieldsOnTheLogInTab();
        logInToB2B();
        navigationToActsOfDocuments();
        checkingThatDocumentIsDisplayed();
        downloadDocument();
        navigationToDetailInformationOfOrganizationFromDocument();
    }

    @Test //3. Добавление документа пользователю
    public void AddDocumentToUser() {
        //arrange
        deletingExcelFilesFromDownloads();
        registr.registrationIPWithManualEntryINN();
        registr.tryConfirmRegistration();
        //confirmRegistrationOfOrganizationJustCreatedUser();
        //exitFromB2B();
        //act
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        addingDocumentToJustCreatedUser();
        exitFromB2B();
        navigationToAuthorizationTab();
        registr.fillingFieldsOnTheLogInTab();
        logInToB2B();
        navigationToActsOfDocuments();
        checkingThatDocumentIsDisplayed();
        downloadDocument();
    }

    @Test //4. Добавление документа пользователю c привязкой организации
    public void AddDocumentWithOrganizationToUser() {
        //arrange
        deletingExcelFilesFromDownloads();
        registr.registrationIPWithManualEntryINN();
        registr.tryConfirmRegistration();
        //confirmRegistrationOfOrganizationJustCreatedUser();
        //exitFromB2B();
        //act
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        System.out.println(registr.theSameEmail);
        addingDocumentWithOrganizationToJustCreatedUser(registr.theSameInnManual, registr.theSameEmail);
        driver.findElement(buttonForSaveDocumentForUserLocator).click();
        exitFromB2B();
        navigationToAuthorizationTab();
        registr.fillingFieldsOnTheLogInTab();
        logInToB2B();
        navigationToActsOfDocuments();
        checkingThatDocumentIsDisplayed();
        downloadDocument();
        navigationToDetailInformationOfOrganizationFromDocument();
    }
    @Test //5. Отображение документа привязонного к заказу
    public void displayingTheDocumentLinkedToTheOrder() {
        //arrange
        deletingExcelFilesFromDownloads();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ordering.deletingProductsFromTheCart();
        navigationToCatalogTab();
        ordering.changeTheQuantityOfRandomProduct();
        ordering.checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        navigationToCart();
        makingAnOrderAndStoringNumberOfOrderForBindingADocument();
        exitFromB2B();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        addingDocumentForUserWithNumberOfOrder(emailUser, makingOrder.numberOfOrder);
        exitFromB2B();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        navigationToMyOrdersPage();
        checkingThatLastOrderHaveDocument();
        downloadDocument();
    }
    @Test //6. Переход на детальную страницу заказа из раздела "Документы" с помощью привязанного к заказу документа
    public void goToTheDetailedOrderPageFromTheDocumentsSectionUsingTheDocumentLinkedToTheOrder() {
        //arrange
        deletingExcelFilesFromDownloads();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        ordering.deletingProductsFromTheCart();
        navigationToCatalogTab();
        ordering.changeTheQuantityOfRandomProduct();
        ordering.checkingThatThePriceOfTheAddedProductHasBeenCalculated();
        navigationToCart();
        makingAnOrderAndStoringNumberOfOrderForBindingADocument();
        exitFromB2B();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeAdmin();
        logInToB2B();
        addingDocumentForUserWithNumberOfOrder(emailUser, makingOrder.numberOfOrder);
        exitFromB2B();
        navigationToAuthorizationTab();
        fillingFieldsOnTheLogInTabLikeUser();
        logInToB2B();
        navigationToActsOfDocuments();
        navigationToTheLastOrderFromDocumentsPage();
    }
}
