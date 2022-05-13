package org.mappers;

import org.apache.ibatis.annotations.Param;
import org.bean.User;

/**
 * @author yjt
 * @create 2022-05-06-16:01
 */
public interface UserDaoMapper {
    //登录根据用户名和密码查询该用户账户密码是否正确
    public User selectUser(@Param("username") String username, @Param("password") String password);
    //根据id查询用户是否存在
    public User selectId(@Param("id")int id);
    //添加用户
    public void addUser(User user);


}
