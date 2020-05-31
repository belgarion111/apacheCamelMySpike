package it.cs367.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Dalton {

    Integer reward;
    String name , action;
    public void creatDalton(String newDalton) {
        String[] csvOutput = newDalton.split(",");
        name = csvOutput[0];
        action = csvOutput[2];
        reward = Integer.parseInt(csvOutput[1].trim());

    }

}
