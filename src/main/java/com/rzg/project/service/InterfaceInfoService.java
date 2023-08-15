package com.rzg.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rzg.rzgapicommon.model.entity.InterfaceInfo;

/**
* @author Rzg
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-07-11 16:28:14
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
