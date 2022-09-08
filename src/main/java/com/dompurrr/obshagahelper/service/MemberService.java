package com.dompurrr.obshagahelper.service;

import com.dompurrr.obshagahelper.model.Member;

import java.util.List;

public interface MemberService {
    /**
     * Запись нового жителя
     * @param
     */
    void create(Member member);

    /**
     * Вывод списка всех жителей
     * @return ArrayList всех жителей
     */
    List<Member> readAll();

    /**
     * Вывод жителя по его id
     * @param id - ID жителя
     * @return житель с заданным ID
     */
    Member read(int id);

    /**
     * Обновляет жителя с заданным ID,
     * на жителя member
     * @param member житель заместо старого
     * @param id - ID жителя которого необходимо заменить
     * @return true в случае успеха, иначе - false
     */
    boolean update(Member member, Integer id);

    /**
     * Удаление жителя с заданным ID
     * @param id - id жителя для удаления
     * @return true в случае успеха, иначе - false
     */
    boolean delete(Integer id);
}
