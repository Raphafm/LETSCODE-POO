package org.example.Quiz;

public enum TipoPerfilInvestidor {
    CONSERVADOR("Conservador","01",0),
    MODERADO("Moderado","02", 10),
    ARROJADO("Arrojado","03",14);


    static TipoPerfilInvestidor tipoPerfilInvestidor;
    String label;
    String code;
    int pontuacaoMinima;

    TipoPerfilInvestidor( String label, String code, int pontuacaoMinima) {
        this.pontuacaoMinima = pontuacaoMinima;
        this.label = label;
        this.code = code;
    }

    public static TipoPerfilInvestidor getTipoPerfilInvestidor(int pontos) {
        if (pontos < 10){
            tipoPerfilInvestidor = TipoPerfilInvestidor.CONSERVADOR;
        } else if(pontos >= 10 && pontos < 14){
            tipoPerfilInvestidor = TipoPerfilInvestidor.MODERADO;
        } else{
            tipoPerfilInvestidor = TipoPerfilInvestidor.ARROJADO;
        }

        return tipoPerfilInvestidor;
    }
}
