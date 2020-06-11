package com.hc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.bean.Dept;
import com.hc.bean.DeptList;
import com.hc.bean.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.FailureCallback;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DeptController1Tests {

    @Resource
    private TestRestTemplate restTemplate;

    @Test
    public void fun() {
        System.out.println(restTemplate);
    }

    @Test
    public void test11() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/dept/demo11", String.class);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test
    public void test12() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/dept/demo12", String.class);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test
    public void test2() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/dept2/demo1?dname=aa&loc=aaaaa", String.class);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test //获取简单POJO对象
    public void test130() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", "sales");//传值，但要在url上配置相应的参数
        Dept result = restTemplate.getForObject("/dept/demo130?dname={name}", Dept.class, map);
        System.out.println(result);
    }

    @Test //获取简单POJO对象
    public void test131() throws Exception {
        Map<String, String> multiValueMap = new HashMap<>();
        multiValueMap.put("name", "sales");//传值，但要在url上配置相应的参数
        multiValueMap.put("loc", "NewYork");
        Dept result = restTemplate.getForObject("/dept/demo131?dname={name}&loc={loc}", Dept.class, multiValueMap);
        System.out.println(result);
    }
    @Test
    public void test131_() {
        Map<String, String> params = new HashMap<>();
        params.put("dname", "sales");
        params.put("loc", "NewYork");
        ResponseEntity<String> entity = restTemplate.getForEntity("/dept/demo131", String.class, params);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test //获取简单POJO对象
    public void test132() throws Exception {
        Dept result = restTemplate.getForObject("/dept/demo132/aa/aaaaa", Dept.class);
        System.out.println(result);
    }

    @Test //获取简单POJO对象
    public void test133() throws Exception {
        Map<String, String> multiValueMap = new HashMap<>();
        multiValueMap.put("name", "sales");//传值，但要在url上配置相应的参数
        multiValueMap.put("loc", "NewYork");
        Dept result = restTemplate.getForObject("/dept/demo133?dname={name}&loc={loc}", Dept.class, multiValueMap);
        System.out.println(result);
    }

    @Test //获取简单POJO对象
    public void test21() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("dname", "sales");
        multiValueMap.add("loc", "china");
        Dept dept = restTemplate.postForObject("/dept/demo21", multiValueMap, Dept.class);
        System.out.println(dept);
    }

    @Test //获取简单POJO对象
    public void test221() {
        //此处不能使用Map=HashMap，否则值传递不到Controller
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.set("dname", "sales");
        multiValueMap.set("loc", "china");

        Dept entity = restTemplate.postForObject("/dept/demo221", multiValueMap, Dept.class);
        System.out.println(entity);
    }

    @Test //获取简单POJO对象
    public void test222() {
        //此处不可以使用Map=HashMap，否则值传递不到Controller
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.set("dname", "sales");
        multiValueMap.set("loc", "china");

        Dept dept = restTemplate.postForObject("/dept/demo222", multiValueMap, Dept.class);
        System.out.println(dept);
    }

    @Test
    public void test23() {
        ParameterizedTypeReference<List<Dept>> responseType =
                new ParameterizedTypeReference<List<Dept>>() { };
        ResponseEntity<List<Dept>> responseEntity =
                restTemplate.exchange("/dept/demo23", HttpMethod.POST, null, responseType);
        List<Dept> deptList = responseEntity.getBody();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

    @Test
    public void test24() throws JsonProcessingException {
        DeptList depts = restTemplate.getForObject("/dept/demo24", DeptList.class);
        System.out.println(depts);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(depts);
        System.out.println(json);
    }

    @Test
    public void test25() {
        Class<? extends Result> responseType = new Result<List<LinkedHashMap<String, Object>>>().getClass();
        Result<List<LinkedHashMap<String, Object>>> res = restTemplate.getForObject("/dept/demo25", responseType);
        System.out.println(res);
        System.out.println(res.getCode());
        System.out.println(res.getMsg());
        List<LinkedHashMap<String, Object>> data = res.getData();
        System.out.println(data);
        data.forEach(item -> System.out.println(item.get("deptno") + " " + item.get("dname") + " " + item.get("loc")));
    }

    // PUT请求测试
    @Test
    public void test3() throws Exception {
        Dept dept = new Dept(10, "RESEARCH", "CHICAGO");
        restTemplate.put("/dept/demo3", dept);
    }

    // DELETE请求测试
    @Test
    public void test4() throws Exception {
        restTemplate.delete("/dept/demo4?deptno={no}", 10);
    }

}
