package model;

public class Student {
    private String idStu;
    private String fullName;
    private String idClass;
    private double theoPoint, practicePoint;

    public Student(String idStu, String fullName, String idClass, double theoPoint, double practicePoint) {
        this.idStu = idStu;
        this.fullName = fullName;
        this.idClass = idClass;
        this.theoPoint = theoPoint;
        this.practicePoint = practicePoint;
    }

    public Student() {
    }

    public String getIdStu() {
        return idStu;
    }

    public void setIdStu(String idStu) {
        this.idStu = idStu;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public double getTheoPoint() {
        return theoPoint;
    }

    public void setTheoPoint(double theoPoint) {
        this.theoPoint = theoPoint;
    }

    public double getPracticePoint() {
        return practicePoint;
    }

    public void setPracticePoint(double practicePoint) {
        this.practicePoint = practicePoint;
    }

    /*
        method total point
     */
    public double totalPoint() {
        return (this.theoPoint + this.practicePoint) / 2;
    }

    /*
        method result
     */
    public String result() {
        return (totalPoint() >= 5) ? "ĐẬU" : "RỚT";
    }
    @Override
    public String toString() {
        String text = getIdStu() + "\t" + getFullName() + "\t" +
                getIdClass() + "\t" + getTheoPoint() + "\t\t" +
                getPracticePoint() + "\t\t" + totalPoint() + "\t\t"
                + result() + "\n";
        return text;
    }
}
