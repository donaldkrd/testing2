import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
public class CalculatorTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculation(2,2,'+')).isEqualTo(4);
        assertThat(Calculator.calculation(4,2,'-')).isEqualTo(2);
        assertThat(Calculator.calculation(8,2,'/')).isEqualTo(4);
        assertThat(Calculator.calculation(3,2,'*')).isEqualTo(6);

        /**
         * "() ->" синтаксис лямбда выражения или анонимных функций
         * "()" - специальный вызов функции без объявления, могут передаваться параметры, которые могут
         * использоваться в правой части, после стрелки
         */
        assertThatThrownBy(() -> Calculator.calculation(8,4,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void evaluatesExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,2,'+')).isEqualTo(4);
    }
    @Test
    void subsctractionExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(4,2,'-')).isEqualTo(2);
    }
    @Test
    void multiplicationExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(3,2,'*')).isEqualTo(6);
    }
    @Test
    void divisionExpression(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(8,2,'/')).isEqualTo(4);
    }
    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol(){
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8,2,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);
        Calculator.getOperand();
        System.out.println(testedValue);
        System.setIn(inputStream);
    }
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "w";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class)
                .describedAs("Ошибка ввода данных");
        System.setIn(inputStream);
        System.setOut(null);
    }

}