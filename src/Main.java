/*
Функция сортирующая массив элементов A:
        Sort(A,p,r)
        1 if p < r
2    then           q := round_half_down((p+r)/2)
        3                       Sort(A,p,q)
        4                       Sort(A,q+1,r)
        5                       Merge(A,p,q,r)

        Пример массива:
        A = (5,2,4,6,1,3,2,6)

        Примера запуска:
        Sort(A,1,length[A])
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {58, 1543, 48, 45, 75, 0, -55, 505, 333, 4846};
        System.out.print("Incoming array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        array = sort(array);
        System.out.print("Resulting array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static int[] sort(int[] array) {
        if (array.length == 1)
            return array;
        else {
            int half = (int) Math.floor(array.length >> 1);
            int[] halfFirst = new int[half];
            int[] halfSecond = new int[array.length - half];
            for (int i = 0; i < array.length; i++) {
                if (i < half)
                    halfFirst[i] = array[i];
                else
                    halfSecond[i - half] = array[i];
            }
            halfFirst = sort(halfFirst);
            halfSecond = sort(halfSecond);
            array = sortNext(halfFirst, halfSecond);
            return array;
        }
    }

    public static int[] sortNext(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];
        int a = 0, b = 0;
        for (int i = 0; i < firstArray.length + secondArray.length; i++) {
            if (a == firstArray.length) {
                resultArray[i] = secondArray[b];
                b++;
            } else if (b == secondArray.length) {
                resultArray[i] = firstArray[a];
                a++;
            } else if (firstArray[a] > secondArray[b]) {
                resultArray[i] = secondArray[b];
                b++;
            } else {
                resultArray[i] = firstArray[a];
                a++;
            }
        }
        return resultArray;
    }
}