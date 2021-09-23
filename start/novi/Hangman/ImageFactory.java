package novi.Hangman;

import java.util.List;
import java.util.List;

public class ImageFactory {
    private static final List<List<String>> IMAGES = List.of(
            List.of(),
            List.of(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "___|___"
            ),
            List.of(
                    "",
                    "   |",
                    "   |",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |",
                    "   |",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |       |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |       |",
                    "   |      / \\",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |      -|-",
                    "   |      / \\",
                    "___|___"
            )
    );

    public static List<String> getImage(int index) {
        return IMAGES.get(index);
    }


}
