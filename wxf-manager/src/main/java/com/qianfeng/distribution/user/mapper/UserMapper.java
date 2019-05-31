package com.qianfeng.distribution.user.mapper;


import com.qianfeng.distribution.user.bean.LoginUserBean;
import com.qianfeng.distribution.user.po.SysModule;
import com.qianfeng.distribution.vo.ParentNodeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    LoginUserBean checkUsername(@Param("account") String account);

    List<ParentNodeVo> queryParentNode(@Param("roleCode") String roleCode);

    List<SysModule> queryAllFunc();

    List<SysModule> queryFuncByRole(@Param("roleCode") String roleCode);

    List<String> queryFuncNameByRole(@Param("roleCode") String roleCode);

    void delFunByCode(String moduleCodes);

    void addFunc(@Param("moduleId") String moduleId,@Param("roleId") String roleId);

    List<String> queryFuncByUser(@Param("username") String username);
}
