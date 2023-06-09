package Personas;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Set;

public class FichaTecnica {
    private Set<String> antecedentesTecnicos;
    private LinkedList<String> motivosDeConsulta;
    private LinkedList<String> inspecciones;
    private LinkedList<String> diagnostico;
    private LinkedList<String> resolucion;

    private Cliente cliente;
    public Set<String> getAntecedentesTecnicos() {
        return antecedentesTecnicos;
    }

    public LinkedList<String> getMotivosDeConsulta() {
        return motivosDeConsulta;
    }

    public LinkedList<String> getInspecciones() {
        return inspecciones;
    }

    public LinkedList<String> getDiagnostico() {
        return diagnostico;
    }

    public LinkedList<String> getResolucion() {
        return resolucion;
    }

    public FichaTecnica(Cliente cliente){
        this.motivosDeConsulta = new LinkedList<>();
        this.inspecciones = new LinkedList<>();
        this.diagnostico = new LinkedList<>();
        this.resolucion = new LinkedList<>();
        this.cliente = cliente;
    }
    public FichaTecnica appendAntecedentes(String antecedentes) {
        if (antecedentes != null && !antecedentes.isEmpty()) {
            this.antecedentesTecnicos.add(antecedentes);
        }
        return this;
    }
    public FichaTecnica appendMotivoDeConsulta(String motivoDeConsulta) {
        if (motivoDeConsulta != null && !motivoDeConsulta.isEmpty()) {
            this.motivosDeConsulta.add(motivoDeConsulta);
        }
        return this;
    }
    public FichaTecnica appendInspeccion(String inspeccion) {
        if (inspeccion != null && !inspeccion.isEmpty()) {
            this.inspecciones.add(inspeccion);
        }
        return this;
    }
    public FichaTecnica appendDiagnostico(String diagnostico) {
        if (diagnostico != null && !diagnostico.isEmpty()) {
            this.diagnostico.add(diagnostico);
        }
        return this;
    }
    public FichaTecnica appendResolucion(String resolucion) {
        if (resolucion != null && !resolucion.isEmpty()) {
            this.resolucion.add(resolucion);
        }
        return this;
    }

    public FichaTecnica appendFicha(FichaTecnica fichaTecnica){
        if(fichaTecnica != null){
            this.antecedentesTecnicos.addAll(fichaTecnica.antecedentesTecnicos);
            this.motivosDeConsulta.addAll(fichaTecnica.motivosDeConsulta);
            this.inspecciones.addAll(fichaTecnica.inspecciones);
            this.diagnostico.addAll(fichaTecnica.diagnostico);
            this.resolucion.addAll(fichaTecnica.resolucion);
        }
        return this;
    }

    public String toStringAntecedentes(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String antecedente : this.antecedentesTecnicos){
            stringBuilder.append(antecedente).append("\n\n");
        }
        return stringBuilder.toString();
    }
    public String toStringMotivosDeConsulta(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String motivoDeConsulta : this.motivosDeConsulta){
            stringBuilder.append(motivoDeConsulta).append("\n\n");
        }
        return stringBuilder.toString();
    }
    public String toStringInspecciones(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String inspeccion : this.inspecciones){
            stringBuilder.append(inspeccion).append("\n\n");
        }
        return stringBuilder.toString();
    }
    public String toStringDiagnostico(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String diagnostico : this.diagnostico){
            stringBuilder.append(diagnostico).append("\n\n");
        }
        return stringBuilder.toString();
    }
    public String toStringResolucion(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String resolucion : this.resolucion){
            stringBuilder.append(resolucion).append("\n\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Ficha tecnica:\n\n\n" +
                "Antecedentes:\n\n" +
                toStringAntecedentes() +
                "\n\nMotivos de Consulta:\n\n" +
                toStringMotivosDeConsulta() +
                "\n\nInspecciones:\n\n" +
                toStringInspecciones() +
                "\n\nDiagnósticos:\n\n" +
                toStringDiagnostico() +
                "\n\nTratamiento:\n\n" +
                toStringResolucion();
    }

    public void setAntecedentesFamiliaresInJTextArea(JTextArea textArea) {
        StringBuilder antecedentes = new StringBuilder();
        for (String antecedente : this.antecedentesTecnicos) {
            antecedentes.append(antecedente).append("\n");
        }
        textArea.setText(antecedentes.toString());
    }
    public void setMotivosDeConsultaInJTextArea(JTextArea textArea) {
        StringBuilder motivos = new StringBuilder();
        for (String motivo : this.motivosDeConsulta) {
            motivos.append(motivo).append("\n");
        }
        textArea.setText(motivos.toString());
    }
    public void setInspeccionesInJTextArea(JTextArea textArea) {
        StringBuilder inspecciones = new StringBuilder();
        for (String inspeccion : this.inspecciones) {
            inspecciones.append(inspeccion).append("\n");
        }
        textArea.setText(inspecciones.toString());
    }
    public void setDiagnosticoInJTextArea(JTextArea textArea) {
        StringBuilder diagnosticos = new StringBuilder();
        for (String diagnostico : this.diagnostico) {
            diagnosticos.append(diagnostico).append("\n");
        }
        textArea.setText(diagnosticos.toString());
    }
    public void setResolucionInJTextArea(JTextArea textArea) {
        StringBuilder resoluciones = new StringBuilder();
        for (String resolucion : this.resolucion) {
            resoluciones.append(resolucion).append("\n");
        }
        textArea.setText(resoluciones.toString());
    }
    public String getElementMotivosDeConsulta(int index) {
        return this.motivosDeConsulta.get(index);
    }
    public String getElementInspecciones(int index) {
        return this.inspecciones.get(index);
    }
    public String getElementDiagnostico(int index) {
        return this.diagnostico.get(index);
    }
    public String getElementResolucion(int index) {
        return this.resolucion.get(index);
    }
}
