package com.example.board.Manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Component
public class OpenApiManager {
    private final String BASE_URL = "http://apis.data.go.kr/B551011/KorService1";
    //지역기반 관광정보조회
    private final String apiUri1 = "/areaBasedList1";
    //소개정보조회
    private final String apiUri2 = "/detailIntro1";
    //지역코드조회
    private final String apiUri3 = "/areaCode1";
    private final String serviceKey = "?ServiceKey=";
    private final String defaultQueryParam = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    private final String numOfRows = "&numOfRows=10";

    private String makeUrl1(String areaCode,String sigunCode,String pageNo) throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri1 +
                serviceKey +
                defaultQueryParam +
                numOfRows +
                "&sigunguCode=" + sigunCode +
                "&pageNo=" + pageNo +
                "&areaCode=" + areaCode;
    }

    private String makeUrl2(String contentId, String contentTypeId) throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri2 +
                serviceKey +
                defaultQueryParam +
                numOfRows +
                "&contentTypeId=" + contentTypeId +
                "&contentId=" + contentId;
    }

    private String makeUrl3(String areaCode) throws UnsupportedEncodingException {
        return BASE_URL +
                apiUri3 +
                serviceKey +
                defaultQueryParam +
                "&numOfRows=30" +
                "&areaCode=" + areaCode;
    }

    public ResponseEntity<?> fetch1(String areaCode,String sigunCode, String pageNo) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl1(areaCode,sigunCode,pageNo), HttpMethod.GET, entity, Map.class);
        log.info("resultMap : " ,resultMap.getBody());
        System.out.println(resultMap);
        System.out.println(resultMap.getBody());
        return resultMap;

    }

    public ResponseEntity<?> fetch2(String contentId, String contentTypeId) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl2(contentId, contentTypeId), HttpMethod.GET, entity, Map.class);
        log.info("resultMap : " ,resultMap.getBody());
        System.out.println(resultMap.getBody());
        return resultMap;
    }
    public ResponseEntity<?> fetch3(String areaCode) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl3(areaCode), HttpMethod.GET, entity, Map.class);
        log.info("resultMap : " ,resultMap.getBody());
        System.out.println(resultMap.getBody());
        return resultMap;
    }
}
