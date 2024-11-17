package tasks.task_4;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("task 1:");

        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));


        System.out.println("\ntask 2:");

        System.out.println(bruteForce(2,2));


        System.out.println("\ntask 3:");

        System.out.println();


        System.out.println("\ntask 4:");

        System.out.println();


        System.out.println("\ntask 5:");

        System.out.println();


        System.out.println("\ntask 6:");

        System.out.println();


        System.out.println("\ntask 7:");

        System.out.println();


        System.out.println("\ntask 8:");

        System.out.println();


        System.out.println("\ntask 9:");

        System.out.println();


        System.out.println("\ntask 10:");

        System.out.println();
    }

    public static String nonRepeat(String str) {
        String[] arr = str.split("");
        Arrays.sort(arr);
        String s = "";
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i].equals(arr[i + 1])) {
                count++;
                if (count > 3) {
                    s = str.replaceAll(arr[i], "");
                }
            }else{
                count = 1;
            }
        }
        return s;
    }

    public static List<String> bruteForce(int n, int k) {
        List<String> results = new ArrayList<>();
        if (k > 5 || n > k) {
            return results;
        }
        char[] alphabet = new char[k];
        for (int i = 0; i < k; i++) {
            alphabet[i] = (char) ('0' + i);
        }
        List<String> permutations = new ArrayList<>();
        permutations.add("");
        while (!permutations.isEmpty()) {
            String current = permutations.remove(0);
            if (current.length() == n) {
                results.add(current);
                continue;
            }
            for (int i = 0; i < alphabet.length; i++) {
                if (current.indexOf(alphabet[i]) == -1) {
                     permutations.add(current + alphabet[i]);
                }
            }
        }
        return results;
    }
}

/*

2.	Напишите функцию, которая генерирует все возможные комбинации для слов длины n состоящих из алфавита размером k <= 5. Буквы в слове не должны повторяться.
Пример:
bruteForce(1,5) ➞ ["0","1","2","3","4"]

bruteForce(2,2) ➞ ["01", "10"]

bruteForce(5,3) ➞ []

3.	Реализуйте функции Decode и Encode реализующий алгоритм шифрования Вернама. Decode принимает строку и ключ, возвращает массив чисел. Encode получает массив чисел и ключ, возвращает слово.
Пример:
encode([0, 31, 28, 10, 29], “MKIIT”) ➞ “MTUCI”

decode("MTUCI","MKIIT") ➞ [0, 31, 28, 10, 29]

4.	Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован.
Пример:
split("()()()") ➞ ["()", "()", "()"]
split("((()))") ➞ ["((()))"]
split("((()))(())()()(()())") ➞ ["((()))", "(())", "()", "()",
"(()())"]
split("((())())(()(()()))") ➞ ["((())())", "(()(()()))"]

5.	Напишите функцию, которая преобразует строку в звездную стенографию. Если символ повторяется n раз, преобразуйте его в символ*n..
Пример:
shortHand("abbccc") ➞ "ab*2c*3"

shortHand("vvvvaajaaaaa") ➞ "v*4a*2ja*5"


6.	Напишите функцию, принимающую положительное целое число, не превышающее 1502, и возвращающую его представление в римской системе счисления.
Пример:
convertToRome(8) ➞ "VIII"

convertToRome(1234) ➞ "MCCXXXIV"

convertToRome(52) ➞ "LII"

7.	Напишите функцию, принимающую строку цифр, подсчитывающую количество повторяющихся элементов. И возвращающую “чет” – если самое большое количество повторений на четном индексе и “нечет” – если на нечетном.
Если количество одинаковое, то возвращается первое вхождение.
Пример:
uniqueSubstring("31312131") ➞ "нечет"

uniqueSubstring("1111111") ➞ "чет"

uniqueSubstring("12223234333") ➞ "чет"


8.	Напишите функцию прохождения матричного лабиринта, с минимальным количеством затрат. На вход подается матрица n x n, в которой находятся отрицательные и положительные числа. Отрицательные числа – это стенки лабиринта, проходить через которые категорически нельзя. Положительные – стоимость вхождения в эту ячейку. Вход лабиринта правое нижнее значение матрицы, выход – левая верхняя. Вход и Выход не могут иметь отрицательное значение.
Передвигаться можно только вверх или влево.
Функция должна возвращать:
А) Если путь существует, то сам путь, а также стоимость затрат.
Б) Если пути нет, то сообщение: “Прохода нет”
Пример:
labirint(
[[1, 3, 1],
 [1, -1, 1],
 [4, 2, 1]]) ➞ [“1-1-1-3-1”,”7”]
// 1+3+1+1+1=7

labirint(
[[2, -7, 3],
 [-4, -1, 8],
 [4, 5, 9]]) ➞ ["Прохода нет"]

9.	Создайте функцию, принимающую строку, содержащую числа внутри слов. Эти числа представляют расположение слова для новой строящейся строки.
Пример:
numericOrder("t3o the5m 1One all6 r4ule ri2ng") ➞ " One ring to rule them all"

numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat") ➞ " With great power comes great responsibility"

10.	Напишите функцию, принимающую строку на вход, и возвращает принадлежность строки к золотому сечению. Строка принадлежит золотому сечению, если количество повторяющих элементов соответствует числам Фибоначчи.
Пример:
fibString("CCCABDD") ➞ True

fibString("ABC") ➞ False

 */