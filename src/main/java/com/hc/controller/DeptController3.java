package com.hc.controller;

import com.hc.bean.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/dept3")
public class DeptController3 {

    @ResponseBody
    @GetMapping("/demo11")
    public Dept demo11() {
        Dept dept = new Dept(10, "aa", "aaaaaaaa");
        return dept;
    }

    @ResponseBody
    @GetMapping("/demo12")
    public Dept demo12(String dname, String loc) {
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }
    @ResponseBody
    @GetMapping("/demo13")
    public Dept demo13(@RequestParam("deptno") Integer deptno,  String dname, String loc) {
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    /////////////////////////////////////////////////////
    @ResponseBody
    @PostMapping("/demo21")
    public Dept demo21() {
        Dept dept = new Dept(10, "aa", "aaaaaaaa");
        return dept;
    }

    @ResponseBody
    @PostMapping("/demo22")
    public Dept demo22(String dname, String loc) {
        Dept dept = new Dept();
        dept.setDeptno(new Random().nextInt());
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

    @ResponseBody
    @PostMapping("/demo23")
    public Dept demo23(@RequestParam("query")String query, @RequestParam("deptno") Integer deptno,  String dname, String loc) {
        System.out.println(query);
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        dept.setDname(dname);
        dept.setLoc(loc);
        return dept;
    }

/////////////////////////////////////////////////////////////////////////////
    //@ResponseBody
    //@GetMapping("/demo11")
    //public String demo11() {
    //    return "sales";
    //}
    //
    //@GetMapping("/demo12")
    //public String demo12() {
    //    return "index";
    //}
    //
    //@ResponseBody
    //@GetMapping("/demo131/{dname}/{loc}")
    //public Dept demo131(@PathVariable("dname") String dname, @PathVariable("loc") String loc) {
    //    Dept dept = new Dept();
    //    dept.setDeptno(new Random().nextInt());
    //    dept.setDname(dname);
    //    dept.setLoc(loc);
    //    return dept;
    //}
    //
    //
    //@ResponseBody
    //@GetMapping(value = "/demo14")
    //public Dept demo14(@RequestParam("dname") String dname, @RequestParam("loc") String loc) {
    //    Dept dept = new Dept();
    //    dept.setDeptno(new Random().nextInt());
    //    dept.setDname(dname);
    //    dept.setLoc(loc);
    //    return dept;
    //}
    //
    ///////////////////////////////////////////////////////////////////////////
    //@ResponseBody
    //@PostMapping("/demo21")
    //public Dept demo21(String dname, String loc) {
    //    Dept dept = new Dept();
    //    dept.setDeptno(new Random().nextInt());
    //    dept.setDname(dname);
    //    dept.setLoc(loc);
    //    return dept;
    //}
    //
    //@ResponseBody
    //@PostMapping("/demo221")
    //public Dept demo221(Dept dept) {
    //    return dept;
    //}
    //
    //@ResponseBody
    //@RequestMapping("/demo222")
    //public Dept demo222(String dname, String loc) {
    //    Dept dept = new Dept();
    //    dept.setDname(dname);
    //    dept.setLoc(loc);
    //    return dept;
    //}
    //
    //@ResponseBody
    //@PostMapping("/demo23")
    //public List<Dept> demo23() {
    //    List<Dept> res = new ArrayList<>();
    //    res.add(new Dept(11, "aa", "aaaaa"));
    //    res.add(new Dept(22, "bb", "bbbbb"));
    //    res.add(new Dept(11, "cc", "ccccc"));
    //    return res;
    //}
    //
    //@ResponseBody
    //@GetMapping("/demo24")
    //public DeptList demo24() {
    //    List<Dept> temp = new ArrayList<>();
    //    temp.add(new Dept(11, "aa", "aaaaa"));
    //    temp.add(new Dept(22, "bb", "bbbbb"));
    //    temp.add(new Dept(33, "cc", "ccccc"));
    //    DeptList deptList = new DeptList();
    //    deptList.setDepts(temp);
    //    return deptList;
    //}
    //
    //@ResponseBody
    //@GetMapping("/demo25")
    //public Result demo25() {
    //    List<Dept> deptList = new ArrayList<>();
    //    deptList.add(new Dept(11, "aa", "aaaaa"));
    //    deptList.add(new Dept(22, "bb", "bbbbb"));
    //    deptList.add(new Dept(33, "cc", "ccccc"));
    //
    //    Result res = new Result();
    //    res.setData(deptList);
    //    res.setCode(200);
    //    res.setMsg("success");
    //    return res;
    //}
    //
    //@ResponseBody
    //@PutMapping("/demo3")
    //public Dept demo3(@RequestBody Dept dept) {
    //    System.out.println(dept);
    //    return dept;
    //}
    //@ResponseBody
    //@DeleteMapping("/demo4")
    //public void demo4(@RequestParam("deptno") Integer deptno) {
    //    System.out.println("deptno: "+deptno);
    //}

}
