package com.ycc.utilsDao;

import com.ycc.entity.eError;

import java.util.List;
import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/14 16:46
 */
public interface ErrorUtilsDao {
    Random R = new Random();
    String[] ERROR_MSG= new String[]{"normal", "overtime"};
    eError getOne();
    List<eError> getMore(int num);
}
