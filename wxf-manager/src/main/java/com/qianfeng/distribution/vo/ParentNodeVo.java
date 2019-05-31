package com.qianfeng.distribution.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParentNodeVo {
    private String text;
    private List<LeafNodeVO> nodes;
}
