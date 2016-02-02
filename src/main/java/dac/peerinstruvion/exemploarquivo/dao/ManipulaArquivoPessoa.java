/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dac.peerinstruvion.exemploarquivo.dao;

import dac.peerinstruvion.exemploarquivo.pojo.Pessoa;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Junior
 */
public class ManipulaArquivoPessoa {

    private final File arquivo;

    public ManipulaArquivoPessoa() {
        arquivo = new File("cadastropessoas.doc");
        createFile();
    }

    public void addPessoa(Pessoa novo) {
        List<Pessoa> listaPessoas = desSerializaObjecto();
        listaPessoas.add(novo);
        serializaObject(listaPessoas);
    }

    public List<Pessoa> getTodasPessoasCadastrados() {
        List<Pessoa> listaDePessoas = desSerializaObjecto();
        return listaDePessoas;
    }

    private List<Pessoa> desSerializaObjecto() {
        List<Pessoa> listaPessoas = null;
        try {
            FileInputStream stIn = new FileInputStream(arquivo);
            ObjectInputStream in = new ObjectInputStream(stIn);
            listaPessoas = (List<Pessoa>) in.readObject();
            in.close();
            stIn.close();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro!\nDetalhes:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (EOFException e) {
            listaPessoas = new ArrayList<Pessoa>();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro!\nDetalhes:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return listaPessoas;
    }

    private void serializaObject(List<Pessoa> listaDePessoas) {
        try {
            FileOutputStream stOut = new FileOutputStream(arquivo);
            ObjectOutputStream out = new ObjectOutputStream(stOut);
            out.writeObject(listaDePessoas);
            out.close();
            stOut.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro!\nDetalhes:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createFile() {
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo de Funcionarios: " + e.getMessage());
            }
        }
    }
}
