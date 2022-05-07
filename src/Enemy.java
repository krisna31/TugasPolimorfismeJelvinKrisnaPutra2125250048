abstract class Enemy {
  // attribute
  protected int health, attack, defense;
  protected String name, type;
  final String ABC = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
  final String abc = ABC.toLowerCase();

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

  public void setHealth(int health) {
    this.health = health;
  }

  public int getDefense() {
    return this.defense;
  }

  public int getAttack() {
    return this.attack;
  }

  public String getType() {
    return this.type;
  }

  protected char selectAChar(String s) {
    return s.toCharArray()[(int) (Math.random() * s.length())];
  }
} // end of Enemy