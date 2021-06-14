package com.company.respository;

import com.company.page.Page;

import java.util.Stack;

public class PageHistoryRespository {

    private Stack<Page> pageStack = new Stack<>();

    public void add(Page page) {
        boolean isDuplicate = false;

        if (pageStack.size() > 0) {
            isDuplicate = pageStack.peek() == page;
        }

        if (!isDuplicate) {
            if (pageStack.size() > 5) {
                pageStack.remove(pageStack.size() - 1);
                pageStack.push(page);
            } else {
                pageStack.push(page);
            }
        }

        return;
    }

    public Page get() {
        if (pageStack.size() <= 0) {
            System.exit(0);
            return null;
        } else {
            pageStack.pop();
            Page prePage = pageStack.peek();
            pageStack.pop();
            return prePage;
        }
    }

    public String findAll() {
        return null;
    }
}
