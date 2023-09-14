package iFellow;

import java.util.Scanner;
public class ClockDegreeCalc {
    public static void main(String[] args) {
        double h;
        double m;

        Scanner in = new Scanner(System.in);
        System.out.println("Hours = ...");
        h = in.nextDouble();
        if (h > 11){
            h=h-12;
        }
        System.out.println("Mins = ...");
        m = in.nextDouble();

        cornDegree(h, m);
    }
    public static double cornDegree(double h, double m){
        if (h > 11){
            h=h-12;
        }
        if (h > 23 | m > 60 | h < 0 | m < 0){
            return 0;
        }
        h = (h + m/60) * 30;
        m = m*6;
        double degree;
        degree = h-m;
        if (Math.abs(degree) <= 180){
            System.out.println("Degree = " + Math.abs(degree));}
        else {
            degree = 360-Math.abs(degree);
            System.out.println("Degree = " + Math.abs(degree));

        }
        return degree;
    }
}