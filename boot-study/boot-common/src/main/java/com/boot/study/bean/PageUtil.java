//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public class PageUtil {
    public PageUtil() {
    }

    public static <T> Page<T> transPageQueryCondition2MybatisPlusPage(PageQueryCondition<T> condition, GeneralConvertor dozer) {
        Page<T> page = new Page(condition.getCurrent(), condition.getSize(), condition.isSearchCount());
        if (!condition.getOrders().isEmpty()) {
            page.setOrders(dozer.convertor(condition.getOrders(), OrderItem.class));
        }

        return page;
    }

    public static <T> PageQueryResult<T> transMybatisPlusPage2PageQueryResult(IPage<T> pageResult) {
        PageQueryResult<T> result = new PageQueryResult();
        result.setCurrent((int) pageResult.getCurrent());
        result.setSize((int) pageResult.getSize());
        if (pageResult.isSearchCount()) {
            result.setTotal((int) pageResult.getTotal());
        }

        result.setRecords(pageResult.getRecords());
        return result;
    }

    public static <T> PageQueryResult<T> transMybatisPlusPage2PageQueryResult(IPage<?> pageResult, List<T> records) {
        PageQueryResult<T> result = new PageQueryResult();
        result.setCurrent((int) pageResult.getCurrent());
        result.setSize((int) pageResult.getSize());
        if (pageResult.isSearchCount()) {
            result.setTotal((int) pageResult.getTotal());
        }

        result.setRecords(records);
        return result;
    }
}
