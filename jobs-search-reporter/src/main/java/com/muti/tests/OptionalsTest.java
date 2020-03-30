package com.muti.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalsTest {

   public static List<String> getNamesList() {
      final List<String> list = new ArrayList<>();
      return list;
   }

   public static String mvpName() {
      return null;
   }

   public static Optional<String> mvpOptionalName(final String name) {
      return Optional.ofNullable(name);
   }

   public static void main(final String[] args) {
      final String names[] = { "AAA", null, "Bbee", null };
      Stream.of(names).forEach(name -> System.out.println(mvpOptionalName(name).orElse("El valor es nulo")));
   }

}
