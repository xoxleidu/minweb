package com.example.minweb.service;

import com.example.minweb.domain.Student;
import com.example.minweb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class MoneyService {

    @Resource
    private StudentRepository studentRepository;

    @Transactional//出现异常回滚注解
    public void mTom(int fromUser,int toUser,float money){

        Student fromStudent = studentRepository.getOne(fromUser);
        fromStudent.setMoney(fromStudent.getMoney() - money);
        studentRepository.save(fromStudent);

        Student toStudent = studentRepository.getOne(toUser);
        toStudent.setMoney(toStudent.getMoney() + money);
        //int zero = 1/0;//模拟异常
        studentRepository.save(toStudent);

    }

    @Transactional//出现异常回滚注解
    public void mTomX(int fromUser,int toUser,float money){

        Student fromStudent = studentRepository.getOne(fromUser);
        fromStudent.setMoney(fromStudent.getMoney() - money);
        studentRepository.save(fromStudent);

        Student toStudent = studentRepository.getOne(toUser);
        toStudent.setMoney(toStudent.getMoney() + money);
        int zero = 1/0;//模拟异常
        studentRepository.save(toStudent);

    }
}
