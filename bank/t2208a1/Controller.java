package bank.t2208a1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private static long balanceNumber = 1000000;
    List<TransactionHistory>  listHistory = new ArrayList<TransactionHistory>();

    public long getBalanceNumber() {
        return balanceNumber;
    }

    public static long transfer(long money) {
        if (money < 50000) {
            System.out.println("Số tiền chuyển tối thiểu là 50,000");
        } else if (money > balanceNumber) {
            System.out.println("Số dư không đủ");
        } else {
            balanceNumber -= money;
            System.out.println("Chuyển tiền thành công");
            System.out.println("Số dư: " + balanceNumber);
        }
        return balanceNumber;
    }

    public void actionTransfer() {
        Scanner scanner = new Scanner(System.in);

        //Nhập nội dung chuyển tiền
        System.out.print("Nhập nội dung chuyển tiền: ");
        String description = scanner.nextLine();
        //Nhập số tài khoản hưởng thụ
        System.out.print("Nhập số tài khoản hưởng thụ: ");
        String beneficiaryAccount = scanner.nextLine();

        //Nhập số tiền chuyển
        System.out.print("Nhập số tiền chuyển: ");
        long money = scanner.nextLong();

        //Thực hiện chuyển tiền
        long newBalance = transfer(money);

        //Tạo một đối tượng TransactionHistory và thêm vào listHistory
        TransactionHistory TransactionHistory = new TransactionHistory(description, beneficiaryAccount, money);
        listHistory.add(TransactionHistory);
    }

    public void getHistory(){
        System.out.println("Danh sách lịch sử giao dịch:");
        for (TransactionHistory TransactionHistory : listHistory) {
            System.out.println(TransactionHistory.toString());
        }
    }

    public static String formatMoney(long money) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(money);
    }

}
