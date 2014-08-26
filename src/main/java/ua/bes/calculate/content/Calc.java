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

    private static final Logger log = Logger.getLogger(Calc.class.getName());

    private double result;

    public String setPar(Data data) {
	result = 0;

	if (data != null && 
		data.getOneNumber() != 0.0 
		& !data.getOperation().equals("") 
		& data.getTwoNumber() != 0.0  ) {
	    switch (data.getOperation()) {
		case "%":
		    result = percent(data.getOneNumber(), data.getTwoNumber());
		    break;
		case "/":
		    result = divide(data.getOneNumber(), data.getTwoNumber());
		    break;
		case "+":
		    result = add(data.getOneNumber(), data.getTwoNumber());
		    break;
		case "-":
		    result = subtract(data.getOneNumber(), data.getTwoNumber());
		    break;
		case "sqrt":
		    result = radical(data.getOneNumber(), data.getTwoNumber());
		    break;
		case "*":
		    result = multiply(data.getOneNumber(), data.getTwoNumber());
		    break;
		default:
		    result = data.getOneNumber();
		    break;
	    }
	    log.info("\n set :" + data
		    + "\n result = " + result);
	    return Double.toString(result);
	}
	log.info("\n set :" + (data == null ? "null" : data)
		+ "\n result = Fail");
	return "Fail";
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
