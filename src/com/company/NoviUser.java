package com.company;


import java.lang.ref.SoftReference;
import java.util.Scanner;

public class NoviUser {

    Scanner sc = new Scanner(System.in);
    Skener skener = new Skener();




 public void odstampaj() {


     System.out.println("-----------------------------------------PRVO OVO ISKOPIRAJ U SQLDBX DA DOBIJES POGODBU I STRANKU------------------------------------------------------------");
     System.out.println("                                                                                                                                   ");
     System.out.println("SELECT * FROM EX_ACQ_POGODBA WHERE OUT_POGODBA_ID=" +"'" + skener.cupanjeOCD()+"'" +";");

     //--------------------------------------------------------------UPISI U NEXT LINE -------------------------------------------------------------------------------------------------//
     System.out.println("1. pogodba_id = ");
     String pogodba_id = sc.nextLine();
     System.out.println("2. stranka_id = ");
     String stranka_id = sc.nextLine();

     //-------------------------------------------------------------SELECT DA SE PRONADJE OUT_COM_ID--------------------------------------------------------------------------------------//

     System.out.println("SELECT * FROM PO_ACQ_CONTRACT_COMM WHERE CONTRACT_ID=" + pogodba_id + ";");

    System.out.println("3. out_comm_id = ");
     String out_comm_id = sc.nextLine();

     //-------------------------------------------------------------PRONALAZENJE COMM_ID --------------------------------------------------------------------------------------------------//

     System.out.println("SELECT * FROM EX_ACQ_COMM_MODEL WHERE OUT_COMM_ID=" + "'"+ out_comm_id + "'" + ";");



     System.out.println("4. comm_id = ");
     String comm_id = sc.nextLine();

     //-------------------------------------------------------------OUT PRICING POSITION I PRICING GROUP ID ----------------------------------------------------------------------------------//

     System.out.println("SELECT * FROM PO_ACQ_COMM_TERMPROD WHERE COMM_ID=" + comm_id + ";");


     System.out.println("5. out_pricing_position = ");
     String out_pricing_position = sc.nextLine();
     System.out.println("6. pricing_group_id = ");
     String pricing_group_id = sc.nextLine();

     //-------------------------------------------------------------OUT_TERMINAL_ID  --------------------------------------------------------------------------------------------------------//

     System.out.println("SELECT * FROM PO_ACQ_CONTRACT_FREQ WHERE CONTRACT_ID=" + pogodba_id + ";");



     System.out.println("7. out_terminal_id = ");
     String out_terminal_id = sc.nextLine();

     //-------------------------------------------------------------PROD MESTO ID ------------------------------------------------------------------------------------------------------------//

     System.out.println("SELECT * FROM PO_ACQ_POGODBA_PM WHERE POGODBA_ID =" + pogodba_id + ";");


     System.out.println("8. prod_mesto_id = ");
     String prod_mesto_id = sc.nextLine();

     // ------------------------------------------------------------TERMINAL_ID --------------------------------------------------------------------------------------------------------------//

     System.out.println("SELECT max(terminal_id) FROM EX_ACQ_TERMINAL WHERE TERMINAL_ID  like '184%';"); // PRONALAZI POSLEDNJI TERMINAL ID u TABELI. DODAJ JOSH JEDAN
     System.out.println("PRONALAZI POSLEDNJI TERMINAL ID U BAZI, PREPISI TAJ BROJ, AUTOMATSKI CE DODATI +1");
     System.out.println("9. terminal_id = ");
     String terminal_id = sc.nextLine() + 1;

     //------------------------------------------------------------PRICING_POSITION_ID--------------------------------------------------------------------------------------------------------//

     System.out.println("SELECT * FROM EX_ACQ_PRICING_POSITION WHERE OUT_PRICING_POSITION_ID=" + "'" + out_pricing_position + "'" + ";");

     System.out.println(" 10. pricing_position_id = ");
     String pricing_position_id = sc.nextLine();


     //-----------------------------------------------------------RUCNO PRAVLJENJE TERMINALA --------------------------------------------------------------------------------------------------//

     System.out.println("INSERT INTO EX_ACQ_TERMINAL (TERMINAL_ID,  OUT_TERMINAL_ID, TUJ, PARTNER_ID, TIP_TERMINAL_ID, PROD_MESTO_ID, NADMODEL_ID, OFFLINE, EMV, ROCNI_VNOS, PC_BLAG, GOTOVINA, VRSTICA_1, VRSTICA_2, VRSTICA_3, POZDRAV, URA_DLL, STATUS, DAT_STATUS, UPO_ID, DAT_SPR, PREDAVTORIZACIJA) VALUES (" + terminal_id + "," + out_terminal_id + ","  + "'N', 5555, 2," + prod_mesto_id + ", 2, 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'CAO', '00.00.00', 'P', '2019-01-01', 'Created By deqamanager', '2019-01-01', 'N');" );




             //---------------------------------------------------UPDATE POLJA PREKO POGODBE I STRANKE---------------------------------------------------------------------------------//

     System.out.println("UPDATE EX_ACQ_POGODBA SET VELJA_OD = '2019-01-01', TERMS_CONDITIONS_DATE = '2019-01-01', CREATED_ON = '2019-01-01' WHERE POGODBA_ID =" + pogodba_id + ";");
     System.out.println("UPDATE PO_ACQ_CONTRACT_COMM SET VALID_FROM = '2019-01-01' WHERE CONTRACT_ID=" + pogodba_id + ";");
     System.out.println("UPDATE PO_ACQ_CONTRACT_FREQ SET START_OF_CHARGE='2019-01-01' WHERE CONTRACT_ID=" + pogodba_id + ";");
     System.out.println("UPDATE PO_ACQ_CONTRACT_FREQ SET VALID_FROM='2019-01-01' WHERE CONTRACT_ID=" + pogodba_id + ";");

     System.out.println("UPDATE  EX_ACQ_COMM_MODEL SET VALID_FROM = '2019-01-01' WHERE COMM_ID = " + comm_id + ";");
     System.out.println("UPDATE EX_ACQ_PRICING_POSITION SET PP_FEE_TYPE_ID=8 WHERE PRICING_POSITION_ID= " + pricing_position_id + ";");
     System.out.println("UPDATE EX_ACQ_PRICING_POSITION SET VALID_FROM='2019-01-01' WHERE PRICING_POSITION_ID=" + pricing_position_id + ";");
     System.out.println("UPDATE EX_ACQ_PROD_MESTO SET STRANKA_ID = 176388 WHERE PROD_MESTO_ID = " + prod_mesto_id + ";");

     System.out.println("INSERT INTO PO_ACQ_PRODUCT_POSITION (TERM_ACQ_PROD_ID, OUT_PRICING_POSITION_ID, VALID_FROM, VALID_TO) VALUES ('R1',"  + "'" + out_pricing_position + "'," + " '2019-01-01', '2019-06-28');");

     System.out.println("                                                                                                                                                                          ");
     System.out.println("-----------------------------------------S---T---R---O---S---E---K---------------------------------------------------------------------------------------------------------");
     System.out.println(" SELECT * FROM EX_ACQ_STROSEK WHERE POGODBA_ID= " + pogodba_id + ";" );

 }
}
