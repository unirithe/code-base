package com.ycc.utilsDao;

import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 17:24
 */
public interface getDao<E> {

    E getOne();
    List<E> getMore(int num);
}
