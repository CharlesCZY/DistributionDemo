package com.qianfeng.distribution.controller;

import com.qianfeng.distribution.user.bean.LoginUserBean;
import com.qianfeng.distribution.user.po.SysModule;
import com.qianfeng.distribution.user.service.IUserService;
import com.qianfeng.distribution.vo.JsonResultVO;
import com.qianfeng.distribution.vo.ParentNodeVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResultVO loging(String username,String password){
        JsonResultVO jsonResultVO=new JsonResultVO();

        try {
            UsernamePasswordToken token=new UsernamePasswordToken(username,password);
            SecurityUtils.getSubject().login(token);
            jsonResultVO.setCode(1);
        }catch (AuthenticationException e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
        }
        return jsonResultVO;
    }

    @RequestMapping("/parantNode")
    @ResponseBody
    public List<ParentNodeVo> queryParantNode(){
        LoginUserBean user = (LoginUserBean) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<ParentNodeVo> parentNodeVos=userService.queryParentNode(user.getRoleCode());
        return parentNodeVos;
    }

    @RequestMapping("/allfunc")
    public String queryPermission(Model model)throws Exception{
        LoginUserBean user=(LoginUserBean) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<SysModule> moduleHasList=userService.queryFuncByRole(user.getRoleCode());
        List<SysModule> moduleAllList=userService.queryAllNoHasFunc(user.getRoleCode());
        model.addAttribute("allFuncList",moduleAllList);
        model.addAttribute("funcHasList",moduleHasList);

        return "permission";
    }

    @RequestMapping("/delfunc")
    @ResponseBody
    public JsonResultVO deleteFuncByCode(String moduleCode){
        JsonResultVO jsonResultVO=new JsonResultVO();
        try {
            userService.deleteFuncByCode(moduleCode);
            jsonResultVO.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
        }
        return jsonResultVO;
    }

    @RequestMapping("/addfunc")
    @ResponseBody
    public JsonResultVO addFunc(String moduleId,String roleId){
        JsonResultVO jsonResultVO=new JsonResultVO();
        try {
            userService.addFunc(moduleId,roleId);
            jsonResultVO.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
        }
        return jsonResultVO;
    }
}
