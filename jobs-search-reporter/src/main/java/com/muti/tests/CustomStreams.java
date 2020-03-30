package com.muti.tests;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomStreams {

   public static void main(final String[] args) {
      // IntStream is an obligatory class when defining a Stream of Integers
      // Using .iterate will fill the stream with items that follow the function
      final IntStream infinityStream = IntStream.iterate(0, x -> x + 1);
      // ... until a limit is defined
      // Also, the parallel method will allow the stream to operate in threads, which in this case will print the
      // elements almost randomly
      infinityStream.limit(1000).parallel().filter(x -> x % 9 == 0).forEach(System.out::println);

      // Streams can also be created adding the elements as an array
      final Stream<String> aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba",
            "allí.");
      // Reduce operation in this case applies a Binary Accumulator between the accumulated element and the next element
      // on the stream until just one element is left.
      final Optional<String> longStoryOptional = aLongStoryStream
            .reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
      longStoryOptional.ifPresent(System.out::println);

      // Not adding a limit when an iterate is created will make the execution keeps adding elements infinitely
      final Stream<Double> convergentSeriesHalfs = Stream.iterate(0.0, x -> 1 / Math.pow(2, x));
      final Optional<Double> sumOfInfinity = convergentSeriesHalfs.limit(1000).peek(System.out::println)
            .reduce((a, x) -> a + x);
      sumOfInfinity.ifPresent(System.out::println);

      final Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
      final int sumOfFirstTen = firstTenNumbersStream.reduce(90, Integer::sum);// 90 + sum(0...10)
      System.out.println(sumOfFirstTen);

      // Another type of reduction can be done with a binaryFunction and a BinaryOperator that first will map each
      // element and then will accumulate the values in a single result
      final Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía",
            "estaba", "allí.");
      final int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.length(), Integer::sum);

   }

}
