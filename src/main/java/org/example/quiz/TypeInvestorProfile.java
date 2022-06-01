package org.example.quiz;

public enum TypeInvestorProfile {
    CONSERVADOR("Conservador","01",0),
    MODERADO("Moderado","02", 10),
    ARROJADO("Arrojado","03",14);


    static TypeInvestorProfile typeInvestorProfile;
    String label;
    String code;
    int minScore;

    TypeInvestorProfile(String label, String code, int minScore) {
        this.minScore = minScore;
        this.label = label;
        this.code = code;
    }

    public static TypeInvestorProfile getTipeInvestorPerfil(int score) {
        if (score < 10){
            typeInvestorProfile = TypeInvestorProfile.CONSERVADOR;
        } else if(score >= 10 && score < 14){
            typeInvestorProfile = TypeInvestorProfile.MODERADO;
        } else{
            typeInvestorProfile = TypeInvestorProfile.ARROJADO;
        }

        return typeInvestorProfile;
    }
}
