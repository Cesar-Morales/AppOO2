import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Espacio {

    private String name;
    private TipoDeSuelo tipoDeSuelo;
    private List<Cultivo> cultivos;

    public Espacio(String name, TipoDeSuelo tipoDeSuelo) {
        setName(name);
        setTipoDeSuelo(tipoDeSuelo);
        this.cultivos = new ArrayList<>();
    }

    @Override
	public String toString() {
		return "Espacio [name=" + name + ", cultivos=" + Arrays.toString(cultivos.toArray()) + "]";
	}

	public Boolean agregarCultivo(Cultivo cultivo) {
        if(puedePLantarseEnSuelo(cultivo)){
            this.getCultivos().add(cultivo);
            return true;
        }
        else
            return false;
    }

    private boolean puedePLantarseEnSuelo(Cultivo cultivo) {
        return this.getTipoDeSuelo().puedePlantarse(cultivo);
    }

    //Hacemos que este listar cultivos sea un imprmir o que solo devuelva los cultivos
    //Y que la clase quinta los imprima? Tal vez esto puede ser una parte del refactoring.
    //Porque esto es literalmente un getter.
    public List<Cultivo> listaDeCultivos() {
        return this.getCultivos();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoDeSuelo getTipoDeSuelo() {
        return tipoDeSuelo;
    }

    public void setTipoDeSuelo(TipoDeSuelo tipoDeSuelo) {
        this.tipoDeSuelo = tipoDeSuelo;
    }

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public void setCultivos(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

}
