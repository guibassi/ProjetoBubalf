package page;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import static core.DriverFactory.getDriver;


public class FormPage extends BasePage {

    /*** FORMULÁRIO ***/
    public void acessarFormulario() {
        clicarLink("Formulário");
    }
    public void criarUsuario() {
        clicarLink("Criar Usuários");
    }
    public void listaDeUsuarios() {
        clicarLink("Lista de Usuários");
    }
    public void setNome(String nome) {
        escrever("user_name", nome);
    }
    public void setSobrenome(String sobrenome) {
        escrever("user_lastname", sobrenome);
    }
    public void setEmail(String email) {
        escrever("user_email", email);
    }
    public void setEndereco(String endereco) {
        escrever("user_address", endereco);
    }
    public void setUniversidade(String universidade) {
        escrever("user_university", universidade);
    }
    public void setProfissao(String profissao) {
        escrever("user_profile", profissao);
    }
    public void setGenero(String genero) {
        escrever("user_gender", genero);
    }
    public void setIdade(String idade) {
        escrever("user_age", idade);
    }
    public void criar() {
        clicarBotao(By.xpath("//input[@value='Criar']"));
    }

    public String obterMensagemSucesso() {
        return obterTexto(By.id("notice"));
    }

    public String obterMensagemListadeUsuarios() {
        return obterTexto(By.xpath("//*[contains(@class, 'center')]"));
    }

    public void localizarEditar(String nomeLocalizar) {
        clicarBotao(By.xpath(" //*[contains(text(),'" + nomeLocalizar + "')]/../td[10]"));
    }

    public void excluirUsuario(String nomeExcluir) {
        clicarBotao(By.xpath(" //*[contains(text(),'" + nomeExcluir + "')]/../td[11]"));
    }

    public void aceitaAlert() {
        Alert alert_box = getDriver().switchTo().alert();
        alert_box.accept();
    }

    public void cancelarAlert (){
        Alert alert_box = getDriver().switchTo().alert();
        alert_box.dismiss();
    }


}
