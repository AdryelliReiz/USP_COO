package classes;

class Veiculo {
    void movimente() {
        System.out.println("Eu me movimento por aí.");
    }
}

class Carro extends Veiculo {
    void movimente() {
        super.movimente(); //opcional
        System.out.println("Eu gasto combustível, gero trânsito e poluo o ar.");
    }

    void buzinar() {
        System.out.println("Bi Bi, olha o carro passando!");
    }
}

class Ferrari extends Carro {
    void movimente() {
        super.movimente(); //opcinal
        System.out.println("Sou vermelha, super-da-hora mas faço um barulhão.");
    }
}

class Bicicleta extends Veiculo {
    void movimente() {
        super.movimente(); //opcional
        System.out.println("Faço bem para a saúde física e mental e não poluo.");
    }
}

class Moto extends Veiculo {
    public void buzinar() {
        System.out.println("Bi bi!");
    }
}

public class introduction {
    public static void main(String[] args) {
        Moto minhaMoto = new Moto();
        minhaMoto.buzinar();
        minhaMoto.movimente();
        Veiculo meuCarro = new Carro();
        //meuCarro.buzinar(); // aqui vai querar um erro '0'
    }
}
