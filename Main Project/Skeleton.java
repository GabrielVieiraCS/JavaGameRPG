class Skeleton extends Enemy
{
     private int maxAttackDamage;
    private int damageDealt;
    String[] enemyName = {"Skellington","Shivers","Ligament","Johhny-Joints", "Sinovial","Spino","Crunch","Skelly","Clicks","Marrow","White"};
    
    public Skeleton(int maxHealth,  int dps)
    {
        super(maxHealth, dps); // TO-DO
        maxHealth = 45;
        enemyHealth = rand.nextInt(maxHealth); //Enemy health is a random integer from 0 - 75
        dps = 20;
        maxAttackDamage = 15;
        damageDealt = rand.nextInt(maxAttackDamage);
    }
    
    public String enemyName()
    {
        String name = enemyName[rand.nextInt(enemyName.length)] + " the SKELETON";
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