package com.byzoro.mapper;

import com.byzoro.entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cityMapper")
public interface CityMapper {

    /**
    * 增加
    * @param city
    */
    int insert(City city);

    /**
    * 根据id删除
    * @param id 为主键
    */
    int delete(Integer id);

    /**
    * 修改
    * @param city
    */
    int update(City city);

    /**
    * 根据id查询
    * @param id
    * @return
    */
    City queryById(Integer id);

    /**
    * 根据条件查询一个对象
    * @param city
    * @return
    */
    City queryOneByAttr(@Param("query") City city);

    /**
    * 根据条件查询条数
    * @param city
    * @return
    */
    int count(@Param("query") City city);

    /**
    * 根据条件查询
    * @param city
    * @return
    */
    List<City> queryAllByAttr(@Param("query") City city);

    /**
    * 分页查询
    * @param begin 开始条数
    * @param pageSize 每页条数
    * @param city
    * @return
    */
    List<City> queryByPage(@Param("query") City city, @Param("begin") Integer begin, @Param("pageSize") Integer pageSize);

    /**
     * 通过parentId查询信息
     * @param parentId
     * @return
     */
    List<City> queryByParentId(Integer parentId);

    City queryByName(String name);

    /**
     * 通过名称和parentId查询对象
     * @param name
     * @param code
     * @return
     */
    City queryByNameAndParentId(@Param("name") String name, @Param("code") Integer code);

}
