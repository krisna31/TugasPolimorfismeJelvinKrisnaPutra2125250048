class Boar extends Enemy {
  Boar() {
    this.health = 100;
    this.attack = 7;
    this.defense = 8;
    this.type = "Boar";
    this.name = "" + selectAChar(ABC) + selectAChar(abc) + selectAChar(abc) + selectAChar(abc) + selectAChar(abc)
        + selectAChar(abc);
  }
} // end of Boar