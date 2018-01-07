package app.mapper;

import app.Entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by hasee on 2017/12/5.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where user_name = #{userName}")
    List<User> findByName(String userName);

    @Select("select * from user where 1 = 1 ")
    @Results(value = {
            @Result(property = "userSex", column = "user_sex",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "userName", column = "user_name",javaType = String.class,jdbcType = JdbcType.VARCHAR)
    }
    )
    List<User> findAll();

    @Insert("insert into user(user_name,user_sex,age) values(#{userName},#{userSex},#{age}) ")
    int save(User user);
}
