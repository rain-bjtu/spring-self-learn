package spring.aop.annotation;

public interface IRemoteService {

    public void login(String username, String password);

    public String execute(String cmd);

    public String execute(String cmd, int times);

    public int executeStatus(int cmdNumber);

    public int close(int seconds) throws Exception;

    public String errorOccur(int error) throws Exception;

    public boolean isConnected(String username, String password);
}
