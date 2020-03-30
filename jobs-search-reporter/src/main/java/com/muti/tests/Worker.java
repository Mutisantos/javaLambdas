package com.muti.tests;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Worker {
   private final List<String> skills;
   private final String Id;
}