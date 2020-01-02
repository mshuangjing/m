package com.byzoro.service.impl;

import com.byzoro.entity.City;
import com.byzoro.mapper.CityMapper;
import com.byzoro.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    @Qualifier("cityMapper")
    private CityMapper cityMapper;

    @Override
    public int insert(City city) {
        return cityMapper.insert(city);
    }


    @Override
    public int delete(Integer id) {
        return cityMapper.delete(id);
    }

    @Override
    public int update(City city) {
        return cityMapper.update(city);
    }

    @Override
    public City queryById(Integer id) {
        return cityMapper.queryById(id);
    }

    @Override
    public City queryOneByAttr(City city) {
        return cityMapper.queryOneByAttr(city);
    }

    @Override
    public int count(City city) {
        return cityMapper.count(city);
    }

    @Override
    public List<City> queryAllByAttr(City city) {
        return cityMapper.queryAllByAttr(city);
    }

    @Override
    public List<City> queryByPage(City city, Integer pageNum, Integer pageSize) {
        List<City> citys = cityMapper.queryByPage(city,(pageNum-1)*pageSize,pageSize);
        return citys;
    }

    @Override
    public List<City> queryByParentId(Integer parentId) {
        return cityMapper.queryByParentId(parentId);
    }

    @Override
    public City queryByName(String name) {
        return cityMapper.queryByName(name);
    }
}
