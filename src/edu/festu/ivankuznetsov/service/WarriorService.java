package edu.festu.ivankuznetsov.service;

import edu.festu.ivankuznetsov.model.Warrior;

import java.io.Closeable;
import java.util.List;
import java.util.Optional;

public interface WarriorService extends Closeable {
    List<Warrior> getAll();

    Optional<Warrior> getByName(String name);

    List<Warrior> filterByHp(Integer target, Boolean asc);

}
