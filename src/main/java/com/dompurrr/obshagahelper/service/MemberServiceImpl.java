package com.dompurrr.obshagahelper.service;

import com.dompurrr.obshagahelper.model.Member;
import com.dompurrr.obshagahelper.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MemberServiceImpl implements MemberService{
    private static final Map<Integer, Member> MEMBER_REPOSITORY_MAP  = new HashMap<>();

    private static final AtomicInteger MEMBER_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Member member) {
        final Integer memberId = MEMBER_ID_HOLDER.incrementAndGet();
        member.setId(memberId);
        MEMBER_REPOSITORY_MAP.put(memberId, member);
    }

    @Override
    public List<Member> readAll() {
        return new ArrayList<>(MEMBER_REPOSITORY_MAP.values());
    }

    @Override
    public Member read(int id) {
        return MEMBER_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Member member, Integer id) {
        if (MEMBER_REPOSITORY_MAP.containsKey(id)){
            member.setId(id);
            MEMBER_REPOSITORY_MAP.put(id, member);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return MEMBER_REPOSITORY_MAP.remove(id) != null;
    }
}
