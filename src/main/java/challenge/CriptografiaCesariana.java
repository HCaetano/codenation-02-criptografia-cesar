package challenge;

public class CriptografiaCesariana implements Criptografia {

    final private Integer DESLOCAMENTO = 3;
    final private Integer DESCONTO_PARA_FIM_DO_ALFABETO = 26;
    private StringBuilder mensagemFinal = new StringBuilder();
    private char caracterDaIteracao;

    @Override
    public String criptografar(String texto) {
        verificaVazio(texto);
        String mensagemMinusculas = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            caracterDaIteracao = mensagemMinusculas.charAt(i);

            if (Character.isLetter(caracterDaIteracao)) {
                caracterDaIteracao += DESLOCAMENTO;
                if (caracterDaIteracao > 'z') {
                    caracterDaIteracao -= DESCONTO_PARA_FIM_DO_ALFABETO;
                }
            }

            mensagemFinal.append(caracterDaIteracao);
        }

        return String.valueOf(mensagemFinal);
    }

    @Override
    public String descriptografar(String texto) {
        verificaVazio(texto);
        String mensagemMinusculas = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            caracterDaIteracao = mensagemMinusculas.charAt(i);

            if (Character.isLetter(caracterDaIteracao)) {
                caracterDaIteracao -= DESLOCAMENTO;
                if (caracterDaIteracao < 'a') {
                    caracterDaIteracao += DESCONTO_PARA_FIM_DO_ALFABETO;
                }
            }

            mensagemFinal.append(caracterDaIteracao);
        }

        return String.valueOf(mensagemFinal);
    }

    private void verificaVazio(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
