package com.qs.controller;

import com.qs.pojo.Books;
import com.qs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //    获取全部书籍
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }
//     跳过来添加
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    //    添加书籍
    @RequestMapping("/addBook")
    public String addPaper(Books book) {
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

//    跳过来修改
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
//        根据传过来的id查到书籍存入model模型中
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

//    修改书籍
    @RequestMapping("updateBook")
    public String updateBook(Model model,Books book){
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books",books);
//        将修改完毕的书籍发送到书籍页面显示
        return "redirect:/book/allBook";
    }

//    删除书籍
    @RequestMapping("/del/{bookId}")
//                          获取通过路径传过来的参数id
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
