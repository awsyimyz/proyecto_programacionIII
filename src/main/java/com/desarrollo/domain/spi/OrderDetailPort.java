package com.desarrollo.domain.spi;

import com.desarrollo.domain.model.OrderDetailDomain;

public interface OrderDetailPort {

    void save(OrderDetailDomain domain);
}
