package com.shangma.cn.controller.base;
import com.github.pagehelper.PageHelper;
import com.shangma.cn.common.http.AxiosResult;
import com.shangma.cn.service.base.BaseService;
import com.shangma.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<T, ID> {
    @Autowired
    private BaseService<T, ID> baseService;

    //看返回的数据判断方法执行成功还是失败
    public AxiosResult<Void> toAxios(int row) {
        return row > 0 ? AxiosResult.success() : AxiosResult.error();
    }
    //查看所有 设置分页 有分页的返回数据的时候应该返回PageVo
    @GetMapping
    public AxiosResult<PageVo<T>> findPage(@RequestParam(defaultValue = "1") int currentpage,
                                           @RequestParam(defaultValue = "5") int pageSize) {
        PageHelper.startPage(currentpage, pageSize);
        PageVo<T> page = baseService.findPage();
        return AxiosResult.success(page);
    }
    //按照id进行查询
    @GetMapping("{id}")
    public AxiosResult<T> findPage(@PathVariable ID id) {
        return AxiosResult.success(baseService.findById(id));
    }
    //新增类
    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody T entity) {
        int i = baseService.addEntity(entity);
        AxiosResult<Void> voidAxiosResult = toAxios(i);
        return voidAxiosResult;
    }
    //修改类
    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody T entity) {
        int i = baseService.updateEntity(entity);
        AxiosResult<Void> axios = toAxios(i);
        return axios;
    }
    //删除类
    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteEntity(@PathVariable ID id) {
        int i = baseService.deleteEntity(id);
        AxiosResult<Void> voidAxiosResult = toAxios(i);
        return voidAxiosResult;
    }
}
