package com.wanle.repair.api.service;

import com.wanle.domain.User;
import com.wanle.vo.ResultVo;

public interface UserService {
    ResultVo userRegister(User user);

    ResultVo userLogin(User user);

    ResultVo sendUserEamilCode(String email);
}
