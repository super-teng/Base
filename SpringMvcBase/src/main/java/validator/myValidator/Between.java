package validator.myValidator;

import validator.myValidator.impl.BetweenValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

/**
 * Created by Super腾 on 2017/1/9.
 */
@Documented
@Constraint(
        validatedBy = {BetweenValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/**
 * 注解类，创建初始可以从原始某一注解中进行复制，之后保留基本的三个方法，创建自己需要的方法添加具体实现类
 */
public @interface Between {

    String message() default "{age between {min}and {max} }";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    //最小年龄
    int min();
    //最大年龄
    int max();
}
