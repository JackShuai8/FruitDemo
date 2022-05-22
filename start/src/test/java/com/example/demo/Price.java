package com.example.demo;

import java.util.List;

//计算水果价格的抽象类
public abstract class Price {

    /**
     * 计算水果的价格
     * @param unitPrice //单价
     * @param weight //重量
     * @param discount //折扣 默认打10折
     * @return
     */
    public Double count(Double unitPrice, Double weight, Double discount) {
        return  unitPrice * weight * (discount / 10.0);
    }
    /**
     * 计算所有水果的价格
     * @param list 所有的水果
     * @param flag 是否满减 True 满减,False不满减
     * @param full 满减的额度
     * @param reduce 满减的金额
     * @return
     */
    public  Double sum(List<Object> list,Boolean flag, int full, int reduce){
        //计算所有水果的总价格
        Double allFruitPrice = 0.0;
        for (int i = 0; i < list.size(); i++) {
            allFruitPrice += Double.parseDouble(list.get(i).toString());
        }
        //判断是否有满减活动
        if (flag){
            return fullReduce(allFruitPrice,full,reduce);
        }else {
            return allFruitPrice;
        }
    }

    /**
     * 计算满减后的价格
     * @param price 总价格
     * @param full 满减的额度
     * @param reduce 满减的金额
     * @return
     */
    public  Double fullReduce(Double price, int full, int reduce){
        if (price > full){
            return price - reduce;
        }else {
            return 0.0;
        }
    }
}
