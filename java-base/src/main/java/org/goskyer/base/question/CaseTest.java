package org.goskyer.base.question;

/**
 * Created by zzq on 16-10-19.
 */
public class CaseTest {
    public static void main(String[] args) {
        System.out.println(CaseTest.getValue(2));
    }


    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;//4
            case 3:
                result = result + i * 3;//10
        }
        return result;
    }
}
