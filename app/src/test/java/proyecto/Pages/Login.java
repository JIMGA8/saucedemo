package proyecto.Pages;

public class Login extends BasePage {

    private String campoUsaurio = "//input[@id='user-name']";
    private String campoContraseña = "//input[@id='password']";
    private String btnLogin = "//input[@id='login-button']";
    private String textSwagLabs = "//div[contains( text(), 'Swag Labs')]";

    public Login() {
        super(driver);
    }

    public void navigateToSaucedemo() {
        navigateTo("https://www.saucedemo.com/");
    }

    public void WriteUserAndPass(String usuario, String password) {
        write(campoUsaurio, usuario);
        write(campoContraseña, password);
        clickElement(btnLogin);
        ;
    }

    public boolean validateLogin() {
        return elementIsDisplayed(textSwagLabs);
    }

}