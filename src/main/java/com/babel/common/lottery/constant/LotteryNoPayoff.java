package com.babel.common.lottery.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Owner on 2018/1/5.
 */
public class LotteryNoPayoff {
    public static List<Long> PLAYS_SIX = Arrays.asList(1151190l, 1111190l, 1111290l, 1111390l, 1111490l, 1141190l,1141290l,1141390l,1141490l);
    public static List<Long> PLAYS_SSC = Arrays.asList(113l,213l,323l,324l,423l,424l,523l,524l);

    public static List<Long> getPlays(Long lotteryId){
        List<Long> list=new ArrayList<>();
        if(lotteryId==null){
            return list;
        }
        if(lotteryId==10||lotteryId==9){
            return PLAYS_SIX;
        }
        else if(lotteryId==1||lotteryId==2){
            return PLAYS_SSC;
        }
        return list;
    }
}
