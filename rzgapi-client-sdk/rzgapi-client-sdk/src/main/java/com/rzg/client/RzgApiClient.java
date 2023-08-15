package com.rzg.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.rzg.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.rzg.utils.SignUtils.genSign;

/**
 * 请求客户端
 * @author Deuce7
 */
public class RzgApiClient {

    private String accessKey;
    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public RzgApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        return result;
    }

    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        return result;
    }



    private Map<String, String> getHeaderMap(String body){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        //hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("body", body);
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }


    public String getNameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        return httpResponse.body();
    }
}
