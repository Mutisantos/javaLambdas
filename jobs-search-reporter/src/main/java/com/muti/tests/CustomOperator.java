package com.muti.tests;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CustomOperator {

   public static void main(final String[] args) {
      // Function<T,R> is a Java8 Interface that enables to create a function that receives a T type input and return a
      // R type output
      final Function<Double, String> formatDouble = x -> "같같같같같같같같캲esult: " + x + "같같같같같같같같�";

      //UnaryOperator is a Function<T,R> where T and R are of the same data type.
      final UnaryOperator<Double> squareRoot = Math::sqrt;
      
      // BinaryOperator is a BiFunction<T,U,R> where T, U and R are of the same data type.
      final BinaryOperator<Double> divide = (x, y) -> x / y;
      
      
      final Trifunction<Double, Double, Double, String> paramPrinter = (a, b, c) -> 
         "Param a = " + a + "\nParam b = " + b + "\nParam c = " + c;
      
      final Trifunction<Double, Double, Double, Double> raizCuadraticaPositiva = (final Double a, final Double b, final Double c) -> {
         double result = (b * b) - (4 * a * c);
         result = squareRoot.apply(result);
         result = divide.apply(result, 2 * a);
         result = b - result;
         return result;
      };
      
      // Java Compiler infers the data type of the inputs and which will be the return statement of the lambda
      final Trifunction<Double, Double, Double, Double> raizCuadraticaNegativa = (a, b, c) -> -b
            - divide.apply(squareRoot.apply(b * b - 4 * a * c), 2 * a);
      
      System.out.println(paramPrinter.apply(10.0, 2.5, -1.5));
      System.out.println(formatDouble.apply(raizCuadraticaPositiva.apply(10.0, 2.5, -1.5)));
      System.out.println(formatDouble.apply(raizCuadraticaNegativa.apply(10.0, 2.5, -1.5)));
      
   }
   
   
   //Using this annotation with an interface and adding the apply signature, custom Function definitions can be done;
   @FunctionalInterface
   public interface Trifunction<T, U, V, W> {
      W apply(T operadorTipoT, U operadorTipoU, V operadorTipoV);
   }

}
