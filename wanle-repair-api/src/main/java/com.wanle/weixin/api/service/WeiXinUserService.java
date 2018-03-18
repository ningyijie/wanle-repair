package com.wanle.weixin.api.service;

import com.wanle.domain.User;

public interface WeiXinUserService {
    public User getUserByOauthToken(String oauthAccessToken, String openId);
}
