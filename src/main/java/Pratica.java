
import java.io.FileNotFoundException;
import java.io.IOException;
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
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String arquivo;
        Scanner scn = new Scanner(System.in);
        System.out.print("Arquivo: ");
        arquivo = scn.next();
        ProcessaLancamentos procLanc = new ProcessaLancamentos(arquivo);
        List<Lancamento> lanctos = procLanc.getLancamentos();
        
        System.out.println("\nBUSCA DE LANÇAMENTOS");
        Integer conta = 0;
        do {
            System.out.print("Número da conta: ");
            if (scn.hasNextInt()) {
                conta = scn.nextInt();
                exibeLancamentosConta(lanctos, conta);
            } else {
                scn.next();
                System.out.println("Por favor, informe um valor numérico");
            }
        } while (conta > 0);
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        int i = lancamentos.indexOf(new Lancamento(conta, null, null, null));
        if (i < 0) {
            System.out.println("Conta inexistente");
            return;
        }
        while (i < lancamentos.size() && lancamentos.get(i).getConta().equals(conta)) {
            System.out.println(lancamentos.get(i));
            i++;
        }
    }
 
}