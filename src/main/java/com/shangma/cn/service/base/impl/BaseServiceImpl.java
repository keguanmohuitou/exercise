package com.shangma.cn.service.base.impl;

import com.github.pagehelper.PageInfo;
import com.shangma.cn.mapper.base.BaseMapper;
import com.shangma.cn.service.base.BaseService;
import com.shangma.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class BaseServiceImpl<T, ID> implements BaseService<T,ID> {

    @Autowired
    private BaseMapper<T, ID> baseMapper;


    @Override
    public PageVo<T> findPage() {
        List<T> brands = baseMapper.selectByExample(null);
        return setPageVo(brands);
    }

    @Override
    public PageVo<T> findPage(Object example) {
        List<T> ts = baseMapper.selectByExample(example);
        return setPageVo(ts);
    }

    @Override
    public T findById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addEntity(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int updateEntity(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteEntity(ID id)  {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int batchAddEnTity(List<T> list) {
        list.forEach(item -> baseMapper.insert(item));
        return 1;
    }

    @Transactional
    @Override
    public int batchUpdateEntity(List<T> list) {
        list.forEach(item -> baseMapper.updateByPrimaryKey(item));
        return 1;
    }

    @Transactional
    @Override
    public int batchDelteEntity(List<ID> ids) {
        ids.forEach(item -> baseMapper.deleteByPrimaryKey(item));
        return 1;
    }

    //进行分页的设置并且返回数据
    @Override
    public PageVo<T> setPageVo(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        PageVo<T> objectPageVo = new PageVo<>();
        objectPageVo.setList(list);
        objectPageVo.setTotal(total);
        return objectPageVo;
    }
}
