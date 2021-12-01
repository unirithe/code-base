import com.ycc.entity.*;
import com.ycc.enums.ActionId;
import com.ycc.log.PageLog;
import com.ycc.utils.*;
import com.ycc.utilsDao.*;
import org.junit.Test;

import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 22:26
 */
public class myTest {
    @Test
    public void testActionEnum(){
        for (ActionId value : ActionId.values()) {
            System.out.println(value + ": " + ActionId.valueOf(value.name()));
        }
    }
    @Test
    public void testActionUtils(){
        ActionUtilsDao action = ProxyUtils.getProxy(new ActionUtilsImpl());
        System.out.println(action.item_type(1));  // 获取事件类型
        for (eAction eAction : action.getMore(100)) {
            System.out.println(eAction);
        }
    }
    @Test
    public void testDisplayUtils(){
        DisplayUtilsDao display = ProxyUtils.getProxy(new DisplayUtilsImpl());

        List<List<eDisplay>> more = display.getMore(10000);
        for (List<eDisplay> eDisplays : more) {
            System.out.println(eDisplays);
        }
    }
    @Test
    public void testPageUtils(){
        PageUtilsDao page = ProxyUtils.getProxy(new PageUtilsImpl());
        List<ePage> more = page.getMore(10000);
        for (ePage ePage : more) {
            System.out.println(ePage);
        }
    }
    @Test
    public void testErrorUtils(){
        ErrorUtilsDao error = ProxyUtils.getProxy(new ErrorUtilsImpl());
        for (eError e : error.getMore(1000)) {
            System.out.println(e);
        }
    }
    @Test
    public void testGenerateUserLog(){
        UserUtilsDao user = ProxyUtils.getProxy(new UserUtilsImpl());
        ActionUtilsDao action = ProxyUtils.getProxy(new ActionUtilsImpl());
        DisplayUtilsDao display = ProxyUtils.getProxy(new DisplayUtilsImpl());
        PageUtilsDao page = ProxyUtils.getProxy(new PageUtilsImpl());
        ErrorUtilsDao error = ProxyUtils.getProxy(new ErrorUtilsImpl());

        List<eUser> luser = user.getMore(100);
        List<eAction> laction = action.getMore(100);
        List<List<eDisplay>> ldisplay = display.getMore(100);
        List<ePage> lpage = page.getMore(100);
        List<eError> lerror = error.getMore(100);

        for (int i = 0; i < 100; i++) {
            eAction eAction = laction.get(i);
            System.out.println(new PageLog(
                luser.get(i),
                    laction.get(i),
                    ldisplay.get(i),
                    lpage.get(i),
                    lerror.get(i),
                    System.currentTimeMillis() + ""
            ));
        }

    }
}
