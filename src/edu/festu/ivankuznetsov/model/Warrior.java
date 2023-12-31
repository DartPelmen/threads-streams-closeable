package edu.festu.ivankuznetsov.model;

public class Warrior {
    String name;
    Integer hp;

    public Warrior() {
    }

    public Warrior(String name, Integer hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "{name:"+name+",hp:"+hp+"}";
    }
}
