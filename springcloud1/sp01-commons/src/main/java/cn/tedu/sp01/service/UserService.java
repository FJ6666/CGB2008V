package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.User;

public interface UserService {
    //根据用户ID获取用户
    User getUser(Integer id);

    /**
     * 增加用户积分
     * @param id 指定用户ID
     * @param score 指定增加积分
     */
    void addScore(Integer id, Integer score);
}
