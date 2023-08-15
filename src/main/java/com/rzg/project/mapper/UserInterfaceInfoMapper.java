package com.rzg.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rzg.rzgapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author Rzg
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-07-15 13:57:03
* @Entity com.rzg.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




