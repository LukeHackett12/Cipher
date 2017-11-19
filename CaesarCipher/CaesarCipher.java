import java.util.Scanner;

public class CaesarCipher{
    public static void main(String[] args){
        System.out.print("Do you want to encrypt or decrypt a message: ");
        Scanner input = new Scanner(System.in);
        String response = input.next();
        if(response.equalsIgnoreCase("encrypt")){
            encrypt();
        }
        else if(response.equalsIgnoreCase("decrypt")){
            decrypt();
        }
    }

    public static void encrypt(){
        Scanner input = new Scanner(System.in);
        System.out.print("What message do you want to send? ");
        String message = input.nextLine();
        System.out.print("What do you want to set your key as?(1-25) ");
        int key = input.nextInt();

        System.out.println("Your message: " + message);

        //Cut up input
        message = message.toLowerCase();
        String[] sentence = message.split(" ");
        //Start cipher
        System.out.print("The encrypted message is: ");
        for(int i = 0; i < sentence.length; i++){
            char[] word = sentence[i].toCharArray();

            for(int j = 0; j < word.length; j++){
                int temp = (int)word[j];
                int shifted = 0;
                shifted = (((temp-97) + key) % 26) + 97;

                word[j] = (char)shifted;
                System.out.print(word[j]);
            }
            sentence[i] = new String(word);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void decrypt(){
        Scanner input = new Scanner(System.in);
        System.out.print("What message do you want to decrypt? ");
        String message = input.nextLine();
        System.out.print("What was the key? ");
        int key = input.nextInt();

        message = message.toLowerCase();
        String[] sentence = message.split(" ");
        System.out.print("The decrypted message is: ");
        for(int i = 0; i < sentence.length; i++){
            char[] word = sentence[i].toCharArray();

            for(int j = 0; j < word.length; j++){
                int temp = (int)word[j];
                int shifted = 0;
                shifted = (((temp-97) - key) % 26) + 97;

                word[j] = (char)shifted;
                System.out.print(word[j]);
            }
            sentence[i] = new String(word);
            System.out.print(" ");
        }
        System.out.println();
    }
}
