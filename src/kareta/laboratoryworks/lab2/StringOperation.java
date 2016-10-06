package kareta.laboratoryworks.lab2;

import java.util.Scanner;

public class StringOperation {
    public static String replaceWords(String text, int checkedLength) {
        StringBuffer buffer = new StringBuffer(text);
        final String consonants = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvXxZzWwYy";

        int wordStart = 0;
        while (wordStart < buffer.length()) {
            int wordEnd = wordStart;

            if (Character.isLetter(buffer.charAt(wordEnd))) {
                while (wordEnd < buffer.length() && Character.isLetter(buffer.charAt(wordEnd))) {
                    wordEnd++;
                }

                boolean rightLength = (wordEnd - wordStart) == checkedLength;
                boolean firstIsConsonant =
                        consonants.contains(Character.toString(buffer.charAt(wordStart)));
                if (rightLength && firstIsConsonant) {
                    buffer.delete(wordStart, wordEnd);
                    wordStart = wordEnd - checkedLength;
                } else {
                    wordStart = wordEnd;
                }
            }
            wordStart++;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Type line:");
        String line = input.nextLine();

        System.out.println("Words length to be deleted:");
        int wordLengthToDelete = input.nextInt();

        String resultLine = replaceWords(line, wordLengthToDelete);
        System.out.println("Result:");
        System.out.println(resultLine);
    }
}

