package com.rzg.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rzg.project.common.ErrorCode;
import com.rzg.project.exception.BusinessException;
import com.rzg.project.mapper.UserInterfaceInfoMapper;
import com.rzg.project.service.UserInterfaceInfoService;
import com.rzg.rzgapicommon.model.entity.InterfaceInfo;
import com.rzg.rzgapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author Rzg
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-07-15 13:57:03
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {


    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于零");
        }
    }


    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //判断
        if(interfaceInfoId <= 0 || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("InterfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.gt("leftNum", 0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");

        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        QueryWrapper<InterfaceInfo> result = queryWrapper.select("userId");

        return this.update(updateWrapper);
    }

}




