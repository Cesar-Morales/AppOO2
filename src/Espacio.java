import java.util.ArrayList;
import java.util.List;
public class Espacio {

    private String name;
    private TipoDeSuelo tipoDeSuelo;
    private Double porcentajeDeHumedad;
    private List<Cultivo> cultivos;

    public Espacio(String name, TipoDeSuelo tipoDeSuelo) {
        setName(name);
        setTipoDeSuelo(tipoDeSuelo);
        setPorcentajeDeHumedad(100.0);
        this.cultivos = new ArrayList<>();
    }

    @Override
	public String toString() {
		return "Espacio [name=" + name + ", tipoDeSuelo=" + tipoDeSuelo + ", porcentajeDeHumedad=" + porcentajeDeHumedad
				+ ", cultivos=" + cultivos + "]";
	}

	public Boolean agregarCultivo(Cultivo cultivo) {
        if(this.puedePlantarse(cultivo)){
            this.getCultivos().add(cultivo);
            return true;
        }
        else
            return false;
    }

    private boolean puedePlantarse(Cultivo cultivo) {
        return Quinta.getEstacion().cultivoApto(cultivo) && 
               this.getTipoDeSuelo().puedePlantarse(cultivo, this.getPorcentajeDeHumedad());
    }

    //Hacemos que este listar cultivos sea un imprmir o que solo devuelva los cultivos
    //Y que la clase quinta los imprima? Tal vez esto puede ser una parte del refactoring.
    //Porque esto es literalmente un getter.
    public List<Cultivo> listaDeCultivos() {
        return this.getCultivos();
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
     * @return TipoDeSuelo return the tipoDeSuelo
     */
    public TipoDeSuelo getTipoDeSuelo() {
        return tipoDeSuelo;
    }

    /**
     * @param tipoDeSuelo the tipoDeSuelo to set
     */
    public void setTipoDeSuelo(TipoDeSuelo tipoDeSuelo) {
        this.tipoDeSuelo = tipoDeSuelo;
    }


    /**
     * @return Double return the porcentajeDeHumedad
     */
    public Double getPorcentajeDeHumedad() {
        return porcentajeDeHumedad;
    }

    /**
     * @param porcentajeDeHumedad the porcentajeDeHumedad to set
     */
    public void setPorcentajeDeHumedad(Double porcentajeDeHumedad) {
        this.porcentajeDeHumedad = porcentajeDeHumedad;
    }


    /**
     * @return List<Cultivo> return the cultivos
     */
    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    /**
     * @param cultivos the cultivos to set
     */
    public void setCultivos(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

}
