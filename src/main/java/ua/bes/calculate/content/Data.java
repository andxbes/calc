/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.bes.calculate.content;

import org.springframework.stereotype.Component;

/**
 *
 * @author Andr
 */
@Component
public class Data {

    private boolean oneFieldReady;
    private double oneNumber,
	           twoNumber;
    private String  operation;

    /**
     * @return the oneFieldReady
     */
    public boolean isOneFieldReady() {
	return oneFieldReady;
    }

    /**
     * @param oneFieldReady the oneFieldReady to set
     */
    public void setOneFieldReady(boolean oneFieldReady) {
	this.oneFieldReady = oneFieldReady;
    }

    /**
     * @return the oneNumber
     */
    public double getOneNumber() {
	return oneNumber;
    }

    /**
     * @param oneNumber the oneNumber to set
     */
    public void setOneNumber(double oneNumber) {
	this.oneNumber = oneNumber;
    }

    /**
     * @return the twoNumber
     */
    public double getTwoNumber() {
	return twoNumber;
    }

    /**
     * @param twoNumber the twoNumber to set
     */
    public void setTwoNumber(double twoNumber) {
	this.twoNumber = twoNumber;
    }

    /**
     * @return the operation
     */
    public String getOperation() {
	return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
	this.operation = operation;
    }

    @Override
    public String toString() {
	return    "{\noneNumber : " + oneNumber 
		+ ",\ntwoNumber : "+ twoNumber 
		+ ",\noperation : " + operation+"\n}";
    }

    
  



}
