package utfpr.ct.dainf.pratica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Linguagem Java
 * @author
 */
public class ProcessaLancamentos {
    private BufferedReader reader;
    private List<Lancamento> lancamentos;
    
    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        throw new UnsupportedOperationException("Não implementado");
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(new File(path)));
    }
    
    private String getNextLine() throws IOException {
        return reader.readLine();
    }
    
    private Lancamento processaLinha(String linha) {
                
        Integer ano, mes, dia, conta;
        double valor;
        String descricao;
        
        conta = Integer.parseInt(linha.substring(0, 6));
        dia = Integer.parseInt(linha.substring(12, 14));
        mes = Integer.parseInt(linha.substring(10, 12));
        ano = Integer.parseInt(linha.substring(6, 10));
        descricao = linha.substring(14, 74).trim();
        valor = Long.valueOf(linha.substring(74, 86))/100;
        
        GregorianCalendar data = new GregorianCalendar(ano, mes-1, dia);
        Date date = data.getTime();
        
        return new Lancamento(conta, date, descricao, valor);
    }
    
    private Lancamento getNextLancamento() throws IOException {
                
        String linha = this.getNextLine();
        
        if(linha != null){
            return this.processaLinha(linha);
        }
        else return null;
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        Lancamento atual;
        lancamentos = new ArrayList<>();
        
        while((atual = getNextLancamento()) != null){
            lancamentos.add(atual);
        }
        reader.close();
        
        Collections.sort(lancamentos, new LancamentoComparator());
        
        return lancamentos;
    }
    
}
