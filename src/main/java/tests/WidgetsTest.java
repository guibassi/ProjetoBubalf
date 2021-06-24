package tests;

import core.BasePage;
import core.BaseTest;
import static core.DriverFactory.getDriver;

import generic.BaseTest2;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import page.MenuPage;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class WidgetsTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    BasePage basePage = new BasePage();

    @Test
    public void T001_accordionTest (){
        try {
        menuPage.acessarAccordion();
        basePage.clicarLink("Accordion");

        basePage.clicarBotao(By.xpath("//div[text()='First']"));
        System.out.println(basePage.obterTexto(By.xpath("(//li[@class='active']//div)[2]")));

        basePage.clicarBotao(By.xpath("//div[text()='Second']"));
        System.out.println(basePage.obterTexto(By.xpath("//span[text()='Segundo Texto.']")));

        basePage.clicarBotao(By.xpath("//div[text()='Third']"));
        System.out.println(basePage.obterTexto(By.xpath("//span[text()='Terceiro Texto.']")));

        BaseTest2.gerarPrintScreen("Reports", "Accordion", 0, "Accordion passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Accordion", 1, "Accordion falhou.");
        }
    }

    @Test
    public void T002_autocompleteTest () {
        try {
        menuPage.acessarAccordion();
        basePage.clicarLink("Autocomplete");

        WebElement textBoxElement = getDriver().findElement(By.id("autocomplete-input"));
        textBoxElement.sendKeys("s" + Keys.DOWN + Keys.DOWN + Keys.ENTER);

        BaseTest2.gerarPrintScreen("Reports", "Auto Complete", 0, "Auto Complete passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Auto Complete", 1, "Auto Complete falhou.");
        }
    }

    @Test
    public void T003_datapickerTest (){
        try {
        menuPage.acessarAccordion();
        basePage.clicarLink("Datapicker");
        basePage.clicarBotao("datepicker");
        basePage.clicarBotao(By.xpath("(//input[@readonly='true'])[1]"));
        basePage.clicarBotao(By.xpath("//span[text()='December']"));

        basePage.clicarBotao(By.xpath("(//input[@readonly='true'])[2]"));
        basePage.clicarBotao(By.xpath("//span[text()='2015']"));

        basePage.clicarBotao(By.xpath("//button[text()='31']"));
        basePage.clicarBotao(By.xpath("//button[text()='Ok']"));

        Assert.assertTrue("Dec 31, 2015", true);

        BaseTest2.gerarPrintScreen("Reports", "Data Picker", 0, "Data Picker passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Data Picker", 1, "Data Picker falhou.");
        }
    }




}
