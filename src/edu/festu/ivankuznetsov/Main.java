package edu.festu.ivankuznetsov;

import edu.festu.ivankuznetsov.controller.WarriorController;
import edu.festu.ivankuznetsov.model.Warrior;
import edu.festu.ivankuznetsov.service.WarriorServiceManual;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (var controller = new WarriorController(new WarriorServiceManual(new ArrayList<>(List
                .of(new Warrior("John", 1)))))){
            controller.getAll().forEach(System.out::println);
            System.out.println(controller.getByName("John"));
            System.out.println(controller.getByName("John"));
        } catch (Exception exception){
            exception.printStackTrace();
        }

    }
}