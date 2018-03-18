package com.wanle.repair.api.service;

import com.wanle.domain.User;
import com.wanle.vo.ResponseVo;

public interface UserService {
    ResponseVo userRegister(User user);

    ResponseVo userLogin(User user);

    ResponseVo sendUserEamilCode(String email);
}
