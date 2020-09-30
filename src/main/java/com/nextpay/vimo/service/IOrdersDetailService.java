package com.nextpay.vimo.service;

import com.nextpay.vimo.model.Orders;
import com.nextpay.vimo.model.OrdersDetail;

public interface IOrdersDetailService extends IGeneralService<OrdersDetail> {
    Integer sumProductAmount(Long id);

    Iterable<OrdersDetail> findAllByOrders(Orders orders);
}
