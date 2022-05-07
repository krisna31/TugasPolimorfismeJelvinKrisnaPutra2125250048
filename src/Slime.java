class Slime extends Enemy {
  Slime() {
    this.health = 100;
    this.attack = 10;
    this.defense = 5;
    this.type = "Slime";
    this.name = "" + selectAChar(ABC) + selectAChar(abc) + selectAChar(abc) + selectAChar(abc) + selectAChar(abc)
        + selectAChar(abc);
  }
} // end of Slime