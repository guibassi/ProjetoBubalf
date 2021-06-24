package tests;


import core.BaseTest;
import generic.BaseTest2;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;
import page.FormPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FormularioTest extends BaseTest {
    FormPage formPage = new FormPage();


    @Test
    public void T001_InserirConta (){
       try {
       formPage.acessarFormulario();
       formPage.criarUsuario();
       formPage.setNome("A Guilherme Teste");
       formPage.setSobrenome("Bassi Teste");
       formPage.setEmail("Teste@teste.com.br");
       formPage.setEndereco("Av Teste");
       formPage.setUniversidade("Uniara");
       formPage.setProfissao("Automacao de Testes");
       formPage.setGenero("Masculino");
       formPage.setIdade("36");
       formPage.criar();

       Assert.assertEquals("Usuário Criado com sucesso", formPage.obterMensagemSucesso());

       BaseTest2.gerarPrintScreen("Reports", "Inserir Conta", 0, "Inserir Conta passou.");
       } catch (Exception e) {
           BaseTest2.gerarPrintScreen("Reports", "Inserir Conta", 1, "Inserir Conta falhou.");
       }
    }

    @Test
    public void T002_ListarUsuarios () {
        try {
        formPage.acessarFormulario();
        formPage.listaDeUsuarios();
        Assert.assertEquals("Lista de Usuários!!", formPage.obterMensagemListadeUsuarios());

        BaseTest2.gerarPrintScreen("Reports", "Listar Usuários", 0, "Listar Usuários passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Listar Usuários", 1, "Listar Usuários falhou.");
        }
    }

    @Test
    public void T003_AlterarUsuario (){
        try {
        formPage.acessarFormulario();
        formPage.listaDeUsuarios();
        formPage.localizarEditar("A Guilherme Teste");
        formPage.setNome("");
        formPage.setNome("A Guilherme Teste Alterado");
        formPage.criar();
        Assert.assertEquals("Seu Usuário foi Atualizado!", formPage.obterMensagemSucesso());

        BaseTest2.gerarPrintScreen("Reports", "Alterar usuário", 0, "Alterar usuário passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Alterar usuário", 1, "Alterar usuário falhou.");
        }
    }

    @Test
    public void T004_ExcluirUsuario () {
        try {
        formPage.acessarFormulario();
        formPage.listaDeUsuarios();
        formPage.excluirUsuario("A Guilherme Teste Alterado");
        formPage.aceitaAlert();
        Thread.sleep(3000);
        Assert.assertEquals("Seu Usuário foi removido com sucesso!", formPage.obterMensagemSucesso());
        System.out.println(formPage.obterMensagemSucesso());

        BaseTest2.gerarPrintScreen("Reports", "Excluir usuário", 0, "Excluir usuário passou.");
        } catch (Exception e) {
            BaseTest2.gerarPrintScreen("Reports", "Excluir usuário", 1, "Excluir usuário falhou.");
        }
    }

}