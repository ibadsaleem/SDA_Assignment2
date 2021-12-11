public class Game {
    private Player playerA;
    private Player playerB;
    private Player winner = null;

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public Board getBoard() {
        return board;
    }

    private Board board;
    public Game() {}
    public void initializeGame() {
        winner = null;
        playerA = new Player('*', "playerA");
        playerB = new Player('o', "playerB");
        board = new Board(playerA.getAlias(), playerB.getAlias());
    }
    private boolean startGame() {
        //will check each player moves if one makes up the pattern he wins
        boolean noresult = true;
        boolean valid_move = true;
        while (!this.board.board_full() && noresult) {
            board.displayBoard();
            int positionA, positionB;
            do {
                positionA = playerA.make_move();
            } while (!board.update_board(playerA, positionA));
            if (board.check_winner(positionA, playerA) != 'N') {
                winner = playerA;
                noresult = false;
                continue;
            }
            System.out.println("result = " + board.check_winner(positionA, playerA));
            board.displayBoard();
            do {
                positionB = playerB.make_move();
            } while (!board.update_board(playerB, positionB));
            if (board.check_winner(positionB, playerB) != 'N') {
                winner = playerB;
                noresult = false;
            }
            System.out.println("result = " + board.check_winner(positionB, playerB));
            board.increment();
        }
        boolean result = check_win_draw(winner);
        return result;
    }
    private boolean checkWinDraw(Player player) {
        board.display_board();
        if (player == null) {
            System.out.println("draw match");
            return false;
        } else {
            System.out.println(playerA.getName() + " won the round");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.initialize_game();
            game.start_game();


        } catch (Exception e) { //exception Handling
            System.out.println(e.getMessage());
        }
    }


}