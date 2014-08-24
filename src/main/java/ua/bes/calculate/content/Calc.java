/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.bes.calculate.content;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andr
 */
@Component

public class Calc {

    private static Logger log = Logger.getLogger(Calc.class.getName());

    private double result;

    public String setPar(Data data) {
	result = 0;
	log.info("set = " + data);

	switch (data.getOperation()) {
	    case "%":
		return Double.toString(
			percent(data.getOneNumber(), data.getTwoNumber())
		);
	    case "/":
		return Double.toString(
			divide(data.getOneNumber(), data.getTwoNumber())
		);
	    case "+":
		return Double.toString(
			add(data.getOneNumber(), data.getTwoNumber())
		);
	    case "-":
		return Double.toString(
			subtract(data.getOneNumber(), data.getTwoNumber())
		);
	    case "sqrt":
		return Double.toString(
			radical(data.getOneNumber(), data.getTwoNumber())
		);
	    case "*":
		return Double.toString(
			multiply(data.getOneNumber(), data.getTwoNumber())
		);

	}

	return "Oops!!!";
    }

    
    private double divide(double a, double b) {
	return a / b;
    }

   
    private double multiply(double a, double b) {
	return a * b;
    }

    
    private double add(double a, double b) {
	return a + b;
    }

   
    private double subtract(double a, double b) {
	return a - b;
    }

   
    private double percent(double a, double b) {
	return a * (b / 100);
    }

    // корень (квадратный или произвольный  )
    private double radical(double a, double b) {
	if (b == 0) {
	    return Math.sqrt(a);
	} else {
	    return Math.pow(a, 1 / b);   
	}
    }

}
