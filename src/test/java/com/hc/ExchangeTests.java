package com.hc;

import com.hc.bean.Dept;
import com.hc.bean.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExchangeTests {

    @Resource
    private TestRestTemplate restTemplate;

    @Test
    public void fun() {
        System.out.println(restTemplate);
    }

    // 请求头信息测试
    @Test
    public void getHeader() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "xxxxxx");
        HttpEntity formEntity = new HttpEntity(headers);
        String[] urlVariables = new String[]{"zhangsan"};
        ResponseEntity<Result> res = restTemplate.exchange("/dept2/getHeader?username={name}", HttpMethod.GET, formEntity, Result.class, urlVariables);
        System.out.println(res);
    }

    @Test
    public void get() {//get传递单参
        ResponseEntity<Dept> res = restTemplate.exchange("/dept2/demo1?dname={name}&loc={loc}", HttpMethod.GET, null, Dept.class, "aa", "aaaaaaa");
        System.out.println(res);
    }

    @Test
    public void post() {//post传递单参
        ResponseEntity<Dept> res = restTemplate.exchange("/dept2/demo2?dname={name}&loc={loc}", HttpMethod.POST, null, Dept.class, "aa", "aaaaaaa");
        System.out.println(res);
    }

    @Test
    public void put() { //put传递单参
        Map<String, Object> map = new HashMap<>();
        map.put("deptno", 10);
        map.put("dname", "sales");
        map.put("loc", "Dalars");
        HttpEntity httpEntity = new HttpEntity(map);
        ResponseEntity<String> resp = restTemplate.exchange("/dept2/demo3", HttpMethod.PUT, httpEntity, String.class, map);
        System.out.println(resp.getBody());
    }

    @Test
    public void delete() { //delete传递单参
        Map<String, Object> map = new HashMap<>();
        map.put("deptno", 10);
        map.put("dname", "sales");
        map.put("loc", "Dalars");
        HttpEntity httpEntity = new HttpEntity(map);
        ResponseEntity<String> res = restTemplate.exchange("/dept2/demo4", HttpMethod.DELETE, httpEntity, String.class, map);
        System.out.println(res);
    }

    //    获取 json 数组对象
//    虽然 restTemplate.getForObject() 能很方便地将 json 转成 pojo, 但仅仅适合于处理单个对象的情形.
//    下面的 json 直接返回了一个数组, 这时使用 getForObject() 就不管用了.
//    我们可以使用 exchange() 方法, 最关键一点是将 List<Dept> 类型传进去, 这样 RestTemplate 就知道如何将 json 数组转成 object list 了.
    @Test
    public void test5() {
        ParameterizedTypeReference<List<Dept>> responseType = new ParameterizedTypeReference<List<Dept>>() {};
        ResponseEntity<List<Dept>> responseEntity = restTemplate.
                exchange("/dept2/demo5", HttpMethod.POST, null, responseType);
        List<Dept> deptList = responseEntity.getBody();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

}
