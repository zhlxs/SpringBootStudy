//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageQueryCondition<T> {
    public static final long DEFAULT_MAX_SIZE = 500L;
    private T model;
    private long size;
    private long current;
    private List<OrderItem> orders;
    private boolean searchCount;

    public PageQueryCondition() {
        this.size = 10L;
        this.current = 1L;
        this.orders = new ArrayList();
        this.searchCount = true;
    }

    public PageQueryCondition(long current, long size) {
        this(current, size, true);
    }

    public PageQueryCondition(long current, long size, boolean isSearchCount) {
        this.size = 10L;
        this.current = 1L;
        this.orders = new ArrayList();
        this.searchCount = true;
        if (current > 1L) {
            this.current = current;
        }

        this.size = size;
        this.searchCount = isSearchCount;
    }

    public PageQueryCondition<T> addOrder(OrderItem... items) {
        this.orders.addAll(Arrays.asList(items));
        return this;
    }

    public PageQueryCondition<T> addOrder(List<OrderItem> items) {
        this.orders.addAll(items);
        return this;
    }

    public List<OrderItem> orders() {
        return this.getOrders();
    }

    public List<OrderItem> getOrders() {
        return this.orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    public T getModel() {
        return this.model;
    }

    public long getSize() {
        return this.size;
    }

    public long getCurrent() {
        return this.current;
    }

    public boolean isSearchCount() {
        return this.searchCount;
    }

    public void setModel(final T model) {
        this.model = model;
    }

    public void setSize(final long size) {
        this.size = size;
    }

    public void setCurrent(final long current) {
        this.current = current;
    }

    public void setSearchCount(final boolean searchCount) {
        this.searchCount = searchCount;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageQueryCondition)) {
            return false;
        } else {
            PageQueryCondition<?> other = (PageQueryCondition) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$model = this.getModel();
                    Object other$model = other.getModel();
                    if (this$model == null) {
                        if (other$model == null) {
                            break label47;
                        }
                    } else if (this$model.equals(other$model)) {
                        break label47;
                    }

                    return false;
                }

                if (this.getSize() != other.getSize()) {
                    return false;
                } else if (this.getCurrent() != other.getCurrent()) {
                    return false;
                } else {
                    Object this$orders = this.getOrders();
                    Object other$orders = other.getOrders();
                    if (this$orders == null) {
                        if (other$orders != null) {
                            return false;
                        }
                    } else if (!this$orders.equals(other$orders)) {
                        return false;
                    }

                    if (this.isSearchCount() != other.isSearchCount()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageQueryCondition;
    }

    public int hashCode() {
        int result = 1;
        Object $model = this.getModel();
        result = result * 59 + ($model == null ? 43 : $model.hashCode());
        long $size = this.getSize();
        result = result * 59 + (int) ($size >>> 32 ^ $size);
        long $current = this.getCurrent();
        result = result * 59 + (int) ($current >>> 32 ^ $current);
        Object $orders = this.getOrders();
        result = result * 59 + ($orders == null ? 43 : $orders.hashCode());
        result = result * 59 + (this.isSearchCount() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "PageQueryCondition(model=" + this.getModel() + ", size=" + this.getSize() + ", current=" + this.getCurrent() + ", orders=" + this.getOrders() + ", searchCount=" + this.isSearchCount() + ")";
    }
}
