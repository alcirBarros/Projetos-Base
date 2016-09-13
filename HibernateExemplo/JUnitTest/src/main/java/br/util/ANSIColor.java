package br.util;

/**
 * Methods for printing colorful text for ANSI-enabled terminals.
 *
 * @author Casey Kirsle, kirsle.org
 * @version 0.01, 2008/12/23
 */
public class ANSIColor {

    private static boolean ansi_enabled = true;

    /**
     * Enable ANSI color codes (codes are enabled by default).
     */
    public static void enable() {
        ansi_enabled = true;
    }

    /**
     * Disable ANSI color codes. When disabled, all other methods won't do anything until ANSI colors are re-enabled.
     */
    public static void disable() {
        ansi_enabled = false;
    }

    /**
     * Alias for color("red").
     */
    public static void red() {
        color("red");
    }

    /**
     * Alias for color("maroon").
     */
    public static void maroon() {
        color("maroon");
    }

    /**
     * Alias for color("lime").
     */
    public static void lime() {
        color("lime");
    }

    /**
     * Alias for color("green").
     */
    public static void green() {
        color("green");
    }

    /**
     * Alias for color("yellow").
     */
    public static void yellow() {
        color("yellow");
    }

    /**
     * Alias for color("gold").
     */
    public static void gold() {
        color("gold");
    }

    /**
     * Alias for color("blue").
     */
    public static void blue() {
        color("blue");
    }

    /**
     * Alias for color("navy").
     */
    public static void navy() {
        color("navy");
    }

    /**
     * Alias for color("magenta").
     */
    public static void magenta() {
        color("magenta");
    }

    /**
     * Alias for color("purple").
     */
    public static void purple() {
        color("purple");
    }

    /**
     * Alias for color("cyan").
     */
    public static void cyan() {
        color("cyan");
    }

    /**
     * Alias for color("teal").
     */
    public static void teal() {
        color("teal");
    }

    /**
     * Alias for color("white").
     */
    public static void white() {
        color("white");
    }

    /**
     * Alias for color("silver").
     */
    public static void silver() {
        color("silver");
    }

    /**
     * Alias for color("reset").
     */
    public static void reset() {
        color("reset");
    }

    /**
     * Print a single line of text in red. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void red(String text) {
        color("red");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in maroon. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void maroon(String text) {
        color("maroon");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in lime. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void lime(String text) {
        color("lime");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in green. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void green(String text) {
        color("green");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in yellow. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void yellow(String text) {
        color("yellow");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in gold. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void gold(String text) {
        color("gold");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in blue. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void blue(String text) {
        color("blue");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in navy. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void navy(String text) {
        color("navy");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in magenta. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void magenta(String text) {
        color("magenta");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in purple. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void purple(String text) {
        color("purple");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in cyan. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void cyan(String text) {
        color("cyan");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in teal. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void teal(String text) {
        color("teal");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in white. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void white(String text) {
        color("white");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print a single line of text in silver. No line breaks are used. Color is reset afterward.
     *
     * @param text The text to print in this color.
     */
    public static void silver(String text) {
        color("silver");
        System.out.print(text);
        color("reset");
    }

    /**
     * Print an ANSI color escape code to the terminal.
     *
     * @param name The name of a color to use (or a reset sequence is sent).
     */
    public static void color(String name) {
        // Don't do it if ANSI colors aren't enabled.
        if (ansi_enabled == false) {
            return;
        }

        if (name.equals("red")) {
            System.out.print((char) 27 + "[31;1m");
        } else if (name.equals("maroon")) {
            System.out.print((char) 27 + "[31m");
        } else if (name.equals("lime")) {
            System.out.print((char) 27 + "[32;1m");
        } else if (name.equals("green")) {
            System.out.print((char) 27 + "[32m");
        } else if (name.equals("yellow")) {
            System.out.print((char) 27 + "[33;1m");
        } else if (name.equals("gold")) {
            System.out.print((char) 27 + "[33m");
        } else if (name.equals("blue")) {
            System.out.print((char) 27 + "[34;1m");
        } else if (name.equals("navy")) {
            System.out.print((char) 27 + "[34m");
        } else if (name.equals("magenta")) {
            System.out.print((char) 27 + "[35;1m");
        } else if (name.equals("purple")) {
            System.out.print((char) 27 + "[35m");
        } else if (name.equals("cyan")) {
            System.out.print((char) 27 + "[36;1m");
        } else if (name.equals("teal")) {
            System.out.print((char) 27 + "[36m");
        } else if (name.equals("white")) {
            System.out.print((char) 27 + "[37;1m");
        } else if (name.equals("silver")) {
            System.out.print((char) 27 + "[37m");
        } else {
            System.out.print((char) 27 + "[0m");
        }
    }
}
