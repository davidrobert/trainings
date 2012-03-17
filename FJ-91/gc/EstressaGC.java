import java.util.ArrayList;

public class EstressaGC {
	public static void main(String[] args) {
		
		// faz o trabalho pesado com a memoria
		for (int i = 0; i < 500; i++) {
			ArrayList<MeuObjeto> lista = new ArrayList<MeuObjeto>();
			
			for (int j = 0; j < 800000; j++) {
				lista.add(new MeuObjeto());
			}
		}
		
	}
}
class MeuObjeto {}