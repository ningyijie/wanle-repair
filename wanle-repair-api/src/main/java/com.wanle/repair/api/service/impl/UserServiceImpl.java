package com.wanle.repair.api.service.impl;

import com.wanle.dao.EmailSecutityDao;
import com.wanle.dao.UserDao;
import com.wanle.domain.EmailSecutity;
import com.wanle.domain.User;
import com.wanle.repair.api.service.UserService;
import com.wanle.utils.MailUtil;
import com.wanle.vo.Message;
import com.wanle.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private EmailSecutityDao emailSecutityDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MailUtil mailUtil;
    @Override
    public ResultVo userRegister(User user) {
        //1、判断验证码
        try {
            String emailCode=user.getEmailCode();
            EmailSecutity emailSecutity=emailSecutityDao.selectByEmailAnd5Minute(user.getEmail());
            if(emailSecutity!=null){
                if(emailCode.equals(emailSecutity.getSecurityCode())) {
                    user.setPassword(Base64Utils.encodeToString(user.getPassword().getBytes()));
                    userDao.insertSelective(user);
                }else{
                    return new ResultVo(Message.NoResult,"验证码填写不正确");
                }

            }else {
                return new ResultVo(Message.NoResult,"验证码过期或未获取验证码，请重新获取");

            }

            return new ResultVo(Message.Success,user);
        } catch (Exception e) {
            logger.error("用户注册失败{}",e);
            return new ResultVo(Message.UnKnowError,"用户注册失败");
        }
    }

    @Override
    public ResultVo userLogin(User user) {
        try {
            user.setPassword(Base64Utils.encodeToString(user.getPassword().getBytes()));
            List<User> userList=userDao.list(user);
            if(userList!=null && userList.size()>0){
                return new ResultVo(Message.Success,userList.get(0));
            }else{
                return new ResultVo(Message.NoResult,"用户名或密码错误");
            }
        } catch (Exception e) {
            logger.error("用户登录失败",e);
            return new ResultVo(Message.UnKnowError,"用户登录失败");
        }
    }

    @Override
    public ResultVo sendUserEamilCode(String email) {
        try {
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            String content="亲爱的"+email+"你好:<br/>"+"欢迎注册万乐维修，你的注册验证码为:"+verifyCode+",该验证码5分钟内有效";
            boolean flag= mailUtil.sendHtmlMail(email,"注册验证码",content);
            if(!flag){
                return new ResultVo(Message.SystemError,"验证码发送失败，请联系管理员");
            }
            EmailSecutity emailSecutity=new EmailSecutity();
            emailSecutity.setEmail(email);
            emailSecutity.setSecurityCode(verifyCode);
           int i= emailSecutityDao.insertSelective(emailSecutity);
            return new ResultVo(Message.Success);
        } catch (Exception e) {
            logger.error("email={},获取验证码失败",email,e);
            return new ResultVo(Message.UnKnowError,"验证码入库失败");
        }
    }
}
