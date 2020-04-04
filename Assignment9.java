// Assignment #: 9
//         Name: Pavan Bathula
//    StudentID: 1217503742
//      Lecture: Tu-Th 1:30-2:45
//  Description: Assignment 9 is a program which reads in a sequence of integers from standard input
//               until 0 is entered. The class consists of four recursive methods: findMin,countOdd
//               computeLargestEven and sumOfNumbersLargerThanFirst. findMin returns the smallest integer
//               in the array. countOdd returns the number of odd numbers in the array. computeLargestEven
//               returns the largest even number in the array. sumOfNumbersLargerThanFirst returns the sum
//               of all integers except the first integer of the array.

import java.io.*;
import java.lang.Math;
//import java libraries
public class Assignment9 {

    public static void main(String[] args) throws IOException {
        int num = 0;
        //initializing num variable
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(input);
        //BufferedReader to take input
        int[] values = new int[100];
        //array that can store 100 values

        do {
            values[num] = Integer.parseInt(read.readLine());
            num = num + 1;
        } while (values[num - 1] != 0);
        //do while loop to store values in array
            int minimum = findMin(values, 0, num);
            //finds the minimum value using recursive method

            int sum = sumOfNumbersLargerThanFirst(values, 0,num, values[0]);
            //finds the sum of numbers larger than first and returns the value

            int countOdd = countOddNumbers(values, 0, num);
            //finds the number of odd numbers in array and returns value

            int largestEven = computeLargestEven(values, 0, num);
            //finds and returns the largest even value

            System.out.println("The minimum number is " + minimum);
            System.out.println("The count of odd integers in the sequence is " + countOdd);
            System.out.println("The largest even integer in the sequence is " + largestEven);
            System.out.println("The sum of numbers larger than the first is " + sum);
            //Output Statements
        }





    public static int findMin(int[] numbers, int startIndex, int endIndex) {
        if (startIndex == endIndex)
        //This checks if there is only one element in array
        {
            return numbers[startIndex];
            //returns the element
        } else if (findMin(numbers, startIndex, endIndex - 1) < numbers[endIndex])
        //finds minimum if there is more than one element in array
        {
            return findMin(numbers, startIndex, endIndex - 1);
            //returns minimum value from values specified
        } else {
            return numbers[endIndex];
        }
    }

    public static int countOddNumbers(int[] elements, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            return Math.abs(elements[startIndex] % 2) + countOddNumbers(elements, startIndex + 1, endIndex);
        }
        return 0;
    }





    public static int computeLargestEven(int[] elements,int startIndex,int endIndex){
        if(startIndex == endIndex)
        //
        {
           if(elements[startIndex]%2==0)
           //checks the array for even numbers
           {
               return elements[startIndex];
           }else{
               return 0;
           }
        }else if(elements[startIndex]>computeLargestEven(elements,startIndex+1,endIndex)){
            if(elements[startIndex]%2==0){
                return elements[startIndex];
            }else{
                return computeLargestEven(elements,startIndex+1,endIndex);
            }
        }else{
            return computeLargestEven(elements,startIndex+1,endIndex);
        }
    }

    public static int sumOfNumbersLargerThanFirst(int[] elements,int startIndex, int endIndex, int firstNumber){
            if(startIndex == endIndex){
                return elements[startIndex];
            }else {
                if(elements[startIndex] > firstNumber){
                    return sumOfNumbersLargerThanFirst(elements, startIndex+1, endIndex,firstNumber)+elements[startIndex];
                }else{
                    return sumOfNumbersLargerThanFirst(elements, startIndex+1, endIndex,firstNumber);
                }
            }
        }



}
