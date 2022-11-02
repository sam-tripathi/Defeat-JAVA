/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Usuário
 */
public class Savegame {
            
        File arquivo = new File("SnakeInfo.bin");
        FileInputStream dadosin = null;
               
      public Savegame(){
          try{              
          
      dadosin = new FileInputStream(arquivo);
      
      }catch(Exception e){
            System.out.println(e);
        }
      }
        
     public void Salvar(String nome, String highscore){
        try{
                              
            FileOutputStream dados = new FileOutputStream(arquivo);
           
            PrintStream salvar = new PrintStream(dados);
                        
            salvar.println(nome);
            salvar.println(highscore); 
                 
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
     
         
     public int getHighscore(){
        try{
             
             FileInputStream dados = new FileInputStream(arquivo);
             InputStreamReader stream = new InputStreamReader(dados);
             
             BufferedReader leitor = new BufferedReader(stream);
                      leitor.readLine();
             return Integer.valueOf(leitor.readLine());              
                           
         }catch(Exception e){
            System.out.println("erro ao carregar registro");
            return 0;
        }
     }
    public String getNome(){
         try{
             
             FileInputStream dados = new FileInputStream(arquivo);
             InputStreamReader stream = new InputStreamReader(dados);
             
             BufferedReader leitor = new BufferedReader(stream);
                      
             return (leitor.readLine());              
                           
         }catch(Exception e){
            System.out.println("erro ao carregar registro");
            return "0";
        }
    }
     
           
     
}

