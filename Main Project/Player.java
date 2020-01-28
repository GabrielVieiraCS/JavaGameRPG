import java.util.*;

class Player
{   
    Random rand = new Random();
    String playerName;
    int hp;
    int healthpots;
    int maxAttackDamage;
    int damageDealt;
    int damageTaken;
    
    int healthPotionHealAmount;
    int healthPotionDropChance;
  
    public Player()
    {
        playerName = "";
        hp = 100;
        maxAttackDamage = 25;
        healthpots = 4;
        healthPotionHealAmount = 30;
        healthPotionDropChance = 40; // Percentage
        damageDealt = rand.nextInt(maxAttackDamage)+1;
    }
    
    public int getPlayerDamage()
    {
        return damageDealt;
    }
    
    public void setName(String name)
    {
        playerName = name;
    }
    
    public String getName()
    {
        return playerName;
    }
    
    public void healHP()
    {
        hp = hp + healthPotionHealAmount;
    }
    
    public void setHP(int enemyDamage)
    {
        hp = hp - enemyDamage;
    }
    
    public int getHP()
    {
        return hp;
    }

}