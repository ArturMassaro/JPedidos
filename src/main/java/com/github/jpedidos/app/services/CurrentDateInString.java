package com.github.jpedidos.app.services;

import java.text.SimpleDateFormat;
import java.util.Date; 

public class CurrentDateInString {
  public static String execute(){
    String date = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date());

    return date;
  }
}