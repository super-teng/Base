package validator.myValidator.impl;

import validator.myValidator.Between;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Super腾 on 2017/1/9.
 */

//自定义校验注解的实现类，实现一个约束校验，里面的参数是between注解，注解元素类型是整形
public class BetweenValidator implements ConstraintValidator<Between,Integer> {
    int min;
    int max;
    //初始化的时候对两个元素进行初始化取得当前整数的最小值和最大值进行初始化。
    public void initialize(Between between) {
        min = between.min();
        max = between.max();
    }
    //主要的校验方法，校验当前元素的正确性，是整个方法的核心
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if(integer!=null && integer <max && integer >min){
            return true;
        }else{
            return false;
        }
    }
}
