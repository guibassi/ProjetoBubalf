package core;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import page.LoginPage;


import static core.DriverFactory.killDriver;


public class BaseTest {

	LoginPage page = new LoginPage();

	@Rule
	public TestName testName = new TestName();


	@Before
	public void inicializa() {
		page.acessarTelaInicial();
	}


	@After
	public void finaliza() {
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
