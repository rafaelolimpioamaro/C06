public class Computador {
    String marca;
    float preco;
    HardwareBasico[] hardware;
    SistemaOperacional sistema;
    MemoriaUSB memoria;

    public Computador() {
        this.hardware = new HardwareBasico[3];

        for (int i = 0; i < 3; i++) {
            this.hardware[i] = new HardwareBasico();
        }
        this.sistema = new SistemaOperacional();
    }

    void mostraPCCconfigs(){
        System.out.println("Marca: " + marca);
        System.out.println("Preco: " + preco);
        System.out.print("Hardware: ");
        for (int i = 0; i < hardware.length; i++) {
            System.out.println(hardware[i].nome + " " + hardware[i].capacidade);
        }
        System.out.println("Sistema: " + sistema.nome + " (" + sistema.tipo + "  bits)");
        if(memoria != null){
            System.out.println("Acompahameto: " + memoria.nome + " de " + memoria.capacidade +  "Gb");

        } else {
            System.out.println("Nao tem memoria");
        }
    }

    void addMemoriaUSB(MemoriaUSB musb){
        this.memoria = musb;
    }

}

