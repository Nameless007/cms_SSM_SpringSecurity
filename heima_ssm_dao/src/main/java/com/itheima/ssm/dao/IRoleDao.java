package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

//    //根据用户id查询出所有对应的角色
////    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
////    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Select("select * from role where id in( select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.itheima.ssm.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);

}
