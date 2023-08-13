package com.hyomee.core.utils;

import com.fasterxml.uuid.Generators;

public class UuidUtils {

  public static String getUUID() {
    String uuid = String.valueOf(Generators.timeBasedEpochGenerator().generate());
    return uuid.replaceAll("-", "");
  }
}
