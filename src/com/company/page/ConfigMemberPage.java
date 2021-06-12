package com.company.page;

import com.company.member.Member;
import com.company.respository.MemoryRespository;

import java.util.Scanner;

public class ConfigMemberPage implements Page{
    Scanner sc = new Scanner(System.in);
    MemoryRespository memoryRespository = MemoryRespository.getInstance();

    private Member target;
    private Page prePage;
    public ConfigMemberPage(Member member, Page instance) {
        this.target = member;
        this.prePage = instance;
    }

    public void config() {
        try {
            // stateless 하게 바꿀 수 없을까..
            if (target == null) {
                System.out.println("존재하지 않는 이름입니다");
                this.back(prePage);
            } else {
                System.out.println("수정할 데이터를 선택하세요");
                System.out.println("1.이름 2.나이 3.취소");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("바꿀 이름을 입력해주세요");
                        target.setName(sc.next());
                        this.back(prePage);
                        break;
                    case 2:
                        try {
                            System.out.println("바꿀 나이를 입력해주세요");
                            target.setAge(Integer.parseInt(sc.next()));
                        } catch (Exception e) {
                            System.out.println("잘못된 나이입니다");
                        }
                        this.back(prePage);
                        break;
                    case 3:
                        this.back(prePage);
                        break;
                    default:
                        this.exit();
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        this.back(prePage);
    }

    @Override
    public void logic() {

    }

    @Override
    public void next() {

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

    }
}
