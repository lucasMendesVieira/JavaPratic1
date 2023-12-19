import entities.Funcionario;
import entities.UI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Funcionario> func = new ArrayList<>();
        String opcao = "";
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        UI menu = new UI();

        while (!opcao.equalsIgnoreCase("sair")){
            System.out.println(menu.opcoes());
            opcao = sc.nextLine();
            if (opcao.equalsIgnoreCase("sair")){
                break;
            }else if(opcao.equalsIgnoreCase("novo cadastro")){
                Funcionario.novoCadastro(func);
            } else if (opcao.equalsIgnoreCase("listar funcionarios")) {
                for(Funcionario funcionario : func){
                    System.out.println(funcionario.toString());
                }
            } else if (opcao.equalsIgnoreCase("reajustar salario")) {
                for(Funcionario funcionario : func){
                    funcionario.reajuste();
                    System.out.println("Valor reajustado do(a): "+funcionario.getName()+", "+funcionario.getSalary()+" Reais");
                }

            } else if (opcao.equalsIgnoreCase("calcular bonus")) {
                for(Funcionario funcionario : func){
                    funcionario.bonus();
                    System.out.println("Valor com bonus do(a): "+funcionario.getName()+", "+funcionario.getSalary());
                }
                
            }

        }
    }
}