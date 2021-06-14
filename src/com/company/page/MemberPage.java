package com.company.page;

import com.company.member.Member;
import com.company.respository.MemoryRespository;
import com.company.respository.PageHistoryRespository;
import com.company.respository.Respository;

import java.util.Scanner;

public class MemberPage implements Page{

    private Page case1;
    private Scanner sc;
    private Respository respository;
    private PageHistoryRespository pageHistoryRespository;

    public MemberPage(Scanner sc, Page case1, Respository respository, PageHistoryRespository pageHistoryRespository) {
        this.sc = sc;
        this.case1 = case1;
        this.respository = respository;
        this.pageHistoryRespository = pageHistoryRespository;
    }

    @Override
    public String getOptionName() {
        return "사용자 권한";
    }

    @Override
    public void logic() {
        pageHistoryRespository.add(this);
        System.out.println("[ 사용자 권한 콘솔 ]");
        System.out.println("작업을 선택해주세요");
        System.out.println("1." + case1.getOptionName() + " 2.사용자 정보 수정 3.뒤로가기 4.처음으로 5.사용자 가입");
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
                    System.out.println("수정할 사용자의 이름을 입력하세요");
                    new ConfigMemberPage(respository.findByName(sc.next()), this).config();
                    break;
                case 3:
                case 4:
                    this.back();
                    break;
                case 5:
                    try {
                        Member newMember = new Member();
                        System.out.println("생성할 사용자의 이름을 입력하세요");
                        newMember.setName(sc.next());
                        System.out.println("생성할 사용자의 나이를 입력하세요");
                        newMember.setAge(Integer.parseInt(sc.next()));
                        System.out.println("생성할 사용자의 이메일을 입력하세요");
                        newMember.setEmail(sc.next());
                        System.out.println(respository.save(newMember));
                    } catch (Exception e) {
                        System.out.println("잘못된 나이입니다");
                    }
                    this.logic();
                    break;
            }
        } catch (Exception e) {
            System.out.println("잘못된 선택지입니다");
            System.out.println(e);
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
