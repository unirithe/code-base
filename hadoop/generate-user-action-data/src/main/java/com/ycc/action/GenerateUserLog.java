package com.ycc.action;

import com.ycc.DataCenter;
import com.ycc.entity.*;
import com.ycc.log.PageLog;
import com.ycc.utils.*;
import com.ycc.utilsDao.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 22:23
 */
public class GenerateUserLog {

    static UserUtilsDao user = ProxyUtils.getProxy(new UserUtilsImpl());
    static ActionUtilsDao action = ProxyUtils.getProxy(new ActionUtilsImpl());
    static DisplayUtilsDao display = ProxyUtils.getProxy(new DisplayUtilsImpl());
    static PageUtilsDao page = ProxyUtils.getProxy(new PageUtilsImpl());
    static ErrorUtilsDao error = ProxyUtils.getProxy(new ErrorUtilsImpl());

    public static void start() {
        generate();
        print();
    }

    public static void generate(){
        List<eUser> luser = user.getMore(DataCenter.OPTION_NUMBER);
        List<eAction> laction = action.getMore(DataCenter.OPTION_NUMBER);
        List<List<eDisplay>> ldisplay = display.getMore(DataCenter.OPTION_NUMBER);
        List<ePage> lpage = page.getMore(DataCenter.OPTION_NUMBER);
        List<eError> lerror = error.getMore(DataCenter.OPTION_NUMBER);

        List list = new ArrayList();
        for (int i = 0; i < DataCenter.OPTION_NUMBER; i++) {

            PageLog pageLog = new PageLog(
                    luser.get(i),
                    laction.get(i),
                    ldisplay.get(i),
                    lpage.get(i),
                    lerror.get(i),
                    System.currentTimeMillis() + ""
            );
            list.add(pageLog);
        }
        DataCenter.JSON_LOG.put(DataCenter.USER, list);
    }
    public static void print(){
        String res = DataCenter.JSON_LOG.getJSONArray(DataCenter.USER).toString();
        switch (DataCenter.OPTION_PRINT_WAY) {
            case 2:         // 规格化输出
                res = DataCenter.formatJSON(DataCenter.JSON_LOG.getJSONArray(DataCenter.USER));
                System.out.println(res);
                break;
            case 1:          // 直接输出
                System.out.println(res);
                break;
            default: break; // 不输出
        }
    }
}
