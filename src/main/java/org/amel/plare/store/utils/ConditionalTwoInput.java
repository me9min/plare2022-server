package org.amel.plare.store.utils;

import lombok.*;

@Data
public class ConditionalTwoInput{
    private int x;
    private int y;

    public ConditionalTwoInput(int x, int y){
        this.x = x;
        this.y = y;
    }
}