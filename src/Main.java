public class Main {

    public static void checkUser(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) { //проверка на превышение длины логина
                throw new WrongLoginException("Превышена длина логина");
            }

            if (password.length() > 20) {//проверка на превышение длины пароля
                throw new WrongPasswordException("Превышена длина пароля");
            }

            for (int i = 0; i < login.length(); i++) { //проверка логина на наличие недопустимых символов
                char accessSymbols = login.charAt(i);
                if (!(accessSymbols >= 'A' && accessSymbols <= 'Z') && !(accessSymbols >= 'a' && accessSymbols <= 'z') && !(accessSymbols >= '0' && accessSymbols <= '9') && accessSymbols != '_') {
                    throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
                }
            }

            for (int i = 0; i < password.length(); i++) {//проверка пароля на наличие недопустимых символов
                char accessSymbols = password.charAt(i);
                if (!(accessSymbols >= 'A' && accessSymbols <= 'Z') && !(accessSymbols >= 'a' && accessSymbols <= 'z') && !(accessSymbols >= '0' && accessSymbols <= '9') && accessSymbols != '_') {
                    throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
                }
            }

            if (!password.equals(confirmPassword)) { //проверка на соответствие пароля и подтверждения пароля
                throw new WrongPasswordException("Пароль и подтверждение пароля различны");
            }

        } catch (WrongLoginException | WrongPasswordException wrongLoginException) {
            throw new RuntimeException(wrongLoginException);
        }
    }

    public static void main(String[] args) {
        checkUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
    }
}