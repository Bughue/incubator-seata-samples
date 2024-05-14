package org.apache.seata.sample.entity;

/**
 * order request
 *
 * @author minghua.xie
 * @date 2024/5/10
 **/
public class OrderRequest {
    private String userId;
    private String commodityCode;
    private int orderCount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
