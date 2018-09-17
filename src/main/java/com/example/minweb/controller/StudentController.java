package com.example.minweb.controller;

import com.example.minweb.domain.Student;
import com.example.minweb.repository.StudentRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentRepository studentRepository;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("sList",studentRepository.findAll());
        mav.setViewName("sList");
        return mav;
    }

    @PostMapping("/query")
    public ModelAndView aopQuery(Student student){

        ModelAndView mav = new ModelAndView();
        List<Student> studentList = new ArrayList<>();

        if (student.getName() == null || student.getName().length() == 0){
            mav.addObject("sList",studentList);
        }else {
            studentList = studentRepository.findAll(new Specification<Student>() {
                @Override
                public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    Predicate predicate = criteriaBuilder.conjunction();
                    if (student != null) {
                        if (student.getName() != null && !"".equals(student.getName())) {
                            predicate.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + student.getName() + "%"));
                        }
                /*if (student.getAge() != null && !"".equals(student.getAge())) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.get("age"), "%" + student.getAge() + "%"));
                }
                if (!"".equals(student.getMoney())) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.get("money"), "%" + student.getMoney() + "%"));
                }*/
                    }
                    return predicate;
                }
            });
            mav.addObject("sList",studentList);
        }

        mav.setViewName("sList");
        return mav;

    }

    @PostMapping("/add")
    @ResponseBody
    public String aopAdd(@Valid Student student, BindingResult br){

        if (br.hasErrors()) {
            return br.getFieldError().getDefaultMessage();
        }else {
            studentRepository.save(student);
            return "success";
        }

    }

    @GetMapping("/find/{id}")
    public ModelAndView aopFind(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("student",studentRepository.getOne(id));
        mav.setViewName("studentupdate");
        return mav;
    }

    @PostMapping("/update")
    public String aopUpdate(Student student){

        studentRepository.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String aopDelete(Integer id){
        studentRepository.deleteById(id);
        return "redirect:/student/list";
    }


}
