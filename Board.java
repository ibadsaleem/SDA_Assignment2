//Muhammad Ibad Saleem 19K0220 G
public class Board {
    private char Auser;
    private int checkFill = 0;
    private char Buser;
    private char[] boxArr;
    private String slots = "123456789";     //3x3 box 

    public Board(char a , char b){

        boxArr= new char[9];
        for(int i = 1 ; i <= 9 ; i++){
            boxArr[i-1] = slots.charAt(i-1);
        }
        Auser = a;
        Buser = b;
    }
    
    public void display_board(){
       String dboard = "";
        System.out.println("player A = " + Auser + "       player B = " + Buser);
        System.out.print("\t");
        for(int i = 1 ; i <= 9 ; i++){


            System.out.print(boxArr[i-1] + " ");

            if(i%3 == 0){System.out.println("");System.out.print("\t");
            }
        }

    }
    
    public int getFilled_slots() {
        return checkFill;
    }

    public void incrementFill() {
        this.checkFill++;
    }
    public boolean boardFull(){
        if(checkFill == 9){
            return true;
        }
        return false;
    }
    public boolean updateBoard(Player player,int pos){
        if(pos >= 1 && pos <= 9){
            if(this.is_empty(pos)){
                this.boxArr[pos-1] = player.getAlias();
                return true;
            }
        }
        System.out.println("Incorrect Move" + player.getAlias());
        return false;

    }
    private int getPos(int row , int col){
        return row*3 + col;
    }
    public char checkWinner(int pos , Player player){          //checking win pattern
        boolean BoxWin = true;      
        int row = (pos-1)/3;
        for(int i=(3*row) ; i < (3*(row+1)) ; i++){
            if(boxArr[i] != player.getAlias()){
                BoxWin =false;
            }
        }
        if(BoxWin){return player.getAlias();}
        BoxWin=true;
        //check vertical
        int col = (pos-1)%3;
        for(int i= 0 ; i < 3 ; i++){
            if(boxArr[i*3 + col] != player.getAlias()){
                BoxWin = false;
            }
        }
        if(BoxWin){
            return player.getAlias();
        }
        BoxWin=true;
        for(int i = 0 ; i< 3; i++){
            if(boxArr[i*3+i] != player.getAlias() ){
                BoxWin = false;
            }
        }
        if(BoxWin){
            return player.getAlias();
        }
        BoxWin=true;
        for(int i = 2,j=0; i>=0 && j<3 ; i--,j++){
            if(boxArr[j*3+i] != player.getAlias() ){
                BoxWin = false;
            }
        }
        if(BoxWin){
            return player.getAlias();
        }

        return 'N';
    }

    public boolean is_empty(int position){              //checking position if empty to run

        int value = (int)boxArr[position-1];
        System.out.print(value);
        if(boxArr[position-1] >= 48 && boxArr[position-1] <= 57){return true;}
        return false;
    }
}
