package com.qfedu.wfxmerchant.mapper;

import com.qfedu.wfxmerchant.po.TbImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ImageMapper {

    Integer addImages(TbImages tbImages);

    List<TbImages> queryImageExistByMD5(@Param("imageMd5") String md5);

    void updateImageType(@Param("imageType") String imageType,@Param("fkId") String fkId,@Param("imageId") String imageId);
}
