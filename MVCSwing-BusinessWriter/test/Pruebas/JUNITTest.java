package Pruebas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUNITTest {
   @Test
   public void testAdd() {
      String str= "Junit is working fine";
      assertEquals("Junit is working fine", str);
   }
}