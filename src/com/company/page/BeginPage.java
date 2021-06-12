package com.company.page;

import java.util.Scanner;

public class BeginPage implements Page{
    Scanner sc = new Scanner(System.in);

    private static final Page instance = new BeginPage();
    Page memberPage = MemberPage.getInstance();
    Page adminPage = AdminPage.getInstance();

    public static Page getInstance() {
        return instance;
    }

    public BeginPage() {}

    public void logic() {
        System.out.println("[ 무비 스테이츠에 오신걸 환영합니다! ]");
        System.out.println("권한을 선택하세요");
        System.out.println("1.사용자 2.어드민");
        this.next();
    }

    @Override
    public void next() {
        try {
            switch (Integer.parseInt(sc.next())) {
                case 1:
                    memberPage.logic();
                    break;
                case 2:
                    adminPage.logic();
                    break;
                default:
                    this.exit();
            }
        } catch (Exception e) {
            System.out.println("잘못된 선택지입니다");
            this.back(instance);
        }

    }

    @Override
    public void back(Page page) {
        page.logic();
    }

    @Override
    public void reset() {

    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
