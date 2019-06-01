package com.qfedu.wfxmerchant.controller;

import com.qfedu.wfxmerchant.vo.JsonResultVo;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/uploadimg")
public class UploadController {
    public static final String IMAGE_BASE_URL="http://localhost/images/";

    @RequestMapping("/upload")
    @ResponseBody
    public JsonResultVo uploadGoodsImage(MultipartFile file){

        JsonResultVo jsonResultVo = new JsonResultVo();


        try {
            //用来连接FTP服务器的工具类
            FTPClient ftp = new FTPClient();
            //连接FTP服务器，默认端口是21
            //连接本机ftp服务器
            ftp.connect("192.168.52.135",21);
            //匿名用户必须使用anonymous登录，密码是邮箱
            boolean login = ftp.login("anonymous","123456@qq.com");
            //获取登录之后的响应状态
            int replyCode = ftp.getReplyCode();
            //没有响应则连接FTP失败
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("获取响应失败");
                jsonResultVo.setCode(0);
                return jsonResultVo;
            }


            //设置接收文件类型为二进制文件
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //FTP服务器上创建images文件夹（如果没有则重新创建文件夹，如果有则使用原来的文件夹）
            ftp.makeDirectory("images");
            //切换ftp上传默认文件夹
            ftp.changeWorkingDirectory("images");

            //将本地图片上传到ftp服务器上
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            ftp.storeFile(fileName, file.getInputStream());
            //退出登录
            ftp.logout();
            jsonResultVo.setMsg(IMAGE_BASE_URL+fileName);
            jsonResultVo.setCode(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResultVo;

    }
}
