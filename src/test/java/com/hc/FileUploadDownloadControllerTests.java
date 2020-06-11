package com.hc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FileUploadDownloadControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void upload1() {
        Resource resource = new FileSystemResource("E:\\图片\\课程LOGO\\android.png");
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("fileName", resource);
        Boolean res = restTemplate.postForObject("/fileUpload", multiValueMap, Boolean.class);
        System.out.println(res);
    }

    @Test
    public void upload2() {
        Resource resource = new FileSystemResource("E:\\图片\\课程LOGO\\android.png");
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("fileName", resource);

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange("/fileUpload", HttpMethod.POST, httpEntity, Boolean.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void download1() {
        byte[] bytes = restTemplate.getForObject("/download?fileName=application", byte[].class);
        System.out.println(new String(bytes));
    }

    @Test
    public void download2() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("fileName", "application");
        HttpEntity httpEntity = new HttpEntity(multiValueMap);
        //需要指定请求方式为POST，否则请求数据fileName无法提交到后台
        ResponseEntity<byte[]> response = restTemplate.exchange("/download", HttpMethod.POST, httpEntity, byte[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(new String(response.getBody()));
        }
    }

}
