package page;

import core.BasePage;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static core.DriverFactory.getDriver;

public class MenuPage extends BasePage {


    /*** ACESSAR MENU ***/
    public void acessarBuscadeElementos() {
        clicarLink("Busca de elementos");
    }
    public void acessarMudancaDeFoco(){ clicarLink("Mudança de foco");}
    public void radioeCheckbox() {
        clicarLink("Radio e Checkbox");
    }
    public void acessarAccordion() {
        clicarLink("Widgets");
    }
    public void acessarInteracoes() {
        clicarLink("Iterações");
    }
    public void acessarOutros() {
        clicarLink("Outros");
    }


    /*** CLICAR RADIOS ***/
    public void clicarRadioRed (){
        clicarRadio(By.xpath("//label[@for='red']"));
    }
    public void clicarRadioBlue (){
        clicarRadio(By.xpath("//label[@for='blue']"));
    }
    public void clicarRadioYellow (){
        clicarRadio(By.xpath("//label[@for='yellow']"));
    }
    public void clicarRadioGreen (){
        clicarRadio(By.xpath("//label[@for='green']"));
    }


    /*** CLICAR CHECK BOX ***/
    public void clicarCheckPurple (){
        clicarRadio(By.xpath("//label[@for='purple']"));
    }
    public void clicarCheckGrey (){
        clicarRadio(By.xpath("//label[@for='grey']"));
    }
    public void clicarCheckBlack (){
        clicarRadio(By.xpath("//label[@for='black']"));
    }
    public void clicarCheckWhite (){
        clicarRadio(By.xpath("//label[@for='white']"));
    }

    /*** NOVA GUIA ***/
    public void novaGuia (){
        String originalWindow = getDriver().getWindowHandle();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*** FECHA GUIA E VOLTA ***/
    public void retornaguia (){
        getDriver().close();
        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
    }

    /*** ARRASTA E SOLTA ***/
    public void arrastaEsolta(){
        WebElement elementoBase = getDriver().findElement(By.id("winston"));
        WebElement elementoAlvo = getDriver().findElement(By.id("dropzone"));

        Actions action = new Actions(getDriver());
        action.clickAndHold(elementoBase).moveToElement(elementoAlvo).release().build().perform();
    }

    public void mouseover () throws InterruptedException {
        WebElement gmailLink = getDriver().findElement(By.xpath("//div[@class='card-content']"));
        Actions actionProvider = new Actions(getDriver());
        actionProvider.moveToElement(gmailLink).build().perform();
        Thread.sleep(2000);
        //getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    public void upload (){
        getDriver().findElement(By.xpath("(//input[@id='upload'])[1]"))
                .sendKeys("C:"+ File.separator+"Users"+File.separator+"gbcun"
                        +File.separator+"Desktop"+File.separator+"teste.pdf");
    }

    public void scrollDown (){
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUp (){
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

}
