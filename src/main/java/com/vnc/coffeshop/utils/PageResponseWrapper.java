package com.vnc.coffeshop.utils;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponseWrapper<T> {
    private List<T> data;
    private Long totalElements;
    private Integer totalPages;
    private Integer page;
    private Integer size;

    public PageResponseWrapper(Page<T> page) {
        this.data = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.page = page.getNumber();
        this.size = page.getSize();
    }

    public List<T> getData() {
        return data;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
