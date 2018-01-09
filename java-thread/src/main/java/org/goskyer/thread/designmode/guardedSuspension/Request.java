package org.goskyer.thread.designmode.guardedSuspension;


import lombok.Data;

@Data
public class Request {

    private String name;

    public Request(String name) {
        super();
        this.name = name;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name;
    }
}
