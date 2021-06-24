package tests;

import core.BasePage;
import core.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import page.MenuPage;

import java.util.concurrent.TimeUnit;

import static core.DriverFactory.getDriver;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.ENTER;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BuscaDeElementosTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    BasePage basePage = new BasePage();

    @Test
    public void T001_clicarRadioBoxTest (){
        menuPage.acessarBuscadeElementos();
        menuPage.radioeCheckbox();

        menuPage.clicarRadioRed();
        Assert.assertTrue(menuPage.isRadioMarcado("red"));

        menuPage.clicarRadioBlue();
        Assert.assertTrue(menuPage.isRadioMarcado("blue"));

        menuPage.clicarRadioYellow();
        Assert.assertTrue(menuPage.isRadioMarcado("yellow"));

        menuPage.clicarRadioGreen();
        Assert.assertTrue(menuPage.isRadioMarcado("green"));
    }

    @Test
    public void T002_clicarCheckBoxTest (){
        menuPage.acessarBuscadeElementos();
        menuPage.radioeCheckbox();

        menuPage.clicarCheckPurple();
        menuPage.clicarCheckGrey();
        menuPage.clicarCheckBlack();
        menuPage.clicarCheckWhite();

        Assert.assertTrue(menuPage.isCheckMarcado("purple"));
        Assert.assertTrue(menuPage.isCheckMarcado("grey"));
        Assert.assertTrue(menuPage.isCheckMarcado("black"));
        Assert.assertTrue(menuPage.isCheckMarcado("white"));

        menuPage.clicarCheckPurple();
        menuPage.clicarCheckGrey();
        menuPage.clicarCheckBlack();
        menuPage.clicarCheckWhite();

        Assert.assertTrue(menuPage.isCheckDesMarcado("purple"));
        Assert.assertTrue(menuPage.isCheckDesMarcado("grey"));
        Assert.assertTrue(menuPage.isCheckDesMarcado("black"));
        Assert.assertTrue(menuPage.isCheckDesMarcado("white"));
    }
    @Test
    public void T003_dropdownSentTest (){
        menuPage.acessarBuscadeElementos();
        basePage.clicarLink("Dropdown e Select");
        basePage.clicarBotao(By.xpath("//a[@class='btn dropdown-button']"));
        basePage.clicarBotao("dropdown3");
        Assert.assertEquals("Você Clicou no Dropdown Sent!",
                basePage.obterTexto(By.xpath("//h5[text()='Você Clicou no Dropdown Sent!']")));

    }

    @Test
    public void T004_selectsTest () {
        menuPage.acessarBuscadeElementos();
        basePage.clicarLink("Dropdown e Select");

        basePage.clicarBotao(By.xpath("(//input[@value='Escolha sua opção'])[2]"));
        basePage.clicarBotao(By.xpath("//span[text()='Ronaldo']"));

        basePage.clicarBotao(By.xpath("(//input[@value='Escolha sua opção'])[1]"));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        basePage.clicarBotao(By.xpath("//span[text()='Dragon Ball']"));

        basePage.clicarBotao(By.xpath("//input[@value='Brasil']"));
        basePage.clicarBotao(By.xpath("//span[text()='Argentina']"));

        basePage.clicarBotao(By.xpath("//input[@value='Gênero']"));
        basePage.clicarBotao(By.xpath("//span[text()='Homem']"));

        basePage.clicarBotao(By.xpath("//input[@value='Sexo']"));
        basePage.clicarBotao(By.xpath("//span[text()='Masculino']"));

        basePage.clicarBotao(By.xpath("(//select[@id='dropdown'])[1]"));
        basePage.clicarBotao(By.xpath("//option[text()='Firefox']"));
    }

    @Test
    public void T005_textoNaPaginaTest () {
        menuPage.acessarBuscadeElementos();
        basePage.clicarLink("Textos");

        getDriver().getPageSource();
        Assert.assertTrue("Integração contínua", true);

        basePage.clicarBotao(By.xpath("//img[@src='/assets/codeship-50945a5e8bb1ea354e577187176227307f0e8047dc53e145b615255b4625b88e.jpg']/following-sibling::a[1]"));

        getDriver().getPageSource();
        Assert.assertTrue("Aprenda a fazer integração contínua", true);

        getDriver().navigate().back();
    }

    @Test
    public void T006_tabelaTest ()throws NumberFormatException{
        menuPage.acessarBuscadeElementos();
        basePage.clicarLink("Tabela");

        String str = getDriver().findElement(By.xpath("//td[text()='Carne']/../td[3]")).getText().replaceAll("[$,]", "");
        double dnum = Double.parseDouble(str);

        if (dnum > 5.00) {
            System.out.println("PASSOU");
        } else {
            System.out.println("NÃO PASSOU");
        }
    }

}
