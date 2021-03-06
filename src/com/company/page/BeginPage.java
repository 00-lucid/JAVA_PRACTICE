package com.company.page;

import com.company.respository.PageHistoryRespository;

import java.util.Scanner;

public class BeginPage implements Page{

    private Page case1;
    private Page case2;
    private Scanner sc;
    private PageHistoryRespository pageHistoryRespository;

    public BeginPage(Scanner sc, Page case1, Page case2, PageHistoryRespository pageHistoryRespository) {
        // 사용영역과 설정영역 철저히 분리
        this.sc = sc;
        this.case1 = case1;
        this.case2 = case2;
        this.pageHistoryRespository = pageHistoryRespository;
    }

    public void logic() {
        pageHistoryRespository.add(this);
        System.out.println("[ 무비 스테이츠에 오신걸 환영합니다! ]");
        System.out.println("권한을 선택하세요");
        System.out.println("1."+ case1.getOptionName() + " 2." + case2.getOptionName());
        this.next();
    }

    @Override
    public void next() {
        try {
            switch (Integer.parseInt(sc.next())) {
                case 1:
                    case1.logic();
                    break;
                case 2:
                    case2.logic();
                    break;
                default:
                    this.exit();
            }
        } catch (Exception e) {
            System.out.println("잘못된 선택지입니다");
            this.logic();
        }

    }

    @Override
    public void back() {
        pageHistoryRespository.get().logic();
    }

    @Override
    public void reset() {

    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public String getOptionName() {
        return "무비 스테이츠에 오신걸 환영합니다!";
    }
}
