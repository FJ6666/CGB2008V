package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.Order;

public interface OrderService {
    /**
     * 获取订单
     * @param orderId 订单ID
     * @return 返回Order对象
     */
    Order getOrder(String orderId);

    /**
     * 添加订单
     * @param order 定单实例
     */
    void addOrder(Order order);
}
