package by.bsuir.studytracker.controller;

import by.bsuir.studytracker.view.MenuView;
import by.bsuir.studytracker.view.StudentView;

import java.sql.Connection;

public class MainController {

    private MenuView menuView;
    public MainController(Connection connection) {
        this.menuView = new MenuView(connection);
    }


    public void displayAdminMenu(){
        menuView.displayAdminMenu();
    }

    public String[] login(){
        return menuView.loginForm();
    }

}
