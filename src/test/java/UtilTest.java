
import com.thinner.apps.utils.Base64Util;
import org.junit.Test;

/**
 * Created by caoqitong on 8/16/15.
 */
public class UtilTest {

  @Test
  public void testBase64(){
    String str = "test";
    try {
      String base64Str = Base64Util.getBase64(str);
      System.out.print(base64Str);
      System.out.println(Base64Util.getFromBase64(base64Str));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
