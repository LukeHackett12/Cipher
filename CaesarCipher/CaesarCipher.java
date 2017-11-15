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
                int temp = (int)word[j];
                int shifted = 0;

                //if lowercase
                if(temp >= 97 && temp <= 122){
                    shifted = (((temp-97) + key) % 26) + 97;
                }
                //else if capital
                else if(temp >= 65 && temp <= 90){
                    shifted = (((temp-65) + key) % 26) + 65;
                }

                word[j] = (char)shifted;
                System.out.print(word[j]);
            }
            sentence[i] = new String(word);
            System.out.print(" ");
        }

        System.out.println();
        //Optionally decrypt
        System.out.print("Do you want to decrypt:(y/n) ");
        if(input.hasNext("y") || input.hasNext("Y")){
            System.out.print("The decrypted message is: ");

            for(int i = 0; i < sentence.length; i++){
                char[] word = sentence[i].toCharArray();

                for(int j = 0; j < word.length; j++){
                    int temp = (int)word[j];
                    int shifted = 0;
                    //if lowercase
                    if(temp >= 97 && temp <= 122){
                        shifted = (((temp-97) + key) % 26) + 97;
                    }
                    //else if capital
                    else if(temp >= 65 && temp <= 90){
                        shifted = (((temp-65) + key) % 26) + 65;
                    }

                    word[j] = (char)shifted;
                    System.out.print(word[j]);
                }
                sentence[i] = new String(word);
                System.out.print(" ");
            }
        }
    }
}
