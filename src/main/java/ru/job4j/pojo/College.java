package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setSurname("Doe");
        student.setGroupe("Programmers");
        student.setDateReceipt("12-октября-2020");
        
        System.out.println(student.getName());
        System.out.println(student.getSurname());
        System.out.println(student.getGroupe());
        System.out.println(student.getDateReceipt());
    }
}
