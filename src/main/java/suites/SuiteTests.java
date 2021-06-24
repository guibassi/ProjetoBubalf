package suites;


import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FormularioTest.class,
        BuscaDeElementosTest.class,
        MudancaDeFocoTest.class,
        WidgetsTest.class,
        InteracoesTest.class,
        OutrosTest.class
})
public class SuiteTests {

    @AfterClass
    public static void finalizaTudo(){
        DriverFactory.killDriver();
        }

}
