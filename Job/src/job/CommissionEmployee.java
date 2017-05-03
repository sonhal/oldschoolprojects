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
public class CommissionEmployee extends Object {
    private String firstName;
    private String lastName;
    private int SSNR;
    private double grossSales;
    private double comRate;
    
    
    
   public CommissionEmployee(String first, String last, int sosnr,
           double sales, double rate) 
   {
    firstName = first;
    lastName = last;
    SSNR = sosnr;
    setGrossSales(sales);
    setComRate(rate);
   }
   
   
   public void setFirstName(String first)
   {
    firstName = first;
   }
           
   public String getFirstName()
   {
   return firstName;
   }
   
   public void setLastName(String last)
   {
       lastName = last;
   }
   
   public String getLastName()
   {
       return lastName;
   }
   
   
   public void setSSNR(int sosnr)
   {
       SSNR = sosnr;
   }
   
   public int getSSNR(){
       return SSNR;
   }
   
   public void setGrossSales(double sales){
       if(sales >= 0.0){
           grossSales = sales;
       }
       else
           throw new IllegalArgumentException("Invalid entry");
   }
   
   public double getGrossSales(){
       return grossSales;
   }
   
   
   
   public void setComRate(double rate){
       if(rate >= 0.0 && rate < 1.0){
           comRate = rate;
       }
       else
           throw new IllegalArgumentException("Invalid entry");
   }
   
   public double getComRate(){
       return comRate;
   }
   
   
   public double getEarnings(){
       return getGrossSales() * getComRate();
   }
   
   @Override
    public String toString(){
        return "Employee = " + getFirstName() +" " + getLastName() + "\n" +
                "Sosial Security Nr = " + getSSNR() + "Earn = " + getEarnings();
    }
   
}
