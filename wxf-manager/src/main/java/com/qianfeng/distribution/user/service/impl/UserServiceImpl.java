package com.qianfeng.distribution.user.service.impl;

import com.qianfeng.distribution.user.bean.LoginUserBean;
import com.qianfeng.distribution.user.mapper.UserMapper;
import com.qianfeng.distribution.user.po.SysModule;
import com.qianfeng.distribution.user.po.UserInfo;
import com.qianfeng.distribution.user.service.IUserService;
import com.qianfeng.distribution.vo.ParentNodeVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public LoginUserBean login(String username, String password) throws NullPointerException, AuthenticationException {
        if (username==null){
            throw new NullPointerException("username is null");
        }
        if (password==null){
            throw new NullPointerException("password is null");
        }
        LoginUserBean userInfo = userMapper.checkUsername(username);

        if (userInfo==null){
            throw new UnknownAccountException();
        }

        String salt=userInfo.getAccount()+userInfo.getUserId();

        Md5Hash md5Hash=new Md5Hash(password,salt);
        String hex=md5Hash.toHex();
        String infoPassword=userInfo.getPassword();
        if (!infoPassword.equals(hex)){
            throw new IncorrectCredentialsException();
        }


        return userInfo;
    }

    @Override
    public List<ParentNodeVo> queryParentNode(String roleId) {
        List<ParentNodeVo> parentNodeVos=userMapper.queryParentNode(roleId);
        return parentNodeVos;
    }

    @Override
    public List<SysModule> queryAllNoHasFunc(String roleId) throws Exception {
       List<SysModule> moduleList=userMapper.queryAllFunc();
       List<String> stringList=userMapper.queryFuncNameByRole(roleId);
       ArrayList<SysModule> arrayList = new ArrayList<>();

       int size=moduleList.size();
       for (int i=0;i<size;i++){
           if (!stringList.contains(moduleList.get(i).getModuleCode())){
               arrayList.add(moduleList.get(i));
           }
       }

        return arrayList;
    }

    @Override
    public List<SysModule> queryFuncByRole(String roleId) throws Exception {
       List<SysModule> sysModules=userMapper.queryFuncByRole(roleId);
        return sysModules;
    }

    @Override
    public void deleteFuncByCode(String moduleCode) throws Exception {
        userMapper.delFunByCode(moduleCode);
    }

    @Override
    public void addFunc(String moduleId, String roleId) throws Exception {
        userMapper.addFunc(moduleId,roleId);
    }

    @Override
    public List<String> queryFuncByUser(String username) throws Exception {
        List<String> funcByUser = userMapper.queryFuncByUser(username);
        return funcByUser;
    }
}
