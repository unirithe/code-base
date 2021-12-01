package com.ycc.utils;

import com.ycc.entity.eError;
import com.ycc.utilsDao.ErrorUtilsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 16:49
 */
public class ErrorUtilsImpl implements ErrorUtilsDao {
    public eError getOne() {
        int i = R.nextInt(2);
        return new eError(i + "", ERROR_MSG[i]);
    }

    public List<eError> getMore(int num) {
        List<eError> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getOne());
        }
        return list;
    }
}
