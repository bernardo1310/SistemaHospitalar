package entrada;

import dados.Paciente;
import dados.Medico;
import dados.Sala;
import service.GerenciamentoMedico;
import service.GerenciamentoSala;
import service.Triagem;
import service.AtendimentoMedico;
import estrutura.Fila;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Fila filaPacientes = new Fila(10); 
        GerenciamentoMedico gerenciamentoMedico = new GerenciamentoMedico();
        GerenciamentoSala gerenciamentoSala = new GerenciamentoSala();
        Triagem triagem = new Triagem(filaPacientes);
        AtendimentoMedico atendimentoMedico = new AtendimentoMedico(filaPacientes);

        // Criação de médicos
        Medico medico1 = new Medico(1, "Dr. Larissa", "Médico geral");
        medico1.setDisponivel(true);
        Medico medico2 = new Medico(2, "Dra. Ana Paula", "Cardiologista");
        medico2.setDisponivel(true);

        // Criação de salas
        Sala sala1 = new Sala(1, "Sala 1", 5);
        Sala sala2 = new Sala(2, "Sala 2", 3);

        // Cadastro de médicos e salas
        gerenciamentoMedico.cadastrarMedico(medico1);
        gerenciamentoMedico.cadastrarMedico(medico2);
        gerenciamentoSala.cadastrarSala(sala1);
        gerenciamentoSala.cadastrarSala(sala2);

        // gerador de números aleatórios
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Atender paciente");
            System.out.println("2. Ver médicos cadastrados");
            System.out.println("3. Ver salas cadastradas");
            System.out.println("4. Ver fila de pacientes");
            System.out.println("5. Adicionar pacientes aleatórios");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Informe o ID do médico: ");
                    int medicoId = Integer.parseInt(scanner.nextLine());
                    Medico medico = gerenciamentoMedico.consultarMedico(medicoId);

                    if (medico != null && medico.isDisponivel()) {
                        System.out.print("Informe o ID da sala: ");
                        int salaId = Integer.parseInt(scanner.nextLine());
                        Sala sala = gerenciamentoSala.consultarSala(salaId);

                        if (sala != null && sala.isDisponivel()) {
                            atendimentoMedico.atenderPaciente(medico, sala);
                            sala.adicionarPaciente();
                            System.out.println("Paciente atendido com sucesso!");
                        } else {
                            System.out.println("Sala não disponível ou não encontrada.");
                        }
                    } else {
                        System.out.println("Médico não disponível ou não encontrado.");
                    }
                    break;
                case 2:
                    gerenciamentoMedico.listarMedicos();
                    break;
                case 3:
                    gerenciamentoSala.listarSalas();
                    break;
                case 4:
                    System.out.println("\nFila de Pacientes:");
                    filaPacientes.exibirFila();
                    break;
                case 5:
                    int pacientesChegaram = 3;
                    for (int i = 0; i < pacientesChegaram; i++) {
                        String nomePaciente = "Paciente " + (filaPacientes.getTamanho() + 1);
                        String sintomas = "Sintomas aleatórios";
                        int prioridade = random.nextInt(5) + 1; 

                        Paciente paciente = new Paciente(filaPacientes.getTamanho() + 1, nomePaciente, sintomas, prioridade);
                        triagem.realizarTriagem(paciente);  // insere  paciente na fila

                        // System.out.println("Paciente " + paciente.getNome() + " adicionado à fila com prioridade " + prioridade + ".");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            try {
                Thread.sleep(1000);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
