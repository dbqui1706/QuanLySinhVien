package view;

import model.ManagementStudent;
import model.Student;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Views extends JFrame implements ActionListener {
    JPanel left_Panel, right_Panel;
    JLabel idStudent_Label, stuInformation_Label, fullName_Label, idClass_Label,
            theoreticalPoint_Label, practicalPoint_Label, totalPoint_Label, result_Label;
    JButton btn_Result, btn_Add, btn_Clear, btn_Delete, btn_Fix, btn_Find,btn_info;
    JTextField textField_IdStu, textField_FullName, textField_TheoreticalPoint,
            textField_PracticalPoint, textField_totalPoint, textField_Result;
    JComboBox<String> comboBox_IdClass;
    JTextArea textArea;
    static ManagementStudent managementStudent;

    public Views( ) throws HeadlessException {
        managementStudent = new ManagementStudent();
        setTitle("Chương trình quản lý sinh viên");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
        data();
        action();
        setVisible(true);
    }


    private void init() {
        /*
        Create left panel
         */
        left_Panel = new JPanel();
        left_Panel.setLayout(new GridLayout(0, 1));
        stuInformation_Label = new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER);
        stuInformation_Label.setFont(new Font("Time new roman", Font.BOLD, 20));
        idStudent_Label = new JLabel("Mã sinh viên:");
        fullName_Label = new JLabel("Họ tên");
        idClass_Label = new JLabel("Mã lớp");
        theoreticalPoint_Label = new JLabel("Điểm lý thuyết");
        practicalPoint_Label = new JLabel("Điểm thực hành");
        totalPoint_Label = new JLabel("Điểm trung bình");
        result_Label = new JLabel("Kết quả");
        textField_IdStu = new JTextField();
        textField_FullName = new JTextField();
        textField_TheoreticalPoint = new JTextField();
        textField_PracticalPoint = new JTextField();
        textField_totalPoint = new JTextField();
        textField_totalPoint.setEditable(false);
        textField_Result = new JTextField();
        textField_Result.setEditable(false);
        comboBox_IdClass = new JComboBox<String>();
        String listClas[] = {"DH21DTA", "DH21DTB", "DH21DTC", "DH21DTD"};
        for (int i = 0; i < listClas.length; i++) {
            comboBox_IdClass.addItem(listClas[i]);
        }
        left_Panel.add(stuInformation_Label);
        left_Panel.add(idStudent_Label);
        left_Panel.add(textField_IdStu);
        left_Panel.add(fullName_Label);
        left_Panel.add(textField_FullName);
        left_Panel.add(idClass_Label);
        left_Panel.add(comboBox_IdClass);
        left_Panel.add(theoreticalPoint_Label);
        left_Panel.add(textField_TheoreticalPoint);
        left_Panel.add(practicalPoint_Label);
        left_Panel.add(textField_PracticalPoint);
        left_Panel.add(totalPoint_Label);
        left_Panel.add(textField_totalPoint);
        left_Panel.add(result_Label);
        left_Panel.add(textField_Result);
        /*
        Create button
         */
        JPanel panel_Button;
        left_Panel.add(panel_Button = new JPanel());
        btn_Add = new JButton("Thêm");
        btn_Clear = new JButton("Clear");
        btn_Delete = new JButton("Xóa");
        btn_Fix = new JButton("Sửa");
        btn_Find = new JButton("Tìm");
        btn_info = new JButton("Show");
        panel_Button.add(btn_Add);
        panel_Button.add(btn_Clear);
        panel_Button.add(btn_Delete);
        panel_Button.add(btn_Fix);
        panel_Button.add(btn_Find);
        panel_Button.add(btn_info);
        /*
        Create panel right
         */
        right_Panel = new JPanel();
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Mã SV\t\t" + "Họ tên\t\t" + "Lớp\t" + "Lý thuyết\t" + "Thực hành\t" + "Trung bình\t" + "Kết quả\t\n");
        right_Panel.add(textArea);
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_Panel, right_Panel));
    }

    private void action() {
        btn_Add.addActionListener(this);
        btn_Clear.addActionListener(this);
        btn_info.addActionListener(this);
        btn_Find.addActionListener(this);
        btn_Delete.addActionListener(this);
        btn_Fix.addActionListener(this);
    }
    private String printOut(){
        String titleBar =managementStudent.out();
        textArea.setText(textArea.getText() + titleBar);
        return titleBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Add) {
          Student stu = new Student();
          stu.setIdStu(textField_IdStu.getText());
          stu.setFullName(textField_FullName.getText());
          stu.setIdClass(comboBox_IdClass.getSelectedItem().toString());
          stu.setTheoPoint(Double.parseDouble(textField_TheoreticalPoint.getText()));
          stu.setPracticePoint(Double.parseDouble(textField_PracticalPoint.getText()));

            if (!textField_IdStu.getText().isEmpty() || !textField_FullName.getText().isEmpty() ||
                    !textField_TheoreticalPoint.getText().isEmpty() || !textField_PracticalPoint.getText().isEmpty()) {
                managementStudent.addStudent(stu);
                textField_Result.setText(stu.result());
                textField_totalPoint.setText(String.valueOf(stu.totalPoint()));
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
            if (textField_IdStu.getText().isEmpty() || textField_FullName.getText().isEmpty() ||
                    textField_TheoreticalPoint.getText().isEmpty() || textField_PracticalPoint.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            }

        }
        if (e.getSource() == btn_Clear) {
            textField_Result.setText("");
            textField_totalPoint.setText("");
            textField_PracticalPoint.setText("");
            textField_TheoreticalPoint.setText("");
            textField_IdStu.setText("");
            textField_FullName.setText("");
        }
        if (e.getSource() == btn_Find){
            String idStu = textField_IdStu.getText();
            Student stu = managementStudent.findStudent(idStu);
            if (stu != null){
                textArea.setText("Mã SV\t\t" + "Họ tên\t\t" + "Lớp\t" + "Lý thuyết\t" + "Thực hành\t" + "Trung bình\t" + "Kết quả\t\n");
                textArea.setText(textArea.getText() + stu.toString());

            }else {
                JOptionPane.showMessageDialog(this,"Không tìm thấy sinh viên có mã " + idStu);
            }
        }if (e.getSource() == btn_info){
            textArea.setText("");
            textArea.setText("Mã SV\t\t" + "Họ tên\t\t" + "Lớp\t" + "Lý thuyết\t" + "Thực hành\t" + "Trung bình\t" + "Kết quả\t\n");
            printOut();
        }
        if (e.getSource() == btn_Delete){
            Student student = managementStudent.findStudent(textField_IdStu.getText());
            if (student != null){
                managementStudent.removeStudent(student);
                JOptionPane.showMessageDialog(this,"Xóa thành công");
            }
        }if (e.getSource() == btn_Fix){
            Student stu2 = new Student(textField_IdStu.getText(),textField_FullName.getText()
                    ,comboBox_IdClass.getSelectedItem().toString(),Double.parseDouble(textField_TheoreticalPoint.getText())
                    ,Double.parseDouble(textField_PracticalPoint.getText()));
            if (!managementStudent.fixInformation(textField_IdStu.getText(),stu2)){
                JOptionPane.showMessageDialog(null,"Không tồn tại mã số " + textField_IdStu.getText());
                return;
            }else {
                JOptionPane.showMessageDialog(this,"Sửa thành công");
                textArea.setText("");
                textArea.setText("Mã SV\t\t" + "Họ tên\t\t" + "Lớp\t" + "Lý thuyết\t" + "Thực hành\t" + "Trung bình\t" + "Kết quả\t\n");
                printOut();
            }
        }
    }
    private void data(){
        Student s1 = new Student("21130500","Đặng Bá Qúi","DH21DTC",9,9);
        Student s2 = new Student("21130501","Nguyễn Văn B","DH21DTC",8,6);
        Student s3 = new Student("21130502","Nguyễn Văn C","DH21DTC",6,9);
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        managementStudent = new ManagementStudent(list);
    }
}
