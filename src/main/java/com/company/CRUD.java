package com.company;

import com.company.util.ScannerUtil;
import com.company.studentCRUD.DeleteExample;
import com.company.studentCRUD.InsertExample2;
import com.company.studentCRUD.SelectExample;
import com.company.studentCRUD.UpdateExample;

public class CRUD {
    public static void main(String[] args) {

//        asd?
        System.out.println("second commit");
        while(true){
            System.out.println("1.C//2.R//3.U//4.D");
            System.out.print("CHOOSE:  ");
            String choose = ScannerUtil.SCANNER_STR.nextLine();
            if (choose.equals("exit")) break;
            switch (choose) {
                case "1" -> InsertExample2.main(args);
                case "2" -> SelectExample.main(args);
                case "3" -> {
                    SelectExample.main(args);
                    UpdateExample.main(args);
                }
                case "4" -> DeleteExample.main(args);
                default -> System.out.println("Wrong Number");
            }
        }
    }
}
