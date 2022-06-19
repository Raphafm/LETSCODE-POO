package org.example.model;

public enum TypeInvestorProfile {
    CONSERVADOR("Conservador",0){
        @Override
        public TypeInvestorProfile getTypeInvestorProfile(int score) {
            return this;
        }
    },
    MODERADO("Moderado", 10){
        @Override
        public TypeInvestorProfile getTypeInvestorProfile(int score) {
            return score < this.minScore ? TypeInvestorProfile.CONSERVADOR.getTypeInvestorProfile(score) : this;
        }
    },
    ARROJADO("Arrojado",14){
        @Override
        public TypeInvestorProfile getTypeInvestorProfile(int score) {
            return score < this.minScore ? TypeInvestorProfile.MODERADO.getTypeInvestorProfile(score) : this;
        }
    };

    private final String label;
    protected final int minScore;

    TypeInvestorProfile(String label, int minScore) {
        this.minScore = minScore;
        this.label = label;
    }

    public abstract TypeInvestorProfile getTypeInvestorProfile(int score);

    public String getLabel() {
        return label;  
    }
 }
