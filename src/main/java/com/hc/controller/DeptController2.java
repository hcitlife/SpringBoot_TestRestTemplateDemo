package com.hc.controller;

import com.hc.bean.Dept;
import com.hc.bean.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/dept2")
public class DeptController2 {
    @ResponseBody
    @GetMapping("/getHeader")
    public Result getHeader(String username, HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println(username + " " + token);
        Result res = new Result();
        res.setData(username + " " + token);
        res.setCode(200);
        res.setMsg("success");
        return res;
    }

    @ResponseBody
    @GetMapping("/demo1")
    public Dept demo1(@RequestParam("dname") String dname, @RequestParam("loc") String loc) {
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        System.out.println(dept);
        return dept;
    }

    @ResponseBody
    @PostMapping("/demo2")
    public Dept demo2(String dname, String loc) {
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        System.out.println(dept);
        return dept;
    }
    @ResponseBody
    @PutMapping("/demo3")
    public Dept demo3(@RequestBody Dept dept) {
        System.out.println(dept);
        return dept;
    }
    @ResponseBody
    @DeleteMapping("/demo4")
    public void demo4(@RequestBody Dept dept) {
        System.out.println(dept);
    }

    @ResponseBody
    @PostMapping("/demo5")
    public List<Dept> demo5() {
        List<Dept> res = new ArrayList<>();
        res.add(new Dept(11, "aa", "aaaaa"));
        res.add(new Dept(22, "bb", "bbbbb"));
        res.add(new Dept(11, "cc", "ccccc"));
        return res;
    }

}
