package model;

import java.util.ArrayList;

public class ManagementStudent {
    private ArrayList<Student> listStudent;

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public ManagementStudent() {
        listStudent = new ArrayList<Student>();
    }

    public ManagementStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }
    /*
    To String
     */

    @Override
    public String toString() {
        String titleBar = "Mã SV\t\t" + "Họ tên\t\t" + "Lớp\t" + "Lý thuyết\t" + "Thực hành\t"
                + "Trung bình\t" + "Kết quả\n";

        for (Student student : this.listStudent) {
            titleBar += student.getIdStu() + "\t" + student.getFullName() + "\t" +
                    student.getIdClass() + "\t" + student.getTheoPoint() + "\t\t" +
                    student.getPracticePoint() + "\t\t" + student.totalPoint() + "\t\t"
                    + student.result() + "\n";
        }
        return titleBar;
    }

    /*
    Add student
     */
    public void addStudent(Student student) {
        listStudent.add(student);
    }

    public void removeStudent(Student student) {
        this.listStudent.remove(student);
    }
    public boolean fixInformation(String id, Student student){
        Student newStudent = findStudent(id);
        if (this.listStudent.contains(newStudent)){
            newStudent = this.listStudent.get(listStudent.indexOf(newStudent));
            newStudent.setFullName(student.getFullName());
            newStudent.setTheoPoint(student.getTheoPoint());
            newStudent.setPracticePoint(student.getPracticePoint());
            return true;
        }
        return false;
    }

    /*
    Method find student by id student
     */
    public Student findStudent(String idStudent) {
        Student student = null;
        for (Student st : listStudent) {
            if (st.getIdStu().equals(idStudent)) {
                student = st;
            }
        }
        return student;
    }

    public String out() {
        String t = "";
        for (Student student : this.listStudent) {
            t += student.toString();
        }
        return t;
    }

}
