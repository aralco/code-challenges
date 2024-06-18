package com.cochabamba.interview.beamtrail;

public class AB implements IA,IB{

    public static void main(String[] args) {
        AB ab = new AB();
        ab.a();
    }

    @Override
    public void a() {
        IB.super.a();
    }
}
