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
            role = inputanInteger("Pilih Role\n1. Knight\n2.  Fighter\nPilihan AnDa : ");
        } while (role != 1 && role != 2);
        printGaris();
        // input for Enemy
        int roleEnemy = 1;
        do {
            if (roleEnemy != 1 && roleEnemy != 2)
                printUppercase("mohon input sEsuai opsi saja 1/2");
            roleEnemy = inputanInteger("PiLih Enemy\n1. Slime\n2. BoAr\npilihAN Anda : ");
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
                printGaris("WhaT Is Attack And Defense???");
                System.out.println(
                        "Attack : Attacking the enemy With your weapOn and Then enemy wIll attack you with randoM damagE output");
                System.out.println(
                        "DefenSe : If you feel that enemy damage is too much, you can defend yourself and will not take any damage from enemy");
                once++;
            }
            // printing ronde number
            printGaris("Ronde Ke-" + ronde);
            ronde++;
            // input for choose menu attack and defense
            int choose = 1;
            do {
                if (choose != 1 && choose != 2 && choose != 88)
                    printUppercase("mohon input sesuai opsi saja 1/2");
                choose = inputanInteger("Mohon Pilih\n1. Attack\n2. Defense\nPilihan Anda : ");
            } while (choose != 1 && choose != 2 && choose != 88);
            // doing attack and defense depend on choose number
            switch (choose) {
                case 1:
                    player.attack(enemy);
                    break;
                case 2:
                    player.defense(enemy);
                    break;
                case 88:
                    printGaris();
                    System.err.println(
                            "I have keep this secret with capitalizing the special or non capitalized the capitalize letter in the whole word btw the secret 'DELApAN TWO TIMES'");
                    System.err.println(
                            "i don't believe it but you found this secret of this program that is the real name of your enemy that you're fighting right now");
                    printGaris();
                    printGaris(
                            "Enemy Name With Type " + enemy.getType() + " is named " + enemy.getName().toUpperCase());
                    printGaris();
                    System.err.println(
                            "You can screenshot this thing and send it to my whatsapp 083177639394 Because i want to know who found this secret either than me Maybe My Teacher");
                    printGaris();
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
