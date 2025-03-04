package model;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ValidacoesProduto{
	
    public static boolean validarCodigo(String codigo, JLabel codigo_lbl) {
        if (codigo.isEmpty() || codigo.length() < 4) {
        	codigo_lbl.setForeground(new Color(204, 0, 0));
            return false;
        } else {
        	codigo_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }
    
    public static boolean validarNome(String nome, JLabel codigo_lbl) {
        if (nome.isEmpty() || nome.length() < 4) {
        	codigo_lbl.setForeground(new Color(204, 0, 0));
            return false;
        } else {
        	codigo_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }
    
    public static boolean validarDescricao(String descricao, JLabel descricao_lbl) {
        if (!descricao.isEmpty()) {
        	descricao_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }else {
        	return true;
        }
    }
    
    public static boolean validarDeposito(String deposito, JLabel deposito_lbl) {
        if (deposito.isEmpty() || deposito.length() < 4) {
        	deposito_lbl.setForeground(new Color(204, 0, 0));
            return false;
        } else {
        	deposito_lbl.setForeground(new Color(0, 204, 0));
            return true;
        }
    }
    
    public static boolean validarImagem(JFileChooser fileChooser, JLabel imagem_lbl) {
        if (fileChooser.getSelectedFile() != null) {
        	imagem_lbl.setForeground(new Color(0, 204, 0));
            return true;
        } else {
            return true;
        }
    }
    
    public static boolean validarDeposito(JComboBox<String> deposito_box, JLabel imagem_lbl) {
        if (deposito_box.getSelectedItem().toString()!= null) {
        	imagem_lbl.setForeground(new Color(0, 204, 0));
            return true;
        } else {
            return true;
        }
    }
    
    public static boolean validarCusto(String custo, JLabel custo_lbl) {
    	if(!custo.isEmpty() || custo.length() < 0) {    	
	    	Double custoDouble = Double.parseDouble(custo);
	        if (custoDouble < 0) {
	        	custo_lbl.setForeground(new Color(204, 0, 0));
	            return false;
	        } else {
	        	custo_lbl.setForeground(new Color(0, 204, 0));
	            return true;
	        }
		}else {
        	custo_lbl.setForeground(new Color(204, 0, 0));
			return false;
		}
    }
    
    public static boolean validarValor(String valor, JLabel valor_lbl) {
    	if(!valor.isEmpty() || valor.length() < 0) {
	    	Double valorDouble = Double.parseDouble(valor);
	        if (valorDouble < 0) {
	        	valor_lbl.setForeground(new Color(204, 0, 0));
	            return false;
	        } else {
	        	valor_lbl.setForeground(new Color(0, 204, 0));
	            return true;
	        }
    	}else {
    		valor_lbl.setForeground(new Color(204, 0, 0));
    		return false;
    	}
    }
    
}