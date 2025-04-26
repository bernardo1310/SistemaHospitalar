package service;

import dados.Medico;
import java.util.HashMap;
import java.util.Map;

public class RelatorioAtendimento {
    private Map<Medico, Integer> atendimentosPorMedico;

    public RelatorioAtendimento() {
        this.atendimentosPorMedico = new HashMap<>();
    }

    public void registrarAtendimento(Medico medico) {
        atendimentosPorMedico.put(medico, atendimentosPorMedico.getOrDefault(medico, 0) + 1);
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Atendimentos Médicos:");
        for (Map.Entry<Medico, Integer> entry : atendimentosPorMedico.entrySet()) {
            System.out.println("Médico " + entry.getKey().getNome() + " atendeu " + entry.getValue() + " pacientes.");
        }
    }
}
