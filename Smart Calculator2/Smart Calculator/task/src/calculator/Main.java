package calculator;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Scanner scanner;
    static Map<String, BigInteger> hashMap = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean work = true;
        while (work) {
            scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input) {
                case "":
                    break;
                case "/postfix":
                    String infix = scanner.nextLine();
                    infixToPostfix(infix);
                    break;
                case "/refine":
                    String refine = scanner.nextLine();
                    refineOperators(refine);

                case "/exit":
                    System.out.println("Bye!");
                    work = false;
                    break;
                case "/map":
                    System.out.println(hashMap);
                    break;
                case "/help":
                    System.out.println("The program calculates the sum of numbers");
                    break;
                default:

                    Pattern pattern = Pattern.compile("=");
                    Matcher matcher = pattern.matcher(input);
                    int count = 0;
                    while (matcher.find()) count++;
                    if ((input.matches("\\d*[^A-Za-z]+[0-9]+$")
                            || input.matches("[0-9A-Za-z\\s\\-+]+"))
                            && input.contains("+") || input.contains("-")
                            || input.contains("/") || input.contains("*")) {
                      //  calculate(input);
                        infixToPostfix(input);

                    } else if (input.matches("[A-Za-z\\s]+=[\\d\\s]+") || input.matches("[A-Za-z\\s]+=[A-Za-z\\s]+")) {

                        assignVariable(input);

                    } else {
                        if (input.matches("[0-9].*\\+")
                                || input.matches("[0-9].*-")
                                || input.matches("[0-9\\s]+")) {
                            System.out.println("Invalid expression");
                        } else if (input.matches("^/.*")) {
                            System.out.println("Unknown command");
                        } else {
                            if (hashMap.containsKey(input)) {
                                System.out.println(hashMap.get(input));
                            } else {
                                if (input.matches("[A-Za-z0-9\\s]+=[\\d\\s]+")) {
                                    System.out.println("Invalid identifier");
                                } else if (input.matches("[A-Za-z0-9\\s]+=[A-Za-z0-9\\s]+") || count >= 2){
                                    System.out.println("Invalid assignment");
                                } else {
                                    System.out.println("Invalid expression");
                                }



                            }

                        }

                    }
            }
        }

    }

    private static void assignVariable(String input) {

        if (input.matches("[A-Za-z\\s]+=[\\d\\s]+")) {

            String refineInput = input.replaceAll(" ", "");

            String[] inputArray = refineInput.split("=");

            hashMap.put(inputArray[0], new BigInteger(inputArray[1]));

        } else {

            String refineInput = input.replaceAll(" ", "");

            String[] inputArray = refineInput.split("=");

            if (hashMap.containsKey(inputArray[1])) {
                hashMap.put(inputArray[0], hashMap.get(inputArray[1]));
            } else {
                System.out.println("Unknown variable");
            }


        }




    }

    private static void infixToPostfix(String input) {

        if (input.matches("/[a-zA-Z]+")) {
            System.out.println("Unknown command");
            return;
        }
        input = refineOperators(input);
       // System.out.println(input);
    //    input = input.replaceAll(" ", "");

  /*      Infix notation 1:

        3 + 2 * 4

        Postfix notation 1:

        3 2 4 * +     */


      /*  Add operands (numbers and variables) to the result (postfix notation) as they arrive.
                If the stack is empty or contains a left parenthesis on top, push the incoming operator on the stack.
        If the incoming operator has higher precedence than the top of the stack, push it on the stack.
        If the incoming operator has lower or equal precedence than or to the top of the stack,
        pop the stack and add operators to the result until you see an operator that has a smaller precedence
        or a left parenthesis on the top of the stack; then add the incoming operator to the stack.
        If the incoming element is a left parenthesis, push it on the stack.
        If the incoming element is a right parenthesis, pop the stack and add operators to the result until you see a
         left parenthesis. Discard the pair of parentheses.
                At the end of the expression, pop the stack and add all operators to the result.*/
                StringBuilder postfix = new StringBuilder();
                int precendence = 0;
                Deque<Character> stack = new ArrayDeque<>();
                char[] inputCharArray = input.toCharArray();
                char currentChar = 'a';
                boolean flagNextDigit = true;

                for (int i = 0; i < inputCharArray.length; i++) {

                    if (inputCharArray[i] == '*' || inputCharArray[i] == '/') {
                        precendence = 2;
                       // currentChar = inputCharArray[i];
                        flagNextDigit = false;
                    } else if (inputCharArray[i] == '+' || inputCharArray[i] == '-') {
                        precendence = 1;
                        flagNextDigit = false;
                     //   currentChar = inputCharArray[i];
                    } else if (inputCharArray[i] == ')' || inputCharArray[i] == '(') {
                        //  currentChar = inputCharArray[i];
                        flagNextDigit = false;
                    }

                    if (inputCharArray[i] == '*' || inputCharArray[i] == '/' || inputCharArray[i] == '+'
                    || inputCharArray[i] == '-') {
                        if (stack.isEmpty() || stack.peekLast() == '(') {
                            stack.addLast(inputCharArray[i]);

                        } else if ((stack.peekLast() == '+' || stack.peekLast() == '-') &&
                        precendence == 2) {
                            stack.addLast(inputCharArray[i]);
                          //  flagNextDigit = true;
                        } else if ((stack.peekLast() == '*' || stack.peekLast() == '/') &&
                                (precendence == 2 || precendence == 1) ) {
                            while (!stack.isEmpty() && (stack.peekLast() != '(' && stack.peekLast() != '-'
                                    || stack.peekLast() == '+')) {
                                postfix.append(" ").append(stack.pollLast());
                            }
                            stack.addLast(inputCharArray[i]);

                        } else if ((stack.peekLast() == '-' || stack.peekLast() == '+') &&
                                precendence == 1) {
                            postfix.append(" ").append(stack.pollLast());
                            stack.addLast(inputCharArray[i]);
                        } else  {
                                postfix.append(" ").append(inputCharArray[i]);
                                // flagNextDigit = true;
                            }


                    } else if (inputCharArray[i] == '(') {
                        stack.addLast(inputCharArray[i]);

                    } else if (inputCharArray[i] == ')') {
                        while (!stack.isEmpty() && stack.peekLast() != '(') {
                            postfix.append(" ").append(stack.pollLast());
                        }
                        stack.pollLast();
                        flagNextDigit = true;
                    } else {
                        if (flagNextDigit) {
                            postfix.append(inputCharArray[i]);
                        } else {
                            postfix.append(" ").append(inputCharArray[i]);
                            flagNextDigit = true;
                        }

                    }

                }
                int initStackSize = stack.size();
                for (int b = 0; b < initStackSize; b++) {
                    postfix.append(' ').append(stack.pollLast());
                }
            //    System.out.println(postfix.toString());

        calculateResult(postfix.toString().trim());
         //  System.out.println(postfix.toString());

    }

    private static void calculateResult(String input) {

      /*  When we have an expression in postfix notation, we can calculate it using another stack.
      To do that, scan the postfix expression from left to right:

        If the incoming element is a number, push it into the stack (the whole number, not a single digit!).
        If the incoming element is the name of a variable, push its value into the stack.

     If the incoming element is an operator, then pop twice to get two numbers and perform the operation;
                push the result on the stack.

        When the expression ends, the number on the top of the stack is a final result.*/
         //   System.out.println(input);
            Deque<String> stack = new ArrayDeque<>();
            String[] inputArray = input.split(" ");

            for (String s : inputArray) {

                if (s.matches("\\d+")) {
                    stack.addLast(s);
                } else if (s.matches("[a-zA-Z]+")) {
                    if (hashMap.containsKey(s)) {
                        stack.addLast(String.valueOf(hashMap.get(s)));
                    } else {
                        System.out.println("Unknown variable");
                        return;
                    }

                } else {
                    BigInteger val1 = BigInteger.ZERO;
                    BigInteger val2 = BigInteger.ZERO;
                    if (!stack.isEmpty()) {
                        val1 = new BigInteger(stack.pollLast());
                    }
                    if (!stack.isEmpty()) {
                        val2 = new BigInteger(stack.pollLast());
                    }

                        String toCalc = val2 + " " + s + " " + val1;
                       BigInteger semiResult = calculate(toCalc);
                       stack.addLast(String.valueOf(semiResult));

                    }

                }
            if (!stack.peekLast().equals("0")) {
                System.out.println(stack.peekLast());
            }


            }

    private static String refineOperators(String s) {
        s = s.replaceAll(" ", "");

        char[] arrayChars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        char current = 'a';
        int minusCount = 0;
        for (int i = 0; i < arrayChars.length; i++) {
            switch (arrayChars[i]) {

                case '+':
                    if (current == '+') {
                        continue;
                    }
                    current = '+';
                    sb.append(arrayChars[i]);
                    break;
                case '-':
                    minusCount++;
                    if (current == '-' || arrayChars[i+1] != '-') {
                        if (minusCount != 0 && minusCount % 2 == 0 && arrayChars[i+1] != '-') {
                            sb.append("+");
                        } else if (arrayChars[i+1] != '-') {
                            sb.append("-");
                        }

                    }

                    current = '-';
                    break;
                case '*':
                    if (current == '*') {
                        System.out.println("Invalid expression");
                        return "0";
                    }
                    current = '*';
                    sb.append('*');
                    break;
                case '/':
                    if (current == '/') {
                        System.out.println("Invalid expression");
                        break;
                    }
                    current = '/';
                    sb.append('/');
                    break;
                default:
                    sb.append(arrayChars[i]);
                    minusCount = 0;
            }

        }
        return sb.toString();
    }


    private static BigInteger calculate(String input) {
        String[] array = input.split(" ");
        Queue<String> queue = new LinkedList<>();
        if ((input.contains("(") && !input.contains(")"))
                || (input.contains(")") && !input.contains("(")))  {
            System.out.println("Invalid expression");
            return BigInteger.ZERO;
        }
        ArrayList<BigInteger> BigIntegers = new ArrayList<>();
        ArrayList<String> intsAndVars = new ArrayList<>();
        String regexInt = "-?\\+?\\d+";
        String regexPlus = "\\++";
        String regexVar = "[A-Za-z0-9]+";

        for (String s : array) {
            if (s.matches(regexInt) || s.matches(regexVar)) {
                intsAndVars.add(s);
            } else {
                if (s.matches(regexPlus)) {
                    queue.add("+");
                } else if (s.contains("-")) {
                    char[] minusArr = s.toCharArray();

                    int count = 0;
                    for (char c : minusArr) {
                        count++;
                    }
                    if (count % 2 == 0) {
                        queue.offer("+");
                    } else {
                        queue.offer("-");
                    }
                } else if (s.contains("*")) {
                    char[] multipleArr = s.toCharArray();

                    int count = 0;
                    for (char c : multipleArr) {
                        count++;
                    }
                    if (count == 1) {
                        queue.offer("*");
                    } else {
                        System.out.println("Invalid expression");
                    }
                } else if (s.contains("/")) {
                    char[] divArr = s.toCharArray();

                    int count = 0;
                    for (char c : divArr) {
                        count++;
                    }
                    if (count == 1) {
                        queue.offer("/");
                    } else {
                        System.out.println("Invalid expression");
                    }
                }
            }
        }
        for (String s : intsAndVars) {

            if (s.matches("-?\\d+")) {
                BigIntegers.add(new BigInteger(s));
            } else if (s.matches("[a-zA-Z]+")) {
                BigIntegers.add(new BigInteger(String.valueOf(hashMap.get(s))));
            }

        }

    //    System.out.println(integers);
      //  System.out.println(queue);
     BigInteger result = BigIntegers.get(0);
        for (int i = 0; i < BigIntegers.size() - 1; i++) {

            if (queue.peek().equals("+")) {
                queue.poll();
                result = result.add(BigIntegers.get(i + 1));
            } else if (queue.peek().equals("-")) {
                queue.poll();
                result = result.subtract(BigIntegers.get(i + 1));
            } else if (queue.peek().equals("*")) {
                queue.poll();
                result = result.multiply(BigIntegers.get(i + 1));
            } else if (queue.peek().equals("/")) {
                queue.poll();
                result =  result.divide(BigIntegers.get(i + 1));
            }
            // System.out.println(queue);


        }
       // System.out.println(result);
        return result;
    }
}
