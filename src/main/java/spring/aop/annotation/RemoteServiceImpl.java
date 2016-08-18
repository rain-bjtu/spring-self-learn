package spring.aop.annotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("remoteService")
public class RemoteServiceImpl implements IRemoteService {

    @Override
    public void login(String username, String password) {
        System.out.println("Logging...");
        if (username.equals("username") && password.equals("password")) {
            System.out.println("Welcome to login remote server!");
            return;
        }
        System.out.println("Sorry, you have enter a wrong username or password!");
    }

    @Override
    public String execute(String cmd) {
        System.out.println("You are command is: " + cmd);
        System.out.println("Please wait a minute, command is being executed!");
        if (cmd.length() < 5) {
            return "Success!";
        }
        return "Failure";
    }

    @Override
    public int executeStatus(int cmdNumber) {
        System.out.println("Your cmd number is " + cmdNumber);
        return cmdNumber > 9 ? 1 : 0;
    }

    @Override
    public int close(int seconds) throws Exception {
        Random r = new Random();
        if (seconds < 3) {
            System.out.println("Time is too short!");
            return r.nextInt(10) + 1;
        } else if (seconds > 20) {
            System.out.println("Inner error, will not close remote server!");
            throw new Exception("Inner error!");
        }
        System.out.println("Remote server is closing. Good Bye...");
        return 0;
    }

    @Override
    public void errorOccur(int error) throws Exception {
        try {
            switch (error) {
            case 1:
                System.out.println("Error!");
                throw new Exception("1");
            default:
                System.out.println("No error!");
                break;
            }
        } catch (Exception e) {
            System.out.println("Catch error: " + e.getMessage());
            throw new Exception("2");
        } finally {
            System.out.println("Finally!");
        }
    }

    @Override
    public boolean isConnected(String username, String password) {
        System.out.println("Is Connected???");
        printCheckInfo();
        if (username.equals("username") && password.equals("password")) {
            return true;
        }
        return false;
    }

    private void printCheckInfo() {
        System.out.println("Checking...");
    }
}
