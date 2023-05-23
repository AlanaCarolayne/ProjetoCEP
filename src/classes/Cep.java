package classes;
public class Cep {
    //----------------Variaveis------------------//
    private String cep;
    private String estado;
    private String municipio;
    private  String bairro;
    private String logradouro;
    private String complemento;

    public Cep(cepViaCep cep) {
            this.cep = cep.cep();
            this.estado = cep.uf();
            this.municipio = cep.localidade();
            this.bairro = cep.bairro();
            this.logradouro = cep.logradouro();
            this.complemento = cep.complemento();
    }

    //-------------Getters e Setters---------------------//
    public String getCep() {
        return cep;
    }
    public String getEstado() {
        return estado;
    }
    public String getMunicipio() {
        return municipio;
    }
    public String getBairro() {
        return bairro;
    }
    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }


    @Override
    public String toString() {
        return "( CEP: " + this.cep +" Logradouro: " + this.logradouro +
                " " +this.complemento + ", bairro: " + this.bairro +
                ", municipio: " + this.municipio + ", estado de " + this.estado +" )";
    }
}
