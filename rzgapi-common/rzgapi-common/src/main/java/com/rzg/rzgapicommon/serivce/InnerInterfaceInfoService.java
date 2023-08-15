package com.rzg.rzgapicommon.serivce;

import com.rzg.rzgapicommon.model.entity.InterfaceInfo;

/**
* @author Rzg
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-07-11 16:28:14
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在
     * @param url
     * @param method
     * @return
     */
    public InterfaceInfo getInterfaceInfo(String url, String method);

}
