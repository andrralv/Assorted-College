import org.springframework.web.servlet.ModelAndView;
import springapp.web.videoclubController;
import junit.framework.TestCase;

public class HelloControllerTests extends TestCase {
    public void testHandleRequestView() throws Exception {
        videoclubController controller = new videoclubController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
    }
}
