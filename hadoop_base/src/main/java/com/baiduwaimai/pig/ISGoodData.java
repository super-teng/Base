package com.baiduwaimai.pig;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;

/**
 * Created by Super腾 on 2016/12/21.
 */
public class ISGoodData extends FilterFunc {
    //tuple类本质上是一个与某个类型关联的对象列表，内部的数据结构是一个arraylist
    //我们可以根据所传入的数据来决定我们所关系那个索引位置的数据
    //判断是否应该被过滤掉
    public Boolean exec(Tuple tuple) throws IOException {
        if(tuple == null || tuple.size() == 0){
            return false;
        }
        try{
            //取第一个数据元素判断是否为空，去除掉空值的元素
            Object o = tuple.get(0);
            if(o == null || o == ""){
                return false;
            }else{
                return true;
            }
        }catch (IOException e){
            throw e;
        }
    }
}
