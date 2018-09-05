package gameplay;

public class GamePlay {

    public double chance(double payout){ //payout is the player's bet
        int chance = 0;
        chance = (int)(Math.random()*30)+1;
        if (chance>=1 && chance<=3){ //small jackpot, larger payout
            return payout * 1.5;
        }
        else if ((chance>3) && (chance<=8)){ //smaller chance, moderate payout
            return payout * 1.2;
        }
        else if (chance>8 && chance<15){ //larger chance, small payout
            return payout * 1.1;
        }
        else if (chance>=15 && chance<=20){ //larger chance, small payout
            return payout * 1.1;
        }
        else if (chance>20 && chance<29){ //no extra payout, largest chance
            return payout;
        }
        else if (chance>=29 && chance<=30){ //very small chance, much larger payout
            return payout * 2.5;
        }
        else { //shouldn't be needed but just in case
            return payout;
        }
    }
}
