package bank.t2208a1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ValidateAccount validate = new ValidateAccount();
        Controller controller = new Controller();

        boolean isCheck = false;
        while (!isCheck) {
            System.out.println("SĐT: ");
            String mobile = sc.nextLine();

            System.out.println("PASS: ");
            String password = sc.nextLine();

            isCheck = validate.checkAccount(mobile, password);
        }

        while (true) {
            menu();
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Số Dư: ");
                    long balance = controller.getBalanceNumber();
                    System.out.println(Controller.formatMoney(balance));
                    break;
                case 2:
                    controller.actionTransfer();
                    break;
                case 3:
                    System.out.println("Lịch sử giao dịch: ");
                    controller.getHistory();
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này!!!");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("** Lựa chọn của bạn là: ");
        System.out.println("1. Xem số dư");
        System.out.println("2. Chuyển khoản");
        System.out.println("3. Xem lịch sử");
        System.out.println("0. Thoát");
    }
}
