package com.qfedu.wfxmerchant.service;

import com.qfedu.wfxmerchant.po.TbImages;

public interface IImageService {

    Integer addImages(TbImages tbImages);

    TbImages queryImageExistByMD5(String md5);

    void updateImageType(String imageType,String fkId,String imageUrl);
}
