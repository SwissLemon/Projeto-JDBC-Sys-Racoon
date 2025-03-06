package model;

import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ValidacoesCliente {
	public static boolean validarNome(String nome, JLabel codigo_lbl) {
        if (nome.isEmpty() || nome.length() < 4) {
        	codigo_lbl.setForeground(new Color(204, 0, 0));
            return false;
        } else {
        	codigo_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }
	
	public static boolean validarEmail(String email, JLabel email_lbl) { //falta esse cara aqui ainda
        if (email.isEmpty() || email.length() < 4) {
        	email_lbl.setForeground(new Color(204, 0, 0));
            return false;
        } else {
        	email_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }
	
	public static boolean validarSenha(String senha, JLabel senha_lbl) {
        if (senha.isEmpty() || senha.length() < 4) {
        	senha_lbl.setForeground(new Color(204, 0, 0));
            return false;
        } else {
        	senha_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }
	
	public static boolean validarStatus(String status, JLabel status_lbl) {
		int statusInt = Integer.parseInt(status);
        if (statusInt < 0 || statusInt > 1) {
        	status_lbl.setForeground(new Color(204, 0, 0));
            return false;        	
        } else {
        	status_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }

	public static boolean validarDataNascimento(String dia, String mes, String ano, JLabel dataNascimento_lbl) {
	    if (dia.isEmpty() || mes.isEmpty() || ano.isEmpty()) {
	    	dataNascimento_lbl.setForeground(Color.RED);
	        return false;
	    }

	    try {
	        int diaInt = Integer.parseInt(dia);
	        int mesInt = Integer.parseInt(mes);
	        int anoInt = Integer.parseInt(ano);

	        if (diaInt < 1 || diaInt > 31 || mesInt < 1 || mesInt > 12 || anoInt < 1900 || anoInt > 2100) {
	        	dataNascimento_lbl.setForeground(Color.RED);
	            return false;
	        }

	        dataNascimento_lbl.setForeground(Color.GREEN);

		    String dataNascimento = dia + "-" + mes + "-" + ano;
	        return true;
	    } catch (NumberFormatException e) {
	    	dataNascimento_lbl.setForeground(Color.RED);
	        return false;
	    }
	}
	
    public static boolean validarFoto(JFileChooser fileChooser, JLabel imagem_lbl) {
        if (fileChooser.getSelectedFile() != null) {
        	imagem_lbl.setForeground(new Color(0, 204, 0));
            return true;
        } else {
            return true;
        }
    }
}
