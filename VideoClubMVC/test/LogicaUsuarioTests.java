import domain.logicaUsuario;
import junit.framework.TestCase.*;
import static junit.framework.TestCase.assertNull;
import org.junit.Before;
import org.junit.Test;

public class LogicaUsuarioTests {
    private logicaUsuario logica;
    @Before
    protected void setUp() throws Exception {
        logica = new logicaUsuario();
    }
}