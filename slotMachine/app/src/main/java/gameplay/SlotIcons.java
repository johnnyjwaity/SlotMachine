package gameplay;

public enum SlotIcons {
    Lemon,
    Orange,
    Seven,
    Bar,
    Cherry,
    Bell,
    Grape;




   public static int iconToNum(SlotIcons icon){
        switch (icon){
            case Cherry: return 0;
            case Orange: return 1;
            case Grape: return 2;
            case Bell: return 3;
            case Bar: return 4;
            case Seven: return 5;
        }
        return -1;
   }
}
