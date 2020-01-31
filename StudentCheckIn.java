import java.io.Serializable;

public class StudentCheckIn implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String date;
    String time;

    public StudentCheckIn(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }
}