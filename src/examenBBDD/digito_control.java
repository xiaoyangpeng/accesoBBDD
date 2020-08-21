package examenBBDD;
import javax.swing.JLabel;

public class digito_control {

	static public boolean estabien(String DNI) {
		String cabeza=DNI.substring(0,1);
		String ultimo=DNI.substring(8,9);
		if(cabeza.equals("X")||cabeza.equals("Y")||cabeza.equals("Z")||numero(cabeza)){
			if(ultimo.equals(comprobar(pasaranumero(DNI)%23))) {
				System.out.println(comprobar(pasaranumero(DNI)%23));
				return true;
			}
			else return false;
		}
		return false;
	}

	static public int pasaranumero(String DNI) {
		String primero=empcabeza(DNI);

			if(primero.equals("0")) {
				DNI="0"+DNI.substring(1,8);
			}
			if(primero.equals("1")) {
				DNI="1"+DNI.substring(1,8);
			}
			if(primero.equals("2")) {
				DNI="2"+DNI.substring(1,8);
			}
			
			return Integer.parseInt(DNI.substring(0,8));
	}

	
	static public String empcabeza(String DNI) {//en caso de NIE solo permite encabezar por X Y Z
		String op=DNI.substring(0,1);
		if(op.equals("X"))  return "0";
		else if(op.equals("Y")) return "1";
		else if(op.equals("Z")) return "2";
		else return DNI;
		
	}
	
	static boolean numero(String valor) {

			char cada=valor.charAt(0);
			if((cada<48)||(cada>57)) return false;// en  ASCII 0=48  9=57
		return true;
	}
	
static 	String comprobar(int resto){// comprobar el resto de la division 
	
		if(resto==0) return "T";
		if(resto==1) return "R";
		if(resto==2) return "W";
		if(resto==3) return "A";
		if(resto==4) return "G";
		if(resto==5) return "M";
		if(resto==6) return "Y";
		if(resto==7) return "F";
		if(resto==8) return "P";
		if(resto==9) return "D";
		if(resto==10) return "X";
		if(resto==11) return "B";
		if(resto==12) return "N";
		if(resto==13) return "J";
		if(resto==14) return "Z";
		if(resto==15) return "S";
		if(resto==16) return "Q";
		if(resto==17) return "V";
		if(resto==18) return "H";
		if(resto==19) return "L";
		if(resto==20) return "C";
		if(resto==21) return "K";
		if(resto==22) return "E";
		return "mal";
	}

}
