package com.rzg.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rzg.rzgapicommon.model.entity.UserInterfaceInfo;

/**
* @author Rzg
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-07-15 13:57:03
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);
}
