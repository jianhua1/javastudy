import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface JhAnnotation {
   String hehe() default "";
   String ab();
   boolean istrue() default false;

}
