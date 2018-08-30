package org.goskyer.thread.communication.cross;

/**
 * Created by zzqno on 2017-6-21.
 * 交叉打印 demo1
 */
public class DBTools {
    //决定了先运行那个线程
    volatile private boolean prevISA = false;

    synchronized public void backupA() {
        try {
            while (prevISA == true) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("%%%%%%");
            }
            prevISA = true;
            notifyAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try {
            while (prevISA == false) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("######");
            }
            prevISA = false;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 10; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }
}

class BackupA extends Thread {
    private DBTools dbTools;

    public BackupA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}

class BackupB extends Thread {
    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}