import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    @Label("姓名")
    private String name;
    @Label("出生日期")
    @Format(pattern = "yyyy/mm/dd")
    private Date date;
    @Label("分数")
    private Double score;

    public Student(String name, Date date, Double score) {
        this.name = name;
        this.date = date;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }


}
