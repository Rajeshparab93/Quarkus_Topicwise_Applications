package org.clover;

import java.util.List;

public class ApiResponse {

    public String total;
    public int page;
    public List<TvShow> tv_shows;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
