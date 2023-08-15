package com.rzg.rzgapicommon.serivce;


import com.rzg.rzgapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService {

    /**
     * 从数据库中查询是否分配给用户密钥
     * @param accessKey
     * @return
     */
    public User getInvokeUser(String accessKey);
}
