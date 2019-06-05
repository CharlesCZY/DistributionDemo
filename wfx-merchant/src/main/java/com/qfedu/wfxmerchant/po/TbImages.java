package com.qfedu.wfxmerchant.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TbImages {
    private long imageId;
    private String imageUrl;
    private String imageMd5;
    private String fkId;
    private String imageType;
}
