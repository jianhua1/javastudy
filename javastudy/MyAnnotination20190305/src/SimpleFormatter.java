import java.lang.reflect.Field;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormatter {
    public static String format(Object obj){
        StringBuilder sb=new StringBuilder();
        try{
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            Field[] fields = aClass.getFields();
            for (Field declaredField : declaredFields) {
                System.out.println("declaredField.getName():"+declaredField.getName());
                Label label = declaredField.getAnnotation(Label.class);
                String name=label!=null?label.value():declaredField.getName() ;
                if(!declaredField.isAccessible()){
                    declaredField.setAccessible(true);
                }
                Object value=declaredField.get(obj);
                if(value!=null && declaredField.getType()== Date.class){
                    Format format = declaredField.getAnnotation(Format.class);
                    if(format!=null){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.pattern());
                        value=simpleDateFormat.format(value);
                    }
                }
                sb.append(name+": "+value);
                sb.append("\n");

            }
            for (Field field : fields) {
                System.out.println("field.getName():"+field.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
