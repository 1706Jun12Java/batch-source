package com.company.Q17;

public class Interest {
    private double principal;
    private double rate;
    private double year;

    public double getPrincipal() {
        return principal;
    }

    public double getRate() {
        return rate;
    }

    public double getTime() {
        return year;
    }

    public double getInterest(){
        return principal * rate * year;
    }

    public Interest(double principal, double rate, double year) {

        this.principal = principal;
        this.rate = rate;
        this.year = year;
    }
}
