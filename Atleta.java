public class Atleta extends Persona{
    public static final int SCONTO_ATLETA_NAZIONALE = 30;
    public static final int SCONTO_ATLETA_INTERNAZIONALE = 50;
    String sport;
    enum Rilevanza{NAZIONALE, INTERNAZIONALE};
    Rilevanza rilevanza;

    public Atleta(String cognomeNome, String codiceFiscale, int annoNascita, String sport, Rilevanza rilevanza) {
        super(cognomeNome, codiceFiscale, annoNascita);
        this.sport = sport;
        this.rilevanza = rilevanza;
    }

    @Override
    public double sconto() {
        if(rilevanza == Rilevanza.NAZIONALE){
            abbonamento = ABBONAMENTO_BASE - SCONTO_ATLETA_NAZIONALE *(ABBONAMENTO_BASE/100);
        } else if (rilevanza == Rilevanza.INTERNAZIONALE) {
            abbonamento = ABBONAMENTO_BASE - SCONTO_ATLETA_INTERNAZIONALE *(ABBONAMENTO_BASE/100);
        }
        abbonamento = Math.min(abbonamento, super.sconto());
        return abbonamento;
    }

    @Override
    public void stampa() {
        System.out.print(cognomeNome + " " + codiceFiscale + " " + annoNascita + " " + sport + " ");
        if(rilevanza == Rilevanza.NAZIONALE){
            System.out.print("Nazionale");
        } else if (rilevanza == Rilevanza.INTERNAZIONALE) {
            System.out.print("Internazionale");
        }
        System.out.println(" | " + sconto());
    }
}
