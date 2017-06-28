
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.pratica.Lancamento;
import utfpr.ct.dainf.pratica.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Pratica {
    
    static int conta;
    static List<Lancamento> listlancamento = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in); 
        ProcessaLancamentos processor;
        
        System.out.println("Caminho");
        String caminho = scanner.next();
        
        processor = new ProcessaLancamentos(caminho);
        listlancamento = processor.getLancamentos();
        
        System.out.println("Conta");
            
        while(scanner.hasNextInt()){
            
            conta = scanner.nextInt();
            
            if(conta != 0){
                Pratica.exibeLancamentosConta(listlancamento, conta);
            }
            
            else{
                System.exit(0);
                }
            }
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        List<Lancamento> listconta = new ArrayList<>();
        Lancamento temp = new Lancamento(conta, null, null, null);
        boolean ver = true;
        
        int indice = lancamentos.indexOf(temp);
        
        if(indice >= 0){
            listconta.add(lancamentos.get(indice));
            indice++;
            while(lancamentos.get(indice).getConta() ==  lancamentos.get(indice-1).getConta()){
                listconta.add(lancamentos.get(indice));
                indice++;
            }
            for(Lancamento l: listconta){
                        System.out.println(l);
                    }
       
        }    
        else System.out.println("Conta inexistente.");
    }
 
}