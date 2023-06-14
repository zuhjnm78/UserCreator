public class LoginValidator {
    private static String allowedSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
    private static int MaxLoginLength = 20;
    private static int MaxPasswortLength = 20;
    public static void validate(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login.length() > MaxLoginLength) {
            throw new WrongLoginException("login длиннее 20 символов");
        }
        if(!login.matches("[" + allowedSymbols + "]+")) {
            throw new WrongLoginException("login содержит в себе недопустимые символы");
        }
        }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
        if (password.length() > MaxPasswortLength) {
            throw new WrongPasswordException("password длиннее 20 символов");
        }
        if (!password.matches("[" + allowedCharacters + "]+")) {
            throw new WrongPasswordException("password содержит в себе недопустимые символы");
        }


        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password введен не верно");
        }
    }

}