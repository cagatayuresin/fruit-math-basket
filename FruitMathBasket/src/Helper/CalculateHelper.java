package Helper;

import Model.FruitEnum;
import Model.OperatorEnum;

import java.util.Random;

public class CalculateHelper {

    private Random random;

    public int firstOperand;
    public OperatorEnum operator;
    public int secondOperand;

    public int result;

    public CalculateHelper(){
        this.random = new Random();

    }

    public void setCalculate()
    {
        firstOperand = random.nextInt(1,10);
        secondOperand = random.nextInt(1,10);
        operator = GetRandomOperator();

        switch (operator) {
            case DIVISION:
                int temp = firstOperand * secondOperand;
                firstOperand = temp;
                result = firstOperand / secondOperand;
                break;
            case ADDITION:
                result = firstOperand + secondOperand;
                break;
            case SUBTRACTION:
                result = firstOperand - secondOperand;
                break;
            case MULTIPLICATION:
                result = firstOperand * secondOperand;
        }
    }

    public OperatorEnum GetRandomOperator(){
        return OperatorEnum.values()[random.nextInt(0,4)];
    }

    public String getOperatorString()
    {
        switch (operator)
        {
            case MULTIPLICATION:
                return "*";
            case SUBTRACTION:
                return "-";
            case ADDITION:
                return "+";
            case DIVISION:
                return "/";
        }
        return "";
    }

    @Override
    public String toString(){
        return Integer.toString(firstOperand) + " " + getOperatorString() + " " + Integer.toString(secondOperand);
    }


}
