package com.muti.tests;

import java.util.function.Function;

public class ComposedLambda {

   

   public static void main(final String[] args) {
      final Function<Integer, Integer> multiply2 = x -> x * 2;
      final Function<Integer, Integer> power2 = x -> x * x;
      System.out.println(multiply2.compose(power2).apply(4));
      System.out.println(multiply2.andThen(power2).apply(4));

   }

}
