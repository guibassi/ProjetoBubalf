package page;

import core.BasePage;
import core.DriverFactory;


public class LoginPage extends BasePage {

        public void acessarTelaInicial() {
            DriverFactory.getDriver().get("https://automacaocombatista.herokuapp.com/treinamento/home");
        }

    }
