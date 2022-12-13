package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class MyStepdefs {


    @Given("Client is on the login page")
    public void clientIsOnTheLoginPage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }


    @When("Client enter valid user name, password and domain name")
    public void client_enter_valid_user_name_password_and_domain_name() {

        String userName = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        LoginPage loginpage = new LoginPage();
        loginpage.login(userName, password);
        Driver.closeDriver();
    }
    @When("Client uses credentials to login")
    public void client_uses_credentials_to_login(DataTable dataTable) {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        List<List<String>> obj =dataTable.asLists();
        System.out.println(obj);
        System.out.println(obj.get(1).get(2));

    }


    @Then("Client uses credentials")
    public void client_uses_credentials(Map<String, String> dataTable) {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginpage = new LoginPage();
        System.out.println(dataTable.get("username"));
        System.out.println(dataTable.get("password"));
        loginpage.login(dataTable.get("username"), dataTable.get("password"));
        Driver.closeDriver();

    }

    @Then("Client enter {string} credentials")
    public void client_enter_credentials(String string) {
        String userName = null;
        String password = null;

        if (string.equalsIgnoreCase("sales manager")) {
            userName = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (string.equalsIgnoreCase("driver")) {
            userName = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (string.equalsIgnoreCase("store manager")) {
            userName = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        } else {
            System.out.println("invalid role");
        }

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(userName,password);
        Driver.closeDriver();


    }

    @Given("^Client enter (.+) and (.+) credentials$")
    public void client_enter_and_credentials(String names, String password) throws Throwable {


        if (names.equalsIgnoreCase("sales manager")) {
//            names = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (names.equalsIgnoreCase("driver")) {
            names = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (names.equalsIgnoreCase("store manager")) {
            names = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        } else {
            System.out.println("invalid role");
        }

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(names,password);
        Driver.closeDriver();

    }

    @When("user enter data in excel at {string}")
    public void user_enter_data_in_excel_at(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("^I open application in (Chrome|Firefox|IE) browser$")
    public void i_open_application_in_Chrome_browser(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            String url = ConfigurationReader.get("url");
            Driver.get().get(url);
        } else if(browser.equalsIgnoreCase("firefox")) {
            String url = ConfigurationReader.get("url");
            Driver.get().get(url);
        } else if(browser.equalsIgnoreCase("safari")) {
            String url = ConfigurationReader.get("url");
            Driver.get().get(url);
        }
    }
}
