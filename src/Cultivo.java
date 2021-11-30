public class Cultivo {
    
    private String name;
    private Double phOptimo;
    private Double humedadOptima;
    private Double durezaOptima;
    private Double temperaturaOptima;
    private String nombreFamilia;


    public Cultivo(String name, 
                   Double phOptimo, 
                   Double humedadOptima,
                   Double durezaOptima,
                   Double temperaturaOptima,
                   String nombreFamilia){
    
        setName(name);
        setPhOptimo(phOptimo);
        setHumedadOptima(humedadOptima);
        setDurezaOptima(durezaOptima);
        setTemperaturaOptima(temperaturaOptima);
        setNombreFamilia(nombreFamilia);
            
    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Double return the phOptimo
     */
    public Double getPhOptimo() {
        return phOptimo;
    }

    /**
     * @param phOptimo the phOptimo to set
     */
    public void setPhOptimo(Double phOptimo) {
        this.phOptimo = phOptimo;
    }

    /**
     * @return Double return the humedadOptima
     */
    public Double getHumedadOptima() {
        return humedadOptima;
    }

    /**
     * @param humedadOptima the humedadOptima to set
     */
    public void setHumedadOptima(Double humedadOptima) {
        this.humedadOptima = humedadOptima;
    }

    /**
     * @return Double return the durezaOptima
     */
    public Double getDurezaOptima() {
        return durezaOptima;
    }

    /**
     * @param durezaOptima the durezaOptima to set
     */
    public void setDurezaOptima(Double durezaOptima) {
        this.durezaOptima = durezaOptima;
    }

    /**
     * @return Double return the temperaturaOptima
     */
    public Double getTemperaturaOptima() {
        return temperaturaOptima;
    }

    /**
     * @param temperaturaOptima the temperaturaOptima to set
     */
    public void setTemperaturaOptima(Double temperaturaOptima) {
        this.temperaturaOptima = temperaturaOptima;
    }

    /**
     * @return String return the nombreFamilia
     */
    public String getNombreFamilia() {
        return nombreFamilia;
    }

    /**
     * @param nombreFamilia the nombreFamilia to set
     */
    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

}
