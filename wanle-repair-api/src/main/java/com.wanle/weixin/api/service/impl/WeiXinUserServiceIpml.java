package com.wanle.weixin.api.service.impl;

import com.wanle.domain.User;
import com.wanle.weixin.api.service.WeiXinUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import weixin.popular.api.SnsAPI;

/**
 * class_name: WeiXinUserServiceIpml
 * package: com.wanle.weixin.api.service.impl
 * describe: TODO 微信用户 serviceImpl
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/15
 * creat_time: 下午7:34
 **/
@Service
public class WeiXinUserServiceIpml implements WeiXinUserService {

    private Logger logger= LoggerFactory.getLogger(WeiXinUserService.class);


    /**
     * method_name: getUserByOauthToken
     * param: [oauthAccessToken, openId]
     * describe: TODO 通过网页授权，获取用户信息
     * creat_user: ningyijie@finupgroup.com
     * creat_date: 2018/3/15
     * creat_time: 下午7:39
     **/

    @Override
    public User getUserByOauthToken(String oauthAccessToken, String openId) {
        weixin.popular.bean.user.User user= SnsAPI.userinfo(oauthAccessToken,openId,"zh_CN");
        logger.info("openId={},通过调用网页授权获取用户信息：{}",openId,user);
        User userBean=new User();
        //如果获取到用户的信息，则转化为本地 user
        if(user!=null){
            BeanUtils.copyProperties(user,userBean);
        }
        return userBean;
    }
}
