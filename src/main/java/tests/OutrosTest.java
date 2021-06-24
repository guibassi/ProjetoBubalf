package tests;

import core.BasePage;
import core.BaseTest;
import core.DriverFactory;
import generic.BaseTest2;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import page.MenuPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OutrosTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    BasePage basePage = new BasePage();

    @Test
    public void T001_uploadTest (){
        try {
        menuPage.acessarOutros();
        basePage.clicarLink("Upload de Arquivo");
        menuPage.upload();
        Assert.assertTrue(String.valueOf(DriverFactory.getDriver().findElement(By.xpath("//input[@class='file-path validate valid']"))), true);

        BaseTest2.gerarPrintScreen("Reports", "Upload", 0, "Upload passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Upload", 1, "Upload falhou.");
        }
    }

    @Test
    public void T002_scrollTest () {
        try {
        menuPage.acessarOutros();
        basePage.clicarLink("Scroll");
        menuPage.scrollDown();
        Thread.sleep(3000);
        menuPage.scrollUp();

        BaseTest2.gerarPrintScreen("Reports", "Scroll", 0, "Scroll passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Scroll", 1, "Scroll falhou.");
        }
    }
}
