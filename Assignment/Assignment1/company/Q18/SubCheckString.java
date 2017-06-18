package com.company.Q18;

public class SubCheckString extends CheckString{

    @Override
    public boolean checkUpperCase(String string) {
        return !string.equals(string.toLowerCase());
    }

    @Override
    public String toUpperCase(String string) {
        return string.toUpperCase();
    }

    @Override
    public void addTen(String string) {
        try {
            int value = Integer.parseInt(string);

            System.out.println(value + " add 10 = " + (value + 10));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
