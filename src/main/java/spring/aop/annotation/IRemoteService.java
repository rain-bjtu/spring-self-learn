package spring.aop.annotation;

public interface IRemoteService {

    public void login(String username, String password);

    public String execute(String cmd);

    public int executeStatus(int cmdNumber);

    public int close(int seconds) throws Exception;

    public void errorOccur(int error) throws Exception;
}
