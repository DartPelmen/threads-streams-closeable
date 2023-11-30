package edu.festu.ivankuznetsov.controller;

import edu.festu.ivankuznetsov.model.Warrior;
import edu.festu.ivankuznetsov.service.WarriorService;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class WarriorController implements Closeable {
    private final WarriorService warriorService;

    public WarriorController(WarriorService warriorService) {
        this.warriorService = warriorService;
    }
    public List<String> getAll(){
        return warriorService.getAll().stream().map(Warrior::toString).toList();
    }
    public List<String> filterByHp(Integer hp, Boolean asc){
        return warriorService.filterByHp(hp, asc).stream().map(Warrior::toString).toList();
    }

    public String getByName(String name){
        var maybe = warriorService.getByName(name);
        return maybe.isPresent() ? maybe.get().toString() : "NOPE";
    }

    @Override
    public void close() throws IOException {
        warriorService.close();
    }
}
