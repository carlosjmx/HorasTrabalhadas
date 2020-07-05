package entidades;

import entidades.enums.NivelTrabalhador;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private Double salarioBase;
    
    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();
    
    public Trabalhador(){}

    public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }
       
    public void adicionarContrato(ContratoPorHora contrato){
        contratos.add(contrato);
    }
    
    public void removerContrato(ContratoPorHora contrato){
        contratos.remove(contrato);
    }
    
    public double verRendimentos(int ano, int mes){
        double soma = salarioBase;
        Calendar periodo = Calendar.getInstance();
        
        for(ContratoPorHora contrato : contratos){
            periodo.setTime(contrato.getData());
            int contrato_ano = periodo.get(Calendar.YEAR);
            int contrato_mes = 1 + periodo.get(Calendar.MONTH);
            
            if(contrato_mes == mes && contrato_ano == ano){
                soma += contrato.valorTotal();
            }
        }
        return soma;
    }
}