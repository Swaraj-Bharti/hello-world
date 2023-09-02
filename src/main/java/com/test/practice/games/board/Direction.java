package com.test.practice.games.board;

import lombok.Getter;

@Getter
public enum Direction {

    UP(0,4),
    UP_RIGHT(1,5),
    RIGHT(2,6),
    DOWN_RIGHT(3,7),
    DOWN(4,0),
    DOWN_LEFT(5,1),
    LEFT(6,2),
    UP_LEFT(7,3);

    private final int index;
    private final int reverseIndex;

    Direction(int index, int reverseIndex) {
        this.index = index;
        this.reverseIndex = reverseIndex;
    }

    public Direction getReverseDirection(){
            int reverseIndex = this.getReverseIndex();
            for(Direction d : values()){
                if(d.getIndex() == reverseIndex){
                    return d;
                }
            }
        return null;
    }
}
