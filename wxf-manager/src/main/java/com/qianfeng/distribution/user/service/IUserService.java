package com.qianfeng.distribution.user.service;

import com.qianfeng.distribution.user.bean.LoginUserBean;
import com.qianfeng.distribution.user.po.SysModule;
import com.qianfeng.distribution.vo.ParentNodeVo;
import org.apache.shiro.authc.AuthenticationException;

import java.util.List;


public interface IUserService {

    LoginUserBean login(String username, String password) throws NullPointerException,AuthenticationException;

    List<ParentNodeVo> queryParentNode(String roleId);

    List<SysModule> queryAllNoHasFunc(String roleId) throws Exception;

    List<SysModule> queryFuncByRole(String roleId) throws Exception;

    void deleteFuncByCode(String moduleCode)throws Exception;

    void addFunc(String moduleId,String roleId) throws Exception;

    List<String> queryFuncByUser(String username) throws Exception;

}
