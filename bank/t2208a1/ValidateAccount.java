package bank.t2208a1;

public class ValidateAccount {

    public final String MOBILE = "090499999";
    public final String PASSWORD = "DaoMotLan";
    public boolean checkAccount(String mobile, String password){
        if(mobile.equals(MOBILE)){
            if (password.equals(PASSWORD)){
                System.out.println("Đăng nhập thành công!");
                return true;
            } else {
                System.out.println("Mật khẩu sai rồi!");
                return false;
            }
        } else {
            System.out.println("Kiểm tra lại số điện thoại hoặc mật khẩu nhé!");
            return false;
        }
    }
}
