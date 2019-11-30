package DesignPattern.Creational;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) throws Exception{
        Members originMembers = new Members();
        originMembers.load();

        Members cloneMembers = (Members) originMembers.clone();
    }
}

class Members implements Cloneable{

    private List memberList;

    public Members() {
        memberList = new ArrayList();
    }

    public Members(List list) {
        this.memberList = list;
    }

    public void load() {
        memberList.add("Park");
        memberList.add("Kim");
        memberList.add("Cha");
    }

    public List getMemberList() {
        return memberList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List list = new ArrayList();
        for (Object s : this.getMemberList()) {
            list.add(s);
        }
        return new Members(list);
    }
}