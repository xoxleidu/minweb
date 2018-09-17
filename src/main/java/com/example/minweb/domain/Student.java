package com.example.minweb.domain;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "名字不能为空")
    private String name;
    @Min(value = 1,message = "年龄不能小于1岁")
    @Max(value = 100,message = "年龄不能大于100岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    @NumberFormat(pattern = "#,#.##")
    private Float money;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Float getMoney() {
        return money;
    }

    public Student setMoney(Float money) {
        this.money = money;
        return this;
    }
}
