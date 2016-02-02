/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dac.peerinstruvion.exemploarquivo.teste;

import dac.peerinstruvion.exemploarquivo.dao.ManipulaArquivoPessoa;
import dac.peerinstruvion.exemploarquivo.pojo.Pessoa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Junior
 */
public class App {

    public static void main(String[] args) {
        ManipulaArquivoPessoa map = new ManipulaArquivoPessoa();
        map.addPessoa(new Pessoa(1, "Antonio"));
        map.addPessoa(new Pessoa(2, "Rafael"));
        List<Pessoa> lp = map.getTodasPessoasCadastrados();
        for(Pessoa p : lp){
            System.out.println(p);
        }
    }

}
