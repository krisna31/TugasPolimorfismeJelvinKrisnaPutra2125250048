import java.util.*;

public class App {
    // static scanner for global scope
    static Scanner scanner = new Scanner(System.in);

    // MAIN METHOD
    public static void main(String[] args) {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // header or opening
        printHeader();

        // input for Player
        int role = 1;
        do {
            if (role != 1 && role != 2)
                printUppercase("mohon input sesuai opsi saja 1/2");
            role = inputanInteger("Pilih Role\n1. Knight\n2.  Fighter\nPilihan Anda : ");
        } while (role != 1 && role != 2);
        printGaris();
        // input for Enemy
        int roleEnemy = 1;
        do {
            if (roleEnemy != 1 && roleEnemy != 2)
                printUppercase("mohon input sesuai opsi saja 1/2");
            roleEnemy = inputanInteger("Pilih Enemy\n1. Slime\n2. Boar\nPilihan Anda : ");
        } while (roleEnemy != 1 && roleEnemy != 2);
        printGaris();
        switch (role) {
            case 1:
                Knight knight = new Knight();
                knight.setNama(inputanString("Masukkan Nama : "));
                switch (roleEnemy) {
                    case 1:
                        Slime slime = new Slime();
                        playGame(knight, slime);
                        break;
                    case 2:
                        Boar boar = new Boar();
                        playGame(knight, boar);
                        break;
                }
                break;
            case 2:
                Fighter fighter = new Fighter();
                fighter.setNama(inputanString("Masukkan Nama : "));
                switch (roleEnemy) {
                    case 1:
                        Slime slime = new Slime();
                        playGame(fighter, slime);
                        break;
                    case 2:
                        Boar boar = new Boar();
                        playGame(fighter, boar);
                        break;
                }
                break;
        }

        // scanner close
        scanner.close();
    }

    // Play Game Method for Player and Enemy
    public static void playGame(Player player, Enemy enemy) {
        // inisialisasi for ronde int variable
        int ronde = 1, once = 0;
        // looping game
        do {
            // print player and enemy
            System.out.println("Player HP : " + player.getHealth() + "\nEnemy HP : " + enemy.getHealth());
            // rules for attack and defense
            if (once == 0) {
                printGaris("WHAT IS ATTACK AND DEFENSE???");
                System.out.println(
                        "Attack : Attacking the enemy with your weapon and then enemy will attack you with random damage output");
                System.out.println(
                        "Defense : If you feel that enemy damage is too much, you can defend yourself and will not take any damage from enemy");
                once++;
            }
            // printing ronde number
            printGaris("Ronde Ke-" + ronde);
            ronde++;
            // input for choose menu attack and defense
            int choose = 1;
            do {
                if (choose != 1 && choose != 2)
                    printUppercase("mohon input sesuai opsi saja 1/2");
                choose = inputanInteger("Mohon Pilih\n1. Attack\n2. Defense\nPilihan Anda : ");
            } while (choose != 1 && choose != 2);
            // realizing attack and defense depend on choose number
            switch (choose) {
                case 1:
                    player.attack(enemy);
                    break;
                case 2:
                    player.defense(enemy);
                    break;
                default:
                    break;
            }
        } while (player.getHealth() > 0 && enemy.getHealth() > 0);
    }

    private static void printUppercase(String arg) {
        System.out.println(arg.toUpperCase());
    }

    private static void printHeader() {
        System.out.println("WELCOME TO SIMPLE ONE SHOT PLAYER VS ENEMY GAME WITH CLI INTERFACE");
        System.out.println("Anda Sebagai Player Berhak Memilih 1 dari 2 Role yang Diesediakan");
        System.out.println("Pemenang Ditentukan Dari Siapa yang Berhasil Membunuh Lawannya Terlebih Dahulu");
        System.out.println(
                "Besaran Serangan Musuh Tidak Konstan Atau Acak Sehingga Player Diberikan 2 opsi untuk Attack OR Defense");
        printGaris("SELAMAT BERMAIN");
    }

    private static String inputanString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int inputanInteger(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printGaris() {
        System.out.println("======================================================");
    }

    private static void printGaris(String arg) {
        System.out.println("============================" + arg + "============================");
    }
} // end of main

interface Attribute {
    public void attack(Enemy enemy);

    public void defense(Enemy enemy);
} // end of interface attribute

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

class Knight extends Player {
    Knight() {
        this.health = 100;
        this.weapon = "Sword";
        this.defense = 20;
        this.attack = 25;
        this.useDefense = false;
    }
} // end of knight class

class Fighter extends Player {
    Fighter() {
        this.health = 100;
        this.weapon = "Shield & Claymore";
        this.defense = 28;
        this.attack = 18;
        this.useDefense = false;
    }
} // end of knight class

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