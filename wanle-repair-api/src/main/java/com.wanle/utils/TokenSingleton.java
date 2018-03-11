package com.wanle.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * class_name: TokenSingleton
 * package: com.wanle.utis
 * describe: TODO  access_token 单例获取
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/10
 * creat_time: 下午9:28
 **/
@Service
public class TokenSingleton {

    private  Logger logger= LoggerFactory.getLogger(TokenSingleton.class);

    @Value("${weixn.appid}")
    private  String appid;

    @Value("${weixin.secret}")
    private  String secret;

    //缓存accessToken 的Map  ,map中包含 一个accessToken 和 缓存的时间戳
    //当然也可以分开成两个属性咯

    private  Map<String, String> map = new HashMap<>();

    private TokenSingleton() {
    }

    private static TokenSingleton single = null;

    // 静态工厂方法
    public static TokenSingleton getInstance() {
        if (single == null) {
            single = new TokenSingleton();
        }
        return single;
    }

    public  String getAccessToken() {
        String time = map.get("time");
        String accessToken = map.get("access_token");
        Long nowDate = System.currentTimeMillis();

        try {
            if (accessToken != null && time != null && nowDate - Long.parseLong(time) < 2 * 60 * 60 * 1000) {
                logger.info("access_token在有效期内，不需要重新获取");
                return accessToken;

            } else {
                 logger.info("accessToken 不存在或者超时 ,开始获取 access_token");
                 Token token=TokenAPI.token(appid, secret);
                logger.info("调用 接口 生成 token：{}", JSONObject.toJSONString(token));
                if(token==null || "".equals(token.getAccess_token())){
                    logger.info("调用 接口 生成 accessToken 失败");
                    return null;
                }
                accessToken=token.getAccess_token();
                //"获取jsapi_token";
                map.put("time", nowDate + "");
                map.put("access_token", accessToken);
            }
        } catch (Exception e) {
            logger.error("生成 access_token 异常",e);
        }

        return accessToken;

    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public static TokenSingleton getSingle() {
        return single;
    }

    public static void setSingle(TokenSingleton single) {
        TokenSingleton.single = single;
    }

}
