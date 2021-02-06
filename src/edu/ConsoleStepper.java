package edu;

import java.util.ArrayList;

public class ConsoleStepper implements ODEupdate {

    private ArrayList<Double> tList;
    private ArrayList<Double> xList;
    private ArrayList<Double> vList;

    public ConsoleStepper() {
        tList = new ArrayList<>();
        xList = new ArrayList<>();
        vList = new ArrayList<>();
    }


    @Override
    public void update(double t, double x, double v) {
        tList.add(t);
        xList.add(x);
        vList.add(v);

    }

    public void getT_X(int n){
        for (int i = 0; i < tList.size(); i+=n) {
            System.out.println(tList.get(i)+"\t"+xList.get(i));
        }
    }

    public void getT_V(int n){
        for (int i = 0; i < tList.size(); i+=n) {
            System.out.println(tList.get(i)+"\t"+vList.get(i));
        }
    }
}
