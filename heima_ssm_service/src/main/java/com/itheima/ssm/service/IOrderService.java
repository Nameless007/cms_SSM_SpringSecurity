package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;


import java.util.List;

public interface IOrderService {
    public List<Orders> findAll(Integer page,Integer size)throws Exception;

    Orders findById(String id) throws Exception;
}
