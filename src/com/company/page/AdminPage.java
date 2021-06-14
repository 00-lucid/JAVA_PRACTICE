package com.company.page;

import com.company.respository.MemoryRespository;
import com.company.respository.PageHistoryRespository;
import com.company.respository.Respository;

import java.util.Scanner;

public class AdminPage implements Page{

    private Page case1;
    private Scanner sc;
    private Respository respository;
    private PageHistoryRespository pageHistoryRespository;


    public AdminPage(Scanner sc, Page case1, Respository memoryRespository, PageHistoryRespository pageHistoryRespository) {
        this.sc = sc;
        this.case1 = case1;
        this.respository = memoryRespository;
        this.pageHistoryRespository = pageHistoryRespository;
    }

    @Override
    public String getOptionName() {
        return "관리자 권한";
    }

    @Override
    public void logic() {
        pageHistoryRespository.add(this);
        System.out.println("[ 관리자 권한 콘솔 ]");
        System.out.println("작업을 선택해주세요");
        System.out.println("1." + case1.getOptionName() + " 2.사용자 삭제 3.뒤로가기 4.처음으로 5.전체 사용자 조회");
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
                    try {
                        System.out.println("삭제할 사용자의 인덱스를 입력하세요");
                        int i = Integer.parseInt(sc.next());
                        System.out.println(respository.remove(i));
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다");
                    }
                    this.logic();
                    break;

                case 3:
                case 4:
                    this.back();
                    break;
                case 5:
                    respository.findAll();
                    this.logic();
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
}
