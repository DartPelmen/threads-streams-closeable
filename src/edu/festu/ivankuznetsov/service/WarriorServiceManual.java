package edu.festu.ivankuznetsov.service;

import edu.festu.ivankuznetsov.model.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WarriorServiceManual implements WarriorService {
    private List<Warrior> warriors;
    private ExecutorService executorService = Executors.
            newSingleThreadExecutor();

    public WarriorServiceManual(List<Warrior> warriors) {
        this.warriors = warriors;
    }

    @Override
    public List<Warrior> getAll(){
        return warriors;
    }

    @Override
    public Optional<Warrior> getByName(String name){
        var future = executorService.submit(() -> warriors
                .stream()
                .filter(x->x.getName()
                        .equals(name))
                .findAny());
        while (future.state() == Future.State.RUNNING){

        }
        if(future.state() == Future.State.SUCCESS)
            return future.resultNow();
        else return Optional.empty();
    }

    @Override
    public List<Warrior> filterByHp(Integer target, Boolean asc){
        var future = executorService.submit(() -> warriors
                .stream()
                .filter(x-> asc ? (x.getHp()>=target)
                        : (x.getHp()<=target))
                .toList());
        while (future.state() == Future.State.RUNNING){

        }
        if(future.state() == Future.State.SUCCESS)
            return future.resultNow();
        else return new ArrayList<>();
    }

    @Override
    public void close() {
        executorService.shutdown();
    }
}
