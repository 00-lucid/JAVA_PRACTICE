package com.company.respository;

import com.company.member.Member;

public interface Respository {
    String save(Member member);

    String findAll();

    Member findByName(String name);

    String remove(int idx);
}
