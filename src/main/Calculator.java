import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Результат операции: " + result);
    }

    /**
     * Метод запроса вида операции
     * @return возвращает оператор
     */
    public static char getOperator() {
        System.out.println("Введите операцию:");
        char operator = scanner.next().charAt(0);
        return operator;
    }

    /**
     * Метод запроса операндов
     * @return возвращает операнд
     */
    public static int getOperand() {
        System.out.println("Введите число:");
        int operand;
        if(scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз");
            if (scanner.hasNext()){
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Ошибка ввода данных");
            }
        }
        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator){
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0){
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Делить на ноль нельзя");
                }
            default:
                throw new IllegalStateException("Не известный оператор");
        }
        return result;
    }
}