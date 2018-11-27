package com.hikari.yccdev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hikari.yccdev.domain.ErrorBody;
import com.hikari.yccdev.respository.PaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


/**
 * Created by gang.xu01@hand-china.com on 2018/11/23
 */
@RestController
@RequestMapping("palo")
public class PaloApiController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaloRepository paloRepository;

    private static final String HTTP = "http://";
    private static final String IP = "10.37.129.3";
    private static final String COLON = ":";
    private static final String PORT = "7778";
    private static final String BASIC_HTTP = HTTP + IP + COLON + PORT;

    /**
     * description: 模拟登陆
     *
     * @date 2018/11/23 3:15 PM
     * @author gang.xu01@hand-china.com
     * @param userName 用户名
     * @param pwd 密码
     *
     * @return
     * @throws
     */
    @GetMapping("/login")
    public void login(@RequestParam String userName, @RequestParam String pwd) {
        String data = restTemplate.getForObject(BASIC_HTTP
                + "/server/login?user="
                + userName
                + "&extern_password="
                + pwd, String.class);
        String sid = data == null ? "" : data.split(";")[0];
        paloRepository.save(userName, pwd);
        System.out.println(sid);
        paloRepository.save("sid", sid);
    }

    /**
     * description: 模拟创建用户
     *
     * @date 2018/11/23 3:09 PM
     * @author gang.xu01@hand-china.com
     * @param userName 用户名
     *
     * @return
     * @throws
     */
    @PostMapping("/create/user")
    public void createUser(@RequestParam String userName) {
        // 查询是否存在用户
        String data = restTemplate.getForObject(BASIC_HTTP
                + "/element/info?sid="
                + paloRepository.get("sid")
                + "&name_database=System"
                + "&name_dimension=#_USER_"
                + "&name_element="
                + userName
                + "&show_permission=1" ,String.class);
        System.out.println(data);
    }

    @ExceptionHandler(RestClientResponseException.class)
    public ErrorBody exceptionHandler(HttpClientErrorException e) throws IOException {
        return new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorBody.class);
    }

}
