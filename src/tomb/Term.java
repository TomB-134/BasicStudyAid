package tomb;

public class Term {
    public String term;
    public String definition;

    public Term(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public Term() {}

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
