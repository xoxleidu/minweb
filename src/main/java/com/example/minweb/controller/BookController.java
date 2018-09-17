package com.example.minweb.controller;

import com.example.minweb.domain.Book;
import com.example.minweb.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookRepository bookRepository;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bList",bookRepository.findAll());
        mav.setViewName("bList");
        return mav;
    }

    @PostMapping("/add")
    public String add(Book book){

        bookRepository.save(book);
        return "forward:/book/list";

    }

    @GetMapping("/find/{id}")
    public ModelAndView find(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("book",bookRepository.getOne(id));
        mav.setViewName("bookupdate");
        return mav;
    }

    @PostMapping("/update")
    public String update(Book book){

        bookRepository.save(book);
        return "forward:/book/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        bookRepository.deleteById(id);
        return "redirect:/book/list";
    }


}
