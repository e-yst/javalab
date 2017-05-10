/**
 * Created by Eason Tse on 1/3/2017.
 */
public class Student {
    private String StudentName;
    private String StudentId;
    private String StudentClass;

    public Student(String StudentName, String StudentID, String StudentClass) {
        this.StudentName = StudentName;
        this.StudentId = StudentID;
        this.StudentClass = StudentClass;
    }

    public String getStudentName() {
        return this.StudentName;
    }

    public String getStudentId() {
        return this.StudentId;
    }

    public String getStudentClass() {
        return this.StudentClass;
    }
}
