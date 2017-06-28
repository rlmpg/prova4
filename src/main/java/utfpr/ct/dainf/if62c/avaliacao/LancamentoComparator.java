package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class LancamentoComparator implements Comparator<Lancamento>{
    
    @Override
    public int compare(Lancamento l1, Lancamento l2){     
        int res = l1.getConta().compareTo(l2.getConta());
        
        if (res == 0){
            res = l1.getData().compareTo(l2.getData());
        }
        
        return (res);
    }
    
}