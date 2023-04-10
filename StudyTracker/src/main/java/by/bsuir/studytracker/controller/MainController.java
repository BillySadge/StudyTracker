package by.bsuir.studytracker.controller;

import by.bsuir.studytracker.view.MenuView;
import by.bsuir.studytracker.view.StudentView;

import java.sql.Connection;

public class MainController {

    private MenuView menuView;

    public MainController() {
        this.menuView = new MenuView();
    }

    public void displayAdminMenu(){
        menuView.displayAdminMenu();
    }

    public void displayInstructorMenu(){
        menuView.displayInstructorMenu();
    }
    public void displayStudentMenu(){
        menuView.displayStudentMenu();
    }


    public String[] login(){
        return menuView.loginForm();
    }




}
