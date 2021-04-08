package org.xinyu.base.equals;

import java.util.HashSet;

public class RectObject {

    public int x;
    public int y;
    public RectObject(int x,int y){
        this.x = x;
        this.y = y;
    }
/*
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final RectObject other = (RectObject)obj;
        if(x != other.x){
            return false;
        }
        if(y != other.y){
            return false;
        }
        return true;
    }*/

    public static void main(String[] args) {
        //重写equals and hashcode方法
      /*  HashSet<RectObject> set = new HashSet<>();
        RectObject r1 = new RectObject(3,3);
        RectObject r2 = new RectObject(5,5);
        RectObject r3 = new RectObject(3,3);
        set.add(r1);
        set.add(r2);
        set.add(r3);
        set.add(r1);
        //size = 2
        System.out.println("size:" + set.size());*/

        //将对象的属性值参与了hashCode的运算中，在进行删除的时候，就不能对其属性值进行修改
        //否则会造成内存泄漏
        HashSet<RectObject> set = new HashSet<>();
        RectObject r1 = new RectObject(3,3);
        RectObject r2 = new RectObject(5,5);
        RectObject r3 = new RectObject(3,3);
        set.add(r1);
        set.add(r2);
        set.add(r3);
        System.out.println(r3.hashCode());
        r3.y = 7;
        System.out.println(r3.hashCode());
        System.out.println("删除前的大小size:"+set.size());
        set.remove(r3);
        System.out.println("删除后的大小size:"+set.size());


    }
}
