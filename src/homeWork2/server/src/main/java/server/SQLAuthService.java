package server;

public class SQLAuthService implements AuthService {

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return SQLService.getNicknameByLoginAndPassword(login, password);
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        return SQLService.registration(login, password, nickname);
    }

    @Override
    public boolean changeNick(String oldNick, String newNick) {
        return SQLService.changeNick(oldNick, newNick);
    }
}
