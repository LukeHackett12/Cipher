import java.util.Scanner;

public class AutokeyCipher{
    public static void main(String[] Args){
        System.out.print("Do you want to encrypt or decrypt a message: ");
        Scanner input = new Scanner(System.in);
        String response = input.next();
        if(response.equalsIgnoreCase("encrypt")){
            encrypt();
        }
        else if(response.equalsIgnoreCase("decrypt")){
            decrypt();
        }
        else if(response.equalsIgnoreCase("table")){
            char[][] alphabetTable = alphabetTable();
            for(int i = 0; i < 27; i++){
                for(int j = 0; j < 27; j++){
                    System.out.print(alphabetTable[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void encrypt(){
        char[][] alphabetTable = alphabetTable();

        Scanner input = new Scanner(System.in);
        System.out.print("What message do you want to encrypt? ");
        String message = input.nextLine();
        message = message.toLowerCase();
        char[] messageSplit = message.toCharArray();
        System.out.print("What is the keyword? ");
        String keyword = input.next();
        char[] keywordSplit = keyword.toCharArray();

        char[] autokey = new char[messageSplit.length];

        for(int i = 0; i < autokey.length; i++){
            if(i < keywordSplit.length){
                autokey[i] = keywordSplit[i];
            }
            else{
                autokey[i] = messageSplit[(i - keywordSplit.length)%messageSplit.length];
            }
        }

        char[] cipher = new char[messageSplit.length];
        for(int i = 0; i < messageSplit.length; i++){
            if(messageSplit[i] != ' '){
                char messageLetter = messageSplit[i];
                char keywordLetter = keywordSplit[i%keywordSplit.length];

                int xVal = 0;
                int yVal = 0;
                for(int x = 0;x < 26; x++){
                    if(alphabetTable[x][0] == messageLetter){
                        xVal = x;
                    }
                }
                for(int y = 0; y < 26; y++){
                    if(alphabetTable[0][y] == keywordLetter){
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
    }

    public static void decrypt(){
        char[][] alphabetTable = alphabetTable();

        Scanner input = new Scanner(System.in);
        System.out.print("What message do you want to decrypt? ");
        String cipher = input.nextLine();
        cipher = cipher.toLowerCase();
        char[] cipherSplit = cipher.toCharArray();
        System.out.print("What was the keyword? ");
        String keyword = input.next();
        char[] keywordSplit = keyword.toCharArray();

        char[] message = new char[cipherSplit.length];
        for(int i = 0; i < cipherSplit.length; i++){
            if(cipherSplit[i] != ' '){
                char cipherLetter = cipherSplit[i];
                char keywordLetter = keywordSplit[i%keywordSplit.length];

                int xVal = 0;
                int yVal = 0;
                for(int x = 0;x < 26; x++){
                    if(alphabetTable[x][0] == keywordLetter){
                        xVal = x;
                    }
                }
                for(int y = 0; y < 26; y++){
                    if(alphabetTable[xVal][y] == cipherLetter){
                        yVal = y;
                    }
                }

                message[i] = alphabetTable[0][yVal];
            }
            else {
                message[i] = ' ';
            }
            System.out.print(message[i]);
        }
        System.out.println();
    }

    public static char[][] alphabetTable(){
        char[][] alphabetTable = new char[27][27];

        for(int i = 0; i < 27; i++){
            for(int j = 0; j < 27; j++){
                int temp = i + j;
                if((temp % 27) + 97 < 123){
                    temp = (temp % 27) + 97;
                    alphabetTable[i][j] = (char)temp;
                }
                else{
                    alphabetTable[i][j] = ' ';
                }
            }
        }
        return alphabetTable;
    }
}
