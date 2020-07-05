
package application;

import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HorasTrabalhadas {
   
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner entrarDados = new Scanner(System.in);
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Entre com o nome do departamento:");
        String departamento = entrarDados.nextLine();
        
        System.out.print("Entre com o nome do funcionario:");
        String nomeFuncionario = entrarDados.nextLine();
        
        System.out.print("Entre com o nivel do funcionario:");
        String nivelFuncionario = entrarDados.nextLine();
        
        System.out.print("Entre com o Salario:");
        double salario = entrarDados.nextDouble();
        
        System.out.print("Quantos contrato o funcionario tem?");
        int quantContrato = entrarDados.nextInt();
        Trabalhador novoFuncionario = new Trabalhador(nomeFuncionario, NivelTrabalhador.valueOf(nivelFuncionario), salario, new Departamento(departamento));
        
        for(int i=1; i<=quantContrato; i++){
             System.out.print("Entre com a data do " + i +" contrato ");
             System.out.print("- Formato da Data (DD/MM/YY):");
             Date dataContrato = dataFormat.parse(entrarDados.next());
             
             System.out.print("Entre com o valor por hora:");
             double valorPorHora = entrarDados.nextDouble();
             
             System.out.print("Entre com numero de horas trabalhadas:");
             int horasContrato = entrarDados.nextInt();
             ContratoPorHora contratoHora = new ContratoPorHora(dataContrato, valorPorHora, horasContrato);
             novoFuncionario.adicionarContrato(contratoHora);
        }
        
        System.out.println("\n");
        System.out.println("Entre com o mes e ano para calcular o salario ( MM/YYYY )");
        String mesAno = entrarDados.next();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));
        
        System.out.println("Nome: " + novoFuncionario.getNome());
        System.out.println("Departamento: " + novoFuncionario.getDepartamento().getNome());
        System.out.println("Rendimentos em " + mesAno + " : " + String.format("%.2f", novoFuncionario.verRendimentos(ano, mes)));
        entrarDados.close();
    }
}
