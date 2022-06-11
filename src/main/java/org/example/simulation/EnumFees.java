package org.example.simulation;

public enum EnumFees {
    IR180(180,.225d),IR365(360,.2d),IR720(720,.175d),IR(Integer.MAX_VALUE,.15d);

    private int timeDays;
    private double fees;

    EnumFees(int timeDays, double fees) {
        this.timeDays = timeDays;
        this.fees = fees;
    }

    public int getTimeDays() {
        return timeDays;
    }

    public double getFees() {
        return fees;
    }
}
