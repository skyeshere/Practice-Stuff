using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;

class Program
{
    int[] array; //array to be used for parsing
    Dictionary<int, int> hash = [];

    public Program()
    {
        Random rnd = new();
        int random_number = rnd.Next(100000000, 1000000000); //create a random 5 digit long number
        Console.WriteLine("The number generated is: " + random_number);

        this.array = random_number.ToString().Select(t=>int.Parse(t.ToString())).ToArray(); //convert random number into an integer array of all digits
        this.hash = CountDigits();

        PrintResults();

    }

    public void PrintResults()
    {
        Console.WriteLine("Digits were counted as follows: ");
        foreach(KeyValuePair<int,int> element in hash)
        {
            Console.WriteLine("Digit: {0} \t Count: {1}", element.Key, element.Value);
        }
    }

    public Dictionary<int, int> CountDigits()
    {
        Dictionary<int, int> counting_hash = [];

        foreach(int digit in array)
        {
            if (counting_hash.ContainsKey(digit)) //if digit is already being counted
            {
                //add to the count (value)
                counting_hash[digit]++;
            }
            else // if digit is not being counted, add it to the hashtable
            {                  //(key  , value)
                counting_hash.Add(digit, 1);
            }
        }

        return counting_hash;
    }


    static void Main()
    {
        new Program(); //get out of static typing because it fucking SUCKS
    }
}