package com.qfedu.wfxmerchant.service.GoodsService;


import com.qfedu.wfxmerchant.mapper.ImageMapper;
import com.qfedu.wfxmerchant.po.TbImages;
import com.qfedu.wfxmerchant.service.IImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService implements IImageService {

    @Resource
    private ImageMapper imageMapper;
    @Override
    public Integer addImages(TbImages tbImages) {
        return imageMapper.addImages(tbImages);
    }

    @Override
    public TbImages queryImageExistByMD5(String md5) {
        List<TbImages> tbImages=imageMapper.queryImageExistByMD5(md5);
        if (null==tbImages||tbImages.isEmpty()){
            return null;
        }

        return tbImages.get(0);
    }

    @Override
    public void updateImageType(String imageType, String fkId, String imageUrl) {
        imageMapper.updateImageType(imageType,fkId,imageUrl);
    }
}
