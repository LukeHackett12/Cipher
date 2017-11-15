import java.util.Scanner;

public class CaesarCipher{
    public static void main(String[] args){
        //Ask for cipher key
        Scanner input = new Scanner(System.in);
        System.out.print("What message do you want to send? ");
        String message = input.nextLine();
        System.out.print("What do you want to set your key as?(1-25) ");
        int key = input.nextInt();

        System.out.println("Your message: " + message);

        //Cut up input
        String[] sentence = message.split(" ");
        //Start cipher
        System.out.print("The encrypted message is: ");
        for(int i = 0; i < sentence.length; i++){
            char[] word = sentence[i].toCharArray();
            for(int j = 0; j < word.length; j++){
                int temp = (int)word[j]-97;
                int shifted = ((temp + key) % 26) + 97;
                word[j] = (char)shifted;
                System.out.print(word[j]);
            }
            sentence[i] = new String(word);
            System.out.print(" ");
        }

        System.out.println();
        //Optionally decrypt
        System.out.print("Do you want to decrypt:(y/n) ");
        if(input.hasNext("y")){
            System.out.print("The decrypted message is: ");

            for(int i = 0; i < sentence.length; i++){
                char[] word = sentence[i].toCharArray();

                for(int j = 0; j < word.length; j++){
                    int temp = (int)word[j] - 97;
                    int shifted = 0;
                    if(temp - key >= 0)
                        shifted = ((temp - key) % 26) + 97;
                    else
                        shifted = (temp - key) + 123;

                    word[j] = (char)shifted;
                    System.out.print(word[j]);
                }
                sentence[i] = new String(word);
                System.out.print(" ");
            }
        }
    }
}
