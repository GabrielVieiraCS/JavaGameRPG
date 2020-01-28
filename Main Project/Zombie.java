class Zombie extends Enemy
{
    private int maxAttackDamage;
    private int damageDealt;
    String[] enemyName = {"Ulgar","Vak","Reff","Vii", "Baggy","Dooba","Tiko","Nak","Luum-Sa","Shak","Korl"};
    
    public Zombie(int maxHealth, int dps)
    {
        super(maxHealth, dps);
        maxHealth = 50;
        int enemyHealth = rand.nextInt(maxHealth); //Enemy health is a random integer from 0 - 75
        dps = 25;
        maxAttackDamage = 15;
        damageDealt = rand.nextInt(maxAttackDamage);
    }
    
    public String enemyName()
    {
        String name = enemyName[rand.nextInt(enemyName.length)] + " the ZOMBIE";
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