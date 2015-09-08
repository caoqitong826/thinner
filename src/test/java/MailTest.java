import com.thinner.apps.utils.MailUtil;
import org.junit.Test;

/**
 * Created by caoqitong on 8/22/15.
 */
public class MailTest {
  @Test
  public void testMail(){
    boolean b = MailUtil.senderMail("caoqitong@qq.com", "nihaoa", "welcome to thinner!");
  }
}
