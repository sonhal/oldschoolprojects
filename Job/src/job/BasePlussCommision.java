/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

/**
 *
 * @author sonhal
 */
public class BasePlussCommision extends CommissionEmployee {
    
    double basePay;
    
    public BasePlussCommision(String first, String last, int sosnr,
           double sales, double rate, double pay)
           {
               super(first, last, sosnr, sales, rate);
               
               setBasePay(pay);
           }
    
    public void setBasePay(double pay){
        if(pay >= 0){
            basePay = pay;
        }
        else 
            throw new IllegalArgumentException("Invalid entry");
    }
    
    
    public double getBasePay(){
        return basePay;
    }
    
    
    @Override
    public double getEarnings(){
        return getBasePay() + getGrossSales() * getComRate();
    }
    
    public String toString(){
        return "Employee = " + getFirstName() + " "+ getLastName() + "\n" +
                "Sosial Security Nr = " + getSSNR() + "\n" + "Earnings = " + getEarnings();
    }
}
