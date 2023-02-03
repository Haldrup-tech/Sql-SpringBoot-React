package com.example.accessingdatamysql;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvReader {
  public List<String[]> readFile(String filename) throws IOException, CsvException {
    try (CSVReader reader = new CSVReader(new FileReader(filename))) {
      List<String[]> r = reader.readAll();
      r.remove(0);
      return r;
    }
  }
}
