public class Main {

    public static void main (String[] args){
        App app = new App();
        app.loginModule("automationtest","123456789");
        app.eventModule("Test Event", "Test Event Description", "01/01/2023","Test Event Edited", "Test Event Description Edited", "11/11/2023");
    }
}
