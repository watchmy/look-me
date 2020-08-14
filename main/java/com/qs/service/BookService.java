package com.qs.service;

import com.qs.pojo.Books;
import java.util.List;

public interface BookService {
    //    增加一个Book
    int addBook(Books book);

    //    根据id删除一个Book
    void deleteBookById(int id);

    //    更新Book信息
    int updateBook(Books book);

    //    根据id查询Book对象
    Books queryBookById(int id);

    //    查询全部Book，返回一个List集合
    List<Books> queryAllBook();
}
