public class PolkadotScorer {

    public static int computePolkadotScore(String art) {
        String[] lines = art.split("\\R", -1);

        // Step 1: Find the lips' horizontal range (x-axis).
        // We use the line that contains a run of ˆ characters (upper lip guide),
        // then expand left and right until we hit ';' which acts as mouth corners.
        final char HAT = '\u02C6';    // ˆ
        int lipsStartX = -1, lipsEndX = -1;

        for (String line : lines) {
            int firstHat = line.indexOf(HAT);
            if (firstHat < 0) continue;

            int lastHat = line.lastIndexOf(HAT);

            int left = firstHat;
            for (int i = firstHat - 1; i >= 0; i--) {
                if (line.charAt(i) == ';') { left = i; break; }
            }

            int right = lastHat;
            for (int i = lastHat + 1; i < line.length(); i++) {
                if (line.charAt(i) == ';') { right = i; break; }
            }

            lipsStartX = left;
            lipsEndX = right;
            break;
        }

        if (lipsStartX < 0 || lipsEndX < 0) {
            throw new IllegalArgumentException("Could not determine lips range.");
        }

        // Step 2: Count characters used for both pupils.
        // We look for the eye line that has the pattern "• ; •" and count bullets.
        final char BULLET = '\u2022'; // •
        int pupilChars = 0;

        for (String line : lines) {
            int firstBullet = line.indexOf(BULLET);
            int semicolon = line.indexOf(';');
            int lastBullet = line.lastIndexOf(BULLET);

            if (firstBullet >= 0 && semicolon >= 0 && lastBullet > semicolon) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == BULLET) pupilChars++;
                }
                break;
            }
        }

        if (pupilChars == 0) {
            throw new IllegalArgumentException("Could not determine pupil chars.");
        }

        // Step 3: Count dress polkadots (O) based on x-position.
        // inside  = O where lipsStartX <= x <= lipsEndX
        // outside = all other O
        int inside = 0, outside = 0;

        for (String line : lines) {
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'O') {
                    if (x >= lipsStartX && x <= lipsEndX) inside++;
                    else outside++;
                }
            }
        }

        // Step 4: Final score formula from the prompt:
        // outside + (inside * pupilChars)
        return outside + inside * pupilChars;
    }
}