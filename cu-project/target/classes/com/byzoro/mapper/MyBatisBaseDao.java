package com.byzoro.mapper;

import java.io.Serializable;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @author mashuangjing
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface MyBatisBaseDao<Model, PK extends Serializable> {
    /**
     * 根据ID删除数据
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 新增数据
     * @param record
     * @return int
     */
    int insert(Model record);

    /**
     * 新增数据
     * @param record
     * @return int
     */
    int insertSelective(Model record);

    /**
     * 根据ID查询数据
     * @param id
     * @return Model
     */
    Model selectByPrimaryKey(PK id);

    /**
     * 修改数据
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Model record);

    /**
     * 修改数据
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Model record);
}