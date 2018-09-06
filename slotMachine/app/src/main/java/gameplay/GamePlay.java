package gameplay;

import java.util.ArrayList;

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
        lastPayout = 0;
    }

    public float getLastPayout() {
        return lastPayout;
    }
}
