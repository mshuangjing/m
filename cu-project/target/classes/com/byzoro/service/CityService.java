package com.byzoro.service;

import com.byzoro.entity.City;

import java.util.List;

public interface CityService {

    /**
     * 增加
     *
     * @param city
     */
    int insert(City city);

    /**
     * 根据id删除
     *
     * @param id 为主键
     */
    int delete(Integer id);

    /**
     * 修改
     *
     * @param city
     */
    int update(City city);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    City queryById(Integer id);

    /**
     * 根据条件查询一个对象
     *
     * @param city
     * @return
     */
    City queryOneByAttr(City city);

    /**
     * 根据条件查询条数
     *
     * @param city
     * @return
     */
    int count(City city);

    /**
     * 根据条件查询
     *
     * @param city
     * @return
     */
    List<City> queryAllByAttr(City city);

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页条数
     * @param city
     * @return
     */
    List<City> queryByPage(City city, Integer pageNum, Integer pageSize);

    /**
     * 通过parentId查询信息
     * @param parentId
     * @return
     */
    List<City> queryByParentId(Integer parentId);

    City queryByName(String name);
}
