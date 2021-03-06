package com.shangma.cn.service.impl;

import com.shangma.cn.entity.Brand;
import com.shangma.cn.service.base.BaseService;
import com.shangma.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand, Long> implements BaseService<Brand, Long> {

}
