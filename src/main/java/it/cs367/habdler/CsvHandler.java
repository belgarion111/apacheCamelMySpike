package it.cs367.habdler;

import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
public class CsvHandler {

    public void doHandleCsvData(List<List<String>> csvData)
    {
       log.info("this is the data");
       csvData.forEach(e->e.forEach(System.out::println));
    }

}
