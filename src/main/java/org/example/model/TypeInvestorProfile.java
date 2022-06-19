package org.example.model;

public enum TypeInvestorProfile {
    CONSERVADOR("Conservador",0),
    MODERADO("Moderado", 10),
    ARROJADO("Arrojado",14);

    static TypeInvestorProfile typeInvestorProfile;
    String label;
    int minScore;

    TypeInvestorProfile(String label, int minScore) {
        this.minScore = minScore;
        this.label = label;
    }

    public static TypeInvestorProfile getTypeInvestorProfile(int score) {
        if (score < 10){
            typeInvestorProfile = TypeInvestorProfile.CONSERVADOR;
        } else if(score < 14){
            typeInvestorProfile = TypeInvestorProfile.MODERADO;
        } else{
            typeInvestorProfile = TypeInvestorProfile.ARROJADO;
        }
        return typeInvestorProfile;
    }

    public String getLabel() {
        return label;
    }
}
