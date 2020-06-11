package com.hc.controller;

import com.hc.bean.Dept;
import com.hc.bean.DeptList;
import com.hc.bean.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/dept")
public class DeptController1 {

    @ResponseBody
    @GetMapping("/demo11")
    public String demo11() { //Get字符串
        return "sales";
    }

    @GetMapping("/demo12")
    public String demo12() {//Get页面
        return "index";
    }

    @ResponseBody
    @GetMapping("/demo130")
    public Dept demo13(String dname) { //Get带参数，返回对象
        Dept dept = new Dept();
        dept.setDname(dname);
        return dept;
    }
    @ResponseBody
    @GetMapping("/demo131")
    public Dept demo131(String dname, String loc) {//Get带参数，返回对象
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    @ResponseBody
    @GetMapping("/demo132/{dname}/{loc}")
    public Dept demo132(@PathVariable("dname") String dname, @PathVariable("loc") String loc) {//Get带参数，返回对象
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    @ResponseBody
    @GetMapping(value = "/demo133")
    public Dept demo133(@RequestParam("dname") String dname, @RequestParam("loc") String loc) {//Get带参数，返回对象
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    /////////////////////////////////////////////////////////////////////////
    @ResponseBody
    @PostMapping("/demo21")
    public Dept demo21(String dname, String loc) {
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    @ResponseBody
    @PostMapping("/demo221")
    public Dept demo221(Dept dept) {
        return dept;
    }

    @ResponseBody
    @RequestMapping("/demo222")
    public Dept demo222(String dname, String loc) {
        Dept dept = new Dept();
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    @ResponseBody
    @PostMapping("/demo23")
    public List<Dept> demo23() {
        List<Dept> res = new ArrayList<>();
        res.add(new Dept(11, "aa", "aaaaa"));
        res.add(new Dept(22, "bb", "bbbbb"));
        res.add(new Dept(11, "cc", "ccccc"));
        return res;
    }

    @ResponseBody
    @GetMapping("/demo24")
    public DeptList demo24() {
        List<Dept> temp = new ArrayList<>();
        temp.add(new Dept(11, "aa", "aaaaa"));
        temp.add(new Dept(22, "bb", "bbbbb"));
        temp.add(new Dept(33, "cc", "ccccc"));
        DeptList deptList = new DeptList();
        deptList.setDepts(temp);
        return deptList;
    }

    @ResponseBody
    @GetMapping("/demo25")
    public Result demo25() {
        List<Dept> deptList = new ArrayList<>();
        deptList.add(new Dept(11, "aa", "aaaaa"));
        deptList.add(new Dept(22, "bb", "bbbbb"));
        deptList.add(new Dept(33, "cc", "ccccc"));

        Result res = new Result();
        res.setData(deptList);
        res.setCode(200);
        res.setMsg("success");
        return res;
    }

    @ResponseBody
    @PutMapping("/demo3")
    public Dept demo3(@RequestBody Dept dept) {
        System.out.println(dept);
        return dept;
    }
    @ResponseBody
    @DeleteMapping("/demo4")
    public void demo4(@RequestParam("deptno") Integer deptno) {
        System.out.println("deptno: "+deptno);
    }

}
