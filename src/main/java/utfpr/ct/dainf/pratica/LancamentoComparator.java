package utfpr.ct.dainf.pratica;
import java.util.Comparator;
/**
 * Linguagem Java
 * @author
 */
public class LancamentoComparator implements Comparator<Lancamento>{

    @Override
    public int compare(Lancamento o1, Lancamento o2) {
        int comp = o1.getConta().compareTo(o2.getConta());
        if (comp == 0)
            comp = o1.getData().compareTo(o2.getData());
        return comp;
    }
        
}
    

