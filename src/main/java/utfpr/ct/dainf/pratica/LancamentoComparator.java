package utfpr.ct.dainf.pratica;

import java.util.Comparator;

/**
 * Linguagem Java
 * @author
 */
public class LancamentoComparator implements Comparator<Lancamento>{

    @Override
    public int compare(Lancamento o1, Lancamento o2) {
       if(o1.getConta().equals(o2.getConta())){
           return (o1.getData().getTime() > o2.getData().getTime()) ? 1 : o1.getData().getTime() == o2.getData().getTime()?0 : -1;
       }
       return o1.getConta() - o2.getConta();
    }

    
}
