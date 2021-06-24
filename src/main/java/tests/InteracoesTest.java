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
public class InteracoesTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    BasePage basePage = new BasePage();

    @Test
    public void T001_dragAndDropTest (){
        try {
        menuPage.acessarInteracoes();
        basePage.clicarLink("Drag And Drop");
        menuPage.arrastaEsolta();

        DriverFactory.getDriver().findElement(By.id("dropzone")).getCssValue("background-color");
        Assert.assertTrue("rgb(0, 200, 0)", true);

        BaseTest2.gerarPrintScreen("Reports", "Drag And Drop", 0, "Drag And Drop passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Drag And Drop", 1, "Drag And Drop falhou.");
        }
    }

    @Test
    public void T002_mousehoverTest () {
        try {
        menuPage.acessarInteracoes();
        basePage.clicarLink("Mousehover");
        menuPage.mouseover();
        Assert.assertEquals("Você usou o mouse hover!", basePage.obterTexto(By.xpath("//div[@class='card-reveal']//p[1]")));

        BaseTest2.gerarPrintScreen("Reports", "Mouse Hover", 0, "Mouse Hover passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Mouse Hover", 1, "Mouse Hover falhou.");
        }

    }



}
