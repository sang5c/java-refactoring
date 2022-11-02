package com.example.javarefactoring.ch01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록 \n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints += each.getFrequentRenterPoints();

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // 푸터 행 추가
        result += "누적 대여료: " + String.valueOf(getTotalAmount()) + "\n";
        result += "적립 포인트: " + String.valueOf(getTotalAmountForFrequentRenterPoints());
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1><EM>" + getName() + " 고객님의 대여 기록</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        // 푸터 행 추가
        result += "<P>누적 대여료: <EM>" + String.valueOf(getTotalAmount()) + "</EM><P>\n";
        result += "적립 포인트: <EM>" + String.valueOf(getTotalAmountForFrequentRenterPoints()) + "</EM><P>";
        return result;
    }

    private int getTotalAmountForFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalAmount() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}
