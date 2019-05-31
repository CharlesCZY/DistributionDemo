package com.qianfeng.distribution.configuration;

import com.qianfeng.distribution.realm.AccountRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


/**
 * 负责手工创建对象
 */
@Configuration
public class AppConfiguration {

    @Bean
    public DefaultWebSecurityManager provideSecurityManager(AccountRealm accountRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm);
        return securityManager;

    }


    @Bean
    public ShiroFilterFactoryBean provideShiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();

        shiroFilterFactoryBean.setLoginUrl("/page/login.html");
        linkedHashMap.put("/page/login.html","anon");
        linkedHashMap.put("/user/login","anon");
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/css/**","anon");

        linkedHashMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator proxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor provideAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager);
        return sourceAdvisor;
    }
}
