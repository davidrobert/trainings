import java.util.ArrayList;
import java.util.Scanner;

public class EstressaGCComPausa {
	public static void main(String[] args) {
		
		// travando o fim do programa
		System.out.println("Executando! Agora abra no VisualVM e volte aqui pra liberar a execucao");
		new Scanner(System.in).nextLine();
		System.out.println("Comecando a manipular a memoria...");
		
		
		// calcula o tempo de execução
		long init = System.nanoTime();
		
		// faz o trabalho pesado com a memoria
		for (int i = 0; i < 500; i++) {
			ArrayList<MeuObjeto> lista = new ArrayList<MeuObjeto>();
			
			for (int j = 0; j < 800000; j++) {
				lista.add(new MeuObjeto());
			}
		}
		
		// mostra tempo gasto
		System.out.printf("Fim! Tempo gasto na execucao: %,dns\n",
				System.nanoTime() - init);
	}
}
