import java.util.Scanner;

public class VignereCipher{
    public static void main(String[] args){
        char[][] alphabetTable = new char[26][26];

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                int temp = i + j;
                temp = (temp % 26) + 97;
                alphabetTable[i][j] = (char)temp;
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.print("What message do you want to send? ");
        String message = input.nextLine();
        char[] messageSplit = message.toCharArray();
        System.out.print("What do you want to set your keyword as: ");
        String keyword = input.next();
        char[] keywordSplit = keyword.toCharArray();

        char[] cipher = new char[messageSplit.length];
        for(int i = 0; i < messageSplit.length; i++){
            //Ignore if space, 'add' the two letters together
            if(messageSplit[i] != ' '){
                char messageLetter = messageSplit[i];
                char keywordLetter = keywordSplit[i%keywordSplit.length];

                int xVal = 0;
                int yVal = 0;
                for(int x = 0;x < 26; x++){
                    if(alphabetTable[x][1] == messageLetter){
                        xVal = x;
                    }
                }
                for(int y = 0; y < 26; y++){
                    if(alphabetTable[1][y] == keywordLetter){
                        yVal = y;
                    }
                }

                cipher[i] = alphabetTable[xVal][yVal];
            }
            else {
                cipher[i] = ' ';
            }
            System.out.print(cipher[i]);
        }
        System.out.println();
    }
}
