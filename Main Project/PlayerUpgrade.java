class PlayerUpgrade extends Player //Achieved when the player picks up special item
{
    public int health;
    public int healthpots;
    public int dps;
    private int special; //New attack which deals more damage to enemies
    
    public PlayerUpgrade(String name)
    {
        super(name);
        health = 120;
        dps = 55;
        healthpots = 4;
        special = 80;
    }



}
