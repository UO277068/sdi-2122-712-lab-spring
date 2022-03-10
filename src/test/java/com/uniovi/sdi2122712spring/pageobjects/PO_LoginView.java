package com.uniovi.sdi2122712spring.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView {
    static public void fillLoginForm(WebDriver driver, String dnip, String passwordp) {
        WebElement dni = driver.findElement(By.name("username"));
        dni.click();
        dni.clear();
        dni.sendKeys(dnip);
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys(passwordp);
        //Pulsar el boton de Alta.
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }
    static public void loginUser(WebDriver driver,String dni,String password,String confirmationtext){
        clickOption(driver, "login", "class", "btn btn-primary");
        fillLoginForm(driver, dni, password);
        //Comprobar que se ha logeado uno correctamente
        PO_View.checkElementBy(driver, "text",confirmationtext );
    }

    static public void logoutUser(WebDriver driver,int properties){
        String loginText = getP().getString("signup.message", properties);
        clickOption(driver, "logout", "text", loginText);
    }
}
