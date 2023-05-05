package com.desarrollo.domain.api;

import com.desarrollo.domain.model.OrderDetailDomain;

public interface OrderDetailService {

    void save(OrderDetailDomain domain);

    OrderDetailDomain getById(int id);
}
