import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    WebDriver driver;
    String baseURL = "https://e2e-assessment.piton.com.tr";
    By userNameL = new By.ByXPath("//input[@id='username']");
    By passwordL = new By.ByXPath("//input[@id='password']");
    By loginButtonL = new By.ByXPath("//button[@color='primary']");
    By userNameErrorL = new By.ByXPath("//mat-error[@id='mat-error-0']");
    By passwordErrorL = new By.ByXPath("//mat-error[@id='mat-error-1']");
    By welcomeScreenL = new By.ByXPath("//strong[contains(text(),'Welcome Automation Test User')]");
    By createEventL = new By.ByXPath("//span[@class='mat-button-wrapper']");
    By createNewEventL = new By.ByXPath("//span[@class='mat-button-wrapper' and contains(text(),'Create New Event')]");
    By addParticipantL = new By.ByXPath("//span[@class='mat-button-wrapper' and contains(text(),'Add Participant')]");
    By deleteParticapantL = new By.ByXPath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base mat-warn']");
    By eventNameL = new By.ByXPath("//div[@class='mat-form-field-flex ng-tns-c37-2']");
    By eventNameTextL = new By.ByXPath("//input[@id='name']");
    By eventDescriptionL = new By.ByXPath("//div[@class='mat-form-field-flex ng-tns-c37-3']");
    By getEventDescriptionTextL = new By.ByXPath("//input[@id='description']");
    By eventDateL = new By.ByXPath("//div[@class='mat-form-field-flex ng-tns-c37-4']");
    By eventDateTextL = new By.ByXPath("//input[@id='mat-input-4']");
    By editEventL = new By.ByXPath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base mat-primary']");
    By eventUpdateAlertL = new By.ByXPath("//span[contains(text(),'Event updated successfully')]");
    By eventCreatedAlertL = new By.ByXPath("//span[contains(text(),'Event created successfully')]");
    By updateEventButton = new By.ByXPath("//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']");

    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
public void loginModule(String username, String password){
    driver.findElement(loginButtonL).click();
    driver.findElement(userNameErrorL);
    driver.findElement(passwordErrorL);
    System.out.println("Hatalı Giriş Testi Tamamlandı");
    driver.findElement(userNameL).sendKeys(username);
    driver.findElement(passwordL).sendKeys(password);
    driver.findElement(loginButtonL).click();
    System.out.println("Başarılı Giriş Testi Tamamlandı");
    driver.findElement(welcomeScreenL);
    System.out.println("Welcome Mesajı Görüldü");
}
public void eventModule(String eventName, String eventDescription, String eventDate, String eventNameEdited, String eventDescriptionEdited, String eventDateEdited) {
        driver.findElement(createEventL).click();
        driver.findElement(createNewEventL).click();
        driver.findElement(addParticipantL).click();
        driver.findElement(deleteParticapantL).click();
        driver.findElement(deleteParticapantL).click();
        driver.findElement(eventNameL).click();
        driver.findElement(eventNameTextL).sendKeys(eventName);
        driver.findElement(eventDescriptionL).click();
        driver.findElement(getEventDescriptionTextL).sendKeys(eventDescription);
        driver.findElement(eventDateL).click();
        driver.findElement(eventDateTextL).sendKeys(eventDate);
        driver.findElement(createNewEventL).click();
        driver.findElement(editEventL).click();
        driver.findElement(eventCreatedAlertL);
        System.out.println("Event Oluşturma Başarılı.");
        driver.findElement(eventNameTextL).clear();
        driver.findElement(getEventDescriptionTextL).clear();
        driver.findElement(eventNameTextL).sendKeys(eventNameEdited);
        driver.findElement(getEventDescriptionTextL).sendKeys(eventDescriptionEdited);
        driver.findElement(updateEventButton).click();
        driver.findElement(eventUpdateAlertL);
        System.out.println("Event Düzemleme Başarılı.");
        //driver.quit();
}}


