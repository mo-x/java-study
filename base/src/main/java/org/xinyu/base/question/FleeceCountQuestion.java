package org.xinyu.base.question;

/**
 * Created by zzqno on 2017-5-3.
 * 有一个羊圈 羊出生2个月后长羊毛 每个月 至少0.7kg  最多10公斤
 * 5个月后0.6kg
 * 羊不死 每个月从出生1头羊 10年产出多少羊毛
 */
public class FleeceCountQuestion {
    public static void main(String[] args) {
        System.out.println(new FleeceCountQuestion().countAll(10, 1));
    }

    public double countAll(int year, int type) {
        //羊的个数
        int count = year * 12;
        double min = 0d;
        double base = 0d;
        if (type == 1)
            base = 0.7d;
        else
            base = 10d;
        for (int i = 3; i <= count; i++) {
            //i 既可以标明月数也可以标明羊的出生数
            if (i == 3) {
                min = 2 * base + (count - 5) * 0.7;
            } else {
                //这个月羊的出生到year长毛的月数
                int currMonth = count - 3 - i;
                if (count - currMonth >= 2) {
                    min = min + (2 * base + (currMonth - 5) * 0.7);
                }
            }
        }
        return min;
    }

}
