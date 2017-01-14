package com.baiduwaimai.pig;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;

/**
 * Created by Super腾 on 2016/12/21.
 */
public class Up extends EvalFunc<String>{
        public String exec(Tuple tuple) throws IOException {
            //健壮性判断，没有输入数据时
            if(tuple == null || tuple.size() == 0){
                return null;
            }
            try{
                //将所有小写转化为大写
                String s = (String)tuple.get(0);
                return s.toUpperCase();
            }catch(IOException e){
                throw e;
            }
        }
}
