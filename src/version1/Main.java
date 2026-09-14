/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labactivity1;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Hourly Employee
        HourlyEmployee h_Emp1 = new HourlyEmployee(101, "Alpha");
        h_Emp1.setTotalHoursWorked(35);
        h_Emp1.setRatePerHour(250);
        HourlyEmployee h_Emp2 = new HourlyEmployee(102, "Bravo", 45, 200);
        // Piece Worker Employee
        PieceWorkerEmployee pw_Emp1 = new PieceWorkerEmployee();
        pw_Emp1.setEmpID(201);
        pw_Emp1.setEmpName("Charlie");
        pw_Emp1.setRatePerPiece(175);
        pw_Emp1.setTotalPiecesFinished(250);
        PieceWorkerEmployee pw_Emp2 = new PieceWorkerEmployee(202, "Delta", 205, 300);
        // Commission Employee
        CommissionEmployee ce_Emp1 = new CommissionEmployee(301, "Echo");
        ce_Emp1.setTotalSale(200000.00);
        CommissionEmployee ce_Emp2 = new CommissionEmployee(302, "Foxtrot", 500000);
        // Base Plus Commission Employee
        BasePlusCommissionEmployee bpc_Emp1 = new BasePlusCommissionEmployee(401, "Golf");
        bpc_Emp1.setTotalSale(150000);
        bpc_Emp1.setBaseSalary(30000);
        BasePlusCommissionEmployee bpc_Emp2 = new BasePlusCommissionEmployee(402, "Hotel", 75000, 50000);
        
        System.out.println("\n---------------------------------------------------------------------------------------\nDISPLAY EXECUTION\n---------------------------------------------------------------------------------------\n");
        
        h_Emp1.displayHourEmployee();
        h_Emp2.displayHourEmployee();
        System.out.println("");
        
        pw_Emp1.displayPieceWorkerEmployee();
        pw_Emp2.displayPieceWorkerEmployee();
        System.out.println("");
        
        ce_Emp1.displayCommissionEmployye();
        ce_Emp2.displayCommissionEmployye();
        System.out.println("");
        
        bpc_Emp1.displayBasePlusCommissionEmployee();
        bpc_Emp2.displayBasePlusCommissionEmployee();
        
        System.out.println("\n---------------------------------------------------------------------------------------\n");
        
        System.out.println("\n---------------------------------------------------------------------------------------\nSTRING CONVERSION EXECUTION\n---------------------------------------------------------------------------------------\n");
        
        System.out.println(h_Emp1);
        System.out.println(h_Emp2);
        System.out.println("");
        
        System.out.println(pw_Emp1);
        System.out.println(pw_Emp2);
        System.out.println("");
        
        System.out.println(ce_Emp1);
        System.out.println(ce_Emp2);
        System.out.println("");
        
        System.out.println(bpc_Emp1);
        System.out.println(bpc_Emp2);
        
        System.out.println("\n---------------------------------------------------------------------------------------\n");
        
        
        
    }
    
}
