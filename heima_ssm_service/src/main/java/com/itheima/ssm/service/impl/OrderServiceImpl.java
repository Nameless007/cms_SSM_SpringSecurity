package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<Orders> orders= orderDao.findAll();
        return orders;
    }

    @Override
    public Orders findById(String id) throws Exception{
        return orderDao.findById(id);
    }
}
