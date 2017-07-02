

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VulnerableClass {
  private Scanner console;
  private String scan;
  private String scan2;
  private boolean fazerOperacao;
  static final int CHARACTERS_READ_BY_INTERATION = 100;

  public VulnerableClass() {
    scan = "";
    fazerOperacao = true;
  }

  public String getScan1() {
    return scan;
  }

  public String getScan2() {
    return scan2;
  }

  public boolean getBool() {
    return fazerOperacao;
  }
  /**
  * Javadoc para passar no criterio.
  */
  public void vulnerableMethod(String filename) throws IOException {
    while (fazerOperacao) {
      console = new Scanner(System.in);
      System.out.println("Digite a operacao desejada para realizar no arquiv"
          + "<R para ler um arquivo, W para escrever em um arquivo>? ");
      scan = console.nextLine();
      if (scan.equals("R")) {
        fazerOperacao = false;
        BufferedReader br = null;
        FileReader fr = null;
        try {
          fr = new FileReader(filename);
          br = new BufferedReader(fr, CHARACTERS_READ_BY_INTERATION);
          char [] cbuf = new char [CHARACTERS_READ_BY_INTERATION];
          while (br.read(cbuf, 0, CHARACTERS_READ_BY_INTERATION) != -1) {
            String linha = String.valueOf(cbuf);
            System.out.print(linha);
          }
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
          throw e;
        }
      } else if (scan.equals("W")) {
        fazerOperacao = false;
        BufferedWriter buffWrite;
        try {
          buffWrite = new BufferedWriter(new FileWriter(filename));
          String linha = "";
          System.out.println("Escreva algo: ");
          linha = console.nextLine();
          buffWrite.append(linha + "\n");
          buffWrite.close();
        } catch (IOException e) {
          e.printStackTrace();
          throw e;
        }
      } else {
        fazerOperacao = false;
        System.out.println("Digito inválido");
      }
      System.out.println("Outra operação?<digite S para sim, outro simbolo para não>");
      scan2 = console.nextLine();
      if (scan2.equals("S")) {
        fazerOperacao = true;
      }
    }
  }
}
