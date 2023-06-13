public class UserCreator {
    public static void createUser(String login, String password, String confirmPassword) {
        try {
            createLogin(login);
            createPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void createLogin(String login) throws WrongLoginException {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
        if (login.length() > 20) {
            throw new WrongLoginException("login длиннее 20 символов");
        }
        if(!login.matches("[" + allowedCharacters + "]+")) {
            throw new WrongLoginException("login содержит в себе недопустимые символы");
        }
        }

    private static void createPassword(String password, String confirmPassword) throws WrongPasswordException {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
        if (password.length() > 20 || !password.matches("[" + allowedCharacters + "]+")) {
            throw new WrongPasswordException("password содержит в себе недопустимые символы");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password длиннее 20 символов");
        }
    }

}