package com.company;

import apple.laf.JRSUIUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("population.txt"), "Windows-1251"));
        HashMap<String, String> millionMap = new HashMap<>();
        String s;
        while ((s = br1.readLine()) != null) {
            String[] sArr = s.split("\t");
            if(Integer.parseInt(sArr[1]) >= 1000000){
                millionMap.put(sArr[0],sArr[1]);
            }
        }
        br1.close();

      /*  for (Map.Entry<String,String> entry: millionMap.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
*/

        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("exclude.txt"),"Windows-1251"));
        while ((s = br2.readLine()) != null) {
            if(millionMap.containsKey(s)) millionMap.remove(s);
        }
        br2.close();

        BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream("work.txt"),"Windows-1251"));
        ArrayList<String> resultList = new ArrayList<>(millionMap.size());
        while ((s = br3.readLine()) != null) {
            if(millionMap.containsKey(s)){
                resultList.add(s);
            }
        }
        br3.close();

        resultList.trimToSize();
        Collections.sort(resultList);

        for(String elements: resultList){
            System.out.println(elements + " - " + millionMap.get(elements));
        }
    }
}
