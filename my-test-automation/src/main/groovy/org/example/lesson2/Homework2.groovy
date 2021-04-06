package org.example.lesson2

class Homework2 {

    static void main(args) {

        Homework2 homework2 = new Homework2()

        // Task 1
        /*Should I go to school?
        You need to create a class with a method to help you decide whether to go to school.

        if the temperature is < -25 ℃, we don't go to school at all
        if the temperature is -25 ..- 20 ℃, you can go if the path is < 1 km*/

        println("Task 1:")

        boolean flag = homework2.shouldIGotoSchool(-20, 0.9)

        if (flag) {
            println("Sorry, you need to go to school :(")
        } else {
            println("Congrats! You are free from school :)")
        }

        println()

        //--------------------------------------------------------------------------

        // Task 2
        /*Currency Converter

        currencies BYN, USD, EUR

        currency rates can be hardcoded

        Create CurrencyConverter class with method.
                double convert (String from, String to, double value)*/

        println("Task 2:")

        String a = "usd".toUpperCase()
        String b = "byn".toUpperCase()
        double value = 100.30

        double convertedValue = homework2.convert(a, b, value)

        println("$value $a is ${convertedValue.round(2)} $b")

        println()

        //---------------------------------------------------------------------------

        // Task 3
        /*Lorem ipsum

        - Find the total word count.
        - Find the letter that occurs most often in the text, count how many times it occurs.
        - Find the number of sentences in the text.
        - Find the average number of words in a sentence.*/

        println("Task 3:")

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        homework2.loremIpsum(loremIpsum.toLowerCase())

    }

    boolean shouldIGotoSchool(double temperature, double distanceToSchool) {

        if ((temperature > -20) || (((-25 <= temperature) && (temperature <= -20)) && (distanceToSchool < 1))) {
            return true
        } else {
            return false
        }

    }

    double convert(String from, String to, double value) {

        double eurBynRate = 3.13
        double eurUsdRate = 1.22
        double usdBynRate = 2.57

        String fromTo = from + to

        switch (fromTo) {

            case "EURBYN":
                return (value * eurBynRate);
                break;
            case "EURUSD":
                return (value * eurUsdRate);
                break;
            case "BYNUSD":
                return (value / usdBynRate);
                break;
            case "BYNEUR":
                return (value / eurBynRate);
                break;
            case "USDBYN":
                return (value * usdBynRate);
                break;
            case "USDEUR":
                return (value / eurUsdRate);
                break;
        }

    }

    void loremIpsum(String s) {

        // word count

        int wordCount = s.split(' ').length

        // most often letter

        char mostOftenLetter
        int mainCounter = 0

        for (i in s) {

            int counter = 0
            char letter = i

            if ("abcdefghijklmnopqrstuvwxyz".contains(i)) {
                for (j in s) {

                    if (letter == j) {
                        counter++

                    }
                }
                if (counter > mainCounter) {
                    mainCounter = counter
                    mostOftenLetter = letter
                }
            }
        }

        // Sentence counter

        int sentenceCounter = s.replace('!', '.').replace('?', '.').split('\\.').length

        // Average number of words

        int numberOfSentences = s.replace('!', '.').replace('?', '.').split('\\.').length
        int averageWordCountInSentences = 0

        for (i in s.replace('!', '.').replace('?', '.').split('\\.')) {

            averageWordCountInSentences += i.split(' ').length
        }

        averageWordCountInSentences = averageWordCountInSentences / numberOfSentences

        println("""The total word count: $wordCount 
The letter that occurs most often in the text is '$mostOftenLetter', it occurs $mainCounter time(s).
The number of sentences in the text: $sentenceCounter
The average number of words in a sentence: $averageWordCountInSentences""")

    }
}
