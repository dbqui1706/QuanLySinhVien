package main;

import view.Views;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Views();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
