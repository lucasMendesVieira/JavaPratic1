package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Funcionario {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String role;
    private double salary;
    private Date admissionDate;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public Funcionario(String name, String role, Double salary, String admissionDate) {
        try {
            this.name = name;
            this.role = role;
            this.salary = salary;
            this.admissionDate = sdf.parse(admissionDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final void novoCadastro(List<Funcionario> func) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do funcionario: ");
        String name = sc.nextLine();
        System.out.print("Digite a função do funcionario: ");
        String role = sc.nextLine();
        System.out.print("Digite o salario do funcionario: ");
        var salary = sc.nextDouble();
        System.out.print("Digite a data de admissão do funcionario (dd/MM/yyyy): ");
        sc.nextLine();
        String admissionDate = sc.nextLine();
        func.add(new Funcionario(name, role, salary, admissionDate));
    }
    public void reajuste(){
        this.salary+=salary*0.07;
    }

    public void bonus(){
        Date local = new Date();
        LocalDate localDateAdmission = admissionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateNow = local.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long diferencaAnos = ChronoUnit.YEARS.between(localDateAdmission,localDateNow);
        if(diferencaAnos>=3){
            this.salary+=salary*0.10;
        }  else if(diferencaAnos>=1 && diferencaAnos<=2){
            this.salary+=salary*0.10;
        } else {
            System.out.println("Sem bonus anual, pois não completou 1 ano");
        }
    }

        @Override
        public String toString () {
            return "name= " + name +
                    ", role= " + role +
                    ", salary= " + salary +
                    ", admissionDate= " + sdf.format(admissionDate);
        }
}