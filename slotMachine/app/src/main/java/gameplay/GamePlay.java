package gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamePlay {

    private float lastPayout = 0;

    public ArrayList<SlotIcons> roll(){ //payout is the player's bet
        ArrayList<SlotIcons> slotIcons = new ArrayList<>();
        for (int i=0;i<3;i++){
            int chance = 0;
            chance = (int)(Math.random()*30)+1;

            if (chance>=1 && chance<=3){ //small jackpot, larger payout
                slotIcons.add(SlotIcons.Cherry);
            }
            else if ((chance>3) && (chance<=8)){ //smaller chance, moderate payout
                slotIcons.add(SlotIcons.Bell);
            }
            else if (chance>8 && chance<15){ //larger chance, small payout
                slotIcons.add(SlotIcons.Grape);
            }
            else if (chance>=15 && chance<=20){ //larger chance, small payout
                slotIcons.add(SlotIcons.Bar);
            }
            else if (chance>20 && chance<29){ //no extra payout, largest chance
                slotIcons.add(SlotIcons.Orange);
            }
            else if (chance>=29 && chance<=30){ //very small chance, much larger payout
                slotIcons.add(SlotIcons.Seven);
            }
        }
        calculatePayout(slotIcons);
        return slotIcons;

    }

    private void calculatePayout(ArrayList<SlotIcons> results){
        float score = 0;
        for(int i = 0; i < 3; i++){
            score += SlotIcons.iconToPayout(results.get(i));
        }
        Map<SlotIcons, Integer> duplicates = new HashMap<>();
        for(SlotIcons s : results){
            int currentValue = 0;
            if(duplicates.containsKey(s)){
                currentValue += 1;
            }
            currentValue ++;
            duplicates.put(s, currentValue);
        }
        boolean addedMultiplier = false;
        for(SlotIcons s : duplicates.keySet()){
            if(duplicates.get(s) == 2){
                score *= 1;
                addedMultiplier = true;
            }
            else if(duplicates.get(s) == 3){
                score *= 5;
                addedMultiplier = true;
            }
        }
        if(!addedMultiplier){
            score *= 0;
        }

        score *= 100;
        score = Math.round(score);
        score /= 100;
        lastPayout = score;
    }

    public float getLastPayout() {
        return lastPayout;
    }
}
