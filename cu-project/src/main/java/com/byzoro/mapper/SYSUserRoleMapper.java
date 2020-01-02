package com.byzoro.mapper;

import com.byzoro.entity.SYSUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SYSUserRoleMapper {
    int insert(SYSUserRole record);

    int insertSelective(SYSUserRole record);

    /**
     * 通过用户id删除用户用户组映射关系
     * @param userId
     * @return
     */
    int deleteMappingByUserId(@Param("userId") Long userId);
}