public class Bichinho {
 
    private static final int MIN = 0;
    private static final int MAX = 100;
 
    private String nome;
    private int fome;
    private int energia;
    private int felicidade;
 
    public Bichinho(String nome) {
        this.nome = nome;
        this.fome = limitar(60);
        this.energia = limitar(100);
        this.felicidade = limitar(50);
    }
 
    // Garante que qualquer valor fique sempre entre 0 e 100.
    private int limitar(int valor) {
        return Math.max(MIN, Math.min(MAX, valor));
    }
 
    // Bônus: com fome 100, o bichinho fica doente.
    private boolean estaDoente() {
        return fome >= MAX;
    }
 
    public void alimentar() {
        fome = limitar(fome - 30);
        felicidade = limitar(felicidade + 5);
        System.out.println(nome + " comeu. Nham!");
    }
 
    public void brincar() {
        if (estaDoente()) {
            System.out.println(nome + " está doente de tanta fome e se recusa a brincar. Dê comida primeiro!");
            return;
        }
        felicidade = limitar(felicidade + 20);
        energia = limitar(energia - 15);
        fome = limitar(fome + 10);
        System.out.println(nome + " brincou!");
        if (estaDoente()) {
            System.out.println(nome + " chegou a fome 100 e ficou doente...");
        }
    }
 
    public void dormir() {
        energia = MAX;
        fome = limitar(fome + 20);
        System.out.println(nome + " dormiu e acordou cheio de energia.");
        if (estaDoente()) {
            System.out.println(nome + " acordou com fome 100 e está doente...");
        }
    }
 
    public boolean estaFeliz() {
        return felicidade >= 70;
    }
 
    public void status() {
        System.out.println("--- " + nome + " ---");
        System.out.println("Fome: " + fome + " | Energia: " + energia + " | Felicidade: " + felicidade);
        System.out.println("Feliz: " + (estaFeliz() ? "sim" : "não")
                + " | Doente: " + (estaDoente() ? "sim" : "não"));
        System.out.println();
    }
 
    public static void main(String[] args) {
        Bichinho pet = new Bichinho("Bolinha");
 
        System.out.println("=== Um dia na vida do Bolinha ===\n");
 
        System.out.println("Manhã:");
        pet.status();
 
        System.out.println("Hora da farra:");
        pet.brincar();
        pet.brincar();
        pet.brincar();
        pet.brincar();
        pet.status();
 
        System.out.println("Ainda quer brincar?");
        pet.brincar(); // recusa: fome 100
        pet.status();
 
        System.out.println("Hora do almoço:");
        pet.alimentar();
        pet.status();
 
        System.out.println("Hora da soneca:");
        pet.dormir();
        pet.status();
 
        System.out.println("Lanche da noite:");
        pet.alimentar();
        pet.alimentar();
        pet.status();
 
        System.out.println(pet.estaFeliz() ? "Bolinha foi dormir feliz!" : "Bolinha foi dormir meio triste...");
    }
}
