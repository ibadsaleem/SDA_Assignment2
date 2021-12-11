import java.util.Scanner;
//Alias refers to player
public class Player {
    private char alias;
    private String name;
    private Scanner scanner;
    public Player(char alias, String name) {
        this.alias = alias;
        this.name = name;
        scanner = new Scanner(System.in);
    }

    public char getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }
    public int makeMove() { // can be place on unfilled slot
        int input = 0;
        boolean valid = true;
        String number;
        while (valid) {
            try {
                System.out.println(this.name + " turn : ");
                input = 0;
                number = scanner.nextLine();
                input = Integer.parseInt(number); //Scanner for taking input
                if (input != 0) {
                    valid = false;
                }

            } catch (Exception err) {
                System.out.println(err.getMessage());
                valid = true;
            }
        }
        return input;
    }

    public void display_user_info() {
        String info = name + "  " + alias;
        System.out.println(info);
    }
}