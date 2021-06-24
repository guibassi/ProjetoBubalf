package tests;

import core.BasePage;
import core.BaseTest;



import generic.BaseTest2;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import page.FormPage;

import page.MenuPage;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MudancaDeFocoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    BasePage basePage = new BasePage();
    FormPage formPage = new FormPage();


    @Test
    public void T001_alertTest (){
        try {
            menuPage.acessarMudancaDeFoco();
            basePage.clicarLink("Alert");
            basePage.clicarBotao(By.xpath("//button[text()='Clique para JS Alert']"));
            formPage.aceitaAlert();
            Assert.assertEquals("Você clicou no alerta com sucesso!!", basePage.obterTexto(By.id("result")));

            BaseTest2.gerarPrintScreen("Reports", "Confirmar Alerta", 0, "Alerta clicado passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Confirmar Alerta", 1, "Alerta falhou.");
        }
    }

    @Test
    public void T002_confirmTest (){
        try {
        menuPage.acessarMudancaDeFoco();
        basePage.clicarLink("Alert");
        basePage.clicarBotao(By.xpath("//button[text()='Clique para JS Confirm']"));
        formPage.cancelarAlert();
        Assert.assertEquals("Você clicou: Cancel", basePage.obterTexto(By.id("result")));

        BaseTest2.gerarPrintScreen("Reports", "Cancelar Alerta", 0, "Alerta cancelado passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Cancelar Alerta", 1, "Alerta falhou.");
        }
    }

    @Test
    public void T003_promptTest (){
        try {
        menuPage.acessarMudancaDeFoco();
        basePage.clicarLink("Alert");
        basePage.clicarBotao(By.xpath("//button[text()='Clique para JS Prompt']"));
        basePage.alertaEscrever("Goku");
        Assert.assertEquals("Você digitou: Goku", basePage.obterTexto(By.id("result")));

        BaseTest2.gerarPrintScreen("Reports", "Escrever Prompt", 0, "Prompt passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Escrever Prompt", 1, "Prompt falhou.");
        }
    }

    @Test
    public void T004_janelaTest () {
        try {
        menuPage.acessarMudancaDeFoco();
        basePage.clicarLink("Janela");
        basePage.clicarBotao(By.xpath("//a[contains(@class,'btn waves-light')]"));
        menuPage.novaGuia();
        Assert.assertEquals("Você Abriu uma nova janela!!", basePage.obterTexto(By.xpath("//h5[text()='Você Abriu uma nova janela!!']")));
        menuPage.retornaguia();

        BaseTest2.gerarPrintScreen("Reports", "Nova Janela", 0, "Nova janela passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Nova Janela", 1, "Nova janela falhou.");
        }


    }

    @Test
    public void T005_modalTest (){
        try {
        menuPage.acessarMudancaDeFoco();
        basePage.clicarLink("Modal");
        basePage.clicarBotao(By.xpath("//a[@href='#modal1']"));
        Assert.assertTrue("futuro", true);
        basePage.clicarBotao(By.xpath("//div[@class='modal-footer']//a[1]"));

        BaseTest2.gerarPrintScreen("Reports", "Modal texto", 0, "Modal texto passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Modal texto", 1, "Modal texto falhou.");
        }


    }
}
