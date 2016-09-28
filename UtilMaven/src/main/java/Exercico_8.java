
public class Exercico_8 {

    public static void main(String[] args) {
        Integer a = 10256;
        Integer b = 512;
        System.out.println("Valores de Entrada: " + a + " - " + b);
        String c = "";
        int limite = Math.max(a.toString().length(), b.toString().length());
        for (int i = 0; i <= limite; i++) {
            if (i < a.toString().length()) {
                c += a.toString().charAt(i);
            }
            if (i < b.toString().length()) {
                c += b.toString().charAt(i);
            }
        }
        int result = Integer.valueOf(c) > 1000000 ? -1 : Integer.valueOf(c);
        System.out.println("Valor de Saída: " + result);
    }
}
