package com.bitc.xmltest.service;

import com.bitc.xmltest.dto.BoxOffice;
import com.bitc.xmltest.dto.DailyBoxOffice;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class BoxOfficeServiceImpl implements BoxOfficeService {
    @Override
    public List<DailyBoxOffice> getDailyBoxOfficeListJson(String serviceUrl) {
        List<DailyBoxOffice> itemList = null;
        URL url = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;  // 웹 서버에서 응답으로 넘겨주는 데이터를 받아오는 스트림

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

//            웹사이트 연결이 완료
            reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
//            문자열을 효과적으로 사용하기 위한 클래스
//            일반적인 문자열 String -> 매번 새로 만듬
//            StringBuilder 원본에 계속 append
//            toString -> 그제서야 일반 문자열로 바꿔줌
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

//            Gson 객체 사용
            Gson gson = new Gson();
//            Gson 을 통해서 가져온 데이터를 BoxOffice 클래스 타입으로 변환
            BoxOffice boxOffice = gson.fromJson(sb.toString(), BoxOffice.class);

            itemList = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (urlConn != null) { urlConn.disconnect(); }
        }

        return itemList;
    }
}
