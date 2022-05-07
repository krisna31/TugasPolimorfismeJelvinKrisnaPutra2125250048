abstract class Player implements Attribute {
  // attribute
  protected String name, weapon;
  protected int health, defense, attack;
  protected boolean useDefense;

  // method
  public String getName() {
    return this.name;
  }

  public void setNama(String name) {
    this.name = name;
  }

  public int getHealth() {
    return this.health;
  }

  public int getDefense() {
    return this.defense;
  }

  public String getWeapon() {
    return this.weapon;
  }

  public int getAttack() {
    return this.attack;
  }

  public boolean getUseDefense() {
    return this.useDefense;
  }

  public boolean validatePlayer(Player player) {
    return player.getHealth() <= 0 ? true : false;
  }

  public boolean validateEnemy(Enemy enemy) {
    return enemy.getHealth() <= 0 ? true : false;
  }

  @Override
  public void attack(Enemy enemy) {
    System.out.println("Sebelum ==> HP Player = " + this.health);
    System.out.println("Sebelum ==> HP Enemy = " + enemy.getHealth());
    System.out.println("Player " + this.name + " attacking " + enemy.getType());
    if (!this.useDefense) {
      enemy.setHealth(enemy.getHealth() - this.attack);
      if (validateEnemy(enemy))
        enemy.setHealth(0);
      System.out.println("Sesudah Player Attack ==> HP Player = " + this.health);
      System.out.println("Sesudah Player Attack ==> HP Enemy = " + enemy.getHealth());
      if (validateEnemy(enemy))
        System.out.println("Enemy " + enemy.getType() + " is dead");
    }
    if (enemy.getHealth() <= 0)
      System.out.println("Player " + this.name + " Has Won The Battle");
    else {
      if (!this.useDefense && enemy.getHealth() > 0) {
        this.health = (int) (this.health - enemy.getAttack() * Math.round(Math.random() * 5));
        if (validatePlayer(this))
          this.health = 0;
        System.out.println("Sesudah Enemy Attack ==> HP Player = " + this.health);
        System.out.println("Sesudah Enemy Attack ==> HP Enemy = " + enemy.getHealth());
        if (validatePlayer(this)) {
          System.out.println("Player " + this.name + " is dead");
          System.out.println("Enemy " + enemy.getType() + " Has Won The Battle");
        }
      }
    }
    this.useDefense = false;
  }

  @Override
  public void defense(Enemy enemy) {
    this.useDefense = true;
    this.attack(enemy);
  }
} // end of Player