package com.company;

class Node{
    String data;
    Node next;
    Node(String data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(Node data){
        this(null,null);
    }
    public String toString(){
        if(data==null) return "null";
        else return data;
    }
}

class SList{
    Node head=new Node(null);
    //creates SListIterator instance
    public SlistIterator iterator(){
        return new SlistIterator(head);
    }
    public String toString(){
        if(head==null){
            return "list is empty";
        }
        SlistIterator sIterator=this.iterator();
        StringBuilder s=new StringBuilder();
        while (sIterator.hasNext()){
            s.append(sIterator.next()+"- >");
        }
        return " "+s;
    }
}

class SlistIterator{
    Node temp;
    SlistIterator(Node n){
        this.temp=n;
    }
    public Node next(){
        temp=temp.next;
        return temp;
    }
    public boolean hasNext(){
        return temp.next!=null;
    }
    public void insertNode(String data){
        temp.next=new Node(data,temp.next);
        temp=temp.next;
    }
    public void delete(){
        if(this.hasNext()){
            temp.next=temp.next.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SList s=new SList();
        SlistIterator obj=s.iterator();
        obj.insertNode("Syed");
        obj.insertNode("Abdul");

        System.out.println(s);
        SlistIterator obj2=s.iterator();
        obj2.delete();
        System.out.println(s);
    }
}
