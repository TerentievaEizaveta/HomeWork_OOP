package ru.gb.family_tree;

import java.util.List;
import java.util.ArrayList;

public class FamilyTree {
    private List<Human> humanList;
    private int id;
    private int humanId;


    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        if (!humanList.contains(human) ) {
            human.setId(humanId++);
            humanList.add(human);
            addToParents(human);
            addToChildren(human);

        }
    }
    public void addToParents(Human human){
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }


    public String getInfo( ){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }


}
