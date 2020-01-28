import java.util.*;

class Enemy
{
    Random rand = new Random();
    int enemyHealth;
    int maxHealth;
    int dps;
    private int maxAttackDamage;
    private int damageDealt;
    String[] enemyName = {"Ulgar","Vak","Reff","Vii", "Baggy","Dooba","Tiko","Nak","Luum-Sa","Shak","Korl", "Dagga", "Booo"};
    
    public Enemy(int maxHealth, int dps)
    {
        maxHealth = 75;
        enemyHealth = rand.nextInt(maxHealth); //Enemy health is a random integer from 0 - 75
        dps = 25;
        
    
    }
    
    public String enemyName()
    {
        String name = enemyName[rand.nextInt(enemyName.length)] + " the Enemy";
        return name;
    }
    
    public int getEnemyDamage()
    {
        return damageDealt;
    }
    
    public void setEnemyHP(int enemyHP)
    {
        enemyHealth = enemyHP;
    }
    
    public int getEnemyHP()
    {
        return enemyHealth;
    }

}