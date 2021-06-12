package com.company.page;

public interface Page {
    // 페이지는 각각 다른 I/O를 가짐

    // 페이지의 로직 함수
    void logic();

    // 인자로 받은 페이지로 이동하는 함수
    void next();

    // 이전 페이지로 이동하는 함수
    void back();

    // 처음 페이지로 이동하는 함수
    void reset();

    // 프로그램 종료 함수
    void exit();

    //
    String getOptionName();
}
