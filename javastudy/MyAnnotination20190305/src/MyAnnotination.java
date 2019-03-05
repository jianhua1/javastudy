import java.text.SimpleDateFormat;

public class MyAnnotination {

    public static void main(String[] args) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Student student = new Student("z3",simpleDateFormat.parse("1990-12-12"),23d);
            //System.out.println(student);
            System.out.println(SimpleFormatter.format(student));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
