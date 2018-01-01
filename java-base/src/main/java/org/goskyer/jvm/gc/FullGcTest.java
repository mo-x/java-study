package org.goskyer.jvm.gc;

public class FullGcTest {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte[] bytes1 = new byte[2 * _1MB];
        byte[] bytes2 = new byte[2 * _1MB];
        byte[] bytes3 = new byte[2 * _1MB];
        byte[] bytes4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
