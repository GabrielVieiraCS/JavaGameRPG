class Orc extends Enemy
{
     private int maxAttackDamage;
    private int damageDealt;
    String[] enemyName = {"Ulg","Drax","Rofi","Keka", "Zur","Fa","Mog","Dok","San","Bigu","OOfa"};
    
    public Orc(int maxHealth, int dps)
    {
        super(maxHealth, dps);
        maxHealth = 60;
        enemyHealth = rand.nextInt(maxHealth); //Enemy health is a random integer from 0 - 75
        dps = 20; 
        maxAttackDamage = 15;
        damageDealt = rand.nextInt(maxAttackDamage);
    }
    
    public String enemyName()
    {
        String name = enemyName[rand.nextInt(enemyName.length)] + " the ORC";
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