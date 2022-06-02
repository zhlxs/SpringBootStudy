//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.bean;

import java.util.Collections;
import java.util.List;

public class PageQueryResult<T> {
    private List<T> records = Collections.emptyList();
    private int total = -1;
    private int size = 10;
    private int current = 1;

    private boolean success = false;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean hasPrevious() {
        return this.current > 1;
    }

    public boolean hasNext() {
        return this.current < this.getPages();
    }

    public int getPages() {
        if (this.getSize() == 0) {
            return 0;
        } else {
            int pages = this.getTotal() / this.getSize();
            if (this.getTotal() % this.getSize() != 0) {
                ++pages;
            }

            return pages;
        }
    }

    public PageQueryResult() {
    }

    public List<T> getRecords() {
        return this.records;
    }

    public int getTotal() {
        return this.total;
    }

    public int getSize() {
        return this.size;
    }

    public int getCurrent() {
        return this.current;
    }

    public void setRecords(final List<T> records) {
        this.records = records;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public void setCurrent(final int current) {
        this.current = current;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageQueryResult)) {
            return false;
        } else {
            PageQueryResult<?> other = (PageQueryResult) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label35:
                {
                    Object this$records = this.getRecords();
                    Object other$records = other.getRecords();
                    if (this$records == null) {
                        if (other$records == null) {
                            break label35;
                        }
                    } else if (this$records.equals(other$records)) {
                        break label35;
                    }

                    return false;
                }

                if (this.getTotal() != other.getTotal()) {
                    return false;
                } else if (this.getSize() != other.getSize()) {
                    return false;
                } else {
                    return this.getCurrent() == other.getCurrent();
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageQueryResult;
    }

    public int hashCode() {
        int result = 1;
        Object $records = this.getRecords();
        result = result * 59 + ($records == null ? 43 : $records.hashCode());
        result = result * 59 + this.getTotal();
        result = result * 59 + this.getSize();
        result = result * 59 + this.getCurrent();
        return result;
    }

    public String toString() {
        return "PageQueryResult(records=" + this.getRecords() + ", total=" + this.getTotal() + ", size=" + this.getSize() + ", current=" + this.getCurrent() + ")";
    }
}
