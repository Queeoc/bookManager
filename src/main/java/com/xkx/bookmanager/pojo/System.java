package com.xkx.bookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class System {
    private int everydayFine;
    private int bookLimit;
    private int timeLimit;
}
